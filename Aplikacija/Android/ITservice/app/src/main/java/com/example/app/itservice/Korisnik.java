package com.example.app.itservice;

import java.io.Serializable;

/**
 * Created by MocaPC on 5/7/2018.
 */

public  class Korisnik implements Serializable{

    private int ID;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private String email;
    private String brojtelefona;
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public int getID() {
        return ID;
    }

    public String getBrojtelefona() {
        return brojtelefona;
    }

    public void setBrojtelefona(String brojtelefona) {
        this.brojtelefona = brojtelefona;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
