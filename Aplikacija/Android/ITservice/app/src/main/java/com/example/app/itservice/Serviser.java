package com.example.app.itservice;

import java.util.Date;

/**
 * Created by MocaPC on 5/7/2018.
 */

public class Serviser extends Korisnik

{
    private Date datumZaposljenja;
    private String jmbg;

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
