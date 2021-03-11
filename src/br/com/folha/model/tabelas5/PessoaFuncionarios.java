/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "pessoa_funcionarios")
@NamedQueries({
    @NamedQuery(name = "PessoaFuncionarios.findAll", query = "SELECT p FROM PessoaFuncionarios p"),
    @NamedQuery(name = "PessoaFuncionarios.findById", query = "SELECT p FROM PessoaFuncionarios p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaFuncionarios.findByMatricula", query = "SELECT p FROM PessoaFuncionarios p WHERE p.matricula = :matricula"),
    @NamedQuery(name = "PessoaFuncionarios.findByDtNomeacao", query = "SELECT p FROM PessoaFuncionarios p WHERE p.dtNomeacao = :dtNomeacao"),
    @NamedQuery(name = "PessoaFuncionarios.findByDtPosse", query = "SELECT p FROM PessoaFuncionarios p WHERE p.dtPosse = :dtPosse"),
    @NamedQuery(name = "PessoaFuncionarios.findByNumeroDeOrdem", query = "SELECT p FROM PessoaFuncionarios p WHERE p.numeroDeOrdem = :numeroDeOrdem"),
    @NamedQuery(name = "PessoaFuncionarios.findByNumeroDePonto", query = "SELECT p FROM PessoaFuncionarios p WHERE p.numeroDePonto = :numeroDePonto"),
    @NamedQuery(name = "PessoaFuncionarios.findByDtCadastro", query = "SELECT p FROM PessoaFuncionarios p WHERE p.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "PessoaFuncionarios.findByMotivoCadastro", query = "SELECT p FROM PessoaFuncionarios p WHERE p.motivoCadastro = :motivoCadastro"),
    @NamedQuery(name = "PessoaFuncionarios.findByDtCancelamento", query = "SELECT p FROM PessoaFuncionarios p WHERE p.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "PessoaFuncionarios.findByMotivoCancelamento", query = "SELECT p FROM PessoaFuncionarios p WHERE p.motivoCancelamento = :motivoCancelamento"),
    @NamedQuery(name = "PessoaFuncionarios.findByIdUnidadeLotacaoAtualFk", query = "SELECT p FROM PessoaFuncionarios p WHERE p.idUnidadeLotacaoAtualFk = :idUnidadeLotacaoAtualFk")})
public class PessoaFuncionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "dt_nomeacao")
    @Temporal(TemporalType.DATE)
    private Date dtNomeacao;
    @Column(name = "dt_posse")
    @Temporal(TemporalType.DATE)
    private Date dtPosse;
    @Column(name = "numero_de_ordem")
    private String numeroDeOrdem;
    @Column(name = "numero_de_ponto")
    private String numeroDePonto;
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
    @Column(name = "id_unidade_lotacao_atual_fk")
    private BigInteger idUnidadeLotacaoAtualFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<FuncionariosCapacitacoes> funcionariosCapacitacoesList;
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFuncionarioFk")
    private List<FuncionariosAnexos> funcionariosAnexosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosClasse> histFuncionariosClasseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCargos> histFuncionariosCargosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCarreira> histFuncionariosCarreiraList;
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<FuncionariosFerias> funcionariosFeriasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosSituacoes> histFuncionariosSituacoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<Autorizacoes> autorizacoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosVinculos> histFuncionariosVinculosList;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_carga_horaria_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private CargaHorariaSemanal idCargaHorariaAtualFk;
    @JoinColumn(name = "id_cargo_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Cargos idCargoAtualFk;
    @JoinColumn(name = "id_especialidade_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private CargosEspecialidade idEspecialidadeAtualFk;
    @JoinColumn(name = "id_carreira_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Carreiras idCarreiraAtualFk;
    @JoinColumn(name = "id_vinculo_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Vinculos idVinculoAtualFk;
    @JoinColumn(name = "id_classe_carreira_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private ClassesCarreira idClasseCarreiraAtualFk;
    @JoinColumn(name = "id_nivel_carreira_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private NiveisCarreira idNivelCarreiraAtualFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_situacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Situacoes idSituacaoAtualFk;
    @JoinColumn(name = "id_unidade_atuacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeAtuacaoAtualFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList;

    public PessoaFuncionarios() {
    }

    public PessoaFuncionarios(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDtNomeacao() {
        return dtNomeacao;
    }

    public void setDtNomeacao(Date dtNomeacao) {
        this.dtNomeacao = dtNomeacao;
    }

    public Date getDtPosse() {
        return dtPosse;
    }

    public void setDtPosse(Date dtPosse) {
        this.dtPosse = dtPosse;
    }

    public String getNumeroDeOrdem() {
        return numeroDeOrdem;
    }

    public void setNumeroDeOrdem(String numeroDeOrdem) {
        this.numeroDeOrdem = numeroDeOrdem;
    }

    public String getNumeroDePonto() {
        return numeroDePonto;
    }

    public void setNumeroDePonto(String numeroDePonto) {
        this.numeroDePonto = numeroDePonto;
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

    public BigInteger getIdUnidadeLotacaoAtualFk() {
        return idUnidadeLotacaoAtualFk;
    }

    public void setIdUnidadeLotacaoAtualFk(BigInteger idUnidadeLotacaoAtualFk) {
        this.idUnidadeLotacaoAtualFk = idUnidadeLotacaoAtualFk;
    }

    public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoesList() {
        return funcionariosCapacitacoesList;
    }

    public void setFuncionariosCapacitacoesList(List<FuncionariosCapacitacoes> funcionariosCapacitacoesList) {
        this.funcionariosCapacitacoesList = funcionariosCapacitacoesList;
    }

    public List<FuncionariosLicencas> getFuncionariosLicencasList() {
        return funcionariosLicencasList;
    }

    public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
        this.funcionariosLicencasList = funcionariosLicencasList;
    }

    public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiraList() {
        return histFuncionariosNiveisCarreiraList;
    }

    public void setHistFuncionariosNiveisCarreiraList(List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList) {
        this.histFuncionariosNiveisCarreiraList = histFuncionariosNiveisCarreiraList;
    }

    public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoList() {
        return histFuncionariosAutorizacaoList;
    }

    public void setHistFuncionariosAutorizacaoList(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList) {
        this.histFuncionariosAutorizacaoList = histFuncionariosAutorizacaoList;
    }

    public List<FuncionariosAnexos> getFuncionariosAnexosList() {
        return funcionariosAnexosList;
    }

    public void setFuncionariosAnexosList(List<FuncionariosAnexos> funcionariosAnexosList) {
        this.funcionariosAnexosList = funcionariosAnexosList;
    }

    public List<HistFuncionariosClasse> getHistFuncionariosClasseList() {
        return histFuncionariosClasseList;
    }

    public void setHistFuncionariosClasseList(List<HistFuncionariosClasse> histFuncionariosClasseList) {
        this.histFuncionariosClasseList = histFuncionariosClasseList;
    }

    public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaList() {
        return histFuncionariosCargaHorariaList;
    }

    public void setHistFuncionariosCargaHorariaList(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList) {
        this.histFuncionariosCargaHorariaList = histFuncionariosCargaHorariaList;
    }

    public List<HistFuncionariosCargos> getHistFuncionariosCargosList() {
        return histFuncionariosCargosList;
    }

    public void setHistFuncionariosCargosList(List<HistFuncionariosCargos> histFuncionariosCargosList) {
        this.histFuncionariosCargosList = histFuncionariosCargosList;
    }

    public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraList() {
        return histFuncionariosCarreiraList;
    }

    public void setHistFuncionariosCarreiraList(List<HistFuncionariosCarreira> histFuncionariosCarreiraList) {
        this.histFuncionariosCarreiraList = histFuncionariosCarreiraList;
    }

    public List<FuncionariosFerias> getFuncionariosFeriasList() {
        return funcionariosFeriasList;
    }

    public void setFuncionariosFeriasList(List<FuncionariosFerias> funcionariosFeriasList) {
        this.funcionariosFeriasList = funcionariosFeriasList;
    }

    public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesList() {
        return histFuncionariosSituacoesList;
    }

    public void setHistFuncionariosSituacoesList(List<HistFuncionariosSituacoes> histFuncionariosSituacoesList) {
        this.histFuncionariosSituacoesList = histFuncionariosSituacoesList;
    }

    public List<Autorizacoes> getAutorizacoesList() {
        return autorizacoesList;
    }

    public void setAutorizacoesList(List<Autorizacoes> autorizacoesList) {
        this.autorizacoesList = autorizacoesList;
    }

    public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList() {
        return histFuncionariosVinculosList;
    }

    public void setHistFuncionariosVinculosList(List<HistFuncionariosVinculos> histFuncionariosVinculosList) {
        this.histFuncionariosVinculosList = histFuncionariosVinculosList;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    public CargaHorariaSemanal getIdCargaHorariaAtualFk() {
        return idCargaHorariaAtualFk;
    }

    public void setIdCargaHorariaAtualFk(CargaHorariaSemanal idCargaHorariaAtualFk) {
        this.idCargaHorariaAtualFk = idCargaHorariaAtualFk;
    }

    public Cargos getIdCargoAtualFk() {
        return idCargoAtualFk;
    }

    public void setIdCargoAtualFk(Cargos idCargoAtualFk) {
        this.idCargoAtualFk = idCargoAtualFk;
    }

    public CargosEspecialidade getIdEspecialidadeAtualFk() {
        return idEspecialidadeAtualFk;
    }

    public void setIdEspecialidadeAtualFk(CargosEspecialidade idEspecialidadeAtualFk) {
        this.idEspecialidadeAtualFk = idEspecialidadeAtualFk;
    }

    public Carreiras getIdCarreiraAtualFk() {
        return idCarreiraAtualFk;
    }

    public void setIdCarreiraAtualFk(Carreiras idCarreiraAtualFk) {
        this.idCarreiraAtualFk = idCarreiraAtualFk;
    }

    public Vinculos getIdVinculoAtualFk() {
        return idVinculoAtualFk;
    }

    public void setIdVinculoAtualFk(Vinculos idVinculoAtualFk) {
        this.idVinculoAtualFk = idVinculoAtualFk;
    }

    public ClassesCarreira getIdClasseCarreiraAtualFk() {
        return idClasseCarreiraAtualFk;
    }

    public void setIdClasseCarreiraAtualFk(ClassesCarreira idClasseCarreiraAtualFk) {
        this.idClasseCarreiraAtualFk = idClasseCarreiraAtualFk;
    }

    public NiveisCarreira getIdNivelCarreiraAtualFk() {
        return idNivelCarreiraAtualFk;
    }

    public void setIdNivelCarreiraAtualFk(NiveisCarreira idNivelCarreiraAtualFk) {
        this.idNivelCarreiraAtualFk = idNivelCarreiraAtualFk;
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

    public Situacoes getIdSituacaoAtualFk() {
        return idSituacaoAtualFk;
    }

    public void setIdSituacaoAtualFk(Situacoes idSituacaoAtualFk) {
        this.idSituacaoAtualFk = idSituacaoAtualFk;
    }

    public Unidades getIdUnidadeAtuacaoAtualFk() {
        return idUnidadeAtuacaoAtualFk;
    }

    public void setIdUnidadeAtuacaoAtualFk(Unidades idUnidadeAtuacaoAtualFk) {
        this.idUnidadeAtuacaoAtualFk = idUnidadeAtuacaoAtualFk;
    }

    public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoList() {
        return histFuncionariosUnidadeAtuacaoList;
    }

    public void setHistFuncionariosUnidadeAtuacaoList(List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList) {
        this.histFuncionariosUnidadeAtuacaoList = histFuncionariosUnidadeAtuacaoList;
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
        if (!(object instanceof PessoaFuncionarios)) {
            return false;
        }
        PessoaFuncionarios other = (PessoaFuncionarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.PessoaFuncionarios[ id=" + id + " ]";
    }
    
}
