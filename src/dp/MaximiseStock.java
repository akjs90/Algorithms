package dp;

import java.math.BigDecimal;
import java.util.Scanner;

public class MaximiseStock {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int T = sc.nextInt();
			while (T > 0) {
				int N = sc.nextInt();
				int S[] = new int[N];
				for (int i = 0; i < N; i++)
					S[i] = sc.nextInt();
				int[][] stock = new int[2][N];
				BigDecimal total_bought = new BigDecimal(0);
				BigDecimal total_sold = new BigDecimal(0);

				for (int i = 0; i < N; i++) {
					for (int j = i + 1; j < N; j++) {
						if (S[i] < S[j]) {
							if (i == 0) {
								stock[0][i] = 1;
							} else
								stock[0][i] = stock[0][i - 1] + 1;
							break;
						}
					}
					if (i > 0 && stock[0][i] == 0 && stock[0][i - 1] != 0)
						stock[1][i] = stock[0][i - 1];
					if (i == N - 1 && stock[0][i - 1] > 0) {
						stock[1][i] = stock[0][i - 1];
					}

					if (stock[0][i] > 0)
						total_bought = total_bought.add(BigDecimal.valueOf(S[i]));
					if (stock[1][i] > 0)
						total_sold = total_sold.add(BigDecimal.valueOf(S[i]).multiply(BigDecimal.valueOf(stock[1][i])));
				}
				System.out.println(total_sold.subtract(total_bought));
				T--;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
