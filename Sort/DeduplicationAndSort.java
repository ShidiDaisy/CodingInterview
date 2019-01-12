package Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*华为真题
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，
 * 希望大家能正确处理)。

输入描述:
输入多行，先输入随机整数的个数，再输入相应个数的整数


输出描述:
返回多行，处理后的结果

输入例子1:
11
10
20
40
32
67
40
20
89
300
400
15

输出例子1:
10
15
20
32
40
67
89
300
400*/
public class DeduplicationAndSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] studNum = new int[n];
			for(int i=0; i<n; i++){
				studNum[i] = sc.nextInt();
			}
			
			DeduplicationAndSort sol = new DeduplicationAndSort();
			int[] res = sol.sortDeduplication(studNum);
			for(int i=0; i<res.length; i++){
				System.out.println(res[i]);
			}
		}
	}

	public int[] sortDeduplication(int[] studentNum){
		Set<Integer> dedupedList = new HashSet<Integer>();
		for(int i=0; i<studentNum.length; i++){
			dedupedList.add(studentNum[i]);
		}
		
		int[] resList = toInt(dedupedList);
		Arrays.sort(resList);
		
		return resList;
	}
	
	public int[] toInt(Set<Integer> set) {
		  int[] a = new int[set.size()];
		  int i = 0;
		  for (Integer val : set) a[i++] = val;
		  return a;
	}
}
