package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
public class Filamentoso extends IsolamentoFungico {

	private String corVerso;
	private String corReverso;
	private boolean hifa;
	private boolean porangio;
	private boolean clamidoconidio;
	private boolean artroconidio;
	private boolean basidiosporo;
	private String macroconidio;
	private String microconidio;
	
	public String getCorVerso() {
		return corVerso;
	}
	public void setCorVerso(String corVerso) {
		this.corVerso = corVerso;
	}
	public String getCorReverso() {
		return corReverso;
	}
	public void setCorReverso(String corReverso) {
		this.corReverso = corReverso;
	}
	public boolean isHifa() {
		return hifa;
	}
	public void setHifa(boolean hifa) {
		this.hifa = hifa;
	}
	public boolean isPorangio() {
		return porangio;
	}
	public void setPorangio(boolean porangio) {
		this.porangio = porangio;
	}
	public boolean isClamidoconidio() {
		return clamidoconidio;
	}
	public void setClamidoconidio(boolean clamidoconidio) {
		this.clamidoconidio = clamidoconidio;
	}
	public boolean isArtroconidio() {
		return artroconidio;
	}
	public void setArtroconidio(boolean artroconidio) {
		this.artroconidio = artroconidio;
	}
	public boolean isBasidiosporo() {
		return basidiosporo;
	}
	public void setBasidiosporo(boolean basidiosporo) {
		this.basidiosporo = basidiosporo;
	}
	public String getMacroconidio() {
		return macroconidio;
	}
	public void setMacroconidio(String macroconidio) {
		this.macroconidio = macroconidio;
	}
	public String getMicroconidio() {
		return microconidio;
	}
	public void setMicroconidio(String microconidio) {
		this.microconidio = microconidio;
	}
	
	
}
