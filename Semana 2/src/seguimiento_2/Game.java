package seguimiento_2;

import java.util.Scanner;

public class Game {

    private Box start;
    private int current;
    private int columns;
    private boolean finished;
    private Scanner scn;

    public Game(int rows, int columns) {
        this.columns = columns;
        init(rows * columns);
        start.setPlayers(new Player[] { new Player("P1"), new Player("P2") });
        current = 0;
        finished = false;
        scn = new Scanner(System.in);
    }

    private void init(int length) {
        start = new Box(start);
        if (length > 1)
            init(length - 1);
    }

    public boolean hasFinished() {
        return finished;
    }

    public void movePlayer() {
        int boxes = diceResult();
        if(boxes == 0){
            movePlayer();
            return;
        }
        System.out.println("Resultado de dado: " + boxes);

        if (start.move(current, boxes)) {
            System.out.println("Jugador " + (current + 1) + " gana.");
            printTable();
            finished = true;
            return;
        }

        current = current == 0 ? 1 : 0;
    }

    public int diceResult() {
        return (int) (Math.random() * 7);
    }

    public void printTable() {
        start.print(1, columns);
    }

    public void printMenu() {
        System.out.println("1. Tirar dado\n" +
                "2. Ver tablero\n" +
                "3. Salir");
    }

    public int readOption() {
        System.out.print("Opcion: ");
        try {
            return scn.nextInt();
        } catch (Exception e) {
            return -1;
        }
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                movePlayer();
                break;
            case 2:
                printTable();
                break;
            case 3:
                finished = true;
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
        System.out.println();
    }
}
