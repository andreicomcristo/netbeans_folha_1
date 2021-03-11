/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

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
@Table(name = "pessoa_documentos_titulo")
@NamedQueries({
    @NamedQuery(name = "PessoaDocumentosTitulo.findAll", query = "SELECT p FROM PessoaDocumentosTitulo p"),
    @NamedQuery(name = "PessoaDocumentosTitulo.findById", query = "SELECT p FROM PessoaDocumentosTitulo p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaDocumentosTitulo.findByNumeroTitulo", query = "SELECT p FROM PessoaDocumentosTitulo p WHERE p.numeroTitulo = :numeroTitulo"),
    @NamedQuery(name = "PessoaDocumentosTitulo.findByZona", query = "SELECT p FROM PessoaDocumentosTitulo p WHERE p.zona = :zona"),
    @NamedQuery(name = "PessoaDocumentosTitulo.findBySecao", query = "SELECT p FROM PessoaDocumentosTitulo p WHERE p.secao = :secao")})
public class PessoaDocumentosTitulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "numero_titulo")
    private String numeroTitulo;
    @Column(name = "zona")
    private String zona;
    @Column(name = "secao")
    private String secao;
    @JoinColumn(name = "id_cidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Cidades idCidadeFk;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;

    public PessoaDocumentosTitulo() {
    }

    public PessoaDocumentosTitulo(Long id) {
        this.id = id;
    }

    public PessoaDocumentosTitulo(Long id, String numeroTitulo) {
        this.id = id;
        this.numeroTitulo = numeroTitulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroTitulo() {
        return numeroTitulo;
    }

    public void setNumeroTitulo(String numeroTitulo) {
        this.numeroTitulo = numeroTitulo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public Cidades getIdCidadeFk() {
        return idCidadeFk;
    }

    public void setIdCidadeFk(Cidades idCidadeFk) {
        this.idCidadeFk = idCidadeFk;
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
        if (!(object instanceof PessoaDocumentosTitulo)) {
            return false;
        }
        PessoaDocumentosTitulo other = (PessoaDocumentosTitulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.PessoaDocumentosTitulo[ id=" + id + " ]";
    }
    
}
