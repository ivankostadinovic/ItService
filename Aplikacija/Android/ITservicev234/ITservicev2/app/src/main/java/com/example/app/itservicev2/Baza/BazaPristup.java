package com.example.app.itservicev2.Baza;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Korisnik;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.KlijentPaket.KlijentActivity;
import com.example.app.itservicev2.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class BazaPristup {

    private DatabaseReference db;
    private FirebaseAuth auth;
    private Activity activity;
    private Korisnik korisnik;
    private FirebaseUser user;
    private ValueEventListener problemListener;

    public BazaPristup(){
        db = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        korisnik=null;
    }
    public BazaPristup(Activity a) {
        db = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        activity = a;
        korisnik=null;
        problemListener=new  ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Problem p=dataSnapshot.getValue(Problem.class);

                ((KlijentActivity)activity).pregledProblemaFragment.ucitajProblemPromenu(p);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

    }

    public void ucitajProbleme(String Uid)
    {
        db.child("Porblemi-korisnika").child(Uid).addListenerForSingleValueEvent(new ValueEventListener() {// za ucitvaanje svih problema
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Problem> listaP=new ArrayList<>();
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    listaP.add(ds.getValue(Problem.class));
                }
                ((KlijentActivity)activity).instanceFragment(listaP);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void postaviProblemListener(List<Problem> listaP)// za promenu kada serviser prihvati problem
    {


             for(Problem p:listaP)
             {
                 db.child("Porblemi-korisnika").child(p.getIdKlijenta()).child(p.getProblemId()).addValueEventListener(problemListener);
             }

    }
    public void upisiProblem(Problem problem)
    {
         String kljuc= db.child("Problemi-neprihvaceni").push().getKey();
        problem.setProblemId(kljuc);
        db.child("Porblemi-korisnika").child(problem.getIdKlijenta()).child(kljuc).setValue(problem);
        db.child("Problemi-neprihvaceni").child(kljuc).setValue(problem);

        db.child("Porblemi-korisnika").child(problem.getIdKlijenta()).child(kljuc).addValueEventListener(problemListener);

    }

    public void proveriLogin(String email, String pass) {

        final OnCompleteListener<AuthResult> a = new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(activity, "Uspesno!", Toast.LENGTH_SHORT).show();
                    FirebaseUser user=task.getResult().getUser();
                    ucitajKorisnika(user.getUid());

                } else {
                    Toast.makeText(activity, "Pogresan Email/Password!", Toast.LENGTH_SHORT).show();
                    ((BaseActivity)activity).hideProgress();
                }
            }
        };
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(activity, a);
    }



    public void ucitajKorisnika(final String Uid)
    {
        db.child("Korisnici").child(Uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.child("IsServiser").getValue(Boolean.class)) {
                    Klijent k=dataSnapshot.getValue(Klijent.class);
                    ((LoginActivity)activity).pokreniKlijentActivity(k);
                }
                else
                {
                    korisnik=dataSnapshot.getValue(Korisnik.class);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void upisiKlijenta(final Klijent k) {
        final OnCompleteListener<AuthResult> a = new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser u = task.getResult().getUser();
                    db.child("Klijenti").child(u.getUid()).setValue(k);
                    db.child("Korisnici").child(u.getUid()).setValue(k);
                    db.child("Korisnici").child(u.getUid()).child("IsServiser").setValue(false);
                    db.child("Korisnici").child(u.getUid()).child("Id").setValue(u.getUid());

                    Toast.makeText(activity, "Registrovanje uspesno!.", Toast.LENGTH_LONG).show();
                    activity.finish();
                } else {
                    Toast.makeText(activity, "Vec postoji korisnik sa tim Emailom", Toast.LENGTH_LONG).show();
                }

            }
        };
        auth.createUserWithEmailAndPassword(k.getEmail(), k.getPassword()).addOnCompleteListener(activity, a);




    }
    public void posaljiEmailZaPromenu(String email)
    {
        auth.setLanguageCode("sr");
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(activity, "Email je poslat na vasu adresu.", Toast.LENGTH_LONG).show();
                            activity.finish();
                        }
                        else
                        {
                            Toast.makeText(activity, "Nepostojeci Email!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    public void promeniKorisnika(Klijent k,String ime)
    {
        if(ime.equals("Klijent")) {
            db.child("Klijenti").child(k.getId()).setValue( k);
            db.child("Korisnici").child(k.getId()).setValue(k);
            db.child("Korisnici").child(k.getId()).child("IsServiser").setValue(false);
        }

        else {
            //db.child("Serviseri").child(k.getId()).setValue((Serviser) k);
            //db.child("Korisnici").child(k.getId()).setValue((Serviser) k);
        }


    }
    public void promeniEmail(final String email)
    {
         user=auth.getCurrentUser();
        user.updateEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            db.child("Korisnici").child(user.getUid()).child("email").setValue(email);
                            Toast.makeText(activity, "Email uspesno promenjen.", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(activity, "Email nije  promenjen.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
    public void promeniPassword(final String pass)
    {

        user=auth.getCurrentUser();
        user.updatePassword(pass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            db.child("Korisnici").child(user.getUid()).child("password").setValue(pass);
                            Toast.makeText(activity, "Šifra uspesno promenjena.", Toast.LENGTH_LONG).show();

                        }
                        else
                        {
                            Toast.makeText(activity, "Šifra nije  promenjena.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
