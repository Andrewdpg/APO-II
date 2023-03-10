package Semana_6.unicentro_parking;

import java.util.Scanner;

public class Reader {

    private static Scanner scn = new Scanner(System.in);

    public static int readInt(int def) {
        try {
            return scn.nextInt();
        } catch (Exception e) {
            scn.next();
            return def;
        }
    }

    public static String readString() {
        return scn.next();
    }

    public static String readString(boolean mayEmpty) {
        String value = scn.next();
        while (value == "" && !mayEmpty) {
            value = scn.next();
        }
        return value;
    }

    public static String readString(int minSize) {
        String value = scn.next();
        while (value.length() < minSize) {
            System.out.println("No cumple con la longitud mínima");
            value = scn.next();
        }
        return value;
    }

    public static String readString(int minSize, int maxSize) {
        String value = scn.next();
        while (value.length() < minSize || value.length() > maxSize) {
            System.out.println("No cumple con la longitud necesaria");
            value = scn.next();
        }
        return value;
    }
}
