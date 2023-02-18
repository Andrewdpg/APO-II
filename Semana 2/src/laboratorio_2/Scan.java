package laboratorio_2;

import java.util.Scanner;

public class Scan {

    private static Scanner scn = new Scanner(System.in);

    public static int readInt(int def) {
        try {
            return scn.nextInt();
        } catch (Exception e) {
            return def;
        }
    }

    public static int readInt(int def, int min) {
        try {
            int value = scn.nextInt();
            if (value >= min) {
                return value;
            } else {
                return def;
            }
        } catch (Exception e) {
            return def;
        }
    }

    public static String readString(){
        return scn.next();
    }
}
