package double_linked_list;

public class Node {

    private Node next;
    private Node previous;
    private Object data;

    public Node(Node next, Node previous, Object data) {
        this.next = next;
        this.previous = previous;
        this.data = data;
    }

    public Node(Node next, Node previous) {
        this.next = next;
        this.previous = previous;
    }

    public Node(Node next, Object data) {
        this.next = next;
        this.data = data;
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node() {
    }

    public Object getItemAt(int index) {
        if (index == 0)
            return data;
        if (next == null)
            return null;
        return next.getItemAt(index - 1);
    }

    public Object getPreviousAt(int index) {
        if (index == 0)
            return data;
        if (previous == null)
            return null;
        return previous.getPreviousAt(index - 1);
    }

    public void deleteFirst(Object data){
        if(next == null) return;
        if(next.getData() == data){
            next = next.getNext();
            next.setPrevious(this);
        }else{
            next.deleteFirst(data);
        }
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

    public String toString(){
        return data + (next !=null?","+next.toString():"]");
    }
}
