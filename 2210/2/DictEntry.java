
public class DictEntry {

/**
 * This class represents an entry in the dictionary, associating a configuration with its integer score.
 * Each board configuration will be represented as a string as follows: concatenate all characters placed
 * in the board starting at the top left position and moving from left to right and from top to botom
 */
	private String config;
	private int score;
	public DictEntry(String config, int score)
	{
		this.config = config;
		this.score = score; 
		
		
	}
	/**
	 * returns board config
	 * @return config
	 */
	public String getConfig()
	{
		
		return config;
		
	}
	/**
	 * returns board score
	 * @return score
	 */
	public int getScore()
	{
		
		return score;
		
	}
	
}
