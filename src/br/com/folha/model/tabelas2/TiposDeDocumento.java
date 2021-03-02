/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "tipos_de_documento")
@NamedQueries({
    @NamedQuery(name = "TiposDeDocumento.findAll", query = "SELECT t FROM TiposDeDocumento t")})
public class TiposDeDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "sigla_documento")
    private String siglaDocumento;
    @Column(name = "nome_documento")
    private String nomeDocumento;
    @OneToMany(mappedBy = "idTiposDeDocumentoFk")
    private List<PessoaDocumentos> pessoaDocumentosList;

    public TiposDeDocumento() {
    }

    public TiposDeDocumento(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiglaDocumento() {
        return siglaDocumento;
    }

    public void setSiglaDocumento(String siglaDocumento) {
        this.siglaDocumento = siglaDocumento;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    public List<PessoaDocumentos> getPessoaDocumentosList() {
        return pessoaDocumentosList;
    }

    public void setPessoaDocumentosList(List<PessoaDocumentos> pessoaDocumentosList) {
        this.pessoaDocumentosList = pessoaDocumentosList;
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
        if (!(object instanceof TiposDeDocumento)) {
            return false;
        }
        TiposDeDocumento other = (TiposDeDocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.TiposDeDocumento[ id=" + id + " ]";
    }
    
}
