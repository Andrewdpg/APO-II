package exception;

public class DuplicatedContactException extends RuntimeException{

    public DuplicatedContactException(){
        super("contacto duplicado");
    }
}
