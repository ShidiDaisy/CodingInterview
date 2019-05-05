package Set;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
//Union the disjoint set, and find the element in which set
	
	//<Element, Set>
	private Map<Integer, Integer> parent = new HashMap();
	public static void main(String[] args) {
		int[] universe = {1, 2, 3, 4, 5};
		UnionFind uf = new UnionFind();
		
		//create singleton set
		uf.makeSet(universe);
		printSets(universe, uf);
		
		//Union set 4 into 3
		uf.union(4, 3);
		printSets(universe, uf);
		
		uf.union(2, 1);
		printSets(universe, uf);
		
		uf.union(3, 1);
		printSets(universe, uf);
	}
	
	private void makeSet(int[] universe) {
		//create disjoint sets
		for(int i:universe) {
			parent.put(i, i);
		}
	}
	
	public static void printSets(int[] set, UnionFind uf) {
		for(int i:set) {
			System.out.print(uf.find(i) + " ");
		}
		System.out.println();
	}
	
	private int find(int k) {
		//if k is the root
		if(parent.get(k) == k) {
			return k;
		}else {
			//find the set number of its' parent
			return find(parent.get(k));
		}
	}
	
	private void union(int a, int b) {
		//find which set the element belongs to
		int x = find(a);
		int y = find(b);
		
		//Union them
		parent.put(a, b); 
	}
	
	

	

}
