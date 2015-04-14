
public class Feed {
	private String name;
	private String[] list = new String[5];
	private int size;
	
	
	public Feed(String _name)
	{
		name = _name;
		
	}
	/**
	 * getter for variable size
	 * @return
	 */
	public int getSize()
	{
		
		
		return size;
	}
	/**
	 * adds new item to list array, expands array if nessacary
	 * @param item
	 */
	public void add(String item)
	{
		
		list[size] = item;
		size++;
		if(size >= list.length)
		{
			list = this.expandArray();
		}
		 
	}
	/**
	 * expands array
	 * @return
	 */
	public String[] expandArray() {
		String[] largerList = new String[list.length + 1 * 2];
		for (int i = 0; i < size; i++)
			largerList[i] = list[i];
		
			return largerList;
	}
	/**
	 * finds pattern in list
	 * @param pattern
	 */
	 public void find(String pattern){
		 for(int i = 0; i < size; i++)
		 {
			 if(list[i].contains(pattern)){
				 System.out.println("name:" + name + " " + list[i]);
				 
			 }
		 }
		 
	 }
	 /**
	  * records the last read element of the list, and reads from that value upon being called
	  * @param start
	  * @return
	  */
	 public int readFrom(int start){
		 
		 
		 for(int i = start  ; i <= size; i++)
		 {
			 if(list[i] != null)
			 {
				
				 System.out.println(list[i]);
			 }
		 }
		 return (size - start);
		 
	 }
	 
}
	 

