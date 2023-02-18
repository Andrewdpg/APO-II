package seguimiento_2;

public class Box {

    private Player[] players;

    private Box next;

    public Box(Box next) {
        players = new Player[2];
        this.next = next;
    }

    public void setPlayers(Player[] players){
        this.players = players;
    }

    public boolean hasPlayer(int num) {
        if (num >= 0 || num < players.length)
            return players[num] != null;
        return false;
    }

    public boolean move(int pNum, int boxes) {
        if (pNum < 0 || pNum >= players.length)
            return false;
        if (players[pNum] != null) {
            Player player = players[pNum];
            players[pNum] = null;
            return move(pNum, boxes, player);
        } else if (next != null) {
            return next.move(pNum, boxes);
        } else {
            return false;
        }
    }

    public boolean move(int pNum, int boxes, Player player) {
        if (boxes == 0 || next == null) {
            players[pNum] = player;
            return next == null;
        }
        return next.move(pNum, boxes - 1, player);
    }

    public Box getNext() {
        return next;
    }

    public void setNext(Box next) {
        this.next = next;
    }

    public void print(int box,int columns) {
        String value = "";
        for (Player player : players) {
            if (player != null) {
                value += (value != "" ? "," : "") + player.getName();
            }
        }
        if (value == "") {
            value = String.valueOf(box);
        }
        System.out.print("[" + value + "]");
        if(box%columns==0)System.out.print("\n");
        if(next !=null) next.print(box+1,columns);
    }
}
