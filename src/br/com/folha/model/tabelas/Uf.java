/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "uf")
@NamedQueries({
    @NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u"),
    @NamedQuery(name = "Uf.findById", query = "SELECT u FROM Uf u WHERE u.id = :id"),
    @NamedQuery(name = "Uf.findBySiglaUf", query = "SELECT u FROM Uf u WHERE u.siglaUf = :siglaUf"),
    @NamedQuery(name = "Uf.findByNomeUf", query = "SELECT u FROM Uf u WHERE u.nomeUf = :nomeUf")})
public class Uf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "sigla_uf", nullable = false, length = 300)
    private String siglaUf;
    @Basic(optional = false)
    @Column(name = "nome_uf", nullable = false, length = 300)
    private String nomeUf;
    @OneToMany(mappedBy = "idUfFk")
    private Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUfFk")
    private Collection<Cidades> cidadesCollection;
    @OneToMany(mappedBy = "idUfEmissao")
    private Collection<PessoaDocumentosRg> pessoaDocumentosRgCollection;

    public Uf() {
    }

    public Uf(Long id) {
        this.id = id;
    }

    public Uf(Long id, String siglaUf, String nomeUf) {
        this.id = id;
        this.siglaUf = siglaUf;
        this.nomeUf = nomeUf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public String getNomeUf() {
        return nomeUf;
    }

    public void setNomeUf(String nomeUf) {
        this.nomeUf = nomeUf;
    }

    public Collection<PessoaDocumentosConselho> getPessoaDocumentosConselhoCollection() {
        return pessoaDocumentosConselhoCollection;
    }

    public void setPessoaDocumentosConselhoCollection(Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection) {
        this.pessoaDocumentosConselhoCollection = pessoaDocumentosConselhoCollection;
    }

    public Collection<Cidades> getCidadesCollection() {
        return cidadesCollection;
    }

    public void setCidadesCollection(Collection<Cidades> cidadesCollection) {
        this.cidadesCollection = cidadesCollection;
    }

    public Collection<PessoaDocumentosRg> getPessoaDocumentosRgCollection() {
        return pessoaDocumentosRgCollection;
    }

    public void setPessoaDocumentosRgCollection(Collection<PessoaDocumentosRg> pessoaDocumentosRgCollection) {
        this.pessoaDocumentosRgCollection = pessoaDocumentosRgCollection;
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
        if (!(object instanceof Uf)) {
            return false;
        }
        Uf other = (Uf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.Uf[ id=" + id + " ]";
    }
    
}
