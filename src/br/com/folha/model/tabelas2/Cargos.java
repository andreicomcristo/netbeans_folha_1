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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "cargos")
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c")})
public class Cargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome_cargo")
    private String nomeCargo;
    @Column(name = "descricao_cargo")
    private String descricaoCargo;
    @OneToMany(mappedBy = "idCargoFk")
    private List<CargosEspecialidade> cargosEspecialidadeList;
    @OneToMany(mappedBy = "idCargoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargoFk")
    private List<HistFuncionariosCargos> histFuncionariosCargosList;
    @JoinColumn(name = "id_nivel_cargo_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NiveisCargo idNivelCargoFk;
    @OneToMany(mappedBy = "idCargoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;

    public Cargos() {
    }

    public Cargos(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public List<CargosEspecialidade> getCargosEspecialidadeList() {
        return cargosEspecialidadeList;
    }

    public void setCargosEspecialidadeList(List<CargosEspecialidade> cargosEspecialidadeList) {
        this.cargosEspecialidadeList = cargosEspecialidadeList;
    }

    public List<FuncionariosLicencas> getFuncionariosLicencasList() {
        return funcionariosLicencasList;
    }

    public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
        this.funcionariosLicencasList = funcionariosLicencasList;
    }

    public List<HistFuncionariosCargos> getHistFuncionariosCargosList() {
        return histFuncionariosCargosList;
    }

    public void setHistFuncionariosCargosList(List<HistFuncionariosCargos> histFuncionariosCargosList) {
        this.histFuncionariosCargosList = histFuncionariosCargosList;
    }

    public NiveisCargo getIdNivelCargoFk() {
        return idNivelCargoFk;
    }

    public void setIdNivelCargoFk(NiveisCargo idNivelCargoFk) {
        this.idNivelCargoFk = idNivelCargoFk;
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
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.Cargos[ id=" + id + " ]";
    }
    
}
