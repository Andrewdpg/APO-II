package Semana_4.binary_tree;

public class Main {

    public static void main(String[] args) {
        Tree list = new Tree();

        list.add("David");
        list.add("Julian");
        list.add("Pablo");
        list.add("Juan");
        list.add("Isabela");
        list.add("Daniela");

        System.out.println(list.toString());
        System.out.println(list.search("David").toString());
        System.out.println(list.getMin());
        System.out.println(list.getMax());
    }
}
