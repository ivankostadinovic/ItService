package com.example.app.itservicev2.KlijentPaket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.KorisnikProfilFragment;
import com.example.app.itservicev2.LoginActivity;
import com.example.app.itservicev2.Custom.OnSwipeTouchListener;
import com.example.app.itservicev2.PregledProblemaFragment;
import com.example.app.itservicev2.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class KlijentActivity extends BaseActivity {


    private Klijent klijent;
    public KorisnikProfilFragment profilFragment;
    public PrijaviProblemFragment prijaviProblemFragment;
    public PregledProblemaFragment pregledProblemaFragment;
    private BazaPristup bazaPristup;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profil:

                    otvoriFragment(profilFragment);
                    return true;
                case R.id.navigation_prijavi_problem:

                    otvoriFragment(prijaviProblemFragment);

                    return true;
                case R.id.navigation_pregled_problema:
                    otvoriFragment(pregledProblemaFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klijent);
        inicijalizujKomponente();


    }

    public void otvoriFragment(Fragment fragment)
    {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentConteiner, fragment);
            transaction.addToBackStack(null);
            transaction.commit();


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.odjaviSe) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void instanceFragment(List<Problem> listaP)// poziva se preko bazaPristup objekta startuje fragment
    {
        pregledProblemaFragment=PregledProblemaFragment.newInstance(klijent,listaP,false);
        bazaPristup.postaviKlijentProblemListener(klijent.getId());
        otvoriFragment(pregledProblemaFragment);

        hideProgress();
    }

    @Override
    public void inicijalizujKomponente() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        klijent =(Klijent)getIntent().getExtras().getSerializable("Klijent");

        bazaPristup=new BazaPristup(this);

        prijaviProblemFragment=PrijaviProblemFragment.newInstance(klijent);

        profilFragment= KorisnikProfilFragment.newInstance(klijent);

        showProgress();

        bazaPristup.ucitajProbleme(klijent.getId(),false);// ucitavanje liste iz baze i startovanje fragmenta



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.botom_navigation_klijent);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        View view =findViewById(R.id.klijent_activity);
        view.setOnTouchListener(new OnSwipeTouchListener(this){

            public void onSwipeLeft() {

                if( profilFragment.isVisible()) {
                    otvoriFragment(prijaviProblemFragment);
                    return;
                }
                if(prijaviProblemFragment.isVisible())
                {
                    otvoriFragment(pregledProblemaFragment);
                    return;
                }
            }
            public void onSwipeRight() {
                if(prijaviProblemFragment.isVisible())
                {
                    otvoriFragment(profilFragment);
                    return;
                }
            }
        });

    }
}
