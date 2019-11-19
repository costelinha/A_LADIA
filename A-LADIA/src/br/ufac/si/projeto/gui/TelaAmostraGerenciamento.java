package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TelaAmostraGerenciamento {

	private JFrame frame;
	private JTable table_1;
	private JTextField tfBuscar;
	private AmostraGerente ag = new AmostraGerente();
	private Amostra amostra;
	private List<Amostra> lista = ag.recuperarTodasRecente();


	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAmostraGerenciamento window = new TelaAmostraGerenciamento();
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
	public TelaAmostraGerenciamento() {
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
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(12, 95, 154, 23);
		frame.getContentPane().add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista = ag.recuperarTodasPorNomeContendo(tfBuscar.getText());
				mostrarAmostras();
			}
		});
		btnBuscar.setBounds(178, 93, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarAmostra tca = new TelaCadastrarAmostra();
				frame.dispose();
			}
		});
		btnCadastrar.setBounds(503, 161, 117, 25);
		btnCadastrar.setBounds(485, 161, 117, 25);
		frame.getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent evento) {

				TelaCadastroAmostra tca = new TelaCadastroAmostra();
				frame.dispose();

			}
		});
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.setBounds(49, 358, 117, 25);
		frame.getContentPane().add(btnRetirar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(485, 205, 117, 25);
		frame.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(485, 251, 117, 25);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setBounds(206, 358, 117, 25);
		frame.getContentPane().add(btnDevolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 140, 451, 148);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Data do registro", "Responsável"
			}
		));
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(496, 130, 17, 148);
	//	frame.getContentPane().add(scrollBar);
	//	table_1.add(scrollBar);
		
	}
	
	public void mostrarAmostras() {
		
		DefaultTableModel modelo = (DefaultTableModel)table_1.getModel();
		Object [] row = new Object [4];
		while(modelo.getRowCount()>0)
			modelo.removeRow(0);
		if(tfBuscar.getText().isEmpty())
			lista = ag.recuperarTodasRecente();
		for(int i=0; i<lista.size(); i++) {
			row[0] = lista.get(i).getNumeroAmostra();
			row[1] = lista.get(i).getAnimal();
			row[2] = lista.get(i).getDataRegistro();
			row[3] = lista.get(i).getUsuario();
			modelo.addRow(row);
		}
		
	}
}
