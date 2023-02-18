package Semana_3.laboratorio_3;

public class Node {

    private Node next;
    private Node previous;
    private int data;
    private int passed;

    public Node(int data) {
        this.data = data;
        passed = 0;
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void print(Node main) {
        System.out.print((this != main ? "," : "") + data);
        if (next != main) {
            next.print(main);
        }
    }

    public void delete() {
        next.setPrevious(this.previous);
        previous.setNext(this.next);
    }

    public void delete(int data, Node main) {
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

    public void delete(int index) {
        if (index == 0) {
            delete();
            return;
        }
        next.delete(index - 1);
    }

    public void deleteLast(int data, Node main) {
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

    public void deleteAll(int data, Node main) {
        if (this.data == data) {
            this.next.setPrevious(this.previous);
            this.previous.setNext(this.next);
        }
        if (next != main) {
            next.delete(data, main);
            return;
        }
    }

    public int get(int index, boolean passed) {
        if (index == 0) {
            return this.data;
        }

        if (passed) {
            if (index - 1 <= 0) {
                this.passed++;
                if (this.passed == Menu.MAX_PASSED_TIMES) {
                    Menu.pos-=1;
                    delete();
                }
            }
        }
        return next.get(index - 1, passed);
    }

    public int get(int index) {
        if (index == 0) {
            return this.data;
        }

        return next.get(index - 1);
    }

    public int getPassed() {
        return passed;
    }

    public int length(Node main) {
        if (main == getNext()) {
            return 1;
        }
        return next.length(main) + 1;
    }
}
