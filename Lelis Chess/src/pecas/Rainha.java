package pecas;

import tabuleiro.TabuleiroXadrez;
import tabuleiro.Posicao;

public class Rainha extends Peca {

	public Rainha(boolean white, boolean ehRei) {
		super(white, ehRei);
	}

	@Override
	public boolean podeMover(TabuleiroXadrez board, Posicao inicio, Posicao fim) {
		if(inicio.getX() == fim.getX() || inicio.getY() == fim.getY())
			return this.moverLinhaReta(board, inicio, fim);
		else return this.moverDiagonal(board, inicio, fim);
	}
	
}
