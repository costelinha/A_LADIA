package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaUsuarioGerenciamento {

	private JFrame frame;
	private JTable table_1;
	private JTextField tfBuscar;
	private UsuarioGerente ug = new UsuarioGerente();
	List<Usuario> lista = ug.recuperarTodosPorNome();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuarioGerenciamento window = new TelaUsuarioGerenciamento();
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
	public TelaUsuarioGerenciamento() {
		initialize();
		mostrarUsuarios();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(12, 95, 154, 23);
		frame.getContentPane().add(tfBuscar);
		tfBuscar.setColumns(10);
		tfBuscar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					lista = ug.recuperarTodosPorNomeContendo(tfBuscar.getText());
					mostrarUsuarios();
				}
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista = ug.recuperarTodosPorNomeContendo(tfBuscar.getText());
				mostrarUsuarios();
			}
		});
		btnBuscar.setBounds(178, 93, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				TelaCadastrarUsuario tc = new TelaCadastrarUsuario();
				frame.dispose();
			}
		});
		btnCadastrar.setBounds(485, 161, 117, 25);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(485, 205, 117, 25);
		frame.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(485, 251, 117, 25);
		frame.getContentPane().add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 151, 461, 216);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "E-Mail", "Telefone", "Login"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(180);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCoordenador tc = new TelaCoordenador();
				frame.dispose();
			}
		});
		btnVoltar.setBounds(485, 290, 117, 25);
		frame.getContentPane().add(btnVoltar);

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				TelaEditarUsuario teu = new TelaEditarUsuario(ug.recuperar((long)table_1.getValueAt(table_1.getSelectedRow(), 0)));
				frame.dispose();
			}
		
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				TelaExcluirUsuario texu = new TelaExcluirUsuario(ug.recuperar((long)table_1.getValueAt(table_1.getSelectedRow(), 0)));
				frame.dispose();
			}
		});
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table_1.getSelectedRow()==-1) {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}else {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				}				
				
			}
		});
	}
	
	
	
	public void mostrarUsuarios() {
		
		DefaultTableModel modelo = (DefaultTableModel)table_1.getModel();
		Object [] row = new Object [6];
		while(modelo.getRowCount()>0)
			modelo.removeRow(0);
		if(tfBuscar.getText().isEmpty())
			lista = ug.recuperarTodosPorNome();
		for(int i=0; i<lista.size(); i++) {
			row[0] = lista.get(i).getId();
			row[1] = lista.get(i).getNome();
			row[2] = lista.get(i).getEmail();
			row[3] = lista.get(i).getTelefone();
			row[4] = lista.get(i).getLogin();
			modelo.addRow(row);
		}
		
		
	}
}
