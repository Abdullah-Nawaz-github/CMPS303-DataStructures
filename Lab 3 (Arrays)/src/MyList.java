import java.util.Arrays;

public class MyList<G> { // set(i,E), add(), contains()

	// unsorted array. adding is easy. removing requires shifting
	private G[] elements;
	private int counter;

	@SuppressWarnings("unchecked")
	public MyList() {
		elements = (G[]) new Object[10]; // downcast to be generic array
	}

	@SuppressWarnings("unchecked")
	public MyList(int size) {
		elements = (G[]) new Object[size];
	}

	// Add method size( ) that returns how many elements currently in the list.
	public int size() {
		return counter;
	}

//	Add method isEmpty() that returns true when the list is empty, otherwise it
//	returns false.
	public boolean isEmpty() {
		return counter == 0;
	}

//	Add method add(E e) (void) that adds the element e at the end of the array if it is not full. If the
//	array is full, create a new array with double size of the old one, copy the elements to the new one,
//	and make the reference points to the new one.

	public void add(G g) {
		if (counter == elements.length) {
			@SuppressWarnings("unchecked")
			G[] Elements2 = (G[]) new Object[2 * elements.length];
			for (int i = 0; i < elements.length; i++) {
				Elements2[i] = elements[i];
			}
			elements = Elements2;
		}
		elements[counter] = g; // if array is not full
		counter++;
	}

//	Method clear( ): void method that removes all elements in the list.
	@SuppressWarnings("unchecked")
	public void clear() {
//		for (int i = 0; i < counter; i++) {
//			elements[i]=null;
//		}

		elements = (G[]) new Object[elements.length];
		counter = 0;
	}

//	Method set(int i, E e): void method that replaces element at position i.
	public void set(int i, G g) { // unsorted array
		if (i >= 0 && i < counter)
			elements[i] = g; // no need to shift
	}

//	Method contains(E e): it returns true if the element in the list, otherwise it returns false
	public boolean contains(G g) {
		for (int i = 0; i < counter; i++) {
			if (elements[i].equals(g)) {
				return true;
			}
		}
		return false;
	}

//	Method indexOf(E e): it returns the index of the element e in the list if it is in the list, otherwise it
//	returns -1.
	public int indexOf(G g) {
		for (int i = 0; i < counter; i++) {
			if (elements[i].equals(g)) {
				return i;
			}
		}
		return -1;
	}

//	Method toArray( ): it returns an array of all elements in the list.
	public G[] toArray() {

//		return Arrays.copyOf(arr, count); //can't use this method for this assignment

		@SuppressWarnings("unchecked")
		G[] array = (G[]) new Object[counter];
		for (int i = 0; i < counter; i++) {
			array[i] = elements[i];
		}
		return array;
	}

//	Method remove(int i): it removes the element at the specified position in this list. Shifts any
//	subsequent elements to the left (subtracts one from their indices).
	public void remove(int i) {
		if (i >= 0 && i < counter) {
			for (int j = i; j < counter - 1; j++) {
				elements[j] = elements[j + 1];
			}
			elements[counter - 1] = null;
			counter--;
		}
	}

	@Override
	public String toString() {
		return "MyList [elements=" + Arrays.toString(elements) + ", counter=" + counter + "]";
	}

}
