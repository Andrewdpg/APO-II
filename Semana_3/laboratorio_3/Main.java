package Semana_3.laboratorio_3;

public class Main {
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        do{
            menu.printMenu();
            menu.readOption();
            menu.execute();
        }while(!menu.hasFinished());
    }
}
