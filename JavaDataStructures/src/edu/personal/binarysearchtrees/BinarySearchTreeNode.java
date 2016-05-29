package edu.personal.binarysearchtrees;

public class BinarySearchTreeNode<D>
{
	private D data;

	private BinarySearchTreeNode<D> left;

	private BinarySearchTreeNode<D> right;

	public BinarySearchTreeNode(D data, BinarySearchTreeNode<D> left,
			BinarySearchTreeNode<D> right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinarySearchTreeNode(D data)
	{
		this(data, null, null);
	}

	public BinarySearchTreeNode<D> getLeft()
	{
		return left;
	}

	public void setLeft(BinarySearchTreeNode<D> left)
	{
		this.left = left;
	}

	public BinarySearchTreeNode<D> getRight()
	{
		return right;
	}

	public void setRight(BinarySearchTreeNode<D> right)
	{
		this.right = right;
	}

	public D getData()
	{
		return data;
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.data);
	}
}
