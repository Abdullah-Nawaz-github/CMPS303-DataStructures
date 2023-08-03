import java.util.ArrayList;
import java.util.Arrays;

public class MyList<G> {
	private G elements[];
	private int counter;

	public MyList() {
		elements = (G[]) new Object[10];
	}

	public MyList(int size) {
		elements = (G[]) new Object[size];
	}

	public int size() {
		return counter;
	}

	public int length() {
		return elements.length;
	}

	public void display() {
		for (G element : elements)
			System.out.println(element);
	}

	public boolean isEmpty() {
		return counter == 0;
	}

	public void add(G element) { // just adding at the end of an unsorted array
		if (counter < elements.length) // if list is not full
			elements[counter++] = element; // set place after counter to the new elemtn
		else {
			G temp[] = (G[]) new Object[elements.length * 2]; // create new array of twice the length
			for (int index = 0; index < counter; index++) // copy
				temp[index] = elements[index];

			elements = temp; // refer to the temp
			elements[counter++] = element;
		}
	}

	public void clear() {
		elements = (G[]) new Object[elements.length]; // will place all zero
		counter = 0;
	}

	public void set(int index, G element) {
		if (index < 0 || index >= counter)
			System.out.println("Index is out of the range.");
		else
			elements[index] = element; // set is simple. no need to shift other elements in this case also
	}

	public boolean contains(G element) {
		for (G instance : elements)
			if (element.equals(instance))
				return true;
		return false;
	}

	public int indexOf(G element) {
		for (int index = 0; index < counter; index++) // go through the array. stop right before the counter
			if (elements[index].equals(element))
				return index;
		return -1;
	}

	public G[] toArray() {
		G[] temp = (G[]) new Object[counter];
		for (int index = 0; index < counter; index++)
			temp[index] = elements[index];
		return temp;
	}

	public G remove(int index) { // look at array and solve sample step
		// check if index is bigger than zero and less than counter
		if (index >= 0 && index < counter) {
			// go from removing index to the end of the array
			// shift left using elements[i]=elements[i+1]
			for (int i = index; i < counter; i++) {
				elements[i] = elements[i + 1];
			}
			counter--;
			elements[counter - 1] = null;
		}
		return null;

	}

	public void integrate(int index, MyList myList) {
		// create temp array
		ArrayList<G> temp = new ArrayList<G>(); // use ArrayList for adding
		// add elements before insertion index to the temp array
		for (int i = 0; i < index; i++) {
			temp.add(elements[i]);
		}
		// add all elements of myList to it
		for (int i = 0; i < myList.size(); i++) {
			temp.add((G) myList.elements[i]); // cast back to G
		}

		for (int i = index; i < size(); i++) {
			temp.add(elements[i]);
		}

		System.out.println(temp.toString());

	}

}