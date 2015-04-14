/**
 * Representation of a position in a Reversi game.
 * The board is represented with a single array to cut down
 * on the number of storage allocations (since game play
 * allocates lots of these).
 * 
 * @author Stephen M. Watt
 */
public class A5Q4ReversiPosition {
	private int      _nrows, _ncols;
	private char[] 	 _board;
	
	
	
	/**
	 * Create a new position that has all the squares empty.
	 * 
	 * @param nrows number of rows.
	 * @param ncols number of columns.
	 */
	public A5Q4ReversiPosition(int nrows, int ncols) {
		_nrows = nrows; _ncols = ncols;
		_board = new char[_nrows*_ncols];
		clear();
	}
	/**
	 * @return the number of rows.
	 */
	public int nrows() { return _nrows; }
	/**
	 * @return the number of columns.
	 */
	public int ncols() { return _ncols; }
	/**
	 * Is the numbered square inside the board?
	 */
	public boolean isInBounds(int r, int c) {
		return 0 <= r && r < _nrows && 0 <= c && c < _ncols;
	}

	/**
	 * Get the contents of a square.
	 * @param r the row of the square (0 <= r < _nrows)
	 * @param c the column of the square (0 <= c < _ncols).
	 * @return the content of the square: White, Black or Empty.
	 */
	public int getSquare(int r, int c) { return _board[r*_ncols+c]; }
	
	/**
	 * Set the contents of a square to one of White, Black or Empty.
	 * @param r the row of the square (0 <= r < _nrows)
	 * @param c the column of the square (0 <= c < _ncols)
	 * @param contents White, Black or Empty.
	 */
	public void setSquare(int r, int c, int contents) {
		_board[r*_ncols+c] = (char) contents;
	}
	/**
	 * Clear a position.  That is, set all the squares to empty.
	 */
	public void clear() {
		
	}
	
	/**
	 * Fill a position with squares containing the given color.
	 * This could be Black, White or Empty.
	 * 
	 * @param the color to fill with.
	 */
	public void fill(int color) {
		for (int i = 0; i < _nrows*_ncols; i++) _board[i] = (char) color;
	}
	/**
	 * Create a copy of a position so that it may be modified
	 * without affecting the original.
	 * @return the copy.
	 */
	public A5Q4ReversiPosition copy() {
		A5Q4ReversiPosition newpos = new A5Q4ReversiPosition(_nrows, _ncols);
		copyInto(newpos);
		return newpos;
	}
	/**
	 * Copy this position into another.
	 */
	public void copyInto(A5Q4ReversiPosition other) {
		for (int i = 0; i < _nrows*_ncols; i++) other._board[i] = _board[i];
	}

	
	
	

}