package data_structure;

public class Main {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        List list = new List();

        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        System.out.println(list.get(100));
        System.out.println(System.currentTimeMillis()-t1);
    }
}
