/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "escolaridades")
@NamedQueries({
    @NamedQuery(name = "Escolaridades.findAll", query = "SELECT e FROM Escolaridades e"),
    @NamedQuery(name = "Escolaridades.findById", query = "SELECT e FROM Escolaridades e WHERE e.id = :id"),
    @NamedQuery(name = "Escolaridades.findByNomeEscolaridade", query = "SELECT e FROM Escolaridades e WHERE e.nomeEscolaridade = :nomeEscolaridade"),
    @NamedQuery(name = "Escolaridades.findByDescricaoEscolaridade", query = "SELECT e FROM Escolaridades e WHERE e.descricaoEscolaridade = :descricaoEscolaridade")})
public class Escolaridades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_escolaridade")
    private String nomeEscolaridade;
    @Column(name = "descricao_escolaridade")
    private String descricaoEscolaridade;
    @OneToMany(mappedBy = "idEscolaridadeFk")
    private List<Pessoa> pessoaList;

    public Escolaridades() {
    }

    public Escolaridades(Long id) {
        this.id = id;
    }

    public Escolaridades(Long id, String nomeEscolaridade) {
        this.id = id;
        this.nomeEscolaridade = nomeEscolaridade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEscolaridade() {
        return nomeEscolaridade;
    }

    public void setNomeEscolaridade(String nomeEscolaridade) {
        this.nomeEscolaridade = nomeEscolaridade;
    }

    public String getDescricaoEscolaridade() {
        return descricaoEscolaridade;
    }

    public void setDescricaoEscolaridade(String descricaoEscolaridade) {
        this.descricaoEscolaridade = descricaoEscolaridade;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
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
        if (!(object instanceof Escolaridades)) {
            return false;
        }
        Escolaridades other = (Escolaridades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.Escolaridades[ id=" + id + " ]";
    }
    
}
