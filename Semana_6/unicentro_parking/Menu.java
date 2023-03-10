package Semana_6.unicentro_parking;

import Semana_6.unicentro_parking.exception.BadPlateFormat;
import Semana_6.unicentro_parking.exception.EntranceNotAllowedException;
import Semana_6.unicentro_parking.exception.FullCapacityReachedException;
import Semana_6.unicentro_parking.model.Parking;
import Semana_6.unicentro_parking.model.Vehicle;
import Semana_6.unicentro_parking.model.VehicleType;

public class Menu {

    private static final String MENU = "\n1. Registrar vehiculo\n"
            + "2. Salir\n"
            + "Opcion: ";

    private boolean isRunning;
    private int option;

    private Parking parking;

    public Menu() {
        isRunning = true;
        parking = new Parking();
    }

    private void registerVehicle() throws BadPlateFormat, FullCapacityReachedException, EntranceNotAllowedException {
        VehicleType type;
        String plate;
        String ownerID;

        type = readVehicleType();

        System.out.println("Dame la placa del vehiculo: ");
        plate = Reader.readString(Vehicle.PLATE_LENGTH, Vehicle.PLATE_LENGTH);

        System.out.println("Dame la ID del dueño: ");
        ownerID = Reader.readString();
        Vehicle vehicle = new Vehicle(type, plate, ownerID);

        parking.addVehicle(vehicle);
    }

    private VehicleType readVehicleType() {
        VehicleType type = VehicleType.CAR;
        boolean isCorrect = false;
        do {
            try {
                System.out.print("Selecciona el tipo de vehículo:\n"
                        + "1. Carro.\n"
                        + "2. Moto.\n"
                        + "Opcion: ");
                type = VehicleType.values()[Reader.readInt(-1) - 1];
                isCorrect = true;
            } catch (Exception e) {
                System.out.println("Opcion no reconocida.");
            }
        } while (!isCorrect);
        return type;
    }

    public void printMenu() {
        System.out.print(MENU);
    }

    public void executeOption() {
        switch (option) {
            case 1:
                try {
                    registerVehicle();
                    System.out.println(parking.getCars().toString());
                } catch (BadPlateFormat ex) {
                    System.out.println(ex.getLocalizedMessage());
                } catch (FullCapacityReachedException ex) {
                    System.out.println(ex.getLocalizedMessage());
                } catch(EntranceNotAllowedException ex){
                    System.out.println(ex.getLocalizedMessage());
                }
                break;
            case 2:
                isRunning = false;
                break;
            default:
                System.out.println("Opción no reconocida");
                break;
        }
    }

    public void readOption() {
        option = Reader.readInt(-1);
    }

    public boolean isRunning() {
        return isRunning;
    }

}