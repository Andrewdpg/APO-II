import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] input = reader.readLine().split(" ");
            Integer[] values = new Integer[input.length];
            for (int j = 0; j < input.length; j++) {
                values[j] = Integer.parseInt(input[j]);
            }
            selectionSort(values);
            min = abs(values[0] - values[1]);
            for (int j = 2; j < n; j++) {
                min = min(min, abs(values[j] - values[j - 1]));
            }
            System.out.println(min);
        }
    }

    public static <T extends Comparable<T>> T[] selectionSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[i]) < 0) {
                    T temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static int abs(int x) {
        return x < 0 ? -x : x;
    }

    public static int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }
}
/*
 * public static int b() throws IOException {
 * BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 * int n = Integer.parseInt(reader.readLine());
 * String data = " " + reader.readLine().trim() + " ";
 * while (!data.equals(" ") && !data.equals("  ")) {
 * String id = data.substring(0, data.indexOf(" ",1) + 1);
 * System.out.println(data);
 * data = data.replaceFirst(id, " ");
 * if (data.indexOf(data) != data.lastIndexOf(data)) {
 * return -1;
 * }
 * n--;
 * if (!id.equals(" 0 ")) {
 * data = data.replace(id, " ");
 * }
 * }
 * return n;
 * }
 * 
 * public static <T extends Comparable<T>> T[] bubblesort(T[] array) {
 * for (int i = 1; i < array.length; i++) {
 * for (int j = 1; j < array.length - i; j++) {
 * if (array[j].compareTo(array[j - 1]) < 0) {
 * T temp = array[j];
 * array[j] = array[j - 1];
 * array[j - 1] = temp;
 * }
 * }
 * }
 * return array;
 * }
 * 
 * public static <T extends Comparable<T>> T[] selectionSort(T[] array) {
 * for (int i = 0; i < array.length - 1; i++) {
 * for (int j = i + 1; j < array.length; j++) {
 * if (array[j].compareTo(array[i]) < 0) {
 * T temp = array[j];
 * array[j] = array[i];
 * array[i] = temp;
 * }
 * }
 * }
 * return array;
 * }
 * 
 * public static <T extends Comparable<T>> T[] insertionSort(T[] array) {
 * for (int i = 1; i < array.length; i++) {
 * for (int j = 0; j < i; j++) {
 * if (array[i].compareTo(array[j]) < 0) {
 * T temp = array[j];
 * array[j] = array[i];
 * array[i] = temp;
 * continue;
 * }
 * }
 * }
 * return array;
 * }
 */
