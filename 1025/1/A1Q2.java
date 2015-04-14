
public class A1Q2 {
	// Make a boolean array of the desired size with all elements true
	public static boolean[] makeSieve (int n) {
		
		boolean[] marks = new boolean[n];
		for(int i = 2; i < marks.length; i++)
		{
			marks[i] = true;
				
			
		}
		return marks;
		
	}
	//Cancel the multiples k*n, for k = 2, 3, etc
	//Solution taken from class slides
	public static void doCancel(boolean[] marks, int n){
		for(int i =0 ; i < n; i++)
		{
			
			if(marks[i] == true)
			{
				for( int j = 2; j * i < marks.length; j++)
				{
					marks[i*j] = false;
					
				}
				
			}
		}
		
	}
	//Print out the required results
	public static void printPrimes(boolean[] marks){
		
		for( int i = 0; i < marks.length; i++)
		{
			if(marks[i] == true)
			{
				System.out.println( i);
			}
		 
			
		}
				
	}
	public static void main(String[] args){
		boolean[] sieve = makeSieve(1000); //makes boolean array size 1000
		doCancel(sieve, 1000); // uses cancel solution to find prime numbers
		printPrimes(sieve); // prints only prime numbers
		
	
		
		
	}

}
