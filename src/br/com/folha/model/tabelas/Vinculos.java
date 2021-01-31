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
@Table(name = "vinculos", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome_vinculo"})})
@NamedQueries({
    @NamedQuery(name = "Vinculos.findAll", query = "SELECT v FROM Vinculos v"),
    @NamedQuery(name = "Vinculos.findById", query = "SELECT v FROM Vinculos v WHERE v.id = :id"),
    @NamedQuery(name = "Vinculos.findByNomeVinculo", query = "SELECT v FROM Vinculos v WHERE v.nomeVinculo = :nomeVinculo"),
    @NamedQuery(name = "Vinculos.findByDescricaoVinculo", query = "SELECT v FROM Vinculos v WHERE v.descricaoVinculo = :descricaoVinculo")})
public class Vinculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_vinculo", nullable = false, length = 100)
    private String nomeVinculo;
    @Column(name = "descricao_vinculo", length = 300)
    private String descricaoVinculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVinculoFk")
    private Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection;

    public Vinculos() {
    }

    public Vinculos(Long id) {
        this.id = id;
    }

    public Vinculos(Long id, String nomeVinculo) {
        this.id = id;
        this.nomeVinculo = nomeVinculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVinculo() {
        return nomeVinculo;
    }

    public void setNomeVinculo(String nomeVinculo) {
        this.nomeVinculo = nomeVinculo;
    }

    public String getDescricaoVinculo() {
        return descricaoVinculo;
    }

    public void setDescricaoVinculo(String descricaoVinculo) {
        this.descricaoVinculo = descricaoVinculo;
    }

    public Collection<HistFuncionariosVinculos> getHistFuncionariosVinculosCollection() {
        return histFuncionariosVinculosCollection;
    }

    public void setHistFuncionariosVinculosCollection(Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection) {
        this.histFuncionariosVinculosCollection = histFuncionariosVinculosCollection;
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
        if (!(object instanceof Vinculos)) {
            return false;
        }
        Vinculos other = (Vinculos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.Vinculos[ id=" + id + " ]";
    }
    
}
