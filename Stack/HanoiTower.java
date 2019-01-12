package Stack;

import java.util.Stack;

/*在经典的汉诺塔问题中，有 3 个塔和 N 个可用来堆砌成塔的不同大小的盘子。要求盘子必须按照从小到大的顺序从上往下堆 （如，任意一个盘子，其必须堆在比它大的盘子上面）。
 * 同时，你必须满足以下限制条件：

(1) 每次只能移动一个盘子。
(2) 每个盘子从堆的顶部被移动后，只能置放于下一个堆中。
(3) 每个盘子只能放在比它大的盘子上面。

请写一段程序，实现将第一个堆的盘子移动到最后一个堆中。
https://www.jiuzhang.com/solution/mock-hanoi-tower-by-stacks/
 * */
public class HanoiTower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Tower{
		private Stack<Integer> disks;
		public Tower(int i) {
			disks = new Stack<Integer>();
		}
		
		//Add a disk into this tower
		public void add(int d) {
			if(!disks.isEmpty() && disks.peek() <= d) {
				
			}
		}
	}

}
