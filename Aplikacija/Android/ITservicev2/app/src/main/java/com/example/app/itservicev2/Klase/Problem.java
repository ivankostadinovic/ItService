package com.example.app.itservicev2.Klase;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.Date;

public class Problem implements Serializable {

    private String problemId;
    private String status;
    private String naziv;
    private String Opis;
    private String datumPrijavljivanja;
    private String datumResavajna;
    private String tipProblema;
    private String nacinResavanja;
    private String idKlijenta;
    private String idServisera;
    private String adresa;

    public void Problem()
    {

    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {

        this.problemId = problemId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getAdresa() {

        return adresa;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public void setDatumPrijavljivanja(String datumPrijavljivanja) {
        this.datumPrijavljivanja = datumPrijavljivanja;
    }

    public void setDatumResavajna(String datumResavajna) {
        this.datumResavajna = datumResavajna;
    }

    public void setTipProblema(String tipProblema) {
        this.tipProblema = tipProblema;
    }

    public void setNacinResavanja(String nacinResavanja) {
        this.nacinResavanja = nacinResavanja;
    }

    public void setIdKlijenta(String idKlijenta) {
        this.idKlijenta = idKlijenta;
    }

    public void setIdServisera(String idServisera) {
        this.idServisera = idServisera;
    }

    public String getStatus() {

        return status;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return Opis;
    }

    public String getDatumPrijavljivanja() {
        return datumPrijavljivanja;
    }

    public String getDatumResavajna() {
        return datumResavajna;
    }

    public String getTipProblema() {
        return tipProblema;
    }

    public String getNacinResavanja() {
        return nacinResavanja;
    }

    public String getIdKlijenta() {
        return idKlijenta;
    }

    public String getIdServisera() {
        return idServisera;
    }
}