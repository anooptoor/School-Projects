
public class A1Q4 {
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
		int n = 16;
		boolean[] sievea = makeSieve(n);
		int a = doCancel(sievea, n);
		printPrimes(a, n);
		
		n = 256;
		boolean[] sieveb = makeSieve(n);
		int b = doCancel(sieveb, n);
		printPrimes(b, n);
		
		n = 4096;
		boolean[] sievec = makeSieve(n);
		int c = doCancel(sievec, n);
		printPrimes(c, n);
		
		n = 65536;
		boolean[] sieved = makeSieve(n);
		int d = doCancel(sieved, n);
		printPrimes(d, n);
		
		n = 1048576;
		boolean[] sievee = makeSieve(n);
		int e = doCancel(sievee, n);
		printPrimes(e, n);
		
		n = 16777216;
		boolean[] sievef = makeSieve(n);
		int f = doCancel(sievef, n);
		printPrimes(f, n);
	
		
		
	}

}
