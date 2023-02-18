package Semana_3.listas_circulares;

public class List {

    private Node head;

    public List() {
    }

    public void add(Object... data) {
        for (Object object : data) {
            add(object);
        }
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
            head.setNext(head);
            head.setPrevious(head);
            return;
        }
        head.getPrevious().setNext(new Node(data));
        head.getPrevious().getNext().setPrevious(head.getPrevious());
        head.getPrevious().getNext().setNext(head);
        head.setPrevious(head.getPrevious().getNext());
    }

    public void delete(Object... data) {
        for (Object object : data) {
            delete(object);
        }
    }

    public void delete(Object data) {
        if (head == null)
            return;
        if (head == head.getNext()) {
            if (head.getData() == data) {
                head = null;
            }
            return;
        }
        if (head.getData() == data) {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            head = head.getNext();
        }
        head.delete(data, head);
    }

    public void deleteAll(Object data) {
        if (head == null)
            return;
        if (head == head.getNext()) {
            if (head.getData() == data) {
                head = null;
            }
            return;
        }
        if (head.getData() == data) {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            head = head.getNext();
        }
        head.deleteAll(data, head);
    }

    public void deleteLast(Object data) {
        if (head == null)
            return;
        if (head == head.getNext()) {
            if (head.getData() == data) {
                head = null;
            }
            return;
        }
        head.getPrevious().deleteLast(data, head);
    }

    public void print() {
        System.out.print("\n[");
        if (head != null)
            head.print(head);
        System.out.print("]");
    }
}
