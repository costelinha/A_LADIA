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

public class TelaCadastrarAmostra {

	private JFrame frmCadastroDeAmostra;
	private JTextField tfAnimal;
	private JTextField tfEspecie;
	private JTextField tfRaca;
	private JTextField tfSexo;
	private JTextField tfTutor;
	private JTextField tfIdade;
	private JTextField tfNFicha;
	private JTextField tfRequisitante;
	private JTextField tfAmostras;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarAmostra window = new TelaCadastrarAmostra();
					window.frmCadastroDeAmostra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public TelaCadastrarAmostra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmCadastroDeAmostra = new JFrame();
		frmCadastroDeAmostra.setTitle("Cadastro de Amostra");
		frmCadastroDeAmostra.setBounds(100, 100, 646, 497);
		frmCadastroDeAmostra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeAmostra.getContentPane().setLayout(null);
		frmCadastroDeAmostra.setVisible(true);

		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setBounds(12, 76, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblAnimal);

		tfAnimal = new JTextField();
		tfAnimal.setBounds(66, 74, 228, 19);
		frmCadastroDeAmostra.getContentPane().add(tfAnimal);
		tfAnimal.setColumns(10);

		JLabel lblEspecie = new JLabel("Espécie:");
		lblEspecie.setBounds(12, 116, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblEspecie);

		JLabel lblRaca = new JLabel("Raça:");
		lblRaca.setBounds(12, 150, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblRaca);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 185, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblSexo);

		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setBounds(12, 220, 91, 15);
		frmCadastroDeAmostra.getContentPane().add(lblTutor);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(12, 260, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblIdade);

		JLabel lblRequisitante = new JLabel("Requisitante:");
		lblRequisitante.setBounds(12, 300, 101, 15);
		frmCadastroDeAmostra.getContentPane().add(lblRequisitante);

		JLabel lblAmostras = new JLabel("Amostras:");
		lblAmostras.setBounds(12, 337, 91, 15);
		frmCadastroDeAmostra.getContentPane().add(lblAmostras);

		tfEspecie = new JTextField();
		tfEspecie.setBounds(76, 114, 218, 19);
		frmCadastroDeAmostra.getContentPane().add(tfEspecie);
		tfEspecie.setColumns(10);

		tfRaca = new JTextField();
		tfRaca.setBounds(100, 145, 238, 19);
		frmCadastroDeAmostra.getContentPane().add(tfRaca);
		tfRaca.setColumns(10);

		tfSexo = new JTextField();
		tfSexo.setBounds(214, 183, 114, 19);
		frmCadastroDeAmostra.getContentPane().add(tfSexo);
		tfSexo.setColumns(10);

		tfTutor = new JTextField();
		tfTutor.setBounds(147, 218, 181, 19);
		frmCadastroDeAmostra.getContentPane().add(tfTutor);
		tfTutor.setColumns(10);

		tfIdade = new JTextField();
		tfIdade.setBounds(100, 258, 228, 19);
		frmCadastroDeAmostra.getContentPane().add(tfIdade);
		tfIdade.setColumns(10);

		tfRequisitante = new JTextField();
		tfRequisitante.setBounds(147, 298, 181, 19);
		frmCadastroDeAmostra.getContentPane().add(tfRequisitante);
		tfRequisitante.setColumns(10);

		tfAmostras = new JTextField();
		tfAmostras.setBounds(110, 335, 218, 19);
		frmCadastroDeAmostra.getContentPane().add(tfAmostras);
		tfAmostras.setColumns(10);

		JButton btnConfimar = new JButton("Confirmar");
		btnConfimar.setBounds(53, 432, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnConfimar);
		btnConfimar.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent evento) {

//				if (tfData.getText().isEmpty() || tfTutor.getText().isEmpty() || tfReceber.getText().isEmpty() ) {
//					JOptionPane.showMessageDialog(null, "NO!");	
//				}
//				else {
					Date data = new Date();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(data);
					AmostraGerente ag = new AmostraGerente();
					Amostra a = new Amostra();
					a.setDataRegistro(data);
					a.setRaca(tfRaca.getText());
					a.setAnimal(tfAnimal.getText());
					a.setEspecie(tfEspecie.getText());
					a.setSexo(tfSexo.getText());
					a.setTutor(tfTutor.getText());
					a.setIdade(tfIdade.getText());
					a.setRequisitante(tfRequisitante.getText());
					a.setDisponibilidade(true);
					a.setSituacao(true);
					a.setAmostras(tfAmostras.getText());
					a.setUsuario(TelaLogin.getUsuario());
					ag.adicionar(a);
					
					ag.encerrar();
					
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
					TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
					frmCadastroDeAmostra.dispose();
//				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(211, 432, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnCancelar);
		
		JLabel lblNmeroDaFicha = new JLabel("Número da ficha:");
		lblNmeroDaFicha.setBounds(382, 63, 152, 15);
		frmCadastroDeAmostra.getContentPane().add(lblNmeroDaFicha);
		
		tfNFicha = new JTextField();
		tfNFicha.setBounds(520, 61, 114, 19);
		frmCadastroDeAmostra.getContentPane().add(tfNFicha);
		tfNFicha.setColumns(10);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
				frmCadastroDeAmostra.dispose();
			}
		});
		btnCancelar.setBounds(211, 432, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnCancelar);
		
		JLabel lblExames = new JLabel("Exames:");
		lblExames.setBounds(363, 116, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblExames);
		
		JCheckBox chckbxParasitologiaDePele = new JCheckBox("Parasitologia de Pele");
		chckbxParasitologiaDePele.setBounds(428, 112, 187, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxParasitologiaDePele);
		
		JCheckBox chckbxParasitologiaDeOuvido = new JCheckBox("Parasitologia de Ouvido");
		chckbxParasitologiaDeOuvido.setBounds(428, 146, 218, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxParasitologiaDeOuvido);
		
		JCheckBox chckbxCitologiaDePele = new JCheckBox("Citologia de Pele");
		chckbxCitologiaDePele.setBounds(428, 181, 187, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxCitologiaDePele);
		
		JCheckBox chckbxCitologiaDeOuvido = new JCheckBox("Citologia de Ouvido");
		chckbxCitologiaDeOuvido.setBounds(428, 216, 163, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxCitologiaDeOuvido);
		
		JCheckBox chckbxTricograma = new JCheckBox("Tricograma");
		chckbxTricograma.setBounds(428, 243, 129, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxTricograma);

	}
}