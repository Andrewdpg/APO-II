package Semana_4.laboratorio_4;

public class Menu {

    private static final String MENU = "\n1. Agregar registro\n"
            + "2. Buscar registro por puntaje\n"
            + "3. Jugadores por orden alfabético\n"
            + "4. Ver TOP 5 puntajes\n"
            + "5. Salir\n"
            + "Opcion: ";

    private boolean isRunning;
    private int option;
    private Tree scoreTree;
    private Tree nameTree;

    public Menu() {
        scoreTree = new Tree(RegistryParams.SCORE);
        nameTree = new Tree(RegistryParams.NAME);
        isRunning = true;
    }

    public void printMenu() {
        System.out.print(MENU);
    }

    private void addScoreRegistry() {
        ScoreRegistry registry = new ScoreRegistry(null, -1);
        while (registry.getName() == null || registry.getName().equals("")) {
            System.out.print("Dame el nombre: ");
            registry.setName(Reader.readString());
        }
        while (registry.getScore() < 0) {
            System.out.print("Dame el puntaje: ");
            registry.setScore(Reader.readInt(-1));
        }
        addScoreRegistry(registry);
    }

    private ScoreRegistry searchByScore(int score) {
        return scoreTree.searchByKey(score);
    }

    private void addScoreRegistry(ScoreRegistry scoreRegistry) {
        if (!nameTree.exists(scoreRegistry) && !scoreTree.exists(scoreRegistry)) {
            nameTree.add(scoreRegistry);
            scoreTree.add(scoreRegistry);
            System.out.println("\nAnadido correctamente\n");
        } else {
            System.out.println("\nNo anadido: puntaje o nombre ya registrados\n");
        }
    }

    public void executeOption() {
        switch (option) {
            case 1:
                addScoreRegistry();
                break;
            case 2:
                System.out.print("Dame el puntaje a buscar: ");
                ScoreRegistry registry = searchByScore(Reader.readInt(-1));
                if (registry != null) {
                    System.out.println("Persona encontrada: " + registry.toString());
                } else {
                    System.out.println("Persona no encontrada.");
                }
                break;
            case 3:
                System.out.println("\nPuntaje     Nombre\n" + nameTree.toString());
                break;
            case 4:
                System.out.println("\n\nasdfasdfasdf"+scoreTree.getHighest(5));
                
                break;
            case 5:
                isRunning = false;
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