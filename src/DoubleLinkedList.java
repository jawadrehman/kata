public class DoubleLinkedList {
	private Node head;
	private Node trailer;

	protected int count;

	public DoubleLinkedList() {
		count = 0;
	}

	public Node getLast() {
		return trailer;
	}

	public Node getFirst() {
		return head;
	}

	public Node getNext(Node node) {
		return node.getNext();
	}

	public Node getPrev(Node node) {
		return node.getPrev();
	}

	public void addBefore(Node node, Node beforeNode) {
		Node intermediate = beforeNode.getPrev();
		node.setPrev(intermediate);
		intermediate.setNext(node);

		node.setNext(beforeNode);

		beforeNode.setPrev(node);

		if (beforeNode == head) {
			head = node;
		}
	}

	public void addAfter(Node node, Node afterNode) {

		if (afterNode.hasNext()) {
			Node intermediate = afterNode.getNext();
			intermediate.setPrev(node);
			node.setNext(intermediate);
		}
		node.setPrev(afterNode);

		afterNode.setNext(node);
		
	
		
		if (afterNode == trailer) {
			trailer = node;
		}

		count++;
	}

	public void add(Node node) {
		if (head == null) {
			head = node;
			trailer = node;
		}
		addAfter(node, head);
	}

	public Node remove(Node node) {
		Node nextNode = node.getNext();
		Node prevNode = node.getPrev();

		nextNode.setPrev(prevNode);
		prevNode.setNext(nextNode);

		node.setNext(null);
		node.setPrev(null);

		if (head == node) {
			head = node.getNext();
		}
		if (trailer == node) {
			trailer = node.getPrev();
		}

		return node;
	}

	public int getCount() {
		return count;
	}

	public String toString() {
		Node iter = head;
		String string = "[" + iter.getElement();

		while (iter != trailer) {
			string.concat(", " + iter.getElement());
			iter = iter.getNext();
		}

		string.concat("]");

		return string;
	}
}
