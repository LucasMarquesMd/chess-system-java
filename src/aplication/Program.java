package aplication;

import chess.ChessMatch;

public class Program {
	public static void main(String[] args) {
		
		//Instancia uma partida de xadrez
		ChessMatch chessMatch = new ChessMatch();
		
		UI.printBoard(chessMatch.getPieces());
	}
}
