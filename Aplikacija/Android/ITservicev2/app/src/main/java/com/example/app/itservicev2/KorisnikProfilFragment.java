package com.example.app.itservicev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.Klase.Korisnik;
import com.example.app.itservicev2.Klase.Serviser;
import com.example.app.itservicev2.KlijentPaket.KlijentActivity;
import com.example.app.itservicev2.ServiserPaket.ServiserActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.app.Activity.RESULT_OK;


public class KorisnikProfilFragment extends Fragment implements View.OnClickListener {


    private Korisnik korisnik;
    private EditText editIme,editPrezime,editEmail,editTelefon,editNazivFirme;
    private TextView txtFirmaJmbg, txtImeKorisnika, txtPrezimeKorisnika, txtEmailKorisnika, txtTelefonKorisnika, txtFirmaJmbgKorisnika,txtVerifikacija;
    private Button btnChangePass,btnChangeEmail,btnSaveChanges,btnEdit,btnCancel;
    private BazaPristup bazaPristup;
    private boolean isServiser;

    public KorisnikProfilFragment() {

    }

    public static KorisnikProfilFragment newInstance(Korisnik k) {
        KorisnikProfilFragment fragment = new KorisnikProfilFragment();
        Bundle args = new Bundle();
        args.putSerializable("Korisnik",k);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            korisnik = (Korisnik) getArguments().getSerializable("Korisnik");
            isServiser=true;
            if(korisnik instanceof Klijent)
                isServiser=false;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_korisnik_profil, container, false);


        inicijalizujKomponente(view);

       korisnikUKomponente();

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if(resultCode==RESULT_OK)
        if(requestCode==1)
        {
            korisnik.setEmail(data.getStringExtra("NoviEmail"));
            korisnikUKomponente();
        }
        else if(requestCode==2)
        {
            korisnik.setPassword(data.getStringExtra("NoviPass"));
            korisnikUKomponente();
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {

            case R.id.btnChangeEmail:
                Intent i=new Intent(getActivity(),ChangeEmailActivity.class);
                i.putExtra("Pass", korisnik.getPassword());
                i.putExtra("isServiser",isServiser);
                startActivityForResult(i,1);
                break;
            case R.id.btnChangePass:
                Intent i1=new Intent(getActivity(),ChangePassActivity.class);
                i1.putExtra("Pass", korisnik.getPassword());
                i1.putExtra("isServiser",isServiser);
                startActivityForResult(i1,2);
                break;
            case R.id.btnSaveChanges:
                saveChangesOnClick();
                break;
            case R.id.btnPromeniPodatke:
                enableEdit(true);
                break;
            case R.id.btnCancel:
                enableEdit(false);
            case R.id.txtVerifikacija:
                verifikacijaOnCLick();


        }

    }

    public void verifikacijaOnCLick()
    {
        bazaPristup.posaljiEmailZaVerifikaciju();
    }



    public void enableEdit(boolean flag)
    {

        EditText editi[]={editNazivFirme,editTelefon,editPrezime,editIme};
        TextView tekstovi[]={txtFirmaJmbgKorisnika, txtTelefonKorisnika, txtPrezimeKorisnika, txtImeKorisnika};
        if(flag) {
            txtFirmaJmbg.setVisibility(View.VISIBLE);

            btnEdit.setVisibility(View.INVISIBLE);
            btnSaveChanges.setVisibility(View.VISIBLE);
            btnCancel.setVisibility(View.VISIBLE);

            for (int i=0;i<editi.length;i++) {
                tekstovi[i].setVisibility(View.INVISIBLE);
                editi[i].setText(tekstovi[i].getText().toString());
                editi[i].setVisibility(View.VISIBLE);
            }
            if(isServiser) {
                editNazivFirme.setVisibility(View.INVISIBLE);
                txtFirmaJmbgKorisnika.setVisibility(View.VISIBLE);

            }
        }
        else {

            btnEdit.setVisibility(View.VISIBLE);
            btnSaveChanges.setVisibility(View.INVISIBLE);
            btnCancel.setVisibility(View.INVISIBLE);


            for (int i = 0; i < editi.length; i++) {
                editi[i].setVisibility(View.INVISIBLE);
                tekstovi[i].setVisibility(View.VISIBLE);
            }

        }



    }

