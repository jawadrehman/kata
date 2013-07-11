package com.kata.search;
import java.util.ArrayList;
import java.util.Stack;

public class DFS {
	Stack<Node> toVisit;
	Node root;
	Node[] treeNodes;

	public static void main(String[] args){
		new DFS();
	}
	
	public DFS() {
		toVisit = new Stack<Node>();
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
			for(int i = children.size()-1; i>= 0; i--){
				toVisit.push(children.get(i));
			}
			result = visitNode(search);
		}
		return result;
	}

	public void traverseSearch(int search) {
		toVisit.push(root);
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
