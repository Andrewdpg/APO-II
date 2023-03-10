package Semana_6.unicentro_parking.exception;

public class BadPlateFormat extends Exception{

    public BadPlateFormat(){
        super("El formato de la placa no es correcto");
    }

    public BadPlateFormat(String add){
        super("El formato de la placa no es correcto. " + add);
    }
}
