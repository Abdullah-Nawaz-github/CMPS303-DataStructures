package testing;

import hashing1.HashTable;
import hashing1.Student;
import hashing1.Entry;

//import hashing2.Entry;
//import hashing2.HashTable;
//import hashing2.Student;

public class Test {

	public static void main(String arg[]) {

		HashTable<Student> ht = new HashTable<Student>(10);
		ht.insert(50, new Student(50, "Ali"));
		ht.insert(20, new Student(20, "Khalid"));
		ht.insert(70, new Student(70, "Nasser"));
		ht.insert(30, new Student(30, "Nasser"));
		ht.insert(80, new Student(80, "Noor"));
		ht.insert(90, new Student(90, "Sara"));
		ht.displayTable();

		System.out.println("----------------------------------");
		System.out.println("The implemented hashing for this instance is: " + hashingType());
	}

	/*
	 * According to the distribution of the elements in the instance hash table,
	 * implement the static method below that will decide if the instance parameter
	 * is an instance of the Quadratic hash table or Double hashing. Remember, your
	 * implementation has to be based on the distribution of the elements, which
	 * means which insert() method has been called while inserting the elements into
	 * the hashtable parameter.
	 * 
	 * Finally, consider the maximum of three collisions for any element exists in
	 * the instance parameter.
	 */

	public static String hashingType() {
		HashTable<Student> ht = new HashTable<>(1);
		return (ht.insert(50, new Student(50, "Ali")) == 1) ? "Double Hashing" : "Quad Hashing";
	}

}