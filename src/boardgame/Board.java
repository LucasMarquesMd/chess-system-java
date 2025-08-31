package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 collumn");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //Matriz de peças (com posições nulas)
	}


	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}
	
// --- METODOS ----
	
	//Retorna a peça de acordo com a linha e coluna informada.
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	//Retorna a peça pela posição
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		//Atribui uma peça na matriz pieces[][]
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; // Informa que a peça não tem mais uma posição nula
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		
		Piece aux = piece(position);
		aux.position = null; // A peça não tem mais posição no tabuleiro.
		// A posição da peça na matriz fica nula.
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	
	// METODOS DE VERIFICAÇÃO
	
	//Classe auxiliar
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	//Verifica se a posição existe no tabuleiro
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	//Verifica se a peça existe no tabuleiro
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
