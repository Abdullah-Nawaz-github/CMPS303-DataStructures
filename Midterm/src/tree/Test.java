package tree;

public class Test {

	public static void main(String arg[]) {

		Tree<Integer> t = new Tree<>();

		t.insert(5, null);

		t.insert(2, null);

		t.insert(9, null);

		t.insert(1, null);

		t.insert(4, null);

		t.insert(7, null);

		t.insert(10, null);

		t.insert(3, null);

		t.insert(6, null);

		t.insert(8, null);

		t.insert(0, null);

		System.out.println();

		t.printKeys();

		// preorder
		t.traverse(1);

		System.out.println();

		// level by level
		t.printKeys();

	}
}