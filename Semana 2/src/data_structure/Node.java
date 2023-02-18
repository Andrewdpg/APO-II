package data_structure;

public class Node {

    private Object data;
    private Node next;

    public Node(Object data, Node next){
        this.next = next;
        this.data = data;
    }
    public Node(Object data){
        this.data = data;
    }
    public Node(){
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Object getUntil(int n){
        if(n == 0) return data;
        if(next == null) return null;
        return next.getUntil(n-1);
    }


    public Node getLast(){
        if(next == null) return this;
        return next.getLast();
    }

    public void addAtEnd(Node node){
        if(next == null)
            next = node;
        else
            next.addAtEnd(node);
    }

}
