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

public class TelaExcluirUsuario extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarUsuario tc = new TelaEditarUsuario();
					tc.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public TelaExcluirUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		
		JLabel lblExNome = new JLabel(usuario.getNome());
		lblExNome.setBounds(166, 64, 114, 19);
		frame.getContentPane().add(lblExNome);
/*		tfNome = new JTextField();
		tfNome.setText(usuario.getNome());
		tfNome.setBounds(166, 66, 114, 19);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		tfNome.setEnabled(false);*/
		
	
		
		JLabel lblExTelefone = new JLabel(usuario.getTelefone());
		lblExTelefone.setBounds(166, 93, 114, 19);
		frame.getContentPane().add(lblExTelefone);
/*		tfTelefone.setText(usuario.getTelefone());
		tfTelefone.setBounds(166, 93, 114, 19);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);
		tfTelefone.setEnabled(false);*/
		
		JLabel lblExEmail = new JLabel(usuario.getEmail());
		lblExEmail.setBounds(166, 120, 114, 19);
		frame.getContentPane().add(lblExEmail);
/*		tfEmail = new JTextField();
		tfEmail.setText(usuario.getEmail());
		tfEmail.setBounds(166, 120, 114, 19);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		tfEmail.setEnabled(false);*/
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(24, 148, 70, 15);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblExLogin = new JLabel(usuario.getLogin());
		lblExLogin.setBounds(166, 149, 114, 19);
		frame.getContentPane().add(lblExLogin);
/*		tfLogin = new JTextField();
		tfLogin.setText(usuario.getLogin());
		tfLogin.setBounds(166, 149, 114, 19);
		frame.getContentPane().add(tfLogin);
		tfLogin.setColumns(10);
		tfLogin.setEnabled(false);*/
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnConfirmar.setBounds(230, 234, 97, 25);
		frame.getContentPane().add(btnConfirmar);
		
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
					UsuarioGerente ug = new UsuarioGerente();
					int resposta = JOptionPane.showConfirmDialog(null, "Remover este usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);
					if(resposta == JOptionPane.YES_OPTION) {
						ug.remover(ug.recuperar(usuario.getId()));
						ug.encerrar();
						JOptionPane.showMessageDialog(null, "Removido com sucesso.");
						TelaUsuarioGerenciamento tug = new TelaUsuarioGerenciamento();
						frame.dispose();						
					} else {
						TelaUsuarioGerenciamento tug = new TelaUsuarioGerenciamento();
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