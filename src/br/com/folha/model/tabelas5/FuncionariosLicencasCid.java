/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "funcionarios_licencas_cid")
@NamedQueries({
    @NamedQuery(name = "FuncionariosLicencasCid.findAll", query = "SELECT f FROM FuncionariosLicencasCid f"),
    @NamedQuery(name = "FuncionariosLicencasCid.findById", query = "SELECT f FROM FuncionariosLicencasCid f WHERE f.id = :id"),
    @NamedQuery(name = "FuncionariosLicencasCid.findByIdCidFk", query = "SELECT f FROM FuncionariosLicencasCid f WHERE f.idCidFk = :idCidFk")})
public class FuncionariosLicencasCid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "id_cid_fk")
    private long idCidFk;

    public FuncionariosLicencasCid() {
    }

    public FuncionariosLicencasCid(Long id) {
        this.id = id;
    }

    public FuncionariosLicencasCid(Long id, long idCidFk) {
        this.id = id;
        this.idCidFk = idCidFk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdCidFk() {
        return idCidFk;
    }

    public void setIdCidFk(long idCidFk) {
        this.idCidFk = idCidFk;
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
        if (!(object instanceof FuncionariosLicencasCid)) {
            return false;
        }
        FuncionariosLicencasCid other = (FuncionariosLicencasCid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.FuncionariosLicencasCid[ id=" + id + " ]";
    }
    
}
