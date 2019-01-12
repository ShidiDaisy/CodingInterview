import java.util.HashMap;
import java.util.Map;

public class Guru_Interview {

	public static void main(String[] args) {
		System.out.println(solution("00:01:07,400-234-090\n" + 
				"00:05:01,701-080-080\n" + 
				"00:05:00,400-234-090"));

	}
	
	public static int solution(String S) {
		//Split the strings
		String[] lines = S.split("\n");
		Map<String,Integer> numToTime = new HashMap<String, Integer>();
		Map<String,Double> numToPay = new HashMap<String, Double>();
		
		int totalPay=0;
		for(String line:lines) {
			String duration = line.split(",")[0];
			String number = line.split(",")[1];
			int hours = Integer.parseInt(duration.split(":")[0]);
			int mins = Integer.parseInt(duration.split(":")[1]);
			int secs = Integer.parseInt(duration.split(":")[2]);
			int totalSecs = hours*3600 + mins*60 + secs;
			double payAmount = 0;
			
			//Calculate the amount for each entry
			if(totalSecs < 300) {
				payAmount = totalSecs * 3;
			}else{
				payAmount = Math.ceil((double)totalSecs/60) * 150;
			}
			
			totalPay = (int) (totalPay + payAmount);
			
			if(!numToTime.containsKey(number)) {
				numToTime.put(number, totalSecs);
				numToPay.put(number, payAmount);
			}else {
				numToTime.put(number, numToTime.get(number) + totalSecs);
				numToPay.put(number, numToPay.get(number) + payAmount);
			}
				
		}
		
		//Get the free call
		Map.Entry<String, Integer> maxEntry = null;
		for(Map.Entry<String, Integer> entry:numToTime.entrySet()){
			if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}else if(entry.getValue().compareTo(maxEntry.getValue()) == 0) {
				maxEntry = maxEntry;
			}
		}
		
		totalPay = (int) (totalPay - numToPay.get(maxEntry.getKey()));
		
		return totalPay;
    }

}
