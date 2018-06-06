package com.example.app.itservicev2.ServiserPaket;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.Klase.Serviser;
import com.example.app.itservicev2.PregledProblemaFragment;
import com.example.app.itservicev2.KorisnikProfilFragment;
import com.example.app.itservicev2.LoginActivity;
import com.example.app.itservicev2.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class ServiserActivity extends BaseActivity {


    private Serviser serviser;
    private BazaPristup bazaPristup;
    public KorisnikProfilFragment profilFragment;
    public PregledProblemaFragment pregledProblemaFragment;
    public PregledNeprihvacenihProbFragment pregledNeprihvacenihProbFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profil:
                   otvoriFragment(profilFragment);
                    return true;
                case R.id.navigation_prijavljeni_problemi:
                    otvoriFragment(pregledNeprihvacenihProbFragment);
                    return true;
                case R.id.navigation_pregled_problema:
                    //if(pregledProblemaFragment.listaProblema==null)
                        showProgress();
                    otvoriFragment(pregledProblemaFragment);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviser);
        inicijalizujKomponente();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }


    public void otvoriFragment(Fragment fragment)
    {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragmentConteiner, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

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
    public void instanceFragment(List<Problem>listaP)
    {
         pregledNeprihvacenihProbFragment=pregledNeprihvacenihProbFragment.newInstance(serviser,listaP);
        otvoriFragment(pregledNeprihvacenihProbFragment);

        bazaPristup.postaviNeprihvaceniProblemListener();
        hideProgress();

    }

    @Override
    public void inicijalizujKomponente() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.botom_navigation_serviser);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        serviser =(Serviser) getIntent().getExtras().getSerializable("Serviser");

        bazaPristup=new BazaPristup(this);


        profilFragment= KorisnikProfilFragment.newInstance(serviser);
        pregledProblemaFragment=PregledProblemaFragment.newInstance(serviser,null,true);

        bazaPristup.ucitajNeprihvaceneProbleme(serviser.getId());

        bazaPristup.postaviServiserProblemListener(serviser.getId());
        showProgress();



       // otvoriFragment(profilFragment);



    }
}
