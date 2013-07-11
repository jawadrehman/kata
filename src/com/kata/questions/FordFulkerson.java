package com.kata.questions;

import java.util.LinkedList;

public class FordFulkerson {
	private Integer[][] graph = { { 0, 16, 13, 0, 0, 0 },
									{ 0, 0, 10, 12, 0, 0 }, 
									{ 0, 4, 0, 0, 14, 0 },
									{ 0, 0, 9, 0, 0, 20 }, 
									{ 0, 0, 0, 7, 0, 4 }, 
									{ 0, 0, 0, 0, 0, 0 } };

	public FordFulkerson() {
		System.out.println("start");

		System.out.println("the max flow " + fordFulkerson(graph, 0, 5));
	}
	
	public static void main(String[] args) {
		new FordFulkerson();
	}

	public boolean bfs(Integer rGraph[][], int s, int t, int parent[]) {
		boolean[] visited = new boolean[6];
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(s);

		visited[s] = true;
		parent[s] = -1;
		while (!q.isEmpty()) {
			int u = q.pop();
			for (int v = 0; v < rGraph.length; v++) {
				if (visited[v] == false && rGraph[u][v] > 0) {
					q.add(v);
					parent[v] = u;
					visited[v] = true;

				}
				else {
				}
			}

		}
		System.out.println("visited = " + visited[t]);
		return (visited[t] == true);
	}

	public int fordFulkerson(Integer graph[][], int s, int t) {
		int u, v;

		Integer rGraph[][] = new Integer[graph.length][graph[0].length];

		for (u = 0; u < graph.length; u++) {
			for (v = 0; v < graph.length; v++) {
				rGraph[u][v] = graph[u][v];
			}
		}

		int parent[] = new int[graph.length];

		int max_flow = 0;

		while (bfs(rGraph, s, t, parent)) {
			int path_flow = Integer.MAX_VALUE;
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				path_flow = Math.min(path_flow, rGraph[u][v]);
			}

			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}
			
			max_flow += path_flow;
			
			
		}
		return max_flow;
	}

}
