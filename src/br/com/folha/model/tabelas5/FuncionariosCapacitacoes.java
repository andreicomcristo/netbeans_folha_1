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
@Table(name = "funcionarios_capacitacoes")
@NamedQueries({
    @NamedQuery(name = "FuncionariosCapacitacoes.findAll", query = "SELECT f FROM FuncionariosCapacitacoes f"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findById", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.id = :id"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByDescricao", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByInstituicao", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.instituicao = :instituicao"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByCargaHoraria", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByDtInicial", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.dtInicial = :dtInicial"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByDtFinal", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.dtFinal = :dtFinal"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByObservacoes", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.observacoes = :observacoes"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByDtCadastro", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByDtCancelamento", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "FuncionariosCapacitacoes.findByMotivoCancelamento", query = "SELECT f FROM FuncionariosCapacitacoes f WHERE f.motivoCancelamento = :motivoCancelamento")})
public class FuncionariosCapacitacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "instituicao")
    private String instituicao;
    @Column(name = "carga_horaria")
    private Integer cargaHoraria;
    @Column(name = "dt_inicial")
    @Temporal(TemporalType.DATE)
    private Date dtInicial;
    @Column(name = "dt_final")
    @Temporal(TemporalType.DATE)
    private Date dtFinal;
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @JoinColumn(name = "id_area_de_capacitacao_fk", referencedColumnName = "id")
    @ManyToOne
    private AreasDeCapacitacao idAreaDeCapacitacaoFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_tipos_capacitacao_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposDeCapacitacao idTiposCapacitacaoFk;

    public FuncionariosCapacitacoes() {
    }

    public FuncionariosCapacitacoes(Long id) {
        this.id = id;
    }

    public FuncionariosCapacitacoes(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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

    public AreasDeCapacitacao getIdAreaDeCapacitacaoFk() {
        return idAreaDeCapacitacaoFk;
    }

    public void setIdAreaDeCapacitacaoFk(AreasDeCapacitacao idAreaDeCapacitacaoFk) {
        this.idAreaDeCapacitacaoFk = idAreaDeCapacitacaoFk;
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

    public TiposDeCapacitacao getIdTiposCapacitacaoFk() {
        return idTiposCapacitacaoFk;
    }

    public void setIdTiposCapacitacaoFk(TiposDeCapacitacao idTiposCapacitacaoFk) {
        this.idTiposCapacitacaoFk = idTiposCapacitacaoFk;
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
        if (!(object instanceof FuncionariosCapacitacoes)) {
            return false;
        }
        FuncionariosCapacitacoes other = (FuncionariosCapacitacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.FuncionariosCapacitacoes[ id=" + id + " ]";
    }
    
}
