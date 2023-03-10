package Semana_6.unicentro_parking.exception;

public class FullCapacityReachedException extends Exception{
    
    public FullCapacityReachedException(){
        super("Se ha alcanzado la capacidad maxima");
    }

    public FullCapacityReachedException(String of){
        super("Se ha alcanzado la capacidad maxima de " + of);
    }
}
