
public class SudokuA2Q1 {
	
	int N = 0;
	int[][] board;
	public SudokuA2Q1(){
		N = 3;
		board = new int[N*N][N*N];
	
		
	}
	public void setSquare(int i, int j,  int val){
		
		if(val <= 9 && val > 0)
		{
		  board[i][j] = val;
		}
		
		
	}
	public int getSquare(int i, int j)
	{
		int val = board[i][j];
		return val;
		
		
	}
	public void show()
	{
		for(int b = 0; b < 9; b++)
		{
			for(int c = 0 ; c < 9; c++)
			{
				if(board[b][c] != 0)
				{
					System.out.print(" " + board[b][c] + " ");
				}
				else
				{
					System.out.print(" . ");
				}
				if(c == 2 || c == 5)
				{
					
					System.out.print("|");
				}
				if(c == 8)
				{
					
					System.out.println();
				}
				
				
			}
			if(b == 2  || b == 5)
			{
				System.out.println("---------+---------+--------");
			}
			
			
		}	
	}// close show
	
	

}//close class


		
		
		
		

	
	
	
	
	
	
	
	
	
	

	
