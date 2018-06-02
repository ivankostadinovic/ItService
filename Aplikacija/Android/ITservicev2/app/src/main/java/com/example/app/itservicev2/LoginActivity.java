package com.example.app.itservicev2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Korisnik;
import com.example.app.itservicev2.Klase.Serviser;
import com.example.app.itservicev2.KlijentPaket.KlijentActivity;
import com.example.app.itservicev2.ServiserPaket.ServiserActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private DatabaseReference db;
    private BazaPristup bazaPristup;

    private EditText editEmail,editPass;
    private TextView txtCreateAcc,txtForgetPass;

    private Korisnik korisnik;

    private Button btnLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicijalizujKomponente();

        txtForgetPass.setOnClickListener(this);
        txtCreateAcc.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }


    protected void onStart() {
        super.onStart();


       // user=auth.getCurrentUser();
       // if(user!=null)
       // {
       //     showProgress();
        //   editEmail.setText(user.getEmail());
        //   editPass.setText("*****");
        //    bazaPristup.ucitajKorisnika(user.getUid());
     // }
    //   hideProgress();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnLogin:
                if(!praznoProvera(new EditText[]{editEmail,editPass}))
                    return;
                showProgress();
                bazaPristup.proveriLogin(editEmail.getText().toString(),editPass.getText().toString());
                break;
            case R.id.txtCreateAccount:
                startActivity(new Intent(this,CreateAccountActivity.class));
                break;
            case R.id.txtForgotPassword:
                    startActivity(new Intent(this,ForgotPasswordActivity.class));
                break;
        }
    }

    public  void pokreniKlijentActivity(Klijent klijent)
    {

        Intent i=new Intent(this,KlijentActivity.class);
        i.putExtra("Klijent",klijent);
        startActivity(i);
        hideProgress();
        finish();

    }
    public void pokreniServiserActivity(Serviser serviser)
    {
        Intent i=new Intent(this,ServiserActivity.class);
        i.putExtra("Serviser",serviser);
        startActivity(i);
        hideProgress();
        finish();

    }

    @Override
    public void inicijalizujKomponente() {

        auth=FirebaseAuth.getInstance();
        db=FirebaseDatabase.getInstance().getReference();
        bazaPristup=new BazaPristup(this);

        editEmail=(EditText) findViewById(R.id.editEmail);
        editPass=(EditText) findViewById(R.id.editPass);

        txtCreateAcc=(TextView) findViewById(R.id.txtCreateAccount);
        txtForgetPass=(TextView) findViewById(R.id.txtForgotPassword);
        txtCreateAcc.setClickable(true);
        txtForgetPass.setClickable(true);

        btnLogin=(Button) findViewById(R.id.btnLogin);

    }
}
