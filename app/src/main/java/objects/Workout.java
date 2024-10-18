package objects;

public class Workout {
    private String izena;
    private double maila;

    public Workout(String izena, double maila) {
        this.izena = izena;
        this.maila = maila;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public double getMaila() {
        return maila;
    }

    public void setMaila(double maila) {
        this.maila = maila;
    }
}
