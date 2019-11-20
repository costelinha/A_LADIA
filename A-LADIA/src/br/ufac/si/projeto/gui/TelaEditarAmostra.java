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

public class TelaEditarAmostra {

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
	private Amostra amostra;
	private static boolean exames[] = new boolean [5];

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarAmostra window = new TelaEditarAmostra();
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
	public TelaEditarAmostra(Amostra amostra) {
		this.amostra = amostra;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmCadastroDeAmostra = new JFrame();
		frmCadastroDeAmostra.setTitle("Cadastro de Amostra");
		frmCadastroDeAmostra.setBounds(100, 100, 646, 497);
		frmCadastroDeAmostra.setLocationRelativeTo(null);
		frmCadastroDeAmostra.setResizable(false);
		frmCadastroDeAmostra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeAmostra.getContentPane().setLayout(null);
		frmCadastroDeAmostra.setVisible(true);

		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setBounds(12, 76, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblAnimal);

		tfAnimal = new JTextField();
		tfAnimal.setBounds(66, 74, 228, 19);
		tfAnimal.setText(amostra.getAnimal());
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
		tfEspecie.setText(amostra.getEspecie());
		frmCadastroDeAmostra.getContentPane().add(tfEspecie);
		tfEspecie.setColumns(10);

		tfRaca = new JTextField();
		tfRaca.setBounds(100, 145, 238, 19);
		tfRaca.setText(amostra.getRaca());
		frmCadastroDeAmostra.getContentPane().add(tfRaca);
		tfRaca.setColumns(10);

		tfSexo = new JTextField();
		tfSexo.setBounds(214, 183, 114, 19);
		tfSexo.setText(amostra.getSexo());
		frmCadastroDeAmostra.getContentPane().add(tfSexo);
		tfSexo.setColumns(10);

		tfTutor = new JTextField();
		tfTutor.setBounds(147, 218, 181, 19);
		tfTutor.setText(amostra.getTutor());
		frmCadastroDeAmostra.getContentPane().add(tfTutor);
		tfTutor.setColumns(10);

		tfIdade = new JTextField();
		tfIdade.setBounds(100, 258, 228, 19);
		tfIdade.setText(amostra.getIdade());
		frmCadastroDeAmostra.getContentPane().add(tfIdade);
		tfIdade.setColumns(10);

		tfRequisitante = new JTextField();
		tfRequisitante.setBounds(147, 298, 181, 19);
		tfRequisitante.setText(amostra.getRequisitante());
		frmCadastroDeAmostra.getContentPane().add(tfRequisitante);
		tfRequisitante.setColumns(10);

		tfAmostras = new JTextField();
		tfAmostras.setBounds(110, 335, 218, 19);
		tfAmostras.setText(amostra.getAmostras());
		frmCadastroDeAmostra.getContentPane().add(tfAmostras);
		tfAmostras.setColumns(10);
		
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

		JButton btnConfimar = new JButton("Confirmar");
		btnConfimar.setBounds(53, 432, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnConfimar);
		btnConfimar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
					Date data = new Date();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(data);
					AmostraGerente ag = new AmostraGerente();
					Amostra a = new Amostra();
					ag.recuperar(a.getNumeroAmostra()).setAnimal(tfAnimal.getText());
					ag.recuperar(a.getNumeroAmostra()).setRaca(tfRaca.getText());
					ag.recuperar(a.getNumeroAmostra()).setEspecie(tfEspecie.getText());
					ag.recuperar(a.getNumeroAmostra()).setAmostras(tfAmostras.getText());
					ag.recuperar(a.getNumeroAmostra()).setRequisitante(tfRequisitante.getText());
					ag.recuperar(a.getNumeroAmostra()).setTutor(tfTutor.getText());
					ag.recuperar(a.getNumeroAmostra()).setSexo(tfSexo.getText());
					ag.recuperar(a.getNumeroAmostra()).setIdade(tfIdade.getText());		
				/*	if(chckbxParasitologiaDePele.isSelected()) {
						a.exames[0]=true;
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
					}*/
					
				
					
					
					a.setExames(exames);
					ag.atualizar(ag.recuperar(a.getNumeroAmostra()));
					ag.encerrar();
					
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
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
		btnCancelar.setBounds(211, 432, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnCancelar);
		
		JLabel lblNmeroDaFicha = new JLabel("Número da ficha:");
		lblNmeroDaFicha.setBounds(382, 63, 152, 15);
		frmCadastroDeAmostra.getContentPane().add(lblNmeroDaFicha);
		
		tfNFicha = new JTextField();
		tfNFicha.setBounds(520, 61, 114, 19);
		tfNFicha.setText(amostra.getNumeroFicha()+"");
		tfNFicha.disable();
		frmCadastroDeAmostra.getContentPane().add(tfNFicha);
		tfNFicha.setColumns(10);

		btnCancelar.setBounds(211, 432, 117, 25);
		frmCadastroDeAmostra.getContentPane().add(btnCancelar);
		
		JLabel lblExames = new JLabel("Exames:");
		lblExames.setBounds(363, 116, 70, 15);
		frmCadastroDeAmostra.getContentPane().add(lblExames);
		
	}

	public static boolean[] getExames() {
		return exames;
	}

	public static void setExames(boolean[] exames) {
		TelaEditarAmostra.exames = exames;
	}
	
}