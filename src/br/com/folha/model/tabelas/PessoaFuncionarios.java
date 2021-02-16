/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
    @NamedQuery(name = "PessoaFuncionarios.findByMotivoCancelamento", query = "SELECT p FROM PessoaFuncionarios p WHERE p.motivoCancelamento = :motivoCancelamento")})
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
    @OneToMany(mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosClasse> histFuncionariosClasseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosCargos> histFuncionariosCargosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<Autorizacoes> autorizacoesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection;

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

    public Collection<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiraCollection() {
        return histFuncionariosNiveisCarreiraCollection;
    }

    public void setHistFuncionariosNiveisCarreiraCollection(Collection<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraCollection) {
        this.histFuncionariosNiveisCarreiraCollection = histFuncionariosNiveisCarreiraCollection;
    }

    public Collection<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoCollection() {
        return histFuncionariosAutorizacaoCollection;
    }

    public void setHistFuncionariosAutorizacaoCollection(Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection) {
        this.histFuncionariosAutorizacaoCollection = histFuncionariosAutorizacaoCollection;
    }

    public Collection<HistFuncionariosClasse> getHistFuncionariosClasseCollection() {
        return histFuncionariosClasseCollection;
    }

    public void setHistFuncionariosClasseCollection(Collection<HistFuncionariosClasse> histFuncionariosClasseCollection) {
        this.histFuncionariosClasseCollection = histFuncionariosClasseCollection;
    }

    public Collection<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaCollection() {
        return histFuncionariosCargaHorariaCollection;
    }

    public void setHistFuncionariosCargaHorariaCollection(Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection) {
        this.histFuncionariosCargaHorariaCollection = histFuncionariosCargaHorariaCollection;
    }

    public Collection<HistFuncionariosCargos> getHistFuncionariosCargosCollection() {
        return histFuncionariosCargosCollection;
    }

    public void setHistFuncionariosCargosCollection(Collection<HistFuncionariosCargos> histFuncionariosCargosCollection) {
        this.histFuncionariosCargosCollection = histFuncionariosCargosCollection;
    }

    public Collection<HistFuncionariosCarreira> getHistFuncionariosCarreiraCollection() {
        return histFuncionariosCarreiraCollection;
    }

    public void setHistFuncionariosCarreiraCollection(Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection) {
        this.histFuncionariosCarreiraCollection = histFuncionariosCarreiraCollection;
    }

    public Collection<HistFuncionariosSituacoes> getHistFuncionariosSituacoesCollection() {
        return histFuncionariosSituacoesCollection;
    }

    public void setHistFuncionariosSituacoesCollection(Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection) {
        this.histFuncionariosSituacoesCollection = histFuncionariosSituacoesCollection;
    }

    public Collection<Autorizacoes> getAutorizacoesCollection() {
        return autorizacoesCollection;
    }

    public void setAutorizacoesCollection(Collection<Autorizacoes> autorizacoesCollection) {
        this.autorizacoesCollection = autorizacoesCollection;
    }

    public Collection<HistFuncionariosVinculos> getHistFuncionariosVinculosCollection() {
        return histFuncionariosVinculosCollection;
    }

    public void setHistFuncionariosVinculosCollection(Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection) {
        this.histFuncionariosVinculosCollection = histFuncionariosVinculosCollection;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
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

    public Collection<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoCollection() {
        return histFuncionariosUnidadeAtuacaoCollection;
    }

    public void setHistFuncionariosUnidadeAtuacaoCollection(Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection) {
        this.histFuncionariosUnidadeAtuacaoCollection = histFuncionariosUnidadeAtuacaoCollection;
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
        return "br.com.folha.model.tabelas.PessoaFuncionarios[ id=" + id + " ]";
    }
    
}
