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
import android.view.View;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Custom.BaseActivity;
import com.example.app.itservicev2.Custom.OnSwipeTouchListener;
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
    public  BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profil:
                   otvoriFragment(profilFragment,true);
                    return true;
                case R.id.navigation_neprihvaceni_problemi:
                    otvoriFragment(pregledNeprihvacenihProbFragment,true);
                    return true;
                case R.id.navigation_pregled_problema:
                    if(pregledProblemaFragment.listaProblema==null)
                        showProgress();
                    otvoriFragment(pregledProblemaFragment,true);
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

    public void otkaziListenere(){
        pregledNeprihvacenihProbFragment.bazaPristup.otkaziNeprihvaceniProblemListener();
        if(pregledProblemaFragment.bazaPristup!=null)
            pregledProblemaFragment.bazaPristup.otkaziServiserProblemListener();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        otkaziListenere();
        finish();
    }



    public void otvoriFragment(Fragment fragment,boolean flag)
    {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(flag)
        transaction.setCustomAnimations(R.animator.slide_in_left,
                R.animator.slide_out_right, 0, 0);
        else
            transaction.setCustomAnimations(R.animator.slide_in_right,
                    R.animator.slide_out_left, 0, 0);
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
            otkaziListenere();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void inicijalizujKomponente() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigation = (BottomNavigationView) findViewById(R.id.botom_navigation_serviser);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        serviser =(Serviser) getIntent().getExtras().getSerializable("Serviser");

        bazaPristup=new BazaPristup(this);


        pregledNeprihvacenihProbFragment=PregledNeprihvacenihProbFragment.newInstance(serviser);
        profilFragment= KorisnikProfilFragment.newInstance(serviser);
        pregledProblemaFragment=PregledProblemaFragment.newInstance(serviser,true);

        if(pregledNeprihvacenihProbFragment.listaProblema==null)
            showProgress();
        otvoriFragment(pregledNeprihvacenihProbFragment,true);
        navigation.setSelectedItemId(R.id.navigation_neprihvaceni_problemi);






        View view =findViewById(R.id.serviser_activity);
        view.setOnTouchListener(new OnSwipeTouchListener(this){
            public void onSwipeLeft() {

                if (profilFragment.isVisible()) {
                    otvoriFragment(pregledNeprihvacenihProbFragment,true);
                    navigation.setSelectedItemId(R.id.navigation_neprihvaceni_problemi);
                    return;
                }
            }
        });









    }
}
