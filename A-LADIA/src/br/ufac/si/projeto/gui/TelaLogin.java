package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import br.ufac.si.projeto.entidades.*;
import br.ufac.si.projeto.gerentes.*;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	JButton btnEntrar = new JButton("Entrar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin tl = new TelaLogin();
					tl.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
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
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				login();
			}
		});
		
		
		
		JLabel lblAladia = new JLabel("A-LADIA");
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblSenha = new JLabel("Senha");
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(182)
					.addComponent(lblAladia))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addComponent(lblLogin)
					.addGap(35)
					.addComponent(tfLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addComponent(lblSenha)
					.addGap(29)
					.addComponent(pfSenha, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(lblAladia)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblLogin))
						.addComponent(tfLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblSenha))
						.addComponent(pfSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(btnEntrar))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void login() {
		Usuario usuario =null;
		String login = tfLogin.getText(), senha = new String(pfSenha.getPassword());
		UsuarioGerente ug = new UsuarioGerente();

		try {
			usuario = ug.recuperarLogin(login).get(0);
			if((login.equals("admin") && senha.equals("123"))
					|| (usuario!=null && senha.equals(usuario.getSenha()) && usuario.getTipo()==1)) {
				TelaCoordenador tc = new TelaCoordenador();
				frame.dispose();
				
			}else if(usuario!=null && usuario.getTipo()==0) { 
					TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
					frame.dispose();
					}
		}catch(Exception e)
		{
			
			JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha no login", JOptionPane.ERROR_MESSAGE);
			tfLogin.setText("");
			pfSenha.setText("");
		}

	}

}
