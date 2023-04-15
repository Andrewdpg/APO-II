import model.exception.NegativeAmmountException;
import ui.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        do {
            try {
                menu.printMenu();
                menu.readOption();
                menu.executeOption();
            } catch (NegativeAmmountException e) {
                System.out.println("La cantidad no debe ser negativa");
            }
        } while (menu.isRunning());
    }
}