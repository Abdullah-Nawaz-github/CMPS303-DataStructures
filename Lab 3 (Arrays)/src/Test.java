import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

//		create two objects of MyList, each one initially contains
//		3 elements: one of type Integer and the other one of type Character. Test the methods above.

		MyList<Integer> mylist1 = new MyList<Integer>(5);
		@SuppressWarnings("unused")
		MyList<Character> mylist2 = new MyList<Character>(5);

		// Have add method in MyList
		mylist1.add(9);
		mylist1.add(5);
		mylist1.add(22);
		mylist1.add(3);
		mylist1.add(7);
		mylist1.add(292);
		System.out.println("After adding = " + mylist1.toString());

		System.out.println("Size = " + mylist1.size());
		System.out.println("isEmpty = " + mylist1.isEmpty());

		mylist1.clear();
		System.out.println("after clearing = " + mylist1.toString());

		mylist1.add(9);
		mylist1.add(5);
		mylist1.add(22);
		mylist1.add(3);
		System.out.println(mylist1.toString());
		mylist1.set(2, 88);
		System.out.println("after setting = " + mylist1.toString());

		System.out.println("contains 9? " + mylist1.contains(9));
		System.out.println("index of 9 : " + mylist1.indexOf(9));
		System.out.println("array : " + Arrays.toString(mylist1.toArray()));

		System.out.println(mylist1.toString());
		mylist1.remove(1);
		System.out.println("remove 9 " + mylist1.toString());

	}

}
