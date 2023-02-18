package Semana_3.laboratorio_3;

public class Menu {

    public static int MAX_PASSED_TIMES = 3;
    private int option;
    private List turns;
    private boolean hasFinished;
    public static int pos;
    private int counter;

    public Menu() {
        turns = new List();
        hasFinished = false;
        pos = 0;
        counter = 0;
    }

    public boolean hasFinished() {
        return hasFinished;
    }

    public void readOption() {
        option = Reader.readInt(-1);
    }

    public void printMenu() {
        System.out.print("\nSistema Bancolombia:\n"
                + " 1. Dar turno\n"
                + " 2. Mostrar turno actual\n"
                + " 3. Pasar turno\n"
                + " 4. Seguir\n"
                + " 0. Salir\n"
                + " Opcion: ");
    }

    public void execute() {
        int value;

        switch (option) {
            case 1:
                counter++;
                turns.add(counter);
                break;
            case 2:
                value = turns.get(pos);
                System.out.println("\nTurno actual:" + (value != -1 ? value : " No hay más turnos"));

                break;
            case 3:
                if (pos == turns.length() && turns.length() != 0) {
                    pos = 0;
                } else {
                    pos++;
                }
                value = turns.get(pos, true);

                System.out.println("\nTurno actual:" + (value != -1 ? value : " No hay más turnos"));
                break;
            case 4:
                turns.delete(pos);
                pos = 0;
                break;
            case 0:
                hasFinished = true;
                break;
            default:
                System.out.println("Opcion no reconocida");
                break;
        }
        System.out.print("\nLista de turnos: ");
        turns.print();
        System.out.println();
    }

}
