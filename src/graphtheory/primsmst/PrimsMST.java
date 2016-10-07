package graphtheory.primsmst;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To find minimum spanning tree prims algorithm*/
public class PrimsMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // Number of nodes.
		int M = sc.nextInt(); // Number of edges.
		int adjMat[][] = new int[N][N];
		for (int i = 0; i < N; i++) { // initialize adjacency matrix with -1.
			for (int j = 0; j < N; j++)
				adjMat[i][j] = -1;
		}
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int wt = sc.nextInt();
			adjMat[u - 1][v - 1] = adjMat[v - 1][u - 1] = wt; // mark weight for
																// each edge.
		}
		int parent[] = new int[N]; // parent of each node.
		ArrayList<Integer> mst = new ArrayList<>(); // minimum spanning tree.
		int distance[] = new int[N];
		for (int i = 0; i < N; i++)
			distance[i] = Integer.MAX_VALUE; // assign weight for each node to
												// max value.
		int start = sc.nextInt(); // start or root node.
		distance[start - 1] = 0; // mark distance of root node as 0.
		parent[start - 1] = -1; // mark parent to root as -1 as no one is its
								// parent.
		for (int count = 0; count < N; count++) { // till every node from tree
													// is in MST.
			int min_node = findMin(distance, mst); // find node with minimum
													// weight and return its
													// index.
			// System.out.println("Minimum node "+(min_node+1));
			mst.add(min_node + 1); //add the node with minimum weight to MST.
			for (int v = 0; v < N; v++) { //update the weights of node adjacent to min_node found in previous step in distance[]. 
				if (min_node != -1 && adjMat[min_node][v] != -1 && !mst.contains(v + 1)
						&& distance[v] > adjMat[min_node][v]) { //update the weight of adjacent node only if its weight is smaller than previous and not present in MST list.
					parent[v] = min_node; // mark parent of adjacent node to min_node. 
					distance[v] = adjMat[min_node][v];
					// System.out.println("adjacent nodes "+(v+1));
				}
			}
		}

		int sum = 0;
		for (int i : mst) {
			/*
			 * System.out.println("node in mst "+i); if(parent[i-1]==-1)
			 * System.out.println(i+" is root"); else System.out.println(i+
			 * " parent is "+ (parent[i-1]+1) +" distance is "+distance[i-1]);
			 */
			if (i > 0)
				sum += distance[i - 1]; //sum of weights.
		}
		System.out.println(sum); //display sum of weights.
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
		// System.out.println("min node is "+(min_index+1)+" with wt
		// "+distance[min_index]);
		return min_index;
	}

}
/*
 * 5 6 1 2 3 1 3 4 4 2 0 5 2 2 2 3 5 3 5 7 1
 */
