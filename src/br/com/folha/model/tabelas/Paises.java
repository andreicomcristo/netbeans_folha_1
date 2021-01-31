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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "paises", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome_pais"})})
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findById", query = "SELECT p FROM Paises p WHERE p.id = :id"),
    @NamedQuery(name = "Paises.findByNomePais", query = "SELECT p FROM Paises p WHERE p.nomePais = :nomePais")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_pais", nullable = false, length = 300)
    private String nomePais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaisFk")
    private Collection<Cidades> cidadesCollection;

    public Paises() {
    }

    public Paises(Long id) {
        this.id = id;
    }

    public Paises(Long id, String nomePais) {
        this.id = id;
        this.nomePais = nomePais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public Collection<Cidades> getCidadesCollection() {
        return cidadesCollection;
    }

    public void setCidadesCollection(Collection<Cidades> cidadesCollection) {
        this.cidadesCollection = cidadesCollection;
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
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.Paises[ id=" + id + " ]";
    }
    
}
