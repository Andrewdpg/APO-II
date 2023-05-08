import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < 100; j++) {
            int n = 2;
            int k = j + 1;
            HashMap<Integer, Integer> mp = new HashMap<>(k);
            for (int i = 0; i < k; i++) {
                int value = 0;
                if (mp.containsKey(value)) {
                    mp.replace(value, mp.get(value)+1);
                } else {
                    mp.put(value, 1);
                }
            }
            ArrayList<Integer> cords = new ArrayList<>(mp.keySet());
            int count = 0;
            int cMouse = cords.size() - 1;
            int iCat = -1;
            int coord;
            while (iCat < n - 2 && cMouse >= 0 && (coord = cords.get(cMouse)) >= iCat + 1) {
                int posible = (coord - iCat) / (n - 1 - coord);
                int in = mp.get(coord);
                int moved = min((coord - iCat) / (n - 1 - coord), mp.get(coord));
                iCat += (n - 2 - coord) * moved;
                count += moved;
                cMouse--;
                
                System.out.println("---------");
                System.out.println("coord: " + coord);
                System.out.println("posibles: " + posible);
                System.out.println("en casilla: " + in);
                System.out.println("movidos: " + moved);
                System.out.println("iCat: " + iCat);
                System.out.println("cont: " + count);
                System.out.println("cMouse: " + cMouse);
            }
            System.out.println((j + 1) + ": " + count);
        }
        sc.close();
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
