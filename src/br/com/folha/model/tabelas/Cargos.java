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
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findById", query = "SELECT c FROM Cargos c WHERE c.id = :id"),
    @NamedQuery(name = "Cargos.findByNomeCargo", query = "SELECT c FROM Cargos c WHERE c.nomeCargo = :nomeCargo"),
    @NamedQuery(name = "Cargos.findByDescricaoCargo", query = "SELECT c FROM Cargos c WHERE c.descricaoCargo = :descricaoCargo")})
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
    private Collection<CargosEspecialidade> cargosEspecialidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargoFk")
    private Collection<HistFuncionariosCargos> histFuncionariosCargosCollection;
    @JoinColumn(name = "id_nivel_cargo_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NiveisCargo idNivelCargoFk;

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

    public Collection<CargosEspecialidade> getCargosEspecialidadeCollection() {
        return cargosEspecialidadeCollection;
    }

    public void setCargosEspecialidadeCollection(Collection<CargosEspecialidade> cargosEspecialidadeCollection) {
        this.cargosEspecialidadeCollection = cargosEspecialidadeCollection;
    }

    public Collection<HistFuncionariosCargos> getHistFuncionariosCargosCollection() {
        return histFuncionariosCargosCollection;
    }

    public void setHistFuncionariosCargosCollection(Collection<HistFuncionariosCargos> histFuncionariosCargosCollection) {
        this.histFuncionariosCargosCollection = histFuncionariosCargosCollection;
    }

    public NiveisCargo getIdNivelCargoFk() {
        return idNivelCargoFk;
    }

    public void setIdNivelCargoFk(NiveisCargo idNivelCargoFk) {
        this.idNivelCargoFk = idNivelCargoFk;
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
        return "br.com.folha.model.tabelas.Cargos[ id=" + id + " ]";
    }
    
}
