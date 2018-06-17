package com.example.app.itservicev2.ServiserPaket;

import android.app.Activity;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.Klase.Serviser;
import com.example.app.itservicev2.R;

public class ServiserNeprihvaceniPopActivity extends BaseActivity implements View.OnClickListener {

    private TextView txtKlijent,txtNaziv,txtOpis;
    private RadioGroup radioGroup;
    private BazaPristup bazaPristup;
    private Button btnPrihvatiProblem;
    private Problem problem;
    private Serviser serviser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviser_neprihvaceni_pop);
        inicijalizujKomponente();

    }

    @Override
    public void inicijalizujKomponente() {

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6)) ;
        txtKlijent=(TextView)findViewById(R.id.txtKlijent);
        txtNaziv=(TextView)findViewById(R.id.txtNaziv);
        txtOpis=(TextView)findViewById(R.id.txtOpis);


        radioGroup=(RadioGroup)findViewById(R.id.RadioGroupNacinResavanja);

        btnPrihvatiProblem=(Button)findViewById(R.id.btnPrihvatiProblem);
        btnPrihvatiProblem.setOnClickListener(this);

        bazaPristup=new BazaPristup(this  );

        problem=(Problem)getIntent().getSerializableExtra("Problem");
        serviser=(Serviser)getIntent().getSerializableExtra("Serviser");

        bazaPristup.ucitajKlijenta(problem.getIdKlijenta());


    }
    public void popuniKomponente(Klijent klijent)
    {
        txtKlijent.setText(klijent.getIme()+" "+klijent.getPrezime());
        txtNaziv.setText(problem.getNaziv());
        txtOpis.setText(problem.getOpis());
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnPrihvatiProblem)
        {
            if(!radioValidacija())
                return;
            problem.setIdServisera(serviser.getId());
            problem.setStatus("Prihvacen");
            bazaPristup.prihvatiProblem(problem);
            finish();


        }

    }
    public boolean radioValidacija() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Morate odabrati nacin resavanja problema!", Toast.LENGTH_LONG).show();
            return false;
        } else {
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.radioDonosenje:
                    problem.setNacinResavanja("Donosenje u servis");
                    problem.setObavestenje("Trebate doneti uredjaj u servis radi daljeg resavanja  Adresa je: ...");
                    break;
                case R.id.radioRemote:
                    problem.setNacinResavanja("Remote pristup");
                    problem.setObavestenje("Problem ce se resiti remote pristupom. Serviser ce vas pozvati uskoro radi daljeg dogovora!");
                    break;
                case R.id.radioTelefon:
                    problem.setNacinResavanja("Telefonom");
                    problem.setObavestenje("Problem ce se resiti telefonom. Serviser ce vas pozvati uskoro!");

                    break;
                case R.id.radioTeren:
                    problem.setNacinResavanja("Izlazak na teren");
                    problem.setObavestenje("Serviser ce uskoro doci na vasu adresu");
                    break;
            }
            return true;
        }
    }


}
