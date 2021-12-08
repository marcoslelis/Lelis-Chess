package pecas;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import tabuleiro.TabuleiroXadrez;
import tabuleiro.Posicao;

public abstract class Peca {
	protected boolean morto = false;
	protected boolean branca = false;
	protected Image imagem;
	protected boolean ehRei = false;

	public Peca(boolean white, boolean ehRei) {
		this.branca = white;
		this.ehRei = false;
		setImage();
	}

	public Image getImage() {
		return this.imagem;
	}

	public boolean ehBranca() {
		return this.branca == true;
	}

	public boolean isKilled() {
		return this.morto == true;
	}

	public abstract boolean podeMover(TabuleiroXadrez board, Posicao start, Posicao end);

	private void setImage() {
		String imgName;
		if (this.ehBranca())
			imgName = "W";
		else
			imgName = "B";

		imgName += this.getClass().getSimpleName();
		File imgFile = new File("./img/" + imgName + ".png");
		try {
			this.imagem = ImageIO.read(imgFile).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean moverLinhaReta(TabuleiroXadrez board, Posicao inicio, Posicao fim) {
		if (inicio.getX() == fim.getX()) {
			if (inicio.getY() < fim.getY()) {
				for (int y = inicio.getY() + 1; y < fim.getY(); y++) {
					if (board.getBoxes()[fim.getX()][y].getPeca() != null)
						return false;
				}
			} else {
				for (int y = fim.getY() + 1; y < inicio.getY(); y++) {
					if (board.getBoxes()[fim.getX()][y].getPeca() != null)
						return false;
				}
			}
			// Eat enemy
			if (fim.getPeca() != null && fim.getPeca().ehBranca() == inicio.getPeca().ehBranca())
				return false;
			
			if(fim.getPeca().ehRei == true)
					System.exit(0);
					
				
			return true;
		}
		if (inicio.getY() == fim.getY()) {
			if (inicio.getX() > fim.getX()) {
				for (int x = fim.getX() + 1; x < inicio.getX(); x++) {
					if (board.getBoxes()[x][fim.getY()].getPeca() != null)
						return false;
				}
			} else {
				for (int x = inicio.getX() + 1; x < fim.getX(); x++) {
					if (board.getBoxes()[x][fim.getY()].getPeca() != null)
						return false;
				}
			}
			// Eat enemy
			if (fim.getPeca() != null && fim.getPeca().ehBranca() == inicio.getPeca().ehBranca())
				return false;
			return true;

		}
		return false;
	}

	public boolean moverDiagonal(TabuleiroXadrez board, Posicao start, Posicao end) {
		if (Math.abs(start.getX() - end.getX()) != Math.abs(start.getY() - end.getY())) {
			return false;
		}
		// Go Up
		if (start.getX() > end.getX()) {
			// Go Left
			if (start.getY() > end.getY()) {
				for (int i = 1; i < start.getX() - end.getX(); i++) {
					if (board.getBoxes()[end.getX() + i][end.getY() + i].getPeca() != null)
						return false;
				}
				// Check eat
				if (end.getPeca() != null && end.getPeca().ehBranca() == start.getPeca().ehBranca())
					return false;
				return true;
			}
			// Go Right
			else if (start.getY() < end.getY()) {
				for (int i = 1; i < start.getX() - end.getX(); i++) {
					if (board.getBoxes()[end.getX() + i][end.getY() - i].getPeca() != null)
						return false;
				}
				// Check eat
				if (end.getPeca() != null && end.getPeca().ehBranca() == start.getPeca().ehBranca())
					return false;
				return true;
			} else
				return false;
		}
		// Go Down
		else if (start.getX() < end.getX()) {
			// Go Right
			if (start.getY() < end.getY()) {
				for (int i = 1; i < end.getX() - start.getX(); i++) {
					if (board.getBoxes()[start.getX() + i][start.getY() + i].getPeca() != null)
						return false;
				}
				// Check eat
				if (end.getPeca() != null && end.getPeca().ehBranca() == start.getPeca().ehBranca())
					return false;
				return true;
			}
			// Go Left
			else if (start.getY() > end.getY()) {
				for (int i = 1; i < end.getX() - start.getX(); i++) {
					if (board.getBoxes()[start.getX() + i][start.getY() - i].getPeca() != null)
						return false;
				}
				// Check eat
				if (end.getPeca() != null && end.getPeca().ehBranca() == start.getPeca().ehBranca())
					return false;
				return true;
			} else
				return false;
		} else
			return false;
	}
	
	public ArrayList<Posicao> encontraPosicao(TabuleiroXadrez board, Posicao posicaoAtual){
		ArrayList<Posicao> disponivel = new ArrayList<Posicao>();
		
		for(int i = 0; i < board.getBoxes().length; i++) {
			for(int j = 0; j < board.getBoxes().length; j++) {
				if(this.podeMover(board, posicaoAtual, board.getBoxes()[i][j])) {
					disponivel.add(board.getBoxes()[i][j]);
				}
			}
		}
		
		return disponivel;
	}
}
