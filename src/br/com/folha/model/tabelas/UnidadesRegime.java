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
@Table(name = "unidades_regime", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sigla_regime_unid_lotacao"})})
@NamedQueries({
    @NamedQuery(name = "UnidadesRegime.findAll", query = "SELECT u FROM UnidadesRegime u"),
    @NamedQuery(name = "UnidadesRegime.findById", query = "SELECT u FROM UnidadesRegime u WHERE u.id = :id"),
    @NamedQuery(name = "UnidadesRegime.findBySiglaRegimeUnidLotacao", query = "SELECT u FROM UnidadesRegime u WHERE u.siglaRegimeUnidLotacao = :siglaRegimeUnidLotacao"),
    @NamedQuery(name = "UnidadesRegime.findByNomeRegimeUnidLotacao", query = "SELECT u FROM UnidadesRegime u WHERE u.nomeRegimeUnidLotacao = :nomeRegimeUnidLotacao"),
    @NamedQuery(name = "UnidadesRegime.findByDescricaoRegimeUnidLotacao", query = "SELECT u FROM UnidadesRegime u WHERE u.descricaoRegimeUnidLotacao = :descricaoRegimeUnidLotacao")})
public class UnidadesRegime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "sigla_regime_unid_lotacao", nullable = false, length = 10)
    private String siglaRegimeUnidLotacao;
    @Basic(optional = false)
    @Column(name = "nome_regime_unid_lotacao", nullable = false, length = 150)
    private String nomeRegimeUnidLotacao;
    @Column(name = "descricao_regime_unid_lotacao", length = 300)
    private String descricaoRegimeUnidLotacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeRegimeFk")
    private Collection<HistUnidadesRegime> histUnidadesRegimeCollection;

    public UnidadesRegime() {
    }

    public UnidadesRegime(Long id) {
        this.id = id;
    }

    public UnidadesRegime(Long id, String siglaRegimeUnidLotacao, String nomeRegimeUnidLotacao) {
        this.id = id;
        this.siglaRegimeUnidLotacao = siglaRegimeUnidLotacao;
        this.nomeRegimeUnidLotacao = nomeRegimeUnidLotacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiglaRegimeUnidLotacao() {
        return siglaRegimeUnidLotacao;
    }

    public void setSiglaRegimeUnidLotacao(String siglaRegimeUnidLotacao) {
        this.siglaRegimeUnidLotacao = siglaRegimeUnidLotacao;
    }

    public String getNomeRegimeUnidLotacao() {
        return nomeRegimeUnidLotacao;
    }

    public void setNomeRegimeUnidLotacao(String nomeRegimeUnidLotacao) {
        this.nomeRegimeUnidLotacao = nomeRegimeUnidLotacao;
    }

    public String getDescricaoRegimeUnidLotacao() {
        return descricaoRegimeUnidLotacao;
    }

    public void setDescricaoRegimeUnidLotacao(String descricaoRegimeUnidLotacao) {
        this.descricaoRegimeUnidLotacao = descricaoRegimeUnidLotacao;
    }

    public Collection<HistUnidadesRegime> getHistUnidadesRegimeCollection() {
        return histUnidadesRegimeCollection;
    }

    public void setHistUnidadesRegimeCollection(Collection<HistUnidadesRegime> histUnidadesRegimeCollection) {
        this.histUnidadesRegimeCollection = histUnidadesRegimeCollection;
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
        if (!(object instanceof UnidadesRegime)) {
            return false;
        }
        UnidadesRegime other = (UnidadesRegime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.UnidadesRegime[ id=" + id + " ]";
    }
    
}
