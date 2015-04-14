import java.util.StringTokenizer;


public class SimpleFunction {
	private SimpleListADT<String> arguments = new ArraySimpleList<String>();
	
	private SimpleListADT<String> steps = new ArraySimpleList<String>();
	String name = "";
	String c = "";
	public SimpleFunction(StringTokenizer input){
		name = input.nextToken();
		c = input.nextToken();
		while(c.equals("{") != true)
		{
			arguments.addToRear(c);
			c= input.nextToken();
		}
		c = input.nextToken();
		while(c.equals("}") != true)
		{
			steps.addToRear(c);
			c= input.nextToken();		
		} 
	}
	/**
	 * Evaluates the expression, able to handle functions calling functions
	 * @param stack
	 * @param prog
	 */
	public void eval(StackADT<Integer> stack,Program prog){
		SimpleListADT<Integer> vals =  new ArraySimpleList<Integer>();
		
		SimpleFunction func = null;
		int index = 0;
		//move values onto list
		for(int i = 0; i <= stack.size(); i++)
		{
			int p = stack.pop();
			vals.addToRear(p);
			
		}
		//iterate through steps
		for( int i=0; i< steps.size();i++)
		{
				 String s = steps.get(i);
				 if(s.equals("+"))
				 {
					 int int1= vals.get(0); //grabs first value
					 int int2;
					 //grabs second value if it exists
					 if(vals.size() > 1)
					 {
						 int2= vals.get(1);
					 }
					 else
					 {
						 int2 = vals.get(0);
					 }
				     stack.push(int1+int2);
				 }
				 else if(s.equals("-"))
				 {
					 int int1= vals.get(0); //grabs first value
					 int int2;
					 //grabs second if it exists
					 if(vals.size() > 1)
					 {
						 int2= vals.get(1);
					 }
					 else
					 {
						 int2 = vals.get(0);
					 }
					 
					stack.push(int1-int2);
				 }
				 else if( s.equals("*"))
				 {
					 int int1= vals.get(0); //grabs first value
					 int int2;
					 //grabs second if it exists
					 if(vals.size() > 1)
					 {
						 int2= vals.get(1);
					 }
					 else
					 {
						 int2 = vals.get(0);
					 }
				     stack.push(int1*int2);
				 }
				 
				 if(prog!=null)// if function calling function
				 {
					 func = prog.find(s); //find function
				 
					 if(func!=null) 
						 func.eval(stack,prog);

				 		index=arguments.indexOf(s);
				 		 if(index != -1)
						 {
							 stack.push(vals.get(index));
						 }
				 }
				 //semi-working bonus section
				if( s.equals("zero?"))
				{
					       int int1 = vals.get(0);
					       if(int1 !=0)
					       {
					          while(steps.get(i).equals("done") != true)
					          { 
					        	  i++;
					          }
					       }
				}
				 if( s.equals("nonzero?"))
				 {
					       int int1=vals.get(0);
					       if(int1==0)
					       {  
					    	   while(steps.get(i).equals("done") != true)
					    	   {
					 			i++;
					    	   }
					       }
				  
				 }
		
		}
	}
	/**
	 * evaluates the function, use only for simple non "function calling function" functions
	 * @param stack
	 */
	public void eval(StackADT<Integer> stack){
			eval(stack, null); //program is null so that it cannot be considered recursive
		
		
		
			
			
	}
	/**
	 * returns name of function
	 */
	public String toString(){
	    return name;
	}

}
