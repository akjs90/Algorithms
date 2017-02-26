package Hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GameOfXOR {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			int T = Integer.parseInt(br.readLine().trim());
			while (T > 0) {
				int N = Integer.parseInt(br.readLine().trim());
				long[] _A = new long[N];
				int k = 0;
				for (String a : br.readLine().trim().split(" ")) {
					_A[k++] = Long.parseLong(a);
				}
				long final_xor = 0;
				long xors[][] = new long[N][N];
				for (int len = 0; len <= N; len++) {
					for (int i = 0; i < N-len; i++) {
						int j=i+len;
						if(i==j){
							xors[i][j]=_A[i];
						}
						else{
							xors[i][j]=xors[i][j-1]^xors[j][j];
						}
						final_xor^=xors[i][j];
					}
				}
				for(long[] a:xors){
					System.out.println(Arrays.toString(a));
				}
				System.out.println("Game of XOR is "+final_xor);
				T--;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
