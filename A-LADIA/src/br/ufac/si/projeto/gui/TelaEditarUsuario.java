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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JRadioButton;

public class TelaEditarUsuario extends JFrame{

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
	public TelaEditarUsuario(Usuario usuario) {
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
		frame.setTitle("LADIA - Editar Usuário");
		
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
		tfNome.setText(usuario.getNome());
		tfNome.setBounds(166, 66, 114, 19);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("#####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		tfTelefone.setText(usuario.getTelefone());
		tfTelefone.setBounds(166, 93, 114, 19);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setText(usuario.getEmail());
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
		tfLogin.setText(usuario.getLogin());
		tfLogin.setBounds(166, 149, 114, 19);
		frame.getContentPane().add(tfLogin);
		tfLogin.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(166, 180, 114, 19);
		frame.getContentPane().add(pfSenha);
		
		pfSenhaConfirmar = new JPasswordField();
		pfSenhaConfirmar.setBounds(166, 207, 114, 19);
		frame.getContentPane().add(pfSenhaConfirmar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnConfirmar.setBounds(230, 234, 97, 25);
		frame.getContentPane().add(btnConfirmar);
		
		
		
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
		
		JLabel lblPrivilgios = new JLabel("Privilégios");
		lblPrivilgios.setBounds(333, 95, 103, 15);
		frame.getContentPane().add(lblPrivilgios);
		
		JRadioButton rdbtnEstagirio = new JRadioButton("Estagiário");
		rdbtnEstagirio.setBounds(301, 118, 149, 23);
		frame.getContentPane().add(rdbtnEstagirio);
		
		JRadioButton rdbtnCoordenador = new JRadioButton("Coordenador");
		rdbtnCoordenador.setBounds(301, 145, 149, 23);
		frame.getContentPane().add(rdbtnCoordenador);
		
		if(usuario.getTipo()==1)
			rdbtnCoordenador.setSelected(true);
		else
			rdbtnEstagirio.setSelected(true);
		
		ButtonGroup bgTipo = new ButtonGroup();
		bgTipo.add(rdbtnCoordenador);
		bgTipo.add(rdbtnEstagirio);
		
		JLabel label = new JLabel(TelaLogin.getUsuario().getLogin());
		label.setFont(new Font("Purisa", Font.BOLD, 28));
		label.setBounds(266, 0, 170, 50);
		frame.getContentPane().add(label);
		
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				String senha = new String(pfSenha.getPassword());
				String senhaConfirmar = new String(pfSenhaConfirmar.getPassword());
				if (tfNome.getText().isEmpty() || tfLogin.getText().isEmpty() || new String(pfSenha.getPassword()).isEmpty() || new String(pfSenhaConfirmar.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "Dados inválidos", 2);	
				}
				else if(senha.equals(senhaConfirmar)){
					UsuarioGerente ug = new UsuarioGerente();
					ug.recuperar(usuario.getId()).setNome(tfNome.getText());
					ug.recuperar(usuario.getId()).setEmail(tfEmail.getText());
					ug.recuperar(usuario.getId()).setTelefone(tfTelefone.getText());
					ug.recuperar(usuario.getId()).setLogin(tfLogin.getText());
					ug.recuperar(usuario.getId()).setSenha(senha);
					if(rdbtnCoordenador.isSelected()) {
						ug.recuperar(usuario.getId()).setTipo(1);
					}
					if(rdbtnEstagirio.isSelected()) {
						ug.recuperar(usuario.getId()).setTipo(0);
					}
					ug.atualizar(ug.recuperar(usuario.getId()));
					ug.encerrar();
					JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
					TelaUsuarioGerenciamento tug = new TelaUsuarioGerenciamento();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Senha errada", "Conflito de senha", 2);
				}
			}
		});
		
		/*if(tfNome.getText().isEmpty() || tfEmail.getText().isEmpty() || tfTelefone.getText().isEmpty() || tfLogin.getText().isEmpty() || pfSenha.getText().isEmpty()) {
			btnCadastrar.setEnabled(false);
		}else
		btnCadastrar.setEnabled(true);*/
		
		
	}
}
