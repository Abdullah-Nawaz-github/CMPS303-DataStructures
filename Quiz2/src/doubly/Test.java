package doubly;

import Singly.SinglyLinkedList;

public class Test {
	public static void main(String args[]) {
		DoublyLinkedList<Student> myLinkedList = new DoublyLinkedList<>();
		myLinkedList.addLast(new Student(3,"Ahmed"));
		myLinkedList.addLast(new Student(6,"John"));
		myLinkedList.addLast(new Student(8,"Ali"));
		System.out.println("Doubly Linked list before : ");
		myLinkedList.printForward();
		
		
		System.out.println();
		System.out.println("Doubly Linked list after calling addSingly(2, list2) : ");

		SinglyLinkedList<Student> list2 = new SinglyLinkedList<>();
		list2.addLast(new Student(33,"Omer"));
		list2.addLast(new Student(99,"Shahid"));
		
		myLinkedList.addSingly(2, list2);
		myLinkedList.printForward();
	
		System.out.println();
		myLinkedList.test();


	}

}
