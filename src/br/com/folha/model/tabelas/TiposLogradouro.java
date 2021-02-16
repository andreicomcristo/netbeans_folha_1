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
@Table(name = "tipos_logradouro")
@NamedQueries({
    @NamedQuery(name = "TiposLogradouro.findAll", query = "SELECT t FROM TiposLogradouro t"),
    @NamedQuery(name = "TiposLogradouro.findById", query = "SELECT t FROM TiposLogradouro t WHERE t.id = :id"),
    @NamedQuery(name = "TiposLogradouro.findByNomeTipoLogradouro", query = "SELECT t FROM TiposLogradouro t WHERE t.nomeTipoLogradouro = :nomeTipoLogradouro"),
    @NamedQuery(name = "TiposLogradouro.findByDescricaoTipoLogradouro", query = "SELECT t FROM TiposLogradouro t WHERE t.descricaoTipoLogradouro = :descricaoTipoLogradouro")})
public class TiposLogradouro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_tipo_logradouro")
    private String nomeTipoLogradouro;
    @Column(name = "descricao_tipo_logradouro")
    private String descricaoTipoLogradouro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLogradouroFk")
    private Collection<Enderecos> enderecosCollection;
    @OneToMany(mappedBy = "idTipoLogradouroFk")
    private Collection<Unidades> unidadesCollection;

    public TiposLogradouro() {
    }

    public TiposLogradouro(Long id) {
        this.id = id;
    }

    public TiposLogradouro(Long id, String nomeTipoLogradouro) {
        this.id = id;
        this.nomeTipoLogradouro = nomeTipoLogradouro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTipoLogradouro() {
        return nomeTipoLogradouro;
    }

    public void setNomeTipoLogradouro(String nomeTipoLogradouro) {
        this.nomeTipoLogradouro = nomeTipoLogradouro;
    }

    public String getDescricaoTipoLogradouro() {
        return descricaoTipoLogradouro;
    }

    public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
        this.descricaoTipoLogradouro = descricaoTipoLogradouro;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposLogradouro)) {
            return false;
        }
        TiposLogradouro other = (TiposLogradouro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.TiposLogradouro[ id=" + id + " ]";
    }
    
}
