package DP;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
/**
 * Leetcode322 https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1*/
public class CoinChange {
                            //[1, 2, 5]    //11
    public static int coinChange(int[] coins, int amount) {
        //开数组，最大要存到11
        //0...11: [11+1]
        int[] f = new int[amount+1];
        int n = coins.length; // number of kinds of coins

        // initialization
        f[0] = 0;

        int i, j;
        //f[1], f[2], ..., f[27]
        for(i = 1; i <= amount; i++){
            f[i] = Integer.MAX_VALUE; //boundary

            // last coin coins[j]
            // f[i] = min{f[i-coins[0]]+1, ..., f[i-coins[n]]+1}
            for(j = 0; j < n; j++){
                                        //不能越界
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE){
                    //i-coins[j] can't be negative
                    f[i] = Math.min(f[i-coins[j]]+1, f[i]); //find the min
                }
            }
        }

        if(f[amount] == Integer.MAX_VALUE){
            f[amount] = -1; //拼不出
        }

        return f[amount];
    }

    public static void main(String[] args) throws IOException{
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }
}
