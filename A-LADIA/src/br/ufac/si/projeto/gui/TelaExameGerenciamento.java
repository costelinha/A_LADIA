package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.CitologiaOuvido;
import br.ufac.si.projeto.entidades.CitologiaPele;
import br.ufac.si.projeto.entidades.ParasitologiaOuvido;
import br.ufac.si.projeto.entidades.ParasitologiaPele;
import br.ufac.si.projeto.entidades.Tricograma;
import br.ufac.si.projeto.gerentes.ExameGerente;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaExameGerenciamento {

	private JFrame frame;
	private JTextField tfPositivoPP;
	private JTextField tfPositivoPO;
	private JTextField tfLevedurasCP;
	private JTextField tfBacteriasCP;
	private JTextField tfObsCP;
	private JTextField tfLevedurasCO;
	private JTextField tfBacteriasCO;
	private JTextField tfObsCO;
	private Amostra amostra;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExameGerenciamento window = new TelaExameGerenciamento();
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
	public TelaExameGerenciamento(Amostra amostra) {
		this.amostra = amostra;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JLabel lblParasitologiaDePele = new JLabel("Parasitologia de Pele");
		lblParasitologiaDePele.setBounds(12, 26, 159, 15);
		frame.getContentPane().add(lblParasitologiaDePele);
		
		JRadioButton rdbtnPositivoPP = new JRadioButton("Positivo:");
		rdbtnPositivoPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnPositivoPP.isSelected()) {
					tfPositivoPP.setEnabled(true);
				}
			}
		});
		rdbtnPositivoPP.setBounds(283, 22, 96, 23);
		frame.getContentPane().add(rdbtnPositivoPP);
		
		JRadioButton rdbtnNegativoPP = new JRadioButton("Negativo");
		rdbtnNegativoPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNegativoPP.isSelected()) {
					tfPositivoPP.setEnabled(false);
					tfPositivoPP.setText("");
				}
			}
		});
		rdbtnNegativoPP.setBounds(194, 22, 88, 23);
		frame.getContentPane().add(rdbtnNegativoPP);
		
		ButtonGroup bgPP = new ButtonGroup();
		bgPP.add(rdbtnPositivoPP);
		bgPP.add(rdbtnNegativoPP);
		
		tfPositivoPP = new JTextField();
		tfPositivoPP.setBounds(387, 24, 114, 19);
		tfPositivoPP.setEnabled(false);
		frame.getContentPane().add(tfPositivoPP);
		tfPositivoPP.setColumns(10);
		
		JLabel lblParasitologiaDeOuvido = new JLabel("Parasitologia de Ouvido");
		lblParasitologiaDeOuvido.setBounds(12, 67, 181, 15);
		frame.getContentPane().add(lblParasitologiaDeOuvido);
		
		JRadioButton rdbtnNegativoPO = new JRadioButton("Negativo");
		rdbtnNegativoPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNegativoPO.isSelected()) {
					tfPositivoPO.setEnabled(false);
					tfPositivoPO.setText("");
				}
			}
		});
		rdbtnNegativoPO.setBounds(194, 63, 88, 23);
		frame.getContentPane().add(rdbtnNegativoPO);
		
		JRadioButton rdbtnPositivoPO = new JRadioButton("Positivo:");
		rdbtnPositivoPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPositivoPO.isSelected()) {
					tfPositivoPO.setEnabled(true);
				}
			}
		});
		rdbtnPositivoPO.setBounds(290, 63, 92, 23);
		frame.getContentPane().add(rdbtnPositivoPO);
		
		ButtonGroup bgPO = new ButtonGroup();
		bgPO.add(rdbtnNegativoPO);
		bgPO.add(rdbtnPositivoPO);
		
		tfPositivoPO = new JTextField();
		tfPositivoPO.setEnabled(false);
		tfPositivoPO.setBounds(387, 65, 114, 19);
		frame.getContentPane().add(tfPositivoPO);
		tfPositivoPO.setColumns(10);
		
		JLabel lblCitologiaDePele = new JLabel("Citologia de Pele");
		lblCitologiaDePele.setBounds(12, 105, 120, 15);
		frame.getContentPane().add(lblCitologiaDePele);
		
		JCheckBox chckbxCedCP = new JCheckBox("CED");
		chckbxCedCP.setBounds(22, 128, 52, 23);
		frame.getContentPane().add(chckbxCedCP);
		
		JCheckBox chckbxCenCP = new JCheckBox("CEN");
		chckbxCenCP.setBounds(181, 128, 52, 23);
		frame.getContentPane().add(chckbxCenCP);
		
		JCheckBox chckbxMacrfagosCP = new JCheckBox("Macrófagos");
		chckbxMacrfagosCP.setBounds(20, 155, 129, 23);
		frame.getContentPane().add(chckbxMacrfagosCP);
		
		JCheckBox chckbxEosinfilosCP = new JCheckBox("Eosinófilos");
		chckbxEosinfilosCP.setBounds(181, 155, 129, 23);
		frame.getContentPane().add(chckbxEosinfilosCP);
		
		JCheckBox chckbxLevedurasCP = new JCheckBox("Leveduras:");
		chckbxLevedurasCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxLevedurasCP.isSelected()) {
					tfLevedurasCP.setEnabled(true);
				}
				if(chckbxLevedurasCP.isSelected()==false) {
					tfLevedurasCP.setEnabled(false);
					tfLevedurasCP.setText("");
				}
			}
		});
		chckbxLevedurasCP.setBounds(22, 182, 104, 23);
		frame.getContentPane().add(chckbxLevedurasCP);
		
		tfLevedurasCP = new JTextField();
		tfLevedurasCP.setEnabled(false);
		tfLevedurasCP.setBounds(134, 184, 148, 19);
		frame.getContentPane().add(tfLevedurasCP);
		tfLevedurasCP.setColumns(10);
		
		JCheckBox chckbxNeutrfilosCP = new JCheckBox("Neutrófilos");
		chckbxNeutrfilosCP.setBounds(313, 128, 129, 23);
		frame.getContentPane().add(chckbxNeutrfilosCP);
		
		JCheckBox chckbxCNeoplsicasCP = new JCheckBox("C. Neoplásicas (encaminhar)");
		chckbxCNeoplsicasCP.setForeground(Color.RED);
		chckbxCNeoplsicasCP.setBounds(314, 155, 240, 23);
		frame.getContentPane().add(chckbxCNeoplsicasCP);
		
		JCheckBox chckbxBactriasCP = new JCheckBox("Bactérias:");
		chckbxBactriasCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxBactriasCP.isSelected()) {
					tfBacteriasCP.setEnabled(true);
				}
				if(chckbxBactriasCP.isSelected()==false) {
					tfBacteriasCP.setEnabled(false);
					tfBacteriasCP.setText("");
				}
			}
		});
		chckbxBactriasCP.setBounds(313, 182, 104, 23);
		frame.getContentPane().add(chckbxBactriasCP);
		
		tfBacteriasCP = new JTextField();
		tfBacteriasCP.setEnabled(false);
		tfBacteriasCP.setBounds(420, 184, 134, 19);
		frame.getContentPane().add(tfBacteriasCP);
		tfBacteriasCP.setColumns(10);
		
		JLabel lblObsCP = new JLabel("Obs:");
		lblObsCP.setBounds(12, 213, 70, 15);
		frame.getContentPane().add(lblObsCP);
		
		tfObsCP = new JTextField();
		tfObsCP.setBounds(57, 213, 148, 19);
		frame.getContentPane().add(tfObsCP);
		tfObsCP.setColumns(10);
		
		JLabel lblCitologiaDeOuvido = new JLabel("Citologia de Ouvido");
		lblCitologiaDeOuvido.setBounds(22, 246, 149, 15);
		frame.getContentPane().add(lblCitologiaDeOuvido);
		
		JCheckBox chckbxCedCO = new JCheckBox("CED");
		chckbxCedCO.setBounds(22, 260, 52, 23);
		frame.getContentPane().add(chckbxCedCO);
		
		JCheckBox chckbxCenCO = new JCheckBox("CEN");
		chckbxCenCO.setBounds(181, 260, 52, 23);
		frame.getContentPane().add(chckbxCenCO);
		
		JCheckBox chckbxNeutrofilosCO = new JCheckBox("Neutrófilos");
		chckbxNeutrofilosCO.setBounds(313, 260, 129, 23);
		frame.getContentPane().add(chckbxNeutrofilosCO);
		
		JCheckBox chckbsMacrofagosCO = new JCheckBox("Macrófagos");
		chckbsMacrofagosCO.setBounds(20, 287, 129, 23);
		frame.getContentPane().add(chckbsMacrofagosCO);
		
		JCheckBox chckbsEosinofilosCO = new JCheckBox("Eosinófilos");
		chckbsEosinofilosCO.setBounds(181, 287, 129, 23);
		frame.getContentPane().add(chckbsEosinofilosCO);
		
		JCheckBox chckbsCNeoplasicasCO = new JCheckBox("C. Neoplásicas (encaminhar)");
		chckbsCNeoplasicasCO.setForeground(Color.RED);
		chckbsCNeoplasicasCO.setBounds(314, 287, 240, 23);
		frame.getContentPane().add(chckbsCNeoplasicasCO);
		
		JCheckBox chckbsLevedurasCO = new JCheckBox("Leveduras:");
		chckbsLevedurasCO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbsLevedurasCO.isSelected()) {
					tfLevedurasCO.setEnabled(true);
				}
				if(chckbsLevedurasCO.isSelected()==false) {
					tfLevedurasCO.setEnabled(false);
					tfLevedurasCO.setText("");
				}
			}
		});
		chckbsLevedurasCO.setBounds(22, 314, 104, 23);
		frame.getContentPane().add(chckbsLevedurasCO);
		
		tfLevedurasCO = new JTextField();
		tfLevedurasCO.setEnabled(false);
		tfLevedurasCO.setColumns(10);
		tfLevedurasCO.setBounds(134, 316, 148, 19);
		frame.getContentPane().add(tfLevedurasCO);
		
		JCheckBox chckbBacteriasCO = new JCheckBox("Bactérias:");
		chckbBacteriasCO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbBacteriasCO.isSelected()) {
					tfBacteriasCO.setEnabled(true);
				}
				if(chckbBacteriasCO.isSelected()==false) {
					tfBacteriasCO.setEnabled(false);
					tfBacteriasCO.setText("");
				}
			}
		});
		chckbBacteriasCO.setBounds(313, 314, 104, 23);
		frame.getContentPane().add(chckbBacteriasCO);
		
		tfBacteriasCO = new JTextField();
		tfBacteriasCO.setEnabled(false);
		tfBacteriasCO.setColumns(10);
		tfBacteriasCO.setBounds(420, 316, 134, 19);
		frame.getContentPane().add(tfBacteriasCO);
		
		JLabel lblObsCO = new JLabel("Obs:");
		lblObsCO.setBounds(12, 345, 70, 15);
		frame.getContentPane().add(lblObsCO);
		
		tfObsCO = new JTextField();
		tfObsCO.setColumns(10);
		tfObsCO.setBounds(57, 345, 148, 19);
		frame.getContentPane().add(tfObsCO);
		
		JLabel lblTricograma = new JLabel("Tricograma");
		lblTricograma.setBounds(12, 388, 120, 15);
		frame.getContentPane().add(lblTricograma);
		
		JRadioButton rdbtnNegativoT = new JRadioButton("Negativo");
		rdbtnNegativoT.setBounds(12, 411, 88, 23);
		frame.getContentPane().add(rdbtnNegativoT);
		
		JRadioButton rdbtnPositivoT = new JRadioButton("Positivo:");
		rdbtnPositivoT.setBounds(112, 411, 86, 23);
		frame.getContentPane().add(rdbtnPositivoT);
		
		ButtonGroup bgT = new ButtonGroup();
		bgT.add(rdbtnNegativoT);
		bgT.add(rdbtnPositivoT);
		
		JCheckBox chckbxEndothrix = new JCheckBox("Endothrix");
		chckbxEndothrix.setEnabled(false);
		chckbxEndothrix.setBounds(205, 411, 96, 23);
		frame.getContentPane().add(chckbxEndothrix);
		
		JCheckBox chckbxEctothrix = new JCheckBox("Ectothrix");
		chckbxEctothrix.setEnabled(false);
		chckbxEctothrix.setBounds(305, 411, 88, 23);
		frame.getContentPane().add(chckbxEctothrix);

		rdbtnPositivoT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPositivoT.isSelected()) {
					chckbxEndothrix.setEnabled(true);
					chckbxEctothrix.setEnabled(true);
				}
			}
		});
		rdbtnNegativoT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNegativoT.isSelected()) {
					chckbxEndothrix.setEnabled(false);
					chckbxEctothrix.setEnabled(false);
					chckbxEndothrix.setSelected(false);
					chckbxEctothrix.setSelected(false);
				}
			}
		});
		
		if(amostra.getExames()[0]==false) {
			rdbtnNegativoPP.setEnabled(false);
			rdbtnPositivoPP.setEnabled(false);
		}
		if(amostra.getExames()[1]==false) {
			rdbtnNegativoPO.setEnabled(false);
			rdbtnPositivoPO.setEnabled(false);
		}
		if(amostra.getExames()[2]==false) {
			chckbxCedCP.setEnabled(false);
			chckbxCenCP.setEnabled(false);
			chckbxMacrfagosCP.setEnabled(false);
			chckbxNeutrfilosCP.setEnabled(false);
			chckbxBactriasCP.setEnabled(false);
			chckbxCNeoplsicasCP.setEnabled(false);
			chckbxEosinfilosCP.setEnabled(false);
			chckbxLevedurasCP.setEnabled(false);
			tfObsCP.setEnabled(false);
		}
		if(amostra.getExames()[3]==false) {
			chckbxCedCO.setEnabled(false);
			chckbxCenCO.setEnabled(false);
			chckbsMacrofagosCO.setEnabled(false);
			chckbxNeutrofilosCO.setEnabled(false);
			chckbBacteriasCO.setEnabled(false);
			chckbsCNeoplasicasCO.setEnabled(false);
			chckbsEosinofilosCO.setEnabled(false);
			chckbsLevedurasCO.setEnabled(false);
			tfObsCO.setEnabled(false);
		}
		if(amostra.getExames()[4]==false) {
			rdbtnNegativoT.setEnabled(false);
			rdbtnPositivoT.setEnabled(false);
		}
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExameGerente eg = new ExameGerente();
				if(amostra.getExames()[0]==true) {
					ParasitologiaPele pp = new ParasitologiaPele();
					if(rdbtnPositivoPP.isSelected()) {
						pp.setResultado(true);
					}
					pp.setAmostra(amostra);
					eg.adicionar(pp);
				}
				if(amostra.getExames()[1]==true) {
					ParasitologiaOuvido po = new ParasitologiaOuvido();
					if(rdbtnPositivoPO.isSelected()) {
						po.setResultado(true);
					}
					po.setAmostra(amostra);
					eg.adicionar(po);
				}
				if(amostra.getExames()[2]==true) {
					CitologiaPele cp = new CitologiaPele();
					if(chckbxCedCP.isSelected()) {
						cp.setCen(true);
					}
					if(chckbxCenCP.isSelected()) {
						cp.setCed(true);
					}
					if(chckbxNeutrfilosCP.isSelected()) {
						cp.setNeutrofilos(true);
					}
					if(chckbxMacrfagosCP.isSelected()) {
						cp.setMacrofagos(true);
					}
					if(chckbxEosinfilosCP.isSelected()) {
						cp.setEosinofilos(true);
					}
					if(chckbxCNeoplsicasCP.isSelected()) {
						cp.setcNeoplasicas(true);
					}
					if(chckbxLevedurasCP.isSelected()) {
						cp.setLeveduras(tfLevedurasCP.getText());
					}
					if(chckbxBactriasCP.isSelected()) {
						cp.setBacterias(tfBacteriasCP.getText());
					}
					cp.setObservacao(tfObsCP.getText());
					cp.setAmostra(amostra);
					eg.adicionar(cp);
				}
				if(amostra.getExames()[3]==true) {
					CitologiaOuvido co = new CitologiaOuvido();
					if(chckbxCedCO.isSelected()) {
						co.setCen(true);
					}
					if(chckbxCenCO.isSelected()) {
						co.setCed(true);
					}
					if(chckbxNeutrofilosCO.isSelected()) {
						co.setNeutrofilos(true);
					}
					if(chckbsMacrofagosCO.isSelected()) {
						co.setMacrofagos(true);
					}
					if(chckbsEosinofilosCO.isSelected()) {
						co.setEosinofilos(true);
					}
					if(chckbsCNeoplasicasCO.isSelected()) {
						co.setcNeoplasicas(true);
					}
					if(chckbsLevedurasCO.isSelected()) {
						co.setLeveduras(tfLevedurasCO.getText());
					}
					if(chckbBacteriasCO.isSelected()) {
						co.setBacterias(tfBacteriasCO.getText());
					}
					co.setObservacao(tfObsCO.getText());
					co.setAmostra(amostra);
					eg.adicionar(co);
				}
				if(amostra.getExames()[4]==true) {
					Tricograma t = new Tricograma();
					if(rdbtnPositivoT.isSelected()) {
						if(chckbxEndothrix.isSelected()) {
							t.setResultado(chckbxEndothrix.getText());
						} else {
							t.setResultado(chckbxEctothrix.getText());
						}
					}
					t.setAmostra(amostra);
					eg.adicionar(t);
				}
				JOptionPane.showMessageDialog(null, "Exame(s) salvo(s)");
				eg.encerrar();
				TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
				frame.dispose();
			}
		});
		btnSalvar.setBounds(375, 485, 117, 25);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
				frame.dispose();
			}
		});
		btnCancelar.setBounds(511, 485, 117, 25);
		frame.getContentPane().add(btnCancelar);
	}
}
