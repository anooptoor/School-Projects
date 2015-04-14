import java.awt.*;

import javax.swing.*;
@SuppressWarnings("serial")
public class A5Q1ReversiGUI_Board  extends JFrame{
	private int rows, cols;
	
	public A5Q1ReversiGUI_Square[][]  guiboard;


	
	public A5Q1ReversiGUI_Board(){
		super("Reversi");
		
		rows = 8;
		cols = 8;

		// Create a 2 d array for the board.
		guiboard = new A5Q1ReversiGUI_Square[rows][cols];
		
		// Create squares and add them to the current frame in a grid.
		setLayout( new GridLayout(rows,cols));
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				guiboard[i][j] = new A5Q1ReversiGUI_Square(i, j, this);
				add(guiboard[i][j]);
			}
		pack();
		setVisible(true);
		
		
		
		
		
	}


}
