
public class A4Q2Tester {
	public static void main(String args[])
	{
		MultitouchTrace a = new MultitouchTrace(); //Trace Object
		int test[] = new int[10];
		
		for(int i = 0; i < 10; i++)
		{
			test[i] = 2;// test array set all values to 2
		}
		//test methods of MultitouchTrace
		a.addPoint(test);
		
		System.out.println(a.touch[0]);
		System.out.println(a.length());
		System.out.println(a.numberOfPointsAt(0));
		System.out.println(a.YAt(0,1));
	}

}
