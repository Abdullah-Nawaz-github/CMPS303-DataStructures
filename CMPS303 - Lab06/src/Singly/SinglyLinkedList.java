package Singly;

public class SinglyLinkedList<E> {

	private Node<E> head = null; // head node
	private Node<E> tail = null; // tail node
	private int size = 0; // size

	public SinglyLinkedList() {
	}

	public int size() {
		return size;
	}

	// method that returns number of nodes in the linked list (if we do not have
	// instance variable size)
	public int getCount() {
		Node<E> current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// returns data of head, if list is not empty
	public E first() {
		if (isEmpty())
			return null;
		return head.getData();
	}

	// return data of tail, if list is not empty
	public E last() {
		if (isEmpty())
			return null;
		return tail.getData();
	}

	// display all data of nodes in seperate lines
	public void display() {
		Node<E> current = head;
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}

	}

	// add node at beginning. create new node and set next to head. make new node
	// the head
	// add at front of linked list
	public void addFirst(E e) {

		Node<E> newNode = new Node<>(e, head);
		head = newNode;
		if (size == 0)
			tail = head;
		size++;
	}

	// add at end of liked list
	public void addLast(E e) {

		Node<E> newest = new Node<>(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);

		tail = newest;
		size++;
	}

	// if we do not have tail available
	public void addLast2(E e) {

		Node<E> newNode = new Node<>(e, null); // new node that points to null
		if (isEmpty())
			head = newNode;
		else {
			// make node current and set it to head
			Node<E> current = head;
			// keep going until current.getNext() is not null
			while (current.getNext() != null) {
				current = current.getNext(); // keep setting current to nextNode()
			}
			current.setNext(newNode);
		}
		tail = newNode;
		size++;
	}

	// insert after node # n (starts from 1). insert data e
	public void insertAfter(int n, E e) { // node 5

		if (n < 1 || n > size()) {
			System.out.println("invalid n");
			return; // return will leave the method
		} else {
			Node<E> current = head; // start from head.
			for (int i = 1; i < n; i++) { // find node at n
				current = current.getNext();
			}
			Node<E> newNode = new Node<>(e, current.getNext()); // set next of newNode to next node at N
			current.setNext(newNode);
			size++;
		}
	}

	public boolean search(Node head, E e) {
		Node current = head; // Initialize current
		while (current != null) {
			if (current.getData() == e)
				return true; // data found
			current = current.getNext();
		}
		return false; // data not found
	}

	public E removeFirst() {
		if (isEmpty())
			return null;

		E answer = head.getData();
		head = head.getNext();
		size--;

		if (size == 0)
			tail = null;

		return answer;
	}

	public E removeLast() {
		if (isEmpty())
			return null;
		E answer = tail.getData();
		if (head == tail)
			head = tail = null;
		else {
			Node<E> tmp = head;

			while (tmp.getNext() != tail)
				tmp = tmp.getNext();

			tmp.setNext(null);
			tail = tmp;
		}
		size--;
		return answer;
	}

	public E remove(int n) {
		if (n < 1 || n > size)
			return null;

		if (n == 1)
			return removeFirst();

		if (n == size)
			return removeLast();

		Node<E> tmp = head;
		for (int index = 1; index < n - 1; index++)
			tmp = tmp.getNext();

		E answer = tmp.getNext().getData();
		tmp.setNext(tmp.getNext().getNext());
		size--;
		return answer;
	}

	public E get(int n) { // n=5 ==> node number 5
		if (n < 1 || n > size)
			return null;

		Node<E> tmp = head;

		for (int index = 1; index < n; index++)
			tmp = tmp.getNext();

		return tmp.getData();
	}

	// Reverse method
	public void reverse() {
		int n = size();
		// create new array of type E
		E tmp[] = (E[]) new Object[n];

		// keep removing first element from linked list (head) and adding it to list
		for (int index = 0; index < n; index++)
			tmp[index] = removeFirst();

		// Then addFirst
		for (int index = 0; index < n; index++)
			addFirst(tmp[index]);
	}

	public SinglyLinkedList<E> split() {
		int midpoint = size / 2;
		Node<E> current = head;
		int count = 0;
		for (int i = 0; i < midpoint; i++) {
			count++;
			current = current.getNext();
		}
		// current is now the node at midpoint

		Node<E> newListHead = current.getNext();
		SinglyLinkedList<E> newList = new SinglyLinkedList<>();
		while (newListHead != null) {
			newList.addLast(newListHead.getData());
			newListHead = newListHead.getNext();
		}
		current.setNext(null);
		size -= count;
		return newList;
	}
}