/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "sexos", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome_sexo"})})
@NamedQueries({
    @NamedQuery(name = "Sexos.findAll", query = "SELECT s FROM Sexos s"),
    @NamedQuery(name = "Sexos.findById", query = "SELECT s FROM Sexos s WHERE s.id = :id"),
    @NamedQuery(name = "Sexos.findByNomeSexo", query = "SELECT s FROM Sexos s WHERE s.nomeSexo = :nomeSexo"),
    @NamedQuery(name = "Sexos.findByDescricaoSexo", query = "SELECT s FROM Sexos s WHERE s.descricaoSexo = :descricaoSexo")})
public class Sexos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_sexo", nullable = false, length = 100)
    private String nomeSexo;
    @Column(name = "descricao_sexo", length = 300)
    private String descricaoSexo;
    @OneToMany(mappedBy = "seqSexoDeclarado")
    private Collection<Pessoa> pessoaCollection;
    @OneToMany(mappedBy = "seqSexo")
    private Collection<Pessoa> pessoaCollection1;

    public Sexos() {
    }

    public Sexos(Long id) {
        this.id = id;
    }

    public Sexos(Long id, String nomeSexo) {
        this.id = id;
        this.nomeSexo = nomeSexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSexo() {
        return nomeSexo;
    }

    public void setNomeSexo(String nomeSexo) {
        this.nomeSexo = nomeSexo;
    }

    public String getDescricaoSexo() {
        return descricaoSexo;
    }

    public void setDescricaoSexo(String descricaoSexo) {
        this.descricaoSexo = descricaoSexo;
    }

    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    public Collection<Pessoa> getPessoaCollection1() {
        return pessoaCollection1;
    }

    public void setPessoaCollection1(Collection<Pessoa> pessoaCollection1) {
        this.pessoaCollection1 = pessoaCollection1;
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
        if (!(object instanceof Sexos)) {
            return false;
        }
        Sexos other = (Sexos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.Sexos[ id=" + id + " ]";
    }
    
}
