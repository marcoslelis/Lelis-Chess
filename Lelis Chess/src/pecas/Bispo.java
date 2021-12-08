package pecas;

import tabuleiro.TabuleiroXadrez;
import tabuleiro.Posicao;

public class Bispo extends Peca {

	public Bispo(boolean white, boolean ehRei) {
		super(white, ehRei);
	}

	@Override
	public boolean podeMover(TabuleiroXadrez board, Posicao inicio, Posicao fim) {
		return this.moverDiagonal(board, inicio, fim);
	}

}
