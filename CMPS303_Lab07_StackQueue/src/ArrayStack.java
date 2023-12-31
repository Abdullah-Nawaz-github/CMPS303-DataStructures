
public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 1000; // default array capacity
	private E[] data; // generic array used for storage
	private int t = -1; // index of the top element in stack

	public ArrayStack() {
		this(CAPACITY);
	} // constructs stack with default capacity

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) { // constructs stack with given capacity
		data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
	}

	public int size() {
		return (t + 1);
	}

	public boolean isEmpty() {
		return (t == -1);
	}

	public void push(E e) {
		if (size() == data.length) {
			System.out.println("Stack is full");
			return;
		} else
			data[++t] = e; // increment t before storing new item
	}

	public E top() {
		if (isEmpty())
			return null;
		return data[t];
	}

	public E pop() {
		if (isEmpty())
			return null;
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
}