package Semana_3.laboratorio_3;

public class List {

    private Node head;

    public List() {
    }

    public void add(int data) {
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

    public void delete(int index) {
        if (head == null)
            return;
        if (head == head.getNext()) {
            head = null;
            return;
        }
        if (index == 0) {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            head = head.getNext();
            return;
        }

        head.delete(index);
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        return head.get(index);
    }

    public int get(int index, boolean passed) {

        if (head == null) {
            return -1;
        }

        int value = head.get(index, true);

        if (head.getPrevious().getNext() != head && head.getNext().getPrevious() != head) {
            head = head.getNext();
        }

        if (head.getPrevious() == head && head.getNext() == head && head.getPassed() >= Menu.MAX_PASSED_TIMES) {
            head = null;
            
        }

        return value;
    }

    public void print() {
        System.out.print("\n");
        if (head != null)
            head.print(head);
        System.out.print("");
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        return head.length(head);
    }

}
