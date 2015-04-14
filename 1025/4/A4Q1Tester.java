
public class A4Q1Tester{
	public static void main(String[] args)
	{
		
		long p = MultitouchStatusOperations.makeStatusWord(2, 2, 6, 2, 2, 6, 2, 2, 6); // create Status Word with 3 touch points
		System.out.println(MultitouchStatusOperations.x1(p)); // all values from long
		System.out.println(MultitouchStatusOperations.x2(p)); 
		System.out.println(MultitouchStatusOperations.x3(p)); 
		System.out.println(MultitouchStatusOperations.y1(p)); 
		System.out.println(MultitouchStatusOperations.y2(p)); 
		System.out.println(MultitouchStatusOperations.y3(p)); 
		System.out.println(MultitouchStatusOperations.p1(p)); 
		System.out.println(MultitouchStatusOperations.p2(p)); 
		System.out.println(MultitouchStatusOperations.p3(p)); 
		System.out.println(MultitouchStatusOperations.numberOfPoints(p));
		
		
		
		
	
		
		
		
		
	}
}
