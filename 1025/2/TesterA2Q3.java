
public class TesterA2Q3 {
	
	public static void main(String args[])
	{
		
		String[] sudoku = new String[] 
		
		
			{	"534678912",
				"672195348",
				"198342567",
				
				"859761423",
				"426853791",
				"713924856",
				
				"961537284",
				"287419635",
				"345286179"};
				
			
		
			
		
				
		SudokuA2Q3 game = new SudokuA2Q3();
		
		game.fancyfill(sudoku);
		game.show();
		boolean a = game.isSolution();
		if( a == true)
		{
			System.out.print("The Sudoku Solution is Correct");
		
			
		}
		
		
		
		
		
		
	}

}
