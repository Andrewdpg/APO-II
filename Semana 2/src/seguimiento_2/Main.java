package seguimiento_2;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(3, 4);
        do{
            game.printMenu();
            game.executeOption(game.readOption());
        }while(!game.hasFinished());
    }
}
