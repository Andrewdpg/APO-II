package Semana_5.bst_deletion;

public class Main {

    public static void main(String[] args) {
        BST tree = new BST();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        tree.add(a);
        tree.add(b);
        tree.add(c);
        tree.add(d);
        tree.add(e);
        tree.add(f);

        System.out.println("------");
        tree.inOrder();

        System.out.println("------");
        tree.inOrder();
        System.out.println("Is it a BST? -> "+tree.checkBST());
    }

}