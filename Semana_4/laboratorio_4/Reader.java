package Semana_4.laboratorio_4;

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
        try {
            return scn.next();
        } catch (Exception e) {
            scn.next();
            System.out.println("Entrada inválida");
            return "";
        }
    }
}
