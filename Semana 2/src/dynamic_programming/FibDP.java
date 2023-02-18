package dynamic_programming;

public class FibDP {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(fib2(40));
        System.out.println(System.currentTimeMillis()-t1);

        t1 = System.currentTimeMillis();
        System.out.println(fib(40));
        System.out.println(System.currentTimeMillis()-t1);
    }

    static int[] dp = new int[1000];
    public static int fib(int n){
        if(n<0) return 0;
        if(n <= 1) return 1;
        return fib(n-1)+fib(n-2);
    }

    public static int fib2(int n){
        if(dp[n] != 0) return dp[n];
        if(n <= 1) return 1;
        dp[n] = fib2(n-1)+fib2(n-2);
        return dp[n];
    }
}