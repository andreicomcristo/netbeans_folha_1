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
@Table(name = "sexos")
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
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_sexo")
    private String nomeSexo;
    @Column(name = "descricao_sexo")
    private String descricaoSexo;
    @OneToMany(mappedBy = "idSexoDeclaradoFk")
    private List<Pessoa> pessoaList;
    @OneToMany(mappedBy = "idSexoFk")
    private List<Pessoa> pessoaList1;

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

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public List<Pessoa> getPessoaList1() {
        return pessoaList1;
    }

    public void setPessoaList1(List<Pessoa> pessoaList1) {
        this.pessoaList1 = pessoaList1;
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
        return "br.com.folha.model.tabelas4.Sexos[ id=" + id + " ]";
    }
    
}
