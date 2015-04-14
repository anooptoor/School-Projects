
public class TesterA2Q1 {
	
	public static void main(String args[])
	{
		SudokuA2Q1 game = new SudokuA2Q1();
		game.setSquare(5, 4, 1);
		game.show();
		int p = game.getSquare(5, 4);
		System.out.print(p);
		
		
		
		
	}

}
