package edu.personal.binarysearchtrees.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.personal.binarysearchtrees.BinarySearchTree;

public class BinarySearchTreeTest
{

	@Test
	public void testAdd()
	{
		BinarySearchTree<Integer> numberTree = new BinarySearchTree<>();
		assertTrue(numberTree.isEmpty());
		numberTree.add(3);
		numberTree.add(5);
		numberTree.add(4);
		numberTree.add(7);
		numberTree.add(2);
		numberTree.add(1);
		assertEquals(6, numberTree.size());
		assertFalse(numberTree.contains(0));
		assertTrue(numberTree.contains(7));
	}

}
