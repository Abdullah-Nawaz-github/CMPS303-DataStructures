package hashing1;

public class HashTable<E> {
	private Entry[] hashArray;
	private Entry defunct;
	private int size;

	public HashTable(int size) {
		hashArray = new Entry[size];
		defunct = new Entry(-1, null);
	}


	public void displayTable() {
		for (int j = 0; j < hashArray.length; j++)
			if (hashArray[j] != null)
				hashArray[j].diplay();
			else
				System.out.println("** ");
	}

	// --------------------------------------------------
	public boolean isFull() {
		for (int i = 0; i < hashArray.length; i++)
			if (hashArray[i] == null || hashArray[i] == defunct)
				return false;
		return true;

	}
	// -------------------------------------------------------------
	
	public int hashFunc(int key) {
		return key % hashArray.length;
	}

	public int hashFunc2(int key) {
		return 9 - (key % 9);
	}

	public int insert(int k, E d) {
		if (!isFull()) {

			if (loadFactor() >= 0.5)
				rehash();

			int hashVal = hashFunc(k);
			while (hashArray[hashVal] != null && hashArray[hashVal] != defunct) {
				hashVal += hashFunc2(k);
				hashVal %= hashArray.length;

			}
			hashArray[hashVal] = new Entry(k, d);
			size++;
		}
		return 1;
	}

	public E delete(int k) {
		int hashVal = hashFunc(k);
		int start = hashVal;
		boolean checkAll = false;

		while (hashArray[hashVal] != null && hashArray[hashVal] != defunct && !checkAll) {
			if (hashArray[hashVal].key == k) {
				E temp = (E) hashArray[hashVal].data;
				hashArray[hashVal] = defunct;
				size--;
				return temp;
			}

			hashVal += hashFunc2(k);
			hashVal %= hashArray.length;
			if (hashVal == start)
				checkAll = true;

		}
		return null;
	}

	public E find(int k) {
		int hashVal = hashFunc(k);
		int start = hashVal;
		boolean checkAll = false;

		while (hashArray[hashVal] != null && !checkAll) {
			if (hashArray[hashVal].key == k)
				return (E) hashArray[hashVal].data;
			hashVal += hashFunc2(k);
			hashVal %= hashArray.length;
			if (hashVal == start)
				checkAll = true;

		}
		return null;
	}

	public double loadFactor() {
		return (double) size / hashArray.length;
	}

	private void rehash() {
		Entry[] oldArray = hashArray;
		hashArray = new Entry[oldArray.length * 2];
		size = 0;
		for (int i = 0; i < oldArray.length; i++)
			if (oldArray[i] != null)
				insert(oldArray[i].key, (E) oldArray[i].data);

	}
	// -------------------------------------------------------------
}