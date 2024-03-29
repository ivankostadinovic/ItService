package com.example.app.itservicev2.Klase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

public class Korisnik implements Serializable {


    private String Id;
    private String ime;
    private String prezime;
    private String email;
    private String password;
    private int brojProblema;

    public void setBrojProblema(int brojProblema) {
        this.brojProblema = brojProblema;
    }

    public int getBrojProblema() {

        return brojProblema;
    }

    private String brojtelefona;

    public void setId(String id) {
        Id = id;
    }

    public String getId() {

        return Id;
    }

    public  Korisnik(){}
    public Korisnik(String iime,String prezime,String email,String pass,String tel,int BrojP)
    {

        this.email=email;
       this.password=pass;
        this.brojtelefona=tel;
       this. ime=ime;
        this.prezime=prezime;
        this.brojProblema=BrojP;

    }


    public String getBrojtelefona() {
        return brojtelefona;
    }

    public void setBrojtelefona(String brojtelefona) {
        this.brojtelefona = brojtelefona;
    }



    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
