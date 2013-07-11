package com.kata.questions;

public class BinaryTreeIteration {

	
	private class Node {
		private Node left, right, parent;
		int id;

		private Node(int id) {
			this.id = id;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}
	}

	private class BinaryTree {
		Node[] nodes = new Node[10];

		public BinaryTree() {
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new Node(i);
				if (i <= 2) {
					nodes[i].setLeft(nodes[i * 2]);
					nodes[i].setRight(nodes[i * 2 + 1]);
				}
				
				else if(i>0) {
					nodes[i].setParent(nodes[(int)(i/2)]);
				}
			}
		}

	}

}
