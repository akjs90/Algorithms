package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinomialCoefficient {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine();
			int N = Integer.parseInt(line.split(" ")[0].trim());
			int k = Integer.parseInt(line.split(" ")[1].trim());
			int _BC[][] = new int[k + 1][N];
			for (int i = 0; i <= k; i++) {
				for (int j = 0; j < N; j++) {
					if (i == 0 || (i == j + 1)) {
						_BC[i][j] = 1;
					} else if (j + 1 > i) {
						_BC[i][j] = _BC[i][j - 1] + _BC[i - 1][j - 1];
					}
				}
			}
			/*
			 * for(int[] a:_BC){ System.out.println(Arrays.toString(a)); }
			 */
			System.out.println("Binomial coefficient of C(" + N + "," + k + ") = " + _BC[k][N - 1]);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
