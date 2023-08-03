import java.util.Arrays;

public class MyList<E> {
	private E[] arr;
	private int count;

	// No-parameter constructor with default size of 10
	public MyList() {
		arr = (E[]) new Object[10];
		count = 0;
	}

	// Parameter constructor that creates the array with the input size
	public MyList(int size) {
		arr = (E[]) new Object[size];
		count = 0;
	}

	// Returns the number of elements currently in the list
	public int size() {
		return count;
	}

	// Returns true if the list is empty, otherwise false
	public boolean isEmpty() {
		return count == 0;
	}

	// Adds the element e at the end of the array if it is not null.
	// If the array is full, creates a new array with double size of the old one,
	// copies the elements to the new one, and makes the reference point to the new
	// one.
	public void add(E e) {
		if (e != null) {
			if (count == arr.length) {
				arr = Arrays.copyOf(arr, arr.length * 2);
			}
			arr[count] = e;
			count++;
		}
	}

	// Removes all elements in the list
	public void clear() {
		arr = (E[]) new Object[arr.length];
		count = 0;
	}

	// Replaces element at position i
	public void set(int i, E e) {
		if (i >= 0 && i < count) {
			arr[i] = e;
		}
	}

	// Returns true if the element is in the list, otherwise false
	public boolean contains(E e) {
		for (int i = 0; i < count; i++) {
			if (arr[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the element e in the list if it is in the list,
	// otherwise returns -1
	public int indexOf(E e) {
		for (int i = 0; i < count; i++) {
			if (arr[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	// Returns an array of all elements in the list
	public E[] toArray() {
		return Arrays.copyOf(arr, count);
	}

	// Removes the element at the specified position in this list.
	// Shifts any subsequent elements to the left (subtracts one from their
	// indices).
	public void remove(int i) {
		if (i >= 0 && i < count) {
			for (int j = i; j < count - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[count - 1] = null;
			count--;
		}
	}
}
