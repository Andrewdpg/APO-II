package Semana_6.billeteraVirtual.exceptions;

public class OverTopException extends Exception {

    public OverTopException(){
        super("Ammount exceeds the limit");
    }
}
