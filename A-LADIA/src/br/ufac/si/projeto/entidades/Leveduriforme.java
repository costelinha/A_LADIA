package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
public class Leveduriforme extends IsolamentoFungico {

	private String cor;
	private String diametro;
	private boolean forma;
	private boolean clamidosporo;
	private boolean artrosporo;
	private String ascosporo;
	private boolean blastoconidioU;
	private boolean blastoconidioM;
	private boolean hifaVerdadeira;
	private boolean pseudoHifa;
	private boolean capsula;
	
	private boolean tuboGerminativo;
	private String provaUrease;
	private boolean testeNanquim;
	private String provaNiger;
	private String microcultivo;
	private String fermentacao;
	private String assimilacao;
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getDiametro() {
		return diametro;
	}
	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}
	public boolean isForma() {
		return forma;
	}
	public void setForma(boolean forma) {
		this.forma = forma;
	}
	public boolean isClamidosporo() {
		return clamidosporo;
	}
	public void setClamidosporo(boolean clamidosporo) {
		this.clamidosporo = clamidosporo;
	}
	public boolean isArtrosporo() {
		return artrosporo;
	}
	public void setArtrosporo(boolean artrosporo) {
		this.artrosporo = artrosporo;
	}
	public String getAscosporo() {
		return ascosporo;
	}
	public void setAscosporo(String ascosporo) {
		this.ascosporo = ascosporo;
	}
	public boolean isBlastoconidioU() {
		return blastoconidioU;
	}
	public void setBlastoconidioU(boolean blastoconidioU) {
		this.blastoconidioU = blastoconidioU;
	}
	public boolean isBlastoconidioM() {
		return blastoconidioM;
	}
	public void setBlastoconidioM(boolean blastoconidioM) {
		this.blastoconidioM = blastoconidioM;
	}
	public boolean isHifaVerdadeira() {
		return hifaVerdadeira;
	}
	public void setHifaVerdadeira(boolean hifaVerdadeira) {
		this.hifaVerdadeira = hifaVerdadeira;
	}
	public boolean isPseudoHifa() {
		return pseudoHifa;
	}
	public void setPseudoHifa(boolean pseudoHifa) {
		this.pseudoHifa = pseudoHifa;
	}
	public boolean isCapsula() {
		return capsula;
	}
	public void setCapsula(boolean capsula) {
		this.capsula = capsula;
	}
	public boolean isTuboGerminativo() {
		return tuboGerminativo;
	}
	public void setTuboGerminativo(boolean tuboGerminativo) {
		this.tuboGerminativo = tuboGerminativo;
	}
	public String getProvaUrease() {
		return provaUrease;
	}
	public void setProvaUrease(String provaUrease) {
		this.provaUrease = provaUrease;
	}
	public boolean isTesteNanquim() {
		return testeNanquim;
	}
	public void setTesteNanquim(boolean testeNanquim) {
		this.testeNanquim = testeNanquim;
	}
	public String getProvaNiger() {
		return provaNiger;
	}
	public void setProvaNiger(String provaNiger) {
		this.provaNiger = provaNiger;
	}
	public String getMicrocultivo() {
		return microcultivo;
	}
	public void setMicrocultivo(String microcultivo) {
		this.microcultivo = microcultivo;
	}
	public String getFermentacao() {
		return fermentacao;
	}
	public void setFermentacao(String fermentacao) {
		this.fermentacao = fermentacao;
	}
	public String getAssimilacao() {
		return assimilacao;
	}
	public void setAssimilacao(String assimilacao) {
		this.assimilacao = assimilacao;
	}
	
	
}
