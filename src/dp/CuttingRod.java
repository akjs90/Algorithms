package dp;

import java.util.Arrays;
import java.util.Scanner;

public class CuttingRod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] prices = new int[N];
		int _CR[] = new int[N + 1];
		for (int i = 0; i < N; i++) {
			prices[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 1; i < N + 1; i++) {
			for (int j = i; j < N + 1; j++) {
				_CR[j] = max(prices[i - 1] + _CR[j - i], _CR[j]);
			}
		}
		System.out.println(Arrays.toString(_CR));
		System.out.println("Maximum Obtaninable value is " + _CR[N]);
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
