package com.example.app.itservice;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.ValueIterator;
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

public class ChangePasswordActivity extends AppCompatActivity {

    private Korisnik korisnik;
    private BazaKonekcija bazaKonekcija;
    private Activity activity;
    private EditText oldPw,editPassword,editConfirmPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        korisnik=(Korisnik) getIntent().getSerializableExtra("korisnik");
         oldPw=(EditText) findViewById(R.id.editOldPassword);
         editConfirmPass=(EditText)findViewById(R.id.editChangeConfirmPass);
        editPassword=(EditText)findViewById(R.id.editChangePassword);
        oldPw.setText(korisnik.getPassword());
        bazaKonekcija=new BazaKonekcija();
        activity=this;

    }
    public void onClickSave(View view)
    {
        if(!praznoProvera(new EditText[]{oldPw}))
            return;
        if(!passProvera())
        {
            return;
        }
        korisnik.setPassword(editPassword.getText().toString());

        final Handler h=new Handler()
        {
        public void handleMessage (Message msg)  {

            Toast.makeText(getApplicationContext(),"Uspesno promenjen password!", Toast.LENGTH_LONG).show();

        Intent i=new Intent(activity, MainActivity.class);
        startActivity(i);

    }
    };

    Runnable r= new Runnable() {
        @Override
        public void run() {
            synchronized (this) {
               boolean tr= bazaKonekcija.updatePass(korisnik);
            }
            h.sendEmptyMessage(0);
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
