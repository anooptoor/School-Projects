import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JButton;



@SuppressWarnings("serial")
public class A5Q2ReversiGUI_Square extends JButton {
	private int setSquare; 
	private int _r, _c;
	private A5Q2ReversiGUI_Board _gui;
	

	
	public A5Q2ReversiGUI_Square(int r, int c, A5Q2ReversiGUI_Board gui )
	{
		_r = r; _c = c; _gui = gui; 
		addMouseListener(new MouseSquareListener());
	}
	
	
	
	public void setSquareEmpty()
	{
		this.setText("");
		setSquare = 0;
	}
	public void setSquareWhite()
	{
		this.setText("O");
		setSquare = 2;
	}
	public void setSquareBlack()
	{
		this.setText("X");
		setSquare = 1;
	}
	private class MouseSquareListener implements MouseListener {
		public void mouseClicked(MouseEvent ev) { refreshSquare();}
		public void mouseEntered (MouseEvent e) { }
		public void mouseExited  (MouseEvent e) { }
		public void mousePressed (MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
	}
	
	public void flipSquare()
	{
		
		for(int i = 0; i < 8; i++)
		{
			if(setSquare == 1)
			{
			 _gui.guiboard[_r][i].setSquareBlack();
			
			 _gui.guiboard[i][_c].setSquareBlack();
			 
			}
			else if(setSquare == 2)
			{
			_gui.guiboard[_r][i].setSquareWhite();
		
			_gui.guiboard[i][_c].setSquareWhite();	
			
			}
			else
			{
			_gui.guiboard[_r][i].setSquareEmpty();
			
			_gui.guiboard[i][_c].setSquareEmpty();
			
			}
			
		}
	}
	public void refreshSquare()
	{
		if(setSquare == 0)
		{
			this.setText("");
		
			setSquare++;
		}
		else if(setSquare == 2)
			
		{
			this.setText("O");
			
			setSquare = 0;
		}
		else if(setSquare == 1)
		{
			this.setText("X");
			
			setSquare++;
		}
		
	}
	
	
}
	

