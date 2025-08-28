package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	//Retorna uma matriz de peças correspondente a partida 
	public ChessPiece[][] getPieces() {
		//variavel aux. temporaria
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		//Percorre a matriz board
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece)board.piece(i,j);//DownCast para ChessPiece - Para o jogo ver apenas as "peças de xadrez"
			}
		}
		
		return mat;
	}
	
	
	//Inicia a partida de xadrez
	//Coloca as peças no tabuleiro
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
		board.placePiece(new King(board, Color.BLACK), new Position(0,4));
		board.placePiece(new King(board, Color.WHITE), new Position(7,4));
	}
}
