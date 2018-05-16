package com.example.app.itservice.KlijentPackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.app.itservice.Baza.BazaKonekcija;
import com.example.app.itservice.ChangePasswordActivity;
import com.example.app.itservice.Problem;
import com.example.app.itservice.R;



public class ProfilFragment extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private BazaKonekcija bazaKonekcija;

    private String mParam1;
    private String mParam2;



    public ProfilFragment() {
        // Required empty public constructor
    }


    public void onClickProblem(View view)
    {


    }

    public static ProfilFragment newInstance() {
        ProfilFragment fragment = new ProfilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bazaKonekcija=new BazaKonekcija();
        View view=inflater.inflate(R.layout.fragment_profil, container, false);
       Button button = (Button) view.findViewById(R.id.btnProblem);
        button.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnProblem:
                Runnable r= new Runnable() {
                    @Override
                    public void run() {
                        synchronized (this) {
                           boolean b= bazaKonekcija.upisiProblem();
                        }
                    }

                };
                Thread t= new Thread(r);
                t.start();
                break;
        }

    }

    // TODO: Rename method, update argument and hook method into UI event





    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
