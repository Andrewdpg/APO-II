package laboratorio_2;

public class Game {

    private boolean hasFinished;
    private Player player;
    private Level start;
    private int levels;

    public Game(int levels) {
        this.levels = levels;
        init(levels);
    }

    private void init(int levels) {
        if (levels == 0)
            return;
        if (start == null) {
            System.out.println("Nombre del jugador:");
            player = new Player(Scan.readString());
            Level lvl = new Level(null, null, player);
            start = lvl;
        } else {
            Level lvl = new Level(null, null);
            start.setPrevious(lvl);
            lvl.setPlayer(start.getPlayer());
            start.setPlayer(null);
            lvl.setNext(start);
            start = lvl;
        }
        init(levels - 1);
    }

    public void ask() {
        hasFinished = start.nextQuestion();
        if (hasFinished) {
            System.out.println("Juego ya terminado.");
            System.out.println("Puntaje del jugador " + player.getName() + ": " + countPoints());
        }

    }

    public int countPoints() {
        if (start != null) {
            return start.countPoints(levels, 1);
        } else {
            return -(levels * 3);
        }
    }

    public boolean hasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public void printGame() {
        start.print(1);
        System.out.println();
    }

}
