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
@Table(name = "privilegios")
@NamedQueries({
    @NamedQuery(name = "Privilegios.findAll", query = "SELECT p FROM Privilegios p"),
    @NamedQuery(name = "Privilegios.findById", query = "SELECT p FROM Privilegios p WHERE p.id = :id"),
    @NamedQuery(name = "Privilegios.findByNomePrivilegio", query = "SELECT p FROM Privilegios p WHERE p.nomePrivilegio = :nomePrivilegio"),
    @NamedQuery(name = "Privilegios.findByDescricaoPrivilegio", query = "SELECT p FROM Privilegios p WHERE p.descricaoPrivilegio = :descricaoPrivilegio")})
public class Privilegios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_privilegio")
    private String nomePrivilegio;
    @Basic(optional = false)
    @Column(name = "descricao_privilegio")
    private String descricaoPrivilegio;
    @OneToMany(mappedBy = "seqPrivilegio")
    private List<PessoaOperadores> pessoaOperadoresList;

    public Privilegios() {
    }

    public Privilegios(Long id) {
        this.id = id;
    }

    public Privilegios(Long id, String nomePrivilegio, String descricaoPrivilegio) {
        this.id = id;
        this.nomePrivilegio = nomePrivilegio;
        this.descricaoPrivilegio = descricaoPrivilegio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePrivilegio() {
        return nomePrivilegio;
    }

    public void setNomePrivilegio(String nomePrivilegio) {
        this.nomePrivilegio = nomePrivilegio;
    }

    public String getDescricaoPrivilegio() {
        return descricaoPrivilegio;
    }

    public void setDescricaoPrivilegio(String descricaoPrivilegio) {
        this.descricaoPrivilegio = descricaoPrivilegio;
    }

    public List<PessoaOperadores> getPessoaOperadoresList() {
        return pessoaOperadoresList;
    }

    public void setPessoaOperadoresList(List<PessoaOperadores> pessoaOperadoresList) {
        this.pessoaOperadoresList = pessoaOperadoresList;
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
        if (!(object instanceof Privilegios)) {
            return false;
        }
        Privilegios other = (Privilegios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.Privilegios[ id=" + id + " ]";
    }
    
}
