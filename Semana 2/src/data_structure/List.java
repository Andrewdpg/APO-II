package data_structure;

public class List {

    Node main;

    public void add(Object data){
        if(main == null)
            main = new Node(data);
        else
            //main.addAtEnd(new Node(data));
            main = new Node(data, main);
    }

    public Object get(int index){
        return main.getUntil(index);
    }

    public Node getLast(){
        return main.getLast();
    }
}
