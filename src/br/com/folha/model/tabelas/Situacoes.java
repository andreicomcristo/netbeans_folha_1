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
@Table(name = "situacoes")
@NamedQueries({
    @NamedQuery(name = "Situacoes.findAll", query = "SELECT s FROM Situacoes s"),
    @NamedQuery(name = "Situacoes.findById", query = "SELECT s FROM Situacoes s WHERE s.id = :id"),
    @NamedQuery(name = "Situacoes.findByNomeSituacao", query = "SELECT s FROM Situacoes s WHERE s.nomeSituacao = :nomeSituacao"),
    @NamedQuery(name = "Situacoes.findByDescricaoSituacao", query = "SELECT s FROM Situacoes s WHERE s.descricaoSituacao = :descricaoSituacao")})
public class Situacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_situacao", nullable = false, length = 300)
    private String nomeSituacao;
    @Column(name = "descricao_situacao", length = 300)
    private String descricaoSituacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacaoFk")
    private Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection;

    public Situacoes() {
    }

    public Situacoes(Long id) {
        this.id = id;
    }

    public Situacoes(Long id, String nomeSituacao) {
        this.id = id;
        this.nomeSituacao = nomeSituacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSituacao() {
        return nomeSituacao;
    }

    public void setNomeSituacao(String nomeSituacao) {
        this.nomeSituacao = nomeSituacao;
    }

    public String getDescricaoSituacao() {
        return descricaoSituacao;
    }

    public void setDescricaoSituacao(String descricaoSituacao) {
        this.descricaoSituacao = descricaoSituacao;
    }

    public Collection<HistFuncionariosSituacoes> getHistFuncionariosSituacoesCollection() {
        return histFuncionariosSituacoesCollection;
    }

    public void setHistFuncionariosSituacoesCollection(Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection) {
        this.histFuncionariosSituacoesCollection = histFuncionariosSituacoesCollection;
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
        if (!(object instanceof Situacoes)) {
            return false;
        }
        Situacoes other = (Situacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.Situacoes[ id=" + id + " ]";
    }
    
}
