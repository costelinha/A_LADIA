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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private static Amostra amostra;
	private List<Amostra> lista = ag.recuperarTodasRecente();


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
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarAmostra tca = new TelaCadastrarAmostra();
				frame.dispose();
			}
		});
		btnCadastrar.setBounds(356, 94, 117, 25);
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
		btnEditar.setBounds(485, 140, 117, 25);
		frame.getContentPane().add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEditarAmostra tea = new TelaEditarAmostra(ag.recuperar((long)table_1.getValueAt(table_1.getSelectedRow(), 0)));
				frame.dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaExcluirAmostra tea = new TelaExcluirAmostra(ag.recuperar((long)table_1.getValueAt(table_1.getSelectedRow(), 0)));
				frame.dispose();
			}
		});
		btnExcluir.setBounds(485, 177, 117, 25);
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
				"ID", "Nome", "Data do registro", "Responsável", "Disponibilidade"
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
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaLogin.getUsuario().getTipo()==1) {
					TelaCoordenador tc = new TelaCoordenador();					
					frame.dispose();
				} else {
					TelaLogin tl = new TelaLogin();					
					frame.dispose();
				}
				
			}
		});
		btnVoltar.setBounds(485, 358, 117, 25);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnExames = new JButton("Exames");
		btnExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaExameGerenciamento teg = new TelaExameGerenciamento(ag.recuperar((long)table_1.getValueAt(table_1.getSelectedRow(), 0)));
				frame.dispose();
			}
		});
		btnExames.setEnabled(false);
		btnExames.setBounds(485, 214, 117, 25);
		frame.getContentPane().add(btnExames);
		
		JButton btnIsolamento = new JButton("Isolamento");
		btnIsolamento.setEnabled(false);
		btnIsolamento.setBounds(485, 251, 117, 25);
		frame.getContentPane().add(btnIsolamento);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(496, 130, 17, 148);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table_1.getSelectedRow()==-1) {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
					btnExames.setEnabled(false);
					btnIsolamento.setEnabled(false);
				}else {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnExames.setEnabled(true);
					btnIsolamento.setEnabled(true);
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
			if(lista.get(i).isSituacao()) {
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

	public static Amostra getAmostra() {
		return amostra;
	}

	public static void setAmostra(Amostra amostra) {
		TelaAmostraGerenciamento.amostra = amostra;
	}
}
