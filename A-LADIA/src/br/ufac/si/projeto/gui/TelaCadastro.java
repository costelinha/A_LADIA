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
import java.text.ParseException;

public class TelaCadastro extends JFrame{

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro tc = new TelaCadastro();
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
	public TelaCadastro() {
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
		tfNome.setBounds(104, 64, 114, 19);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("#####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		tfTelefone.setBounds(104, 91, 114, 19);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);
		
		
		
		tfEmail = new JTextField();
		tfEmail.setBounds(104, 118, 114, 19);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(24, 194, 70, 15);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(24, 221, 70, 15);
		frame.getContentPane().add(lblSenha);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(104, 193, 114, 19);
		frame.getContentPane().add(tfLogin);
		tfLogin.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(104, 219, 114, 19);
		frame.getContentPane().add(pfSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCadastrar.setBounds(230, 234, 97, 25);
		frame.getContentPane().add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				
				if (tfNome.getText().isEmpty() || tfEmail.getText().isEmpty() || tfTelefone.getText().isEmpty() || tfLogin.getText().isEmpty() || new String(pfSenha.getPassword()).isEmpty()) {
				 JOptionPane.showMessageDialog(null, "NO!");	
				}
				else {
				UsuarioGerente ug = new UsuarioGerente();
				Usuario u = new Usuario();
				u.setNome(tfNome.getText());
				u.setEmail(tfEmail.getText());
				u.setTelefone(tfTelefone.getText());
				u.setLogin(tfLogin.getText());
				u.setSenha(new String(pfSenha.getPassword()));
				ug.adicionar(u);
				ug.encerrar();
				u.setTipo(0);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
				TelaCoordenador ta = new TelaCoordenador();
				frame.dispose();
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
				TelaCoordenador tc = new TelaCoordenador();
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
