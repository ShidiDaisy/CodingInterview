package Math;

import java.util.Scanner;

/*Update and Query highest Mark
 * 老师想知道从某某同学当中，分数最高的是多少
 * 
 * 输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

输出：对于每一次询问操作，在一行里面输出最高成绩

输入例子1:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出例子1:
5
6
5
9

Hint: Brute-force
 * */
public class HighestMark {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] grades = new int[N];
			
			for(int i=0; i<N && sc.hasNext(); i++){
				grades[i] = sc.nextInt();
			}
			
			for(int i=0; i<M && sc.hasNext(); i++){
				//for every query/update
				String operation = sc.next();
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				
				process(operation, num1, num2, grades);
				
			}
		}

	}
	
	public static void process(String operation, int num1, int num2, int[] grades){
		//Query
		if(operation.equals("Q")){
			//find the max between num1 to num2
			int max = 0;
			int begin = Math.min(num1, num2);
			int end = Math.max(num1, num2);
			for(int i=begin-1; i<end; i++){
				max = Math.max(max, grades[i]);
			}
			System.out.println(max);
		}else if(operation.equals("U")){
			grades[num1-1] = num2;
		}
	}

}
