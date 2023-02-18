package laboratorio_2;

public class Main {

    public static void main(String[] args) {
        System.out.println("¿Cuantos niveles tendra la partida?");
        Game game = new Game(Scan.readInt(5, 1));
        do{
            game.printGame();
            game.ask();
        }while(!game.hasFinished());
    }
}
