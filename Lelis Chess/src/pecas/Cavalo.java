package pecas;

import tabuleiro.TabuleiroXadrez;
import tabuleiro.Posicao;

public class Cavalo extends Peca {

	public Cavalo(boolean white, boolean ehRei) {
		super(white, ehRei);
	}

	@Override
	public boolean podeMover(TabuleiroXadrez board, Posicao inicio, Posicao fim) {
		if(Math.abs(inicio.getX() - fim.getX()) == 2 && Math.abs(inicio.getY() - fim.getY()) == 1) {
			// Check eat
			if(fim.getPeca() != null && fim.getPeca().ehBranca() == inicio.getPeca().ehBranca()) return false;
			return true;
		}
		if(Math.abs(inicio.getX() - fim.getX()) == 1 && Math.abs(inicio.getY() - fim.getY()) == 2) {
			// Check eat
			if(fim.getPeca() != null && fim.getPeca().ehBranca() == inicio.getPeca().ehBranca()) return false;
			return true;
		}
		return false;
	}
	
}
