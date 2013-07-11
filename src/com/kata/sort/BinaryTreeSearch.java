package com.kata.sort;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BinaryTreeSearch {

	LinkedList<Node> list;

	public static void main(String[] args) {
		new BinaryTreeSearch();
	}

	public BinaryTreeSearch() {
		list = new LinkedList<Node>();
		addToList(1);
		addToList(3);
		addToList(0);
		addToList(2);

		printOutTree();
	}

	public void addToList(int element) {
		try {
			Node cursor = list.getFirst();
			addRecursive(element, cursor);
		} catch (NoSuchElementException e) {
			Node head = new Node();
			head.setElement(element);
			list.addFirst(head);
		}
	}

	public void addRecursive(int element, Node cursor) {
		int current = cursor.getElement();
		if (element < current) {
			if (cursor.hasLeft()) {
				addRecursive(element, cursor.getLeft());
			} else {
				cursor.setLeft(element);
			}
		} else if (element > current) {
			if (cursor.hasRight()) {
				addRecursive(element, cursor.getRight());
			} else {
				cursor.setRight(element);
			}
		}

		else {
			if (!cursor.hasLeft()) {
				cursor.setLeft(element);
			} else if (!cursor.hasRight()) {
				cursor.setRight(element);
			} else {
				addRecursive(element, cursor.getLeft());
			}
		}

	}

	public void printOutTree() {
		Node cursor = list.getFirst();
		printOutNode(cursor);

	}

	public void printOutNode(Node cursor) {
		if (cursor.hasLeft()) {
			printOutNode(cursor.getLeft());
		}
		System.out.println(cursor.getElement());
		if (cursor.hasRight()) {
			printOutNode(cursor.getRight());
		}
	}

	private class Node {
		int element;

		private Node left;
		private Node right;

		public int getElement() {
			return element;
		}

		public void setElement(int element) {
			this.element = element;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void setLeft(int element) {
			left = new Node();
			left.setElement(element);
		}

		public void setRight(int element) {
			right = new Node();
			right.setElement(element);
		}

		public boolean hasLeft() {
			return left != null;
		}

		public boolean hasRight() {
			return right != null;
		}
	}

}
