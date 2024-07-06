package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int column) {
		this.rows = rows;
		this.columns = column;
		pieces = new Piece[rows][columns];//Matriz de peças - posição das peças.
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getCollumn()];
	}
	
	//Atribui uma peça a uma posição no tabuleiro
	public void placePiece(Piece piece, Position position) {
		//Matriz de peças
		pieces[position.getRow()][position.getCollumn()] = piece;
		piece.position = position;//Informa que a peça agora possui uma posição
	}
}
