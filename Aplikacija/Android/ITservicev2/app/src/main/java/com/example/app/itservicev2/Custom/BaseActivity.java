package com.example.app.itservicev2.Custom;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public abstract class BaseActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;

    public void showProgress()
    {
        if(progressDialog==null)
        {
            progressDialog=new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Ucitavanje");

        }
        progressDialog.show();
    }

    public void hideProgress()
    {
        if(progressDialog!=null&&progressDialog.isShowing())
            progressDialog.dismiss();
    }

    public boolean praznoProvera(EditText[] editTexts) {
        boolean flag = true;
        for (int i = 0; i < editTexts.length; i++) {
            if (editTexts[i].getText().toString().isEmpty()) {
                editTexts[i].setError("Polje ne sme biti prazno!");
                flag = false;
            }
        }
        return flag;

    }

    public abstract void inicijalizujKomponente();


    public boolean passProvera(EditText editPass,EditText editConfirmPass) {
        if (editPass.getText().toString().length() < 6) {
            editPass.setError("Password mora biti minum 6 karaktera");
            editConfirmPass.setError("Password mora biti minum 6 karaktera");
            return false;
        }
        if (!editPass.getText().toString().equals(editConfirmPass.getText().toString())) {
            editPass.setError("Ne poklapaju se passwordi!");
            editConfirmPass.setError("Ne poklapaju se passwordi!");
            return false;
        }
        return true;
    }

    public boolean validacijaEmaila(EditText editEmail) {
        String email = editEmail.getText().toString();
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Nevalidan email!");
            return false;
        }
        return  true;
    }

}
