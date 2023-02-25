package Semana_4.laboratorio_4;

public class Tree {

    private Node root;
    private Enum<?> orderedBy;

    public Tree(Enum<?> orderedBy) {
        this.orderedBy = orderedBy;
    }

    public void add(ScoreRegistry data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data, orderedBy);
    }

    public ScoreRegistry searchByKey(Object data) {
        return root.searchByKey(data, (RegistryParams) orderedBy);
    }

    public boolean exists(ScoreRegistry registry) {
        return root != null ? root.exists(registry, (RegistryParams) orderedBy) : false;
    }

    public Node getLast() {
        return getLast(root);
    }

    private Node getLast(Node current) {
        if (current == null)
            return null;
        if (current.getRight() != null) {
            return getLast(current.getRight());
        }
        return current;
    }

    public String getHighest(int count) {
        String msg = root.toStringBehind();
        String[] temp = msg.split("\n");
        if (temp.length <= 5) {
            return msg;
        }
        msg = "";
        for (int i = 0; i < count; i++) {
            msg += temp[i]+"\n";
        }
        return msg;
    }

    @Override
    public String toString() {
        return root != null ? this.root.toString() : "NONE";
    }
}
