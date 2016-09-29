package sorting;

import java.util.Scanner;

public class InsertionSortPart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
			arr[i]=sc.nextInt();
		for(int i=1;i<size;i++)
		{
			int j=i;
			int temp=arr[j];
			while(j>0 && arr[j-1]>temp){
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=temp;
			printnumbers(arr);
		}
		//printnumbers(arr);
	}
	
	private static void printnumbers(int []a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
