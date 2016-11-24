package codeval;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>High Card</b>: Highest value card.<br>
 * <b>One Pair</b>: Two cards of the same value. <br>
 * <b>Two Pairs</b>: Two different pairs.<br>
 * <b>Three of a Kind</b>: Three cards of the same value. <br>
 * <b>Straight</b>: All cards are consecutive values.<br>
 * <b>Flush</b>: All cards of the same suit.<br>
 * <b>Full House</b>: Three of a kind and a pair. <br>
 * <b>Four of a Kind</b>: Four cards of the same value.<br>
 * Straight Flush: All cards are consecutive values of same suit. <br>
 * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.<br>
 * The cards are valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, Ten, Jack, Queen,
 * King, Ace.
 */
public class PokerHands {

	static final String LEFT;
	static final String NONE;
	static final String RIGHT;
	static Map<Character, Integer> cardValues;
	static {
		LEFT = "Left";
		RIGHT = "Right";
		NONE = "None";
		cardValues = new HashMap<Character, Integer>(14, 1) {
			private static final long serialVersionUID = 1L;
			{
				put('1', 1);
				put('2', 2);
				put('3', 3);
				put('4', 4);
				put('5', 5);
				put('6', 6);
				put('7', 7);
				put('8', 8);
				put('9', 9);
				put('T', 10);
				put('J', 11);
				put('Q', 12);
				put('K', 13);
				put('A', 14);
			}
		};
	}

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("D:\\pokerhand.txt")));) {
			String s;
			while ((s = br.readLine()) != null) {
				String[] splitString = s.split(" ");
				String[] leftHand = new String[5], rightHand = new String[5];
				for (int i = 0; i < 10; i++) {
					if (i < 5)
						leftHand[i] = splitString[i];
					else
						rightHand[i - 5] = splitString[i];
				}
				System.out.println("Left Hand: " + Arrays.toString(leftHand)
						+ " Right Hand: " + Arrays.toString(rightHand));
				SortCard(leftHand);
				SortCard(rightHand);
				System.out.println("Left Hand Sorted : "
						+ Arrays.toString(leftHand) + " Right Hand Sorted: "
						+ Arrays.toString(rightHand));
				System.out.println("High card : "
						+ HighCard(leftHand, rightHand));
				boolean leftOnePair = checkPair(leftHand, 1);
				boolean rightOnePair = checkPair(rightHand, 1);
				boolean leftTwoPair = false;
				boolean rightTwoPair = false;
				if (leftOnePair)
					leftTwoPair = checkPair(leftHand, 2);
				if (rightOnePair)
					rightTwoPair = checkPair(rightHand, 2);

				System.out.println("Check OnePair left  & right :"
						+ leftOnePair + " " + rightOnePair);
				System.out.println("Check TwoPair left  & right :"
						+ leftTwoPair + " " + rightTwoPair);

				boolean leftThreeKind = false;
				boolean rightThreeKind = false;
				if (leftOnePair || leftTwoPair)
					leftThreeKind = nOfAKind(leftHand, 3);
				if (rightOnePair || rightTwoPair)
					rightThreeKind = nOfAKind(rightHand, 3);

				System.out.println("Check ThreeOfKind left  & right :"
						+ leftThreeKind + " " + rightThreeKind);

				boolean left4Kind = false;
				boolean right4Kind = false;
				if (leftOnePair && leftThreeKind)
					left4Kind = nOfAKind(leftHand, 4);
				if (rightOnePair && rightThreeKind)
					right4Kind = nOfAKind(rightHand, 4);

				System.out.println("Check 4OfKind left  & right :" + left4Kind
						+ " " + right4Kind);

				System.out.println("Left flush : " + flush(leftHand)
						+ " Right flush : " + flush(rightHand));
				if (leftTwoPair && leftThreeKind)
					System.out.println("Full House Left");
				if (rightTwoPair && rightThreeKind)
					System.out.println("Full House Right");

				System.out.println("Left hand straight " + straight(leftHand));
				System.out
						.println("Right hand straight " + straight(rightHand));

				System.out.println("Left hand straight flush "
						+ (straight(leftHand) && flush(leftHand)));
				System.out.println("Right hand straight flush "
						+ (straight(rightHand) && flush(rightHand)));

				System.out.println("Left hand Royal flush "
						+ royalFlush(leftHand));
				System.out.println("Right hand Royal flush "
						+ royalFlush(rightHand));

				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Sort the cards in the hand.
	 */

	private static String[] SortCard(String[] hand) {
		for (int i = 1; i < 5; i++) {
			int j = i;
			String temp = hand[j];
			while (j > 0
					&& (cardValues.get(hand[j - 1].charAt(0)) > cardValues
							.get(temp.charAt(0)))) {
				hand[j] = hand[j - 1];
				j--;
			}
			hand[j] = temp;
		}
		return hand;

	}

	/**
	 * Get The High Card
	 */
	private static String HighCard(String[] left, String[] right) {
		for (int i = 4; i >= 0; i--) {
			int leftValue = cardValues.get(left[i].charAt(0));
			int rightValue = cardValues.get(right[i].charAt(0));
			// System.out.println(leftValue+" --- "+rightValue);
			if (leftValue > rightValue) {
				return LEFT;
			} else if (leftValue < rightValue)
				return RIGHT;
		}
		return NONE;
	}

	/**
	 * Check for One Pair
	 */
	private static boolean checkPair(String[] hand, Integer pair) {
		int count = 0;
		int paired = 0;
		for (int i = 0; i < 4; i++) {
			if ((cardValues.get(hand[i].charAt(0)) == cardValues
					.get(hand[i + 1].charAt(0)))
					&& paired != cardValues.get(hand[i].charAt(0))) {
				count++;
				paired = cardValues.get(hand[i].charAt(0));
				// System.out.println("paired " + paired);
			}
			if (count == pair)
				return true;
		}
		return false;

	}

	/**
	 * Check Three Of Kind
	 * */
	private static boolean nOfAKind(String[] hand, int n) {
		int count = 1;

		for (int i = 0; i < 4; i++) {
			if ((cardValues.get(hand[i].charAt(0)) == cardValues
					.get(hand[i + 1].charAt(0)))) {
				// System.out.println("in match " + count + " -- " + hand[i]);
				count++;
			} else
				count = 1;
			if (count == n) {
				// System.out.println("count " + count);
				return true;
			}
		}
		return false;
	}

	/**
	 * Flush
	 */
	private static boolean flush(String[] hand) {
		for (int i = 0; i < 4; i++) {
			if (hand[i].charAt(1) != hand[i + 1].charAt(1))
				return false;
		}
		return true;
	}

	/**
	 * Straight
	 * */
	private static boolean straight(String[] hand) {
		for (int i = 0; i < 4; i++) {
			if (cardValues.get(hand[i + 1].charAt(0))
					- cardValues.get(hand[i].charAt(0)) != 1)
				return false;
		}
		return true;
	}

	/**
	 * Royal Flush
	 * */
	private static boolean royalFlush(String[] hand) {
		if (straight(hand) && flush(hand) && (hand[0].charAt(0) == 'T')) {
			return true;
		}
		return false;
	}
}
