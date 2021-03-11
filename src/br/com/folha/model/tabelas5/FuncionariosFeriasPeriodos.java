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
@Table(name = "funcionarios_ferias_periodos")
@NamedQueries({
    @NamedQuery(name = "FuncionariosFeriasPeriodos.findAll", query = "SELECT f FROM FuncionariosFeriasPeriodos f"),
    @NamedQuery(name = "FuncionariosFeriasPeriodos.findById", query = "SELECT f FROM FuncionariosFeriasPeriodos f WHERE f.id = :id"),
    @NamedQuery(name = "FuncionariosFeriasPeriodos.findByDtInicial", query = "SELECT f FROM FuncionariosFeriasPeriodos f WHERE f.dtInicial = :dtInicial"),
    @NamedQuery(name = "FuncionariosFeriasPeriodos.findByDtFinal", query = "SELECT f FROM FuncionariosFeriasPeriodos f WHERE f.dtFinal = :dtFinal"),
    @NamedQuery(name = "FuncionariosFeriasPeriodos.findByDtAssinatura", query = "SELECT f FROM FuncionariosFeriasPeriodos f WHERE f.dtAssinatura = :dtAssinatura"),
    @NamedQuery(name = "FuncionariosFeriasPeriodos.findByDtCadastro", query = "SELECT f FROM FuncionariosFeriasPeriodos f WHERE f.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "FuncionariosFeriasPeriodos.findByDtCancelamento", query = "SELECT f FROM FuncionariosFeriasPeriodos f WHERE f.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "FuncionariosFeriasPeriodos.findByMotivoCancelamento", query = "SELECT f FROM FuncionariosFeriasPeriodos f WHERE f.motivoCancelamento = :motivoCancelamento")})
public class FuncionariosFeriasPeriodos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "dt_inicial")
    @Temporal(TemporalType.DATE)
    private Date dtInicial;
    @Basic(optional = false)
    @Column(name = "dt_final")
    @Temporal(TemporalType.DATE)
    private Date dtFinal;
    @Column(name = "dt_assinatura")
    @Temporal(TemporalType.DATE)
    private Date dtAssinatura;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @JoinColumn(name = "id_ferias_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FuncionariosFerias idFeriasFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;

    public FuncionariosFeriasPeriodos() {
    }

    public FuncionariosFeriasPeriodos(Long id) {
        this.id = id;
    }

    public FuncionariosFeriasPeriodos(Long id, Date dtInicial, Date dtFinal) {
        this.id = id;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(Date dtInicial) {
        this.dtInicial = dtInicial;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public Date getDtAssinatura() {
        return dtAssinatura;
    }

    public void setDtAssinatura(Date dtAssinatura) {
        this.dtAssinatura = dtAssinatura;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
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

    public FuncionariosFerias getIdFeriasFk() {
        return idFeriasFk;
    }

    public void setIdFeriasFk(FuncionariosFerias idFeriasFk) {
        this.idFeriasFk = idFeriasFk;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionariosFeriasPeriodos)) {
            return false;
        }
        FuncionariosFeriasPeriodos other = (FuncionariosFeriasPeriodos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.FuncionariosFeriasPeriodos[ id=" + id + " ]";
    }
    
}
