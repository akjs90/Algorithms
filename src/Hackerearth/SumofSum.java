package Hackerearth;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class SumofSum {

	private static BigInteger sumOfDigits(BigInteger num){
		BigInteger sum=BigInteger.ZERO;
		if(num.divide(BigInteger.TEN).equals(BigInteger.ZERO)){

			return num;
		}
		else
		{
			while(!num.equals(BigInteger.ZERO)){
				sum=sum.add(num.mod(BigInteger.TEN));
				num=num.divide(BigInteger.TEN);
			}
			//System.out.println(sum);
		}
		return sumOfDigits(sum);
	}
	
	public static void main(String[] args) {
		//System.out.println(sumOfDigits(193));
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int Q=sc.nextInt();
		BigInteger A[]=new BigInteger[N];
		for(int i=0;i<N;i++){
			A[i]=sumOfDigits(sc.nextBigInteger());
		}
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		sc.nextLine();
		for(int i=0;i<N;i++){
			int opt=sc.nextInt();
			int K=sc.nextInt();
			if(opt==1){
				BigInteger max=new BigInteger("0");
				int j=1;
				while(j<=K){
					max=max.add(A[N-j]);
					j++;
					
				}
				System.out.println(max.toString());
			}
			else if(opt==2){
				BigInteger min=new BigInteger("0");
				int j=1;
				while(j<=K){
					min=min.add(A[j-1]);
					j++;
				}
				System.out.println(min);
			}
		}
		sc.close();
		
	}

}
