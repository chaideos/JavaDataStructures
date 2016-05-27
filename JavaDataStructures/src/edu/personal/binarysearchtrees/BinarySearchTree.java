package edu.personal.binarysearchtrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree
{

	private BinarySearchTreeNode root;

	public BinarySearchTreeNode add(int data)
	{
		BinarySearchTreeNode node = new BinarySearchTreeNode(data);
		if (root == null)
		{
			root = node;
		}
		else
		{
			BinarySearchTreeNode current = root;
			while (current != null)
			{
				if (data < current.getData())
				{

				}
			}
		}

		return root;
	}

	public boolean isEmpty()
	{
		return this.root == null;
	}

	public void bfs()
	{
		Queue<BinarySearchTreeNode> bfsQueue = new LinkedList<>();
		if (!isEmpty())
		{
			bfsQueue.add(root);
			while (!bfsQueue.isEmpty())
			{
				BinarySearchTreeNode visitedNode = bfsQueue.poll();
				System.out.println(visitedNode);
				bfsQueue.add(visitedNode.getLeft());
				bfsQueue.add(visitedNode.getRight());
			}
		}
	}
}
