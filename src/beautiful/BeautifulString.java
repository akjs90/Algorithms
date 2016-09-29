/**
 * Program to find beautiful string. 
 * 
 * */

package beautiful;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/*
 * A comparator to sort the list in descending order*/
class xyz implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
}

public class BeautifulString {

	public static void main(String[] args) {
		// buffered reader reads the file change the location in the argument.
		//write code to accept path to the file and pass it down in the reader. 
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("/home/akshay/abc.txt")))) {
			// System.out.println("Reading file");
			String s;
			HashMap<Character, Integer> occurences;// map to store occurrences
													// of each
			while ((s = br.readLine()) != null) {
				occurences = new HashMap<>();
				s = s.toLowerCase();
				for (int i = 0; i < s.length(); i++) {
					char c =  s.charAt(i);
					int count = 1;
					if ((int) c >= 97 && (int) c <= 122) { //ignores punctuation
						if (occurences.containsKey(c)) {
							count = occurences.get(c);
							count++;
						}
						occurences.put(c, count); //puts in the map
					}
				}
				ArrayList<Integer> ar = new ArrayList<Integer>(occurences.values());// gets
																					// value
																					// of
																					// map
				Collections.sort(ar, new xyz());// sorting of the list using the
												// custom comparator above
				// System.out.println(ar);
				int beautyValue = 0;
				int charValue = 26;
				for (Integer integer : ar) {
					beautyValue += integer * (charValue--);
				}
				System.out.println(beautyValue);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
