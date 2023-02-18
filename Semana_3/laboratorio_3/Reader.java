package Semana_3.laboratorio_3;

import java.util.Scanner;

public class Reader {

    private static Scanner scn = new Scanner(System.in);

    public static int readInt(int def){
        try {
            return scn.nextInt();
        } catch (Exception e) {
            return def;
        }
    }
}
