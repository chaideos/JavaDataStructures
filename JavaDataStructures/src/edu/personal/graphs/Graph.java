package edu.personal.graphs;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//TODO: Make this a graph of objects or generics
public class Graph
{
	private int v = 0;

	private boolean[] visited;

	/**
	 * Maintaining a list of linked lists where each linked list denotes the
	 * adjacent vertices to a specific vertex
	 */
	private List<Integer>[] adjacencyLists;

	/**
	 * Creates an empty graph with specified number of vertices
	 * 
	 * @param vertices
	 */
	public Graph(int vertices)
	{
		v = vertices;
		this.adjacencyLists = (List<Integer>[]) new List[v];
		this.visited = new boolean[v];
		for (int i = 0; i < v; i++)
			adjacencyLists[i] = new LinkedList<Integer>();

	}

	public Graph(InputStream in)
	{
		Scanner scanner = new Scanner(in);
		v = scanner.nextInt();
		int E = scanner.nextInt();
		this.adjacencyLists = (List<Integer>[]) new List[v];
		this.visited = new boolean[v];
		for (int i = 0; i < v; i++)
			adjacencyLists[i] = new LinkedList<Integer>();
		for (int i = 0; i < E; i++)
			addEdge(scanner.nextInt(), scanner.nextInt());
		scanner.close();
	}

	/**
	 * Return the number of vertices in the graph
	 * 
	 * @return
	 */
	public int V()
	{
		return v;
	}

	/**
	 * Return the number of edges in the graph
	 * 
	 * @return
	 */
	public int E()
	{
		return 0;
	}

	/**
	 * Adds an edge between v and w
	 * 
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w)
	{
		adjacencyLists[v].add(w);
		adjacencyLists[w].add(v);
	}

	/**
	 * Returns a list of vertices adjacent to a vertex v
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v)
	{
		return adjacencyLists[v];
	}

	@Override
	public String toString()
	{
		return "";
	}

	@SuppressWarnings("unused")
	public static int degree(Graph G, int v)
	{
		int degree = 0;
		for (int w : G.adj(v))
			degree++;
		return degree;
	}

	public static int maxDegree(Graph G)
	{
		int max = 0;
		for (int v = 0; v < G.V(); v++)
		{
			if (degree(G, v) > max)
				max = degree(G, v);
		}
		return max;
	}

	public static double averageDegree(Graph G)
	{
		return 2.0 * G.V() / G.E();
	}

	public String bfs(int source)
	{
		StringBuilder builder = new StringBuilder();
		Queue<Integer> bfs = new ArrayDeque<>();
		bfs.add(source);
		visited[source] = true;
		while (!bfs.isEmpty())
		{
			Integer visitedNode = bfs.poll();
			builder.append(visitedNode + "-");
			for (int w : adj(visitedNode))
			{
				if (!visited[w])
				{
					visited[w] = true;
					bfs.add(w);
				}
			}
		}

		return builder.toString();
	}

}
