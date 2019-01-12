package Queue;

import java.util.Arrays;
import java.util.Comparator;

/*Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers 
 * (h, k), where h is the height of the person and k is the number of people in 
 * front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

???
HINT:
Way1
先对height从小到大排序
高度小的优先安排位置，因为不会影响后面的人的排序
不需要再动了
然后把已经排序的位置去掉
剩下的位置照样给矮个子优先选择次序

Way2:
https://www.jiuzhang.com/solution/queue-reconstruction-by-height/#tag-highlight
*
*/


public class reconstructQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] reconstructQueue(int[][] people){
		int numOfPeople = people.length;
		int[][] res = new int[numOfPeople][2];
		
		//Sort people by height in ascending order
		Arrays.sort(people, (new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		}));
		

		return null;
		
	}
}
