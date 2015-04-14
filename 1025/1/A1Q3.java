
public class A1Q3 {

	public static int sumofQuads(int n)
	{
		//fills array of with i^4 for each element
		int[] george = new int[n+1];
		for(int i = 1; i < george.length  ; i++)
		{
			george[i] = i*i*i*i;
			
		}
		// find total number sum of elements from above
		int sum = 0;
		for(int i = 1; i < george.length ;  i++)
		{
			sum = sum + george[i];
			
		}
		
		return sum;
		
	}
	public static void main(String args[])
	{
		int a = sumofQuads(100);
		System.out.println(a);
		a = sumofQuads(5);
		System.out.println(a);
		a = sumofQuads(1024); // Too big of a value to store in integer, negative integer is an error
		System.out.println(a);
		
		
		
		
		
		
		
	}
}
