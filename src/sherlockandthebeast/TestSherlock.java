package sherlockandthebeast;

/**
 * @author akshay
 * <p>Sherlock Holmes suspects his archenemy, Professor Moriarty, is once again plotting something diabolical. Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their supercomputer, <em>The Beast</em>. </p>
 * <p>Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting <em>The Beast</em> with a virus; however, he also gives him a clue—a number,<i>N</i>. Sherlock determines the key to removing the virus is to find the largest <em>Decent Number</em> having <i>N</i> digits.</p>
 * <p>A <em>Decent Number</em> has the following properties:</p>
 * <ol><li>Its digits can only be <em>3</em>'s and/or <em>5</em>'s.</li><li>The number of <em>3</em>'s it contains is divisible by <em>5</em>.</li><li>The number of <em>5</em>'s it contains is divisible by <em>3</em>.</li><li>If there are more than one such number, we pick the largest one. </li></ol>
 * <p>Moriarty's virus shows a clock counting down to <em>The Beast</em>'s destruction, and time is running out fast. Your task is to help Sherlock find the key before <em>The Beast</em> is destroyed!</p>
 * */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

class SherlockAndBeast {
	static int THREE = 3;
	static int FIVE = 5;

	public void getDescentNumber() {
		BigInteger num, tempnum;
		int i = 1;
		int rem = 0;
		boolean fl = true;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>();
		while (n > 0) {
			al.add(sc.nextInt());
			n--;
		}

		for (int dig : al) {
			int digits = dig;
			i = 1;
			num = new BigInteger("0");
			tempnum = new BigInteger("0");
			int temp = digits / THREE;// FIVE;
			rem = digits % THREE;// FIVE;

			while (rem % FIVE != 0 && fl && temp != 0)
				rem = digits - (--temp * THREE);

			if (temp == 0) {
				rem = 0;
				num = new BigInteger("-1");
			}

			while (i <= temp * THREE) {
				num = num.multiply(BigInteger.TEN);
				num = num.add(BigInteger.valueOf(5));
				i++;
			}
			i = 1;
			while (i <= rem) {
				num = num.multiply(BigInteger.TEN);
				num = num.add(BigInteger.valueOf(3));
				i++;
			}

			tempnum = num;
			num = new BigInteger("0");
			if (digits % FIVE == 0) {
				while (i <= digits) {
					num = num.multiply(BigInteger.TEN);
					num = num.add(BigInteger.valueOf(3));
					i++;

				}
			}
			if (num.compareTo(tempnum) > 0 && !num.equals(new BigInteger("0")))
				tempnum = num;

			else
				num = tempnum;

			System.out.println(num.toString());
		}
		sc.close();
	}
}

public class TestSherlock {

	public static void main(String... args) {
		// TODO Auto-generated method stub
		new SherlockAndBeast().getDescentNumber();
	}

}
