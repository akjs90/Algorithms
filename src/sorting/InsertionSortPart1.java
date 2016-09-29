package sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *sort the rightmost element */
public class InsertionSortPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
			arr[i]=sc.nextInt();
		int temp=arr[size-1];
		int i=size-1;
		while(i>0 && arr[i-1]>temp){
			arr[i]=arr[i-1];
			i--;
			printnumbers(arr);
		}
		arr[i]=temp;
		/*for(int i=size-2;i>=0;i--) //from 2nd last element to first
		{
			if(arr[i]>temp)
				arr[i+1]=arr[i];
			
			else
			{	arr[i]=temp;
			printnumbers(arr);
			break;
			}
			printnumbers(arr);
		}*/
		printnumbers(arr);
	}
	private static void printnumbers(int []a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
