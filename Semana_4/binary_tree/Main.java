package Semana_4.binary_tree;

public class Main {

    public static void main(String[] args) {
        Tree list = new Tree();

        list.add("Andres");
        list.add("David");
        list.add("Parra");
        list.add("Garcia");
        list.add("Keti");
        list.add("Mporta");

        System.out.println(list.toString());
        System.out.println(list.search("David"));
        System.out.println(list.search("Mporta"));
        System.out.println(list.search("Garcia"));
    }
}
