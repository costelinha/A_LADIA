package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="CitologiaPele.pegarID", query="SELECT c FROM CitologiaPele c "
			+ "WHERE amostra_fk = :valor")
})
public class CitologiaPele extends Exame {

	private boolean ced;
	private boolean cen;
	private boolean neutrofilos;
	private boolean linfocitos;
	private boolean macrofagos;
	private boolean eosinofilos;
	private boolean cNeoplasicas;
	private String leveduras;
	private String bacterias;
	private String observacao;
	
	public boolean isCed() {
		return ced;
	}
	public void setCed(boolean ced) {
		this.ced = ced;
	}
	public boolean isCen() {
		return cen;
	}
	public void setCen(boolean cen) {
		this.cen = cen;
	}
	public boolean isNeutrofilos() {
		return neutrofilos;
	}
	public void setNeutrofilos(boolean neutrofilos) {
		this.neutrofilos = neutrofilos;
	}
	public boolean isLinfocitos() {
		return linfocitos;
	}
	public void setLinfocitos(boolean linfocitos) {
		this.linfocitos = linfocitos;
	}
	public boolean isMacrofagos() {
		return macrofagos;
	}
	public void setMacrofagos(boolean macrofagos) {
		this.macrofagos = macrofagos;
	}
	public boolean isEosinofilos() {
		return eosinofilos;
	}
	public void setEosinofilos(boolean eosinofilos) {
		this.eosinofilos = eosinofilos;
	}
	public boolean iscNeoplasicas() {
		return cNeoplasicas;
	}
	public void setcNeoplasicas(boolean cNeoplasicas) {
		this.cNeoplasicas = cNeoplasicas;
	}
	public String getLeveduras() {
		return leveduras;
	}
	public void setLeveduras(String leveduras) {
		this.leveduras = leveduras;
	}
	public String getBacterias() {
		return bacterias;
	}
	public void setBacterias(String bacterias) {
		this.bacterias = bacterias;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
