package Stack;

import java.util.Stack;

/*�ھ���ĺ�ŵ�������У��� 3 ������ N �����������������Ĳ�ͬ��С�����ӡ�Ҫ�����ӱ��밴�մ�С�����˳��������¶� ���磬����һ�����ӣ��������ڱ�������������棩��
 * ͬʱ�������������������������

(1) ÿ��ֻ���ƶ�һ�����ӡ�
(2) ÿ�����ӴӶѵĶ������ƶ���ֻ���÷�����һ�����С�
(3) ÿ������ֻ�ܷ��ڱ�������������档

��дһ�γ���ʵ�ֽ���һ���ѵ������ƶ������һ�����С�
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
