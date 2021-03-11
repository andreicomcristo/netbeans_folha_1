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
@Table(name = "hist_funcionarios_niveis_carreira")
@NamedQueries({
    @NamedQuery(name = "HistFuncionariosNiveisCarreira.findAll", query = "SELECT h FROM HistFuncionariosNiveisCarreira h"),
    @NamedQuery(name = "HistFuncionariosNiveisCarreira.findById", query = "SELECT h FROM HistFuncionariosNiveisCarreira h WHERE h.id = :id"),
    @NamedQuery(name = "HistFuncionariosNiveisCarreira.findByDtCadastro", query = "SELECT h FROM HistFuncionariosNiveisCarreira h WHERE h.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "HistFuncionariosNiveisCarreira.findByMotivoCadastro", query = "SELECT h FROM HistFuncionariosNiveisCarreira h WHERE h.motivoCadastro = :motivoCadastro"),
    @NamedQuery(name = "HistFuncionariosNiveisCarreira.findByDtCancelamento", query = "SELECT h FROM HistFuncionariosNiveisCarreira h WHERE h.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "HistFuncionariosNiveisCarreira.findByMotivoCancelamento", query = "SELECT h FROM HistFuncionariosNiveisCarreira h WHERE h.motivoCancelamento = :motivoCancelamento")})
public class HistFuncionariosNiveisCarreira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
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
    @JoinColumn(name = "id_nivel_carreira_fk", referencedColumnName = "id")
    @ManyToOne
    private NiveisCarreira idNivelCarreiraFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;

    public HistFuncionariosNiveisCarreira() {
    }

    public HistFuncionariosNiveisCarreira(Long id) {
        this.id = id;
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

    public NiveisCarreira getIdNivelCarreiraFk() {
        return idNivelCarreiraFk;
    }

    public void setIdNivelCarreiraFk(NiveisCarreira idNivelCarreiraFk) {
        this.idNivelCarreiraFk = idNivelCarreiraFk;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistFuncionariosNiveisCarreira)) {
            return false;
        }
        HistFuncionariosNiveisCarreira other = (HistFuncionariosNiveisCarreira) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.HistFuncionariosNiveisCarreira[ id=" + id + " ]";
    }
    
}
