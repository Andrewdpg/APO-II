package Semana_4.binary_tree;

public class Tree {

    private Node root;

    public Tree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(String data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public Node search(String key){
        return root.search(key);
    }

    public String getMin(){
        return root.getMin();
    }
    public String getMax(){
        return root.getMax();
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
