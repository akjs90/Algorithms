package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {

	static int partition(int[] ar, int low, int high) {
		int pivot = ar[high];
		int j = low;
		for (int i = low; i <= high - 1; i++) {
			if (ar[i] < pivot) {
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
				j++;
			}
		}
		int temp = ar[j];
		ar[j] = ar[high];
		ar[high] = temp;
		printnumbers(ar);
		return j;
	}

	static void quickSort(int[] ar, int low, int high) {
		if (low < high) {
			
			int pi = partition(ar, low, high);
			quickSort(ar, low, pi - 1);
			quickSort(ar, pi + 1, high);
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
		quickSort(ar, 0, ar.length - 1);

		//printnumbers(ar);
	}
	private static void printnumbers(int []a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
