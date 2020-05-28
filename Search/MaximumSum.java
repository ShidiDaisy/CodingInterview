package Search;
/*Maximum Subarray Sum Modulo M
* https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
*
* Find Maximum continuous subarray sum after modulo*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaximumSum {

    static long maximumSum(long[] a, long m) {
        long max = 0;
        long prefix = 0;
        Set<Long> S = new HashSet<>();
        S.add(0l);

        for(int i=1; i<a.length; i++){
            // Compute the prefix sum of array
//            Let maximum sum ending with i be, maxSumi.
//                    Let this sum begins with index j.
//
//                    maxSumi = (prefixi - prefixj + m) % m
//
//            From above expression it is clear that the
//            value of maxSumi becomes maximum when
//            prefixj is greater than prefixi
//            and closest to prefixi

            prefix = (prefix + a[i]) % m;
            max = Long.max(prefix, max);

            long it = 0l;
            for (long s:S) {
//              Finding iterator point to the closet
//              element that is not less than value
//              "prefix + 1", i.e., greater than or
//              equal to this value.
                if(s >= prefix+1){
                    it = s;
                }
            }

            if(it != 0l){
                max = Long.max(max, prefix - it + m);
            }

            S.add(prefix);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            System.out.println(result);
        }

        scanner.close();
    }
}

