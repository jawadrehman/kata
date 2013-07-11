package com.kata.search;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

	LinkedList<Node> toVisit;
	Node root;
	Node[] treeNodes;

	public static void main(String[] args) {
		new BFS();
	}

	public BFS() {
		toVisit = new LinkedList<Node>();
		initTree();

		traverseSearch(5);
	}

	public int visitNode(int search) {
		Node node = toVisit.pop();
		System.out.println("visited" + node.getElement());
		int result = -1;
		if (search == node.getElement()) {
			return node.getIndex();
		} else {
			ArrayList<Node> children = node.getChildren();
			for (Node child : children) {
				toVisit.add(child);
			}

			result = visitNode(search);
		}
		return result;
	}

	public void traverseSearch(int search) {
		toVisit.add(root);
		System.out.println("index = " + visitNode(search));
	}

	public void initTree() {
		root = new Node(10);
		root.setIndex(0);
		treeNodes = new Node[10];

		for (int i = 0; i < treeNodes.length; i++) {
			treeNodes[i] = new Node(i);
			treeNodes[i].setIndex(i);
		}

		root.addChild(treeNodes[0]);
		root.addChild(treeNodes[1]);

		treeNodes[0].addChild(treeNodes[2]);
		treeNodes[0].addChild(treeNodes[3]);

		treeNodes[1].addChild(treeNodes[3]);
		treeNodes[1].addChild(treeNodes[4]);

		treeNodes[2].addChild(treeNodes[5]);
		treeNodes[2].addChild(treeNodes[6]);

		treeNodes[3].addChild(treeNodes[7]);

		treeNodes[4].addChild(treeNodes[8]);

		treeNodes[5].addChild(treeNodes[9]);

	}

}
