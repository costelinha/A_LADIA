package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;

public class TelaExameGerenciamento {

	private JFrame frmLadiaExames;
	private JTextField tfPP;
	private JTextField tfPositivoPO;
	private JTextField tfLevCP;
	private JTextField tfBacCP;
	private JTextField tfLevCO;
	private JTextField tfBacCO;
	private JTextField tfObsCO;
	private JTextField tfObsCP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExameGerenciamento window = new TelaExameGerenciamento();
					window.frmLadiaExames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExameGerenciamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLadiaExames = new JFrame();
		frmLadiaExames.getContentPane().setEnabled(false);
		frmLadiaExames.getContentPane().setForeground(Color.GRAY);
		frmLadiaExames.setTitle("LADIA - Exames");
		frmLadiaExames.setBounds(100, 100, 624, 528);
		frmLadiaExames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLadiaExames.getContentPane().setLayout(null);
		
		JLabel lblParasitologiaDePele = new JLabel("Parasitologia de Pele");
		lblParasitologiaDePele.setForeground(Color.GRAY);
		lblParasitologiaDePele.setBounds(12, 12, 166, 15);
		frmLadiaExames.getContentPane().add(lblParasitologiaDePele);
		
		JRadioButton rdbtnNegativoPP = new JRadioButton("Negativo");
		rdbtnNegativoPP.setEnabled(false);
		rdbtnNegativoPP.setBounds(200, 8, 88, 23);
		frmLadiaExames.getContentPane().add(rdbtnNegativoPP);
		
		JRadioButton rdbtnPositivoPP = new JRadioButton("Positivo:");
		rdbtnPositivoPP.setEnabled(false);
		rdbtnPositivoPP.setBounds(294, 8, 88, 23);
		frmLadiaExames.getContentPane().add(rdbtnPositivoPP);
		
		tfPP = new JTextField();
		tfPP.setEnabled(false);
		tfPP.setBounds(390, 10, 114, 19);
		frmLadiaExames.getContentPane().add(tfPP);
		tfPP.setColumns(10);
		
		JLabel lblParasitologiaDeOuvido = new JLabel("Parasitologia de Ouvido");
		lblParasitologiaDeOuvido.setForeground(Color.GRAY);
		lblParasitologiaDeOuvido.setBounds(12, 206, 188, 15);
		frmLadiaExames.getContentPane().add(lblParasitologiaDeOuvido);
		
		JRadioButton rdbNegativoPO = new JRadioButton("Negativo");
		rdbNegativoPO.setEnabled(false);
		rdbNegativoPO.setBounds(200, 202, 88, 23);
		frmLadiaExames.getContentPane().add(rdbNegativoPO);
		
		JRadioButton rdbPositivoPO = new JRadioButton("Positivo:");
		rdbPositivoPO.setEnabled(false);
		rdbPositivoPO.setBounds(294, 202, 88, 23);
		frmLadiaExames.getContentPane().add(rdbPositivoPO);
		
		tfPositivoPO = new JTextField();
		tfPositivoPO.setEnabled(false);
		tfPositivoPO.setColumns(10);
		tfPositivoPO.setBounds(390, 204, 114, 19);
		frmLadiaExames.getContentPane().add(tfPositivoPO);
		
		JLabel lblCitologiaDePele = new JLabel("Citologia de Pele");
		lblCitologiaDePele.setForeground(Color.GRAY);
		lblCitologiaDePele.setBounds(12, 51, 138, 15);
		frmLadiaExames.getContentPane().add(lblCitologiaDePele);
		
		JCheckBox chckbxCedCP = new JCheckBox("CED");
		chckbxCedCP.setEnabled(false);
		chckbxCedCP.setBounds(12, 74, 52, 23);
		frmLadiaExames.getContentPane().add(chckbxCedCP);
		
		JCheckBox chckbxCenCP = new JCheckBox("CEN");
		chckbxCenCP.setEnabled(false);
		chckbxCenCP.setBounds(124, 74, 52, 23);
		frmLadiaExames.getContentPane().add(chckbxCenCP);
		
