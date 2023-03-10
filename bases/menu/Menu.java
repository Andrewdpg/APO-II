package bases.menu;

public class Menu {

    private static final String MENU = "\n1. Primera opción\n"
            + "2. Segunda opción\n"
            + "3. Tercera opción\n"
            + "4. Cuarta opción\n"
            + "5. Salir\n"
            + "Opcion: ";

    private boolean isRunning;
    private int option;

    public Menu() {
        isRunning = true;
    }

    public void printMenu() {
        System.out.print(MENU);
    }

    public void executeOption() {
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
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