
import java.io.*;


public class A3Q2DNAExtractor {

String sequence = "";
	
	public A3Q2DNAExtractor(String filename){
		
		try {
            // This creates an object from which you can read input lines.
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line = null;

            // readLine reads input lines (without the \n), catching any 
            // exceptions, and returns null if there is no more input.
            while ((line = reader.readLine()) != null)
                    
            		sequence = sequence + line;
            			
        }
        catch (IOException e) {
            System.out.println("Caught IO exception");
        }
		
		
	}
	public String getDNA(){
		
		String b = ""; 
		for(int i = 0; i < sequence.length(); i++)
		{
			String c = sequence.substring(i, i+1);
			if((c.equals("g") || c.equals("c") ||c.equals("t") ||c.equals("a")))
			{
				b = b + c;
				
			}
		}
		 return b;
	 }

}
