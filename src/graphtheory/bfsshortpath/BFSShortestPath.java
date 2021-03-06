package graphtheory.bfsshortpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * <h2>Breadth First Search: Shortest Reach</h2>
 * <p>
 * Consider an undirected graph consisting of <i>n</i> nodes where each node is
 * labeled from 1 to <i>n</i> and the edge between any two nodes is always of
 * length 6. We define node <i>s</i> to be the starting position for a BFS.
 * </p>
 * <p>
 * Given <i>q</i> queries in the form of a graph and some starting node,
 * <i>s</i>, perform each query by calculating the shortest distance from
 * starting node <i>s</i> to all the other nodes in the graph. Then print a
 * single line of <i>n</i>-1 space-separated integers listing node <i>s</i>'s
 * shortest distance to each of the <i>n</i>-1 other nodes (ordered sequentially
 * by node number); if <i>s</i> is disconnected from a node, print -1 as the
 * distance to that node.
 * </p>
 * <h4>Input Format</h4>
 * <p>
 * The first line contains an integer, <i>q</i>, denoting the number of queries.
 * The subsequent lines describe each query in the following format:
 * </p>
 * <ul>
 * <li>The first line contains two space-separated integers describing the
 * respective values of <i>n</i>(the number of nodes) and <i>m</i>(the number of
 * edges) in the graph.</li>
 * <li>Each line <i>i</i> of the <i>m</i> subsequent lines contains two
 * space-separated integers, <i>u</i> and <i>v</i>, describing an edge
 * connecting node <i>u</i> to <i>v</i> node .</li>
 * <li>The last line contains a single integer, <i>s</i>, denoting the index of
 * the starting node.</li>
 * </ul>
 */
public class BFSShortestPath {
	/*
	 * Following program works with help of map and arraylist and no queue fo
	 * tracking the nodes to be visited next to make it prop
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, ArrayList<Integer>> adjacenyList = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt(); // queries
		while (q > 0) {
			int n = sc.nextInt(); // nodes
			for (int i = 0; i < n; i++)
				adjacenyList.put(i + 1, new ArrayList<Integer>());
			int m = sc.nextInt(); // edges
			
			boolean[] visited = new boolean[n];// initialize visited to false.
			int[] distance = new int[n]; // initialize distance of node from
											// start to high value.
			for (int i = 0; i < n; i++)
				distance[i] = -1;

			for (int i = 0; i < m; i++) { // for edge
				int u = sc.nextInt(); // node u
				int v = sc.nextInt(); // to node v

				ArrayList<Integer> al = adjacenyList.get(u);
				al.add(v);
				adjacenyList.put(u, al); // add v in u's adjacencylist

				al = adjacenyList.get(v);
				al.add(u);
				adjacenyList.put(v, al); // add u in v's adjacencylist
			}
			
			int start = sc.nextInt();
			distance[start - 1] = 0;
			
			ArrayList<Integer> queue=new ArrayList<>();
			queue.add(start);
			while(!queue.isEmpty()){
				findShortestPath(adjacenyList, queue.remove(0), visited, distance, queue);
			}
			
			q--;

			for (int i : distance)
				if (i != 0)
					System.out.print(i + " ");
			System.out.println();
			//System.out.println(Arrays.toString(distance));
		}
		sc.close();
	}

	private static void findShortestPath(HashMap<Integer, ArrayList<Integer>> graph, int start, boolean[] visited,
			int[] distance, ArrayList<Integer> queue) {
		if (visited[start - 1])
			return;
		visited[start - 1] = true;
		ArrayList<Integer> adlist = graph.get(start);
		//System.out.println("Source " + start);
		
		for (int ele : adlist) {
			if (!visited[ele - 1]) {
				int d = distance[start - 1] + 6;
				//System.out.println("Distance of node " + ele + " from source is " + d);
				if (distance[ele - 1] == -1 || d < distance[ele - 1])
					distance[ele - 1] = d;
				//System.out.println("next pos in queue  ELEMENT TO BE ENTERED "+ele);
				if(!queue.contains(ele))
					queue.add(ele);
			}

		}
	
	}

}
