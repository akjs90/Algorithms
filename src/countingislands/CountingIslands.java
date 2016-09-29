package countingislands;

import java.util.Scanner;
import java.util.StringTokenizer;

class CountIsland {
	int graph[][] = new int[5][5];;
	boolean visited[][] = new boolean[5][5];
	static Scanner sc;

	static {
		
		sc = new Scanner(System.in);
	}

	public CountIsland() {
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				visited[i][j] = false;
				graph[i][j] = sc.nextInt();
			}
	}

	void depthSearch(int row, int col) {
		int rowm[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colm[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[row][col] = true;
		for (int x = 0; x < 8; x++) {
			if (checkboundry(row + rowm[x], col + colm[x]))
				depthSearch(row + rowm[x], col + colm[x]);
		}
	}

	// (row+rowm[x]>=0)&&(col+colm[x]>=0)&&(row+rowm[x]<5)&&(col+colm[x]<5)&&!visited[row+rowm[x]][col+colm[x]]&&graph[row+rowm[x]][col+colm[x]]==1
	boolean checkboundry(int valx, int valc) {

		return (valx >= 0) && (valc >= 0) && (valx < 5) && valc < 5 && !visited[valx][valc] && (graph[valx][valc] == 1);
	}

	int countisland() {
		int count = 0;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				if (graph[i][j] == 1 && !visited[i][j]) {
					depthSearch(i, j);
					count++;
				}
			}
		return count;
	}

}

public class CountingIslands {

	public static void some(){
		
	}
	public static void main(String[] args) {
		/*CountIsland c = new CountIsland();
		System.out.println("Total islands: " + c.countisland());
		*/
		String text="Name:Akshay\nEmail:xyz@cc.com\nNumber:92921341";
		StringTokenizer tok= new StringTokenizer(text,"\n");
		String tokens[]=text.split("\n");
		System.out.println(tokens.length+" dfsd "+tok.nextToken());
		System.out.println(tok.nextToken(":"));
		
	}

}
