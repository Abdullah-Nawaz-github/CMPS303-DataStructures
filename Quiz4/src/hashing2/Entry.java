package hashing2;
public class Entry<E>{
	public int key;
	public E data;
	public Entry(int k, E d)
	{
		key=k;
		data=d;
	}
	
	public void diplay()
	{
		System.out.print(key+":");
		System.out.println(data);
	}
}