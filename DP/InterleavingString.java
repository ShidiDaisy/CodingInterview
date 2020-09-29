package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Leetcode 97: Interleaving String
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false*/
public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        //create array, all values will be false by default.
        boolean[][] map = new boolean[s1.length()+1][s2.length()+1];

        //initial state
        map[0][0] = true;

        for(int i = 1; i <= s1.length(); i++){
            if(s1.charAt(i-1) == s3.charAt(i-1) && map[i-1][0]){
                map[i][0] = true;
            }
        }

        for(int j = 1; j <= s2.length(); j++){
            if(s2.charAt(j-1) == s3.charAt(j-1) && map[0][j-1]){
                map[0][j] = true;
            }
        }

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if((s1.charAt(i-1) == s3.charAt(i+j-1) && map[i-1][j])
                        || (s2.charAt(j-1) == s3.charAt(i+j-1) && map[i][j-1])){
                    map[i][j] = true;
                }
            }
        }
        return map[s1.length()][s2.length()];
    }

    public static void main(String[] args) {

        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
