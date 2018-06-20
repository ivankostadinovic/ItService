package com.example.app.itservicev2.ServiserPaket;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.Klase.Serviser;
import com.example.app.itservicev2.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        setContentView(R.layout.popup_serviser_neprihvaceni);
        inicijalizujKomponente();

    }

    @Override
    public void inicijalizujKomponente() {

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.65)) ;
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
        txtOpis.setText("   "+problem.getOpis());
        txtOpis.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnPrihvatiProblem)
        {
            if(!isNetworkAvailable())
                return;
            if(!radioValidacija())
                return;
            serviser.setBrojProblema(serviser.getBrojProblema()+1);
            problem.setIdServisera(serviser.getId());
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            String datum = df.format(c);
            problem.setDatumPrihvatanja(datum);
            problem.setStatus("Prihvacen");
            bazaPristup.prihvatiProblem(problem,serviser);
            finish();


        }

    }
    public boolean radioValidacija() {


            switch (radioGroup.getCheckedRadioButtonId()) {
                case -1:
                    return false;
                case R.id.radioDonosenje:
                    problem.setNacinResavanja("Donosenje u servis");
                    problem.setObavestenje("Trebate doneti uredjaj u servis %n radi daljeg resavanja %n Adresa je:Aleksandra medvedeva 3");
                    break;
                case R.id.radioRemote:
                    problem.setNacinResavanja("Remote pristup");
                    problem.setObavestenje("Problem ce se resiti remote pristupom. %nServiser ce vas pozvati uskoro radi daljeg dogovora!");
                    break;
                case R.id.radioTelefon:
                    problem.setNacinResavanja("Telefonom");
                    problem.setObavestenje("Problem ce se resiti telefonom. %nServiser ce vas uskoro pozvati!");

                    break;
                case R.id.radioTeren:
                    problem.setNacinResavanja("Izlazak na teren");
                    problem.setObavestenje("Serviser ce uskoro doci na vasu adresu");
                    break;
        }
        return true;
    }


}
