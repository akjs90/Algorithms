package codeval;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PokerHands {

	public enum cardValues {
		T(10), J(11), Q(12), K(13), A(14);
		private int value;

		private cardValues(int value) {
			this.value = value;
		}
	};

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("/home/akshay/Desktop/pokerhand.input")));) {
			String s;
			while ((s = br.readLine()) != null) {
				String[] splitString = s.split(" ");
				String[] leftHand = new String[5], rightHand = new String[5];
				for (int i = 0; i < 10; i++) {
					if (i < 5)
						leftHand[i] = (splitString[i].charAt(0)==("T"||"J"||"Q"||"K"||"A"))?:;
					else
						rightHand[i-5] = splitString[i];
				}
				System.out.println("Left Hand: "+Arrays.toString(leftHand)+" Right Hand: "+Arrays.toString(rightHand));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cardValues.valueOf("T").value);

	}
	/**
	 * Sort the cards*/
	/*private static String[] HighCard(String[] hand){
		for(int i=0;i<5;i++){
			int j=i;
			while(j>0){
				if(>hand[j]){
					
				}
			}
		}
		
		return hand;
		
	}*/

}
