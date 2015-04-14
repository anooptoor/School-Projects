
public class MultitouchTrace {
	long[] touch = new long[20];
	int lastTouch = 0;
	
	
	public MultitouchTrace()
	{
		
	}
	public int length()
	{
		for(int i = 0; i < touch.length; i++)
		{
			if(touch[i] == 0)
			{
				return i; //count until empty value in array. return the value, signifying the amount of used spots due to the of set of array spot 0
			}
			
		}
		
		return -1; //error return
		
	}
	public long[] resizeArray(long[] a)
	{
		int c = a.length; 
		long[] b = new long[2*c]; // make array of double original size
		for(int i = 0; i < c; i ++)
		{
			b[i] = a[i]; // moves values into new bigger array
		}
		return b; //return bigger array
	}
	public void addPoint(int[] data)
	{
		long i = 0L;
		int j = data[0];
		if(j == 1){
			i = MultitouchStatusOperations.makeStatusWord(data[1], data[2], data[3]);  // add 1 touch point
		}
		else if(j == 2){
			i = MultitouchStatusOperations.makeStatusWord(data[1], data[2], data[3], data[4], data[5], data[6]); // add 2 touch points
		}
		else if(j == 3){
			i = MultitouchStatusOperations.makeStatusWord(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]); //add 3 touch points
		}
		touch[lastTouch] = i; // add to smallest numbered available element in array
		lastTouch++; // increment smallest available element
		if(lastTouch == touch.length)// check if array has reaches its size
			touch = this.resizeArray(touch); // double size if reached max capacity
		
		
	}
	 public int numberOfPointsAt(int i)
	 {
		 	
		return MultitouchStatusOperations.numberOfPoints(touch[i]);
		
	 }
	 public int XAt(int i, int j)
	 {
		 //return a value at time i in for touch 1, 2 or 3 which is represented by j
		if(j == 1)
		{
			return MultitouchStatusOperations.x1(touch[i]);
		}
		else if(j == 2)
		{
			return MultitouchStatusOperations.x2(touch[i]);
		}
		else
		{
			return MultitouchStatusOperations.x3(touch[i]);
		}
		 
	 }
	 public int YAt(int i, int j)
	 {
		//return a value at time i in for touch 1, 2 or 3 which is represented by j
		if(j == 1)
		{
			return MultitouchStatusOperations.y1(touch[i]);
		}
		else if(j == 2)
		{
			return MultitouchStatusOperations.y2(touch[i]);
		}
		else
		{
			return MultitouchStatusOperations.y3(touch[i]);
		}
		 
	 }
	 public int PAt(int i, int j)
	 {
		//return a value at time i in for touch 1, 2 or 3 which is represented by j
		 if(j == 1)
		 {
			return MultitouchStatusOperations.p1(touch[i]);
		 }
		 else if(j == 2)
		 {
			return MultitouchStatusOperations.p2(touch[i]);
		 }
		 else
		 {
			return MultitouchStatusOperations.p3(touch[i]);
		 }
		 
	 }
	
}
