package chaining;

public class Test {
	public static void main(String arg[])
	{
		ChainingHashTable ch=new ChainingHashTable(20);
		ch.insert(10, new Student(10,"Khalid"));
		ch.insert(20, new Student(20,"Ali"));
		ch.insert(30, new Student(10,"Ahmed"));
		ch.insert(40, new Student(20,"Mohamed"));
		ch.insert(7, new Student(7,"Nasser"));
		ch.displayTable();
	}
}
