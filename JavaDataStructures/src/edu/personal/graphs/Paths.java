package edu.personal.graphs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

public class Paths
{
	private boolean[] marked;
	private int[] edgeTo;
	private int s;

	public Paths(Graph g, int start)
	{
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		s = start;
		dfs(g, s);
	}

	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for (int w : G.adj(v))
		{
			if (!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	public boolean hasPathTo(int v)
	{
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v))
			return null;

		Stack<Integer> path = new Stack<>();
		for (int u = v; u != s; u = edgeTo[u])
			path.push(u);
		path.push(s);
		return path;
	}

	public static void main(String[] args)
	{
		InputStream in = null;
		try
		{
			in = new FileInputStream("bfsG.txt");
			Graph G = new Graph(in);
			Paths path = new Paths(G, 0);
			// for (int v = 0; v < G.V(); v++)
			// {
			// for (int w : G.adj(v))
			// System.out.println(v + "-" + w);
			// }
		}
		catch (IOException e)
		{

		}
		finally
		{
			if (in != null)
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
