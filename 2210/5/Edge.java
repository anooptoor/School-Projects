
public class Edge {
	Node u;
	Node v;
	String type;
	String label;
	public Edge(Node u, Node v, String type){
		this.u = u;
		this.v = v;
		this.type = type;
		label = ""; 
		
	}
	/**
	 * getter for first endpoint
	 * @return
	 */
	public Node firstEndpoint(){
		return u;
	}
	/**
	 * getter for second endpoint
	 * @return
	 */
	public Node secondEndpoint(){
		return v;
	}
	/**
	 * getter for type
	 * @return
	 */
	public String getType(){
		return type;
	}
	/**
	 * setter for label
	 * @param label
	 */
	public void setLabel(String label){
		this.label = label;
	}
	/**
	 * getter for label
	 * @return
	 */
	public String getLabel(){
		return label;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	
}
