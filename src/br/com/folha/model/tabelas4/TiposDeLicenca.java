/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "tipos_de_licenca")
@NamedQueries({
    @NamedQuery(name = "TiposDeLicenca.findAll", query = "SELECT t FROM TiposDeLicenca t"),
    @NamedQuery(name = "TiposDeLicenca.findById", query = "SELECT t FROM TiposDeLicenca t WHERE t.id = :id"),
    @NamedQuery(name = "TiposDeLicenca.findByDescricaoTipoLicenca", query = "SELECT t FROM TiposDeLicenca t WHERE t.descricaoTipoLicenca = :descricaoTipoLicenca")})
public class TiposDeLicenca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "descricao_tipo_licenca")
    private String descricaoTipoLicenca;
    @OneToMany(mappedBy = "idTipoLicencaFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;

    public TiposDeLicenca() {
    }

    public TiposDeLicenca(Long id) {
        this.id = id;
    }

    public TiposDeLicenca(Long id, String descricaoTipoLicenca) {
        this.id = id;
        this.descricaoTipoLicenca = descricaoTipoLicenca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoTipoLicenca() {
        return descricaoTipoLicenca;
    }

    public void setDescricaoTipoLicenca(String descricaoTipoLicenca) {
        this.descricaoTipoLicenca = descricaoTipoLicenca;
    }

    public List<FuncionariosLicencas> getFuncionariosLicencasList() {
        return funcionariosLicencasList;
    }

    public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
        this.funcionariosLicencasList = funcionariosLicencasList;
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
        if (!(object instanceof TiposDeLicenca)) {
            return false;
        }
        TiposDeLicenca other = (TiposDeLicenca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.TiposDeLicenca[ id=" + id + " ]";
    }
    
}
