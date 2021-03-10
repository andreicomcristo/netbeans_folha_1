/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

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
@Table(name = "niveis_cargo")
@NamedQueries({
    @NamedQuery(name = "NiveisCargo.findAll", query = "SELECT n FROM NiveisCargo n"),
    @NamedQuery(name = "NiveisCargo.findById", query = "SELECT n FROM NiveisCargo n WHERE n.id = :id"),
    @NamedQuery(name = "NiveisCargo.findBySiglaNivelCargo", query = "SELECT n FROM NiveisCargo n WHERE n.siglaNivelCargo = :siglaNivelCargo"),
    @NamedQuery(name = "NiveisCargo.findByNomeNivelCargo", query = "SELECT n FROM NiveisCargo n WHERE n.nomeNivelCargo = :nomeNivelCargo"),
    @NamedQuery(name = "NiveisCargo.findByDescricaoNivelCargo", query = "SELECT n FROM NiveisCargo n WHERE n.descricaoNivelCargo = :descricaoNivelCargo")})
public class NiveisCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "sigla_nivel_cargo")
    private String siglaNivelCargo;
    @Basic(optional = false)
    @Column(name = "nome_nivel_cargo")
    private String nomeNivelCargo;
    @Column(name = "descricao_nivel_cargo")
    private String descricaoNivelCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelCargoFk")
    private List<Cargos> cargosList;

    public NiveisCargo() {
    }

    public NiveisCargo(Long id) {
        this.id = id;
    }

    public NiveisCargo(Long id, String siglaNivelCargo, String nomeNivelCargo) {
        this.id = id;
        this.siglaNivelCargo = siglaNivelCargo;
        this.nomeNivelCargo = nomeNivelCargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiglaNivelCargo() {
        return siglaNivelCargo;
    }

    public void setSiglaNivelCargo(String siglaNivelCargo) {
        this.siglaNivelCargo = siglaNivelCargo;
    }

    public String getNomeNivelCargo() {
        return nomeNivelCargo;
    }

    public void setNomeNivelCargo(String nomeNivelCargo) {
        this.nomeNivelCargo = nomeNivelCargo;
    }

    public String getDescricaoNivelCargo() {
        return descricaoNivelCargo;
    }

    public void setDescricaoNivelCargo(String descricaoNivelCargo) {
        this.descricaoNivelCargo = descricaoNivelCargo;
    }

    public List<Cargos> getCargosList() {
        return cargosList;
    }

    public void setCargosList(List<Cargos> cargosList) {
        this.cargosList = cargosList;
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
        if (!(object instanceof NiveisCargo)) {
            return false;
        }
        NiveisCargo other = (NiveisCargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.NiveisCargo[ id=" + id + " ]";
    }
    
}
