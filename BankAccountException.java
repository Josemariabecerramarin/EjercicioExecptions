package exceptions.a2;

public class BankAccountException extends Exception{
    public static final String ACCOUNT_NOT_FOUND = "Compte inexistent";
    public static final String ACCOUNT_OVERDRAFT = "Compte al descobert";
    public static final String ACCOUNT_ZERO_USER = "Compte sense usuari";
    public static final String LAST_ACCOUNT = "Ultimo usuario";

    public BankAccountException(String msg) { super(msg);}
}
