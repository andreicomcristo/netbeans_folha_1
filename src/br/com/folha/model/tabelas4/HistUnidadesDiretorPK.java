/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANDREI
 */
@Embeddable
public class HistUnidadesDiretorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @Column(name = "id_unidade_de_saude_fk")
    private long idUnidadeDeSaudeFk;
    @Basic(optional = false)
    @Column(name = "id_pessoa_fk")
    private long idPessoaFk;
    @Basic(optional = false)
    @Column(name = "id_operador_cadastro_fk")
    private long idOperadorCadastroFk;
    @Basic(optional = false)
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    public HistUnidadesDiretorPK() {
    }

    public HistUnidadesDiretorPK(long id, long idUnidadeDeSaudeFk, long idPessoaFk, long idOperadorCadastroFk, Date dtCadastro) {
        this.id = id;
        this.idUnidadeDeSaudeFk = idUnidadeDeSaudeFk;
        this.idPessoaFk = idPessoaFk;
        this.idOperadorCadastroFk = idOperadorCadastroFk;
        this.dtCadastro = dtCadastro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUnidadeDeSaudeFk() {
        return idUnidadeDeSaudeFk;
    }

    public void setIdUnidadeDeSaudeFk(long idUnidadeDeSaudeFk) {
        this.idUnidadeDeSaudeFk = idUnidadeDeSaudeFk;
    }

    public long getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(long idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    public long getIdOperadorCadastroFk() {
        return idOperadorCadastroFk;
    }

    public void setIdOperadorCadastroFk(long idOperadorCadastroFk) {
        this.idOperadorCadastroFk = idOperadorCadastroFk;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idUnidadeDeSaudeFk;
        hash += (int) idPessoaFk;
        hash += (int) idOperadorCadastroFk;
        hash += (dtCadastro != null ? dtCadastro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistUnidadesDiretorPK)) {
            return false;
        }
        HistUnidadesDiretorPK other = (HistUnidadesDiretorPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idUnidadeDeSaudeFk != other.idUnidadeDeSaudeFk) {
            return false;
        }
        if (this.idPessoaFk != other.idPessoaFk) {
            return false;
        }
        if (this.idOperadorCadastroFk != other.idOperadorCadastroFk) {
            return false;
        }
        if ((this.dtCadastro == null && other.dtCadastro != null) || (this.dtCadastro != null && !this.dtCadastro.equals(other.dtCadastro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.HistUnidadesDiretorPK[ id=" + id + ", idUnidadeDeSaudeFk=" + idUnidadeDeSaudeFk + ", idPessoaFk=" + idPessoaFk + ", idOperadorCadastroFk=" + idOperadorCadastroFk + ", dtCadastro=" + dtCadastro + " ]";
    }
    
}
