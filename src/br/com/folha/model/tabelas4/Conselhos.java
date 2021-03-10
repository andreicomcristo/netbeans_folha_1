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
@Table(name = "conselhos")
@NamedQueries({
    @NamedQuery(name = "Conselhos.findAll", query = "SELECT c FROM Conselhos c"),
    @NamedQuery(name = "Conselhos.findById", query = "SELECT c FROM Conselhos c WHERE c.id = :id"),
    @NamedQuery(name = "Conselhos.findByNomeConselho", query = "SELECT c FROM Conselhos c WHERE c.nomeConselho = :nomeConselho"),
    @NamedQuery(name = "Conselhos.findByDescricaoConselho", query = "SELECT c FROM Conselhos c WHERE c.descricaoConselho = :descricaoConselho")})
public class Conselhos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_conselho")
    private String nomeConselho;
    @Column(name = "descricao_conselho")
    private String descricaoConselho;
    @OneToMany(mappedBy = "idConselhosFk")
    private List<PessoaDocumentosConselho> pessoaDocumentosConselhoList;

    public Conselhos() {
    }

    public Conselhos(Long id) {
        this.id = id;
    }

    public Conselhos(Long id, String nomeConselho) {
        this.id = id;
        this.nomeConselho = nomeConselho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeConselho() {
        return nomeConselho;
    }

    public void setNomeConselho(String nomeConselho) {
        this.nomeConselho = nomeConselho;
    }

    public String getDescricaoConselho() {
        return descricaoConselho;
    }

    public void setDescricaoConselho(String descricaoConselho) {
        this.descricaoConselho = descricaoConselho;
    }

    public List<PessoaDocumentosConselho> getPessoaDocumentosConselhoList() {
        return pessoaDocumentosConselhoList;
    }

    public void setPessoaDocumentosConselhoList(List<PessoaDocumentosConselho> pessoaDocumentosConselhoList) {
        this.pessoaDocumentosConselhoList = pessoaDocumentosConselhoList;
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
        if (!(object instanceof Conselhos)) {
            return false;
        }
        Conselhos other = (Conselhos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.Conselhos[ id=" + id + " ]";
    }
    
}
