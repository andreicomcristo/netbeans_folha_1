/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas2;

import java.io.Serializable;
import java.util.List;
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
    @NamedQuery(name = "TiposLogradouro.findAll", query = "SELECT t FROM TiposLogradouro t")})
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
    private List<Enderecos> enderecosList;
    @OneToMany(mappedBy = "idTipoLogradouroFk")
    private List<Unidades> unidadesList;

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

    public List<Enderecos> getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List<Enderecos> enderecosList) {
        this.enderecosList = enderecosList;
    }

    public List<Unidades> getUnidadesList() {
        return unidadesList;
    }

    public void setUnidadesList(List<Unidades> unidadesList) {
        this.unidadesList = unidadesList;
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
        return "br.com.folha.model.tabelas2.TiposLogradouro[ id=" + id + " ]";
    }
    
}
