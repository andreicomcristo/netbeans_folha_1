/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

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
@Table(name = "pessoa_documentos_rg")
@NamedQueries({
    @NamedQuery(name = "PessoaDocumentosRg.findAll", query = "SELECT p FROM PessoaDocumentosRg p"),
    @NamedQuery(name = "PessoaDocumentosRg.findById", query = "SELECT p FROM PessoaDocumentosRg p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaDocumentosRg.findByRgNumero", query = "SELECT p FROM PessoaDocumentosRg p WHERE p.rgNumero = :rgNumero"),
    @NamedQuery(name = "PessoaDocumentosRg.findByRgOrgaoEmissor", query = "SELECT p FROM PessoaDocumentosRg p WHERE p.rgOrgaoEmissor = :rgOrgaoEmissor"),
    @NamedQuery(name = "PessoaDocumentosRg.findByDtEmissao", query = "SELECT p FROM PessoaDocumentosRg p WHERE p.dtEmissao = :dtEmissao"),
    @NamedQuery(name = "PessoaDocumentosRg.findByIdPessoaFk", query = "SELECT p FROM PessoaDocumentosRg p WHERE p.idPessoaFk = :idPessoaFk")})
public class PessoaDocumentosRg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "rg_numero", nullable = false, length = 100)
    private String rgNumero;
    @Column(name = "rg_orgao_emissor", length = 100)
    private String rgOrgaoEmissor;
    @Column(name = "dt_emissao")
    @Temporal(TemporalType.DATE)
    private Date dtEmissao;
    @Basic(optional = false)
    @Column(name = "id_pessoa_fk", nullable = false)
    private long idPessoaFk;
    @JoinColumn(name = "id_uf_emissao", referencedColumnName = "id")
    @ManyToOne
    private Uf idUfEmissao;

    public PessoaDocumentosRg() {
    }

    public PessoaDocumentosRg(Long id) {
        this.id = id;
    }

    public PessoaDocumentosRg(Long id, String rgNumero, long idPessoaFk) {
        this.id = id;
        this.rgNumero = rgNumero;
        this.idPessoaFk = idPessoaFk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRgNumero() {
        return rgNumero;
    }

    public void setRgNumero(String rgNumero) {
        this.rgNumero = rgNumero;
    }

    public String getRgOrgaoEmissor() {
        return rgOrgaoEmissor;
    }

    public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
        this.rgOrgaoEmissor = rgOrgaoEmissor;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public long getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(long idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    public Uf getIdUfEmissao() {
        return idUfEmissao;
    }

    public void setIdUfEmissao(Uf idUfEmissao) {
        this.idUfEmissao = idUfEmissao;
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
        if (!(object instanceof PessoaDocumentosRg)) {
            return false;
        }
        PessoaDocumentosRg other = (PessoaDocumentosRg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.PessoaDocumentosRg[ id=" + id + " ]";
    }
    
}
