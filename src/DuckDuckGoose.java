import java.util.Random;

public class DuckDuckGoose {
	CircularLinkedList cList;
	Node[] listNodes = new Node[4];
	private Node it;

	public DuckDuckGoose() {
		cList = new CircularLinkedList();
		initListNodes();
		it = cList.removeNode();
		itMove();
	}

	public void initListNodes() {
		Integer i = 0;
		for (Node node : listNodes) {
			node = new Node(i);
			i++;
			cList.addNode(node);
		}
	}

	public void itMove() {
		while (true) {
			System.out.println("It = " + it.getElement());

			int moves = new Random().nextInt(2);
			
			for (int i = 0; i < moves; i++) {
				System.out.println("Duck" + cList.getCursor().getElement());
				cList.advance(); 
			}
			
			Node goose = cList.removeNode();
			
			System.out.println("Goose" + goose);

			boolean winner = new Random().nextBoolean();
			if (winner) {
				cList.addNode(it);
				it = goose;
			} else {
				cList.addNode(goose);
			}

			System.out.println("the winner is " + cList.getCursor().getNext().getElement());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new DuckDuckGoose();
	}
}
