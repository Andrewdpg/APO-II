package bases.menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        do {
            menu.printMenu();
            menu.readOption();
            menu.executeOption();
        } while (menu.isRunning());
    }
}