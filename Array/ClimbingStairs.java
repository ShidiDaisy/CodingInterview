package Array;
/**
 * 解题思路： 找重复子问题
 * 1： 1
 * 2： 2
 * 3： 从1跨两步来 or 从2跨一步来， = f(2)+f(1)
 * 4: 从2跨两步来 or 从3跨一步来， = f(2)+f(3)
 * f(n) = f(n-1) + f(n-2)*/
public class ClimbingStairs {
    public int climbStairs(int n){
        int f1 = 1, f2 = 2, f3 = 3;

        if(n < 3){
            return n;
        }

        for(int i = 3; i < n+1; i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }

    public static void main(String[] args) {
        int n = 3;
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(n));
    }
}
