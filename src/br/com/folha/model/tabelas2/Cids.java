/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "cids")
@NamedQueries({
    @NamedQuery(name = "Cids.findAll", query = "SELECT c FROM Cids c")})
public class Cids implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "cod_cid")
    private String codCid;
    @Column(name = "descricao_cid")
    private String descricaoCid;

    public Cids() {
    }

    public Cids(Long id) {
        this.id = id;
    }

    public Cids(Long id, String codCid) {
        this.id = id;
        this.codCid = codCid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodCid() {
        return codCid;
    }

    public void setCodCid(String codCid) {
        this.codCid = codCid;
    }

    public String getDescricaoCid() {
        return descricaoCid;
    }

    public void setDescricaoCid(String descricaoCid) {
        this.descricaoCid = descricaoCid;
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
        if (!(object instanceof Cids)) {
            return false;
        }
        Cids other = (Cids) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.Cids[ id=" + id + " ]";
    }
    
}
