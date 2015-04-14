
public class DictEntry {
	private String word;
	private String definition;
	private int type;
	
	public DictEntry(String word, String definition, int type){
		this.word  = word; 
		this.definition = definition; 
		this.type = type;
		
		
		
	}
	/**
	 * returns word
	 * @return
	 */
	public String word(){
		if(word != null){
			return word; 
		}
		return "";
		
	}
	/**
	 * returns definition
	 * @return
	 */
	public String defintion(){
		return definition; 
		
	}
	/**
	 * returns type
	 * @return
	 */
	public int type(){
		return type; 
	}
	
	
	
}
