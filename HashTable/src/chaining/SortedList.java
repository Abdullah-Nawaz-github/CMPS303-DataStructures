package chaining;
public class SortedList <E>{
	private Node<E> head=null;
	private int size=0;

	public void insert(int k,E d)  
	{

		Node<E> previous = null; 
		Node<E> current = head;;
		while(current != null && k > current.key)
		{ 
			previous = current;
			current = current.next; 
		}
		if(previous==null) 
			head = new Node(k,d,head);
		else 
			previous.next = new Node(k,d,current); 
       size++;
	} 

	public E find(int k)
	{
		Node<E> current=head;
		while (current!=null && current.key<=k)
		{
			if (current.key==k)
				return current.data;
			current=current.next;
		}
		return null;

	}


	public void delete(int k)
	{

		if (head!=null)
			if (head.key==k)
				head=head.next;
			else
			{
				Node<E> previous = null; 
				Node<E> current = head;
				while(current != null && k != current.key)
				{
					previous = current;
					current = current.next; 
				}
				if (current!=null)
					previous.next = current.next;
			}
       size--;
	}
	public void displayList()
	{
		Node<E> current=head;
		while (current!=null)
		{
			current.diplay();
			current=current.next;
		}
	}
	public int size()
	{
		return size;
	}

}