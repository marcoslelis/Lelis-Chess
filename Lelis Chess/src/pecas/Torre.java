package pecas;

import tabuleiro.TabuleiroXadrez;
import tabuleiro.Posicao;

public class Torre extends Peca {

	public Torre(boolean white, boolean ehRei) {
		super(white, ehRei);
	}

	@Override
	public boolean podeMover(TabuleiroXadrez board, Posicao inicio, Posicao fim) {
		return this.moverLinhaReta(board, inicio, fim);
	}

}
