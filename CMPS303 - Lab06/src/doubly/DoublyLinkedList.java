package doubly;

import doubly.Node;

public class DoublyLinkedList<E> {

	private Node<E> header; // header is a dummy node
	private Node<E> trailer; // trailer is a dummy node
	private int size = 0;

	public DoublyLinkedList() {
		// initializing a doubly linked list
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null); // previous of trailer is header
		header.setNext(trailer); // next of header is trailer
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		// header has no data so get data of node after header
		return header.getNext().getData();
	}

	public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getData();
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

//	public E removeFirst() {
//		if (isEmpty())
//			return null;
//		return remove(header.getNext());
//	}
//
//	public E removeLast() {
//		if (isEmpty())
//			return null;
//		return remove(trailer.getPrev());
//	}

	public void printForward() {
		for (Node<E> tmp = header.getNext(); tmp != trailer; tmp = tmp.getNext())
			System.out.println(tmp.getData());
	}

	public void printBackward() {
		for (Node<E> tmp = trailer.getPrev(); tmp != header; tmp = tmp.getPrev())
			System.out.println(tmp.getData());
	}

	// get data for node n (starting from 1)
	public E get(int n) { // n=10 ==> size 50 ==> the lower half "from the header"
		if (n < 1 || n > size) // n=40 ==> size 50 ==> the upper half "from the trailer"
			return null;

		// if n is befor midway point
		if (n < size / 2) {
			// temp starts form header.getNext()
			Node<E> tmp = header.getNext();
			// goes until n
			for (int index = 1; index < n; index++)
				tmp = tmp.getNext();
			// get data
			return tmp.getData();
		} else {
			Node<E> tmp = trailer.getPrev();
			// loop in the other direction
			for (int index = size; index > n; index--)
				tmp = tmp.getPrev();
			return tmp.getData();
		}
	}

	public void insertAfter(int n, E e) {
		Node<E> tmp;
		if (n < 1 || n > size) {
			System.out.println("Invalid node number");
			return;
		}

		if (n == size)
			addLast(e);
		else {
			if (n < size / 2) {
				tmp = header.getNext();
				for (int i = 1; i < n; i++)
					tmp = tmp.getNext();
			} else {
				tmp = trailer.getPrev();
				for (int i = size; i > n; i--)
					tmp = tmp.getPrev();
			}

			// find node at n first
			Node<E> newst = new Node(e, tmp, tmp.getNext());
			tmp.getNext().setPrev(newst); // set previous getNext() of tmp to newest
			tmp.setNext(newst); // set new next of tmp to newest
			size++;
		}
	}

//	public E remove(int n) {
//		Node<E> tmp;
//		if (n < 1 || n > size)
//			return null;
//
//		if (n == 1)
//			return removeFirst();
//
//		if (n == size)
//			return removeLast();
//
//		if (n < size / 2) {
//			tmp = header.getNext();
//			for (int i = 1; i < n; i++)
//				tmp = tmp.getNext();
//		} else {
//			tmp = trailer.getPrev();
//			for (int i = size; i > n; i--)
//				tmp = tmp.getNext();
//		}
//
//		// find tmp first and then do this
//		E answer = tmp.getData();
//		tmp.getNext().setPrev(tmp.getPrev());
//		tmp.getPrev().setNext(tmp.getNext());
//		size--;
//		return answer;
//	}

	// remove if node given
//	private E remove(Node<E> node) {
//		Node<E> predecessor = ((Object) node).getPrev();
//		Node<E> successor = node.getNext();
//		predecessor.setNext(successor);
//		successor.setPrev(predecessor);
//		size--;
//		return node.getData();
//	}
	
	private void split() {
		int midpoint=size/2;
		Node<E> current=header.getNext();
		int count=0;
		for (int i = 0; i < midpoint; i++) {
			count++;
			current=current.getNext();
		}
	}
	
//	public static Node convertToDoublyLinkedList(Node head) {
//	    if (head == null) {
//	        return null;
//	    }
//	    
//	    Node prev = null;
//	    Node curr = head;
//	    
//	    while (curr != null) {
//	        Node next = curr.next;
//	        curr.prev = prev;
//	        curr.next = null;
//	        if (prev != null) {
//	            prev.next = curr;
//	        }
//	        prev = curr;
//	        curr = next;
//	    }
//	    
//	    return head;
//	}
}