package dp;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {

	public static int min(int a, int b, int c) {
		return (a < b && a < c) ? a : ((b < c) ? b : c);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str1 = sc.next().toCharArray();
		char[] str2 = sc.next().toCharArray();
		int[][] _ED = new int[str1.length + 1][str2.length + 1];
		for (int i = 1; i <= str1.length; i++)
			_ED[i][0] = i;
		for (int i = 1; i <= str2.length; i++)
			_ED[0][i] = i;
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					_ED[i][j] = _ED[i - 1][j - 1];
				} else {
					_ED[i][j] = 1 + min(_ED[i][j - 1], _ED[i - 1][j - 1], _ED[i - 1][j]);
				}
			}
		}
		for (int[] a : _ED)
			System.out.println(Arrays.toString(a));

		System.out.println("Minimum cost required to change is " + _ED[str1.length][str2.length]);
	}

}
