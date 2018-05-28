package com.example.app.itservicev2.Klase;

import java.util.Date;

public class Serviser extends  Korisnik{

    private Date datumZaposljenja;
    private String jmbg;

    public Serviser(){}

    public Serviser(String i,String p,String e,String pass,String tel,String j,Date dt){
        super(i,p,e,pass,tel);
        jmbg=j;
        datumZaposljenja=dt;
    }

    public Date getDatumZaposljenja() {
        return datumZaposljenja;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setDatumZaposljenja(Date datumZaposljenja) {
        datumZaposljenja = datumZaposljenja;
    }

    public void setJmbg(String jmbg) {
        jmbg = jmbg;
    }


}
