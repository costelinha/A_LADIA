package br.ufac.si.projeto.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

import javax.swing.JButton;

public class TelaCadastroAmostra {

	private JFrame frmCadastroDeAmostra;
	private JTextField tfData;
	private JTextField tfAnimal;
	private JTextField tfEspecie;
	private JTextField tfRaca;
	private JTextField tfSexo;
	private JTextField tfProp;
	private JTextField tfIdade;
	private JTextField tfRequi;
	private JTextField tfAmostra;
	private JTextField tfReceber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAmostra window = new TelaCadastroAmostra();
					window.frmCadastroDeAmostra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroAmostra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmCadastroDeAmostra = new JFrame();
		frmCadastroDeAmostra.setTitle("Cadastro de Amostra");
		frmCadastroDeAmostra.setBounds(100, 100, 450, 497);
		frmCadastroDeAmostra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeAmostra.getContentPane().setLayout(null);
		frmCadastroDeAmostra.setVisible(true);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(12, 38, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblData);

		tfData = new JTextField();
		tfData.setBounds(56, 36, 238, 19);
		frmCadastroDeAmostra.getContentPane().add(tfData);
		tfData.setColumns(10);

		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setBounds(12, 76, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblAnimal);

		tfAnimal = new JTextField();
		tfAnimal.setBounds(66, 74, 228, 19);
		frmCadastroDeAmostra.getContentPane().add(tfAnimal);
		tfAnimal.setColumns(10);

		JLabel lblNewLabel = new JLabel("Espécie:");
		lblNewLabel.setBounds(12, 116, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Raça:");
		lblNewLabel_1.setBounds(12, 150, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Sexo:");
		lblNewLabel_2.setBounds(12, 185, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Proprietário:");
		lblNewLabel_3.setBounds(12, 220, 91, 15);
		frmCadastroDeAmostra.getContentPane().add(lblNewLabel_3);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(12, 260, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblIdade);

		JLabel lblRequisitante = new JLabel("Requisitante:");
		lblRequisitante.setBounds(12, 300, 101, 15);
		frmCadastroDeAmostra.getContentPane().add(lblRequisitante);

		JLabel lblAmostra = new JLabel("Amostra:");
		lblAmostra.setBounds(12, 337, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblAmostra);

		JLabel lblResponsvelPorReceber = new JLabel("Responsável por receber:");
		lblResponsvelPorReceber.setBounds(12, 377, 215, 15);
		frmCadastroDeAmostra.getContentPane().add(lblResponsvelPorReceber);

		tfEspecie = new JTextField();
		tfEspecie.setBounds(76, 114, 218, 19);
		frmCadastroDeAmostra.getContentPane().add(tfEspecie);
		tfEspecie.setColumns(10);

		tfRaca = new JTextField();
		tfRaca.setBounds(56, 148, 238, 19);
		frmCadastroDeAmostra.getContentPane().add(tfRaca);
		tfRaca.setColumns(10);

		tfSexo = new JTextField();
		tfSexo.setBounds(56, 183, 114, 19);
		frmCadastroDeAmostra.getContentPane().add(tfSexo);
		tfSexo.setColumns(10);

		tfProp = new JTextField();
		tfProp.setBounds(113, 218, 181, 19);
		frmCadastroDeAmostra.getContentPane().add(tfProp);
		tfProp.setColumns(10);

		tfIdade = new JTextField();
		tfIdade.setBounds(66, 258, 228, 19);
		frmCadastroDeAmostra.getContentPane().add(tfIdade);
		tfIdade.setColumns(10);

		tfRequi = new JTextField();
		tfRequi.setBounds(113, 298, 181, 19);
		frmCadastroDeAmostra.getContentPane().add(tfRequi);
		tfRequi.setColumns(10);

		tfAmostra = new JTextField();
		tfAmostra.setBounds(76, 335, 218, 19);
		frmCadastroDeAmostra.getContentPane().add(tfAmostra);
		tfAmostra.setColumns(10);

		tfReceber = new JTextField();
		tfReceber.setBounds(197, 375, 97, 19);
		frmCadastroDeAmostra.getContentPane().add(tfReceber);
		tfReceber.setColumns(10);

		JButton btnConfimar = new JButton("Confirmar");
		btnConfimar.setBounds(53, 432, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnConfimar);
		btnConfimar.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent evento) {

				if (tfData.getText().isEmpty() || tfProp.getText().isEmpty() || tfReceber.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "NO!");	
				}
				else {
					AmostraGerente ag = new AmostraGerente();
					Amostra a = new Amostra();
					a.setDataRegistro(null);
					a.setRaca(tfRaca.getText());
					a.setAnimal(tfAnimal.getText());
					a.setEspecie(tfEspecie.getText());
					a.setSexo(tfSexo.getText());
					a.setTutor("nao sei o que é tutor");
					a.setIdade(tfIdade.getText());
					a.setRequisitante(tfRequi.getText());
					a.setDisponibilidade(true);
					a.setSituacao(true);
					
					ag.adicionar(a);
					ag.encerrar();
					
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
					TelaUsuarioGerenciamento tug = new TelaUsuarioGerenciamento();
					frmCadastroDeAmostra.dispose();
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(211, 432, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnCancelar);

	}
}
