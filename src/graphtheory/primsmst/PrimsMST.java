package graphtheory.primsmst;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To find minimum spanning tree prims algorithm*/
public class PrimsMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // Number of s (nodes)
		int M = sc.nextInt(); // Number of edges
		int adjMat[][] = new int[N][N];
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int wt = sc.nextInt();
			adjMat[u-1][v-1] = adjMat[v-1][u-1] = wt;
		}
		int parent[] = new int[N];
		ArrayList<Integer> mst = new ArrayList<>();
		int distance[] = new int[N];
		for (int i = 0; i < N; i++)
			distance[i] = Integer.MAX_VALUE;
		int start = sc.nextInt();
		distance[start - 1] = 0;
		parent[start - 1] = -1;
		for (int count = 0; count < N; count++) {
			int min_node=findMin(distance, mst);
			mst.add(min_node+1);
			for(int v=0;v<N;v++){
				if(adjMat[min_node][v]!=0 && !mst.contains(v+1) && distance[v]>adjMat[min_node][v] ){
					parent[v]=min_node;
					distance[v]=adjMat[min_node][v];
				}
			}
		}
		
		int sum=0;
		for(int i:mst){
			/*if(parent[i-1]==-1)
				System.out.println(i+" is root");
			else
			System.out.println(i+ " parent is "+ (parent[i-1]+1) +" distance is "+distance[i-1]);*/
			sum+=distance[i-1];
		}
		System.out.println(sum);
	}

	private static int findMin(int[] distance, ArrayList<Integer> mst) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;

		for (int i = 0; i < distance.length; i++) {
			if (!mst.contains(i + 1) && distance[i] < min) {
				min = distance[i];
				min_index = i;
			}
		}
		
		return min_index;
	}

}