    public void komponenteUKorisnika() {
        korisnik.setIme(editIme.getText().toString());
        korisnik.setPrezime(editPrezime.getText().toString());
        korisnik.setBrojtelefona(editTelefon.getText().toString());
        if (!isServiser)
        {
            if (!editNazivFirme.getText().toString().isEmpty())
                ((Klijent) korisnik).setNazivFirme(editNazivFirme.getText().toString());
        }
    }
    public void korisnikUKomponente(){

        txtImeKorisnika.setText(korisnik.getIme());
        txtPrezimeKorisnika.setText(korisnik.getPrezime());
        txtEmailKorisnika.setText(korisnik.getEmail());
        txtTelefonKorisnika.setText(korisnik.getBrojtelefona());
        if(!isServiser) {
            if (!((Klijent) korisnik).getNazivFirme().isEmpty()) {
                txtFirmaJmbg.setVisibility(View.VISIBLE);
                txtFirmaJmbgKorisnika.setText(((Klijent) korisnik).getNazivFirme());
            }
            else txtFirmaJmbg.setVisibility(View.INVISIBLE);
        }
        else
        {
            txtFirmaJmbg.setVisibility(View.VISIBLE);
            txtFirmaJmbgKorisnika.setText(((Serviser)korisnik).getJmbg());

        }


    }

   public void saveChangesOnClick()
    {
        if(isServiser)
        {
            if (!((ServiserActivity) (getActivity())).isNetworkAvailable())
                return;
        }
        else
        {
            if (!((KlijentActivity) (getActivity())).isNetworkAvailable())
                return;
        }

        if(!praznoProvera(new EditText[]{editTelefon,editPrezime,editIme}))
            return;
        komponenteUKorisnika();
        korisnikUKomponente();
        enableEdit(false);
        bazaPristup.promeniKorisnika(korisnik,isServiser);

    }
    public void inicijalizujKomponente(View view)
    {
        editEmail = (EditText) view.findViewById(R.id.editEmail);
        editIme = (EditText) view.findViewById(R.id.editIme);
        editPrezime = (EditText) view.findViewById(R.id.editPrezime);
        editTelefon = (EditText) view.findViewById(R.id.editTelefon);
        editNazivFirme = (EditText) view.findViewById(R.id.editFirma);


        txtFirmaJmbg =(TextView) view.findViewById(R.id.txtFirmaJmbg);
        if(isServiser)
            txtFirmaJmbg.setText(R.string.jmbg);

        txtEmailKorisnika =(TextView) view.findViewById(R.id.EmailKorisnika);
        txtImeKorisnika =(TextView) view.findViewById(R.id.ImeKorisnika);
        txtPrezimeKorisnika =(TextView) view.findViewById(R.id.PrezimeKorisnika);
        txtTelefonKorisnika =(TextView) view.findViewById(R.id.TelefonKorisnika);
        txtFirmaJmbgKorisnika =(TextView)view.findViewById(R.id.FirmaJmbgKorisnika);
        txtVerifikacija=(TextView)view.findViewById(R.id.txtVerifikacija);

        txtVerifikacija.setOnClickListener(this);

       FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
       if(!user.isEmailVerified())
           txtVerifikacija.setVisibility(View.VISIBLE);

        btnChangeEmail = (Button) view.findViewById(R.id.btnChangeEmail);
        btnChangeEmail.setOnClickListener(this);

        btnCancel=(Button)view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);

        btnChangePass = (Button) view.findViewById(R.id.btnChangePass);
        btnChangePass.setOnClickListener(this);

        btnSaveChanges=(Button) view.findViewById(R.id.btnSaveChanges);
        btnSaveChanges.setOnClickListener(this);

        btnEdit=(Button)view.findViewById(R.id.btnPromeniPodatke);
        btnEdit.setOnClickListener(this);

        bazaPristup=new BazaPristup(getActivity());

    }

    public boolean praznoProvera(EditText[] editTexts) {
        boolean flag = true;
        for (int i = 0; i < editTexts.length; i++) {
            if (editTexts[i].getText().toString().isEmpty()) {
                editTexts[i].setError("Polje ne sme biti prazno!");
                flag = false;
            }
        }
        return flag;

    }
}
