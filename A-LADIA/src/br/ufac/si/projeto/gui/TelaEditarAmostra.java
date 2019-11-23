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

public class TelaEditarAmostra {

	private JFrame frame;
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
	public TelaEditarAmostra(Amostra amostra) {
		this.amostra = amostra;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Editar de Amostra");
		frame.setBounds(100, 100, 646, 405);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("LADIA - Editar Amostra");

		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setBounds(12, 122, 70, 15);
		frame.getContentPane().add(lblAnimal);

		tfAnimal = new JTextField();
		tfAnimal.setBounds(142, 120, 171, 19);
		tfAnimal.setText(amostra.getAnimal());
		frame.getContentPane().add(tfAnimal);
		tfAnimal.setColumns(10);

		JLabel lblEspecie = new JLabel("Espécie:");
		lblEspecie.setBounds(12, 151, 70, 15);
		frame.getContentPane().add(lblEspecie);

		JLabel lblRaca = new JLabel("Raça:");
		lblRaca.setBounds(12, 180, 70, 15);
		frame.getContentPane().add(lblRaca);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 209, 70, 15);
		frame.getContentPane().add(lblSexo);

		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setBounds(12, 238, 91, 15);
		frame.getContentPane().add(lblTutor);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(12, 267, 70, 15);
		frame.getContentPane().add(lblIdade);

		JLabel lblRequisitante = new JLabel("Requisitante:");
		lblRequisitante.setBounds(12, 296, 101, 15);
		frame.getContentPane().add(lblRequisitante);

		JLabel lblAmostras = new JLabel("Amostras:");
		lblAmostras.setBounds(12, 325, 91, 15);
		frame.getContentPane().add(lblAmostras);

		tfEspecie = new JTextField();
		tfEspecie.setBounds(142, 149, 171, 19);
		tfEspecie.setText(amostra.getEspecie());
		frame.getContentPane().add(tfEspecie);
		tfEspecie.setColumns(10);

		tfRaca = new JTextField();
		tfRaca.setBounds(142, 178, 171, 19);
		tfRaca.setText(amostra.getRaca());
		frame.getContentPane().add(tfRaca);
		tfRaca.setColumns(10);

		tfSexo = new JTextField();
		tfSexo.setBounds(142, 207, 171, 19);
		tfSexo.setText(amostra.getSexo());
		frame.getContentPane().add(tfSexo);
		tfSexo.setColumns(10);

		tfTutor = new JTextField();
		tfTutor.setBounds(142, 236, 171, 19);
		tfTutor.setText(amostra.getTutor());
		frame.getContentPane().add(tfTutor);
		tfTutor.setColumns(10);

		tfIdade = new JTextField();
		tfIdade.setBounds(142, 265, 171, 19);
		tfIdade.setText(amostra.getIdade());
		frame.getContentPane().add(tfIdade);
		tfIdade.setColumns(10);

		tfRequisitante = new JTextField();
		tfRequisitante.setBounds(142, 294, 171, 19);
		tfRequisitante.setText(amostra.getRequisitante());
		frame.getContentPane().add(tfRequisitante);
		tfRequisitante.setColumns(10);

		tfAmostras = new JTextField();
		tfAmostras.setBounds(142, 323, 171, 19);
		tfAmostras.setText(amostra.getAmostras());
		frame.getContentPane().add(tfAmostras);
		tfAmostras.setColumns(10);
		
		JCheckBox chckbxParasitologiaDePele = new JCheckBox("Parasitologia de Pele");
		chckbxParasitologiaDePele.setBounds(406, 93, 187, 23);
		if(amostra.getExames()[0]) {
			chckbxParasitologiaDePele.setSelected(true);
		}
		frame.getContentPane().add(chckbxParasitologiaDePele);
		
		JCheckBox chckbxParasitologiaDeOuvido = new JCheckBox("Parasitologia de Ouvido");
		chckbxParasitologiaDeOuvido.setBounds(406, 127, 218, 23);
		if(amostra.getExames()[1]) {
			chckbxParasitologiaDeOuvido.setSelected(true);
		}
		frame.getContentPane().add(chckbxParasitologiaDeOuvido);
		
