import java.util.Scanner;

public class findShortestTime {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String[] time = new String[n];
		for(int i=0; i<n; i++) {
			time[i] = in.nextLine();
		}
	
		//Output
		System.out.println(findShortestTime(time));
	}
	
	public static String findShortestTime(String[] time) {
		int minVal = Integer.MAX_VALUE;
		String min = null;
		
		for(int i=0; i<time.length; i++) {
			String duration = time[i];
			int hours = Integer.parseInt(duration.split(":")[0]);
			int mins = Integer.parseInt(duration.split(":")[1]);
			int secs = Integer.parseInt(duration.split(":")[2]);
			int totalSecs = hours*3600 + mins*60 + secs;
			
			if(totalSecs < minVal) {
				minVal = totalSecs;
				min = duration;
			}
		}
		return min;
	}

}
