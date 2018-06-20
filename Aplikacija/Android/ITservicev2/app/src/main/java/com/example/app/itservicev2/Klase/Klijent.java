package com.example.app.itservicev2.Klase;

public class Klijent extends Korisnik {

    private String nazivFirme;

    public Klijent()
    {
    }
    public  Klijent(String i,String p,String e,String pass,String tel,String firma,int BrojP){
      super(i,p,e,pass,tel,BrojP);
        nazivFirme=firma;
    }

    public String getNazivFirme() {
        return nazivFirme;
    }

    public void setNazivFirme(String nazivFirme) {
        this.nazivFirme = nazivFirme;
    }
}
