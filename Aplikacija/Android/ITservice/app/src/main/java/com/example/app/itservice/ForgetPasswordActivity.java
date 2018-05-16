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
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.itservice.Baza.BazaKonekcija;
import com.example.app.itservice.ChangePasswordActivity;
import com.example.app.itservice.Klijent;
import com.example.app.itservice.Korisnik;
import com.example.app.itservice.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editToken;
    private BazaKonekcija bazaKonekcija;
    private Korisnik korisnik;
    private Activity activity;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        editEmail=(EditText)findViewById(R.id.editEmail);
        editToken=(EditText) findViewById(R.id.editToken);
        bazaKonekcija=new BazaKonekcija();
        activity=this;

    }
    public void onClickPotvrdi(View view)
    {
        final Handler h=new Handler()
        {
            public void handleMessage(Message msg)  {

                if(korisnik==null)
                {
                    Toast.makeText(getApplicationContext(),"Pogresan email/token unesite ponovo!", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent i=new Intent(activity, ChangePasswordActivity.class);
                i.putExtra("korisnik",korisnik);
                startActivity(i);

            }
        };

        Runnable r= new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    korisnik=bazaKonekcija.proveriEmailToken(editEmail.getText().toString(),editToken.getText().toString());
                }
                h.sendEmptyMessage(0);
            }

        };
        Thread t= new Thread(r);
        t.start();





    }


}
