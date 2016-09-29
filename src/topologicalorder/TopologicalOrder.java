package topologicalorder;

import java.util.Arrays;
import java.util.Scanner;

class Node{
	int data;
	Node childrens;
	public Node(int data){
		this.data=data;
	}
}
public class TopologicalOrder {
	static int[][] graph;
	static int N,M;
	static boolean visited[];
	private static void initialise(){
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		graph=new int[N][N];
		visited=new boolean[N];
		for(int i=0;i<M;i++)
			graph[sc.nextInt()-1][sc.nextInt()-1]=1;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++)
				System.out.print(graph[i][j]+" ");
			System.out.println();
		}
		sc.close();
		
	}
	private static void findTopology(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialise();

	}

}
