package edu.personal.binarysearchtrees;

public class TreeNode<D>
{
	private D data;

	private TreeNode<D> left;

	private TreeNode<D> right;

	public TreeNode(D data, TreeNode<D> left,
			TreeNode<D> right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public TreeNode(D data)
	{
		this(data, null, null);
	}

	public TreeNode<D> getLeft()
	{
		return left;
	}

	public void setLeft(TreeNode<D> left)
	{
		this.left = left;
	}

	public TreeNode<D> getRight()
	{
		return right;
	}

	public void setRight(TreeNode<D> right)
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
