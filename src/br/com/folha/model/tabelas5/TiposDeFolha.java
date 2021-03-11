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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "tipos_de_folha")
@NamedQueries({
    @NamedQuery(name = "TiposDeFolha.findAll", query = "SELECT t FROM TiposDeFolha t"),
    @NamedQuery(name = "TiposDeFolha.findById", query = "SELECT t FROM TiposDeFolha t WHERE t.id = :id"),
    @NamedQuery(name = "TiposDeFolha.findByNomeTipoFolha", query = "SELECT t FROM TiposDeFolha t WHERE t.nomeTipoFolha = :nomeTipoFolha"),
    @NamedQuery(name = "TiposDeFolha.findByDescricaoTipoFolha", query = "SELECT t FROM TiposDeFolha t WHERE t.descricaoTipoFolha = :descricaoTipoFolha"),
    @NamedQuery(name = "TiposDeFolha.findByNomeTipoFilha", query = "SELECT t FROM TiposDeFolha t WHERE t.nomeTipoFilha = :nomeTipoFilha")})
public class TiposDeFolha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_tipo_folha")
    private String nomeTipoFolha;
    @Column(name = "descricao_tipo_folha")
    private String descricaoTipoFolha;
    @Basic(optional = false)
    @Column(name = "nome_tipo_filha")
    private String nomeTipoFilha;

    public TiposDeFolha() {
    }

    public TiposDeFolha(Long id) {
        this.id = id;
    }

    public TiposDeFolha(Long id, String nomeTipoFolha, String nomeTipoFilha) {
        this.id = id;
        this.nomeTipoFolha = nomeTipoFolha;
        this.nomeTipoFilha = nomeTipoFilha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTipoFolha() {
        return nomeTipoFolha;
    }

    public void setNomeTipoFolha(String nomeTipoFolha) {
        this.nomeTipoFolha = nomeTipoFolha;
    }

    public String getDescricaoTipoFolha() {
        return descricaoTipoFolha;
    }

    public void setDescricaoTipoFolha(String descricaoTipoFolha) {
        this.descricaoTipoFolha = descricaoTipoFolha;
    }

    public String getNomeTipoFilha() {
        return nomeTipoFilha;
    }

    public void setNomeTipoFilha(String nomeTipoFilha) {
        this.nomeTipoFilha = nomeTipoFilha;
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
        if (!(object instanceof TiposDeFolha)) {
            return false;
        }
        TiposDeFolha other = (TiposDeFolha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.TiposDeFolha[ id=" + id + " ]";
    }
    
}
