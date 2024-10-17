package exceptions;

public class ErrorUserNotFound extends Exception{
    public ErrorUserNotFound() {
        super("Ez da erabiltzailea existitzen");
    }
}
