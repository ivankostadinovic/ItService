package com.example.app.itservicev2.KlijentPaket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.Klase.Serviser;
import com.example.app.itservicev2.R;

public class KlijentProblemPopActivity extends BaseActivity implements View.OnClickListener {

    private TextView txtNaziv,txtStatus,txtOpis,txtServiser,txtNacinResavanja,txtObavestenje,txtNacinResavanjaLabel,txtServiserLabel,txtObavestenjeLabel;

    private Button btnZvezda;
    private Problem problem;
    private BazaPristup bazaPristup;

    private Serviser serviser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klijent_problem_pop);
        inicijalizujKomponente();

    }

    @Override
    public void inicijalizujKomponente() {


        txtNacinResavanja=(TextView)findViewById(R.id.txtNacinResavanja) ;
        txtNaziv=(TextView)findViewById(R.id.txtNaziv) ;
        txtOpis=(TextView)findViewById(R.id.txtOpis) ;
        txtObavestenje=(TextView)findViewById(R.id.txtObavestenje) ;
        txtObavestenjeLabel=(TextView)findViewById(R.id.txtObavestenjeLabel) ;
        txtServiserLabel=(TextView)findViewById(R.id.txtServiserLabel) ;
        txtServiser=(TextView)findViewById(R.id.txtServiser) ;
        txtStatus=(TextView)findViewById(R.id.txtStatus) ;
        txtNacinResavanjaLabel=(TextView)findViewById(R.id.txtNacinResavanjaLabel) ;

        btnZvezda=(Button) findViewById(R.id.btnZvezda);
        btnZvezda.setOnClickListener(this);


        problem=(Problem)getIntent().getSerializableExtra("Problem");
        bazaPristup=new BazaPristup(this);
        double procHeight;
        if(problem.getStatus().equals("Neprihvacen")) {

            txtNacinResavanjaLabel.setVisibility(View.GONE);
            txtServiser.setVisibility(View.GONE);
            txtServiserLabel.setVisibility(View.GONE);
            txtObavestenjeLabel.setVisibility(View.GONE);
            txtObavestenje.setVisibility(View.GONE);
            txtNacinResavanjaLabel.setVisibility(View.GONE);
            procHeight=0.3;
            problemUKomponente();

        }
        else {
            procHeight =0.6;
           bazaPristup.ucitajServisera(problem.getIdServisera());
        }

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*procHeight)) ;



    }
    public void problemUKomponente()
    {
        txtNaziv.setText(problem.getNaziv());
        txtOpis.setText(problem.getOpis());
        txtStatus.setText(problem.getStatus());

    }



    public void popuniKomponente(Serviser serviser)
    {

        this.serviser=serviser;
        txtServiser.setText(serviser.getIme()+" "+serviser.getPrezime());
        txtNacinResavanja.setText(problem.getNacinResavanja());
        txtObavestenje.setText(problem.getObavestenje());
        txtNaziv.setText(problem.getNaziv());
        txtOpis.setText(problem.getOpis());
        txtStatus.setText(problem.getStatus());

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnZvezda)
        {
            serviser.setStarsCount(serviser.getStarsCount()+1);
            bazaPristup.registrujStar(serviser);
           // btnZvezda.setBackground(getDrawable());
            btnZvezda.setClickable(false);
        }
    }
}
