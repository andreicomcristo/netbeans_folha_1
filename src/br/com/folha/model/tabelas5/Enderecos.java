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
@Table(name = "enderecos")
@NamedQueries({
    @NamedQuery(name = "Enderecos.findAll", query = "SELECT e FROM Enderecos e"),
    @NamedQuery(name = "Enderecos.findById", query = "SELECT e FROM Enderecos e WHERE e.id = :id"),
    @NamedQuery(name = "Enderecos.findByEnderecoLogradouro", query = "SELECT e FROM Enderecos e WHERE e.enderecoLogradouro = :enderecoLogradouro"),
    @NamedQuery(name = "Enderecos.findByEnderecoNumero", query = "SELECT e FROM Enderecos e WHERE e.enderecoNumero = :enderecoNumero"),
    @NamedQuery(name = "Enderecos.findByEnderecoComplemento", query = "SELECT e FROM Enderecos e WHERE e.enderecoComplemento = :enderecoComplemento"),
    @NamedQuery(name = "Enderecos.findByEnderecoBairro", query = "SELECT e FROM Enderecos e WHERE e.enderecoBairro = :enderecoBairro"),
    @NamedQuery(name = "Enderecos.findByEnderecoCep", query = "SELECT e FROM Enderecos e WHERE e.enderecoCep = :enderecoCep")})
public class Enderecos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "endereco_logradouro")
    private String enderecoLogradouro;
    @Column(name = "endereco_numero")
    private String enderecoNumero;
    @Column(name = "endereco_complemento")
    private String enderecoComplemento;
    @Column(name = "endereco_bairro")
    private String enderecoBairro;
    @Column(name = "endereco_cep")
    private String enderecoCep;
    @JoinColumn(name = "id_endereco_cidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Cidades idEnderecoCidadeFk;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_tipo_logradouro_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposLogradouro idTipoLogradouroFk;

    public Enderecos() {
    }

    public Enderecos(Long id) {
        this.id = id;
    }

    public Enderecos(Long id, String enderecoLogradouro) {
        this.id = id;
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public Cidades getIdEnderecoCidadeFk() {
        return idEnderecoCidadeFk;
    }

    public void setIdEnderecoCidadeFk(Cidades idEnderecoCidadeFk) {
        this.idEnderecoCidadeFk = idEnderecoCidadeFk;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    public TiposLogradouro getIdTipoLogradouroFk() {
        return idTipoLogradouroFk;
    }

    public void setIdTipoLogradouroFk(TiposLogradouro idTipoLogradouroFk) {
        this.idTipoLogradouroFk = idTipoLogradouroFk;
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
        if (!(object instanceof Enderecos)) {
            return false;
        }
        Enderecos other = (Enderecos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.Enderecos[ id=" + id + " ]";
    }
    
}
