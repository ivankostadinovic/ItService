package com.example.app.itservicev2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccountActivity extends BaseActivity {


    private EditText editEmail, editPass, editConfirmPass, editIme, editPrezime, editTelefon, editNazivFirme;
    private Button btnRegistruj;
    private CheckBox cbxFirma;

    private FirebaseAuth auth;
    private DatabaseReference db;
    private BazaPristup bazaPristup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        inicijalizujKomponente();
        cbxFirma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    editNazivFirme.setVisibility(View.VISIBLE);
                else {
                    editNazivFirme.setVisibility(View.INVISIBLE);
                    editNazivFirme.setText("");
                }
            }
        });
        btnRegistruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validacija())
                    return;
                Klijent k = new Klijent(editIme.getText().toString(), editPrezime.getText().toString(), editEmail.getText().toString(),
                        editPass.getText().toString(), editTelefon.getText().toString(), editNazivFirme.getText().toString());
                bazaPristup.upisiKlijenta(k);
            }
        });


    }

    public boolean validacija()
    {
        boolean flag =true;
        if(!validacijaEmaila(editEmail))
            flag=false;
        if(!praznoProvera(new EditText[]{editIme, editPrezime, editTelefon}))
            flag=false;
        if(!passProvera(editPass,editConfirmPass))
            flag=false;
        return flag;

    }


    @Override
    public void inicijalizujKomponente() {

        editEmail = (EditText) findViewById(R.id.editEmailCreate);
        editPass = (EditText) findViewById(R.id.editPassword);
        editConfirmPass = (EditText) findViewById(R.id.editConfirmPassword);
        editIme = (EditText) findViewById(R.id.editIme);
        editPrezime = (EditText) findViewById(R.id.editPrezime);
        editTelefon = (EditText) findViewById(R.id.editTelefon);
        editNazivFirme = (EditText) findViewById(R.id.editNazivFirme);
        cbxFirma=(CheckBox) findViewById(R.id.checkFirma);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance().getReference();
        bazaPristup = new BazaPristup(this);

        btnRegistruj = (Button) findViewById(R.id.btnCreateAccount);

    }




}