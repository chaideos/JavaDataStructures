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
					if (current.getLeft() == null)
						current.setLeft(node);
					else
						current = current.getLeft();
				}
				else if (data >= current.getData())
				{
					if (current.getRight() == null)
						current.setRight(node);
					else
						current = current.getRight();
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
