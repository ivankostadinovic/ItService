package com.example.app.itservicev2;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;

public class ForgotPasswordActivity extends BaseActivity {


    private BazaPristup bazaPristup;

    private EditText editEmail;
    private Button btnPoslji;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        inicijalizujKomponente();

        btnPoslji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validacijaEmaila(editEmail))
                    return;
                bazaPristup.posaljiEmailZaPromenu(editEmail.getText().toString());
            }
        });


    }

    @Override
    public void inicijalizujKomponente() {
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.5)) ;


        bazaPristup=new BazaPristup(this);

        editEmail=(EditText) findViewById(R.id.editEmailReset);
        btnPoslji=(Button) findViewById(R.id.btnPosalji);

    }
}
