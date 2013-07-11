public class Node {
	private Node prevNode;
	private Node nextNode;

	private Object element;

	public Node(Object element) {
		this.element = element;
		prevNode = null;
		nextNode = null;
	}

	public void setNext(Node node) {
		nextNode = node;
	}

	public void setPrev(Node node) {
		prevNode = node;
	}

	public Node getNext() {
		return nextNode;
	}

	public Node getPrev() {
		return prevNode;
	}

	public Object getElement() {
		return element;
	}

	public boolean hasNext() {
		return nextNode != null;
	}

	public boolean hasPrev() {
		return prevNode != null;
	}

	public String toString() {
		String prev;
		try {
			prev = Integer.toString((Integer)prevNode.getElement());

		} catch (NullPointerException e) {
			prev = "";
		}
		String next;
		try {
			next = Integer.toString((Integer)nextNode.getElement());
		} catch (NullPointerException e) {
			next = "";
		}
		return "Element = " + element + " prevNode " + prev
				+ " nextNode " + next;
	}
}
