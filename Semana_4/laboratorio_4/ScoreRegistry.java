package Semana_4.laboratorio_4;

public class ScoreRegistry {

    private String name;
    private int score;

    public ScoreRegistry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(ScoreRegistry other, RegistryParams orderedBy) {
        if (orderedBy == RegistryParams.NAME) {
            return name.compareTo(other.getName());
        } else if (orderedBy == RegistryParams.SCORE) {
            return score - other.getScore();
        }
        return 0;
    }

    public int compareData(Object data, RegistryParams by) {
        if (by == RegistryParams.NAME) {
            return name.compareTo(data.toString());
        } else if (by == RegistryParams.SCORE) {
            return score - Integer.parseInt(data.toString());
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.score + "           " + this.name;
    }
}
