/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "cargos_especialidade")
@NamedQueries({
    @NamedQuery(name = "CargosEspecialidade.findAll", query = "SELECT c FROM CargosEspecialidade c"),
    @NamedQuery(name = "CargosEspecialidade.findById", query = "SELECT c FROM CargosEspecialidade c WHERE c.id = :id"),
    @NamedQuery(name = "CargosEspecialidade.findByNomeEspecialidadeCargo", query = "SELECT c FROM CargosEspecialidade c WHERE c.nomeEspecialidadeCargo = :nomeEspecialidadeCargo"),
    @NamedQuery(name = "CargosEspecialidade.findByDescricaoEspecialidadeCargo", query = "SELECT c FROM CargosEspecialidade c WHERE c.descricaoEspecialidadeCargo = :descricaoEspecialidadeCargo")})
public class CargosEspecialidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_especialidade_cargo")
    private String nomeEspecialidadeCargo;
    @Column(name = "descricao_especialidade_cargo")
    private String descricaoEspecialidadeCargo;
    @JoinColumn(name = "id_cargo_fk", referencedColumnName = "id")
    @ManyToOne
    private Cargos idCargoFk;

    public CargosEspecialidade() {
    }

    public CargosEspecialidade(Long id) {
        this.id = id;
    }

    public CargosEspecialidade(Long id, String nomeEspecialidadeCargo) {
        this.id = id;
        this.nomeEspecialidadeCargo = nomeEspecialidadeCargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEspecialidadeCargo() {
        return nomeEspecialidadeCargo;
    }

    public void setNomeEspecialidadeCargo(String nomeEspecialidadeCargo) {
        this.nomeEspecialidadeCargo = nomeEspecialidadeCargo;
    }

    public String getDescricaoEspecialidadeCargo() {
        return descricaoEspecialidadeCargo;
    }

    public void setDescricaoEspecialidadeCargo(String descricaoEspecialidadeCargo) {
        this.descricaoEspecialidadeCargo = descricaoEspecialidadeCargo;
    }

    public Cargos getIdCargoFk() {
        return idCargoFk;
    }

    public void setIdCargoFk(Cargos idCargoFk) {
        this.idCargoFk = idCargoFk;
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
        if (!(object instanceof CargosEspecialidade)) {
            return false;
        }
        CargosEspecialidade other = (CargosEspecialidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.CargosEspecialidade[ id=" + id + " ]";
    }
    
}
