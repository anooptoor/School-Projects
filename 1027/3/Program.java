import java.util.StringTokenizer;


public class Program {
	
	SimpleListADT<SimpleFunction> functions = new ArraySimpleList<SimpleFunction>();
	
	public Program(StringTokenizer st){
	
		while(st.hasMoreTokens()){
			SimpleFunction s =  new SimpleFunction(st);
		    functions.addToRear(s);   
		}
		
		
	}
	/**
	 * finds a function by its name
	 * @param name
	 * @return
	 */
	public SimpleFunction find(String name)
	{
		return functions.find(name);
	}
}
	
