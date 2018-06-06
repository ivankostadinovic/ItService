package com.example.app.itservicev2.Baza;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Korisnik;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.Klase.Serviser;
import com.example.app.itservicev2.KlijentPaket.KlijentActivity;
import com.example.app.itservicev2.LoginActivity;
import com.example.app.itservicev2.ServiserPaket.ServiserActivity;
import com.example.app.itservicev2.ServiserPaket.ServiserNeprihvaceniPopActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class BazaPristup {

    private DatabaseReference db;
    private FirebaseAuth auth;
    private Activity activity;
    private Korisnik korisnik;
    private FirebaseUser user;



    public BazaPristup() {
        db = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        korisnik = null;
    }

    public BazaPristup(Activity a) {
        db = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        activity = a;
        korisnik = null;



    }
    public void prihvatiProblem(Problem problem)
    {
        db.child("Problemi-korisnika").child(problem.getIdKlijenta()).child(problem.getProblemId()).setValue(problem);
        db.child("Problemi-neprihvaceni").child(problem.getProblemId()).removeValue();
        db.child("Problemi-korisnika").child(problem.getIdServisera()).child(problem.getProblemId()).setValue(problem);
    }
    public void ucitajKlijenta(String Uid)
    {
        db.child("Klijenti").child(Uid).addListenerForSingleValueEvent(new ValueEventListener() { //ucitvaanje klijenta koji je prijvaio problem
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Klijent k=dataSnapshot.getValue(Klijent.class);
                ((ServiserNeprihvaceniPopActivity)activity).popuniKomponente(k);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void ucitajNeprihvaceneProbleme(String Uid)
    {
        db.child("Problemi-neprihvaceni").addListenerForSingleValueEvent(new ValueEventListener() {// za ucitvaanje svih liste neprihvacenih problema
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Problem> listaP = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    listaP.add(ds.getValue(Problem.class));
                }
                ((ServiserActivity)activity).instanceFragment(listaP);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void postaviServiserProblemListener(String Uid)
    {

        ChildEventListener problemListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) { // kada serviser prihvati problem da se update njegova lista problema
                Problem p = dataSnapshot.getValue(Problem.class);
                ((ServiserActivity) activity).pregledProblemaFragment.dodajProblem(p);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        db.child("Problemi-korisnika").child(Uid).addChildEventListener(problemListener);

    }
    public void postaviNeprihvaceniProblemListener()
    {

        ChildEventListener neprihvaceniProblemListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {// kada se doda novi problem da se update lsita neprihvacenih problema
                Problem p = dataSnapshot.getValue(Problem.class);
                  ((ServiserActivity) activity).pregledNeprihvacenihProbFragment.dodajProblem(p);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {// kada se prihvati problem da se obrise iz liste neprihvacenih !
                Problem p = dataSnapshot.getValue(Problem.class);
                ((ServiserActivity) activity).pregledNeprihvacenihProbFragment.ucitajProblemPromenu(p);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        db.child("Problemi-neprihvaceni").addChildEventListener(neprihvaceniProblemListener);

    }



    public void ucitajProbleme(String Uid, final boolean isServiser)
    {
       // ((ServiserActivity)activity).pregledProblemaFragment.showProgress();
        db.child("Problemi-korisnika").child(Uid).addListenerForSingleValueEvent(new ValueEventListener() {// za ucitvaanje svih problema
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Problem> listaP = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    listaP.add(ds.getValue(Problem.class));
                }
                if(isServiser)
                {

                    ((ServiserActivity)activity).pregledProblemaFragment.loadProbleme(listaP);
                   // ((ServiserActivity)activity).pregledProblemaFragment.hideProgress();


                }
                else
                    ((KlijentActivity)activity).instanceFragment(listaP);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void postaviKlijentProblemListener(String Uid)// kada serviser prihvati prijavljeni problem, da se update lsita klijentovih problema
    {
        ChildEventListener problemListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Problem p = dataSnapshot.getValue(Problem.class);
                ((KlijentActivity) activity).pregledProblemaFragment.ucitajProblemPromenu(p);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

            db.child("Problemi-korisnika").child(Uid).addChildEventListener(problemListener);

    }
    public void upisiProblem(Problem problem)                    //dodavanje novog problema
    {
        String kljuc= db.child("Problemi-neprihvaceni").push().getKey();
        problem.setProblemId(kljuc);
        db.child("Problemi-korisnika").child(problem.getIdKlijenta()).child(kljuc).setValue(problem);
        db.child("Problemi-neprihvaceni").child(kljuc).setValue(problem);



    }

    public void proveriLogin(String email, String pass) {       // autentifikacija user i passworda

        final OnCompleteListener<AuthResult> a = new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

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
        db.child("Korisnici").child(Uid).addListenerForSingleValueEvent(new ValueEventListener() {// inicijalizacija activity-a
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.child("IsServiser").getValue(Boolean.class)) {
                    Klijent k=dataSnapshot.getValue(Klijent.class);
                    ((LoginActivity)activity).pokreniKlijentActivity(k);
                }
                else
                {
                    Serviser s=dataSnapshot.getValue(Serviser.class);
                    ((LoginActivity)activity).pokreniServiserActivity(s);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void upisiKlijenta(final Klijent k) {                                // registracija klijenta
        final OnCompleteListener<AuthResult> registrovanje = new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser u = task.getResult().getUser();
                    db.child("Klijenti").child(u.getUid()).setValue(k);
                    db.child("Korisnici").child(u.getUid()).setValue(k);
                    db.child("Korisnici").child(u.getUid()).child("IsServiser").setValue(false);
                    db.child("Korisnici").child(u.getUid()).child("Id").setValue(u.getUid());
                    db.child("Klijenti").child(u.getUid()).child("Id").setValue(u.getUid());



                    Toast.makeText(activity, "Registrovanje uspesno!.", Toast.LENGTH_LONG).show();
                    activity.finish();
                } else {
                    Toast.makeText(activity, "Vec postoji korisnik sa tim Emailom", Toast.LENGTH_LONG).show();
                }

            }
        };
        auth.createUserWithEmailAndPassword(k.getEmail(), k.getPassword()).addOnCompleteListener(activity, registrovanje);




    }
    public void posaljiEmailZaPromenu(String email)                 // mail za promenu passworda
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


    public void promeniKorisnika(Korisnik k,boolean isServiser)         // promena licnih informacija korisnika
    {
        if(!isServiser) {
            db.child("Klijenti").child(k.getId()).setValue( (Klijent)k);
            db.child("Korisnici").child(k.getId()).setValue((Klijent)k);
            db.child("Korisnici").child(k.getId()).child("IsServiser").setValue(isServiser);
        }

        else {
            db.child("Serviseri").child(k.getId()).setValue((Serviser) k);
            db.child("Korisnici").child(k.getId()).setValue((Serviser) k);
            db.child("Korisnici").child(k.getId()).child("IsServiser").setValue(isServiser);
        }


    }
    public void promeniEmail(final String email, final boolean isServiser)
    {
         user=auth.getCurrentUser();
        user.updateEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            if (isServiser) {
                                db.child("Serviseri").child(user.getUid()).child("email").setValue(email);
                                db.child("Korisnici").child(user.getUid()).child("email").setValue(email);

                            } else {

                                db.child("Korisnici").child(user.getUid()).child("email").setValue(email);
                                db.child("Klijenti").child(user.getUid()).child("email").setValue(email);
                                Toast.makeText(activity, "Email uspesno promenjen.", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(activity, "Email nije  promenjen.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
    public void promeniPassword(final String pass, final boolean isServiser)
    {

        user=auth.getCurrentUser();
        user.updatePassword(pass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                        if (isServiser) {
                            db.child("Serviseri").child(user.getUid()).child("password").setValue(pass);
                            db.child("Korisnici").child(user.getUid()).child("password").setValue(pass);
                            Toast.makeText(activity, "Pass uspesno promenjen.", Toast.LENGTH_LONG).show();

                        } else {

                            db.child("Korisnici").child(user.getUid()).child("password").setValue(pass);
                            db.child("Klijenti").child(user.getUid()).child("password").setValue(pass);
                            Toast.makeText(activity, "Šifra uspesno promenjena.", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                        {
                            Toast.makeText(activity, task.getException().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
