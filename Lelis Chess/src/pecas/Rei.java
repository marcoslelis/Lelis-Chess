package pecas;

import tabuleiro.TabuleiroXadrez;
import tabuleiro.Posicao;

public class Rei extends Peca {

	public Rei(boolean white, boolean ehRei) {
		super(white, ehRei);
	}

	@Override
	public boolean podeMover(TabuleiroXadrez board, Posicao inicio, Posicao fim) {
		if (inicio.getX() - fim.getX() == 1 && inicio.getY() == fim.getY() && fim.getPeca() == null)
			return true;
		return false;
	}
}
