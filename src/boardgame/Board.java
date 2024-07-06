package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int column) {
		if(rows < 1 || column < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column!");
		}
		this.rows = rows;
		this.columns = column;
		pieces = new Piece[rows][columns];//Matriz de peças - posição das peças.
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	//Retorna a peça que estiver na matriz de acordo com a posição informada.
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getCollumn()];
	}
	
	//Atribui uma peça a uma posição no tabuleiro
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		//Matriz de peças
		pieces[position.getRow()][position.getCollumn()] = piece;
		piece.position = position;//Informa que a peça agora possui uma posição
	}
	
	//Verifica se uma posição informada existe - por linha e coluna
	private boolean positionExists(int row, int column) {
		return row >=0 && row < rows && column >=0 && column < columns;
	}
	
	//Verifica se uma posição informada existe - pela classe posição
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCollumn());
	}
	
	//
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
