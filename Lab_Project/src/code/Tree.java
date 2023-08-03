package code;

import java.util.ArrayList;

public class Tree {
	
    private ArrayList<Student> students;

	
	Node root;
	
	public Tree() {
        students = new ArrayList<>();

	}
	
	public Student search(Student std){
		
		Node current = root;
		while(current.student.getId()!=std.getId())
		{
			if (std.getId()<current.student.getId())
				current=current.leftChild;
			else
				current=current.rightChild;
			if(current==null)
				return null;
		}
		return current.student;
	}


	public void insert(Student std)
	{
		// add student to ArrayList
        students.add(std);

        
		Node newNode = new Node(std); 
		if(root==null) 
			root = newNode;
		else 
		{
			Node current = root; 
			Node parent;
			while(true) 
			{
				parent = current;
				if(std.getId() < current.student.getId())
				{
					current = current.leftChild;
					if(current == null) 
					{ 
						parent.leftChild = newNode;
						return;
					}
				} 
				else
				{
					current = current.rightChild;
					if(current == null) 
					{ 
						parent.rightChild = newNode;
						return;
					}
				} 
			} 
		} 
	} 
	public boolean delete(Student std)
	{
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while(current.student.getId()!= std.getId()) 
		{
			parent = current;
			if(std.getId() < current.student.getId()) 
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else 
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null) 
				return false; 
		}
		if(current.leftChild==null &&current.rightChild==null)
		{
			if(current == root) 
				root = null; 
			else 
				if(isLeftChild)
					parent.leftChild = null; 
				else 
					parent.rightChild = null;
		}
		else 
			if(current.rightChild==null)
				if(current == root)
					root = current.leftChild;
				else 
					if(isLeftChild) 
						parent.leftChild = current.leftChild;
					else // right child of parent
						parent.rightChild = current.leftChild;
			else if(current.leftChild==null)
				if(current == root)
					root = current.rightChild;
				else 
					if(isLeftChild) // left child of parent
						parent.leftChild = current.rightChild;
					else // right child of parent
						parent.rightChild = current.rightChild;
			else 
			{

				Node successor = getSuccessor(current);
				if(current == root)
					root = successor;
				else if(isLeftChild)
					parent.leftChild = successor;
				else
					parent.rightChild = successor;
				successor.leftChild = current.leftChild;
			} 
		return true;

	}
	private Node getSuccessor(Node delNode)
	{
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child
		while(current != null) // until no more
		{ // left children,
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}
		// if successor not
		if(successor != delNode.rightChild) // right child,
		{ // make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	public void traverse(int traverseType)
	{
		switch (traverseType)
		{
		case 1: preorder(root); break;
		case 2: inorder(root);  break;
		case 3: postorder(root); break;
		}

	}
	public void preorder(Node n)
	{
		if(n==null)
			return;
		else
		{
			System.out.println(n);
			preorder(n.leftChild);
			preorder(n.rightChild);
		}

	}
	public void inorder(Node n)
	{
		if(n==null)
			return;
		else
		{
			inorder(n.leftChild);
			System.out.println(n);
			inorder(n.rightChild);
		}

	}
	public void postorder(Node n)
	{
		if(n==null)
			return;
		else
		{
			postorder(n.leftChild);
			postorder(n.rightChild);
			System.out.println(n);
		}

	}
	public int max()
	{
		Node current=root;
		while (current.rightChild!=null)
			current=current.rightChild;
		return current.student.getId();
	}
	
	public int min()
	{
		Node current=root;
		while (current.leftChild!=null)
			current=current.leftChild;
		return current.student.getId();
	}
	
	public int depth(Student std)
	{
		int nodeDepth=0;
		Node current=root;

		while(current.student.getId() != std.getId())
		{
			if (std.getId()<current.student.getId())
				current=current.leftChild;
			else
				current=current.rightChild;
			nodeDepth = nodeDepth + 1;
			if(current == null)
				return -1;
		}
		return nodeDepth;
	}

	public void printLeaves()
	{
		printAllLeaves(root);
	}
	
	private void printAllLeaves(Node n)
	{
		if (n!=null)
			if (n.leftChild==null && n.rightChild==null)
				System.out.println(n);
			else
			{
				printAllLeaves(n.leftChild);
				printAllLeaves(n.rightChild);
			}
	}

	public int count()
	{
		return countNodes(root);
	}
	private int countNodes(Node n)
	{
		if (n==null)
			return 0;
		else
			return 1+countNodes(n.leftChild)+countNodes(n.rightChild);

	}	
	
	public int countLeaves()
	{
		return countAllLeaves(root);
	}
	private int countAllLeaves(Node n)
	{
		if (n!=null)
			if (n.leftChild==null && n.rightChild==null)
				return 1;
			else
				return countAllLeaves(n.leftChild)+countAllLeaves(n.rightChild);
		return 0;

	}
	
	public int treeHeight()
	{
		return nodeHeight(root)-1;

	}
	private int nodeHeight(Node n)
	{
		if (n==null)
			return 0;
		else
			return 1+Math.max(nodeHeight(n.leftChild),nodeHeight(n.rightChild));
	}
	public boolean isFull()
	{
		return checkFull(root);
	}
	private boolean checkFull(Node n)
	{
		if (n.leftChild==null && n.rightChild==null)
			return true;
		if (n.leftChild!=null && n.rightChild!=null)
			return checkFull(n.leftChild) && checkFull(n.rightChild);
		return false;
	}
	
	public ArrayList<Student> getStudents() {
        return students;
    }

}
