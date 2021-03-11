/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "hist_funcionarios_vinculos")
@NamedQueries({
    @NamedQuery(name = "HistFuncionariosVinculos.findAll", query = "SELECT h FROM HistFuncionariosVinculos h"),
    @NamedQuery(name = "HistFuncionariosVinculos.findById", query = "SELECT h FROM HistFuncionariosVinculos h WHERE h.id = :id"),
    @NamedQuery(name = "HistFuncionariosVinculos.findByDtCadastro", query = "SELECT h FROM HistFuncionariosVinculos h WHERE h.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "HistFuncionariosVinculos.findByMotivoCadastro", query = "SELECT h FROM HistFuncionariosVinculos h WHERE h.motivoCadastro = :motivoCadastro"),
    @NamedQuery(name = "HistFuncionariosVinculos.findByDtCancelamento", query = "SELECT h FROM HistFuncionariosVinculos h WHERE h.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "HistFuncionariosVinculos.findByMotivoCancelamento", query = "SELECT h FROM HistFuncionariosVinculos h WHERE h.motivoCancelamento = :motivoCancelamento")})
public class HistFuncionariosVinculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "motivo_cadastro")
    private String motivoCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_vinculo_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vinculos idVinculoFk;

    public HistFuncionariosVinculos() {
    }

    public HistFuncionariosVinculos(Long id) {
        this.id = id;
    }

    public HistFuncionariosVinculos(Long id, Date dtCadastro) {
        this.id = id;
        this.dtCadastro = dtCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
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

    public PessoaFuncionarios getIdFuncionarioFk() {
        return idFuncionarioFk;
    }

    public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
        this.idFuncionarioFk = idFuncionarioFk;
    }

    public PessoaOperadores getIdOperadorCadastroFk() {
        return idOperadorCadastroFk;
    }

    public void setIdOperadorCadastroFk(PessoaOperadores idOperadorCadastroFk) {
        this.idOperadorCadastroFk = idOperadorCadastroFk;
    }

    public PessoaOperadores getIdOperadorCancelamentoFk() {
        return idOperadorCancelamentoFk;
    }

    public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
        this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
    }

    public Vinculos getIdVinculoFk() {
        return idVinculoFk;
    }

    public void setIdVinculoFk(Vinculos idVinculoFk) {
        this.idVinculoFk = idVinculoFk;
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
        if (!(object instanceof HistFuncionariosVinculos)) {
            return false;
        }
        HistFuncionariosVinculos other = (HistFuncionariosVinculos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.HistFuncionariosVinculos[ id=" + id + " ]";
    }
    
}
