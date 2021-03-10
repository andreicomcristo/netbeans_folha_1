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
@Table(name = "niveis_carreira")
@NamedQueries({
    @NamedQuery(name = "NiveisCarreira.findAll", query = "SELECT n FROM NiveisCarreira n"),
    @NamedQuery(name = "NiveisCarreira.findById", query = "SELECT n FROM NiveisCarreira n WHERE n.id = :id"),
    @NamedQuery(name = "NiveisCarreira.findByNomeNivelCarreira", query = "SELECT n FROM NiveisCarreira n WHERE n.nomeNivelCarreira = :nomeNivelCarreira"),
    @NamedQuery(name = "NiveisCarreira.findByDescricaoNivelCarreira", query = "SELECT n FROM NiveisCarreira n WHERE n.descricaoNivelCarreira = :descricaoNivelCarreira")})
public class NiveisCarreira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_nivel_carreira")
    private String nomeNivelCarreira;
    @Column(name = "descricao_nivel_carreira")
    private String descricaoNivelCarreira;
    @OneToMany(mappedBy = "idNivelCarreiraFk")
    private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList;
    @OneToMany(mappedBy = "idNivelCarreiraAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;

    public NiveisCarreira() {
    }

    public NiveisCarreira(Long id) {
        this.id = id;
    }

    public NiveisCarreira(Long id, String nomeNivelCarreira) {
        this.id = id;
        this.nomeNivelCarreira = nomeNivelCarreira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeNivelCarreira() {
        return nomeNivelCarreira;
    }

    public void setNomeNivelCarreira(String nomeNivelCarreira) {
        this.nomeNivelCarreira = nomeNivelCarreira;
    }

    public String getDescricaoNivelCarreira() {
        return descricaoNivelCarreira;
    }

    public void setDescricaoNivelCarreira(String descricaoNivelCarreira) {
        this.descricaoNivelCarreira = descricaoNivelCarreira;
    }

    public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiraList() {
        return histFuncionariosNiveisCarreiraList;
    }

    public void setHistFuncionariosNiveisCarreiraList(List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList) {
        this.histFuncionariosNiveisCarreiraList = histFuncionariosNiveisCarreiraList;
    }

    public List<PessoaFuncionarios> getPessoaFuncionariosList() {
        return pessoaFuncionariosList;
    }

    public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
        this.pessoaFuncionariosList = pessoaFuncionariosList;
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
        if (!(object instanceof NiveisCarreira)) {
            return false;
        }
        NiveisCarreira other = (NiveisCarreira) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.NiveisCarreira[ id=" + id + " ]";
    }
    
}
