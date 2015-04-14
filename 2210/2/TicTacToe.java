
public class TicTacToe {
/**
 * This class implements all the methods needed by the algorithm computerPlay, it enables the computer to take a turn
 */
	
	private int board_size;
	private int inline;
	private int max_levels;
	private char[][] gameBoard; 
	
	public TicTacToe(int board_size, int inline, int max_levels)
	{
		this.board_size = board_size;
		this.inline = inline;
		this.max_levels = max_levels;
		gameBoard = new char[board_size][board_size];
	}
	
	/**
	 * creates Dictionary
	 * @return
	 */
	public Dictionary createDictionary()
	{
		 Dictionary dict = new Dictionary(); 
		return dict; 
		
	}
	/**
	 * checks for repeated config
	 * @param configuarations
	 * @return
	 */
	public int repeatedConfig(Dictionary configuarations)
	{
		if(configuarations.find(this.stringConfig()) != -1)
			return this.evalBoard();
		else
			return -1; 
	}
	/**
	 * converts board to string representation 
	 * @return
	 */
	private String stringConfig() {
		String config = "";
		for(int i = 0; i < board_size; i++){
			for(int j = 0; j < board_size; j++)
			{
				if(gameBoard[i][j] != '\u0000')
					config = config + gameBoard[i][j];
				else
					config = config + '_'; 
			}
		}
		
		return config; 
	}

	/**
	 * inserts a string representation into dictionary
	 * @param configuarations
	 * @param score
	 * @throws DictionaryException
	 */
	public void insertConfig(Dictionary configuarations, int score) throws DictionaryException
	{
		DictEntry config = new DictEntry(stringConfig(), score);
		configuarations.insert(config);
	}
	/**
	 * stores a move in array
	 * @param row
	 * @param col
	 * @param symbol
	 */
	public void storePlay( int row, int col, char symbol)
	{
		gameBoard[row][col] = symbol; 
		
	} 
	/**
	 * checks if square is empty
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean squareIsEmpty(int row, int col)
	{
		if(gameBoard[row][col] == '\u0000' || gameBoard[row][col] == ' ')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * checks if a symbol has won
	 * @param symbol
	 * @return
	 */
	public boolean wins(char symbol)
	{
		int winHor = 0;
		int winVer = 0;
		int winDia = 0;
		
		for(int i = 0; i < board_size; i++){
			for(int j = 0; j < board_size; j ++){
				if(gameBoard[i][j] == symbol)
				{
					winHor++;
					if(winHor == inline)
						return true;
				}
				else{ winHor = 0;}
			}
			for(int j = 0; j < board_size; j ++){
				if(gameBoard[j][i] == symbol)
				{
					winVer++;
					if(winVer == inline)
						return true;
				}
				else{ winVer = 0;}
				
			}
			if(gameBoard[i][i] == symbol)
			{
				
				winDia++;
				if(winDia == inline)
					return true;
			}
		
			
			
			winVer = 0;
			winHor = 0;
		}
		
		return false;
		
	}
	/**
	 * checks if game is a draw
	 * @return
	 */
	public boolean isDraw()
	{
		
		for(int i = 0; i < board_size; i++)
		{
			for(int j = 0; j < board_size; j++)
			{
				if (gameBoard[i][j] == '\u0000' || gameBoard[i][j] == ' ')
				{
					return false;
				}
			}
		}
		if(wins('O') == true || wins('X') == true)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public int evalBoard()
	{
		if( wins('O') == true)
		{
			return 3;
			
		}
		else if ( wins('X') == true)
		{
			return 0;
		}
		else if ( isDraw() == true)
		{
			return 2;
		}
		else
		{
			return 1;
		}
		
	}
	/**
	 * test harness 
	 * @param args
	 */
	public static void main(String args[])
	{
		TicTacToe t = new TicTacToe(3, 3, 3); 
		
		System.out.println(t.stringConfig());
		t.storePlay(0, 0, 'X' );
		t.storePlay(0, 1, 'O' );
		t.storePlay(0, 2, 'X' );
		t.storePlay(1, 0, 'O' );
		t.storePlay(1, 1, 'X' );
		t.storePlay(1, 2, 'X' );
		t.storePlay(2, 0, 'O' );
		t.storePlay(2, 1, 'X' );
		t.storePlay(2, 2, 'O' );
		System.out.println(t.isDraw()); 
		System.out.println(t.stringConfig());

	}
	
	
}
