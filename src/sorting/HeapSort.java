package sorting;

import java.util.Scanner;

public class HeapSort {

	/**
	 * Min heap for ascending order and Max heap for descending order
	 * @param arr - to be sorted
	 * @param index - position for heapify 
	 * */
	private static void heapify(int[] arr,int index){//Construct min or max heap
		int right=2*index+2;
		int left=2*index+1;
		
		if(left>arr.length-1)
			return;
		heapify(arr, left);
		
		//System.out.println("Left "+left+" right "+right);
		//System.out.println("checking now sides for index "+arr[index]);
		if( arr[left]<arr[index])	//change signs for max heap
		{	int t=arr[index];
			arr[index]=arr[left];
			arr[left]=t;
			heapify(arr, left);
			//System.out.println("heapify : "+index);
		}
		
		if(right>arr.length-1)
			return;
		heapify(arr,right);
		if( arr[right]<arr[index]){//change signs for max heap
			int t=arr[index];
			arr[index]=arr[right];
			arr[right]=t;
			heapify(arr,right);
			//System.out.println("heapify : "+index);
		}
		//printnumbers(arr);
	}
	//11 10 9 5 8 3 7 1 2 6 4 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		in.close();
		//heapify(ar, 1);
		heapify(ar, 0);
		
		for(int i=0;i<ar.length;i++){
			System.out.print(ar[0]+"  ");
			ar[0]=ar[ar.length-i-1];
			/*
			 * Give a large value for sorting in ascending order else smaller value otherwise*/
			ar[ar.length-i-1]=99999;
			//printnumbers(ar);
			heapify(ar,0);
			//printnumbers(ar);
		}
		//heapify(ar, 2);
		//printnumbers(ar);
	}

	private static void printnumbers(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

}
