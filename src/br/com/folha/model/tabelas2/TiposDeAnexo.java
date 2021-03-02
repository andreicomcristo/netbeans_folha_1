/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "tipos_de_anexo")
@NamedQueries({
    @NamedQuery(name = "TiposDeAnexo.findAll", query = "SELECT t FROM TiposDeAnexo t")})
public class TiposDeAnexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "tipo_de_anexo")
    private String tipoDeAnexo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tiposDeAnexo")
    private FuncionariosAnexos funcionariosAnexos;

    public TiposDeAnexo() {
    }

    public TiposDeAnexo(Long id) {
        this.id = id;
    }

    public TiposDeAnexo(Long id, String tipoDeAnexo) {
        this.id = id;
        this.tipoDeAnexo = tipoDeAnexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeAnexo() {
        return tipoDeAnexo;
    }

    public void setTipoDeAnexo(String tipoDeAnexo) {
        this.tipoDeAnexo = tipoDeAnexo;
    }

    public FuncionariosAnexos getFuncionariosAnexos() {
        return funcionariosAnexos;
    }

    public void setFuncionariosAnexos(FuncionariosAnexos funcionariosAnexos) {
        this.funcionariosAnexos = funcionariosAnexos;
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
        if (!(object instanceof TiposDeAnexo)) {
            return false;
        }
        TiposDeAnexo other = (TiposDeAnexo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.TiposDeAnexo[ id=" + id + " ]";
    }
    
}
