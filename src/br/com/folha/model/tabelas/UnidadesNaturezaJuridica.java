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
@Table(name = "unidades_natureza_juridica")
@NamedQueries({
    @NamedQuery(name = "UnidadesNaturezaJuridica.findAll", query = "SELECT u FROM UnidadesNaturezaJuridica u"),
    @NamedQuery(name = "UnidadesNaturezaJuridica.findById", query = "SELECT u FROM UnidadesNaturezaJuridica u WHERE u.id = :id"),
    @NamedQuery(name = "UnidadesNaturezaJuridica.findByNomeNaturezaJuridica", query = "SELECT u FROM UnidadesNaturezaJuridica u WHERE u.nomeNaturezaJuridica = :nomeNaturezaJuridica"),
    @NamedQuery(name = "UnidadesNaturezaJuridica.findByDescricaoNaturezaJuridica", query = "SELECT u FROM UnidadesNaturezaJuridica u WHERE u.descricaoNaturezaJuridica = :descricaoNaturezaJuridica")})
public class UnidadesNaturezaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_natureza_juridica")
    private String nomeNaturezaJuridica;
    @Column(name = "descricao_natureza_juridica")
    private String descricaoNaturezaJuridica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeDeSaudeFk")
    private Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection;

    public UnidadesNaturezaJuridica() {
    }

    public UnidadesNaturezaJuridica(Long id) {
        this.id = id;
    }

    public UnidadesNaturezaJuridica(Long id, String nomeNaturezaJuridica) {
        this.id = id;
        this.nomeNaturezaJuridica = nomeNaturezaJuridica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeNaturezaJuridica() {
        return nomeNaturezaJuridica;
    }

    public void setNomeNaturezaJuridica(String nomeNaturezaJuridica) {
        this.nomeNaturezaJuridica = nomeNaturezaJuridica;
    }

    public String getDescricaoNaturezaJuridica() {
        return descricaoNaturezaJuridica;
    }

    public void setDescricaoNaturezaJuridica(String descricaoNaturezaJuridica) {
        this.descricaoNaturezaJuridica = descricaoNaturezaJuridica;
    }

    public Collection<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaCollection() {
        return histUnidadesNaturezaJuridicaCollection;
    }

    public void setHistUnidadesNaturezaJuridicaCollection(Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection) {
        this.histUnidadesNaturezaJuridicaCollection = histUnidadesNaturezaJuridicaCollection;
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
        if (!(object instanceof UnidadesNaturezaJuridica)) {
            return false;
        }
        UnidadesNaturezaJuridica other = (UnidadesNaturezaJuridica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.UnidadesNaturezaJuridica[ id=" + id + " ]";
    }
    
}
