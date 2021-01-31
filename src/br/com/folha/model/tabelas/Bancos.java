/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "bancos", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo_banco"})})
@NamedQueries({
    @NamedQuery(name = "Bancos.findAll", query = "SELECT b FROM Bancos b"),
    @NamedQuery(name = "Bancos.findById", query = "SELECT b FROM Bancos b WHERE b.id = :id"),
    @NamedQuery(name = "Bancos.findByCodigoBanco", query = "SELECT b FROM Bancos b WHERE b.codigoBanco = :codigoBanco"),
    @NamedQuery(name = "Bancos.findByNomeBanco", query = "SELECT b FROM Bancos b WHERE b.nomeBanco = :nomeBanco"),
    @NamedQuery(name = "Bancos.findBySiglaBanco", query = "SELECT b FROM Bancos b WHERE b.siglaBanco = :siglaBanco")})
public class Bancos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "codigo_banco", nullable = false, length = 50)
    private String codigoBanco;
    @Basic(optional = false)
    @Column(name = "nome_banco", nullable = false, length = 300)
    private String nomeBanco;
    @Column(name = "sigla_banco", length = 150)
    private String siglaBanco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBancoFk")
    private Collection<PessoaBancos> pessoaBancosCollection;

    public Bancos() {
    }

    public Bancos(Long id) {
        this.id = id;
    }

    public Bancos(Long id, String codigoBanco, String nomeBanco) {
        this.id = id;
        this.codigoBanco = codigoBanco;
        this.nomeBanco = nomeBanco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getSiglaBanco() {
        return siglaBanco;
    }

    public void setSiglaBanco(String siglaBanco) {
        this.siglaBanco = siglaBanco;
    }

    public Collection<PessoaBancos> getPessoaBancosCollection() {
        return pessoaBancosCollection;
    }

    public void setPessoaBancosCollection(Collection<PessoaBancos> pessoaBancosCollection) {
        this.pessoaBancosCollection = pessoaBancosCollection;
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
        if (!(object instanceof Bancos)) {
            return false;
        }
        Bancos other = (Bancos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.Bancos[ id=" + id + " ]";
    }
    
}
