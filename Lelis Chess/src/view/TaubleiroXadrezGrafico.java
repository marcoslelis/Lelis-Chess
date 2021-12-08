package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tabuleiro.TabuleiroXadrez;
import tabuleiro.Posicao;

public class TaubleiroXadrezGrafico extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TabuleiroXadrez tabuleiro;
	private final int cell_size = 70;
	private boolean clicked;
	private Posicao waiting;

	public TaubleiroXadrezGrafico() {
		this.setLayout(new GridLayout(8, 8));
		this.setSize(8 * cell_size, 8 * cell_size);

		tabuleiro = new TabuleiroXadrez();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.add(tabuleiro.getBoxes()[i][j]);
				tabuleiro.getBoxes()[i][j].addActionListener(this);
			}
		}

	}
	
	private void drawBoard() {
		for(int i = 0; i < tabuleiro.getBoxes().length; i++) {
			for(int j = 0; j < tabuleiro.getBoxes().length; j++) {
				if ((i + j) % 2 == 0) {
					tabuleiro.getBoxes()[i][j].setBackground(Color.WHITE);
				} else {
					tabuleiro.getBoxes()[i][j].setBackground(Color.GRAY);
				}
				if (tabuleiro.getBoxes()[i][j].getPeca() != null) {
					tabuleiro.getBoxes()[i][j].setIcon(new ImageIcon(tabuleiro.getBoxes()[i][j].getPeca().getImage()));
				} else {
					tabuleiro.getBoxes()[i][j].setIcon(null);
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Posicao current = (Posicao) e.getSource();
		if (clicked) {
			if (waiting.equals(current)) {
				clicked = false;
				drawBoard();
				return;
			}
			if (waiting.getPeca().podeMover(tabuleiro, waiting, current)) {
				tabuleiro.getBoxes()[current.getX()][current.getY()].setPiece(waiting.getPeca());
				tabuleiro.getBoxes()[waiting.getX()][waiting.getY()].setPiece(null);
			}

			drawBoard();
			clicked = false;
		} else {
			if (current.getPeca() != null) {
				waiting = current;
				clicked = true;
				current.setBackground(Color.GREEN);
				ArrayList<Posicao> avaiable = current.getPeca().encontraPosicao(this.tabuleiro, current);
				for (Posicao spot : avaiable) {
					if(spot.getPeca() == null) {
						spot.setBackground(Color.YELLOW);
					}
					else {
						spot.setBackground(Color.RED);
					}
				}
			}
		}
	}
}
