package Semana_6.Excepciones;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            try {
                action();
            } catch (ArithmeticException e) {
                System.out.println("Se ha intentado dividir por 0.");
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Los vectores tienen tamaño diferente.");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Se han introducido letras.");
                e.printStackTrace();
            }catch(Exception e){
                System.out.println("Error desconocido. ");
                e.printStackTrace();
            }
        }
    }

    public static void action() throws ArithmeticException, ArrayIndexOutOfBoundsException, NumberFormatException {
        String a = scn.nextLine().replace("[", "").replace("]", "");
        String b = scn.nextLine().replace("[", "").replace("]", "");

        String[] arrA = a.split(",");
        String[] arrB = b.split(",");

        int[] arr1 = new int[arrA.length];
        int[] arr2 = new int[arrB.length];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(arrA[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(arrB[i]);
        }

        int[] res = new int[arr1.length > arr2.length ? arr2.length : arr1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr1[i] / arr2[i];
        }

        System.out.println(Arrays.toString(res));
    }
}
