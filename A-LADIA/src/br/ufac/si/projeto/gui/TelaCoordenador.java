package br.ufac.si.projeto.gui;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaCoordenador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCoordenador ta= new TelaCoordenador();
					ta.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCoordenador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JButton btnUsuarios = new JButton("Usuários");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuarioGerenciamento tug = new TelaUsuarioGerenciamento();
				frame.dispose();
			}
		});
		
		JButton btnAmostras = new JButton("Amostras");
		btnAmostras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
				frame.dispose();
				
			}
		});
		
		JLabel lblAladia = new JLabel("A-LADIA");
		
		JButton btnSair = new JButton("Sair");
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl = new TelaLogin();
				frame.dispose();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnUsuarios)
							.addGap(53)
							.addComponent(btnAmostras)
							.addGap(93))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAladia)
							.addContainerGap(340, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(191)
					.addComponent(btnSair)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblAladia)
					.addContainerGap(232, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(183, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAmostras)
						.addComponent(btnUsuarios))
					.addGap(18)
					.addComponent(btnSair)
					.addGap(21))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
