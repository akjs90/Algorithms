package sorting;

import java.util.Scanner;

public class HeapSort {

	private static void heapify(int[] arr,int index){
		int right=2*index+2;
		int left=2*index+1;
		System.out.println("heapify : "+index);
		if(right>=arr.length && left>=arr.length)
			return;
		heapify(arr, left);
		heapify(arr,right);
		if(arr[left]>arr[right] && arr[left]>arr[index])
		{	int t=arr[index];
			arr[index]=arr[left];
			arr[left]=t;
		}else if(arr[right]>arr[left] && arr[right]>arr[index]){
			int t=arr[index];
			arr[index]=arr[right];
			arr[right]=t;
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
		heapify(ar, 0);
		printnumbers(ar);
	}

	private static void printnumbers(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

}
