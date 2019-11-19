package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

public class TelaCadastrarUsuario extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	private JTextField tfNome;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private JPasswordField pfSenhaConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarUsuario tc = new TelaCadastrarUsuario();
					tc.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarUsuario() {
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
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(24, 66, 70, 15);
		frame.getContentPane().add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(24, 93, 70, 15);
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(24, 120, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		tfNome = new JTextField();
		tfNome.setBounds(166, 66, 114, 19);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("#####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		tfTelefone.setBounds(166, 93, 114, 19);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);
		
		
		
		tfEmail = new JTextField();
		tfEmail.setBounds(166, 120, 114, 19);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(24, 148, 70, 15);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(24, 180, 70, 15);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblSenhaConfirmar = new JLabel("Confirmar senha:");
		lblSenhaConfirmar.setBounds(24, 209, 138, 15);
		frame.getContentPane().add(lblSenhaConfirmar);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(166, 149, 114, 19);
		frame.getContentPane().add(tfLogin);
		tfLogin.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(166, 180, 114, 19);
		frame.getContentPane().add(pfSenha);
		
		pfSenhaConfirmar = new JPasswordField();
		pfSenhaConfirmar.setBounds(166, 207, 114, 19);
		frame.getContentPane().add(pfSenhaConfirmar);
		pfSenhaConfirmar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String senha = new String(pfSenha.getPassword());
					String senhaConfirmar = new String(pfSenhaConfirmar.getPassword());
					if (tfNome.getText().isEmpty() || tfLogin.getText().isEmpty() || new String(pfSenha.getPassword()).isEmpty() || new String(pfSenhaConfirmar.getPassword()).isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "Dados inválidos", 2);	
					}
					else if(senha.equals(senhaConfirmar)){
						UsuarioGerente ug = new UsuarioGerente();
						Usuario u = new Usuario();
						u.setNome(tfNome.getText());
						u.setEmail(tfEmail.getText());
						u.setTelefone(tfTelefone.getText());
						u.setLogin(tfLogin.getText());
						u.setSenha(senha);
						u.setTipo(0);
						ug.adicionar(u);
						ug.encerrar();
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
						TelaUsuarioGerenciamento tug = new TelaUsuarioGerenciamento();
						frame.dispose();
					} else {
						System.out.println(pfSenha);
						System.out.println(pfSenhaConfirmar);
						JOptionPane.showMessageDialog(null, "Senha errada", "Conflito de senha", 2);
					}
				}
			}
		});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCadastrar.setBounds(230, 234, 97, 25);
		frame.getContentPane().add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				String senha = new String(pfSenha.getPassword());
				String senhaConfirmar = new String(pfSenhaConfirmar.getPassword());
				if (tfNome.getText().isEmpty() || tfLogin.getText().isEmpty() || new String(pfSenha.getPassword()).isEmpty() || new String(pfSenhaConfirmar.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "Dados inválidos", 2);	
				}
				else if(senha.equals(senhaConfirmar)){
					UsuarioGerente ug = new UsuarioGerente();
					Usuario u = new Usuario();
					u.setNome(tfNome.getText());
					u.setEmail(tfEmail.getText());
					u.setTelefone(tfTelefone.getText());
					u.setLogin(tfLogin.getText());
					u.setSenha(senha);
					u.setTipo(0);
					ug.adicionar(u);
					ug.encerrar();
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
					TelaUsuarioGerenciamento tug = new TelaUsuarioGerenciamento();
					frame.dispose();
				} else {
					System.out.println(pfSenha);
					System.out.println(pfSenhaConfirmar);
					JOptionPane.showMessageDialog(null, "Senha errada", "Conflito de senha", 2);
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCancelar.setBounds(339, 234, 97, 25);
		frame.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				TelaUsuarioGerenciamento tug = new TelaUsuarioGerenciamento();
				frame.dispose();
				
			}
		});
		
		JLabel lblAladia = new JLabel("A-LADIA");
		lblAladia.setBounds(178, 24, 70, 15);
		frame.getContentPane().add(lblAladia);
		
		/*if(tfNome.getText().isEmpty() || tfEmail.getText().isEmpty() || tfTelefone.getText().isEmpty() || tfLogin.getText().isEmpty() || pfSenha.getText().isEmpty()) {
			btnCadastrar.setEnabled(false);
		}else
		btnCadastrar.setEnabled(true);*/
		
		
	}
}
