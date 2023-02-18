public class Main {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        //Ej 1
        int[] array = new int[]{12, -1, 15, 2, 4 , 14};
        System.out.println("Sum of {12, -1, 15, 2, 4 , 14}:"+recursion.sum(array));
        //Ej 2
        System.out.println("Reverse of \"Abecedario\":"+recursion.reverse("Abecedario"));
        //Ej 3
        array = new int[]{1, 2, 3, 4, 5 , 6};
        System.out.println("Average of {1, 2, 3, 4, 5 , 6}:"+recursion.prom(array));
        //Ej 4
        array = new int[]{1, 15, 8, 19, 21, 40, -4, 10};
        System.out.println("Position of 19 in {1, 15, 8, 19, 21, 40, -4, 10}: "+recursion.posOf(array,19));
        //Ej 5
        array = recursion.div(34,5);
        System.out.println("Division of 34/5: "+ array[0] + ", Residue: " + array[1]);
        //Ej 6
        System.out.println("MCD of 64 and 30: " + recursion.mcd(64,30));
        //Ej 7
        System.out.println("TARGET of 82500: " + recursion.target(82500).toString());
    }


}