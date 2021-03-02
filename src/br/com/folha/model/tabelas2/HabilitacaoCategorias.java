/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas2;

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
@Table(name = "habilitacao_categorias")
@NamedQueries({
    @NamedQuery(name = "HabilitacaoCategorias.findAll", query = "SELECT h FROM HabilitacaoCategorias h")})
public class HabilitacaoCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_habilitacao_categoria")
    private String nomeHabilitacaoCategoria;
    @Column(name = "descricao_habilitacao_categoria")
    private String descricaoHabilitacaoCategoria;
    @OneToMany(mappedBy = "idHabilitacaoCategoriasFk")
    private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList;

    public HabilitacaoCategorias() {
    }

    public HabilitacaoCategorias(Long id) {
        this.id = id;
    }

    public HabilitacaoCategorias(Long id, String nomeHabilitacaoCategoria) {
        this.id = id;
        this.nomeHabilitacaoCategoria = nomeHabilitacaoCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeHabilitacaoCategoria() {
        return nomeHabilitacaoCategoria;
    }

    public void setNomeHabilitacaoCategoria(String nomeHabilitacaoCategoria) {
        this.nomeHabilitacaoCategoria = nomeHabilitacaoCategoria;
    }

    public String getDescricaoHabilitacaoCategoria() {
        return descricaoHabilitacaoCategoria;
    }

    public void setDescricaoHabilitacaoCategoria(String descricaoHabilitacaoCategoria) {
        this.descricaoHabilitacaoCategoria = descricaoHabilitacaoCategoria;
    }

    public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaoList() {
        return pessoaDocumentosHabilitacaoList;
    }

    public void setPessoaDocumentosHabilitacaoList(List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList) {
        this.pessoaDocumentosHabilitacaoList = pessoaDocumentosHabilitacaoList;
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
        if (!(object instanceof HabilitacaoCategorias)) {
            return false;
        }
        HabilitacaoCategorias other = (HabilitacaoCategorias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.HabilitacaoCategorias[ id=" + id + " ]";
    }
    
}
