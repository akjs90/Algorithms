package dp;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] _A = new int[N];
		int[] _MSIS = new int[N];
		for (int i = 0; i < N; i++){
			_MSIS[i]=_A[i] = sc.nextInt();
		}			
		sc.close();
		int maxsum=_MSIS[0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (_A[i] > _A[j]) {
					_MSIS[i]=max(_MSIS[i],_MSIS[j]+_A[i]);
					maxsum=max(_MSIS[i], maxsum);
				}
			}
		}
		System.out.println(Arrays.toString(_MSIS));
		System.out.println(maxsum);

	}

}
