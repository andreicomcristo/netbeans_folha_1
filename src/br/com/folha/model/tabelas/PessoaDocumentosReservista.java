/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "pessoa_documentos_reservista")
@NamedQueries({
    @NamedQuery(name = "PessoaDocumentosReservista.findAll", query = "SELECT p FROM PessoaDocumentosReservista p"),
    @NamedQuery(name = "PessoaDocumentosReservista.findById", query = "SELECT p FROM PessoaDocumentosReservista p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaDocumentosReservista.findByNumero", query = "SELECT p FROM PessoaDocumentosReservista p WHERE p.numero = :numero"),
    @NamedQuery(name = "PessoaDocumentosReservista.findBySerie", query = "SELECT p FROM PessoaDocumentosReservista p WHERE p.serie = :serie")})
public class PessoaDocumentosReservista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "numero", length = 100)
    private String numero;
    @Column(name = "serie", length = 100)
    private String serie;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;

    public PessoaDocumentosReservista() {
    }

    public PessoaDocumentosReservista(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
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
        if (!(object instanceof PessoaDocumentosReservista)) {
            return false;
        }
        PessoaDocumentosReservista other = (PessoaDocumentosReservista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.PessoaDocumentosReservista[ id=" + id + " ]";
    }
    
}
