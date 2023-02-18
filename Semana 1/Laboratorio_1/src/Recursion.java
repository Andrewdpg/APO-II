import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static final int[] S = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50};

    //Ej 1
    public int sum(int[] array){
        if(array == null) return 0;
        return sum(array, 0);
    }

    private int sum(int[] array, int index){
        if(array.length == index+1) return array[index];
        return array[index] + sum(array,index+1);
    }

    //Ej 2
    public String reverse(String value){
        if(value.length() == 1) return value;
        return reverse(value.substring(1)) + value.charAt(0);
    }

    //Ej 3
    public double prom(int[] array){
        if(array == null) return 0;
        return prom(array, 0);
    }

    private double prom(int[] array, int index){
        if(array.length == index+1) return array[index]/(double)array.length;
        return array[index]/(double)array.length + prom(array,index+1);
    }

    //Ej 4
    public int posOf(int[]array,int number){
        if(array == null) return -1;
        return posOf(array, number, 0);
    }

    private int posOf(int[]array, int number, int index){
        if(array.length == index) return -1;
        if(array[index] == number) return index;
        return posOf(array, number, index+1);
    }

    //Ej 5
    public int[] div(int num, int den){
        if(num < den) return new int[]{0,num};
        return div(num, den, 0);
    }

    public int[] div(int num, int den, int value){
        if(num < den) return new int[]{value,num};
        return div(num-den,den,value+1);
    }

    //Ej 6
    public int mcd(int a, int b){
        if(b == 0) return a;
        return mcd(b,a%b);
    }

    //Ej 7
    public List<Integer> target(int value){
        return target(value,new ArrayList<>());
    }

    private List<Integer> target(int value, List<Integer>list){
        if(value == 0 || list.contains(0)) return list;
        int higher = higherPos(value,0);
        list.add(higher);
        return target(value-higher, list);
    }

    private int higherPos(int value, int index){
        if(value - S[index] >= 0) return S[index];
        if(index < S.length-1) return higherPos(value,index+1);
        return 0;
    }

}
