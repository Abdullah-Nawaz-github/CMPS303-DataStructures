package chaining;
import doubleHashing.Entry;

public class ChainingHashTable<E>
{
	private SortedList[] hashArray;   
	int size;

	public ChainingHashTable(int size)        
	{
		hashArray = new SortedList[size];  
		for(int j=0; j<hashArray.length; j++)          
			hashArray[j] = new SortedList();    
	}

	public int hashFunc(int key)     
	{
		return key % hashArray.length;
	}

	public void insert(int k, E d)  
	{

		int hashVal = hashFunc(k);   
		hashArray[hashVal].insert(k,d); 
	}  

	public void delete(int k)       
	{
		int hashVal = hashFunc(k);   
		hashArray[hashVal].delete(k); 
	}  

	public E find(int k)         
	{
		int hashVal = hashFunc(k);   
		E d = (E) hashArray[hashVal].find(k);   
		return d;               
	}


	public void displayTable()
	{
		for(int j=0; j<hashArray.length; j++) 

			hashArray[j].displayList();
	
	}
	public double loadFactor()
	{
		int s=0;
		for (int i=0;i<hashArray.length;i++)
								s+=hashArray[i].size();
		return (double)s/hashArray.length;
		
	}
	
}
