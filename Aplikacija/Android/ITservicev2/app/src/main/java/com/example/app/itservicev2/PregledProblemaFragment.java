package com.example.app.itservicev2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.RecyclerViewOnSwipe;
import com.example.app.itservicev2.Klase.Korisnik;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.KlijentPaket.KlijentActivity;
import com.example.app.itservicev2.KlijentPaket.KlijentProblemAdapter;
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

    private BazaPristup bazaPristup;


    public PregledProblemaFragment() {

    }

    public void dodajProblem(Problem p)
    {
        if(listaProblema==null)
            listaProblema=new ArrayList<>();
        listaProblema.add(p);
    }


    public static PregledProblemaFragment newInstance(Korisnik k,List<Problem> lp ,boolean isServiser) {
        PregledProblemaFragment fragment = new PregledProblemaFragment();
        Bundle args = new Bundle();
        args.putSerializable("isServiser",isServiser);
        args.putSerializable("Korisnik",k);
        args.putSerializable("ListaProblema", (Serializable) lp);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            korisnik=(Korisnik)getArguments().getSerializable("Korisnik");
            listaProblema=(List<Problem>)getArguments().getSerializable("ListaProblema");
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

                        }
                        else
                        ((KlijentActivity)getActivity()).otvoriFragment(((KlijentActivity)getActivity()).prijaviProblemFragment);
                    }
                    @Override
                    public void onClick(View view, int position) {

                    }
                }));

        if(isServiser&&listaProblema==null)// za prvo ucitavanje liste serviserovih problema!(moze progress bar)
            bazaPristup.ucitajProbleme(korisnik.getId(),isServiser);
        else
         loadProbleme(listaProblema);



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
        }
        else
            adapter=new KlijentProblemAdapter(listaProblema,getActivity());

        if(recyclerView!=null)
        recyclerView.setAdapter(adapter);

    }




}
