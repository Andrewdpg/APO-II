package bases.menu;

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

    public static String readString(boolean mayEmpty){
        String value = scn.next();
        while(value == "" && !mayEmpty){
            value = scn.next();;
        }
        return value;
    }
}
