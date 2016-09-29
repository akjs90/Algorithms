package sorting;

import java.util.Scanner;

public class SelectionSort {

	private static void sortBySelection(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int min_id=i;
			for(int j=i+1;j<arr.length;j++)
				if(arr[j]<arr[min_id])
					min_id=j;
			int temp=arr[min_id];
			arr[min_id]=arr[i];
			arr[i]=temp;
			printnumbers(arr);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		in.close();
		sortBySelection(ar);
		
	}

	private static void printnumbers(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}
