
public class Reader {
	
	private Feed feed;
	private int nextItem = 0;
	private int i = 0;
	public Reader (Feed _feed){
		
		feed = _feed;
	}
	/**
	 * prints every instance of string pattern found in feed
	 * @param pattern
	 */
	public void find(String pattern)
	{
		 feed.find(pattern);
		 
		 
	}
	/**
	 * reads from value next item
	 */
	public void read()
	{
		
	
		int p = feed.readFrom(nextItem + i);
		
		i= i + p;
		
	}
	
}
