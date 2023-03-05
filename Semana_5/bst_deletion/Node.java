package Semana_5.bst_deletion;

public class Node {

    private int key;
    //Datos

    //Enlaces
    private Node right;
    private Node left;

    public Node(int key) {
        this.key = key;
    }

    

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
