package exceptions;

public class UserAlreadyExists extends Exception{
    public UserAlreadyExists() {
        super("Erabiltzailea existitzen da, beste bat erabili!");

    }
}
