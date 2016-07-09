package edu.personal.linkedlists.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.personal.linkedlists.LinkedListNode;
import edu.personal.linkedlists.SinglyLinkedList;

public class SinglyLinkedListTest
{

	@Test
	public void testAdd()
	{
		SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
		LinkedListNode<Integer> testHead = testList.add(new Integer(50));
		testList.add(new Integer(30));
		testList.add(new Integer(10));
		assertEquals(3, testList.size());
		assertEquals("503010", testList.display(testHead));
	}

	@Test
	public void testRemove()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testReverse()
	{
		SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
		LinkedListNode<Integer> reverseHead = testList.reverse();
		assertNull(reverseHead);
		testList.add(new Integer(50));
		reverseHead = testList.reverse();
		assertEquals("50", testList.display(reverseHead));
		testList.add(new Integer(30));
		testList.add(new Integer(10));
		reverseHead = testList.reverse();
		assertEquals("103050", testList.display(reverseHead));
	}

	@Test
	public void testSort()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty()
	{
		SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
		assertTrue(testList.isEmpty());
		testList.add(new Integer(50));
		testList.add(new Integer(30));
		testList.add(new Integer(10));
		assertFalse(testList.isEmpty());
	}

	@Test
	public void testSize()
	{
		SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
		testList.add(new Integer(50));
		testList.add(new Integer(30));
		testList.add(new Integer(10));
		assertEquals(3, testList.size());
	}

}
