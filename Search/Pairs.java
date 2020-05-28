package Search;
/*https://www.hackerrank.com/challenges/pairs/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
*   Determine the number of pairs of array elements that have a difference equal to a target value.
*
* Hint: Sort the array, then 放两个指针，一个一个比较*/
import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);

        int i = 0; //pointer1
        int j = 1; //pointer2
        int count = 0;
        while(j < arr.length){
            int diff = arr[j] - arr[i];
            if(diff == k){
                count++;
                i++;
                j++;
            }else if(diff < k){
                j++;
            }else if(diff > k){
                i++;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        System.out.println(result);

        scanner.close();
    }
}

