/*P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），
 * 则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
input: 
第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
对于 50%的数据,  1 <= N <= 10000;
对于 100%的数据, 1 <= N <= 500000;

output:
输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。
输入例子1:
5
1 2
5 3
4 6
7 5
9 0

输出例子1:
4 6
7 5
9 0

HINTS:
1. Sort at X increasing Y decreasing -> Array A
2. The last element has (Xmax) -> add to res
3. iterate the array A from the end
 	next Y > current Ymax
*/
import java.util.*;
public class skyline {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [][] arr = new int[n][2];
		ArrayList<int[]> skyline = new ArrayList<int[]>();
		
		for(int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			int[] pair = {x,y};
			arr[i] = pair ;
		}
		
		//Sort the array: Y in descending order, X in ascending order
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[1]==b[1] ? a[0]-b[0] : b[1]-a[1];
			}
		});
		
		int xmax = arr[0][0];
		skyline.add(arr[0]);
		//Loop the points from right to left (high Y to low Y)
		for(int i=1; i<arr.length; i++) {
			if (arr[i][0] > xmax) {
				//if has higher ymax, add into skyline
				skyline.add(arr[i]);
				xmax = arr[i][0];
			}
		}

		//Output
		for(int[] pair:skyline) {
			System.out.printf("%d %d\n", pair[0], pair[1]);
		}
	}

}
