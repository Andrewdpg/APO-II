package Semana_3.listas_circulares;

public class Node {

    private Node next;
    private Node previous;
    private Object data;

    public Node(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void print(Node main) {
        System.out.print((this != main ? "," : "") + data.toString());
        if (next != main) {
            next.print(main);
        }
    }

    public void delete(Object data, Node main) {
        if (this.data == data) {
            this.next.setPrevious(this.previous);
            this.previous.setNext(this.next);
            return;
        }
        if (next != main) {
            next.delete(data, main);
            return;
        }
    }

    public void deleteLast(Object data, Node main) {
        if (this.data == data) {
            this.next.setPrevious(this.previous);
            this.previous.setNext(this.next);
            return;
        }
        if (previous != main) {
            previous.deleteLast(data, main);
            return;
        }
    }

    public void deleteAll(Object data, Node main) {
        if (this.data == data) {
            this.next.setPrevious(this.previous);
            this.previous.setNext(this.next);
        }
        if (next != main) {
            next.delete(data, main);
            return;
        }
    }
}
