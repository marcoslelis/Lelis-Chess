package pecas;

import tabuleiro.TabuleiroXadrez;
import tabuleiro.Posicao;

public class Peao extends Peca {

	public Peao(boolean white, boolean ehRei) {
		super(white, ehRei);
	}

	@Override
	public boolean podeMover(TabuleiroXadrez board, Posicao start, Posicao end) {
		if (this.branca) {
			// anda uma
			if (start.getX() - end.getX() == 1 && start.getY() == end.getY() && end.getPeca() == null)
				return true;
			// pode andar dois no primeiro movimento
			if (start.getX() == 6 && end.getX() == 4 && start.getY() == end.getY() && end.getPeca() == null
					&& board.getBoxes()[5][start.getY()].getPeca() == null)
				return true;
			// come peca preta
			if (start.getX() - end.getX() == 1 && Math.abs(start.getY() - end.getY()) == 1 && end.getPeca() != null
					&& !end.getPeca().ehBranca())
					return true;
		}
		if (!this.branca) {
			// anda uma
			if (start.getX() - end.getX() == -1 && start.getY() == end.getY() && end.getPeca() == null)
				return true;
			// pode andar dois no primeiro movimento
			if (start.getX() == 1 && end.getX() == 3 && start.getY() == end.getY() && end.getPeca() == null
					&& board.getBoxes()[2][start.getY()].getPeca() == null)
				return true;
			// come branca
			if (start.getX() - end.getX() == -1 && Math.abs(start.getY() - end.getY()) == 1 && end.getPeca() != null
					&& end.getPeca().ehBranca())
				return true;
		}

		return false;
	}

}
