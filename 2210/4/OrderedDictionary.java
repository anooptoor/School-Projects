
public class OrderedDictionary implements OrderedDictionaryADT {

	
	
	BinaryTree b;
	public OrderedDictionary(){
		this.b = new BinaryTree(new Node(new DictEntry("", "", 1), null, null)); 
	}
	public OrderedDictionary(BinaryTree b){
		this.b = b;
		
	}
	/*
	 * Returns the definition of the given word, or it returns
	 * an empty string if the word is not in the dictionary.
	 */
	public String findWord(String word){ 
		String s = b.search(word).defintion();
		
		return s; 
	
	
	}


	/**
	 * Returns the type of the given word, or it returns
     * -1 if the word is not in the dictionary
	 *  
	 */
	public int findType(String word) {
		if(b.search(word) == null){
			return -1;
		}
		else{
			int a = b.search(word).type(); 
			return a; 
	
		}
	}
	/**
	 * Adds the word, its definition, and type into the
	 * dictionary. It throws a DictionaryException if the word 
	 * is already in the dictionary.
	 * @throws DictionaryException 
	 */
	public void insert(String word, String definition, int type) throws DictionaryException{
			b.add(word,definition, type);
		
	}

	/**
	 * Removes the entry with the given word from the dictionary.
	 * It throws a DictionaryException if the word is not in the
	 * dictionary.  
	 * @throws DictionaryException
	 */

	public void remove(String word) throws DictionaryException {
		   	b.delete(word);
		
	}

	/**
	 * Returns the successor of the given word (the word from
     * the dictionary that lexicographically follows the given
     * one); it returns an empty string if the given word has
     * no successor. The given word DOES NOT need to be in the
     * dictionary. 
     */

	 
	public String successor(String word) {
			return b.next(word).word();
	}

   /**
    * Returns the predecessor of the given word (the word from
    * the dictionary that lexicographically precedes the given
    * one); it returns an empty string if the given word has
    * no predecessor. The given word DOES NOT need to be in the
    * dictionary.
    */
	public String predecessor(String word) {
			return b.last(word).word();
	}
	
	public static void main(String args[]) throws DictionaryException{
		OrderedDictionary d = new OrderedDictionary();
		String res; 
		d.insert("john", "johny", 1);	
		d.insert("flap", "flappy", 1);
		d.remove("flap");
		res = d.findWord("flap");
	    System.out.println(res); 
	    if (res == "") System.out.println("Test 4 passed");
	    else System.out.println("Test 4 failed");
		
	    
	   
	    
	    
	}

}
