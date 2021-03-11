/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

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
@Table(name = "carga_horaria_semanal")
@NamedQueries({
    @NamedQuery(name = "CargaHorariaSemanal.findAll", query = "SELECT c FROM CargaHorariaSemanal c"),
    @NamedQuery(name = "CargaHorariaSemanal.findById", query = "SELECT c FROM CargaHorariaSemanal c WHERE c.id = :id"),
    @NamedQuery(name = "CargaHorariaSemanal.findByCargaHoraria", query = "SELECT c FROM CargaHorariaSemanal c WHERE c.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "CargaHorariaSemanal.findByDescricaoCargaHoraria", query = "SELECT c FROM CargaHorariaSemanal c WHERE c.descricaoCargaHoraria = :descricaoCargaHoraria")})
public class CargaHorariaSemanal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "carga_horaria")
    private int cargaHoraria;
    @Column(name = "descricao_carga_horaria")
    private String descricaoCargaHoraria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaHorariaSemanalFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList;
    @OneToMany(mappedBy = "idCargaHorariaAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;

    public CargaHorariaSemanal() {
    }

    public CargaHorariaSemanal(Long id) {
        this.id = id;
    }

    public CargaHorariaSemanal(Long id, int cargaHoraria) {
        this.id = id;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricaoCargaHoraria() {
        return descricaoCargaHoraria;
    }

    public void setDescricaoCargaHoraria(String descricaoCargaHoraria) {
        this.descricaoCargaHoraria = descricaoCargaHoraria;
    }

    public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaList() {
        return histFuncionariosCargaHorariaList;
    }

    public void setHistFuncionariosCargaHorariaList(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList) {
        this.histFuncionariosCargaHorariaList = histFuncionariosCargaHorariaList;
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
        if (!(object instanceof CargaHorariaSemanal)) {
            return false;
        }
        CargaHorariaSemanal other = (CargaHorariaSemanal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.CargaHorariaSemanal[ id=" + id + " ]";
    }
    
}
