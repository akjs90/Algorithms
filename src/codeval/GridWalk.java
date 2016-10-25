package codeval;

import java.util.ArrayList;

/**
 * There is a monkey which can walk around on a planar grid. The monkey can move
 * one space at a time left, right, up or down. That is, from (x, y) the monkey
 * can go to (x+1, y), (x-1, y), (x, y+1), and (x, y-1).
 * 
 * Points where the sum of the digits of the absolute value of the x coordinate
 * plus the sum of the digits of the absolute value of the y coordinate are
 * lesser than or equal to 19 are accessible to the monkey. For example, the
 * point (59, 79) is inaccessible because 5 + 9 + 7 + 9 = 30, which is greater
 * than 19. Another example: the point (-5, -7) is accessible because abs(-5) +
 * abs(-7) = 5 + 7 = 12, which is less than 19. How many points can the monkey
 * access if it starts at (0, 0), including (0, 0) itself?
 */
public class GridWalk {
	static class Coordinates {
		int x;
		int y;

		public Coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Coordinates c = (Coordinates) obj;
			return x == c.x && y == c.y;
		}

	}

	static int[] XPos = { 0, 0, 1, -1 };
	static int[] YPos = { 1, -1, 0, 0 };
	static int count = 0;
	static ArrayList<Coordinates> list = new ArrayList<Coordinates>();

	public static void main(String[] args) {
		gridWalk(0, 0);
		System.out.println(count);

	}

	private static void gridWalk(int x, int y) {
		if ((sumOfDigits(x) + sumOfDigits(y)) > 19) {
			return;
		}
		count++;
		list.add(new Coordinates(x, y));
		for (int i = 0; i < 4; i++) {
			if (!list.contains(new Coordinates(x + XPos[i], y + YPos[i])))
				gridWalk(x + XPos[i], y + YPos[i]);
		}

	}

	private static int sumOfDigits(int d) {
		d = Math.abs(d);
		int sum = 0;
		while (d != 0) {
			sum += d % 10;
			d /= 10;
		}
		return sum;
	}

}