		JCheckBox chckbxCitologiaDePele = new JCheckBox("Citologia de Pele");
		chckbxCitologiaDePele.setBounds(406, 162, 187, 23);
		if(amostra.getExames()[2]) {
			chckbxCitologiaDePele.setSelected(true);
		}
		frame.getContentPane().add(chckbxCitologiaDePele);		

		JCheckBox chckbxCitologiaDeOuvido = new JCheckBox("Citologia de Ouvido");
		chckbxCitologiaDeOuvido.setBounds(406, 197, 163, 23);
		if(amostra.getExames()[3]) {
			chckbxCitologiaDeOuvido.setSelected(true);
		}
		frame.getContentPane().add(chckbxCitologiaDeOuvido);
		
		JCheckBox chckbxTricograma = new JCheckBox("Tricograma");
		chckbxTricograma.setBounds(406, 237, 129, 23);
		if(amostra.getExames()[4]) {
			chckbxTricograma.setSelected(true);
		}
		frame.getContentPane().add(chckbxTricograma);

		JButton btnConfimar = new JButton("Confirmar");
		btnConfimar.setBounds(359, 325, 117, 25);
		frame.getContentPane().add(btnConfimar);
		btnConfimar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
					Date data = new Date();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(data);
					AmostraGerente ag = new AmostraGerente();
					Amostra a = new Amostra();
					ag.recuperar(amostra.getNumeroAmostra()).setAnimal(tfAnimal.getText());
					ag.recuperar(amostra.getNumeroAmostra()).setRaca(tfRaca.getText());
					ag.recuperar(amostra.getNumeroAmostra()).setEspecie(tfEspecie.getText());
					ag.recuperar(amostra.getNumeroAmostra()).setAmostras(tfAmostras.getText());
					ag.recuperar(amostra.getNumeroAmostra()).setRequisitante(tfRequisitante.getText());
					ag.recuperar(amostra.getNumeroAmostra()).setTutor(tfTutor.getText());
					ag.recuperar(amostra.getNumeroAmostra()).setSexo(tfSexo.getText());
					ag.recuperar(amostra.getNumeroAmostra()).setIdade(tfIdade.getText());	
					ag.recuperar(amostra.getNumeroAmostra()).setNumeroFicha(Integer.parseInt(tfNFicha.getText()));
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
					ag.recuperar(amostra.getNumeroAmostra()).setUsuario(TelaLogin.getUsuario());
					
					ag.recuperar(amostra.getNumeroAmostra()).setExames(exames);
					ag.atualizar(ag.recuperar(amostra.getNumeroAmostra()));
					ag.encerrar();
					
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
					TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
					frame.dispose();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
				frame.dispose();
			}
		});
		btnCancelar.setBounds(507, 325, 117, 25);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblNmeroDaFicha = new JLabel("Número da ficha:");
		lblNmeroDaFicha.setBounds(12, 93, 152, 15);
		frame.getContentPane().add(lblNmeroDaFicha);
		
		tfNFicha = new JTextField();
		tfNFicha.setBounds(142, 91, 171, 19);
		tfNFicha.setText(amostra.getNumeroFicha()+"");
		frame.getContentPane().add(tfNFicha);
		tfNFicha.setColumns(10);
		
		JLabel lblExames = new JLabel("Exames:");
		lblExames.setBounds(341, 97, 70, 15);
		frame.getContentPane().add(lblExames);
		
		JLabel label = new JLabel(TelaLogin.getUsuario().getLogin());
		label.setFont(new Font("Purisa", Font.BOLD, 28));
		label.setBounds(439, 12, 187, 50);
		frame.getContentPane().add(label);
		
	}

	public static boolean[] getExames() {
		return exames;
	}

	public static void setExames(boolean[] exames) {
		TelaEditarAmostra.exames = exames;
	}
	
}