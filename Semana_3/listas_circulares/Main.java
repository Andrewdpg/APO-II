package Semana_3.listas_circulares;

public class Main {
    public static void main(String[] args) {
        List list = new List();

        list.add(0, 1, 2, 3, 4, 5, 6);
        list.print();
        list.delete(0, 1, 2, 3, 4, 5, 6);
        list.print();
    }
}
