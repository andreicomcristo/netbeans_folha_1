/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas5;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "pessoa_operadores")
@NamedQueries({
    @NamedQuery(name = "PessoaOperadores.findAll", query = "SELECT p FROM PessoaOperadores p"),
    @NamedQuery(name = "PessoaOperadores.findById", query = "SELECT p FROM PessoaOperadores p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaOperadores.findByDtCadastro", query = "SELECT p FROM PessoaOperadores p WHERE p.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "PessoaOperadores.findByDtCancelamento", query = "SELECT p FROM PessoaOperadores p WHERE p.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "PessoaOperadores.findByMotivoCancelamento", query = "SELECT p FROM PessoaOperadores p WHERE p.motivoCancelamento = :motivoCancelamento")})
public class PessoaOperadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<FuncionariosCapacitacoes> funcionariosCapacitacoesList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<FuncionariosCapacitacoes> funcionariosCapacitacoesList1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList1;
    @OneToMany(mappedBy = "idOperadorUltimaAlteracaoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList2;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<FuncionariosAnexos> funcionariosAnexosList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<FuncionariosAnexos> funcionariosAnexosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosClasse> histFuncionariosClasseList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosClasse> histFuncionariosClasseList1;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosCargos> histFuncionariosCargosList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosCargos> histFuncionariosCargosList1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<PessoaFilhos> pessoaFilhosList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<PessoaFilhos> pessoaFilhosList1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodosList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodosList1;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<PessoaOperadores> pessoaOperadoresList;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<PessoaOperadores> pessoaOperadoresList1;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_privilegio_fk", referencedColumnName = "id")
    @ManyToOne
    private Privilegios idPrivilegioFk;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<Unidades> unidadesList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<Unidades> unidadesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistUnidadesRegime> histUnidadesRegimeList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistUnidadesRegime> histUnidadesRegimeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorFk")
    private List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<Pessoa> pessoaList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<Pessoa> pessoaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosCarreira> histFuncionariosCarreiraList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosCarreira> histFuncionariosCarreiraList1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<FuncionariosFerias> funcionariosFeriasList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<FuncionariosFerias> funcionariosFeriasList1;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosSituacoes> histFuncionariosSituacoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosSituacoes> histFuncionariosSituacoesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCriacaoFk")
    private List<Autorizacoes> autorizacoesList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaOperadores")
    private UsersOperador usersOperador;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<PessoaBancos> pessoaBancosList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<PessoaBancos> pessoaBancosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosVinculos> histFuncionariosVinculosList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosVinculos> histFuncionariosVinculosList1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<HistUnidadesDiretor> histUnidadesDiretorList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistUnidadesDiretor> histUnidadesDiretorList1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList1;

    public PessoaOperadores() {
    }

    public PessoaOperadores(Long id) {
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

    public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoesList() {
        return funcionariosCapacitacoesList;
    }

    public void setFuncionariosCapacitacoesList(List<FuncionariosCapacitacoes> funcionariosCapacitacoesList) {
        this.funcionariosCapacitacoesList = funcionariosCapacitacoesList;
    }

    public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoesList1() {
        return funcionariosCapacitacoesList1;
    }

    public void setFuncionariosCapacitacoesList1(List<FuncionariosCapacitacoes> funcionariosCapacitacoesList1) {
        this.funcionariosCapacitacoesList1 = funcionariosCapacitacoesList1;
    }

    public List<FuncionariosLicencas> getFuncionariosLicencasList() {
        return funcionariosLicencasList;
    }

    public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
        this.funcionariosLicencasList = funcionariosLicencasList;
    }

    public List<FuncionariosLicencas> getFuncionariosLicencasList1() {
        return funcionariosLicencasList1;
    }

    public void setFuncionariosLicencasList1(List<FuncionariosLicencas> funcionariosLicencasList1) {
        this.funcionariosLicencasList1 = funcionariosLicencasList1;
    }

    public List<FuncionariosLicencas> getFuncionariosLicencasList2() {
        return funcionariosLicencasList2;
    }

    public void setFuncionariosLicencasList2(List<FuncionariosLicencas> funcionariosLicencasList2) {
        this.funcionariosLicencasList2 = funcionariosLicencasList2;
    }

    public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiraList() {
        return histFuncionariosNiveisCarreiraList;
    }

    public void setHistFuncionariosNiveisCarreiraList(List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList) {
        this.histFuncionariosNiveisCarreiraList = histFuncionariosNiveisCarreiraList;
    }

    public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiraList1() {
        return histFuncionariosNiveisCarreiraList1;
    }

    public void setHistFuncionariosNiveisCarreiraList1(List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList1) {
        this.histFuncionariosNiveisCarreiraList1 = histFuncionariosNiveisCarreiraList1;
    }

    public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoList() {
        return histFuncionariosAutorizacaoList;
    }

    public void setHistFuncionariosAutorizacaoList(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList) {
        this.histFuncionariosAutorizacaoList = histFuncionariosAutorizacaoList;
    }

    public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoList1() {
        return histFuncionariosAutorizacaoList1;
    }

    public void setHistFuncionariosAutorizacaoList1(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList1) {
        this.histFuncionariosAutorizacaoList1 = histFuncionariosAutorizacaoList1;
    }

    public List<FuncionariosAnexos> getFuncionariosAnexosList() {
        return funcionariosAnexosList;
    }

    public void setFuncionariosAnexosList(List<FuncionariosAnexos> funcionariosAnexosList) {
        this.funcionariosAnexosList = funcionariosAnexosList;
    }

    public List<FuncionariosAnexos> getFuncionariosAnexosList1() {
        return funcionariosAnexosList1;
    }

    public void setFuncionariosAnexosList1(List<FuncionariosAnexos> funcionariosAnexosList1) {
        this.funcionariosAnexosList1 = funcionariosAnexosList1;
    }

    public List<HistFuncionariosClasse> getHistFuncionariosClasseList() {
        return histFuncionariosClasseList;
    }

    public void setHistFuncionariosClasseList(List<HistFuncionariosClasse> histFuncionariosClasseList) {
        this.histFuncionariosClasseList = histFuncionariosClasseList;
    }

    public List<HistFuncionariosClasse> getHistFuncionariosClasseList1() {
        return histFuncionariosClasseList1;
    }

    public void setHistFuncionariosClasseList1(List<HistFuncionariosClasse> histFuncionariosClasseList1) {
        this.histFuncionariosClasseList1 = histFuncionariosClasseList1;
    }

    public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaList() {
        return histFuncionariosCargaHorariaList;
    }

    public void setHistFuncionariosCargaHorariaList(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList) {
        this.histFuncionariosCargaHorariaList = histFuncionariosCargaHorariaList;
    }

    public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaList1() {
        return histFuncionariosCargaHorariaList1;
    }

    public void setHistFuncionariosCargaHorariaList1(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList1) {
        this.histFuncionariosCargaHorariaList1 = histFuncionariosCargaHorariaList1;
    }

    public List<HistFuncionariosCargos> getHistFuncionariosCargosList() {
        return histFuncionariosCargosList;
    }

    public void setHistFuncionariosCargosList(List<HistFuncionariosCargos> histFuncionariosCargosList) {
        this.histFuncionariosCargosList = histFuncionariosCargosList;
    }

    public List<HistFuncionariosCargos> getHistFuncionariosCargosList1() {
        return histFuncionariosCargosList1;
    }

    public void setHistFuncionariosCargosList1(List<HistFuncionariosCargos> histFuncionariosCargosList1) {
        this.histFuncionariosCargosList1 = histFuncionariosCargosList1;
    }

    public List<PessoaFilhos> getPessoaFilhosList() {
        return pessoaFilhosList;
    }

    public void setPessoaFilhosList(List<PessoaFilhos> pessoaFilhosList) {
        this.pessoaFilhosList = pessoaFilhosList;
    }

    public List<PessoaFilhos> getPessoaFilhosList1() {
        return pessoaFilhosList1;
    }

    public void setPessoaFilhosList1(List<PessoaFilhos> pessoaFilhosList1) {
        this.pessoaFilhosList1 = pessoaFilhosList1;
    }

    public List<FuncionariosFeriasPeriodos> getFuncionariosFeriasPeriodosList() {
        return funcionariosFeriasPeriodosList;
    }

    public void setFuncionariosFeriasPeriodosList(List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodosList) {
        this.funcionariosFeriasPeriodosList = funcionariosFeriasPeriodosList;
    }

    public List<FuncionariosFeriasPeriodos> getFuncionariosFeriasPeriodosList1() {
        return funcionariosFeriasPeriodosList1;
    }

    public void setFuncionariosFeriasPeriodosList1(List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodosList1) {
        this.funcionariosFeriasPeriodosList1 = funcionariosFeriasPeriodosList1;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    public List<PessoaOperadores> getPessoaOperadoresList() {
        return pessoaOperadoresList;
    }

    public void setPessoaOperadoresList(List<PessoaOperadores> pessoaOperadoresList) {
        this.pessoaOperadoresList = pessoaOperadoresList;
    }

    public PessoaOperadores getIdOperadorCadastroFk() {
        return idOperadorCadastroFk;
    }

    public void setIdOperadorCadastroFk(PessoaOperadores idOperadorCadastroFk) {
        this.idOperadorCadastroFk = idOperadorCadastroFk;
    }

    public List<PessoaOperadores> getPessoaOperadoresList1() {
        return pessoaOperadoresList1;
    }

    public void setPessoaOperadoresList1(List<PessoaOperadores> pessoaOperadoresList1) {
        this.pessoaOperadoresList1 = pessoaOperadoresList1;
    }

    public PessoaOperadores getIdOperadorCancelamentoFk() {
        return idOperadorCancelamentoFk;
    }

    public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
        this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
    }

    public Privilegios getIdPrivilegioFk() {
        return idPrivilegioFk;
    }

    public void setIdPrivilegioFk(Privilegios idPrivilegioFk) {
        this.idPrivilegioFk = idPrivilegioFk;
    }

    public List<Unidades> getUnidadesList() {
        return unidadesList;
    }

    public void setUnidadesList(List<Unidades> unidadesList) {
        this.unidadesList = unidadesList;
    }

    public List<Unidades> getUnidadesList1() {
        return unidadesList1;
    }

    public void setUnidadesList1(List<Unidades> unidadesList1) {
        this.unidadesList1 = unidadesList1;
    }

    public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaList() {
        return histUnidadesNaturezaJuridicaList;
    }

    public void setHistUnidadesNaturezaJuridicaList(List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaList) {
        this.histUnidadesNaturezaJuridicaList = histUnidadesNaturezaJuridicaList;
    }

    public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaList1() {
        return histUnidadesNaturezaJuridicaList1;
    }

    public void setHistUnidadesNaturezaJuridicaList1(List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaList1) {
        this.histUnidadesNaturezaJuridicaList1 = histUnidadesNaturezaJuridicaList1;
    }

    public List<HistUnidadesRegime> getHistUnidadesRegimeList() {
        return histUnidadesRegimeList;
    }

    public void setHistUnidadesRegimeList(List<HistUnidadesRegime> histUnidadesRegimeList) {
        this.histUnidadesRegimeList = histUnidadesRegimeList;
    }

    public List<HistUnidadesRegime> getHistUnidadesRegimeList1() {
        return histUnidadesRegimeList1;
    }

    public void setHistUnidadesRegimeList1(List<HistUnidadesRegime> histUnidadesRegimeList1) {
        this.histUnidadesRegimeList1 = histUnidadesRegimeList1;
    }

    public List<AcessoOperadoresUnidades> getAcessoOperadoresUnidadesList() {
        return acessoOperadoresUnidadesList;
    }

    public void setAcessoOperadoresUnidadesList(List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList) {
        this.acessoOperadoresUnidadesList = acessoOperadoresUnidadesList;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public List<Pessoa> getPessoaList1() {
        return pessoaList1;
    }

    public void setPessoaList1(List<Pessoa> pessoaList1) {
        this.pessoaList1 = pessoaList1;
    }

    public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraList() {
        return histFuncionariosCarreiraList;
    }

    public void setHistFuncionariosCarreiraList(List<HistFuncionariosCarreira> histFuncionariosCarreiraList) {
        this.histFuncionariosCarreiraList = histFuncionariosCarreiraList;
    }

    public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraList1() {
        return histFuncionariosCarreiraList1;
    }

    public void setHistFuncionariosCarreiraList1(List<HistFuncionariosCarreira> histFuncionariosCarreiraList1) {
        this.histFuncionariosCarreiraList1 = histFuncionariosCarreiraList1;
    }

    public List<FuncionariosFerias> getFuncionariosFeriasList() {
        return funcionariosFeriasList;
    }

    public void setFuncionariosFeriasList(List<FuncionariosFerias> funcionariosFeriasList) {
        this.funcionariosFeriasList = funcionariosFeriasList;
    }

    public List<FuncionariosFerias> getFuncionariosFeriasList1() {
        return funcionariosFeriasList1;
    }

    public void setFuncionariosFeriasList1(List<FuncionariosFerias> funcionariosFeriasList1) {
        this.funcionariosFeriasList1 = funcionariosFeriasList1;
    }

    public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesList() {
        return histFuncionariosSituacoesList;
    }

    public void setHistFuncionariosSituacoesList(List<HistFuncionariosSituacoes> histFuncionariosSituacoesList) {
        this.histFuncionariosSituacoesList = histFuncionariosSituacoesList;
    }

    public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesList1() {
        return histFuncionariosSituacoesList1;
    }

    public void setHistFuncionariosSituacoesList1(List<HistFuncionariosSituacoes> histFuncionariosSituacoesList1) {
        this.histFuncionariosSituacoesList1 = histFuncionariosSituacoesList1;
    }

    public List<Autorizacoes> getAutorizacoesList() {
        return autorizacoesList;
    }

    public void setAutorizacoesList(List<Autorizacoes> autorizacoesList) {
        this.autorizacoesList = autorizacoesList;
    }

    public UsersOperador getUsersOperador() {
        return usersOperador;
    }

    public void setUsersOperador(UsersOperador usersOperador) {
        this.usersOperador = usersOperador;
    }

    public List<PessoaBancos> getPessoaBancosList() {
        return pessoaBancosList;
    }

    public void setPessoaBancosList(List<PessoaBancos> pessoaBancosList) {
        this.pessoaBancosList = pessoaBancosList;
    }

    public List<PessoaBancos> getPessoaBancosList1() {
        return pessoaBancosList1;
    }

    public void setPessoaBancosList1(List<PessoaBancos> pessoaBancosList1) {
        this.pessoaBancosList1 = pessoaBancosList1;
    }

    public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList() {
        return histFuncionariosVinculosList;
    }

    public void setHistFuncionariosVinculosList(List<HistFuncionariosVinculos> histFuncionariosVinculosList) {
        this.histFuncionariosVinculosList = histFuncionariosVinculosList;
    }

    public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList1() {
        return histFuncionariosVinculosList1;
    }

    public void setHistFuncionariosVinculosList1(List<HistFuncionariosVinculos> histFuncionariosVinculosList1) {
        this.histFuncionariosVinculosList1 = histFuncionariosVinculosList1;
    }

    public List<HistUnidadesDiretor> getHistUnidadesDiretorList() {
        return histUnidadesDiretorList;
    }

    public void setHistUnidadesDiretorList(List<HistUnidadesDiretor> histUnidadesDiretorList) {
        this.histUnidadesDiretorList = histUnidadesDiretorList;
    }

    public List<HistUnidadesDiretor> getHistUnidadesDiretorList1() {
        return histUnidadesDiretorList1;
    }

    public void setHistUnidadesDiretorList1(List<HistUnidadesDiretor> histUnidadesDiretorList1) {
        this.histUnidadesDiretorList1 = histUnidadesDiretorList1;
    }

    public List<PessoaFuncionarios> getPessoaFuncionariosList() {
        return pessoaFuncionariosList;
    }

    public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
        this.pessoaFuncionariosList = pessoaFuncionariosList;
    }

    public List<PessoaFuncionarios> getPessoaFuncionariosList1() {
        return pessoaFuncionariosList1;
    }

    public void setPessoaFuncionariosList1(List<PessoaFuncionarios> pessoaFuncionariosList1) {
        this.pessoaFuncionariosList1 = pessoaFuncionariosList1;
    }

    public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoList() {
        return histFuncionariosUnidadeLotacaoList;
    }

    public void setHistFuncionariosUnidadeLotacaoList(List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList) {
        this.histFuncionariosUnidadeLotacaoList = histFuncionariosUnidadeLotacaoList;
    }

    public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoList1() {
        return histFuncionariosUnidadeLotacaoList1;
    }

    public void setHistFuncionariosUnidadeLotacaoList1(List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList1) {
        this.histFuncionariosUnidadeLotacaoList1 = histFuncionariosUnidadeLotacaoList1;
    }

    public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoList() {
        return histFuncionariosUnidadeAtuacaoList;
    }

    public void setHistFuncionariosUnidadeAtuacaoList(List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList) {
        this.histFuncionariosUnidadeAtuacaoList = histFuncionariosUnidadeAtuacaoList;
    }

    public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoList1() {
        return histFuncionariosUnidadeAtuacaoList1;
    }

    public void setHistFuncionariosUnidadeAtuacaoList1(List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList1) {
        this.histFuncionariosUnidadeAtuacaoList1 = histFuncionariosUnidadeAtuacaoList1;
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
        if (!(object instanceof PessoaOperadores)) {
            return false;
        }
        PessoaOperadores other = (PessoaOperadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas5.PessoaOperadores[ id=" + id + " ]";
    }
    
}
