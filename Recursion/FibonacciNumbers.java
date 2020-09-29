package Recursion;

import java.util.*;

public class FibonacciNumbers{


    public static int fibonacci(int n) {
        int[] fib = new int[2];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i % 2] = fib[0] + fib[1];
        }
        return fib[n % 2];
    }

    public static void fibonacciLoop(int n){
        int t1 = 0, t2 = 1;
        System.out.print("First " + n + "terms: ");
        for(int i = 1; i <= n; i++){
            System.out.print(t1 + " ");
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}