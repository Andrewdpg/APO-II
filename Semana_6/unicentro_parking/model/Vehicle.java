package Semana_6.unicentro_parking.model;

import Semana_6.unicentro_parking.exception.BadPlateFormat;

public class Vehicle {

    public static final int PLATE_LENGTH = 6;
    private VehicleType type;
    private String plate;
    private String ownerID;

    public Vehicle(VehicleType type, String plate, String ownerID) throws BadPlateFormat {
        this.type = type;
        this.plate = plate.toUpperCase();
        this.ownerID = ownerID;
        checkPlate();
    }

    public void checkPlate() throws BadPlateFormat {
        if (plate.length() != PLATE_LENGTH) {
            throw new BadPlateFormat("La longitud de la placa es erronea");
        }
        for (int i = 0; i < plate.length(); i++) {
            if (!Character.isLetter(plate.charAt(i)) && !Character.isDigit(plate.charAt(i))) {
                throw new BadPlateFormat("Contiene simbolos desconocidos");
            }
        }
        if (type == VehicleType.CAR) {
            for (int i = 0; i < PLATE_LENGTH; i++) {
                if ((!Character.isLetter(plate.charAt(i)) && i < 3)
                        || (!Character.isDigit(plate.charAt(i)) && i < 6 && i >= 3)) {
                    throw new BadPlateFormat("La placa no corresponde al tipo de vehículo");
                }
            }
        } else if (type == VehicleType.BIKE) {
            for (int i = 0; i < PLATE_LENGTH; i++) {
                if ((!Character.isLetter(plate.charAt(i)) && i < 3 || i == 5)
                        || (!Character.isDigit(plate.charAt(i)) && i < 5 && i >= 3)) {
                    throw new BadPlateFormat("La placa no corresponde al tipo de vehículo");
                }
            }
        }
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

}
