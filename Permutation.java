import java.util.ArrayList;
import java.util.List;

/*���ַ�����ѡ��һ���ַ���Ϊ���еĵ�һ���ַ���Ȼ���ʣ����ַ�����ȫ���С���˵ݹ鴦��
 * �Ӷ��õ������ַ���ȫ���С�
 * arrayA[]: 1312
 * */
public class Permutation {

	public static void main(String[] args) {
		int[] arrayA = new int[]{1, 2, 3};
		System.out.println(permuation(arrayA).size());
		System.out.println();
	}
	
	public static List<String> permuation(int[] arrayA){
		List<String> result = new ArrayList<String>();
		recursionArrange(arrayA, 0, result);
		return result;
		
	}
	
	/*
	 * start: ��ʼ�����ַ������������ַ���Ҫ���н�����λ��
     * �������ܣ�����ַ������ֵĸ����ַ�ȫ����
	 * */
	public static void recursionArrange(int[] arrayA, int start, List<String> result) {
		
		int end = arrayA.length - 1;
		if(start == end) {//reach the end
			//print this array
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<arrayA.length; i++) {
				sb.append(arrayA[i]);
			}
			if(!result.contains(sb.toString())){
				result.add(sb.toString());
			}
			
		}else {
			for(int i=start; i<=end; i++) {
				swap(arrayA, start, i);
				recursionArrange(arrayA, start+1, result);//fix 1, permutation 2, 3
				swap(arrayA, start, i);
			}
		}
	}
	
	//exchange the A[m] with A[n] 
	public static void swap(int[] arrayA, int m, int n){
		int temp = arrayA[m];
		arrayA[m] = arrayA[n];
		arrayA[n] = temp;
	}

}
