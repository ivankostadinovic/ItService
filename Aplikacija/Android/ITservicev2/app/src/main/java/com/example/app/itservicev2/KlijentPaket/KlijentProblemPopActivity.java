package com.example.app.itservicev2.KlijentPaket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.R;

public class KlijentProblemPopActivity extends BaseActivity {

    private TextView txtNaziv,txtStatus,txtOpis,txtServiser,txtNacinResavanja,txtObavestenje,txtNacinResavanjaLabel,txtServiserLabel,txtObavestenjeLabel;

    private Problem problem;
    private BazaPristup bazaPristup;
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


        problem=(Problem)getIntent().getSerializableExtra("Problem");
        bazaPristup=new BazaPristup(this);
        double procHeight;
        if(problem.getStatus().equals("Neprihvacen")) {

            txtNacinResavanjaLabel.setVisibility(View.INVISIBLE);
            txtServiser.setVisibility(View.INVISIBLE);
            txtServiserLabel.setVisibility(View.INVISIBLE);
            txtObavestenjeLabel.setVisibility(View.INVISIBLE);
            txtObavestenje.setVisibility(View.INVISIBLE);
            txtNacinResavanjaLabel.setVisibility(View.INVISIBLE);
            procHeight=0.5;

        }
        else {
            procHeight =0.6;
          // bazaPristup.ucitajServisera();
        }
        problemUKomponente();
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

}
