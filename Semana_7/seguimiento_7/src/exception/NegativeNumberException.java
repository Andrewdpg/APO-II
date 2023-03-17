package exception;

public class NegativeNumberException extends RuntimeException{
    
    public NegativeNumberException(){
        super("No se pueden usar numeros negativos");
    }
}
