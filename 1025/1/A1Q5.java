
public class A1Q5 {
	// Make a boolean array of the desired size with all elements true
	public static boolean[] makeSieve (int n) {
		
		boolean[] marks = new boolean[n];
		for(int i = 2; i < marks.length; i++)
		{
			marks[i] = true;
				
			
		}
		return marks;
		
	}
	//Cancel the multiples k*n, for k = 2, 3, etc, counts number of primes
	public static int doCancel(boolean[] marks, int n){
		int primecount = 0;
		for(int i =0 ; i < n; i++)
		{
			
			if(marks[i] == true)
			{
				primecount++;
				for( int j = 2; j * i < marks.length; j++)
				{
					marks[i*j] = false;
					
				}
				
			}
		}
		return primecount;
		
	}
	//Print out the required results
	public static void printPrimes(int primecount, int n){
		
		
			
			System.out.println("There are " + primecount + " prime numbers under " + n);
			
			
		
				
	}
	public static void main(String[] args){
		
		int n = 2;
		for(int i = 1; i < 25; i++)
		{
			long b = System.currentTimeMillis(); //start time
			
			boolean[] sieve = makeSieve(n);
			int a = doCancel(sieve, n);
			printPrimes(a, n);
			long time =  System.currentTimeMillis() - b; // find total time
			System.out.println(time + "ms for value " + n); // prints time to complete program
			n = n* 2;
		}
		
	
		
		
	}

}
