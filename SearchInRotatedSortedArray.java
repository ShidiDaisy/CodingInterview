/*https://blog.csdn.net/ojshilu/article/details/17485787
 * ѭ���������飺

ָ���ǣ���һ����������ѭ����/���ƶ����ɾ���֮���ɵ����顣�磬[1,2,3,4,5]ѭ������3λ���ͳ�Ϊ[4,5,1,2,3]����������ص��ǣ����а�����һ��ת�۵㡣
ת�۵���������������鶼������ģ������������������嶼���Ҳ���������

HINT:
1. �ҵ�ת�۵����м����һ��
 * */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(int A[], int n, int target) {
		int left = 0;
		int right = A.length - 1;
		
		while(left<=right) {
			int mid = left + ((right-left)/2);
			if(A[mid] == target) {
				return mid;
			}
			
			if(A[left] <= A[mid]) {//ת�۵����Ұ�ߣ������ǵ���������
				if(A[left] <= target && target < A[mid]) {
					//target in left side
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}else {
				//ת�۵�������
				if(A[mid] < target && target <= A[right]) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

}
