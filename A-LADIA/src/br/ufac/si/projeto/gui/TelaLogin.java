package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.GroupLayout.Alignment;

import br.ufac.si.projeto.entidades.*;
import br.ufac.si.projeto.gerentes.*;
import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private JButton btnEntrar = new JButton("Entrar");
	private static Usuario usuario;
	

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
		frame.setBounds(100, 100, 530, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setTitle("LADIA");
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				login();
			}
		});
		
		
		
		JLabel lblAladia = new JLabel("LADIA");
		lblAladia.setFont(new Font("Purisa", Font.BOLD, 28));
		
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
		
		JLabel lbl = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("download.png")).getImage();
		lbl.setIcon(new ImageIcon(img));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(160)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLogin)
							.addGap(35)
							.addComponent(tfLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSenha)
							.addGap(29)
							.addComponent(pfSenha, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAladia, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))))
					.addContainerGap(132, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAladia)
					.addGap(18)
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
					.addComponent(btnEntrar)
					.addGap(76))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void login() {
		Usuario usuario =null;
		String login = tfLogin.getText(), senha = new String(pfSenha.getPassword());
		UsuarioGerente ug = new UsuarioGerente();

		try {
			usuario = ug.recuperarLogin(login).get(0);
			if((usuario!=null && senha.equals(usuario.getSenha()) && usuario.getTipo()==1) && usuario.isStatus()) {
				TelaLogin.setUsuario(usuario);
				TelaCoordenador tc = new TelaCoordenador();
				frame.dispose();
				
			}else if(usuario!=null && senha.equals(usuario.getSenha()) && usuario.getTipo()==0 && usuario.isStatus()) { 
					TelaLogin.setUsuario(usuario);
					TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
					frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha no login", JOptionPane.ERROR_MESSAGE);
				tfLogin.setText("");
				pfSenha.setText("");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha no login", JOptionPane.ERROR_MESSAGE);
			tfLogin.setText("");
			pfSenha.setText("");
		}

	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		TelaLogin.usuario = usuario;
	}
}
