package bases.list;

public class DoubleLinkedList<T> {

    private Node<T> start;
    private Node<T> end;
    private int length;

    public DoubleLinkedList() {
        length = 0;
    }

    public void add(T value) {
        add(value, -1);
    }

    public void add(T value, int index) {
        if (length < (index < 0 ? -(start == null ? index + 1 : index) : index)) {
            throw new IndexOutOfBoundsException();
        }
        if (start == null) {
            start = new Node<T>(value);
            end = start;
            start.setNext(end);
            start.setPrevious(end);
        } else {
            if (index == 0) {
                Node<T> node = new Node<T>(value, end, start);
                start.setPrevious(node);
                end.setNext(node);
                start = node;
            } else {
                Node<T> node = getNodeAt(index);
                if (index > 0) {
                    node = new Node<T>(value, node.getPrevious(), node);
                } else {
                    node = new Node<T>(value, node, node.getNext());
                }
                node.getPrevious().setNext(node);
                node.getNext().setPrevious(node);
                end = start.getPrevious();
            }
        }
        this.length++;
    }

    public T get(int index) {
        if (length - 1 < (index < 0 ? -index : index)) {
            throw new IndexOutOfBoundsException();
        }
        return getNodeAt(index, start).getData();
    }

    public void update(int index, T value) {
        if (length - 1 < (index < 0 ? -index : index)) {
            throw new IndexOutOfBoundsException();
        }
        getNodeAt(index).setData(value);
    }

    public void remove(int index) {
        if (length - 1 < (index < 0 ? -index : index)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            end.setNext(start.getNext());
            start.getNext().setPrevious(end);
            start = start.getNext();
        } else if (index == -1) {
            start.setPrevious(end.getPrevious());
            end.getPrevious().setNext(start);
            end = end.getPrevious();
        } else {
            Node<T> node = getNodeAt(index);
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }
        length--;
    }

    public void remove(T value) {
        remove(value, start);
    }

    private void remove(T value, Node<T> current) {
        if (current.getData() == value) {
            if (current == start) {
                end.setNext(start.getNext());
                start.getNext().setPrevious(end);
                start = start.getNext();
            } else if (current == end) {
                start.setPrevious(end.getPrevious());
                end.getPrevious().setNext(start);
                end = end.getPrevious();
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
            length--;
            return;
        }
        if (current.getNext() == start) {
            return;
        }
        remove(value, current.getNext());
    }

    protected Node<T> getNodeAt(int index) {
        return getNodeAt(index, start);
    }

    protected Node<T> getNodeAt(int index, Node<T> sFrom) {
        if (index == 0) {
            return sFrom;
        }
        if (index > 0) {
            return getNodeAt(index - 1, sFrom.getNext());
        }
        return getNodeAt(index + 1, sFrom.getPrevious());
    }

    @Override
    public String toString() {
        return "[" + (start != null ? toString(start) : "") + "]";
    }

    private String toString(Node<T> current) {
        if (current.getNext() == start) {
            return current.getData().toString();
        }
        return current.getData().toString() + "," + toString(current.getNext());
    }

    protected Node<T> getStart() {
        return start;
    }

    protected Node<T> getEnd() {
        return end;
    }

    public int getLength() {
        return length;
    }

}