		JCheckBox chckbxNeutrfilosCP = new JCheckBox("Neutrófilos");
		chckbxNeutrfilosCP.setEnabled(false);
		chckbxNeutrfilosCP.setBounds(232, 74, 104, 23);
		frmLadiaExames.getContentPane().add(chckbxNeutrfilosCP);
		
		JCheckBox chckbxLinfcitosCP = new JCheckBox("Linfócitos");
		chckbxLinfcitosCP.setEnabled(false);
		chckbxLinfcitosCP.setBounds(340, 74, 94, 23);
		frmLadiaExames.getContentPane().add(chckbxLinfcitosCP);
		
		JCheckBox chckbxMacrfagosCP = new JCheckBox("Macrófagos");
		chckbxMacrfagosCP.setEnabled(false);
		chckbxMacrfagosCP.setBounds(12, 101, 108, 23);
		frmLadiaExames.getContentPane().add(chckbxMacrfagosCP);
		
		JCheckBox chckbxEosinfilosCP = new JCheckBox("Eosinófilos");
		chckbxEosinfilosCP.setEnabled(false);
		chckbxEosinfilosCP.setBounds(124, 101, 104, 23);
		frmLadiaExames.getContentPane().add(chckbxEosinfilosCP);
		
		JCheckBox chckbxCNeoplsicasCP = new JCheckBox("C. Neoplásicas (encaminhar)");
		chckbxCNeoplsicasCP.setEnabled(false);
		chckbxCNeoplsicasCP.setBounds(232, 101, 232, 23);
		frmLadiaExames.getContentPane().add(chckbxCNeoplsicasCP);
		
		JCheckBox chckbxLevedurasCP = new JCheckBox("Leveduras:");
		chckbxLevedurasCP.setEnabled(false);
		chckbxLevedurasCP.setBounds(12, 128, 104, 23);
		frmLadiaExames.getContentPane().add(chckbxLevedurasCP);
		
		tfLevCP = new JTextField();
		tfLevCP.setEnabled(false);
		tfLevCP.setBounds(124, 132, 104, 19);
		frmLadiaExames.getContentPane().add(tfLevCP);
		tfLevCP.setColumns(10);
		
		JCheckBox chckbxBactriasCP = new JCheckBox("Bactérias:");
		chckbxBactriasCP.setEnabled(false);
		chckbxBactriasCP.setBounds(232, 128, 104, 23);
		frmLadiaExames.getContentPane().add(chckbxBactriasCP);
		
		tfBacCP = new JTextField();
		tfBacCP.setEnabled(false);
		tfBacCP.setBounds(340, 130, 114, 19);
		frmLadiaExames.getContentPane().add(tfBacCP);
		tfBacCP.setColumns(10);
		
		JLabel lblCitologiaDeOuvido = new JLabel("Citologia de Ouvido");
		lblCitologiaDeOuvido.setForeground(Color.GRAY);
		lblCitologiaDeOuvido.setBounds(12, 255, 138, 15);
		frmLadiaExames.getContentPane().add(lblCitologiaDeOuvido);
		
		JCheckBox chckCEDCO = new JCheckBox("CED");
		chckCEDCO.setEnabled(false);
		chckCEDCO.setBounds(12, 278, 52, 23);
		frmLadiaExames.getContentPane().add(chckCEDCO);
		
		JCheckBox chckMacroCO = new JCheckBox("Macrófagos");
		chckMacroCO.setEnabled(false);
		chckMacroCO.setBounds(12, 305, 108, 23);
		frmLadiaExames.getContentPane().add(chckMacroCO);
		
		JCheckBox chckLevCO = new JCheckBox("Leveduras:");
		chckLevCO.setEnabled(false);
		chckLevCO.setBounds(12, 332, 104, 23);
		frmLadiaExames.getContentPane().add(chckLevCO);
		
		tfLevCO = new JTextField();
		tfLevCO.setEnabled(false);
		tfLevCO.setColumns(10);
		tfLevCO.setBounds(124, 336, 104, 19);
		frmLadiaExames.getContentPane().add(tfLevCO);
		
		JCheckBox chckEosiCO = new JCheckBox("Eosinófilos");
		chckEosiCO.setEnabled(false);
		chckEosiCO.setBounds(124, 305, 104, 23);
		frmLadiaExames.getContentPane().add(chckEosiCO);
		
