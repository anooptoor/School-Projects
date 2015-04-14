
public class Dictionary implements DictionaryADT {
	/**
	 * This class implements a DictionaryADT. It implements using a hash table with separate chaining as a storage data type
	 */
	private HashTable dict;
	private int numElements = 0;
	public Dictionary(int size){
		dict = new HashTable(size); 
	}
	public Dictionary(){
		dict = new HashTable(3000);
	}
	
	/**
	 * inserts Entry into Dictionary, returns 1 on collision, returns 0 otherwise
	 */
	public int insert(DictEntry pair) throws DictionaryException {
		int ifDouble = dict.findEntry(pair);
	
		if(ifDouble == -1)
		{
			numElements++;
			return dict.put(pair); 
			
		}
		else
		{
			throw new DictionaryException();
		}
			
	}
	/**
	 * removes element from dictionary
	 */
	public void remove(String config) throws DictionaryException {
		DictEntry d = new DictEntry(config, 1); 
		int ifExist = dict.findEntry(d);
		if(ifExist != -1){
			numElements--;
			dict.remove(d);
		}
		else
		{
			throw new DictionaryException();
		}
		
		
	}

	/**
	 * find entry in dictionary
	 */
	public int find(String config) {
		DictEntry d = new DictEntry(config, 1 );
		return dict.findEntry(d); 
	}

	/**
	 * returns number of elements in dictionary 
	 */
	public int numElements() {
		
		return numElements; 
	}

}
