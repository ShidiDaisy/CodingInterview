import java.util.Map;
import java.util.HashMap;

class Yitu_Interview1 {
	public static void main(String args[]) {
		int[] A = new int[]{1, 1, 0, 0, 1};
        removeElement(A);
	}

    public static int removeElement(int[] A){
        Map<Integer, Integer> posToCount = new HashMap<Integer, Integer> ();
        int lastElem = -1;
        for(int i=0; i<A.length; i++){
            if(A[i] == lastElem){
                posToCount.put(i, posToCount.get(i) + 1);
            }else{
                posToCount.put(i, 1);
            }
            lastElem = A[i];
        }

        Map<Integer, Integer> neigCounts = new HashMap<Integer, Integer>();
        for(Map.Entry pair:posToCount.entrySet()){
            //if(neigCounts.containsKey(pair.getKey())){
              
            //}
            //posToCount.
        }
		return 0;

    }
}
