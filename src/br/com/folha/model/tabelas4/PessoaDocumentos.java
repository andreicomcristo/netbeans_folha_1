/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

import java.io.Serializable;
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

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "pessoa_documentos")
@NamedQueries({
    @NamedQuery(name = "PessoaDocumentos.findAll", query = "SELECT p FROM PessoaDocumentos p"),
    @NamedQuery(name = "PessoaDocumentos.findById", query = "SELECT p FROM PessoaDocumentos p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaDocumentos.findByNumeroDocumento", query = "SELECT p FROM PessoaDocumentos p WHERE p.numeroDocumento = :numeroDocumento")})
public class PessoaDocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_tipos_de_documento_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeDocumento idTiposDeDocumentoFk;

    public PessoaDocumentos() {
    }

    public PessoaDocumentos(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    public TiposDeDocumento getIdTiposDeDocumentoFk() {
        return idTiposDeDocumentoFk;
    }

    public void setIdTiposDeDocumentoFk(TiposDeDocumento idTiposDeDocumentoFk) {
        this.idTiposDeDocumentoFk = idTiposDeDocumentoFk;
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
        if (!(object instanceof PessoaDocumentos)) {
            return false;
        }
        PessoaDocumentos other = (PessoaDocumentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.PessoaDocumentos[ id=" + id + " ]";
    }
    
}
