package Implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/strange-advertising/problem?h_r=next-challenge&h_v=zen
* Each day,  floor(recipients/2) of the recipients like the advertisement and will share it with 3 friends on the
* following day. Assuming nobody receives the advertisement twice, determine how many people have liked the ad by
* the end of a given day*/

public class ViralAdvertising {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int shared = 5;
        int cumulative = 0;

        for(int i=1; i<=n; i++){
            int liked = (int)Math.floor(shared/2);
            cumulative += liked;
            shared = liked * 3;
        }

        return cumulative;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        System.out.println(result);

        scanner.close();
    }
}

