/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

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
@Table(name = "pessoa_documentos_habilitacao")
@NamedQueries({
    @NamedQuery(name = "PessoaDocumentosHabilitacao.findAll", query = "SELECT p FROM PessoaDocumentosHabilitacao p"),
    @NamedQuery(name = "PessoaDocumentosHabilitacao.findById", query = "SELECT p FROM PessoaDocumentosHabilitacao p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaDocumentosHabilitacao.findByNumeroRegistro", query = "SELECT p FROM PessoaDocumentosHabilitacao p WHERE p.numeroRegistro = :numeroRegistro"),
    @NamedQuery(name = "PessoaDocumentosHabilitacao.findByDtEmissao", query = "SELECT p FROM PessoaDocumentosHabilitacao p WHERE p.dtEmissao = :dtEmissao"),
    @NamedQuery(name = "PessoaDocumentosHabilitacao.findByDtValidade", query = "SELECT p FROM PessoaDocumentosHabilitacao p WHERE p.dtValidade = :dtValidade"),
    @NamedQuery(name = "PessoaDocumentosHabilitacao.findByDtPrimeiraHabilitacao", query = "SELECT p FROM PessoaDocumentosHabilitacao p WHERE p.dtPrimeiraHabilitacao = :dtPrimeiraHabilitacao")})
public class PessoaDocumentosHabilitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "numero_registro")
    private String numeroRegistro;
    @Column(name = "dt_emissao")
    @Temporal(TemporalType.DATE)
    private Date dtEmissao;
    @Column(name = "dt_validade")
    @Temporal(TemporalType.DATE)
    private Date dtValidade;
    @Column(name = "dt_primeira_habilitacao")
    @Temporal(TemporalType.DATE)
    private Date dtPrimeiraHabilitacao;
    @JoinColumn(name = "id_habilitacao_categorias_fk", referencedColumnName = "id")
    @ManyToOne
    private HabilitacaoCategorias idHabilitacaoCategoriasFk;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idPessoaFk;

    public PessoaDocumentosHabilitacao() {
    }

    public PessoaDocumentosHabilitacao(Long id) {
        this.id = id;
    }

    public PessoaDocumentosHabilitacao(Long id, String numeroRegistro) {
        this.id = id;
        this.numeroRegistro = numeroRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
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

    public Date getDtPrimeiraHabilitacao() {
        return dtPrimeiraHabilitacao;
    }

    public void setDtPrimeiraHabilitacao(Date dtPrimeiraHabilitacao) {
        this.dtPrimeiraHabilitacao = dtPrimeiraHabilitacao;
    }

    public HabilitacaoCategorias getIdHabilitacaoCategoriasFk() {
        return idHabilitacaoCategoriasFk;
    }

    public void setIdHabilitacaoCategoriasFk(HabilitacaoCategorias idHabilitacaoCategoriasFk) {
        this.idHabilitacaoCategoriasFk = idHabilitacaoCategoriasFk;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
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
        if (!(object instanceof PessoaDocumentosHabilitacao)) {
            return false;
        }
        PessoaDocumentosHabilitacao other = (PessoaDocumentosHabilitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.PessoaDocumentosHabilitacao[ id=" + id + " ]";
    }
    
}
