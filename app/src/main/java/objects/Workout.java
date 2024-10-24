package objects;

import java.util.ArrayList;

public class Workout {
    private String izena;
    private int maila;
    private String videoURL;
    private int ariketaCount;

    public Workout() {
    }

    public Workout(String izena, int maila, String videoURL, int ariketaCount) {
        this.izena = izena;
        this.videoURL = videoURL;
        this.maila = maila;
        this.ariketaCount = ariketaCount;
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

    public int getMaila() {
        return maila;
    }

    public void setMaila(int maila) {
        this.maila = maila;
    }

    public int getAriketaCount() {
        return ariketaCount;
    }

    public void setAriketaCount(int ariketaCount) {
        this.ariketaCount = ariketaCount;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "izena='" + izena + '\'' +
                ", maila=" + maila +
                ", videoURL='" + videoURL + '\'' +
                ", ariketaAriketa=" + ariketaCount +
                '}';
    }
}
