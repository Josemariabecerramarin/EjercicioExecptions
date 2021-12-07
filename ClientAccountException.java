package exceptions.a2;

public class ClientAccountException extends Exception {
    public static final String WRONG_DNI = "DNI incorrecte";

    public ClientAccountException(String msg) { super(msg);}
}
