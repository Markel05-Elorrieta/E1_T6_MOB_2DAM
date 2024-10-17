package com.example.e1_t6_mob_2dam;

import java.util.Date;

public class User
{
    private String izena;
    private String abizenak;
    private String erabiltzailea;
    private String pasahitza;
    private Date jaiotze_data;
    private int telefonoa;

    public User(String izena, String abizenak, String erabiltzailea, String pasahitza, Date jaiotze_data, int telefonoa) {
        this.izena = izena;
        this.abizenak = abizenak;
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
        this.jaiotze_data = jaiotze_data;
        this.telefonoa = telefonoa;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getAbizenak() {
        return abizenak;
    }

    public void setAbizenak(String abizenak) {
        this.abizenak = abizenak;
    }

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public Date getJaiotze_data() {
        return jaiotze_data;
    }

    public void setJaiotze_data(Date jaiotze_data) {
        this.jaiotze_data = jaiotze_data;
    }

    public int getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(int telefonoa) {
        this.telefonoa = telefonoa;
    }
}
