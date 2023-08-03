public class Test {
	
	public static void main(String[] args) {
		Tree<Integer> t=new Tree<>();
		t.insert(8, null);
		t.insert(3, null);
		t.insert(10, null);
		t.insert(1, null);
		t.insert(6, null);
		t.insert(14, null);
		
		t.traverse(1);
		
		System.out.println(t.nodeInfo());

	}
}