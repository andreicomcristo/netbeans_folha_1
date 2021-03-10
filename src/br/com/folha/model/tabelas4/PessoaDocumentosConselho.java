/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "pessoa_documentos_conselho")
@NamedQueries({
    @NamedQuery(name = "PessoaDocumentosConselho.findAll", query = "SELECT p FROM PessoaDocumentosConselho p"),
    @NamedQuery(name = "PessoaDocumentosConselho.findById", query = "SELECT p FROM PessoaDocumentosConselho p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaDocumentosConselho.findByNumeroConselho", query = "SELECT p FROM PessoaDocumentosConselho p WHERE p.numeroConselho = :numeroConselho"),
    @NamedQuery(name = "PessoaDocumentosConselho.findByDtEmissao", query = "SELECT p FROM PessoaDocumentosConselho p WHERE p.dtEmissao = :dtEmissao"),
    @NamedQuery(name = "PessoaDocumentosConselho.findByDtValidade", query = "SELECT p FROM PessoaDocumentosConselho p WHERE p.dtValidade = :dtValidade")})
public class PessoaDocumentosConselho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "numero_conselho")
    private String numeroConselho;
    @Column(name = "dt_emissao")
    @Temporal(TemporalType.DATE)
    private Date dtEmissao;
    @Column(name = "dt_validade")
    @Temporal(TemporalType.DATE)
    private Date dtValidade;
    @JoinColumn(name = "id_conselhos_fk", referencedColumnName = "id")
    @ManyToOne
    private Conselhos idConselhosFk;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_uf_fk", referencedColumnName = "id")
    @ManyToOne
    private Uf idUfFk;

    public PessoaDocumentosConselho() {
    }

    public PessoaDocumentosConselho(Long id) {
        this.id = id;
    }

    public PessoaDocumentosConselho(Long id, String numeroConselho) {
        this.id = id;
        this.numeroConselho = numeroConselho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConselho() {
        return numeroConselho;
    }

    public void setNumeroConselho(String numeroConselho) {
        this.numeroConselho = numeroConselho;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public Date getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }

    public Conselhos getIdConselhosFk() {
        return idConselhosFk;
    }

    public void setIdConselhosFk(Conselhos idConselhosFk) {
        this.idConselhosFk = idConselhosFk;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    public Uf getIdUfFk() {
        return idUfFk;
    }

    public void setIdUfFk(Uf idUfFk) {
        this.idUfFk = idUfFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaDocumentosConselho)) {
            return false;
        }
        PessoaDocumentosConselho other = (PessoaDocumentosConselho) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.PessoaDocumentosConselho[ id=" + id + " ]";
    }
    
}
