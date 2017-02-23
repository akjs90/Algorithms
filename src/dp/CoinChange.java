package dp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine();
            int maxValue = Integer.parseInt(line.split(" ")[0].trim());
            int N = Integer.parseInt(line.split(" ")[1].trim());
			int coins[] = new int[N];
			line = br.readLine();
			int k = 0;
			for (String s : line.split(" ")) {
				coins[k++] = Integer.parseInt(s.trim());
			}
			//int maxValue = Integer.parseInt(br.readLine().trim());
			long[][] _CCM = new long[N + 1][maxValue + 1];
			//Arrays.sort(coins);
			_CCM[0][0] = 1;
			for (int i = 1; i < N + 1; i++) {
				for (int j = 0; j < maxValue + 1; j++) {
					if (j<coins[i - 1] )
						_CCM[i][j] = _CCM[i - 1][j];
					else {
						_CCM[i][j] = _CCM[i][j - coins[i - 1]] + _CCM[i - 1][j];
					}
				}
			}
			System.out.println(_CCM[N][maxValue]);
			//System.out.println();
			/*for(int i=1;i < N + 1; i++){
				System.out.print(coins[i-1]+" ");
				for (int j = 0; j < maxValue + 1; j++) {
					System.out.print(" "+_CCM[i][j]);
				}
				System.out.println();
			}*/

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