		JCheckBox chckCENCO = new JCheckBox("CEN");
		chckCENCO.setEnabled(false);
		chckCENCO.setBounds(124, 278, 52, 23);
		frmLadiaExames.getContentPane().add(chckCENCO);
		
		JCheckBox chckNeutroCO = new JCheckBox("Neutrófilos");
		chckNeutroCO.setEnabled(false);
		chckNeutroCO.setBounds(232, 278, 104, 23);
		frmLadiaExames.getContentPane().add(chckNeutroCO);
		
		JCheckBox chckNeopCO = new JCheckBox("C. Neoplásicas (encaminhar)");
		chckNeopCO.setEnabled(false);
		chckNeopCO.setBounds(232, 305, 232, 23);
		frmLadiaExames.getContentPane().add(chckNeopCO);
		
		JCheckBox chckBacCO = new JCheckBox("Bactérias:");
		chckBacCO.setEnabled(false);
		chckBacCO.setBounds(232, 332, 104, 23);
		frmLadiaExames.getContentPane().add(chckBacCO);
		
		tfBacCO = new JTextField();
		tfBacCO.setEnabled(false);
		tfBacCO.setColumns(10);
		tfBacCO.setBounds(340, 334, 114, 19);
		frmLadiaExames.getContentPane().add(tfBacCO);
		
		JCheckBox chckLinfCO = new JCheckBox("Linfócitos");
		chckLinfCO.setEnabled(false);
		chckLinfCO.setBounds(340, 278, 94, 23);
		frmLadiaExames.getContentPane().add(chckLinfCO);
		
		JLabel lblTricograma = new JLabel("Tricograma");
		lblTricograma.setForeground(Color.GRAY);
		lblTricograma.setBounds(12, 421, 94, 15);
		frmLadiaExames.getContentPane().add(lblTricograma);
		
		JLabel lblObsCO = new JLabel("Obs:");
		lblObsCO.setForeground(Color.GRAY);
		lblObsCO.setBounds(12, 363, 70, 15);
		frmLadiaExames.getContentPane().add(lblObsCO);
		
		tfObsCO = new JTextField();
		tfObsCO.setEnabled(false);
		tfObsCO.setBounds(56, 361, 172, 19);
		frmLadiaExames.getContentPane().add(tfObsCO);
		tfObsCO.setColumns(10);
		
		tfObsCP = new JTextField();
		tfObsCP.setEnabled(false);
		tfObsCP.setColumns(10);
		tfObsCP.setBounds(56, 159, 172, 19);
		frmLadiaExames.getContentPane().add(tfObsCP);
		
		JLabel lblObsCP = new JLabel("Obs:");
		lblObsCP.setForeground(Color.GRAY);
		lblObsCP.setBounds(12, 161, 70, 15);
		frmLadiaExames.getContentPane().add(lblObsCP);
		
		JRadioButton rdbtnNegativoTri = new JRadioButton("Negativo");
		rdbtnNegativoTri.setEnabled(false);
		rdbtnNegativoTri.setBounds(107, 417, 88, 23);
		frmLadiaExames.getContentPane().add(rdbtnNegativoTri);
		
		JRadioButton rdbtnPositivoTri = new JRadioButton("Positivo:");
		rdbtnPositivoTri.setEnabled(false);
		rdbtnPositivoTri.setBounds(200, 417, 88, 23);
		frmLadiaExames.getContentPane().add(rdbtnPositivoTri);
		
		JCheckBox chckbxEndothrix = new JCheckBox("Endothrix");
		chckbxEndothrix.setEnabled(false);
		chckbxEndothrix.setBounds(294, 417, 94, 23);
		frmLadiaExames.getContentPane().add(chckbxEndothrix);
		
		JCheckBox chckbxEctothrix = new JCheckBox("Ectothrix");
		chckbxEctothrix.setEnabled(false);
		chckbxEctothrix.setBounds(390, 417, 88, 23);
		frmLadiaExames.getContentPane().add(chckbxEctothrix);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(495, 460, 117, 25);
		frmLadiaExames.getContentPane().add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(358, 460, 117, 25);
		frmLadiaExames.getContentPane().add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(219, 460, 117, 25);
		frmLadiaExames.getContentPane().add(btnEditar);
	}
}
