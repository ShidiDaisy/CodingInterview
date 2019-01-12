import java.util.Arrays;
import java.util.Scanner;

/*给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
 
[6] = 6 * 6 = 36;
[2] = 2 * 2 = 4;
[1] = 1 * 1 = 1;
[6,2] = 2 * 8 = 16;
[2,1] = 1 * 3 = 3;
[6, 2, 1] = 1 * 9 = 9;
 
从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
区间内的所有数字都在[0, 100]的范围内;

输入描述:
第一行输入数组序列长度n，第二行输入数组序列。
对于 50%的数据,  1 <= n <= 10000;
对于 100%的数据, 1 <= n <= 500000;


输出描述:
输出数组经过计算后的最大值。

输入例子1:
3
6 2 1

输出例子1:
36

HINTS:
For every number i in interval [81 87 47 59 81 18 25 40 56 0], the maximum product must from:
this number is the minimal number in this interval
	that means, there is no number which is smaller from left bound to right bound
	find the left and right bound by iterate the number from first left hand side number and right hand side number. and add to result interval.
	The iteration stops when meets a number is smaller than interval[i]
	
case通过率为70.00%	
*/
public class maxProductInterval {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] interval = new int[n];
		
		int a=0;
		while(in.hasNextInt()){
		//for(int i=0; i<n; i++){
			interval[a] = in.nextInt();
			System.out.println(a + ":" + interval[a]);
			a++;
		}

		int maxProduct = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			int curNum = interval[i];
			int sum = curNum;
			//find the left boundary
			for(int j=i-1; j>=0; j--){
				if(interval[j] > curNum){
					sum += interval[j]; 
				}else{
					break;
				}
			}
			
			//find the right boundary
			for(int k=i+1; k<n; k++){
				if(interval[k] > curNum){
					sum += interval[k];
				}else{
					break;
				}
			}
			
			int product = sum * curNum;
			maxProduct = Math.max(product, maxProduct);
		}
		
		System.out.println(maxProduct);
	}
}
