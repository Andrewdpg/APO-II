import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] array = { 1, 6, 2, 5, 3, -2, 6 };
        bubblesort(array);
        System.out.println(Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void bubblesort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
