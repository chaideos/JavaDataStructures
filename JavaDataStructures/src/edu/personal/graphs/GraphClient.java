package edu.personal.graphs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GraphClient
{

	public static void main(String[] args)
	{
		InputStream in = null;
		try
		{
			in = new FileInputStream("bfsG.txt");
			Graph G = new Graph(in);
			// for (int v = 0; v < G.V(); v++)
			// {
			// for (int w : G.adj(v))
			// System.out.println(v + "-" + w);
			// }
			System.out.println(G.bfs(0));
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
