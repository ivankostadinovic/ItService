package com.example.app.itservicev2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Custom.RecyclerViewOnSwipe;
import com.example.app.itservicev2.Klase.Korisnik;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.KlijentPaket.KlijentActivity;
import com.example.app.itservicev2.KlijentPaket.KlijentProblemAdapter;
import com.example.app.itservicev2.ServiserPaket.ServiserActivity;
import com.example.app.itservicev2.ServiserPaket.ServiserProblemAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PregledProblemaFragment extends Fragment {




    public List<Problem> listaProblema;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Korisnik korisnik;
    private boolean isServiser;
    private ProgressDialog progressDialog;

    public BazaPristup bazaPristup;


    public PregledProblemaFragment() {

    }
    public void showProgress()
    {
        if(progressDialog==null)
        {
            progressDialog=new ProgressDialog(getContext());
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




    public static PregledProblemaFragment newInstance(Korisnik k,boolean isServiser) {
        PregledProblemaFragment fragment = new PregledProblemaFragment();
        Bundle args = new Bundle();
        args.putSerializable("isServiser",isServiser);
        args.putSerializable("Korisnik",k);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            korisnik=(Korisnik)getArguments().getSerializable("Korisnik");
            isServiser=(Boolean)getArguments().getSerializable("isServiser");
        }
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_pregled_problema, container, false);


            incijalizujKomponente(view);


            return view;
    }

    public void incijalizujKomponente(View view)
    {
        if(bazaPristup==null)
            bazaPristup=new BazaPristup(getActivity());

       recyclerView=(RecyclerView)view.findViewById(R.id.recylcerView);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        recyclerView.addOnItemTouchListener(new RecyclerViewOnSwipe(getActivity(),
                recyclerView,
                new RecyclerViewOnSwipe.OnTouchActionListener() {
                    @Override
                    public void onLeftSwipe(View view, int position) {
                    }
                    @Override
                    public void onRightSwipe(View view, int position) {

                        if(isServiser)
                        {
                            ((ServiserActivity)getActivity()).otvoriFragment(((ServiserActivity)getActivity()).pregledNeprihvacenihProbFragment,false);
                            ((ServiserActivity)getActivity()).navigation.setSelectedItemId(R.id.navigation_neprihvaceni_problemi);//ovo treba da se promeni
                        }
                        else {
                            ((KlijentActivity) getActivity()).otvoriFragment(((KlijentActivity) getActivity()).prijaviProblemFragment,false);
                            ((KlijentActivity) getActivity()).navigation.setSelectedItemId(R.id.navigation_prijavi_problem);
                        }
                    }
                    @Override
                    public void onClick(View view, int position) {

                    }
                }));

        if(listaProblema==null) {// za prvo ucitavanje liste problema
            bazaPristup.ucitajProbleme(korisnik.getId(), isServiser);

            if(isServiser)
                bazaPristup.postaviServiserProblemListener(korisnik.getId());
            else
                bazaPristup.postaviKlijentProblemListener(korisnik.getId());
        }
        else
            loadProbleme(listaProblema);




    }

    public void dodajProblem(Problem p)
    {
        if(listaProblema==null)
            return;
        listaProblema.add(p);
    }


    public void ucitajProblemPromenu(Problem problem)
    {
        if(listaProblema!=null) {
          for(int i=0;i<listaProblema.size();i++)
              if(listaProblema.get(i).getProblemId().equals(problem.getProblemId()))
                  listaProblema.set(i,problem);
            loadProbleme(listaProblema);
        }
    }

    public void loadProbleme(List<Problem>listaP)
    {

        listaProblema=listaP;

        if(isServiser)
        {
            adapter=new ServiserProblemAdapter(listaProblema,getActivity());
            ((ServiserActivity)getActivity()).hideProgress();

        }
        else {
            adapter = new KlijentProblemAdapter(listaProblema, getActivity());
            ((KlijentActivity)getActivity()).hideProgress();
        }
        if(recyclerView!=null)
            recyclerView.setAdapter(adapter);

    }




}
