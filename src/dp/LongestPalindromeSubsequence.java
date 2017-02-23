package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestPalindromeSubsequence {
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine();
			int N = line.length();
			int _LPS[][] = new int[N][N];
			for (int len = 0; len <= N; len++) {
				for (int i = 0; i < N - len; i++) {
					int j = i + len;
					if (len == 0) {
						_LPS[i][j] = 1;
					} else if (line.charAt(i) == line.charAt(j)) {
						_LPS[i][j] = _LPS[i + 1][j - 1] + 2;
					} else {
						_LPS[i][j] = max(_LPS[i][j - 1], _LPS[i + 1][j]);
					}
				}
			}
			/*
			 * for(int[] a:_LPS){ System.out.println(Arrays.toString(a)); }
			 */
			System.out.println("Length of longest palindrome subsequence " + _LPS[0][N - 1]);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
