package com.example.app.itservicev2.Klase;

import java.io.Serializable;

public class Problem implements Serializable {

    private String problemId;
    private String status;
    private String naziv;
    private String Opis;
    private String datumPrijavljivanja;
    private String datumResavanja;
    private String tipProblema;
    private String nacinResavanja;
    private String idKlijenta;
    private String idServisera;
    private String adresa;
    private String obavestenje;
    private String datumStartovanja;
    private String vrstaOpreme;
    private boolean isStar;

    public void setStar(boolean star) {
        isStar = star;
    }

    public boolean isStar() {

        return isStar;
    }

    public void setDatumPrihvatanja(String datumPrihvatanja) {
        this.datumPrihvatanja = datumPrihvatanja;
    }

    private String datumPrihvatanja;

    public String getDatumPrihvatanja() {
        return datumPrihvatanja;
    }





    public void setVrstaOpreme(String vrstaOpreme) {
        this.vrstaOpreme = vrstaOpreme;
    }

    public String getVrstaOpreme() {

        return vrstaOpreme;
    }

    public String getObavestenje() {
        return obavestenje;
    }

    public void setObavestenje(String obavestenje) {

        this.obavestenje = obavestenje;
    }

    public void Problem()

    {

    }

    public void setDatumStartovanja(String datumStartovanja) {
        this.datumStartovanja = datumStartovanja;
    }

    public String getDatumStartovanja() {

        return datumStartovanja;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.problemId.equals(((Problem)obj).getProblemId()))
            return true;
        return false;
    }



    public void setProblemId(String problemId) {

        this.problemId = problemId;
    }

    public String getProblemId() {
        return problemId;
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

    public void setDatumResavanja(String datumResavanja) {
        this.datumResavanja = datumResavanja;
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

    public String getDatumResavanja() {
        return datumResavanja;
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
