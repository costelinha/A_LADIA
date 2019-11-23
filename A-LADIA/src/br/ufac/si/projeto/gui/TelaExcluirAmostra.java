package br.ufac.si.projeto.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;

public class TelaExcluirAmostra {

	private JFrame frame;
	private Amostra amostra;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarAmostra window = new TelaCadastrarAmostra();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public TelaExcluirAmostra(Amostra amostra) {
		this.amostra = amostra;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Cadastro de Amostra");
		frame.setBounds(100, 100, 646, 398);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("LADIA - Excluir Amostra");

		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setBounds(12, 76, 70, 15);
		frame.getContentPane().add(lblAnimal);
		JLabel lblExAnimal = new JLabel(amostra.getAnimal());
		lblExAnimal.setBounds(168, 76, 109, 15);
		frame.getContentPane().add(lblExAnimal);
		
		JLabel lblEspecie = new JLabel("Espécie:");
		lblEspecie.setBounds(12, 116, 70, 15);
		frame.getContentPane().add(lblEspecie);
		JLabel lblExEspecie = new JLabel(amostra.getEspecie());
		lblExEspecie.setBounds(168, 116, 109, 15);
		frame.getContentPane().add(lblExEspecie);

		JLabel lblRaca = new JLabel("Raça:");
		lblRaca.setBounds(12, 150, 70, 15);
		frame.getContentPane().add(lblRaca);
		JLabel lblExRaca = new JLabel(amostra.getRaca());
		lblExRaca.setBounds(168, 150, 109, 15);
		frame.getContentPane().add(lblExRaca);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 185, 70, 15);
		frame.getContentPane().add(lblSexo);
		JLabel lblExSexo = new JLabel(amostra.getSexo());
		lblExSexo.setBounds(168, 185, 96, 15);
		frame.getContentPane().add(lblExSexo);

		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setBounds(12, 220, 91, 15);
		frame.getContentPane().add(lblTutor);
		JLabel lblExTutor = new JLabel(amostra.getTutor());
		lblExTutor.setBounds(168, 220, 109, 15);
		frame.getContentPane().add(lblExTutor);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(12, 260, 70, 15);
		frame.getContentPane().add(lblIdade);
		JLabel lblExIdade = new JLabel(amostra.getIdade());
		lblExIdade.setBounds(168, 260, 152, 15);
		frame.getContentPane().add(lblExIdade);

		JLabel lblRequisitante = new JLabel("Requisitante:");
		lblRequisitante.setBounds(12, 300, 101, 15);
		frame.getContentPane().add(lblRequisitante);
		JLabel lblExRequisitante = new JLabel(amostra.getRequisitante());
		lblExRequisitante.setBounds(168, 300, 152, 15);
		frame.getContentPane().add(lblExRequisitante);

		JLabel lblAmostras = new JLabel("Amostras:");
		lblAmostras.setBounds(12, 337, 91, 15);
		frame.getContentPane().add(lblAmostras);
		JLabel lblExAmostras = new JLabel(amostra.getAmostras());
		lblExAmostras.setBounds(168, 337, 152, 15);
		frame.getContentPane().add(lblExAmostras);

		JButton btnConfimar = new JButton("Confirmar");
		btnConfimar.setBounds(345, 327, 117, 25);
		frame.getContentPane().add(btnConfimar);
		btnConfimar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				AmostraGerente ag = new AmostraGerente();
				int resposta = JOptionPane.showConfirmDialog(null, "Remover esta amostra?", "Confirmação", JOptionPane.YES_NO_OPTION);
				if(resposta == JOptionPane.YES_OPTION) {
//					ag.remover(ag.recuperar(amostra.getNumeroAmostra()));
					amostra = ag.recuperar(amostra.getNumeroAmostra());
					amostra.setSituacao(false);
					ag.atualizar(amostra);
					ag.encerrar();
					JOptionPane.showMessageDialog(null, "Removida com sucesso.");
					TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
					frame.dispose();						
				} else {
					TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
					frame.dispose();
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
				frame.dispose();
			}
		});
		btnCancelar.setBounds(503, 327, 117, 25);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblNmeroDaFicha = new JLabel("Número da ficha:");
		lblNmeroDaFicha.setBounds(12, 39, 152, 15);
		frame.getContentPane().add(lblNmeroDaFicha);
		JLabel lblExNumeroDaFicha = new JLabel(amostra.getNumeroFicha()+"");
		lblExNumeroDaFicha.setBounds(168, 39, 70, 15);
		frame.getContentPane().add(lblExNumeroDaFicha);
		
		JLabel label = new JLabel(TelaLogin.getUsuario().getLogin());
		label.setFont(new Font("Purisa", Font.BOLD, 28));
		label.setBounds(432, 12, 188, 50);
		frame.getContentPane().add(label);
		
	}
}