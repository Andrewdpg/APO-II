package model.exception;

public class NegativeAmmountException extends Exception{
    
    public NegativeAmmountException(String message){
        super(message);
    }

    public NegativeAmmountException(){
        super();
    }
}
