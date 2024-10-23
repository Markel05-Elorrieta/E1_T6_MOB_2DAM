package objects;

import java.util.Date;

public class User
{
    private int id = -1;
    private String izena;
    private String abizenak;
    private String erabiltzailea;
    private String pasahitza;
    private Date jaiotze_data;
    private String email;
    private int telefonoa;
    private int maila;

    public User(){
    }

    public User(String izena, String abizenak, String erabiltzailea, String pasahitza, Date jaiotze_data, String email, int telefonoa) {
        this.izena = izena;
        this.abizenak = abizenak;
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
        this.jaiotze_data = jaiotze_data;
        this.email = email;
        this.telefonoa = telefonoa;
        this.maila = 0;
    }

    public User(int id, String izena, String abizenak, String erabiltzailea, String pasahitza, Date jaiotze_data, String email, int telefonoa, int maila) {
        this.id = id;
        this.izena = izena;
        this.abizenak = abizenak;
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
        this.jaiotze_data = jaiotze_data;
        this.email = email;
        this.telefonoa = telefonoa;
        this.maila = maila;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(int telefonoa) {
        this.telefonoa = telefonoa;
    }

    public int getMaila() {return maila;}

    public void setMaila(int maila) {this.maila = maila;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
