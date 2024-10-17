package exceptions;

public class UserNotFound extends Exception{
    public UserNotFound() {
        super("Ez da erabiltzailea existitzen");
    }
}
