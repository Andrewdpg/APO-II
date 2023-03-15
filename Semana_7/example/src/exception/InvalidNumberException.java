package exception;

public class InvalidNumberException extends RuntimeException{
    public InvalidNumberException(){
        super("El numero de telefono no es valido");
    }
}