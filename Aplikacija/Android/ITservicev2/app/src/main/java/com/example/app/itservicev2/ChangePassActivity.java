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
import com.google.firebase.auth.FirebaseAuth;

public class ChangePassActivity extends BaseActivity {

    private EditText editNewPass,editConfirmPass,editOldPass;
    private Button btnChangePass;
    private BazaPristup bazaPristup;
    private String passProvera;
    private boolean isServiser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_change_pass);

        inicijalizujKomponente();



    }

    public void promeniPassOnClick()
    {
        if (!isNetworkAvailable())
            return;

        if(!passProvera(editNewPass,editConfirmPass))
            return;
        bazaPristup.autentifikacija(editOldPass.getText().toString(),editNewPass.getText().toString(),isServiser,false,null);





    }
    public void zavrsiActivity() {
        Intent i = new Intent();
        i.putExtra("NoviPass", editNewPass.getText().toString());
        setResult(RESULT_OK, i);
        finish();
    }




    @Override
    public void inicijalizujKomponente() {


        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.5)) ;

        passProvera=getIntent().getStringExtra("Pass");
        isServiser=getIntent().getBooleanExtra("isServiser",true);

        editNewPass = (EditText) findViewById(R.id.editNewPass);
        editOldPass=(EditText)findViewById(R.id.editOldPass);
        editConfirmPass = (EditText) findViewById(R.id.editChangeConfirmPass);

        bazaPristup=new BazaPristup(this);

        btnChangePass=(Button) findViewById(R.id.btnSubmitChangePass);
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promeniPassOnClick();
            }
        });

    }
}
