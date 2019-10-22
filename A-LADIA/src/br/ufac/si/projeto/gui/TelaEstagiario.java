package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TelaEstagiario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstagiario window = new TelaEstagiario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaEstagiario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBounds(93, 186, 117, 25);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(240, 186, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.setBounds(93, 232, 117, 25);
		frame.getContentPane().add(btnRetirar);
		
		JButton btnDevolucao = new JButton("Devolução");
		btnDevolucao.setBounds(240, 232, 117, 25);
		frame.getContentPane().add(btnDevolucao);
		
		JLabel lblAladia = new JLabel("A-LADIA");
		lblAladia.setBounds(53, 24, 70, 15);
		frame.getContentPane().add(lblAladia);
	}
}
