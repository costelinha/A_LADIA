package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.Filamentoso;
import br.ufac.si.projeto.entidades.IsolamentoFungico;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.IsolamentoFungicoGerente;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFilamentoso {

	private JFrame frmFilamentoso;
	private JTextField tfCorVerso;
	private JTextField tfCorReverso;
	private JTextField tfTextura;
	private JTextField tfBorda;
	private JTextField tfMacronidio;
	private JTextField tfMicronidio;

	Filamentoso f1 = new Filamentoso();
	IsolamentoFungicoGerente ifg = new IsolamentoFungicoGerente();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFilamentoso window = new TelaFilamentoso();
					window.frmFilamentoso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaFilamentoso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFilamentoso = new JFrame();
		frmFilamentoso.setTitle("Filamentoso");
		frmFilamentoso.setBounds(100, 100, 450, 336);
		frmFilamentoso.setResizable(false);
		frmFilamentoso.setLocationRelativeTo(null);
		frmFilamentoso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFilamentoso.getContentPane().setLayout(null);
		frmFilamentoso.setVisible(true);
		
		JLabel lblCorDoVerso = new JLabel("Cor do verso:");
		lblCorDoVerso.setBounds(12, 25, 108, 15);
		frmFilamentoso.getContentPane().add(lblCorDoVerso);
		
		JLabel lblCorDoReverso = new JLabel("Cor do reverso:");
		lblCorDoReverso.setBounds(211, 25, 127, 15);
		frmFilamentoso.getContentPane().add(lblCorDoReverso);
		
		tfCorVerso = new JTextField();
		tfCorVerso.setBounds(111, 23, 82, 19);
		frmFilamentoso.getContentPane().add(tfCorVerso);
		tfCorVerso.setColumns(10);
		
		
		tfCorReverso = new JTextField();
		tfCorReverso.setBounds(330, 23, 88, 19);
		frmFilamentoso.getContentPane().add(tfCorReverso);
		tfCorReverso.setColumns(10);
		
		
		JLabel lblTextura = new JLabel("Textura:");
		lblTextura.setBounds(12, 50, 70, 15);
		frmFilamentoso.getContentPane().add(lblTextura);
		
		JLabel lblBorda = new JLabel("Borda:");
		lblBorda.setBounds(211, 50, 70, 15);
		frmFilamentoso.getContentPane().add(lblBorda);
		
		tfTextura = new JTextField();
		tfTextura.setBounds(111, 48, 82, 19);
		frmFilamentoso.getContentPane().add(tfTextura);
		tfTextura.setColumns(10);
		
		
		tfBorda = new JTextField();
		tfBorda.setBounds(330, 50, 88, 19);
		frmFilamentoso.getContentPane().add(tfBorda);
		tfBorda.setColumns(10);
		
		
		JRadioButton rdbtnHifaSeptada = new JRadioButton("Hifa septada");
		rdbtnHifaSeptada.setBounds(12, 66, 127, 23);
		frmFilamentoso.getContentPane().add(rdbtnHifaSeptada);		
		
		JRadioButton rdbtnHifaNoSeptada = new JRadioButton("Hifa não septada");
		rdbtnHifaNoSeptada.setBounds(147, 66, 149, 23);
		frmFilamentoso.getContentPane().add(rdbtnHifaNoSeptada);
		ButtonGroup bgHifa = new ButtonGroup();
		bgHifa.add(rdbtnHifaSeptada);
		bgHifa.add(rdbtnHifaNoSeptada);
		
		
		JRadioButton rdbtnEsporangio = new JRadioButton("Esporângio");
		rdbtnEsporangio.setBounds(12, 93, 127, 23);
		frmFilamentoso.getContentPane().add(rdbtnEsporangio);
		
		JRadioButton rdbtnZigosporngio = new JRadioButton("Zigosporângio");
		rdbtnZigosporngio.setBounds(147, 93, 149, 23);
		frmFilamentoso.getContentPane().add(rdbtnZigosporngio);
		ButtonGroup bgPorangio = new ButtonGroup();
		bgPorangio.add(rdbtnEsporangio);
		bgPorangio.add(rdbtnZigosporngio);
		
		
		JCheckBox chckbxClam = new JCheckBox("Clamidoconídio");
		chckbxClam.setBounds(10, 120, 143, 23);
		frmFilamentoso.getContentPane().add(chckbxClam);
		
		
		JCheckBox chckbxArtrocondio = new JCheckBox("Artroconídio");
		chckbxArtrocondio.setBounds(154, 120, 117, 23);
		frmFilamentoso.getContentPane().add(chckbxArtrocondio);
		
		
		JCheckBox chckbxBasidiosporo = new JCheckBox("Basidiósporo");
		chckbxBasidiosporo.setBounds(276, 120, 129, 23);
		frmFilamentoso.getContentPane().add(chckbxBasidiosporo);
		
				
		tfMacronidio = new JTextField();
		tfMacronidio.setBounds(146, 149, 114, 19);
		frmFilamentoso.getContentPane().add(tfMacronidio);
		tfMacronidio.setColumns(10);
		tfMacronidio.setEnabled(false);
		JCheckBox chckbxMacrocondio = new JCheckBox("Macroconídio:");
		chckbxMacrocondio.setBounds(10, 147, 129, 23);
		frmFilamentoso.getContentPane().add(chckbxMacrocondio);
		chckbxMacrocondio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxMacrocondio.isSelected()) {
					tfMacronidio.setEnabled(true);
				} else {
					tfMacronidio.setText(null);
					tfMacronidio.setEnabled(false);
				}
			}
		});
				
		tfMicronidio = new JTextField();
		tfMicronidio.setBounds(147, 176, 114, 19);
		frmFilamentoso.getContentPane().add(tfMicronidio);
		tfMicronidio.setColumns(10);
		tfMicronidio.setEnabled(false);
		JCheckBox chckbxMicrocondio = new JCheckBox("Microconídio:");
		chckbxMicrocondio.setBounds(10, 174, 129, 23);
		frmFilamentoso.getContentPane().add(chckbxMicrocondio);
		chckbxMicrocondio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxMicrocondio.isSelected()) {
					tfMicronidio.setEnabled(true);
				} else {
					tfMicronidio.setText(null);
					tfMicronidio.setEnabled(false);
				}
			}
		});
		
		JLabel lblObservaes = new JLabel("Observações:");
		lblObservaes.setBounds(12, 207, 108, 15);
		frmFilamentoso.getContentPane().add(lblObservaes);
		
		JTextArea taObs = new JTextArea();
		taObs.setBounds(115, 207, 227, 49);
		frmFilamentoso.getContentPane().add(taObs);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(192, 277, 117, 25);
		frmFilamentoso.getContentPane().add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setCorVerso(tfCorVerso.getText());
				f1.setCorReverso(tfCorReverso.getText());
				f1.setTextura(tfTextura.getText());
				f1.setBorda(tfBorda.getText());
				if(rdbtnHifaSeptada.isSelected()) {
					f1.setHifa(true);
				} else if(rdbtnHifaNoSeptada.isSelected()) {
					f1.setHifa(false);
				}
				if(rdbtnEsporangio.isSelected()) {
					f1.setPorangio(true);
				} else if(rdbtnZigosporngio.isSelected()) {
					f1.setPorangio(false);
				}
				if(chckbxClam.isSelected()) {
					f1.setClamidoconidio(true);
				}
				if(chckbxArtrocondio.isSelected()) {
					f1.setArtroconidio(true);
				}
				if(chckbxBasidiosporo.isSelected()) {
					f1.setBasidiosporo(true);
				}
				if(chckbxMacrocondio.isSelected()) {
					f1.setMacroconidio(tfMacronidio.getText());
				} else {
					f1.setMacroconidio(null);
				}
				if(chckbxMicrocondio.isSelected()) {
					f1.setMicroconidio(tfMicronidio.getText());
				} else {
					f1.setMicroconidio(null);
				}
				f1.setObservacoes(taObs.getText());
				IsolamentoFungico auxID = null;
				auxID = ifg.maiorID().get(0);
				System.out.println(auxID = ifg.maiorID().get(0));
				f1.setId(auxID.getId()+1);
				
				
				ifg.adicionar(f1);
				ifg.encerrar();
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(321, 277, 117, 25);
		frmFilamentoso.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ifg.encerrar();
				
			}
		});
	}
}
