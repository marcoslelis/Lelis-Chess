package tabuleiro;

import pecas.Bispo;
import pecas.Rei;
import pecas.Cavalo;
import pecas.Peao;
import pecas.Rainha;
import pecas.Torre;

public class TabuleiroXadrez{
	private Posicao[][] boxes = new Posicao[8][8];

	public TabuleiroXadrez() {
		
		resetBoard();
	}
		
	public Posicao[][] getBoxes(){
		return this.boxes;
	}

	private void resetBoard() {
		// pecas pretas
		boxes[0][0] = new Posicao(0, 0, new Torre(false, false));
		boxes[0][1] = new Posicao(0, 1, new Cavalo(false, false));
		boxes[0][2] = new Posicao(0, 2, new Bispo(false, false));
		boxes[0][3] = new Posicao(0, 3, new Rainha(false, false));
		boxes[0][4] = new Posicao(0, 4, new Rei(false, true));
		boxes[0][7] = new Posicao(0, 7, new Torre(false, false));
		boxes[0][6] = new Posicao(0, 6, new Cavalo(false, false));
		boxes[0][5] = new Posicao(0, 5, new Bispo(false, false));
		for (int i = 0; i < 8; i++) {
			boxes[1][i] = new Posicao(1, i, new Peao(false, false));
		}
		// pecas brancas
		boxes[7][0] = new Posicao(7, 0, new Torre(true, false));
		boxes[7][1] = new Posicao(7, 1, new Cavalo(true, false));
		boxes[7][2] = new Posicao(7, 2, new Bispo(true, false));
		boxes[7][3] = new Posicao(7, 3, new Rei(true, true));
		boxes[7][4] = new Posicao(7, 4, new Rainha(true, false));
		boxes[7][7] = new Posicao(7, 7, new Torre(true, false));
		boxes[7][6] = new Posicao(7, 6, new Cavalo(true, false));
		boxes[7][5] = new Posicao(7, 5, new Bispo(true, false));
		
		// inicializa os peoes
		for (int i = 0; i < 8; i++) {
			boxes[6][i] = new Posicao(6, i, new Peao(true, false));
		}
		
		
		// inicializa as casas sem pecas
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				boxes[i][j] = new Posicao(i, j, null);
			}
		}
	}

}
