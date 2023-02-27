package Semana_5.bts_deletion;

public class BST {

    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }
    }

    private void add(Node current, Node node) {
        if (node.getKey().compareTo(current.getKey()) < 0) {
            // Meter a la izquierda
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                add(current.getLeft(), node);
            }
        } else if (node.getKey().compareTo(current.getKey()) > 0) {
            // Meter a la derecha
            if (current.getRight() == null) {
                current.setRight(node);
            } else {
                add(current.getRight(), node);
            }

        } else {
            // No hacer nada
        }
    }

    public Node getMin() {
        return getMin(root);
    }

    private Node getMin(Node current) {
        if (current.getLeft() == null) {
            return current;
        }
        return getMin(current.getLeft());
    }

    public Node getMax() {
        return getMax(root);
    }

    private Node getMax(Node current) {
        if (current.getRight() == null) {
            return current;
        }
        return getMax(current.getRight());
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeft());
        System.out.println(current.getKey());
        inOrder(current.getRight());
    }

    public Node search(String goal) {
        return search(root, goal);
    }

    private Node search(Node current, String goal) {
        if (current == null) {
            System.out.println("Not found");
            return null;
        }
        if (current.getKey().equals(goal)) {
            return current;
        }

        if (goal.compareTo(current.getKey()) < 0) {
            return search(current.getLeft(), goal);
        } else {
            return search(current.getRight(), goal);
        }
    }

    public void delete(String goal) {
        delete(root, null, goal);
    }

    private void delete(Node current, Node parent, String goal) {
        if (current == null) {
            return;
        }

        if (current.getKey().equals(goal)) {
            if (parent == null) {
                root = deleteNode(current);
            } else {
                if (parent.getLeft() == current) {
                    parent.setLeft(deleteNode(current));
                } else {
                    parent.setRight(deleteNode(current));
                }
            }
            return;
        }

        if (goal.compareTo(current.getKey()) < 0) {
            delete(current.getLeft(), current, goal);
        } else {
            delete(current.getRight(), current, goal);
        }
    }

    private Node deleteNode(Node current) {
        if (current.getLeft() != null && current.getRight() == null) {
            return current.getLeft();
        } else if (current.getLeft() == null && current.getRight() != null) {
            return current.getRight();
        } else if (current.getRight() != null && current.getLeft() != null) {
            current.setKey(getMax(current).getKey());
            delete(current.getRight(), current, current.getKey());
            return current;
        } else {
            return null;
        }
    }
}