
public class A3Q3Tester {
	
	public static void main(String args[])
	{
		A3Q1DNASequence a = new A3Q1DNASequence("catgcggtcagcatcgatcgaaaagtagtaa");
		System.out.println(a.baseAt(3));
		System.out.println(a.baseLength());
		System.out.println(a.baseString());
		A3Q1DNASequence b = a.complement();
		System.out.println(b.baseString());
		A3Q3proteinDNA c = new A3Q3proteinDNA(a, 0);
		System.out.println(c.acidAt(1));
		System.out.println(c.acidString());
		System.out.println(c.acidLength());
		
		
		
		
		
		
		
		
		
		
	}

}
