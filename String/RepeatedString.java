package String;
import java.util.*;
import java.io.*;
/*
https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
level: Easy

* Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.

Given an integer, n, find and print the number of letter a's in the first  letters of Lilah's infinite string.

For example, if the string s='abcac' and n=10, the substring we consider is abcacabcac, the first 10 characters of her infinite string. There are 4 occurrences of a in the substring.

Function Description

Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length n in the infinitely repeating string.

repeatedString has the following parameter(s):

s: a string to repeat
n: the number of characters to consider
Input Format

The first line contains a single string, s.
The second line contains an integer, n.

Output Format

Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.

Sample Input 0

aba
10
Sample Output 0

7

Sample Input 1

a
1000000000000

Sample Output 1

1000000000000
*/
public class RepeatedString {
    static long repeatedString(String s, long n) {
        int aInS = 0;

        //count a in s
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                aInS++;
            }
        }

        long numOfRepeat = n/s.length() * aInS;

        for(int i=0; i<n%s.length(); i++){
            if(s.charAt(i) == 'a'){
                numOfRepeat++;
            }
        }
        return numOfRepeat;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}
