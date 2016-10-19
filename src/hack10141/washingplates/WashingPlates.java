package hack10141.washingplates;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class WashingPlates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		int k = 0;
		int p[] = null;
		int d[] = null;
		int diff[] = null;
		BigDecimal sum = new BigDecimal(0);

		try (BufferedReader bis = new BufferedReader(
				new InputStreamReader(new FileInputStream("/home/akshay/washingplatesin.txt")))) {
			String s;
			s = bis.readLine();
			n = Integer.parseInt(s.split(" ")[0]);
			k = Integer.parseInt(s.split(" ")[1]);
			p = new int[n];
			d = new int[n];
			diff = new int[n];
			int i = 0;

			System.out.println("reading....");
			while ((s = bis.readLine()) != null) {
				p[i] = Integer.parseInt(s.split(" ")[0]);
				d[i] = Integer.parseInt(s.split(" ")[1]);
				diff[i] = p[i] + d[i];
				sum = sum.add(BigDecimal.valueOf(d[i]));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// Scanner sc = new Scanner(System.in);

		/*
		 * for (int i = 0; i < n; i++) { p[i] = sc.nextInt(); d[i] =
		 * sc.nextInt(); diff[i] = p[i] - d[i]; }
		 */
		System.out.println("Reading completed...");
		System.out.println("here p  -- " + p.length);
		sortPlates(diff, p, d);

		System.out.println("here diff" + diff[n - 1]);
		System.out.println("here pay" + p[n - 1]);
		System.out.println("here ded" + d[n - 1]);

		BigDecimal sum_diff = new BigDecimal(0);
		
		
		if (k >= n) {
			for (int i : diff) {
				sum = sum.subtract(BigDecimal.valueOf(i));

			}

		} else if (k != 0) {
			for (int i = 0; i < k; i++) {
				// System.out.println("added "+p[i]);
				sum = sum.add(BigDecimal.valueOf(p[i]));

			}
			for (int i = k; i < n; i++) {
				// System.out.println("deducted "+d[i]);
				sum = sum.subtract(BigDecimal.valueOf(d[i]));
			}
		}
		/*
		 * if(sum.intValue()<0) System.out.println("0"); else
		 */
		if (sum.compareTo(BigDecimal.ZERO) < 0)
			System.out.println("0");
		System.out.println(sum.toString());

	}

	private static void sortPlates(int[] diff, int[] pay, int[] ded) {
		// System.out.println("inside");
		int temp = diff[0];
		int j = 0;
		for (int i = 1; i < diff.length; i++) {
			j = i;
			temp = diff[i];
			// int pay_tmp = pay[i];
			// int ded_tmp = ded[i];
			while (j > 0 && diff[j - 1] < temp) {
				/*
				 * if (diff[j - 1] == temp) { if (pay[j - 1] < pay_tmp) { pay[j]
				 * = pay[j - 1]; ded[j] = ded[j - 1]; diff[j] = diff[j - 1];
				 * j--; } } else {
				 */
				// pay[j] = pay[j - 1];
				// ded[j] = ded[j - 1];
				diff[j] = diff[j - 1];
				j--;
				// }

			}
			diff[j] = temp;
			// pay[j] = pay_tmp;
			// ded[j] = ded_tmp;

			// System.out.println("here pay" + Arrays.toString(pay));
			// System.out.println("here ded" + Arrays.toString(ded));

		}

	}
	
	private static void sortQuick(int[] diff, int[] pay, int[] ded,int low,int high){
		int pi=partition(diff, low, high);
		sortQuick(diff, pay, ded, low, pi-1);
		sortQuick(diff, pay, ded, pi+1, high);
	}
	
	private static int partition(int[] diff,int low,int high){
		int pivot=diff[high];
		int j=low;
		for(int i=low;i<high;i++){
			if(diff[i]<pivot){
				int t=diff[j];
				diff[j]=diff[i];
				diff[i]=t;
				j++;
			}
		}
	}

}
