import java.util.Random;

public class InsertionSort {
	DoubleLinkedList dList;

	public InsertionSort() {
		dList = new DoubleLinkedList();
		
		addNodestoList();
		System.out.println("head " + dList.getFirst());
		System.out.println("trailer " + dList.getLast());
		
		sortList(dList);
		
		System.out.println(dList);
	}
	
	public static void main(String[] args) {
		new InsertionSort();
	}

	public void addNodestoList() {
		Node[] listNodes = new Node[10];
		for (Node node : listNodes) {
			node = new Node(new Random().nextInt(10));
			System.out.println("added " + node.getElement());
			dList.add(node);
		}

		System.out.println(dList);
	}

	public DoubleLinkedList sortList(DoubleLinkedList dList) {
		if (dList.getCount() <= 1) {
			return null;
		}

		Node end = dList.getFirst();

		while (end != dList.getLast()) {
			
			Node pivot = end.getNext();
			dList.remove(pivot);
			
			Node ins = end;

			while (ins != dList.getFirst()
					&& (Integer) ins.getElement() > (Integer) pivot
							.getElement()) {
				ins = ins.getPrev();
			}

			dList.addAfter(pivot, ins);

			if (ins == end) {
				end = end.getNext();
			}
		}

		return null;
	}
}
