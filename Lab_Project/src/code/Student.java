package code;

public class Student{
		
	private int id;
	private String name;
	private String address;
	private double gpa;

	public Student() {
	}

	public Student(int id, String name, String address, double gpa) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String toString() {
		return String.format("%-10d , %-15s , %-15s , %-5f \n", id, name, address, gpa);
	}

}
