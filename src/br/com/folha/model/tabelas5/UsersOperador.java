/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "users_operador")
@NamedQueries({
    @NamedQuery(name = "UsersOperador.findAll", query = "SELECT u FROM UsersOperador u"),
    @NamedQuery(name = "UsersOperador.findById", query = "SELECT u FROM UsersOperador u WHERE u.id = :id"),
    @NamedQuery(name = "UsersOperador.findByIdPessoaOperadoresFk", query = "SELECT u FROM UsersOperador u WHERE u.idPessoaOperadoresFk = :idPessoaOperadoresFk")})
public class UsersOperador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    private BigInteger id;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pessoa_operadores_fk")
    private Long idPessoaOperadoresFk;
    @JoinColumn(name = "id_pessoa_operadores_fk", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessoaOperadores pessoaOperadores;
    @JoinColumn(name = "username_fk", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users usernameFk;

    public UsersOperador() {
    }

    public UsersOperador(Long idPessoaOperadoresFk) {
        this.idPessoaOperadoresFk = idPessoaOperadoresFk;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Long getIdPessoaOperadoresFk() {
        return idPessoaOperadoresFk;
    }

    public void setIdPessoaOperadoresFk(Long idPessoaOperadoresFk) {
        this.idPessoaOperadoresFk = idPessoaOperadoresFk;
    }

    public PessoaOperadores getPessoaOperadores() {
        return pessoaOperadores;
    }

    public void setPessoaOperadores(PessoaOperadores pessoaOperadores) {
        this.pessoaOperadores = pessoaOperadores;
    }

    public Users getUsernameFk() {
        return usernameFk;
    }

    public void setUsernameFk(Users usernameFk) {
        this.usernameFk = usernameFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoaOperadoresFk != null ? idPessoaOperadoresFk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersOperador)) {
            return false;
        }
        UsersOperador other = (UsersOperador) object;
        if ((this.idPessoaOperadoresFk == null && other.idPessoaOperadoresFk != null) || (this.idPessoaOperadoresFk != null && !this.idPessoaOperadoresFk.equals(other.idPessoaOperadoresFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.UsersOperador[ idPessoaOperadoresFk=" + idPessoaOperadoresFk + " ]";
    }
    
}
