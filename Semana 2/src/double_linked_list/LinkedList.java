package double_linked_list;

class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        size = 0;
    }

    private void add(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
    }

    public void add(Object data) {
        add(new Node(data));
    }

    public void addFirst(Object data) {
        if (head == null) {
            Node node = new Node(data);
            head = node;
            tail = node;
        }
        head = new Node(head, null, data);
    }

    public Object get(int index) {
        if (index < size / 2)
            return head.getItemAt(index);
        return tail.getPreviousAt(size - index - 1);

    }

    public void delete(Object data){
        if(head.getData()==data) {head = head.getNext();}
        else{
            head.deleteFirst(data);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString(){
        return "[" + head.toString();
    }
}