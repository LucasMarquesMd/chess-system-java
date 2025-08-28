package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //Matriz de peças (com posições nulas)
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
	
// Metodos
	
	//Retorna a peça de acordo com a linha e coluna informada.
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	//Retorna a peça pela posição
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		//Atribui uma peça na matriz pieces[][]
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; // Informa que a peça não tem mais uma posição nula
	}
}
