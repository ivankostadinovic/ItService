package com.example.app.itservicev2;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;

public class ChangeEmailActivity extends BaseActivity {


    private EditText editChangeEmail,editPassEmail;
    private Button btnChangeEmail;
    private BazaPristup bazaPristup;
    private String passProvera;
    private boolean isServiser;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_change_email);

        inicijalizujKomponente();

        btnChangeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promeniEmailOnClick();
            }
        });


    }

    public void promeniEmailOnClick()
    {
        if (!isNetworkAvailable())
            return;

        if(!validacijaEmaila(editChangeEmail))
            return;

        bazaPristup.autentifikacija(editPassEmail.getText().toString(),null,isServiser,true,editChangeEmail.getText().toString());



    }

    public boolean potvrdaPass()
    {


        if(!passProvera.equals(editPassEmail.getText().toString()))
            return  false;
        return true;
    }

    @Override
    public void inicijalizujKomponente() {
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.4));

        bazaPristup=new BazaPristup(this);

        passProvera=  getIntent().getStringExtra("Pass");
        isServiser=getIntent().getBooleanExtra("isServiser",true);


        editPassEmail=(EditText) findViewById(R.id.editPassEmail);
        editChangeEmail=(EditText) findViewById(R.id.editChangeEmail);

        btnChangeEmail=(Button) findViewById(R.id.btnSubmitChangeEmail);

    }
    public void zavrsiActivity()
    {
        Intent i=new Intent();
        i.putExtra("NoviEmail",editChangeEmail.getText().toString());
        setResult(RESULT_OK,i);
        finish();

    }
}
