package backtrack.permutations;

import java.io.IOException;
import java.util.Scanner;

public class PermutationMain {

	static int f;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str;
		char a[];
		Scanner in = new Scanner(System.in);
		str=in.next();
		a=new char[str.length()];
		for(int i=0;i<str.length();i++)
			a[i]=str.charAt(i);
		//str=in.nextLine();
		in.close();
		permute(a,0,a.length);
		
		
	}
	static void permute(char[] s,int low ,int high){
		if(low==high){
			System.out.println((f+1)+"-> "+String.valueOf(s));f++;
		}
		else{
			for(int i=low; i<high;i++){
				swap(s,i,low);
				permute(s, low+1, high);
				swap(s, i, low);
			}
		}
		
		
	}
	static void swap(char[] s,int pos_1,int pos_2){
		char tmp=s[pos_1];
		s[pos_1]=s[pos_2];
		s[pos_2]=tmp;
		
	}
}
