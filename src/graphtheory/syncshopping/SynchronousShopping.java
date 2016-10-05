package graphtheory.syncshopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * <h2>Synchronous Shopping</h2>
 * 5 5 5
1 1
1 2
1 3
1 4
1 5
1 2 10
1 3 10
2 4 10
3 5 10
4 5 10
 * */
public class SynchronousShopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt(); //Number of shopping centers (nodes)
		int M=sc.nextInt(); //Number of roads connecting shopping center
		int K=sc.nextInt(); //Number of fishes found in bitvile
		
		int[][] adjMatrix=new int[N][N];// adjaceny matrix undirected graph
		HashMap<Integer,ArrayList<Integer>> shopDesc=new HashMap<>(); //description of shop
				
		for(int i=0;i<N;i++){
			int T=sc.nextInt();
			ArrayList<Integer> al=new ArrayList<>();
			for(int j=0;j<T;j++){
				int A=sc.nextInt();
				al.add(A);				
			}
			shopDesc.put(i+1, al);
		}
		
		for(int i=0;i<M;i++){
			int u=sc.nextInt(); //Shopping center 1
			int v=sc.nextInt(); //Shopping center 2
			int wt=sc.nextInt(); //time taken from 1 to 2
			adjMatrix[u-1][v-1]=adjMatrix[v-1][u-1]=wt; // mark entry in adjaceny matrix. 0...N-1
		}
		
		sc.close();
	}

}
