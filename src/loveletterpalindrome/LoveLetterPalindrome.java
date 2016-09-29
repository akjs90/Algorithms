package loveletterpalindrome;

import java.util.Scanner;

/**
 * <h2>The Love-Letter Mystery</h2>
 * <p>
 * James found a love letter his friend Harry has written for his girlfriend.
 * James is a prankster, so he decides to meddle with the letter. He changes all
 * the words in the letter into <a href=
 * "https://www.hackerrank.com/external_redirect?to=https://en.wikipedia.org/wiki/Palindrome"
 * target="_blank">palindromes</a>.
 * </p>
 * <p>
 * To do this, he follows two rules:
 * </p>
 * <ol>
 * <li>He can reduce the value of a letter, e.g. he can change <em>d</em> to
 * <em>c</em>, but he cannot change <em>c</em> to <em>d</em>.</li>
 * <li>In order to form a palindrome, if he has to repeatedly reduce the value
 * of a letter, he can do it until the letter becomes <em>a</em>. Once a letter
 * has been changed to <em>a</em>, it can no longer be changed.</li>
 * </ol>
 * <p>
 * Each reduction in the value of any letter is counted as a single operation.
 * Find the minimum number of operations required to convert a given string into
 * a palindrome.
 * </p>
 * <p>
 * <strong>Input Format</strong>
 * </p>
 * <p>
 * The first line contains an integer <b>T</b>.<br>
 * The next <b>T</b> lines will contain a string each. The strings do not
 * contain any spaces.
 * </p>
 * <p>
 * <b>Constraints</b>
 * </p>
 * <p>
 * 1<=T<=10 <br>
 * 1<=<i>length of string</i><=10 <sup>4</sup><br>
 * All characters are lower case English letters.
 * </p>
 * <p>
 * <b>Output Format</b>
 * </p>
 * <p>
 * A single line containing the number of minimum operations corresponding to
 * each test case.
 * </p>
 * 
 * @author Akshay Jadhav.
 * @version 1
 * @since 21/09/2016
 */
public class LoveLetterPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		s.nextLine();
		for (int i = 0; i < T; i++) {
			String letter = s.nextLine();
			convertToPlaindrome(letter);
		}
		s.close();

	}
	/**
	 * Prints the number of changes to made on the string to make it palindrome.
	 * @param s*/
	private static void convertToPlaindrome(String s) {
		char[] arr_str = s.toCharArray();
		int mid = s.length() / 2;
		int odd = 0;
		int changes = 0;
		int length = s.length();
		if (length % 2 != 0)
			odd = 1;
		for (int i = length - 1; i >= mid + odd; i--) {
			// System.out.println("compare index "+i);
			if (arr_str[length - 1 - i] != arr_str[i]) {
				changes += Math.abs((int) arr_str[length - 1 - i] - (int) arr_str[i]);

			}

		}

		System.out.println(changes);

	}

}
