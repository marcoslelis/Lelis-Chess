package tabuleiro;

import javax.swing.JButton;

import pecas.Peca;

public class Posicao extends JButton {
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private Peca peca;

	public Posicao(int x, int y, Peca piece) {
		this.x = x;
		this.y = y;
		this.peca = piece;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPiece(Peca piece) {
		this.peca = piece;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + peca;
	}
	
	@Override
	public boolean equals(Object obj) {
		Posicao other = (Posicao) obj;
		return this.x == other.getX() && this.y == other.getY() && this.peca == other.getPeca();
	}
}
