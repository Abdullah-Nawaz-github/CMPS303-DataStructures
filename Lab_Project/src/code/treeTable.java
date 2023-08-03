package code;

import java.util.ArrayList;

public class treeTable<E> {

	private Tree[] HashArray;
	private Tree defunct;

	public treeTable() {
		HashArray = new Tree[25];
		defunct = new Tree();
		defunct.insert(new Student(0, "null", "null", 0));
	}

	public int hashFunction(int year) {
		int num = year % 25;
		return num;
	}

	public int getYear(int id) {

		int divisor = 1;
		// Determine the divisor
		while (id / divisor >= 10000) {
			divisor *= 10;
		}
		// Extract the first four digits
		int year = id / divisor;
		return year;
	}

//	Student studentWithGPA(double), it returns array list of all students whose GPA is below
//	the received parameter.

	public ArrayList<Student> studentWithGPA(double searchGPA) {
		// create ArrayList which will hold the result
		ArrayList<Student> result = new ArrayList<>();

		// traverse through the HashArray
		for (int i = 0; i < HashArray.length; i++) {
			// get tree at this index
			Tree tree = HashArray[i];
			// if tree has values
			if (tree != null) {
				ArrayList<Student> students = tree.getStudents(); // utilize getStudents method in Tree class
				// Traverse through ArrayList and find students with GPA less than searchGPA
				for (int j = 0; j < students.size(); j++) {
					Student student = students.get(j);
					if (student.getGpa() < searchGPA) {
						result.add(student); // add to result array
					}
				}
			}
		}
		return result;
	}

	// Student highestGPA(), it returns the student has the highest GPA over the 25
	// years.

	public Student highestGPA() {
		double maxGPA = 0;
		Student highestGPAStudent = null;
		// traverse through the HashArra
		for (int i = 0; i < HashArray.length; i++) {
			// get tree at this index
			Tree tree = HashArray[i];
			// if tree has values
			if (tree != null) {
				// get ArrayList of students
				ArrayList<Student> students = tree.getStudents();
				for (Student student : students) {
					// for each student get GPA and compare with maxGA
					double studentGPA = student.getGpa();
					if (studentGPA > maxGPA) {
						// if studentGPA higher then set maxGPA equal to studentGPA
						maxGPA = studentGPA;
						// set highestGPAStuden equal to Student instance
						highestGPAStudent = student;
					}
				}
			}
		}

		return highestGPAStudent;

	}

//	Student highestGPA(int), it returns the student has the highest GPA over the parameter
//	year.
	public Student highestGPA(int searchYear) {
		double highestGPA = 0;
		Student highestGPAStudent = null;

		for (int i = 0; i < HashArray.length; i++) {
			Tree tree = HashArray[i];
			if (tree != null) {
				ArrayList<Student> students = tree.getStudents();
				for (Student student : students) {
					if (getYear(student.getId()) == searchYear) {
						double studentGPA = student.getGpa();
						if (studentGPA > highestGPA) {
							highestGPA = studentGPA;
							highestGPAStudent = student;
						}
					}
				}
			}
		}

		return highestGPAStudent;
	}
	
	public static void main(String[] args) {
		System.out.println(202212345/100000);
	}
	

}