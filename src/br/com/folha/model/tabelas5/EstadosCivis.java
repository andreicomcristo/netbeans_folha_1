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
@Table(name = "estados_civis")
@NamedQueries({
    @NamedQuery(name = "EstadosCivis.findAll", query = "SELECT e FROM EstadosCivis e"),
    @NamedQuery(name = "EstadosCivis.findById", query = "SELECT e FROM EstadosCivis e WHERE e.id = :id"),
    @NamedQuery(name = "EstadosCivis.findByNomeEstadoCivil", query = "SELECT e FROM EstadosCivis e WHERE e.nomeEstadoCivil = :nomeEstadoCivil"),
    @NamedQuery(name = "EstadosCivis.findByDescricaoEstadoCivil", query = "SELECT e FROM EstadosCivis e WHERE e.descricaoEstadoCivil = :descricaoEstadoCivil")})
public class EstadosCivis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_estado_civil")
    private String nomeEstadoCivil;
    @Column(name = "descricao_estado_civil")
    private String descricaoEstadoCivil;
    @OneToMany(mappedBy = "idEstadoCivilFk")
    private List<Pessoa> pessoaList;

    public EstadosCivis() {
    }

    public EstadosCivis(Long id) {
        this.id = id;
    }

    public EstadosCivis(Long id, String nomeEstadoCivil) {
        this.id = id;
        this.nomeEstadoCivil = nomeEstadoCivil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstadoCivil() {
        return nomeEstadoCivil;
    }

    public void setNomeEstadoCivil(String nomeEstadoCivil) {
        this.nomeEstadoCivil = nomeEstadoCivil;
    }

    public String getDescricaoEstadoCivil() {
        return descricaoEstadoCivil;
    }

    public void setDescricaoEstadoCivil(String descricaoEstadoCivil) {
        this.descricaoEstadoCivil = descricaoEstadoCivil;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
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
        if (!(object instanceof EstadosCivis)) {
            return false;
        }
        EstadosCivis other = (EstadosCivis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.EstadosCivis[ id=" + id + " ]";
    }
    
}
