package double_linked_list;

public class Main {
 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(0);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.addFirst(9);
        
        System.out.println(list.toString());
        list.delete(4);
        System.out.println(list.toString());

    }
}
