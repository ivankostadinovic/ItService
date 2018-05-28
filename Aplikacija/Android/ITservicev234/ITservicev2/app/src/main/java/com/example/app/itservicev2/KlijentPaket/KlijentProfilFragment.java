package com.example.app.itservicev2.KlijentPaket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app.itservicev2.Baza.BazaPristup;
import com.example.app.itservicev2.ChangeEmailActivity;
import com.example.app.itservicev2.ChangePassActivity;
import com.example.app.itservicev2.Klase.Klijent;
import com.example.app.itservicev2.R;

import static android.app.Activity.RESULT_OK;


public class KlijentProfilFragment extends Fragment implements View.OnClickListener {


    private Klijent klijent;
    private EditText editIme,editPrezime,editEmail,editTelefon,editNazivFirme;
    private TextView txtNazivFirme,txtImeKlijenta,txtPrezimeKlijenta,txtEmailKlijenta,txtTelefonKlijenta,txtFirmaKlijenta;
    private Button btnChangePass,btnChangeEmail,btnSaveChanges,btnEdit,btnCancel;
    private BazaPristup bazaPristup;

    public KlijentProfilFragment() {

    }

    public static KlijentProfilFragment newInstance(Klijent k) {
        KlijentProfilFragment fragment = new KlijentProfilFragment();
        Bundle args = new Bundle();
        args.putSerializable("Klijent",k);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            klijent= (Klijent) getArguments().getSerializable("Klijent");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_klijent_profil, container, false);


        inicijalizujKomponente(view);

       klijentUKomponente();

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if(resultCode==RESULT_OK)
        if(requestCode==1)
        {
            klijent.setEmail(data.getStringExtra("NoviEmail"));
            klijentUKomponente();
        }
        else if(requestCode==2)
        {
            klijent.setPassword(data.getStringExtra("NoviPass"));
            klijentUKomponente();
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.btnChangeEmail:
                Intent i=new Intent(getActivity(),ChangeEmailActivity.class);
                i.putExtra("Pass",klijent.getPassword());
                startActivityForResult(i,1);
                break;
            case R.id.btnChangePass:
                Intent i1=new Intent(getActivity(),ChangePassActivity.class);
                i1.putExtra("Pass",klijent.getPassword());
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

        }

    }


    public void enableEdit(boolean flag)
    {

        EditText editi[]={editNazivFirme,editTelefon,editPrezime,editIme};
        TextView tekstovi[]={txtFirmaKlijenta,txtTelefonKlijenta,txtPrezimeKlijenta,txtImeKlijenta};
        if(flag) {
            txtNazivFirme.setVisibility(View.VISIBLE);

            btnEdit.setVisibility(View.INVISIBLE);
            btnSaveChanges.setVisibility(View.VISIBLE);
            btnCancel.setVisibility(View.VISIBLE);

            for (int i=0;i<editi.length;i++) {
                tekstovi[i].setVisibility(View.INVISIBLE);
                editi[i].setText(tekstovi[i].getText().toString());
                editi[i].setVisibility(View.VISIBLE);
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

    public void komponenteUKlijenta() {
        klijent.setIme( editIme.getText().toString());
        klijent.setPrezime( editPrezime.getText().toString());
        klijent.setBrojtelefona( editTelefon.getText().toString());
        if(!editNazivFirme.getText().toString().isEmpty())
            klijent.setNazivFirme( editNazivFirme.getText().toString());
    }
    public void klijentUKomponente(){

        txtImeKlijenta.setText(klijent.getIme());
        txtPrezimeKlijenta.setText(klijent.getPrezime());
        txtEmailKlijenta.setText(klijent.getEmail());
        txtTelefonKlijenta.setText(klijent.getBrojtelefona());
        if(!klijent.getNazivFirme().isEmpty())
        {
            txtNazivFirme.setVisibility(View.VISIBLE);
            txtFirmaKlijenta.setText(klijent.getNazivFirme());
        }
        else
            txtNazivFirme.setVisibility(View.INVISIBLE);


    }

   public void saveChangesOnClick()
    {
        if(!praznoProvera(new EditText[]{editTelefon,editPrezime,editIme}))
            return;
        komponenteUKlijenta();
        klijentUKomponente();
        enableEdit(false);
       bazaPristup.promeniKorisnika(klijent,"Klijent");
    }
    public void inicijalizujKomponente(View view)
    {
        editEmail = (EditText) view.findViewById(R.id.editEmail);
        editIme = (EditText) view.findViewById(R.id.editIme);
        editPrezime = (EditText) view.findViewById(R.id.editPrezime);
        editTelefon = (EditText) view.findViewById(R.id.editTelefon);
        editNazivFirme = (EditText) view.findViewById(R.id.editNazivFirme);

        txtNazivFirme=(TextView) view.findViewById(R.id.txtNazivFirme);

        txtEmailKlijenta=(TextView) view.findViewById(R.id.EmailKlijenta);
        txtImeKlijenta=(TextView) view.findViewById(R.id.ImeKlijenta);
        txtPrezimeKlijenta=(TextView) view.findViewById(R.id.PrezimeKlijenta);
        txtTelefonKlijenta=(TextView) view.findViewById(R.id.TelefonKlijenta);
        txtFirmaKlijenta=(TextView)view.findViewById(R.id.FirmaKlijenta);

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
