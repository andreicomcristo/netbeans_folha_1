/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "autorizacoes")
@NamedQueries({
    @NamedQuery(name = "Autorizacoes.findAll", query = "SELECT a FROM Autorizacoes a")})
public class Autorizacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dt_inicio")
    @Temporal(TemporalType.DATE)
    private Date dtInicio;
    @Column(name = "dt_fim")
    @Temporal(TemporalType.DATE)
    private Date dtFim;
    @Basic(optional = false)
    @Column(name = "id_carga_horaria_semanal_fk")
    private long idCargaHorariaSemanalFk;
    @Basic(optional = false)
    @Column(name = "dt_criacao")
    @Temporal(TemporalType.DATE)
    private Date dtCriacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutorizacaoFk")
    private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_criacao_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaOperadores idOperadorCriacaoFk;
    @JoinColumn(name = "id_unidade_de_saude_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeDeSaudeFk;

    public Autorizacoes() {
    }

    public Autorizacoes(Long id) {
        this.id = id;
    }

    public Autorizacoes(Long id, long idCargaHorariaSemanalFk, Date dtCriacao) {
        this.id = id;
        this.idCargaHorariaSemanalFk = idCargaHorariaSemanalFk;
        this.dtCriacao = dtCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public long getIdCargaHorariaSemanalFk() {
        return idCargaHorariaSemanalFk;
    }

    public void setIdCargaHorariaSemanalFk(long idCargaHorariaSemanalFk) {
        this.idCargaHorariaSemanalFk = idCargaHorariaSemanalFk;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoList() {
        return histFuncionariosAutorizacaoList;
    }

    public void setHistFuncionariosAutorizacaoList(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList) {
        this.histFuncionariosAutorizacaoList = histFuncionariosAutorizacaoList;
    }

    public PessoaFuncionarios getIdFuncionarioFk() {
        return idFuncionarioFk;
    }

    public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
        this.idFuncionarioFk = idFuncionarioFk;
    }

    public PessoaOperadores getIdOperadorCriacaoFk() {
        return idOperadorCriacaoFk;
    }

    public void setIdOperadorCriacaoFk(PessoaOperadores idOperadorCriacaoFk) {
        this.idOperadorCriacaoFk = idOperadorCriacaoFk;
    }

    public Unidades getIdUnidadeDeSaudeFk() {
        return idUnidadeDeSaudeFk;
    }

    public void setIdUnidadeDeSaudeFk(Unidades idUnidadeDeSaudeFk) {
        this.idUnidadeDeSaudeFk = idUnidadeDeSaudeFk;
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
        if (!(object instanceof Autorizacoes)) {
            return false;
        }
        Autorizacoes other = (Autorizacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.Autorizacoes[ id=" + id + " ]";
    }
    
}
