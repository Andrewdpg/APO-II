package Semana_4.binary_tree;

public class Node {

    private Node left;
    private Node right;
    private String key;

    public Node(String key) {
        this.key = key;
    }

    public void add(String key) {
        if (this.key.compareTo(key) > 0) {
            if (left != null) {
                left.add(key);
                return;
            }
            left = new Node(key);
        } else if (this.key.compareTo(key)< 0) {
            if (right != null) {
                right.add(key);
                return;
            }
            right = new Node(key);
        }
    }

    public String search(String key, String path) {
        if (this.key.equals(key)) {
            return path;
        }

        if (this.key.compareTo(key) > 0) {
            if (left != null) {
                return left.search(key, path + "->left");
            } else {
                return "NOT_FOUND";
            }
        }

        if (right != null)
            return right.search(key, path + "->right");
        else
            return "NOT_FOUND";

    }

    public Node(String key, Node left, Node right) {
        this.right = right;
        this.left = left;
        this.key = key;
    }

    @Override
    public String toString() {
        return key + (left != null ? "," + left.toString() : "") + (right != null ? "," + right.toString() : "");
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
