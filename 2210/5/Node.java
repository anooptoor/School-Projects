
public class Node {
	private int name;
	private boolean mark;
	public Node(int name){
		this.name = name;
		mark = false;
	}
	/**
	 * sets mark 
	 * @param m
	 */
	public void setMark(boolean m){
		mark = m; 
		
	}
	/**
	 * getter for mark
	 * @return
	 */
	public boolean getMark(){
		return mark;
		
	}
	/**
	 * getter for name
	 * @return
	 */
	public int getName(){
		return name;
		
	}
	
}
