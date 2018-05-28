package com.example.app.itservicev2.Klase;

public class Klijent extends Korisnik {

    private String nazivFirme;

    public Klijent()
    {
    }
    public  Klijent(String i,String p,String e,String pass,String tel,String firma){
      super(i,p,e,pass,tel);
        nazivFirme=firma;
    }

    public String getNazivFirme() {
        return nazivFirme;
    }

    public void setNazivFirme(String nazivFirme) {
        this.nazivFirme = nazivFirme;
    }
}
