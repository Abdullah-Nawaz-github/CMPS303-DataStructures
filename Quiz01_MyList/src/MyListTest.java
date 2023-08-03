import java.util.Arrays;

public class MyListTest {
	public static void main(String args[]) {
		MyList<Integer> instance = new MyList<>(12);
		instance.add(89);
		instance.add(1);
		instance.add(2);
		instance.add(32);
		instance.add(11);
		instance.add(101);
		instance.add(3);
		instance.add(23);

//		MyList<Integer> myList = new MyList<>(6);
//		myList.add(4);
//		myList.add(5);
		System.out.println("instance " + Arrays.toString(instance.toArray()));
//		System.out.println("myList" + Arrays.toString(myList.toArray()));

		instance.remove(4);
		System.out.println("after removing :  " + Arrays.toString(instance.toArray()));

	}
}