public class CircularLinkedList {
	private Node cursor;
	protected int size = 0;

	public CircularLinkedList() {
		cursor = null;
	}

	public void addNode(Node node) {
		if (cursor != null) {
			node.setNext(cursor.getNext());
			node.setPrev(cursor.getPrev());
			cursor.setNext(node);
		} else {
			node.setNext(node);
			cursor = node;
		}
		System.out.println("added" + node);
		size++;
	}

	public Node removeNode() {
		Node oldNode = cursor.getNext();

		if (oldNode == cursor) {
			cursor = null; // list is empty
		}

		else {
			Node newNode = oldNode.getNext();

			cursor.setNext(newNode);
			newNode.setPrev(cursor);

			oldNode.setNext(null);
			oldNode.setPrev(null);

		}
		size--;
		return oldNode;
	}

	public void advance() {
		cursor = cursor.getNext();
	}
	
	public Node getCursor() {
		return cursor;
	}
	
	
}
