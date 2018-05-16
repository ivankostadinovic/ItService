package com.example.app.itservice;



import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Problem {


    private int id;
    private String opis;
    private String resen;
    private String adresa;
    private String tipProblema;
    private String nacinResavanja;
    private Timestamp vremeDolaska;
    private Timestamp vremePolaska;

    public void setId(int id) {
        this.id = id;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setResen(String resen) {
        this.resen = resen;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTipProblema(String tipProblema) {
        this.tipProblema = tipProblema;
    }

    public void setNacinResavanja(String nacinResavanja) {
        this.nacinResavanja = nacinResavanja;
    }

    public void setVremeDolaska(Timestamp vremeDolaska) {
        this.vremeDolaska = vremeDolaska;
    }

    public void setVremePolaska(Timestamp vremePolaska) {
        this.vremePolaska = vremePolaska;
    }

    public int getId() {
        return id;
    }

    public String getOpis() {
        return opis;
    }

    public String getResen() {
        return resen;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTipProblema() {
        return tipProblema;
    }

    public String getNacinResavanja() {
        return nacinResavanja;
    }

    public Timestamp getVremeDolaska() {
        return vremeDolaska;
    }

    public Timestamp getVremePolaska() {
        return vremePolaska;
    }
}
