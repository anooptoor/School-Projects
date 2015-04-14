
public class A3Q1DNASequence {
	String sequence = "";
	public A3Q1DNASequence(String s)
	{
		for(int i = 0; i < s.length(); i++)
		{
			String c = s.substring(i, i+1);
			if(c.equals("g") || c.equals("a") || c.equals("t") || c.equals("c"))
			{
				sequence = sequence + c;
			}
			
		}
	}
	public int baseLength()
	{   
		return (sequence.length() -1);
	}
	public char baseAt(int i)
	{
		char[] bases = sequence.toCharArray();
		return bases[i];
		
	}
	public String baseString()
	{	
		return sequence;
	}
	public A3Q1DNASequence complement()
	{
		String b = "";
		for(int i = 0; i < sequence.length(); i++)
		{
			String c = sequence.substring(i, i+1);
			if(c.equals("g"))
			{
				b = b + "c";
			}
			if(c.equals("c"))
			{
				b = b + "g";
			}
			if(c.equals("a"))
			{
				b = b + "t";
			}
			if(c.equals("t"))
			{
				b = b + "a";
			}
		}
		
		A3Q1DNASequence a = new A3Q1DNASequence(b);
		
		return a;
	}
	
}
