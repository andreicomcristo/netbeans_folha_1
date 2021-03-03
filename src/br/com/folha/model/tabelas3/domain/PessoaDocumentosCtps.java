package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_ctps")
public class PessoaDocumentosCtps extends AbstractEntity<Long> {

	@Column(name = "numero", nullable = false, length = 100)
	private String numero;

	@Column(name = "serie", length = 100)
	private String serie;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(numero);
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(serie);
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

}
