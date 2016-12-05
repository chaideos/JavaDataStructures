package edu.personal.binarysearchtrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<D extends Comparable<D>> implements Tree<D>
{

	private TreeNode<D> root;

	private int count;

	public TreeNode<D> add(D data)
	{
		TreeNode<D> node = new TreeNode<>(data);
		count++;
		if (root == null)
		{
			root = node;
		}
		else
		{
			TreeNode<D> current = root;
			while (current != null)
			{
				if (data.compareTo(current.getData()) < 0)
				{
					if (current.getLeft() == null)
					{
						current.setLeft(node);
						current = null;
					}
					else
						current = current.getLeft();
				}
				else
				{
					if (current.getRight() == null)
					{
						current.setRight(node);
						current = null;
					}
					else
						current = current.getRight();
				}
			}
		}

		return root;
	}

	/**
	 * Checks whether the tree is empty or not
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty()
	{
		return this.root == null;
	}

	@Override
	public int size()
	{
		return count;
	}

	/**
	 * Returns a space separated list of a breadth first search traversal
	 * 
	 * @return
	 */
	public String bfs()
	{
		StringBuilder builder = new StringBuilder();
		Queue<TreeNode<D>> bfsQueue = new LinkedList<>();
		if (!isEmpty())
		{
			bfsQueue.add(root);
			while (!bfsQueue.isEmpty())
			{
				TreeNode<D> visitedNode = bfsQueue.poll();
				builder.append(visitedNode.getData() + " ");
				if (visitedNode.getLeft() != null)
					bfsQueue.add(visitedNode.getLeft());
				if (visitedNode.getRight() != null)
					bfsQueue.add(visitedNode.getRight());
			}
		}
		return builder.toString().trim();
	}

	@Override
	public boolean contains(D data)
	{
		return false;
	}

}
