package Semana_5.bst_deletion;

public class Main {

    public static void main(String[] args) {
        BST tree = new BST();
        Node a = new Node("David");
        Node b = new Node("Julian");
        Node c = new Node("Pablo");
        Node d = new Node("Juan");
        Node e = new Node("Isabela");
        Node f = new Node("Daniela");
        tree.add(a);
        tree.add(b);
        tree.add(c);
        tree.add(d);
        tree.add(e);
        tree.add(f);

        System.out.println("------");
        tree.inOrder();

        tree.delete("Juan");
        System.out.println("------");
        tree.inOrder();

    }

}