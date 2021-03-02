/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "funcionarios_licencas")
@NamedQueries({
    @NamedQuery(name = "FuncionariosLicencas.findAll", query = "SELECT f FROM FuncionariosLicencas f")})
public class FuncionariosLicencas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dt_inicial")
    @Temporal(TemporalType.DATE)
    private Date dtInicial;
    @Column(name = "dt_final")
    @Temporal(TemporalType.DATE)
    private Date dtFinal;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_ultima_alteracao")
    @Temporal(TemporalType.DATE)
    private Date dtUltimaAlteracao;
    @Column(name = "corte_folha_extra")
    private String corteFolhaExtra;
    @Column(name = "corte_folha_efetiva")
    private String corteFolhaEfetiva;
    @Column(name = "dt_previdencia")
    @Temporal(TemporalType.DATE)
    private Date dtPrevidencia;
    @Column(name = "dt_publicacao_diario_oficial")
    @Temporal(TemporalType.DATE)
    private Date dtPublicacaoDiarioOficial;
    @Column(name = "dt_inicial_original")
    @Temporal(TemporalType.DATE)
    private Date dtInicialOriginal;
    @Column(name = "dt_final_original")
    @Temporal(TemporalType.DATE)
    private Date dtFinalOriginal;
    @Column(name = "pendencia_exame_comprobatorio")
    private String pendenciaExameComprobatorio;
    @Column(name = "observacoes")
    private String observacoes;
    @Lob
    @Column(name = "anexo")
    private byte[] anexo;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @JoinColumn(name = "id_cargo_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Cargos idCargoAtualFk;
    @JoinColumn(name = "id_cargo_especialidade_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private CargosEspecialidade idCargoEspecialidadeAtualFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_operador_ultima_alteracao_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorUltimaAlteracaoFk;
    @JoinColumn(name = "id_tipo_licenca_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeLicenca idTipoLicencaFk;
    @JoinColumn(name = "id_unidade_atuacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeAtuacaoAtualFk;
    @JoinColumn(name = "id_unidade_lotacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeLotacaoAtualFk;
    @JoinColumn(name = "id_vinculo_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Vinculos idVinculoAtualFk;

    public FuncionariosLicencas() {
    }

    public FuncionariosLicencas(Long id) {
        this.id = id;
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

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtUltimaAlteracao() {
        return dtUltimaAlteracao;
    }

    public void setDtUltimaAlteracao(Date dtUltimaAlteracao) {
        this.dtUltimaAlteracao = dtUltimaAlteracao;
    }

    public String getCorteFolhaExtra() {
        return corteFolhaExtra;
    }

    public void setCorteFolhaExtra(String corteFolhaExtra) {
        this.corteFolhaExtra = corteFolhaExtra;
    }

    public String getCorteFolhaEfetiva() {
        return corteFolhaEfetiva;
    }

    public void setCorteFolhaEfetiva(String corteFolhaEfetiva) {
        this.corteFolhaEfetiva = corteFolhaEfetiva;
    }

    public Date getDtPrevidencia() {
        return dtPrevidencia;
    }

    public void setDtPrevidencia(Date dtPrevidencia) {
        this.dtPrevidencia = dtPrevidencia;
    }

    public Date getDtPublicacaoDiarioOficial() {
        return dtPublicacaoDiarioOficial;
    }

    public void setDtPublicacaoDiarioOficial(Date dtPublicacaoDiarioOficial) {
        this.dtPublicacaoDiarioOficial = dtPublicacaoDiarioOficial;
    }

    public Date getDtInicialOriginal() {
        return dtInicialOriginal;
    }

    public void setDtInicialOriginal(Date dtInicialOriginal) {
        this.dtInicialOriginal = dtInicialOriginal;
    }

    public Date getDtFinalOriginal() {
        return dtFinalOriginal;
    }

    public void setDtFinalOriginal(Date dtFinalOriginal) {
        this.dtFinalOriginal = dtFinalOriginal;
    }

    public String getPendenciaExameComprobatorio() {
        return pendenciaExameComprobatorio;
    }

    public void setPendenciaExameComprobatorio(String pendenciaExameComprobatorio) {
        this.pendenciaExameComprobatorio = pendenciaExameComprobatorio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
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

    public Cargos getIdCargoAtualFk() {
        return idCargoAtualFk;
    }

    public void setIdCargoAtualFk(Cargos idCargoAtualFk) {
        this.idCargoAtualFk = idCargoAtualFk;
    }

    public CargosEspecialidade getIdCargoEspecialidadeAtualFk() {
        return idCargoEspecialidadeAtualFk;
    }

    public void setIdCargoEspecialidadeAtualFk(CargosEspecialidade idCargoEspecialidadeAtualFk) {
        this.idCargoEspecialidadeAtualFk = idCargoEspecialidadeAtualFk;
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

    public PessoaOperadores getIdOperadorUltimaAlteracaoFk() {
        return idOperadorUltimaAlteracaoFk;
    }

    public void setIdOperadorUltimaAlteracaoFk(PessoaOperadores idOperadorUltimaAlteracaoFk) {
        this.idOperadorUltimaAlteracaoFk = idOperadorUltimaAlteracaoFk;
    }

    public TiposDeLicenca getIdTipoLicencaFk() {
        return idTipoLicencaFk;
    }

    public void setIdTipoLicencaFk(TiposDeLicenca idTipoLicencaFk) {
        this.idTipoLicencaFk = idTipoLicencaFk;
    }

    public Unidades getIdUnidadeAtuacaoAtualFk() {
        return idUnidadeAtuacaoAtualFk;
    }

    public void setIdUnidadeAtuacaoAtualFk(Unidades idUnidadeAtuacaoAtualFk) {
        this.idUnidadeAtuacaoAtualFk = idUnidadeAtuacaoAtualFk;
    }

    public Unidades getIdUnidadeLotacaoAtualFk() {
        return idUnidadeLotacaoAtualFk;
    }

    public void setIdUnidadeLotacaoAtualFk(Unidades idUnidadeLotacaoAtualFk) {
        this.idUnidadeLotacaoAtualFk = idUnidadeLotacaoAtualFk;
    }

    public Vinculos getIdVinculoAtualFk() {
        return idVinculoAtualFk;
    }

    public void setIdVinculoAtualFk(Vinculos idVinculoAtualFk) {
        this.idVinculoAtualFk = idVinculoAtualFk;
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
        if (!(object instanceof FuncionariosLicencas)) {
            return false;
        }
        FuncionariosLicencas other = (FuncionariosLicencas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.FuncionariosLicencas[ id=" + id + " ]";
    }
    
}
