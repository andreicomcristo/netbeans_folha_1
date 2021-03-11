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
@Table(name = "tipos_de_capacitacao")
@NamedQueries({
    @NamedQuery(name = "TiposDeCapacitacao.findAll", query = "SELECT t FROM TiposDeCapacitacao t"),
    @NamedQuery(name = "TiposDeCapacitacao.findById", query = "SELECT t FROM TiposDeCapacitacao t WHERE t.id = :id"),
    @NamedQuery(name = "TiposDeCapacitacao.findByTipoCapacitacao", query = "SELECT t FROM TiposDeCapacitacao t WHERE t.tipoCapacitacao = :tipoCapacitacao"),
    @NamedQuery(name = "TiposDeCapacitacao.findByDescricaoTipoCapacitacao", query = "SELECT t FROM TiposDeCapacitacao t WHERE t.descricaoTipoCapacitacao = :descricaoTipoCapacitacao")})
public class TiposDeCapacitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "tipo_capacitacao")
    private String tipoCapacitacao;
    @Column(name = "descricao_tipo_capacitacao")
    private String descricaoTipoCapacitacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTiposCapacitacaoFk")
    private List<FuncionariosCapacitacoes> funcionariosCapacitacoesList;

    public TiposDeCapacitacao() {
    }

    public TiposDeCapacitacao(Long id) {
        this.id = id;
    }

    public TiposDeCapacitacao(Long id, String tipoCapacitacao) {
        this.id = id;
        this.tipoCapacitacao = tipoCapacitacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoCapacitacao() {
        return tipoCapacitacao;
    }

    public void setTipoCapacitacao(String tipoCapacitacao) {
        this.tipoCapacitacao = tipoCapacitacao;
    }

    public String getDescricaoTipoCapacitacao() {
        return descricaoTipoCapacitacao;
    }

    public void setDescricaoTipoCapacitacao(String descricaoTipoCapacitacao) {
        this.descricaoTipoCapacitacao = descricaoTipoCapacitacao;
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
        if (!(object instanceof TiposDeCapacitacao)) {
            return false;
        }
        TiposDeCapacitacao other = (TiposDeCapacitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.TiposDeCapacitacao[ id=" + id + " ]";
    }
    
}
