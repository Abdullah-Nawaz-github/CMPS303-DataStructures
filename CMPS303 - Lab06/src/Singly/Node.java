package Singly;

// Generic Class
public class Node<E> {

	// data in the node
	private E data;
	// next node
	private Node<E> next;

	// constructor
	public Node(E d, Node<E> n) {
		data = d;
		next = n;
	}

	// returns data
	public E getData() {
		return data;
	}

	// sets data
	public void setData(E data) {
		this.data = data;
	}

	// returns next node
	public Node<E> getNext() {
		return next;
	}

	// sets next node
	public void setNext(Node<E> n) {
		next = n;
	}


}