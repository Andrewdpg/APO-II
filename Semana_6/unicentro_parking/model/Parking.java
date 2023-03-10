package Semana_6.unicentro_parking.model;

import java.util.Calendar;
import java.util.Date;

import Semana_6.unicentro_parking.exception.EntranceNotAllowedException;
import Semana_6.unicentro_parking.exception.FullCapacityReachedException;

public class Parking {

    public static final int MAX_CARS = 100;
    public static final int MAX_BIKES = 200;

    public static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private DoubleLinkedList<Vehicle> cars;
    private DoubleLinkedList<Vehicle> bikes;

    public Parking() {
        cars = new DoubleLinkedList<>();
        bikes = new DoubleLinkedList<>();
    }

    public void addVehicle(Vehicle vehicle) throws FullCapacityReachedException, EntranceNotAllowedException {
        validateEntrance(vehicle);
        if (vehicle.getType() == VehicleType.CAR) {
            if (cars.getLength() >= MAX_CARS) {
                throw new FullCapacityReachedException("carros");
            }
            cars.add(vehicle);
        } else if (vehicle.getType() == VehicleType.BIKE) {
            if (bikes.getLength() >= MAX_BIKES) {
                throw new FullCapacityReachedException("motos");
            }
            bikes.add(vehicle);
        }
    }

    public void validateEntrance(Vehicle vehicle) throws EntranceNotAllowedException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if (LETTERS.substring(0, LETTERS.indexOf("N")).contains("" + vehicle.getPlate().charAt(0))) {
            if (calendar.get(Calendar.HOUR) < 7 || calendar.get(Calendar.HOUR) >= 14) {
                throw new EntranceNotAllowedException("Horario de entrada no permitido");
            }
        } else {
            if (calendar.get(Calendar.HOUR) < 14 || calendar.get(Calendar.HOUR) >= 22) {
                throw new EntranceNotAllowedException("Horario de entrada no permitido");
            }
        }

        if (vehicle.getType() == VehicleType.BIKE) {
            int num = Integer.parseInt(vehicle.getPlate().substring(3, 5));
            if (num >= 0 && num <= 49) {
                if (calendar.get(Calendar.HOUR) < 7 || calendar.get(Calendar.HOUR) >= 14) {
                    throw new EntranceNotAllowedException("Horario de entrada no permitido");
                }
            } else {
                if (calendar.get(Calendar.HOUR) < 14 || calendar.get(Calendar.HOUR) >= 22) {
                    throw new EntranceNotAllowedException("Horario de entrada no permitido");
                }
            }
        }

        if(vehicle.getOwnerID().endsWith("0") ||vehicle.getOwnerID().endsWith("1")){
            if(calendar.get(Calendar.DAY_OF_WEEK) == 2){
                throw new EntranceNotAllowedException("Dia no permitido para entrada");
            }
        }else if(vehicle.getOwnerID().endsWith("2") ||vehicle.getOwnerID().endsWith("3")){
            if(calendar.get(Calendar.DAY_OF_WEEK) == 3){
                throw new EntranceNotAllowedException("Dia no permitido para entrada");
            }   
        }else if(vehicle.getOwnerID().endsWith("4") ||vehicle.getOwnerID().endsWith("5")){
            if(calendar.get(Calendar.DAY_OF_WEEK) == 4){
                throw new EntranceNotAllowedException("Dia no permitido para entrada");
            }
        }else if(vehicle.getOwnerID().endsWith("6") ||vehicle.getOwnerID().endsWith("7")){
            if(calendar.get(Calendar.DAY_OF_WEEK) == 5){
                throw new EntranceNotAllowedException("Dia no permitido para entrada");
            }
        }else if(vehicle.getOwnerID().endsWith("8") ||vehicle.getOwnerID().endsWith("9")){
            if(calendar.get(Calendar.DAY_OF_WEEK) == 6){
                throw new EntranceNotAllowedException("Dia no permitido para entrada");
            }
        }
    }

    public DoubleLinkedList<Vehicle> getCars() {
        return cars;
    }

    public DoubleLinkedList<Vehicle> getBikes() {
        return bikes;
    }
}
