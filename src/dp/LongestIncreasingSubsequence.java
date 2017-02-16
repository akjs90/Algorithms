package dp;

import java.util.Scanner;

/**
 * @author Akshay Find Longest non decreasing subsequence
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] _LIS = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = sc.nextInt();
		sc.close();
		_LIS[0] = 1; // length of first string is 1
		for (int i = 1; i < N; i++) {
			_LIS[i] = 1; // Initial length
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && _LIS[i] < _LIS[j] + 1) // for each 0<=j<i
															// a[i] > a[j] and
															// LCS[j]+1>LCS[i]
					_LIS[i] = _LIS[j] + 1;
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			if (_LIS[i] > max)
				max = _LIS[i];
		}
		System.out.println("Length Of Longest Increasing Subsequence Is " + max);
	}
}
