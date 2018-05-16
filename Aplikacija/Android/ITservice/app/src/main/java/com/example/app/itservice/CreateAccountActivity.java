package com.example.app.itservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.itservice.Baza.BazaKonekcija;

public class CreateAccountActivity extends AppCompatActivity {

    private Korisnik korisnik;
    private BazaKonekcija bazaKonekcija;
    private EditText editUsername,editPassword,editIme,editPrezime,editTelefon,editConfirmPass,editToken,editEmail,editNazivFirme;
    private Activity activity;
    private  boolean upis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        editPassword=(EditText) findViewById(R.id.editPass);
        editUsername=(EditText) findViewById(R.id.editUsername);
        editIme=(EditText) findViewById(R.id.editIme);
        editPrezime=(EditText) findViewById(R.id.editPrezime);
        editEmail=(EditText) findViewById(R.id.editEmail);
        editTelefon=(EditText) findViewById(R.id.editTelefon);
        editConfirmPass=(EditText) findViewById(R.id.editConfirmPass);
        editNazivFirme=(EditText) findViewById(R.id.editNazivFirme);
        editToken=(EditText) findViewById(R.id.editToken);


        activity=this;
        korisnik=new Klijent();
        bazaKonekcija=new BazaKonekcija();

    }


    public void onClickCreate(View view)
    {

        if(!praznoProvera(new EditText[]{editTelefon,editUsername,editToken,editPrezime,editIme,editEmail,editConfirmPass,editPassword}))
            return;
        if(!passProvera())
            return;

        korisnik.setIme(editIme.getText().toString());
        korisnik.setPassword(editPassword.getText().toString());
        korisnik.setPrezime(editPrezime.getText().toString());
        korisnik.setEmail(editEmail.getText().toString());
        korisnik.setBrojtelefona(editTelefon.getText().toString());
        korisnik.setUsername(editUsername.getText().toString());
        korisnik.setToken(editToken.getText().toString());
        ((Klijent)korisnik).setNazivFirme(editNazivFirme.getText().toString());

        final Handler h=new Handler()
        {
            public void handleMessage(Message msg)  {
                Toast.makeText(getApplicationContext(),"Uspesno napravljen nalog", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(activity,MainActivity.class);
                startActivity(i);

            }
        };
        Runnable r= new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                   if(bazaKonekcija.unesiKlijenta(korisnik))
                     h.sendEmptyMessage(0);
                   else
                   {
                       Toast.makeText(getApplicationContext(),"Vec postojeci Email/Username!", Toast.LENGTH_SHORT).show();
                   }
                }
            }

        };
        Thread t= new Thread(r);

            t.start();



    }
    public boolean praznoProvera(EditText[] editTexts)
    {
        boolean flag= true;
        for(int i=0;i<editTexts.length;i++)
        {
            if(editTexts[i].getText().toString().isEmpty())
            {
                editTexts[i].setError("Polje ne sme biti prazno!");
                flag=false;
            }
        }
        return   flag;

    }
    public boolean passProvera()
    {
        if(!editPassword.getText().toString().equals(editConfirmPass.getText().toString()))
        {
            editPassword.setError("Ne poklapaju se passwordi!");
            editConfirmPass.setError("Ne poklapaju se passwordi!");
            return  false;
        }
        return  true;
    }

}
