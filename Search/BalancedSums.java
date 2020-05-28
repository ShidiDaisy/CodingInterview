package Search;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class BalancedSums {
    static String balancedSums(List<Integer> arr) {
        int totalSum = arr.stream().mapToInt(Integer::intValue).sum();

        // Case 0
        int left = 0;
        int right = totalSum - arr.get(0);
        if(left == right){
            return "YES";
        }

        for(int i=1; i<arr.size()-1; i++){
            left += arr.get(i-1);
            right -= arr.get(i);
            if(left == right){
                return "YES";
            }else {
                continue;
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        List<Integer> arr1 = Arrays.asList(1, 1, 4, 1, 1);
        List<Integer> arr2 = Arrays.asList(2, 0, 0, 0);
        List<Integer> arr3 = Arrays.asList(0, 0, 2, 0);
        String result1 = balancedSums(arr1);
        String result2 = balancedSums(arr2);
        String result3 = balancedSums(arr3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
