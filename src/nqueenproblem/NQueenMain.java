package nqueenproblem;

import java.util.Scanner;

public class NQueenMain {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.out.println("Enter Number of queens: ");
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.close();
		System.out.println("constructing N x N maze.......");
		//Thread.sleep(2000);
		int maze[][] = new int[N][N];
		solveQueen(maze, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(maze[i][j]+" ");
			System.out.println();
		}
		
	}

	
	static boolean solveQueen(int[][] m, int row) {
		boolean flag=false;
		if(row==m.length)
			return true;
		for (int i = 0; i < m.length; i++) {
			//System.out.println(" Queen " +row+" searching ... at "+i);
			if (checkDiagonal(m, row, i) && checkColumn(m, row, i)) {
				m[row][i] = 1;
				//2System.out.println(" Queen "+ row+ " placed at " +i);
				flag=solveQueen(m, row+1);
				 
			}
			if(flag)
				break;	
			else
				m[row][i] = 0;
			
		}
		return flag;

	}

	private static boolean checkDiagonal(int[][] m, int row, int i) {

		for (int k = 0; k < m.length && k < row; k++) {
			for (int l = 0; l < m.length; l++) {
				if (((k - l) == (row - i)) || ((k + l) == (row + i))) {
					if (m[k][l] == 1)
						return false;
				}
			}
		}

		return true;
	}

	private static boolean checkColumn(int[][] m, int row, int i) {

		int k = 0;
		while (k < row) {
			if (m[k][i] == 1)
				return false;
			k++;
		}
		return true;
	}

}
