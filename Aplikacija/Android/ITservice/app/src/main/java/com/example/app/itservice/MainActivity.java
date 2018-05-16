package com.example.app.itservice;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.itservice.Baza.*;
import com.example.app.itservice.KlijentPackage.KlijentActivity;

import java.sql.SQLException;

import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;

public class MainActivity extends AppCompatActivity
{
    private Korisnik korisnik;
    private BazaKonekcija bazaKonekcija;
    private  String username;
    private  String password;
    private  EditText editUsername;
    private EditText editPassword;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPassword=(EditText) findViewById(R.id.editPassword);
        editUsername=(EditText) findViewById(R.id.editUsername);
        bazaKonekcija=new BazaKonekcija();
        activity=this;
         Intent i=new Intent(activity,DBCServis.class);
        startService(i);





    }
    public void onClickForget(View view)
    {
        Intent i= new Intent(this,ForgetPasswordActivity.class);
        startActivity(i);

    }

    public void onClickCreateAccount(View view)
    {
        Intent i= new Intent(this,CreateAccountActivity.class);
        startActivity(i);
    }

    public void onClickLogin(View view)
    {


        username=editUsername.getText().toString();
        password=editPassword.getText().toString();
    /*
        final Handler h=new Handler()
        {
            public void handleMessage(Message msg)  {
                if(korisnik==null)
                {
                    Toast.makeText(getApplicationContext(),"Pogresan username/password,unesite ponovo!", Toast.LENGTH_SHORT).show();
                }
                else
                {

                        Intent i=new Intent(activity,KlijentActivity.class);
                        startActivity(i);

                }

            }
        };
        */

        Runnable r= new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    //korisnik = bazaKonekcija.proveriLogin(username,password);
                    try
                    {
                        DBChangeNotification demo=new DBChangeNotification();
                        demo.run();
                    }
                    catch(SQLException mainSQLException )
                    {
                        mainSQLException.printStackTrace();
                    }


                }

            }

        };
        Thread t= new Thread(r);
        t.start();

    }
}
