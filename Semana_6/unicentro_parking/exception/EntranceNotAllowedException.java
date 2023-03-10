package Semana_6.unicentro_parking.exception;

public class EntranceNotAllowedException extends Exception {

    public EntranceNotAllowedException() {
        super("Entrada no permitida");
    }

    public EntranceNotAllowedException(String add) {
        super("Entrada no permitida. " + add);
    }
}
