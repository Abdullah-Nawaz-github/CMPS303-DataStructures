package code;

public class Node {

	public Student student;
	public Node leftChild;
	public Node rightChild;
	
	public Node(Student student)
	{
		this.student=student;
		leftChild=null;
		rightChild=null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

}
