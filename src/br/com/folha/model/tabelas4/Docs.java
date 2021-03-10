/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "docs")
@NamedQueries({
    @NamedQuery(name = "Docs.findAll", query = "SELECT d FROM Docs d"),
    @NamedQuery(name = "Docs.findById", query = "SELECT d FROM Docs d WHERE d.id = :id"),
    @NamedQuery(name = "Docs.findByData", query = "SELECT d FROM Docs d WHERE d.data = :data"),
    @NamedQuery(name = "Docs.findByDocName", query = "SELECT d FROM Docs d WHERE d.docName = :docName"),
    @NamedQuery(name = "Docs.findByDocType", query = "SELECT d FROM Docs d WHERE d.docType = :docType")})
public class Docs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "data")
    private BigInteger data;
    @Column(name = "doc_name")
    private String docName;
    @Column(name = "doc_type")
    private String docType;

    public Docs() {
    }

    public Docs(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getData() {
        return data;
    }

    public void setData(BigInteger data) {
        this.data = data;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
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
        if (!(object instanceof Docs)) {
            return false;
        }
        Docs other = (Docs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.Docs[ id=" + id + " ]";
    }
    
}
