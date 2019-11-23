package br.ufac.si.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.CitologiaOuvido;
import br.ufac.si.projeto.entidades.CitologiaPele;
import br.ufac.si.projeto.entidades.Exame;
import br.ufac.si.projeto.entidades.ParasitologiaOuvido;
import br.ufac.si.projeto.entidades.ParasitologiaPele;
import br.ufac.si.projeto.entidades.Tricograma;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.CitologiaPeleGerente;
import br.ufac.si.projeto.gerentes.ExameGerente;
import br.ufac.si.projeto.gerentes.ParasitologiaOuvidoGerente;
import br.ufac.si.projeto.gerentes.ParasitologiaPeleGerente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExameVisualizacao {

	private JFrame frame;
	private Amostra amostra;
	private Exame exame;
	private ParasitologiaPele parasitP;
	private ParasitologiaOuvido parasitO;
	private CitologiaPele citolP;
	private CitologiaOuvido citolO;
	private Tricograma tri;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExameVisualizacao window = new TelaExameVisualizacao();
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
	public TelaExameVisualizacao(Amostra amostra) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JLabel lblParasitPele = new JLabel("Parasit. Pele");
		lblParasitPele.setBounds(12, 12, 105, 15);
		frame.getContentPane().add(lblParasitPele);
		
		JLabel lblParasitOuvido = new JLabel("Parasit. Ouvido");
		lblParasitOuvido.setBounds(12, 39, 125, 15);
		frame.getContentPane().add(lblParasitOuvido);
		
		JLabel lblCitolPele = new JLabel("Citol. Pele");
		lblCitolPele.setBounds(12, 66, 89, 15);
		frame.getContentPane().add(lblCitolPele);
		
		JLabel lblCitolOuvido = new JLabel("Citol. Ouvido");
		lblCitolOuvido.setBounds(12, 127, 105, 15);
		frame.getContentPane().add(lblCitolOuvido);
		
		JLabel lblTricograma = new JLabel("Tricograma");
		lblTricograma.setBounds(12, 188, 89, 15);
		frame.getContentPane().add(lblTricograma);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAmostraGerenciamento tag = new TelaAmostraGerenciamento();
				frame.dispose();
			}
		});
		btnVoltar.setBounds(321, 232, 117, 25);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(192, 232, 117, 25);
		frame.getContentPane().add(btnEditar);
		
		ExameGerente eg = new ExameGerente();
		AmostraGerente ag = new AmostraGerente();
		JLabel lblPP;
		JLabel lblPO;
		JLabel lblCEDCP;
		JLabel lblCENCP;
		JLabel lblNeutroCP;
		JLabel lblMacroCP;
		JLabel lblEosCP;
		JLabel lblNeoCP;
		JLabel lblLeveCP;
		JLabel lblBacCP;
		JLabel lblObsCP;
		if(amostra.getExames()[0]) {
			ParasitologiaPeleGerente ppg = new ParasitologiaPeleGerente();
			ParasitologiaPele pp = new ParasitologiaPele();
		/*	if(ppg.recuperar(pp.getId()).isResultado()) {
				lblPP = new JLabel("Positivo");
			}else {
				lblPP = new JLabel("Negativo");
			}
			lblPP.setBounds(157, 12, 70, 15);
			frame.getContentPane().add(lblPP);
		}else {
			lblPP = new JLabel("Não solicitado");
			lblPP.setBounds(157, 12, 70, 15);
			frame.getContentPane().add(lblPP);
		}
		if(amostra.getExames()[1]) {
			ParasitologiaOuvidoGerente pog = new ParasitologiaOuvidoGerente();
			ParasitologiaOuvido po = new ParasitologiaOuvido();
			if(pog.recuperar(po.getId()).isResultado()) {
				lblPO = new JLabel("Positivo");
			}else {
				lblPO = new JLabel("Negativo");
			}
			lblPO.setBounds(157, 12, 70, 15);
			frame.getContentPane().add(lblPO);
		}else {
			lblPO = new JLabel("Não solicitado");
			lblPO.setBounds(157, 12, 70, 15);
			frame.getContentPane().add(lblPO);
		}
		if(amostra.getExames()[2]) {
			CitologiaPeleGerente cpg = new CitologiaPeleGerente();
			CitologiaPele cp = new CitologiaPele();
			if(cpg.recuperar(cp.getId()).isCed()) {
				lblCEDCP = new JLabel("CED");
			}
			if(cpg.recuperar(cp.getId()).isCen()) {
				lblCENCP = new JLabel("CEN");
			}
			if(cpg.recuperar(cp.getId()).isNeutrofilos()) {
				lblNeutroCP = new JLabel("Neutrófilos");
			}
			if(cpg.recuperar(cp.getId()).isMacrofagos()) {
				lblMacroCP = new JLabel("Macrófagos");
			}
			if(cpg.recuperar(cp.getId()).isEosinofilos()) {
				lblEosCP = new JLabel("Eosinófilos");
			}
			if(cpg.recuperar(cp.getId()).iscNeoplasicas()) {
				lblNeoCP = new JLabel("Neoplásicas");
			}
			if(cpg.recuperar(cp.getId()).getLeveduras()!=null) {
				lblLeveCP = new JLabel("Leveduras "+cpg.recuperar(cp.getId()).getLeveduras());
			}
			if(cpg.recuperar(cp.getId()).getBacterias()!=null) {
				lblBacCP = new JLabel("Bacterias "+cpg.recuperar(cp.getId()).getBacterias());
			}
			lblObsCP = new JLabel("Observações "+cpg.recuperar(cp.getId()).getObservacao());
			
			lblPP.setBounds(157, 12, 70, 15);
			frame.getContentPane().add(lblPP);
		}else {
			lblPP = new JLabel("Não solicitado");
			lblPP.setBounds(157, 12, 70, 15);
			frame.getContentPane().add(lblPP);*/
		}
	}
}
