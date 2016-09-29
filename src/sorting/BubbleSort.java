package sorting;

import java.util.Scanner;

public class BubbleSort {

	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-i-1;j++)
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		in.close();
		bubbleSort(ar);
		printnumbers(ar);
	}
	
	private static void printnumbers(int []a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
