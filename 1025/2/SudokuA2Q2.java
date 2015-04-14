
public class SudokuA2Q2 {
	
	int N = 0;
	int[][] board;
	public SudokuA2Q2(){
		N = 3;
		board = new int[N*N][N*N];
	
		
	}
	public void setSquare(int i, int j,  int val){
		
		if(val <= 9 && val > 0)
		{
		  board[i][j] = val;
		}
		
		
	}
	public void fill(String[] lines)
	{
		for(int j = 0; j < 9; j++)
		{
			for(int i = 0; i < 9 ; i++)
			{
				String c = lines[j].substring(i, (i+1));
				if(c.equals("."))
				{
					board[j][i] = 0;
					
				}
				else
				{
					board[j][i] = Integer.parseInt(c);
					
				}
			
				
				
		}
			
	}
	
	}
	public void fancyfill(String[] lines)
	{
		int a = 0;
		int b = 0;
		for(int j = 0; j < lines.length ; j++)
		{
			
			a = 0;
			for(int i = 0; i < lines.length; i++)
			{
				String c = lines[j].substring(i, (i+1));
				
				if(c.equals("."))
				{
					
					board[a][b] = 0;
					a++;
					if(i == 8)
					{
						b++;
						
					}
					
				}
				else if(c.equals("|") || c.equals( "-")  || c.equals("+"))
				{
					
					
				}
				
				else
				{
					
					board[a][b] = Integer.parseInt(c);
					a++;
					if(i == 8 )
					{
						b++;
					}
				}
			
				
				
		  }
			
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


		
		
		
		

	
	
	
	
	
	
	
	
	
	

	
