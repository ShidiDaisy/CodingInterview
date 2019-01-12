package Math;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*给定一个由a－z字母组成的二维矩阵，求从其中某一点出发，沿着上下左右四个方向前进，是否可以找出某个单词。某个字母不能重复使用。
 * 输入描述:
输入第一行为两个整数m和n,接下来是m行,每行n个a-z中的字母。最后一行是要查找的单词,单词由a-z字符组成。其中: 0<
m, n <= 100
输出描述:
输出一行,
true表示可以找到;
false表示不
示例1
输入:
4 4
abed
efgh
ijkl
mnop
ok

输出:
true

example2:
5 5
abcde
fghij
pklmn
popqr
apple
apple

return: true
 
 Hint: 深度优先
 * 
 * */
class Pair{
	int x;
	int y;
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class FindEnglishWords {
	
	public static int m;
	public static int n;
	public static String[][] matrix;
	public Stack<Pair> visitedPair = new Stack<Pair>();
	public String[] wordChars;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        matrix = new String[m][n];
        
        for(int i=0; i<m; i++){
    		String line = sc.next();
        	for(int j=0; j<n; j++){
        		matrix[i][j] = String.valueOf(line.charAt(j));
        	}
        }
        
        String word = sc.next();
        
        FindEnglishWords fw = new FindEnglishWords();
        System.out.println(fw.depthFirstSearch(m, n, matrix, word));

	}
	
	public boolean depthFirstSearch(int m, int n, String[][] matrix, String word){
		boolean[][] isVisited = new boolean[m][n]; //default value is false
		
		//word string to array
		wordChars = new String[word.length()];
		for(int i=0; i<word.length(); i++){
			wordChars[i] = word.substring(i, i+1);
		}
		
		//Find first word
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				//find first character
				if(matrix[i][j].equals(wordChars[0])){
					visitedPair.add(new Pair(i, j));
					if(depthFirstSearch(i, j, 1, isVisited)){
						return true;
					}else{
						isVisited[i][j] = false;
						visitedPair.clear();
						continue;
					}
				}
			}
		}
		return false;
	}

	private boolean depthFirstSearch(int i, int j, int charNum, boolean[][] isVisited) {
		isVisited[i][j] = true;
		ArrayList<Pair> neighbors = new ArrayList<Pair>(getNeighbors(i, j, isVisited));
		
		if(!neighbors.isEmpty()){
			for(Pair nei:neighbors){
				if(matrix[nei.x][nei.y].equals(wordChars[charNum])){
					if(charNum == wordChars.length-1){
						return true;
					}else{
						visitedPair.add(new Pair(nei.x, nei.y));
						return depthFirstSearch(nei.x, nei.y, charNum+1, isVisited);
					}
				}
			}
			
			if(visitedPair.size() > 1){
				visitedPair.pop();
				Pair lastPos = visitedPair.peek(); 
				return depthFirstSearch(lastPos.x, lastPos.y, charNum-1, isVisited);
			}else{
				return false;
			}
		}
		
		return false;
	}

	private ArrayList<Pair> getNeighbors(int x, int y, boolean[][] isVisited) {
		int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        ArrayList<Pair> neighbors = new ArrayList<Pair>();
        
        for(int i=0; i<4; i++){
        	int nextX = x + dx[i];
        	int nextY = y + dy[i];
        	if(nextX < 0 || nextX > m-1 || nextY < 0 || nextY > n-1 || isVisited[nextX][nextY]){
        		continue;
        	}else{
        		neighbors.add(new Pair(nextX, nextY));
        	}
        }
        
		return neighbors;
	}

}
