import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JButton;



@SuppressWarnings("serial")
public class A5Q4ReversiGUI_Square extends JButton {
	private int setSquare; 
	private int _r, _c;
	private A5Q4ReversiGUI_Board _gui;
	private A5Q4ReversiPosition _position;

	
	public A5Q4ReversiGUI_Square(int r, int c, A5Q4ReversiGUI_Board gui, A5Q4ReversiPosition position )
	{
		_r = r; _c = c; _gui = gui; _position = position;
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
		public void mouseClicked(MouseEvent ev) { refreshSquare(); flipSquare();}
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
			 _position.setSquare(_r, i, 'X');
			 _gui.guiboard[i][_c].setSquareBlack();
			 _position.setSquare(i, _c, 'X');
			}
			else if(setSquare == 2)
			{
			_gui.guiboard[_r][i].setSquareWhite();
			_position.setSquare(_r, i, 'O');
			_gui.guiboard[i][_c].setSquareWhite();	
			_position.setSquare(i, _c, 'O');
			}
			else
			{
			_gui.guiboard[_r][i].setSquareEmpty();
			_position.setSquare(_r, i, ' ');
			_gui.guiboard[i][_c].setSquareEmpty();
			_position.setSquare(i, _c, ' ');
			}
			
		}
	}
	public void refreshSquare()
	{
		if(setSquare == 0)
		{
			this.setText("");
			_position.setSquare(this._r, this._c, ' ');
			setSquare++;
		}
		else if(setSquare == 2)
			
		{
			this.setText("O");
			_position.setSquare(this._r, this._c, 'O');
			setSquare = 0;
		}
		else if(setSquare == 1)
		{
			this.setText("X");
			_position.setSquare(this._r, this._c, 'X');
			setSquare++;
		}
		
	}
	
	
}
	

