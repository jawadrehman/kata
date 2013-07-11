package com.kata.questions;

public class Collinear {

	Point[] points = new Point[5];
	BinarySearchTree tree;
	GradientNode max;

	public static void main(String[] args) {
		new Collinear();
	}

	public Collinear() {
		tree = new BinarySearchTree();
		/*sample data*/
		points[0] = new Point(2, 2);
		points[1] = new Point(1, 1);
		points[2] = new Point(3, 2);
		points[3] = new Point(4, 8);
		points[4] = new Point(7, 7);
		
		
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				System.out.print(points[i] + " & " + points[j]);
				int m = calculateGradient(points[i], points[j]);
				addToTree(m);
				System.out.println("gradient = " + m);
				System.out.println("-------------------------");
			}
		}

		System.out.println("max = " + max.getNumberElements() + " gradient = "
				+ max.getGradient());

	}

	public int calculateGradient(Point pointA, Point pointB) {
		int gradient = (pointA.getY() - pointB.getY())
				/ (pointA.getX() - pointB.getX());
		return gradient;
	}

	public void addToTree(int gradient) {
		
		GradientNode temp = tree.addToTree(gradient, tree.getRoot());
		if(max==null)
			max = temp;
//		System.out.println("temp" + temp.getNumberElements());
		if ( temp.getNumberElements() > max.getNumberElements()) {
			max = temp;
		}
	}

	private class Point {
		private int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "x = " + x + ", y = " + y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}

	private class GradientNode {
		private int numberElements;
		private int gradient;
		private GradientNode parent, left, right;

		public GradientNode(int gradient) {
			this.gradient = gradient;
			setNumberElements(0);
			System.out.println("setting gradient "+ gradient );

		}

		public void addElement() {
			System.out.println("adding element");

			setNumberElements(getNumberElements() + 1);
		}

		public int getGradient() {
			return gradient;
		}

		

		public GradientNode getLeft() {
			return left;
		}

		public GradientNode getRight() {
			return right;
		}

		public void setParent(GradientNode parent) {
			this.parent = parent;
		}

		public boolean hasLeft() {
			// TODO Auto-generated method stub
			return left != null;
		}

		public void setLeft(GradientNode left) {
			this.left = left;
		}

		public boolean hasRight() {
			// TODO Auto-generated method stub
			return right != null;
		}

		public void setRight(GradientNode right) {
			this.right = right;
		}

		public int getNumberElements() {
			return numberElements;
		}

		public void setNumberElements(int numberElements) {
			this.numberElements = numberElements;
		}
	}

	private class BinarySearchTree {
		GradientNode root;

		public BinarySearchTree() {

		}

		public GradientNode getRoot() {
			return root;
		}

		public GradientNode addToTree(int gradient, GradientNode traverse) {
			GradientNode node = null;

			if (traverse == root && root == null) {
				root = new GradientNode(gradient);
				node = root;
				
			}
			else if (gradient<traverse.getGradient()) {
				System.out.println("left");

				if (!traverse.hasLeft()) {
					node = new GradientNode(gradient);

					traverse.setLeft(node);
					node.setParent(traverse);
				} else {
					node = addToTree(gradient, traverse.getLeft());
				}

			}

			else if (traverse.getGradient() < gradient) {
				System.out.println("right");

				if (!traverse.hasRight()) {
					node = new GradientNode(gradient);
					traverse.setRight(node);
					node.setParent(traverse);
				} else {
					node = addToTree(gradient, traverse.getRight());
				}

			}

			else if (gradient == traverse.getGradient()) {
				System.out.println("same");
				traverse.addElement();
				node = traverse;
			}

			return node;
		}
	}

}
