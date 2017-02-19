package Hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SumOfDigits {
	private static BigInteger sumOfDigits(BigInteger num){
		BigInteger sum=BigInteger.ZERO;
		
			while(!num.equals(BigInteger.ZERO)){
				sum=sum.add(num.mod(BigInteger.TEN));
				num=num.divide(BigInteger.TEN);
			}
			//System.out.println(sum);
		return sum;
	}
	public static void main(String[] args) throws IOException {
		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		line=br.readLine();
		String str[]=line.split(" ");
		BigInteger[] A=new BigInteger[N];
		for(int i=0;i<N;i++){
			A[i]=new BigInteger(str[i].trim());
			System.out.println(sumOfDigits(A[i]));
		}
		
		for(int i=0;i<N;i++){
			
			for(int j=i;j<N;j++){
				if(i==j)
					System.out.println(A[i]);
				else
				System.out.println(A[i]+" "+A[j]);
			}
		}
		byte b=7;
		System.out.println("---> "+(b<<1));
	}
}
