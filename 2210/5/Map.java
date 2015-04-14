import java.io.*;
import java.util.*;



public class Map {
	private String inputFile;
	private Graph graph;
	private int start;
	private int end;
	
	private int width;
	private int length;
	private int numtoll;
	
   
    private Stack<Node> nodes = new Stack<Node>();
    private boolean finished = false;
   
	/**
	 * reads map input
	 * @param inputFile
	 * @throws MapException
	 */
	public Map(String inputFile) throws MapException{
		
		try{
			//takes values from input
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			in.readLine();
			width = Integer.parseInt(in.readLine());
			
			length = Integer.parseInt(in.readLine());
			
			numtoll = Integer.parseInt(in.readLine());
											
			graph = new Graph(width*length);
			
			int current = 0; 
			String s;
			char[] line;
			
			//reads chars line by line, and letter by letter
			while((s = in.readLine()) != null){
				line = s.toCharArray();
				for(int i = 0; i < s.length(); i++){
					
					
					if(line[i] == 's'){
						start = current;
						current++;
						
					}
					else if (line[i] == 'e'){
						end = current;
						current++;
						
					}
					else if (line[i] == 'o'){
						current++;
						
					}
					else if(line[i] == 'h'){
						graph.insertEdge(graph.getNode( current - 1), graph.getNode(current), "toll");
						
					}
					else if(line[i] == 'v'){
						graph.insertEdge(graph.getNode(current - width + (( i + 1 ) / 2)), graph.getNode(current + (( i + 1 ) / 2)), "toll");
						
					}
					else if (line[i] == '-'){
						graph.insertEdge(graph.getNode(current - 1), graph.getNode(current), "free");
						
					}
					else if(line[i] == '|'){
						graph.insertEdge(graph.getNode(current - width + ((  i + 1) / 2 )), graph.getNode(current+(( i + 1 ) / 2)), "free");
						
					}
					else if(line[i] == ' ') {
						
					}
						
				}
				
			}
			in.close();
			

			
		}catch(Exception e){
			throw new MapException("Cannot find file");
		}
	}
	/**
	 * getter for graph
	 * @return
	 */
	public Graph getGraph() throws MapException{
		if(graph == null){
			throw new MapException("Error Graph not defined");
		}
		return graph;
	}
	/**
	 * returns path iterator for map
	 * @return
	 * @throws GraphException
	 */
	public Iterator<Node> findPath() {
		try{
		nodes.push( graph.getNode( start ));
		dfs(start);
		if(nodes.isEmpty() == true){
			return null;
		}
		return nodes.iterator();
		}
		catch(GraphException e){
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * recursive function for depth-first-travel
	 * @param n
	 * @throws GraphException
	 */
	private void dfs( int n) throws GraphException{
		
		Node u = graph.getNode(n);
		Node v;
		Edge e;
		int testEnd;
		graph.getNode(n).setMark(true);
		Iterator<Edge> track = graph.incidentEdges(u);
		
		while (track.hasNext()) {
			e = track.next();
			v = e.secondEndpoint();
			testEnd = u.getName();
			if(testEnd == end){
				finished = true;
			}	
			if(graph.getNode(v.getName()).getMark() == false && finished == false){
				if((e.getType().equals("free")) ){
					nodes.push(v);
					dfs(v.getName());
				}
				else if((e.getType().equals("toll")  && numtoll != 0)){
					numtoll--;
					nodes.push(v);
					dfs(v.getName());
				}
				
			}
		}
		if(finished == false ){
			nodes.pop();
			if(nodes.isEmpty() == false){
				v = nodes.peek();
				graph.getNode(v.getName()).setMark(false); 
				if(graph.getEdge(u, v).getType().equals("toll")){
					numtoll++;
				}
			}
		}
		
		
		
		
		
		}
		
	}
	
	

