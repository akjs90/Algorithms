package figuretowords;

import java.util.HashMap;
import java.util.Scanner;

public class FigureToWordsMain {

	static HashMap<Integer,String> ones;
	static HashMap<Integer,String> tens;
	static HashMap<Integer,String> places;
	static{
		ones = new HashMap<>();
		ones.put(1, "One");
		ones.put(2, "Two");
		ones.put(3, "Three");
		ones.put(4, "Four");
		ones.put(5, "Five");
		ones.put(6, "Six");
		ones.put(7, "Seven");
		ones.put(8, "Eight");
		ones.put(9, "Nine");
		ones.put(10, "Ten");
		ones.put(11, "Eleven");
		ones.put(12, "Twelve");
		ones.put(13, "Thirteen");
		ones.put(14, "Fourteen");
		ones.put(15, "Fifteen");
		ones.put(16, "Sixteen");
		ones.put(17, "Seventeen");
		ones.put(18, "Eighteen");
		ones.put(19, "Ninteen");
		
		tens=new HashMap<>();
		tens.put(1, "Ten");
		tens.put(2, "Twenty");
		tens.put(3, "Thirty");
		tens.put(4, "Fourty");
		tens.put(5, "Fifty");
		tens.put(6, "Sixty");
		tens.put(7, "Seventy");
		tens.put(8, "Eighty");
		tens.put(9, "Ninty");
		
		places=new HashMap<>();
		places.put(1, "Hundered");
		places.put(2, "Thousand");
		places.put(3, "Million");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		Scanner in = new Scanner(System.in);
		number=in.nextInt();
		in.close();
		int temp=number;
		String ans="";
		int val;
		int count=0;
		int innercount = 1;
		while(temp!=0){
			count++;
			if(count == 1){
				val = temp %100;
				if(val!=0){
				if(val < 20)
					ans=ones.get(val)+ans;
				else
				{
					ans=ones.get(val%10)+ans;
					ans=tens.get(val/10)+ans;
				}
				}
				temp = temp/100;
								
			}
			else{
				val = temp%10;
				if(val!=0)
				ans=ones.get(val)+" Hundered "+ans;
				temp/=10;
				count =0;
				innercount++;
				
				if(temp!=0){
					ans=places.get(innercount)+ans;
				}
				
			}
			
			}
		System.out.println(ans);

	}

}
