package Semana_6.billeteraVirtual.exceptions;

public class NegativeAmmountException extends Exception {

    public NegativeAmmountException(){
        super("Negative ammount detected");
    }
}
