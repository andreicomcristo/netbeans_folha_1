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
@Table(name = "carreiras")
@NamedQueries({
    @NamedQuery(name = "Carreiras.findAll", query = "SELECT c FROM Carreiras c")})
public class Carreiras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "sigla_carreira")
    private String siglaCarreira;
    @Basic(optional = false)
    @Column(name = "nome_carreira")
    private String nomeCarreira;
    @Column(name = "descricao_carreira")
    private String descricaoCarreira;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarreiraFk")
    private List<HistFuncionariosCarreira> histFuncionariosCarreiraList;
    @OneToMany(mappedBy = "idCarreiraAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;

    public Carreiras() {
    }

    public Carreiras(Long id) {
        this.id = id;
    }

    public Carreiras(Long id, String siglaCarreira, String nomeCarreira) {
        this.id = id;
        this.siglaCarreira = siglaCarreira;
        this.nomeCarreira = nomeCarreira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiglaCarreira() {
        return siglaCarreira;
    }

    public void setSiglaCarreira(String siglaCarreira) {
        this.siglaCarreira = siglaCarreira;
    }

    public String getNomeCarreira() {
        return nomeCarreira;
    }

    public void setNomeCarreira(String nomeCarreira) {
        this.nomeCarreira = nomeCarreira;
    }

    public String getDescricaoCarreira() {
        return descricaoCarreira;
    }

    public void setDescricaoCarreira(String descricaoCarreira) {
        this.descricaoCarreira = descricaoCarreira;
    }

    public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraList() {
        return histFuncionariosCarreiraList;
    }

    public void setHistFuncionariosCarreiraList(List<HistFuncionariosCarreira> histFuncionariosCarreiraList) {
        this.histFuncionariosCarreiraList = histFuncionariosCarreiraList;
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
        if (!(object instanceof Carreiras)) {
            return false;
        }
        Carreiras other = (Carreiras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.Carreiras[ id=" + id + " ]";
    }
    
}
