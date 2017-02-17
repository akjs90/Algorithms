package backtrack;

import java.util.ArrayList;
import java.util.Scanner;

public class CoolNumbers {
	private static ArrayList<Integer> coolNumbers;
	private static ArrayList<Integer> coolNumbers1;
	static{
		coolNumbers=new ArrayList<>();
		coolNumbers1=new ArrayList<>();
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
	    
		sc.close();
		int numb=0;
		for(int j=1;j<=L;j++){
			getCool(numb, j, 0, 2);
			getCool(numb, j, 0, 5);
			coolNumbers1.addAll(coolNumbers);
			coolNumbers.removeAll(coolNumbers);
		}
			//System.err.println(Integer.MAX_VALUE);
			System.out.println("Total Cool Numbers "+coolNumbers1.size());
	}

	private static void getCool(int num, int L, int i, int k) {
		if (i == L) {
			coolNumbers.add(num);
			System.out.println(num);
			return;
		}
		if (i < L && !coolNumbers.contains(num)) {
			num =(num*10)+ k;
			getCool(num, L, i + 1, 2);
			if(i+1<L)
			getCool(num, L, i + 1, 5);
		}
	}
}
