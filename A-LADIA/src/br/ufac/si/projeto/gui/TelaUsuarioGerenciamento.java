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
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

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
		mostrarAmostras();
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
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "ID", "Nome", "a", "b"
			}
		));
		table_1.setBounds(12, 130, 447, 216);
		frame.getContentPane().add(table_1);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(12, 95, 154, 23);
		frame.getContentPane().add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista = ug.recuperarTodosPorNomeContendo(tfBuscar.getText());
				mostrarAmostras();
			}
		});
		btnBuscar.setBounds(178, 93, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(485, 161, 117, 25);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(485, 205, 117, 25);
		frame.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(485, 251, 117, 25);
		frame.getContentPane().add(btnExcluir);
		
	}
	
	public void mostrarAmostras() {
		
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
			row[5] = lista.get(i).getSenha();
			modelo.addRow(row);
		}
		
	}
}
