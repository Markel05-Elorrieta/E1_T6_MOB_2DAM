package objects;

public class Workout {
    private String izena;
    private String videoURL;
    private double maila;

    public Workout(String izena, String videoURL, double maila) {
        this.izena = izena;
        this.videoURL = videoURL;
        this.maila = maila;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public double getMaila() {
        return maila;
    }

    public void setMaila(double maila) {
        this.maila = maila;
    }
}
