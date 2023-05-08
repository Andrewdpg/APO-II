import java.util.Arrays;
import java.util.Scanner;

public class Val {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int j = 0; j < t; j++) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] barrels = new int[n];
            for (int i = 0; i < n; i++) {
                barrels[i] = scn.nextInt();
            }
            Arrays.sort(barrels);
            for (int i = n - 2; i >= 0 && k > 0; i--) {
                barrels[i] += barrels[i + 1];
                barrels[i + 1] = 0;
                k--;
            }
            Arrays.sort(barrels);
            System.out.println(barrels[n - 1] - barrels[0]);
        }
    }
}