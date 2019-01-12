import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？*/

public class Stock {

	private static Scanner scan;

	public static void main(String[] args) {
		int stockPrice = 1;
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		int dayRise = 1;
		int rise = dayRise;
		
		for(int i=1; i<n; i++) {
			
			if(rise > 0) {
				stockPrice++;
				rise--;
			}else {
				stockPrice--;
				dayRise++;
				rise = dayRise; //reassign a new round of rising days
			}
		}
		System.out.println(stockPrice);
	}
}
