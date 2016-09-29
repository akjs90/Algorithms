package maxrangesum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * <h2>MAX RANGE SUM</h2>
 * <h4>CHALLENGE DESCRIPTION:</h4>
 *<p>Bob is developing a new strategy to get rich in the stock market. He wishes to invest his portfolio for 1 or more days, then sell it at the right time to maximize his earnings. Bob has painstakingly tracked how much his portfolio would have gained or lost for each of the last N days. Now he has hired you to figure out what would have been the largest total gain his portfolio could have achieved.</p>
 *For example:
 *<p>Bob kept track of the last 10 days in the stock market. On each day, the gains/losses are as follows:</p>
 *7 -3 -10 4 2 8 -2 4 -5 -2
 *<p>If Bob entered the stock market on day 4 and exited on day 8 (5 days in total), his gains would have been</p>
 *16 (4 + 2 + 8 + -2 + 4)
 *<h4>INPUT SAMPLE:</h4>
 *<p>The input contains N, the number of days (0 < N < 10000), followed by N (separated by symbol ";") integers D (-10000 < D < 10000) indicating the gain or loss on that day.</p> 
 *For example:
 *<pre>
 *5;7 -3 -10 4 2 8 -2 4 -5 -2
 *6;-4 3 -10 5 3 -7 -3 7 -6 3
 *3;-7 0 -45 34 -24 7
 *</pre>
 *<h4>OUTPUT SAMPLE:</h4>
 *<p>Print out the maximum possible gain over the period. If no gain is possible, print 0.</p>
 *For example:
 *<pre>
 *16
 *0
 *17
 *</pre>
 * */
public class MaxRangeSum {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("/home/akshay/input.txt")))) {
			String s;
			while ((s = br.readLine()) != null) {
				String[] array = s.split(";");
				int noofdays = Integer.parseInt(array[0]);
				String[] ar = array[1].split(" ");
				int max_sum = 0;
				for (int i = 0; i <= ar.length - noofdays; i++) {
					int j = 0;
					int sum = 0;
					while (j < noofdays) {
						sum += Integer.parseInt(ar[i + j]);
						j++;
					}
					if (sum > max_sum)
						max_sum = sum;
				}
				System.out.println(max_sum);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
