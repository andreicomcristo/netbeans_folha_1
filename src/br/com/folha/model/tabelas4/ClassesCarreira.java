/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

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
@Table(name = "classes_carreira")
@NamedQueries({
    @NamedQuery(name = "ClassesCarreira.findAll", query = "SELECT c FROM ClassesCarreira c"),
    @NamedQuery(name = "ClassesCarreira.findById", query = "SELECT c FROM ClassesCarreira c WHERE c.id = :id"),
    @NamedQuery(name = "ClassesCarreira.findBySiglaClasse", query = "SELECT c FROM ClassesCarreira c WHERE c.siglaClasse = :siglaClasse"),
    @NamedQuery(name = "ClassesCarreira.findByNomeClasse", query = "SELECT c FROM ClassesCarreira c WHERE c.nomeClasse = :nomeClasse"),
    @NamedQuery(name = "ClassesCarreira.findByDescricaoClasse", query = "SELECT c FROM ClassesCarreira c WHERE c.descricaoClasse = :descricaoClasse")})
public class ClassesCarreira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "sigla_classe")
    private String siglaClasse;
    @Basic(optional = false)
    @Column(name = "nome_classe")
    private String nomeClasse;
    @Column(name = "descricao_classe")
    private String descricaoClasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasseFk")
    private List<HistFuncionariosClasse> histFuncionariosClasseList;
    @OneToMany(mappedBy = "idClasseCarreiraAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;

    public ClassesCarreira() {
    }

    public ClassesCarreira(Long id) {
        this.id = id;
    }

    public ClassesCarreira(Long id, String siglaClasse, String nomeClasse) {
        this.id = id;
        this.siglaClasse = siglaClasse;
        this.nomeClasse = nomeClasse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiglaClasse() {
        return siglaClasse;
    }

    public void setSiglaClasse(String siglaClasse) {
        this.siglaClasse = siglaClasse;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public String getDescricaoClasse() {
        return descricaoClasse;
    }

    public void setDescricaoClasse(String descricaoClasse) {
        this.descricaoClasse = descricaoClasse;
    }

    public List<HistFuncionariosClasse> getHistFuncionariosClasseList() {
        return histFuncionariosClasseList;
    }

    public void setHistFuncionariosClasseList(List<HistFuncionariosClasse> histFuncionariosClasseList) {
        this.histFuncionariosClasseList = histFuncionariosClasseList;
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
        if (!(object instanceof ClassesCarreira)) {
            return false;
        }
        ClassesCarreira other = (ClassesCarreira) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.ClassesCarreira[ id=" + id + " ]";
    }
    
}
