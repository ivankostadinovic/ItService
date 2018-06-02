package com.example.app.itservicev2.KlijentPaket;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class PrijaviProblemFragment extends Fragment implements View.OnClickListener {


    private EditText editNaziv,editAdresa,editOpis;

    private RadioButton radioSoftverski,radioHardverski;


    private Button btnPrijaviProblem;

    private Klijent klijent;

    private BazaPristup bazaPristup;
    private Problem problem;
    private ProgressDialog progressDialog;





    public PrijaviProblemFragment() {

    }


    public static PrijaviProblemFragment newInstance(Klijent k) {
        PrijaviProblemFragment fragment = new PrijaviProblemFragment();
        Bundle args = new Bundle();
        args.putSerializable("Klijent",k);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                klijent = (Klijent)getArguments().getSerializable("Klijent");
            }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_prijavi_problem, container, false);

        editNaziv=(EditText)view.findViewById(R.id.editNazivProblema);
        editAdresa=(EditText)view.findViewById(R.id.editAdresa);
        editOpis=(EditText) view.findViewById(R.id.editOpis);

        radioHardverski=(RadioButton)view.findViewById(R.id.radioHardverski);
        radioSoftverski=(RadioButton)view.findViewById(R.id.radioSoftverski);

        btnPrijaviProblem=(Button)view.findViewById(R.id.btnPrijaviProblem);
        btnPrijaviProblem.setOnClickListener(this);

        bazaPristup=new BazaPristup(getActivity());
        return view;

    }



    public void clearPolja(){

        editAdresa.setText("");
        editOpis.setText("");
        editNaziv.setText("");
        radioSoftverski.setChecked(false);
        radioHardverski.setChecked(false);


    }
    public void onClick(View v) {

        if(v.getId()==R.id.btnPrijaviProblem)
            prijaviProblem();


    }
    public boolean praznoProvera()
    {
        boolean flag=true;
        if(editNaziv.getText().toString().isEmpty()) {
            editNaziv.setError("Polje ne sme biti prazno!");
            flag = false;
        }
        if(editAdresa.getText().toString().isEmpty()) {
            editAdresa.setError("Polje ne sme biti prazno!");
            flag = false;
        }
        return flag;
    }

    public void ucitajProblem()
    {
        problem=new Problem();
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String datum = df.format(c);
        problem.setDatumPrijavljivanja(datum);
        problem.setOpis(editOpis.getText().toString());
        problem.setNaziv(editNaziv.getText().toString());
        problem.setAdresa(editAdresa.getText().toString());

        if(radioHardverski.isChecked())
            problem.setTipProblema("Hardverski");
        if(radioSoftverski.isChecked())
            problem.setTipProblema("Softverski");

        problem.setStatus("Neprihvacen");
        problem.setIdKlijenta(klijent.getId());

    }

    public void prijaviProblem()
    {
        if(!praznoProvera())
            return;
        ucitajProblem();
        bazaPristup.upisiProblem(problem);
        ((KlijentActivity)getActivity()).pregledProblemaFragment.dodajProblem(problem);
        clearPolja();



    }
}
