package br.ufac.si.projeto.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.CitologiaOuvido;
import br.ufac.si.projeto.entidades.CitologiaPele;
import br.ufac.si.projeto.entidades.ParasitologiaOuvido;
import br.ufac.si.projeto.entidades.ParasitologiaPele;
import br.ufac.si.projeto.entidades.Tricograma;
import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.ExameGerente;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;

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
	private static boolean exames[] = new boolean [5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
		frmCadastroDeAmostra.setBounds(100, 100, 646, 403);
		frmCadastroDeAmostra.setLocationRelativeTo(null);
		frmCadastroDeAmostra.setResizable(false);
		frmCadastroDeAmostra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeAmostra.getContentPane().setLayout(null);
		frmCadastroDeAmostra.setVisible(true);
		frmCadastroDeAmostra.setTitle("LADIA - Cadastrar Amostra");

		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setBounds(12, 76, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblAnimal);

		tfAnimal = new JTextField();
		tfAnimal.setBounds(142, 74, 152, 19);
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
		tfEspecie.setBounds(142, 114, 152, 19);
		frmCadastroDeAmostra.getContentPane().add(tfEspecie);
		tfEspecie.setColumns(10);

		tfRaca = new JTextField();
		tfRaca.setBounds(142, 148, 152, 19);
		frmCadastroDeAmostra.getContentPane().add(tfRaca);
		tfRaca.setColumns(10);

		tfSexo = new JTextField();
		tfSexo.setBounds(142, 183, 152, 19);
		frmCadastroDeAmostra.getContentPane().add(tfSexo);
		tfSexo.setColumns(10);

		tfTutor = new JTextField();
		tfTutor.setBounds(142, 218, 152, 19);
		frmCadastroDeAmostra.getContentPane().add(tfTutor);
		tfTutor.setColumns(10);

		tfIdade = new JTextField();
		tfIdade.setBounds(142, 258, 152, 19);
		frmCadastroDeAmostra.getContentPane().add(tfIdade);
		tfIdade.setColumns(10);

		tfRequisitante = new JTextField();
		tfRequisitante.setBounds(142, 298, 152, 19);
		frmCadastroDeAmostra.getContentPane().add(tfRequisitante);
		tfRequisitante.setColumns(10);

		tfAmostras = new JTextField();
		tfAmostras.setBounds(142, 335, 152, 19);
		frmCadastroDeAmostra.getContentPane().add(tfAmostras);
		tfAmostras.setColumns(10);
		
		JCheckBox chckbxParasitologiaDePele = new JCheckBox("Parasitologia de Pele");
		chckbxParasitologiaDePele.setBounds(420, 150, 187, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxParasitologiaDePele);
		
		JCheckBox chckbxParasitologiaDeOuvido = new JCheckBox("Parasitologia de Ouvido");
		chckbxParasitologiaDeOuvido.setBounds(420, 184, 218, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxParasitologiaDeOuvido);
		
		JCheckBox chckbxCitologiaDePele = new JCheckBox("Citologia de Pele");
		chckbxCitologiaDePele.setBounds(420, 219, 187, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxCitologiaDePele);		

		JCheckBox chckbxCitologiaDeOuvido = new JCheckBox("Citologia de Ouvido");
		chckbxCitologiaDeOuvido.setBounds(420, 254, 163, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxCitologiaDeOuvido);
		
		JCheckBox chckbxTricograma = new JCheckBox("Tricograma");
		chckbxTricograma.setBounds(420, 281, 129, 23);
		frmCadastroDeAmostra.getContentPane().add(chckbxTricograma);

		JButton btnConfimar = new JButton("Confirmar");
		btnConfimar.setBounds(364, 332, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnConfimar);
		btnConfimar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
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
					a.setNumeroFicha(Integer.parseInt(tfNFicha.getText()));
					if(chckbxParasitologiaDePele.isSelected()) {
						exames[0]=true;
					}
					if(chckbxParasitologiaDeOuvido.isSelected()) {
						exames[1]=true;
					}
					if(chckbxCitologiaDePele.isSelected()) {
						exames[2]=true;
					}
					if(chckbxCitologiaDeOuvido.isSelected()) {
						exames[3]=true;
					}
					if(chckbxTricograma.isSelected()) {
						exames[4]=true;
					}
					a.setExames(exames);
					ag.adicionar(a);
					ag.encerrar();
					
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
					TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
					frmCadastroDeAmostra.dispose();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
				frmCadastroDeAmostra.dispose();
			}
		});
		btnCancelar.setBounds(490, 332, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnCancelar);
		
		JLabel lblNmeroDaFicha = new JLabel("Número da ficha:");
		lblNmeroDaFicha.setBounds(12, 41, 152, 15);
		frmCadastroDeAmostra.getContentPane().add(lblNmeroDaFicha);
		
		tfNFicha = new JTextField();
		tfNFicha.setBounds(142, 39, 152, 19);
		frmCadastroDeAmostra.getContentPane().add(tfNFicha);
		tfNFicha.setColumns(10);
		
		JLabel lblExames = new JLabel("Exames:");
		lblExames.setBounds(355, 154, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblExames);
		
		JLabel label = new JLabel(TelaLogin.getUsuario().getLogin());
		label.setFont(new Font("Purisa", Font.BOLD, 28));
		label.setBounds(454, 0, 180, 50);
		frmCadastroDeAmostra.getContentPane().add(label);
		
	}

	public static boolean[] getExames() {
		return exames;
	}

	public static void setExames(boolean[] exames) {
		TelaCadastrarAmostra.exames = exames;
	}
	
}