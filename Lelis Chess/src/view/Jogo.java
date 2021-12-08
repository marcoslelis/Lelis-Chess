package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class Jogo extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private TaubleiroXadrezGrafico tabuleiro;
	
	
	public Jogo() {
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		painel = new JPanel();

		painel.setBorder(new EmptyBorder(50, 10, 50, 10));
		setContentPane(painel);
		painel.setLayout(new BorderLayout(0, 0));
		
		tabuleiro = new TaubleiroXadrezGrafico();
		
		painel.add(tabuleiro, BorderLayout.NORTH);
		
		//pack();
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				
				Jogo jogo = new Jogo();
				jogo.setVisible(true);
			}
		});
	}
}
