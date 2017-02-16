package dp;

import java.util.Scanner;

/**
 * @author akshay
 *         <h3>Problem Statement</h3>
 *         <p>
 *         A sequence of numbers is called a <i>zig-zag sequence</i> if the
 *         differences between successive numbers strictly alternate between
 *         positive and negative. The first difference (if one exists) may be
 *         either positive or negative. A sequence with fewer than two elements
 *         is trivially a zig-zag sequence.
 *         </p>
 *         <p>
 *         For example, 1,7,4,9,2,5 is a zig-zag sequence because the
 *         differences (6,-3,5,-7,3) are alternately positive and negative. In
 *         contrast, 1,4,7,2,5 and 1,7,4,5,5 are <i>not</i> zig-zag sequences,
 *         the first because its first two differences are positive and the
 *         second because its last difference is zero.
 *         </p>
 *         <p>
 *         Given a sequence of integers, <b>sequence</b>, return the length of
 *         the longest subsequence of <b>sequence</b> that is a zig-zag
 *         sequence. A subsequence is obtained by deleting some number of
 *         elements (possibly zero) from the original sequence, leaving the
 *         remaining elements in their original order.
 *         </p>
 */
public class LongestZigZagSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N];
		int[][] _LZS = new int[2][N];
		for (int i = 0; i < N; i++)
			a[i] = sc.nextInt();
		sc.close();
		_LZS[0][0] = 1;
		_LZS[1][0] = 1;

		for (int i = 1; i < N; i++) {
			_LZS[0][i] = 1; // length of subsequence ending with i and a[i-1] <
							// a[i] i.e Longest increasing Subsequence
			_LZS[1][i] = 1; // length of subsequence ending with i and a[i-1] >
							// a[i] i.e. Longest decreasing subsequence
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && _LZS[0][i] < _LZS[1][j] + 1) {
					_LZS[0][i] = _LZS[1][j] + 1;
				} else if (a[i] < a[j] && _LZS[1][i] < _LZS[0][j] + 1) {
					_LZS[1][i] = _LZS[0][j] + 1;
				}
			}
		}

		/*
		 * Find the max in _LZS[0][i] and _LZS[1][i]
		 */
		int i = 0;
		int j = 0;
		int max = 0;
		while (i < N && j < N) {
			if (_LZS[0][i] >= _LZS[1][j] && max < _LZS[0][i]) {
				max = _LZS[0][i];
				j++;
			} else if (_LZS[0][i] < _LZS[1][j] && max < _LZS[1][j]) {
				max = _LZS[1][j];
				i++;
			} else {
				i++;
				j++;
			}
		}

		System.out.println("Length of longest zigzag is " + max);
	}
}
