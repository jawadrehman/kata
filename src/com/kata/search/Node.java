package com.kata.search;
import java.util.ArrayList;

public class Node {
	private Node parent;
	private ArrayList<Node> children;
	private int element, index;

	public Node(int element) {
		setElement(element);
		setIndex(0);
		children = new ArrayList<Node>();
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
	
	public void addChild(Node child){
		children.add(child);
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}