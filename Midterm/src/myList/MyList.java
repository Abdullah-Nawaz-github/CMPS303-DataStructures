package myList;

public class MyList<G> {
	private G elements[];
	private int counter;

	public MyList() {
		elements = (G[]) new Object[10];
	}

	public MyList(int size) {
		elements = (G[]) new Object[size];
	}

	public G getElementAt(int index) {
		return elements[index];
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

	public void add(G element) {
		if (counter < elements.length)
			elements[counter++] = element;
		else {
			G temp[] = (G[]) new Object[elements.length * 2];
			for (int index = 0; index < counter; index++)
				temp[index] = elements[index];

			elements = temp;
			elements[counter++] = element;
		}
	}

	public void clear() {
		elements = (G[]) new Object[elements.length];
		counter = 0;
	}

	public void set(int index, G element) {
		if (index < 0 || index >= counter)
			System.out.println("Index is out of the range.");
		else
			elements[index] = element;
	}

	public boolean contains(G element) {
		for (G instance : elements)
			if (element.equals(instance))
				return true;

		return false;
	}

	public int indexOf(G element) {
		for (int index = 0; index < counter; index++)
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

	public G remove(int index) {
		if (index < 0 || index >= counter) {
			System.out.println("Index is out of the range.");
			return null;
		} else {
			G temp = elements[index];
			for (int secIndex = index; secIndex < counter - 1; secIndex++)
				elements[secIndex] = elements[secIndex + 1];

			elements[counter - 1] = null;
			counter--;
			return temp;
		}
	}
}