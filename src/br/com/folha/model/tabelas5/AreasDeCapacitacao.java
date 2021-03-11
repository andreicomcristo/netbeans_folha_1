/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

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
@Table(name = "areas_de_capacitacao")
@NamedQueries({
    @NamedQuery(name = "AreasDeCapacitacao.findAll", query = "SELECT a FROM AreasDeCapacitacao a"),
    @NamedQuery(name = "AreasDeCapacitacao.findById", query = "SELECT a FROM AreasDeCapacitacao a WHERE a.id = :id"),
    @NamedQuery(name = "AreasDeCapacitacao.findByAreaDeCapacitacao", query = "SELECT a FROM AreasDeCapacitacao a WHERE a.areaDeCapacitacao = :areaDeCapacitacao")})
public class AreasDeCapacitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "area_de_capacitacao")
    private String areaDeCapacitacao;
    @OneToMany(mappedBy = "idAreaDeCapacitacaoFk")
    private List<FuncionariosCapacitacoes> funcionariosCapacitacoesList;

    public AreasDeCapacitacao() {
    }

    public AreasDeCapacitacao(Long id) {
        this.id = id;
    }

    public AreasDeCapacitacao(Long id, String areaDeCapacitacao) {
        this.id = id;
        this.areaDeCapacitacao = areaDeCapacitacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaDeCapacitacao() {
        return areaDeCapacitacao;
    }

    public void setAreaDeCapacitacao(String areaDeCapacitacao) {
        this.areaDeCapacitacao = areaDeCapacitacao;
    }

    public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoesList() {
        return funcionariosCapacitacoesList;
    }

    public void setFuncionariosCapacitacoesList(List<FuncionariosCapacitacoes> funcionariosCapacitacoesList) {
        this.funcionariosCapacitacoesList = funcionariosCapacitacoesList;
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
        if (!(object instanceof AreasDeCapacitacao)) {
            return false;
        }
        AreasDeCapacitacao other = (AreasDeCapacitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.AreasDeCapacitacao[ id=" + id + " ]";
    }
    
}
