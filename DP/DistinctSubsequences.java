package DP;
public class DistinctSubsequences {
    /*Given a string S and a string T, count the number of distinct subsequences of S which equals T.
    *
    * Example 1:

    Input: S = "rabbbit", T = "rabbit"
    Output: 3
    Explanation:

    As shown below, there are 3 ways you can generate "rabbit" from S.
    (The caret symbol ^ means the chosen letters)

    rabbbit
    ^^^^ ^^
    rabbbit
    ^^ ^^^^
    rabbbit
    ^^^ ^^^

    Example 2:

    Input: S = "babgbag", T = "bag"
    Output: 5
    Explanation:

    As shown below, there are 5 ways you can generate "bag" from S.
    (The caret symbol ^ means the chosen letters)

    babgbag
    ^^ ^
    babgbag
    ^^    ^
    babgbag
    ^    ^^
    babgbag
      ^  ^^
    babgbag
        ^^^


slide t[j] through every s[i]
        babgbag
     0 11111111
     b 01122333
     a 00111144
     g 00001115

     Time Complexity: O(s+s*t) = O(s*t)
    * */

    public static int numDistinct(String s, String t){
        int m = s.length()+1; //7+1
        int n = t.length()+1;
        int[][] dp = new int[m][n];

        //init case dp[i][0] = 1, when t has 0 length, then always just 1 same subsequence
        //Time Complexity: O(s)
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }

        //Time Complexity: O(s*t)
        for(int i=1; i<m; i++){

            for(int j=1; j<n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    //how many t[j-1] elements already matched + includes t[j], how many t[j] elements already matched
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }

                if(s.charAt(i-1) != t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String args[]){
        String s = "babgbag";
        String t = "bag";
        System.out.println(numDistinct(s, t));
    }
}
