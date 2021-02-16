/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "cidades")
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c"),
    @NamedQuery(name = "Cidades.findById", query = "SELECT c FROM Cidades c WHERE c.id = :id"),
    @NamedQuery(name = "Cidades.findByNomeCidade", query = "SELECT c FROM Cidades c WHERE c.nomeCidade = :nomeCidade")})
public class Cidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_cidade")
    private String nomeCidade;
    @JoinColumn(name = "id_pais_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paises idPaisFk;
    @JoinColumn(name = "id_uf_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Uf idUfFk;
    @OneToMany(mappedBy = "idEnderecoCidadeFk")
    private Collection<Enderecos> enderecosCollection;
    @OneToMany(mappedBy = "idEnderecoCidadeFk")
    private Collection<Unidades> unidadesCollection;
    @OneToMany(mappedBy = "seqCidadeNatal")
    private Collection<Pessoa> pessoaCollection;
    @OneToMany(mappedBy = "idCidadeFk")
    private Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection;

    public Cidades() {
    }

    public Cidades(Long id) {
        this.id = id;
    }

    public Cidades(Long id, String nomeCidade) {
        this.id = id;
        this.nomeCidade = nomeCidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Paises getIdPaisFk() {
        return idPaisFk;
    }

    public void setIdPaisFk(Paises idPaisFk) {
        this.idPaisFk = idPaisFk;
    }

    public Uf getIdUfFk() {
        return idUfFk;
    }

    public void setIdUfFk(Uf idUfFk) {
        this.idUfFk = idUfFk;
    }

    public Collection<Enderecos> getEnderecosCollection() {
        return enderecosCollection;
    }

    public void setEnderecosCollection(Collection<Enderecos> enderecosCollection) {
        this.enderecosCollection = enderecosCollection;
    }

    public Collection<Unidades> getUnidadesCollection() {
        return unidadesCollection;
    }

    public void setUnidadesCollection(Collection<Unidades> unidadesCollection) {
        this.unidadesCollection = unidadesCollection;
    }

    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    public Collection<PessoaDocumentosTitulo> getPessoaDocumentosTituloCollection() {
        return pessoaDocumentosTituloCollection;
    }

    public void setPessoaDocumentosTituloCollection(Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection) {
        this.pessoaDocumentosTituloCollection = pessoaDocumentosTituloCollection;
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
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.Cidades[ id=" + id + " ]";
    }
    
}
