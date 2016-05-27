package edu.personal.binarysearchtrees;

public class BinarySearchTreeNode
{
	private int data;

	private BinarySearchTreeNode left;

	private BinarySearchTreeNode right;

	public BinarySearchTreeNode(int data, BinarySearchTreeNode left,
			BinarySearchTreeNode right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinarySearchTreeNode(int data)
	{
		this(data, null, null);
	}

	public BinarySearchTreeNode getLeft()
	{
		return left;
	}

	public void setLeft(BinarySearchTreeNode left)
	{
		this.left = left;
	}

	public BinarySearchTreeNode getRight()
	{
		return right;
	}

	public void setRight(BinarySearchTreeNode right)
	{
		this.right = right;
	}

	public int getData()
	{
		return data;
	}
}
