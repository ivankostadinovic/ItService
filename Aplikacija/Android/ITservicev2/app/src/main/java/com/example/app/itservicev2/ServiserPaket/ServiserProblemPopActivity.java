package com.example.app.itservicev2.ServiserPaket;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServiserProblemPopActivity extends BaseActivity implements View.OnClickListener {


    private TextView txtNaziv,txtStatus,txtOpis,txtKlijent,txtNacinResavanja,txtDatumStartovanja,txtDatumZavrsavanja,txtDatumStartovanjaLabel,txtDatumZavrsavanjaLabel, txtUredjaj;
    private Button btnStart,btnFinish,btnSave,btnCancel,btnOdustani;
    private ImageButton imgEdit;
    private RadioGroup radioNacin;

    private Problem problem;
    private BazaPristup bazaPristup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_serviser_problem);

        inicijalizujKomponente();
    }


    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.btnStartProblem)
        {
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            String datum = df.format(c);
            problem.setDatumStartovanja(datum);
            problem.setStatus("U izvrsenju");
            txtStatus.setText("U izvrsenju");
            boolean flag=bazaPristup.startFinishProblem(problem);
            if(flag)
            StartVisibile();

        }
        else if(v.getId()==R.id.btnFinishProblem)
        {
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            String datum = df.format(c);
            problem.setDatumResavanja(datum);
            problem.setStatus("Resen");
            txtStatus.setText("Resen");
            boolean flag=bazaPristup.startFinishProblem(problem);
            if(flag)
            FinishVisible();

        }
        else if(v.getId()==R.id.imgEdit)
        {
            prikaziRadio(true);
        }
        else if(v.getId()==R.id.btnCancel)
        {
            prikaziRadio(false);

        }
        else if(v.getId()==R.id.btnSacuvajPromene)
        {
            sacuvajPromene();
        }
        else if(v.getId()==R.id.btnOdustani)
        {
            boolean flag = bazaPristup.odustaniProblem(problem);
            if(flag)
            finish();
        }
    }


    public void sacuvajPromene()
    {
        prikaziRadio(false);
       if( !proveraRadio())
           return;
         bazaPristup.promeniNacinResavanja(problem);
         String nacinResavanja=splitujString(problem.getNacinResavanja());
        txtNacinResavanja.setText(nacinResavanja);


    }
    public boolean proveraRadio() {
        String nacinResavanja=problem.getNacinResavanja();
        if( R.id.radioDonosenje==radioNacin.getCheckedRadioButtonId()) {
            if(!nacinResavanja.contains("Donosenje u servis")) {
                problem.setNacinResavanja(nacinResavanja+", "+"Donosenje u servis");
                problem.setObavestenje("Trebate doneti uredjaj u servis radi daljeg resavanja  Adresa je: ...");
                return true;
            }
            return false;

        }
           else if( R.id.radioRemote==radioNacin.getCheckedRadioButtonId()) {
            if(!nacinResavanja.contains("Remote pristup")) {
                problem.setNacinResavanja(nacinResavanja+", "+"Remote pristup");
                problem.setObavestenje("Problem ce se resiti remote pristupom. Serviser ce vas pozvati uskoro radi daljeg dogovora!");
                return true;
            }
                return false;
            }
       else if( R.id.radioTelefon==radioNacin.getCheckedRadioButtonId()) {
            if(!nacinResavanja.contains("Telefonom")) {
                problem.setNacinResavanja(nacinResavanja+", "+"Telefonom");
                problem.setObavestenje("Problem ce se resiti telefonom. Serviser ce vas pozvati uskoro!");
                return true;
            }
            return  false;

        }
       else if( R.id.radioTeren==radioNacin.getCheckedRadioButtonId()) {
            if(!nacinResavanja.contains("Izlazak na teren")) {
                problem.setNacinResavanja(nacinResavanja+", " +"Izlazak na teren");
                problem.setObavestenje("Serviser ce uskoro doci na vasu adresu");
                return true;
            }
            return false;
        }
        else
            {
                Toast.makeText(this,"Morati odabrati jedan od nacina!",Toast.LENGTH_LONG);
                return false;
            }
    }


    public void prikaziRadio(boolean flag) {
        if (flag) {
            imgEdit.setVisibility(View.INVISIBLE);
            txtNacinResavanja.setVisibility(View.INVISIBLE);
            radioNacin.setVisibility(View.VISIBLE);
            btnSave.setVisibility(View.VISIBLE);
            btnCancel.setVisibility(View.VISIBLE);
            btnFinish.setVisibility(View.INVISIBLE);
            txtDatumZavrsavanjaLabel.setVisibility(View.INVISIBLE);
            txtDatumZavrsavanja.setVisibility(View.INVISIBLE);
            txtDatumStartovanjaLabel.setVisibility(View.INVISIBLE);
            txtDatumStartovanja.setVisibility(View.INVISIBLE);
        }
        else
        {
            imgEdit.setVisibility(View.VISIBLE);
            txtNacinResavanja.setVisibility(View.VISIBLE);
            radioNacin.setVisibility(View.INVISIBLE);
            btnSave.setVisibility(View.INVISIBLE);
            btnCancel.setVisibility(View.INVISIBLE);


            if(problem.getDatumStartovanja()!=null)
                StartVisibile();
            if(problem.getDatumResavanja()!=null)
                FinishVisible();


        }
    }
    public void StartVisibile()
    {
        btnFinish.setVisibility(View.VISIBLE);
        txtDatumStartovanjaLabel.setVisibility(View.VISIBLE);
        txtDatumStartovanja.setVisibility(View.VISIBLE);
        txtDatumStartovanja.setText(problem.getDatumStartovanja());
        btnStart.setVisibility(View.INVISIBLE);

    }
    public void FinishVisible()
    {
        txtDatumZavrsavanjaLabel.setVisibility(View.VISIBLE);
        txtDatumZavrsavanja.setVisibility(View.VISIBLE);
        txtDatumZavrsavanja.setText(problem.getDatumResavanja());
        btnFinish.setVisibility(View.INVISIBLE);
        imgEdit.setVisibility(View.INVISIBLE);
        btnOdustani.setVisibility(View.INVISIBLE);
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
        txtDatumStartovanja=(TextView)findViewById(R.id.txtDatumStartovanja);
        txtDatumStartovanjaLabel=(TextView)findViewById(R.id.txtDatumStartovanjaLabel);
        txtDatumZavrsavanjaLabel=(TextView)findViewById(R.id.txtDatumZavrsavanjaLabel);
        txtDatumZavrsavanja=(TextView)findViewById(R.id.txtDatumZavrsavanja);
        txtUredjaj =(TextView)findViewById(R.id.txtUredjaj);

        btnStart=(Button)findViewById(R.id.btnStartProblem);
        btnFinish=(Button)findViewById(R.id.btnFinishProblem);
        btnSave=(Button)findViewById(R.id.btnSacuvajPromene);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        btnOdustani=(Button)findViewById(R.id.btnOdustani);
        imgEdit=(ImageButton)findViewById(R.id.imgEdit);

        radioNacin=(RadioGroup)findViewById(R.id.rdioGroupNacinResavanja);




        if(problem.getDatumStartovanja()!=null)
             StartVisibile();
        if(problem.getDatumResavanja()!=null)
             FinishVisible();




        bazaPristup.ucitajKlijenta(problem.getIdKlijenta());


        btnStart.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        imgEdit.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnOdustani.setOnClickListener(this);

    }



    public void popuniKomponente(Klijent klijent)
    {
        txtOpis.setText(problem.getOpis());
        txtOpis.setMovementMethod(new ScrollingMovementMethod());
        txtNaziv.setText(problem.getNaziv());
        String nacinResavanja=splitujString(problem.getNacinResavanja());
        txtNacinResavanja.setText(nacinResavanja);
        txtStatus.setText(problem.getStatus());
        txtUredjaj.setText(problem.getVrstaOpreme());
        txtKlijent.setText(klijent.getIme()+" "+klijent.getPrezime());
    }
}
