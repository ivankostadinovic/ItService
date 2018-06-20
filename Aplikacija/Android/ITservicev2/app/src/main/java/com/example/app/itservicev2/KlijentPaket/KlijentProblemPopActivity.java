package com.example.app.itservicev2.KlijentPaket;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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

    private TextView txtNaziv,txtStatus,txtOpis,txtServiser,txtNacinResavanja,txtObavestenje,txtNacinResavanjaLabel,txtServiserLabel,txtObavestenjeLabel,txtOceniLabel;

    private Button btnZvezda;
    private Problem problem;
    private BazaPristup bazaPristup;

    private Serviser serviser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_klijent_problem);
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
        txtOceniLabel=(TextView)findViewById(R.id.txtOceniLabel);

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
            btnZvezda.setVisibility(View.GONE);
            procHeight=0.4;
            problemUKomponente();

        }
        else {
            procHeight =0.75;
           bazaPristup.ucitajServisera(problem.getIdServisera());
        }
        if(problem.getStatus().equals("Resen")) {
            btnZvezda.setVisibility(View.VISIBLE);
            txtOceniLabel.setVisibility(View.VISIBLE);
        }
        else {
            btnZvezda.setVisibility(View.INVISIBLE);
            txtOceniLabel.setVisibility(View.INVISIBLE);
        }
        if(problem.isStar()) {
            txtOceniLabel.setText("Zvezdica dodeljna");
            btnZvezda.setBackground(getDrawable(R.drawable.icon_star_active));
            btnZvezda.setClickable(false);
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
        String nacinResavanja=splitujString(problem.getNacinResavanja());
        txtNacinResavanja.setText(nacinResavanja);
        txtObavestenje.setText(problem.getObavestenje());
        txtNaziv.setText(problem.getNaziv());
        txtOpis.setText(problem.getOpis());
        txtOpis.setMovementMethod(new ScrollingMovementMethod());
        txtStatus.setText(problem.getStatus());

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnZvezda)
        {
            if(!isNetworkAvailable())
                return;
            serviser.setStarsCount(serviser.getStarsCount()+1);
            problem.setStar(true);
            txtOceniLabel.setText("Zvezdica dodeljna");
            bazaPristup.registrujStar(serviser,problem);
             btnZvezda.setBackground(getDrawable(R.drawable.icon_star_active));
            btnZvezda.setClickable(false);
        }
    }
}
