package dp;

import java.util.Scanner;

public class KnapSack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] w = new int[N];
		int[] v = new int[N];
		for (int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int W = sc.nextInt();
		sc.close();
		int _KS[][] = new int[N + 1][W + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (j < w[i - 1]) {
					_KS[i][j] = _KS[i - 1][j];
				} else {
					_KS[i][j] = max(v[i - 1] + _KS[i - 1][j - w[i - 1]], _KS[i - 1][j]);
				}
			}
		}
		/*
		 * for (int i = 0; i < N+1; i++) { for (int j = 0; j < W + 1; j++) {
		 * System.out.print(_KS[i][j]+" "); } System.out.println(); }
		 */
		System.out.println("Max value for weight W = " + W + " is V = " + _KS[N][W]);
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
