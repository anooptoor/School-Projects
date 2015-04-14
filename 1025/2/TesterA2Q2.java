
public class TesterA2Q2 {
	
	public static void main(String args[])
	{
		
		String[] sudoku = new String[9];
		for(int i = 0; i < 9; i++)
		{
			sudoku[i] = "..9..8..4";
		}
				
		SudokuA2Q2 game = new SudokuA2Q2();
		game.setSquare(5, 4, 1);
		game.fancyfill(sudoku);
		game.show();
		int p = game.getSquare(5, 4);
		
		
		
		
	}

}
