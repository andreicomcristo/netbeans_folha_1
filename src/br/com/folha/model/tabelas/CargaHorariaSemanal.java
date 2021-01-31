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
@Table(name = "carga_horaria_semanal", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"carga_horaria"})})
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
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "carga_horaria", nullable = false)
    private int cargaHoraria;
    @Column(name = "descricao_carga_horaria", length = 300)
    private String descricaoCargaHoraria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaHorariaSemanalFk")
    private Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection;

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

    public Collection<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaCollection() {
        return histFuncionariosCargaHorariaCollection;
    }

    public void setHistFuncionariosCargaHorariaCollection(Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection) {
        this.histFuncionariosCargaHorariaCollection = histFuncionariosCargaHorariaCollection;
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
        return "br.com.folha.model.tabelas.CargaHorariaSemanal[ id=" + id + " ]";
    }
    
}
