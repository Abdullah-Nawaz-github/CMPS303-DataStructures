package myList;

public class MyListTest {

	public static void removeDuplicate(MyList myList) {
		
		MyList temp = new MyList(myList.size());
		for (int i = 0; i < myList.size(); i++) {
			if (!temp.contains(myList.getElementAt(i))) {
				temp.add(myList.getElementAt(i));
			}
		}

		myList = new MyList(temp.size());

		for (int i = 0; i < temp.size(); i++) {
			myList.add(temp.getElementAt(i));
		}

		myList.display();
		System.out.println("list now has size : "+myList.size());
	}

	public static void main(String args[]) {
		MyList<Integer> list = new MyList<>(6);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(1);
		list.display();
		
		System.out.println();
		
		removeDuplicate(list);
		
	}
}