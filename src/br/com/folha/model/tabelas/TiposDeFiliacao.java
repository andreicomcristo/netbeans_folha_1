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
@Table(name = "tipos_de_filiacao")
@NamedQueries({
    @NamedQuery(name = "TiposDeFiliacao.findAll", query = "SELECT t FROM TiposDeFiliacao t"),
    @NamedQuery(name = "TiposDeFiliacao.findById", query = "SELECT t FROM TiposDeFiliacao t WHERE t.id = :id"),
    @NamedQuery(name = "TiposDeFiliacao.findByNomeTipoFiliacao", query = "SELECT t FROM TiposDeFiliacao t WHERE t.nomeTipoFiliacao = :nomeTipoFiliacao"),
    @NamedQuery(name = "TiposDeFiliacao.findByDescricaoTipoFiliacao", query = "SELECT t FROM TiposDeFiliacao t WHERE t.descricaoTipoFiliacao = :descricaoTipoFiliacao")})
public class TiposDeFiliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_tipo_filiacao")
    private String nomeTipoFiliacao;
    @Column(name = "descricao_tipo_filiacao")
    private String descricaoTipoFiliacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFiliacaoFk")
    private Collection<PessoaFilhos> pessoaFilhosCollection;

    public TiposDeFiliacao() {
    }

    public TiposDeFiliacao(Long id) {
        this.id = id;
    }

    public TiposDeFiliacao(Long id, String nomeTipoFiliacao) {
        this.id = id;
        this.nomeTipoFiliacao = nomeTipoFiliacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTipoFiliacao() {
        return nomeTipoFiliacao;
    }

    public void setNomeTipoFiliacao(String nomeTipoFiliacao) {
        this.nomeTipoFiliacao = nomeTipoFiliacao;
    }

    public String getDescricaoTipoFiliacao() {
        return descricaoTipoFiliacao;
    }

    public void setDescricaoTipoFiliacao(String descricaoTipoFiliacao) {
        this.descricaoTipoFiliacao = descricaoTipoFiliacao;
    }

    public Collection<PessoaFilhos> getPessoaFilhosCollection() {
        return pessoaFilhosCollection;
    }

    public void setPessoaFilhosCollection(Collection<PessoaFilhos> pessoaFilhosCollection) {
        this.pessoaFilhosCollection = pessoaFilhosCollection;
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
        if (!(object instanceof TiposDeFiliacao)) {
            return false;
        }
        TiposDeFiliacao other = (TiposDeFiliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.TiposDeFiliacao[ id=" + id + " ]";
    }
    
}
