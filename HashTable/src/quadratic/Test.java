package quadratic;

import linear.Student;

public class Test {
public static void main(String arg[])
{
	QuadraticHashTable<Student> t=new QuadraticHashTable<Student>(10);
	t.insert(50,new Student(50,"Ali"));
	t.insert(20,new Student(20,"Khalid"));
	t.insert(70,new Student(70,"Nasser"));
		
	//t.delete(70);
	t.insert(30,new Student(30,"Nasser"));
	t.displayTable();
	System.out.println("---------------");
	t.insert(80,new Student(80,"Noor"));
	t.insert(90,new Student(90,"Sara"));
	t.displayTable();
}
}
