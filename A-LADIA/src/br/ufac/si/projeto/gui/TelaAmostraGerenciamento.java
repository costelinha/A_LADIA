package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TelaAmostraGerenciamento {

	private JFrame frame;
	private JTable table_1;
	private JTextField tfBuscar;
	private AmostraGerente ag = new AmostraGerente();
	Amostra amostra;
	List<Amostra> lista = ag.recuperarTodasRecente();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		tfBuscar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					lista = ag.recuperarTodasPorNomeContendo(tfBuscar.getText());
					mostrarAmostras();
				}
			}
		});
		
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
		btnCadastrar.setBounds(503, 161, 117, 25);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				amostra = ag.recuperar((long)table_1.getValueAt(table_1.getSelectedRow(), 0));
				amostra.setDisponibilidade(false);
				btnRetirar.setEnabled(false);
				ag.atualizar(amostra);
				JOptionPane.showMessageDialog(null, "Retirada efetuada");
				mostrarAmostras();
			}
		});
		btnRetirar.setEnabled(false);
		btnRetirar.setBounds(49, 358, 117, 25);
		frame.getContentPane().add(btnRetirar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(503, 205, 117, 25);
		frame.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(503, 251, 117, 25);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amostra = ag.recuperar((long)table_1.getValueAt(table_1.getSelectedRow(), 0));
				amostra.setDisponibilidade(true);
				btnDevolver.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Devolução efetuada");
				ag.atualizar(amostra);
				mostrarAmostras();
			}
		});
		btnDevolver.setEnabled(false);
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
				"ID", "Nome", "Data do registro", "Respons\u00E1vel", "Disponibilidade"
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
		table_1.getColumnModel().getColumn(2).setPreferredWidth(170);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(99);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(110);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(496, 130, 17, 148);
	//	frame.getContentPane().add(scrollBar);
	//	table_1.add(scrollBar);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table_1.getSelectedRow()==-1) {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}else {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					if(ag.recuperar((long)table_1.getValueAt(table_1.getSelectedRow(), 0)).isDisponibilidade()) {
						btnRetirar.setEnabled(true);
						btnDevolver.setEnabled(false);
					} else {
						btnRetirar.setEnabled(false);
						btnDevolver.setEnabled(true);
					}
				}				
				
			}
		});
		
	}
	
	public void mostrarAmostras() {
		
		DefaultTableModel modelo = (DefaultTableModel)table_1.getModel();
		Object [] row = new Object [5];
		while(modelo.getRowCount()>0)
			modelo.removeRow(0);
		if(tfBuscar.getText().isEmpty())
			lista = ag.recuperarTodasRecente();
		for(int i=0; i<lista.size(); i++) {
			row[0] = lista.get(i).getNumeroAmostra();
			row[1] = lista.get(i).getAnimal();
			row[2] = lista.get(i).getDataRegistro();
			row[3] = lista.get(i).getUsuario();
			if(lista.get(i).isDisponibilidade())
				row[4] = "Disponível";
			else
				row[4] = "Indisponível";
			modelo.addRow(row);
		}
		
	}
}
