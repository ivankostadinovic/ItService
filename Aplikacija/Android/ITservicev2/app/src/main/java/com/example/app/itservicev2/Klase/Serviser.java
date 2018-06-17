package com.example.app.itservicev2.Klase;


public class Serviser extends  Korisnik{

    private String datumZaposljenja;
    private String jmbg;
    private int starsCount;
    public Serviser(){}

    public Serviser(String i,String p,String e,String pass,String tel,String jmb,String dt){
        super(i,p,e,pass,tel);
        jmbg=jmb;
        datumZaposljenja=dt;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
    }

    public void setDatumZaposljenja(String datumZaposljenja) {
        this.datumZaposljenja = datumZaposljenja;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getDatumZaposljenja() {
        return datumZaposljenja;
    }

    public String getJmbg() {
        return jmbg;
    }


}
