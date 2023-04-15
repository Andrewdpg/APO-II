package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Olimpic;
import model.exception.NegativeAmmountException;
import model.util.Reader;

public class Menu {

    private static final String MENU = "\n1. Ingresar país\n"
            + "2. Mostrar medallería\n"
            + "3. Mostrar total de medallas\n"
            + "4. Mostrar paises\n"
            + "5. Salir\n"
            + "Opcion: ";

    private boolean isRunning;
    private int option;

    private Olimpic olimpic;

    public Menu() {
        isRunning = true;
        olimpic = new Olimpic();
        try {
            olimpic.loadData();
        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo inicial");
        }
    }

    public void printMenu() {
        System.out.print(MENU);
    }

    public void executeOption() throws NegativeAmmountException {
        switch (option) {
            case 1:
                olimpic.addMedal(Reader.readString());
                break;
            case 2:
                olimpic.conventionalSort();
                break;
            case 3:
                olimpic.totalMedalsSort();
                break;
            case 4:
                olimpic.selectionSort();
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