package dp;

import java.util.Scanner;

/**
 * <p>
 * <em>LCS Problem Statement:</em> Given two sequences, find the length of
 * longest subsequence present in both of them. A subsequence is a sequence that
 * appears in the same relative order, but not necessarily contiguous. For
 * example, �abc�, �abg�, �bdf�, �aeg�, ��acefg�, .. etc are subsequences of
 * �abcdefg�. So a string of length n has 2^n different possible subsequences.
 * </p>
 * <p>
 * <strong>Examples:</strong><br>
 * LCS for input Sequences �ABCDGH� and �AEDFHR� is �ADH� of length 3.<br>
 * LCS for input Sequences �AGGTAB� and �GXTXAYB� is �GTAB� of length 4.<br>
 * <a href="http://www.practice.geeksforgeeks.org/problem-page.php?pid=152"
 * target="_blank" wrc_done="true"><br>
 * </a><span class="wrc0 wrc_icon wrc_injected"></span>
 * </p>
 */
public class LongestCommonSubsequence {
	private static int longest(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int len1 = str1.length();
		int len2 = str2.length();
		sc.close();
		int[][] _LCS = new int[len1 + 1][len2 + 1];

		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					_LCS[i][j] = _LCS[i - 1][j - 1] + 1;
				} else {
					_LCS[i][j] = longest(_LCS[i - 1][j], _LCS[i][j - 1]);
				}
			}
		}
		System.out.println("Longest Common Subsequence is " + _LCS[len1][len2]);

	}
}
