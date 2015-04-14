
public class SudokuA2Q3 
{
	
	int N = 0;
	int[][] board;
	public SudokuA2Q3(){
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
					
					board[b][a] = 0;
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
					
					board[b][a] = Integer.parseInt(c);
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
	public boolean isSolution()
	{

		int[] cut = new int[10];
		
		boolean a = false;
		for(int j = 0; j < 9; j++)
		{
			
			for(int i = 0; i < 9; i++)
			{
				
				cut[i + 1] = board[i][j]; 
				//System.out.print(cut[i+1]);
				
			}	
			
			a = check(cut);
			
			if( a == false)
			{
				return false;
				
			}
			
		}
		for(int j = 0; j < 9; j++)
		{
			
			for(int i = 0; i < 9; i++)
			{
				
				cut[i + 1] = board[j][i]; 
				//System.out.print(cut[i+1]);
				
			}	
			
			a = check(cut);
			
			if( a == false)
			{
				return false;
				
			}
			
			
		}
		for(int j = 0; j < 9; j++)
		{
			
			for(int i = 0; i < 9; i++)
			{
				
				cut[i + 1] = board[i][j]; 
				//System.out.print(cut[i+1]);
				
			}	
			
			a = check(cut);
			
			if( a == false)
			{
				return false;
				
			}
			
			
		}
		for(int j = 0; j < 9; j++)
		{
			
			for(int i = 0; i < 9; i++)
			{
				
				cut[i + 1] = board[(3*(i/3)) + i%3 ][(3*(j%3)) + j%3] ;
				//System.out.print(cut[i+1]);
				
			}	
			
			a = check(cut);
			
			if( a == false)
			{
				return false;
				
			}
			
			
		}
		
		
		
		
		
		
		

		return true;
	}
	public static boolean check(int[] slice) 
	{
		
			boolean[] row = new boolean[10];
			row[0] = false;
			for(int j = 1; j <= 9; j++)
			{
				
				row[j] = false;
				
					
			}
			for(int i = 1; i <= 9; i++ )
			{
				if(row[slice[i]] == true)
				{
					
					
					//System.out.println(slice[i] + " " + i);
					return false;
				}
				else
				{
					
					row[slice[i]] = true;	
				}	
			}
			return true;
	}

	
	
	

}//close class


		
		
		
		

	
	
	
	
	
	
	
	
	
	

	
