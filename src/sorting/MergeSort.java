package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	private static void mergesort(int[] arr,int low,int high){
		if(low>=high)
			return;
		int mid=(low+high)/2;
		mergesort(arr,low,mid);
		mergesort(arr,mid+1,high);
		merge(arr,low,mid,high);
		
	}
	private static void merge(int[] arr,int low,int mid,int high){
		
		int[] larr=new int[mid-low+1];
		int[] harr=new int[high-mid];
		for(int i=0;i<larr.length;i++){
			larr[i]=arr[low+i];
		}
		for(int i=0;i<harr.length;i++){
			harr[i]=arr[mid+1+i];
		}
		int i=0;
		int j=0;
		//System.out.println("Lower and higher array "+i+" "+j);
		printnumbers(larr);
		printnumbers(harr);
		

		int k=low;
		while(i <larr.length && j <harr.length){
			if(larr[i]<harr[j]){
				arr[k]=larr[i];
				i++;
			}
			else{
				arr[k]=harr[j];
				j++;
			}			
			k++;
		}
		
		while(i < larr.length){
			arr[k]=larr[i];
			i++;
			k++;
		}
		
		while(j <harr.length){
			arr[k]=harr[j];
			j++;
			k++;
		}
		//System.out.println("partial sorted array "+Arrays.toString(arr));
		printnumbers(arr);
	}
	
	
	private static void swap(int []arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
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
		mergesort(ar,0,ar.length-1);
		printnumbers(ar);
	}
	private static void printnumbers(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

}
