package com.example.app.itservicev2.ServiserPaket;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServiserProblemPopActivity extends BaseActivity implements View.OnClickListener {


    private TextView txtNaziv,txtStatus,txtOpis,txtKlijent,txtNacinResavanja;
    private Button btnStart,btnFinish,btnPromeni;

    private Problem problem;
    private BazaPristup bazaPristup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviser_problem_pop);

        inicijalizujKomponente();
    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btnStartProblem)
        {
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            String datum = df.format(c);
            problem.setStartProblema(datum);
            problem.setStatus("U izvrsenju");
            bazaPristup.startujProblem(problem);
            prikaziFinish();


        }
        else if(v.getId()==R.id.btnFinishProblem)
        {
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            String datum = df.format(c);
            problem.setDatumResavanja(datum);
            problem.setStatus("Resen");
            bazaPristup.startujProblem(problem);
           // btnPromeni.setVisibility(View.INVISIBLE);
            btnStart.setVisibility(View.INVISIBLE);
            btnFinish.setVisibility(View.INVISIBLE);

        }

    }

    @Override
    public void inicijalizujKomponente() {

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        bazaPristup=new BazaPristup(this);

        problem=(Problem)getIntent().getSerializableExtra("Problem");

        getWindow().setLayout((int)(width*.9),(int)(height*.7)) ;

        txtKlijent=(TextView)findViewById(R.id.txtKlijent);
        txtStatus=(TextView)findViewById(R.id.txtStatus);
        txtNaziv=(TextView)findViewById(R.id.txtNaziv);
        txtNacinResavanja=(TextView)findViewById(R.id.txtNacinResavanja);
        txtOpis=(TextView)findViewById(R.id.txtOpis);

        btnStart=(Button)findViewById(R.id.btnStartProblem);
        btnFinish=(Button)findViewById(R.id.btnFinishProblem);
       // btnPromeni=(Button)findViewById(R.id.btnPromeniNacin);


        if(problem.getStartProblema()!=null)
            prikaziFinish();



        bazaPristup.ucitajKlijenta(problem.getIdKlijenta());


        btnStart.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        //btnPromeni.setOnClickListener(this);

    }
    public void prikaziFinish()
    {
        btnFinish.setVisibility(View.VISIBLE);
        btnStart.setVisibility(View.INVISIBLE);
        btnPromeni.setVisibility(View.VISIBLE);
    }


    public void popuniKomponente(Klijent klijent)
    {
        txtOpis.setText(problem.getOpis());
        txtNaziv.setText(problem.getNaziv());
        txtNacinResavanja.setText(problem.getNacinResavanja());
        txtStatus.setText(problem.getStatus());
        txtKlijent.setText(klijent.getIme()+" "+klijent.getPrezime());
    }
}
