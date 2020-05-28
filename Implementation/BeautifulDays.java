package Implementation;

/*
* Beautiful numbers are defined as numbers where |i - reverse(i)| is evenly divisible by k.
* https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
* */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulDays {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for(int day = i; day <= j; day++){
            int reverseNum = reverse(day);
            if(Math.abs(day - reverseNum)%k == 0){
                count++;
            }
        }
        return count;
    }

    static int reverse(int n){
        int reverseNum = 0;
        while (n != 0){
            int lastDigit = n%10;
            reverseNum = reverseNum * 10 + lastDigit;
            n = n/10;
        }
        return reverseNum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        System.out.println(result);

        scanner.close();
    }
}

