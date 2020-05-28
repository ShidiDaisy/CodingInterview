import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int number = scanner.nextInt();
        for(int i=0; i<number; i++){
            String word = scanner.next();
            StringBuilder sbEven = new StringBuilder();
            StringBuilder sbOdd = new StringBuilder();
            for(int j=0; j<word.length(); j++){
                if(j % 2 == 0){
                    sbEven.append(word.charAt(j));
                }else{
                    sbOdd.append(word.charAt(j));
                }
            }
            System.out.println(sbEven + " " + sbOdd);
        }
    }
}