package hashing2;

import hashing1.Entry;

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

	public int insert(int k, E d) {
		if (!isFull()) {

			if (loadFactor() >= 0.5)
				rehash();

			int hashVal = hashFunc(k);
			int i = 1;
			int orignalHash = hashVal;
			while (hashArray[hashVal] != null && hashArray[hashVal] != defunct) {
				hashVal = orignalHash + i * i;
				hashVal %= hashArray.length;
				i++;
			}
			hashArray[hashVal] = new Entry(k, d);
			size++;
		}
		return 2;

	}

	public E delete(int k) {
		int hashVal = hashFunc(k);
		int start = hashVal;
		boolean checkAll = false;
		int i = 1;
		int orignalHash = hashVal;
		while (hashArray[hashVal] != null && hashArray[hashVal] != defunct && !checkAll) {
			if (hashArray[hashVal].key == k) {
				E temp = (E) hashArray[hashVal].data;
				hashArray[hashVal] = defunct;
				size--;
				return temp;
			}

			hashVal = orignalHash + i * i;
			hashVal %= hashArray.length;
			if (hashVal == start)
				checkAll = true;
			i++;
		}
		return null;
	}

	public E find(int k) {
		int hashVal = hashFunc(k);
		int start = hashVal;
		boolean checkAll = false;
		int i = 1;
		int orignalHash = hashVal;
		while (hashArray[hashVal] != null && !checkAll) {
			if (hashArray[hashVal].key == k)
				return (E) hashArray[hashVal].data;
			hashVal = orignalHash + i * i;
			hashVal %= hashArray.length;
			if (hashVal == start)
				checkAll = true;
			i++;
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