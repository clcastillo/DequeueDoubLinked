
public class LinkedDeque<T> implements DequeInterface<T> {
	private DLNode firstNode; 
								
	private DLNode lastNode;

	@Override
	public void addToFront(T newEntry) {
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
	}

	@Override
	public void addToBack(T newEntry) {
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
	}

	@Override
	public T removeFront() {
		T front = null;
		if (!isEmpty()) {
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			if (firstNode == null)
				lastNode = null;
			else
				firstNode.setPreviousNode(null);
		}

		return front;
	}

	@Override
	public T removeBack() {
		T back = null;
		if (!isEmpty()) {
			back = lastNode.getData();
			lastNode = lastNode.getPreviousNode();
			if (lastNode == null)
				firstNode = null;
			else
				lastNode.setNextNode(null);
		}
		return back;
	}

	@Override
	public T getFront() {
		return firstNode.getData();
	}

	@Override
	public T getBack() {
		return lastNode.getData();
	}

	@Override
	public boolean isEmpty() {
        return firstNode == null;
	}

	@Override
	public void clear() {
		for (DLNode x = firstNode; x != null;) {
			DLNode next = x.next;
			x.setData(null);
			x.setNextNode(null);
			x.setPreviousNode(null);
			x = next;
		}
		firstNode = null;
		lastNode = null;
	}

	public LinkedDeque() {
		firstNode = null;
		lastNode = null;

	} 

	private class DLNode {
		private T data; 
		private DLNode next; 
		private DLNode previous;

		private DLNode(DLNode lastNode, T dataPortion) {
			this(lastNode, dataPortion, null);
		}

		private DLNode(DLNode lastNode, T dataPortion, DLNode nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public DLNode getNextNode() {
			return next;
		}

		public void setNextNode(DLNode nextNode) {
			next = nextNode;
		}

		public DLNode getPreviousNode() {
			return previous;
		}

		public void setPreviousNode(DLNode previousNode) {
			previous = previousNode;
		}
	} 
}