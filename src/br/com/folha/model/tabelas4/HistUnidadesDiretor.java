/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "hist_unidades_diretor")
@NamedQueries({
    @NamedQuery(name = "HistUnidadesDiretor.findAll", query = "SELECT h FROM HistUnidadesDiretor h"),
    @NamedQuery(name = "HistUnidadesDiretor.findById", query = "SELECT h FROM HistUnidadesDiretor h WHERE h.histUnidadesDiretorPK.id = :id"),
    @NamedQuery(name = "HistUnidadesDiretor.findByIdUnidadeDeSaudeFk", query = "SELECT h FROM HistUnidadesDiretor h WHERE h.histUnidadesDiretorPK.idUnidadeDeSaudeFk = :idUnidadeDeSaudeFk"),
    @NamedQuery(name = "HistUnidadesDiretor.findByIdPessoaFk", query = "SELECT h FROM HistUnidadesDiretor h WHERE h.histUnidadesDiretorPK.idPessoaFk = :idPessoaFk"),
    @NamedQuery(name = "HistUnidadesDiretor.findByIdOperadorCadastroFk", query = "SELECT h FROM HistUnidadesDiretor h WHERE h.histUnidadesDiretorPK.idOperadorCadastroFk = :idOperadorCadastroFk"),
    @NamedQuery(name = "HistUnidadesDiretor.findByDtCadastro", query = "SELECT h FROM HistUnidadesDiretor h WHERE h.histUnidadesDiretorPK.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "HistUnidadesDiretor.findByMotivoCadastro", query = "SELECT h FROM HistUnidadesDiretor h WHERE h.motivoCadastro = :motivoCadastro"),
    @NamedQuery(name = "HistUnidadesDiretor.findByDtCancelamento", query = "SELECT h FROM HistUnidadesDiretor h WHERE h.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "HistUnidadesDiretor.findByMotivoCancelamento", query = "SELECT h FROM HistUnidadesDiretor h WHERE h.motivoCancelamento = :motivoCancelamento")})
public class HistUnidadesDiretor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistUnidadesDiretorPK histUnidadesDiretorPK;
    @Column(name = "motivo_cadastro")
    private String motivoCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PessoaOperadores pessoaOperadores;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_unidade_de_saude_fk", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unidades unidades;

    public HistUnidadesDiretor() {
    }

    public HistUnidadesDiretor(HistUnidadesDiretorPK histUnidadesDiretorPK) {
        this.histUnidadesDiretorPK = histUnidadesDiretorPK;
    }

    public HistUnidadesDiretor(long id, long idUnidadeDeSaudeFk, long idPessoaFk, long idOperadorCadastroFk, Date dtCadastro) {
        this.histUnidadesDiretorPK = new HistUnidadesDiretorPK(id, idUnidadeDeSaudeFk, idPessoaFk, idOperadorCadastroFk, dtCadastro);
    }

    public HistUnidadesDiretorPK getHistUnidadesDiretorPK() {
        return histUnidadesDiretorPK;
    }

    public void setHistUnidadesDiretorPK(HistUnidadesDiretorPK histUnidadesDiretorPK) {
        this.histUnidadesDiretorPK = histUnidadesDiretorPK;
    }

    public String getMotivoCadastro() {
        return motivoCadastro;
    }

    public void setMotivoCadastro(String motivoCadastro) {
        this.motivoCadastro = motivoCadastro;
    }

    public Date getDtCancelamento() {
        return dtCancelamento;
    }

    public void setDtCancelamento(Date dtCancelamento) {
        this.dtCancelamento = dtCancelamento;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaOperadores getPessoaOperadores() {
        return pessoaOperadores;
    }

    public void setPessoaOperadores(PessoaOperadores pessoaOperadores) {
        this.pessoaOperadores = pessoaOperadores;
    }

    public PessoaOperadores getIdOperadorCancelamentoFk() {
        return idOperadorCancelamentoFk;
    }

    public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
        this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
    }

    public Unidades getUnidades() {
        return unidades;
    }

    public void setUnidades(Unidades unidades) {
        this.unidades = unidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (histUnidadesDiretorPK != null ? histUnidadesDiretorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistUnidadesDiretor)) {
            return false;
        }
        HistUnidadesDiretor other = (HistUnidadesDiretor) object;
        if ((this.histUnidadesDiretorPK == null && other.histUnidadesDiretorPK != null) || (this.histUnidadesDiretorPK != null && !this.histUnidadesDiretorPK.equals(other.histUnidadesDiretorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.HistUnidadesDiretor[ histUnidadesDiretorPK=" + histUnidadesDiretorPK + " ]";
    }
    
}
