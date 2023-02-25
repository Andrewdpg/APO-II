package Semana_4.laboratorio_4;

public class Node {

    private ScoreRegistry registry;
    private Node left;
    private Node right;

    public Node(ScoreRegistry registry) {
        this.registry = registry;
    }

    public void add(ScoreRegistry registry, Enum<?> orderedBy) {
        if (this.registry.compareTo(registry, (RegistryParams) orderedBy) > 0) {
            if (left != null) {
                left.add(registry, orderedBy);
                return;
            }
            left = new Node(registry);

        } else if (this.registry.compareTo(registry, (RegistryParams) orderedBy) < 0) {
            if (right != null) {
                right.add(registry, orderedBy);
                return;
            }
            right = new Node(registry);
        }
    }

    public ScoreRegistry searchByKey(Object data, RegistryParams by) {
        if (this.registry.compareData(data, by) == 0) {
            return this.registry;
        }
        if (this.registry.compareData(data, by) > 0) {
            if (left != null){
                return left.searchByKey(data, by);
            }
            return null;
        }
        if (right != null){
            return right.searchByKey(data, by);
        }
        return null;
    }

    public ScoreRegistry searchNode(ScoreRegistry registry, RegistryParams by) {
        if (this.registry.compareTo(registry, by) == 0){
            return this.registry;
        }

        if (this.registry.compareTo(registry, by) > 0) {
            if (left != null){
                return left.searchNode(registry, by);
            }
            return null;
        }

        if (right != null){
            return right.searchNode(registry, by);
        }
        return null;
    }

    public boolean exists(ScoreRegistry registry, RegistryParams by) {
        return searchNode(registry, by) != null;
    }

    @Override
    public String toString() {
        return (left != null ? left.toString() + "\n" : "") + registry.toString()
                + (right != null ? "\n" + right.toString() : "");
    }

    public String toStringBehind() {
        return (right != null ? right.toStringBehind() + "\n" : "") + registry.toString()
                + (left != null ? "\n" + left.toStringBehind() : "");
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
