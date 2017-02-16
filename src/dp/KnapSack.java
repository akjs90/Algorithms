package dp;

import java.util.Scanner;

public class KnapSack {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();
	int[] w=new int[N];
	int[] v=new int[N];
	for(int i=0;i<N;i++){
		w[i]=sc.nextInt();
		v[i]=sc.nextInt();
	}
	int W=sc.nextInt();
	sc.close();
	int _KS[][]=new int[N][W+1];
	for(int i=0;i<N;i++){
		for(int j=1;j<W+1;j++){
			if(j>=w[i]){
				_KS[i][j]=v[i];
			}
		}
	}
}
}
