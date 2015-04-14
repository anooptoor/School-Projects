import java.awt.List;
import java.util.ArrayList;

/**
 * Basic hashtable for dictionary
 * @author Anoop
 *
 */

public class HashTable {
	
	private ArrayList<ArrayList<DictEntry>> bucket;
	private int tableSize;

	public HashTable(int tableSize){
		this.tableSize = tableSize; 
		bucket = new ArrayList<ArrayList<DictEntry>>(tableSize); 
		for(int i = 0; i < tableSize; i++)
			
			bucket.add(new ArrayList<DictEntry>()); 
		
	
		
	}
	/**
	 * hash's values using Cyclic Shift method from textbook(appropriate for strings)
	 * @param key
	 * @return
	 */
	public int hashValue(DictEntry key){
		int h = 0;
		for( int i = 0; i < key.getConfig().length(); i++)
		{
			h = ( h << 6 ) |( h >>> 28);
			h = h + (int) key.getConfig().charAt(i);		
		}
		return h;
	}
	/**
	 * returns table size
	 * @return
	 */
	public int size(){
		return tableSize; 
	}
	/**
	 * removes an entry from hashtable
	 * @param key
	 */
	public void remove(DictEntry key){
		int value = findEntry(key);
		
		bucket.get(value).remove(key);
		
		
	}
	/**
	 * attempts to find entry in hashtable
	 * @param key
	 * @return
	 */
	protected int findEntry(DictEntry key){
		int value = compress(hashValue(key));
		value = Math.abs(value);
		String s;
		String t;
		for(DictEntry d : bucket.get(value))
		{
			s = d.getConfig(); // iterates and holds entries of bucket
			t = key.getConfig(); // holds value of key
			
			if(s.equals(t)) // compares key to bucket entry
				return value; // returns value if true
			
		}
		return -1;
	}
	/**
	 * adds value to hashtable
	 * @param key
	 * @return
	 */
	public int put(DictEntry key){
		int value = compress(hashValue(key));
		value = Math.abs(value);
		  
		bucket.get(value).add(key); 
	
		if (bucket.get(value).size() == 1)
			return 0; 
		else
			return 1;
	}

	/**
	 * hashtable compress function 
	 * @param hashValue
	 * @return
	 */
	private int compress(int hashValue) {
		return hashValue % tableSize;
	}

	

}
