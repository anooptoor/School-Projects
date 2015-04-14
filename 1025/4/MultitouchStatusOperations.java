


public class MultitouchStatusOperations {
	
	
	
	public static long makeStatusWord()
	{
		return 0L; // return long of 0 to represent no touch
		
	}
	
	public static long makeStatusWord(int x1, int y1, int p1)
	{
			
		
			
		return  1L | ((long)x1 <<4 ) | ((long)y1 << 13) | ((long)p1 <<55); // make status word for 1 point
			
		
	}
	public static long makeStatusWord(int x1, int y1, int p1, 
		                                      int x2, int y2, int p2)
	{
			
		return 2L | ((long)x1 <<4 ) | ((long)y1 << 13) | ((long)p1 <<55) | ((long)x2 << 21) | ((long) y2 << 30) | ((long) p2 << 58) ; // make status word for 2 points
		
		
		
		
	}
	
	public static long makeStatusWord(int x1, int y1, int p1, 
		                                      int x2, int y2, int p2,
		                                      int x3, int y3, int p3){
			
		return 3L | ((long)x1 <<4 ) | ((long)y1 << 13) | ((long)p1 <<55) | ((long)x2 << 21) | ((long) y2 << 30) | ((long) p2 << 58) | ((long) x3 << 38) | ((long) y3 << 47) | ((long) p3 << 61) ; // make status word for 3 points
		
		
	}
	public static int numberOfPoints(long statusWord)
	{
			
		return (int)(statusWord & 0xF); // return number of points
		
	}
	public static int x1(long statusWord)
	{
		return (int) ((statusWord & (0x1FFL << 4)) >>> 4); // return value for x1 
		
	}
	public static int y1(long statusWord)
	{
		return (int) ((statusWord & (0xFFL << 13)) >>> 13); // return value for y1
		
	}
	public static int x2(long statusWord)
	{
		return (int) ((statusWord & (0x1FFL << 21)) >>> 21); // return value for x2
	}
	public static int y2(long statusWord)
	{
		return (int) ((statusWord & (0xFFL << 13)) >>> 13); // return value for y2
		
	}
	public static int x3(long statusWord)
	{
		return (int) ((statusWord & (0x1FFL << 38)) >>> 38); // return value for x3
	}
	public static int y3(long statusWord)
	{
		return (int) ((statusWord & (0xFFL << 47)) >>> 47); // return value for y3
	}
	public static int p1(long statusWord)
	{
		return (int) ((statusWord & (0x7L << 55)) >>> 55); // return value for p1
	}
	public static int p2(long statusWord)
	{
		return (int) ((statusWord & (0x7L << 58)) >>> 58); // return value for p2
	}
	public static int p3(long statusWord)
	{
		return (int) ((statusWord & (0x7L << 61)) >>> 61); // return value for p3
	}
}
		
