import java.util.ArrayList;
import java.util.Iterator;


public class Graph implements GraphADT {
    private int n;
    private Node[] graph;
    private ArrayList<Edge> e = new ArrayList<Edge>();
    private boolean[][] adj;
	public Graph (int n){
		this.n = n;
		graph = new Node[n];
		for(int i = 0; i < n; i++){
			graph[i] = new Node(i); 
		}
		adj = new boolean[n][n];
	}
	/**
	 * inserts edge into graph
	 */
	public void insertEdge(Node u, Node v, String type) throws GraphException{
			boolean realV = false;
			boolean realU = false;
			for(int i = 0; i < n; i++){
				
					if(graph[i].getName() == u.getName()){
						realU = true;
					
					}
					else if(graph[i].getName() == v.getName()){
						realV = true;
						
					
				}
			}
			if(realU == false || realV == false){
				throw new GraphException("Error: Node not in Graph");
			}
			Edge b = new Edge(u, v, type);
			for(Edge a : e){
				if(a.firstEndpoint().equals(u) && a.secondEndpoint().equals(v)){
					throw new GraphException("Error: Edge already in Graph");
				}
				
			}
			e.add(b); 
			 
		
	}

	/**
	 * get node from graph, throws exception if node can not be found
	 */
	public Node getNode(int name) throws GraphException {
		
		for(int i = 0; i < n; i++){
			
					if(graph[i].getName() == name){
						return graph[i];
					}
			
				
			}
		throw new GraphException("Node does not exist"); 
		
	}

	
	public Iterator<Edge> incidentEdges(Node u) throws GraphException {
		if(e.size() > 0){
			ArrayList<Edge> b = new ArrayList<Edge>();
			for(Edge a: e){
				if(a.firstEndpoint().equals(u)){
					b.add(a);
				}
				else if(a.secondEndpoint().equals(u)){
					b.add(a);
				}
			}
			return b.iterator(); 
			
		}
		throw new GraphException("No adjacent edges");  
	}

	/**
	 * for each loop to get to every edge 
	 */
	public Edge getEdge(Node u, Node v) throws GraphException {
		
		for( Edge a : e){
			if(a.firstEndpoint().equals(u) && a.secondEndpoint().equals(v) || a.firstEndpoint().equals(v) && a.secondEndpoint().equals(u)){
				return a;
			}
		}
		throw new GraphException(""); 
		
	}

	/**
	 * returns true if both nodes have an edge connecting them
	 */
	public boolean areAdjacent(Node u, Node v) throws GraphException {
		this.getNode(u.getName());
		this.getNode(v.getName());
		int uName = u.getName();
		int vName = v.getName(); 
		int aName1;
		int aName2;
		for( Edge a : e){
			aName1 = a.firstEndpoint().getName(); 
			aName2 = a.secondEndpoint().getName();	
			if(aName1 == uName && aName2 == vName || aName1 == vName && aName2 == uName){
				return true;
			}
		}
		return false; 
		
	}
	

}
