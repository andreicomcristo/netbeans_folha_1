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
@Table(name = "vinculos")
@NamedQueries({
    @NamedQuery(name = "Vinculos.findAll", query = "SELECT v FROM Vinculos v")})
public class Vinculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_vinculo")
    private String nomeVinculo;
    @Column(name = "descricao_vinculo")
    private String descricaoVinculo;
    @OneToMany(mappedBy = "idVinculoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVinculoFk")
    private List<HistFuncionariosVinculos> histFuncionariosVinculosList;
    @OneToMany(mappedBy = "idVinculoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;

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

    public List<FuncionariosLicencas> getFuncionariosLicencasList() {
        return funcionariosLicencasList;
    }

    public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
        this.funcionariosLicencasList = funcionariosLicencasList;
    }

    public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList() {
        return histFuncionariosVinculosList;
    }

    public void setHistFuncionariosVinculosList(List<HistFuncionariosVinculos> histFuncionariosVinculosList) {
        this.histFuncionariosVinculosList = histFuncionariosVinculosList;
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
        return "br.com.folha.model.tabelas2.Vinculos[ id=" + id + " ]";
    }
    
}
