package codeval;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		LEFT = "left";
		RIGHT = "right";
		NONE = "none";
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

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("/home/akshay/Desktop/pokerhand.input")));) {
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
				SortCard(leftHand);
				SortCard(rightHand);
				//System.out.println("Left Hand Sorted : " + Arrays.toString(leftHand) + " Right Hand Sorted: "
				//		+ Arrays.toString(rightHand));

			//	System.out.println("High card : " + HighCard(leftHand, rightHand));

				int leftRank = checkRanks(leftHand), rightRank = checkRanks(rightHand);
			//	System.out.println("Rank of Left Hand : " + leftRank + " Rank of Right Hand : " + rightRank);

				if (leftRank > rightRank)
					System.out.println(LEFT);
				else if (rightRank > leftRank)
					System.out.println(RIGHT);
				else {
					if (leftRank == 2 || leftRank == 3)
						System.out.println(checkSamePair(leftHand, rightHand));
					else
						System.out.println(HighCard(leftHand, rightHand));
				}
				//System.out.println();
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
			while (j > 0 && (cardValues.get(hand[j - 1].charAt(0)) > cardValues.get(temp.charAt(0)))) {
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
			if ((cardValues.get(hand[i].charAt(0)) == cardValues.get(hand[i + 1].charAt(0)))
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
	 */
	private static boolean nOfAKind(String[] hand, int n) {
		int count = 1;

		for (int i = 0; i < 4; i++) {
			if ((cardValues.get(hand[i].charAt(0)) == cardValues.get(hand[i + 1].charAt(0)))) {
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
	 */
	private static boolean straight(String[] hand) {
		for (int i = 0; i < 4; i++) {
			if (cardValues.get(hand[i + 1].charAt(0)) - cardValues.get(hand[i].charAt(0)) != 1)
				return false;
		}
		return true;
	}

	/**
	 * Royal Flush
	 */
	private static boolean royalFlush(String[] hand) {
		if (straight(hand) && flush(hand) && (hand[0].charAt(0) == 'T')) {
			return true;
		}
		return false;
	}

	/**
	 * Check Ranks
	 */
	private static int checkRanks(String[] hand) {
		/* For Rank */

		/* Royal Flush */
		if (royalFlush(hand))
			return 10;

		/* Straight Flush */
		boolean straight = straight(hand);
		boolean flush = flush(hand);

		if (straight && flush)
			return 9;

		/* Four of a Kind */
		boolean onepair = checkPair(hand, 1);
		boolean threeOfKind = nOfAKind(hand, 3);

		if (onepair && threeOfKind && nOfAKind(hand, 4))
			return 8;

		/* Full House */
		boolean twopair = checkPair(hand, 2);

		if (twopair && threeOfKind)
			return 7;

		/* Flush */
		if (flush)
			return 6;

		/* Straight */
		if (straight)
			return 5;

		/* Three of A Kind */
		if (threeOfKind)
			return 4;

		/* Two Pair */
		if (twopair)
			return 3;

		/* One Pair */
		if (onepair)
			return 2;

		return 0;

	}

	/* Same Ranks in Pair */
	private static String checkSamePair(String[] left, String[] right) {
		ArrayList<Integer> leftAL = new ArrayList<>(2);
		ArrayList<Integer> rightAL = new ArrayList<>(2);
		int pair = (checkPair(left, 2) && checkPair(right, 2)) ? 2 : 1;

		int lcount = 0, rcount = 0;
		for (int i = 0; i < 4; i++) {
			if ((cardValues.get(left[i].charAt(0)) == cardValues.get(left[i + 1].charAt(0)))
					&& !leftAL.contains(cardValues.get(left[i].charAt(0))) && lcount != pair) {
				leftAL.add(cardValues.get(left[i].charAt(0)));
				lcount++;
			}
			if ((cardValues.get(right[i].charAt(0)) == cardValues.get(right[i + 1].charAt(0)))
					&& !rightAL.contains(cardValues.get(right[i].charAt(0))) && rcount != pair) {
				rightAL.add(cardValues.get(right[i].charAt(0)));
				rcount++;
			}
		}
		/*System.out.println("Left " + Arrays.toString(leftAL.toArray()));
		System.out.println("right " + Arrays.toString(rightAL.toArray()));*/

		if ((leftAL.get(0) > rightAL.get(0)))
			return LEFT;
		else if ((leftAL.get(0) < rightAL.get(0)))
			return RIGHT;
		if(pair==2){
			if((leftAL.get(1) > rightAL.get(1)))
				return LEFT;
			else if ((leftAL.get(1) < rightAL.get(1)))
				return RIGHT;
				
		}

		return HighCard(left, right);

	}
}
