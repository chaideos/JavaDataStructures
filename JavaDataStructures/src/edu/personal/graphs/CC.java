package edu.personal.graphs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CC
{
	private int[] id;

	boolean[] marked;

	private int count;

	public CC(Graph G)
	{
		id = new int[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
			{
				dfs(G, v);
				count++;
			}
	}

	public boolean connected(int u, int v)
	{
		return id[u] == id[v];
	}

	public int count()
	{
		return count;
	}

	public int id(int v)
	{
		return id[v];
	}

	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for (int w : G.adj(v))
		{
			if (!marked[w])
			{
				id[w] = count;
				dfs(G, w);
			}
		}
	}

	public static void main(String[] args)
	{
		InputStream in = null;
		try
		{
			in = new FileInputStream("tinyG.txt");
			Graph G = new Graph(in);
			// for (int v = 0; v < G.V(); v++)
			// {
			// for (int w : G.adj(v))
			// System.out.println(v + "-" + w);
			// }
			CC test = new CC(G);
			System.out.println(test.count());
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
