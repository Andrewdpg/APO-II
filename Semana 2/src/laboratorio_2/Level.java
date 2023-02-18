package laboratorio_2;

public class Level {

    private Level next;
    private Level previous;
    private Player player;
    private LevelState state;
    private String question;
    private String answer;

    public Level(Level next, Level previous) {
        this.next = next;
        this.previous = previous;
        init();
    }

    public Level(Level next, Level previous, Player player) {
        this.next = next;
        this.previous = previous;
        this.player = player;
        init();
    }

    private void init() {
        state = LevelState.NOT_ANSWERED;
        int num_1 = (int) (Math.random() * 100);
        int num_2 = (int) (Math.random() * 100);

        Operation op = Operation.values()[(int) (Math.random() * 4)];

        if (op == Operation.ADDITION) {
            question = num_1 + " + " + num_2;
            answer = String.valueOf((int) (num_1 + num_2));
        }
        if (op == Operation.SUBSTRACTION) {
            question = num_1 + " - " + num_2;
            answer = String.valueOf((int) (num_1 - num_2));
        }
        if (op == Operation.DIVISION) {
            num_1++;
            num_2 = (int) (Math.random() * num_1)+1;
            question = num_1 + " / " + num_2;
            answer = String.valueOf((int) (num_1 / num_2));
        }
        if (op == Operation.MULTIPLICATION) {
            question = num_1 + " * " + num_2;
            answer = String.valueOf((int) (num_1 * num_2));
        }
    }

    public void print(int index) {
        String value = "";
        if (state != LevelState.NOT_ANSWERED) {
            value = state == LevelState.CORRECT ? "+" : "X";
        } else {
            value = index + (player != null ? "*" : "");
        }
        System.out.print("[" + value + "]");
        if (next == null)
            return;
        next.print(index + 1);
    }

    public boolean nextQuestion() {
        if (state == LevelState.NOT_ANSWERED) {
            System.out.print("¿Cual es el resultado de " + question + "? (Entero): ");
            String answer = Scan.readString();
            if(next !=null){
                next.setPlayer(player);
            }
            player = null;
            if (answer.equals("PASO")) {
                if(next !=null){
                    next.setPrevious(this.previous);
                }
                previous.setNext(this.next);
            } else if (answer.equals(this.answer)) {
                state = LevelState.CORRECT;
            } else {
                state = LevelState.FAILED;
            }
            System.out.println("Respuesta correcta: " + this.answer);
            return false;
        }
        if (next != null) {
            return next.nextQuestion();
        }
        return true;
    }

    public int countPoints(int levels,int count){
        if(next != null){
            return next.countPoints(levels,count+1) + (this.state == LevelState.CORRECT?1:0);
        }
        return (this.state == LevelState.CORRECT?1:0) -((levels-count)*3);
    }

    public Level getNext() {
        return next;
    }

    public void setNext(Level next) {
        this.next = next;
    }

    public Level getPrevious() {
        return previous;
    }

    public void setPrevious(Level previous) {
        this.previous = previous;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LevelState getState() {
        return state;
    }

    public void setState(LevelState state) {
        this.state = state;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
