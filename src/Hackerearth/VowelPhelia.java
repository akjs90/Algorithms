package Hackerearth;

import java.util.Scanner;

public class VowelPhelia {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int N = sc.nextInt();
			String s = sc.next();
			int count=0;
			int V[][] = new int[N - 2][N+1];
			for (int i = 0; i < N - 2; i++) {
				for (int j = i; j < N; j++) {
					if (s.charAt(j) == 'a' || s.charAt(j) == 'e'
							|| s.charAt(j) == 'i' || s.charAt(j) == 'o'
							|| s.charAt(j) == 'u') {
						V[i][j+1] = V[i][j]+1;
						
					}
					else
					{
						V[i][j+1] = V[i][j];
					}
					if(V[i][j+1]==3)
						count++;
				}
			}
			System.out.println(count);
			T--;
		}
	}
}
