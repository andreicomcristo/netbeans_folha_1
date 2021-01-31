/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "pessoa_operadores")
@NamedQueries({
    @NamedQuery(name = "PessoaOperadores.findAll", query = "SELECT p FROM PessoaOperadores p"),
    @NamedQuery(name = "PessoaOperadores.findById", query = "SELECT p FROM PessoaOperadores p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaOperadores.findBySenha", query = "SELECT p FROM PessoaOperadores p WHERE p.senha = :senha"),
    @NamedQuery(name = "PessoaOperadores.findByDtCadastro", query = "SELECT p FROM PessoaOperadores p WHERE p.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "PessoaOperadores.findByIdOperadorCadastroFk", query = "SELECT p FROM PessoaOperadores p WHERE p.idOperadorCadastroFk = :idOperadorCadastroFk"),
    @NamedQuery(name = "PessoaOperadores.findByDtCancelamento", query = "SELECT p FROM PessoaOperadores p WHERE p.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "PessoaOperadores.findByIdOperadorCancelamentoFk", query = "SELECT p FROM PessoaOperadores p WHERE p.idOperadorCancelamentoFk = :idOperadorCancelamentoFk"),
    @NamedQuery(name = "PessoaOperadores.findByMotivoCancelamento", query = "SELECT p FROM PessoaOperadores p WHERE p.motivoCancelamento = :motivoCancelamento")})
public class PessoaOperadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "senha", nullable = false, length = 300)
    private String senha;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "id_operador_cadastro_fk")
    private BigInteger idOperadorCadastroFk;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "id_operador_cancelamento_fk")
    private BigInteger idOperadorCancelamentoFk;
    @Column(name = "motivo_cancelamento", length = 500)
    private String motivoCancelamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosClasse> histFuncionariosClasseCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosClasse> histFuncionariosClasseCollection1;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosCargos> histFuncionariosCargosCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosCargos> histFuncionariosCargosCollection1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private Collection<PessoaFilhos> pessoaFilhosCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<PessoaFilhos> pessoaFilhosCollection1;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    @JoinColumn(name = "seq_privilegio", referencedColumnName = "id")
    @ManyToOne
    private Privilegios seqPrivilegio;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private Collection<Unidades> unidadesCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<Unidades> unidadesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistUnidadesRegime> histUnidadesRegimeCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistUnidadesRegime> histUnidadesRegimeCollection1;
    @OneToMany(mappedBy = "seqOperadorCadastro")
    private Collection<Pessoa> pessoaCollection;
    @OneToMany(mappedBy = "seqOperadorCancelamento")
    private Collection<Pessoa> pessoaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection1;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCriacaoFk")
    private Collection<Autorizacoes> autorizacoesCollection;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private Collection<PessoaBancos> pessoaBancosCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<PessoaBancos> pessoaBancosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaOperadores")
    private Collection<HistUnidadesDiretor> histUnidadesDiretorCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistUnidadesDiretor> histUnidadesDiretorCollection1;
    @OneToMany(mappedBy = "idOperadorCadastroFk")
    private Collection<PessoaFuncionarios> pessoaFuncionariosCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<PessoaFuncionarios> pessoaFuncionariosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
    private Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection;
    @OneToMany(mappedBy = "idOperadorCancelamentoFk")
    private Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection1;

    public PessoaOperadores() {
    }

    public PessoaOperadores(Long id) {
        this.id = id;
    }

    public PessoaOperadores(Long id, String senha) {
        this.id = id;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public BigInteger getIdOperadorCadastroFk() {
        return idOperadorCadastroFk;
    }

    public void setIdOperadorCadastroFk(BigInteger idOperadorCadastroFk) {
        this.idOperadorCadastroFk = idOperadorCadastroFk;
    }

    public Date getDtCancelamento() {
        return dtCancelamento;
    }

    public void setDtCancelamento(Date dtCancelamento) {
        this.dtCancelamento = dtCancelamento;
    }

    public BigInteger getIdOperadorCancelamentoFk() {
        return idOperadorCancelamentoFk;
    }

    public void setIdOperadorCancelamentoFk(BigInteger idOperadorCancelamentoFk) {
        this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public Collection<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoCollection() {
        return histFuncionariosAutorizacaoCollection;
    }

    public void setHistFuncionariosAutorizacaoCollection(Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection) {
        this.histFuncionariosAutorizacaoCollection = histFuncionariosAutorizacaoCollection;
    }

    public Collection<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoCollection1() {
        return histFuncionariosAutorizacaoCollection1;
    }

    public void setHistFuncionariosAutorizacaoCollection1(Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection1) {
        this.histFuncionariosAutorizacaoCollection1 = histFuncionariosAutorizacaoCollection1;
    }

    public Collection<HistFuncionariosClasse> getHistFuncionariosClasseCollection() {
        return histFuncionariosClasseCollection;
    }

    public void setHistFuncionariosClasseCollection(Collection<HistFuncionariosClasse> histFuncionariosClasseCollection) {
        this.histFuncionariosClasseCollection = histFuncionariosClasseCollection;
    }

    public Collection<HistFuncionariosClasse> getHistFuncionariosClasseCollection1() {
        return histFuncionariosClasseCollection1;
    }

    public void setHistFuncionariosClasseCollection1(Collection<HistFuncionariosClasse> histFuncionariosClasseCollection1) {
        this.histFuncionariosClasseCollection1 = histFuncionariosClasseCollection1;
    }

    public Collection<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaCollection() {
        return histFuncionariosCargaHorariaCollection;
    }

    public void setHistFuncionariosCargaHorariaCollection(Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection) {
        this.histFuncionariosCargaHorariaCollection = histFuncionariosCargaHorariaCollection;
    }

    public Collection<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaCollection1() {
        return histFuncionariosCargaHorariaCollection1;
    }

    public void setHistFuncionariosCargaHorariaCollection1(Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection1) {
        this.histFuncionariosCargaHorariaCollection1 = histFuncionariosCargaHorariaCollection1;
    }

    public Collection<HistFuncionariosCargos> getHistFuncionariosCargosCollection() {
        return histFuncionariosCargosCollection;
    }

    public void setHistFuncionariosCargosCollection(Collection<HistFuncionariosCargos> histFuncionariosCargosCollection) {
        this.histFuncionariosCargosCollection = histFuncionariosCargosCollection;
    }

    public Collection<HistFuncionariosCargos> getHistFuncionariosCargosCollection1() {
        return histFuncionariosCargosCollection1;
    }

    public void setHistFuncionariosCargosCollection1(Collection<HistFuncionariosCargos> histFuncionariosCargosCollection1) {
        this.histFuncionariosCargosCollection1 = histFuncionariosCargosCollection1;
    }

    public Collection<PessoaFilhos> getPessoaFilhosCollection() {
        return pessoaFilhosCollection;
    }

    public void setPessoaFilhosCollection(Collection<PessoaFilhos> pessoaFilhosCollection) {
        this.pessoaFilhosCollection = pessoaFilhosCollection;
    }

    public Collection<PessoaFilhos> getPessoaFilhosCollection1() {
        return pessoaFilhosCollection1;
    }

    public void setPessoaFilhosCollection1(Collection<PessoaFilhos> pessoaFilhosCollection1) {
        this.pessoaFilhosCollection1 = pessoaFilhosCollection1;
    }

    public Pessoa getIdPessoaFk() {
        return idPessoaFk;
    }

    public void setIdPessoaFk(Pessoa idPessoaFk) {
        this.idPessoaFk = idPessoaFk;
    }

    public Privilegios getSeqPrivilegio() {
        return seqPrivilegio;
    }

    public void setSeqPrivilegio(Privilegios seqPrivilegio) {
        this.seqPrivilegio = seqPrivilegio;
    }

    public Collection<Unidades> getUnidadesCollection() {
        return unidadesCollection;
    }

    public void setUnidadesCollection(Collection<Unidades> unidadesCollection) {
        this.unidadesCollection = unidadesCollection;
    }

    public Collection<Unidades> getUnidadesCollection1() {
        return unidadesCollection1;
    }

    public void setUnidadesCollection1(Collection<Unidades> unidadesCollection1) {
        this.unidadesCollection1 = unidadesCollection1;
    }

    public Collection<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaCollection() {
        return histUnidadesNaturezaJuridicaCollection;
    }

    public void setHistUnidadesNaturezaJuridicaCollection(Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection) {
        this.histUnidadesNaturezaJuridicaCollection = histUnidadesNaturezaJuridicaCollection;
    }

    public Collection<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaCollection1() {
        return histUnidadesNaturezaJuridicaCollection1;
    }

    public void setHistUnidadesNaturezaJuridicaCollection1(Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection1) {
        this.histUnidadesNaturezaJuridicaCollection1 = histUnidadesNaturezaJuridicaCollection1;
    }

    public Collection<HistUnidadesRegime> getHistUnidadesRegimeCollection() {
        return histUnidadesRegimeCollection;
    }

    public void setHistUnidadesRegimeCollection(Collection<HistUnidadesRegime> histUnidadesRegimeCollection) {
        this.histUnidadesRegimeCollection = histUnidadesRegimeCollection;
    }

    public Collection<HistUnidadesRegime> getHistUnidadesRegimeCollection1() {
        return histUnidadesRegimeCollection1;
    }

    public void setHistUnidadesRegimeCollection1(Collection<HistUnidadesRegime> histUnidadesRegimeCollection1) {
        this.histUnidadesRegimeCollection1 = histUnidadesRegimeCollection1;
    }

    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    public Collection<Pessoa> getPessoaCollection1() {
        return pessoaCollection1;
    }

    public void setPessoaCollection1(Collection<Pessoa> pessoaCollection1) {
        this.pessoaCollection1 = pessoaCollection1;
    }

    public Collection<HistFuncionariosCarreira> getHistFuncionariosCarreiraCollection() {
        return histFuncionariosCarreiraCollection;
    }

    public void setHistFuncionariosCarreiraCollection(Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection) {
        this.histFuncionariosCarreiraCollection = histFuncionariosCarreiraCollection;
    }

    public Collection<HistFuncionariosCarreira> getHistFuncionariosCarreiraCollection1() {
        return histFuncionariosCarreiraCollection1;
    }

    public void setHistFuncionariosCarreiraCollection1(Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection1) {
        this.histFuncionariosCarreiraCollection1 = histFuncionariosCarreiraCollection1;
    }

    public Collection<HistFuncionariosSituacoes> getHistFuncionariosSituacoesCollection() {
        return histFuncionariosSituacoesCollection;
    }

    public void setHistFuncionariosSituacoesCollection(Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection) {
        this.histFuncionariosSituacoesCollection = histFuncionariosSituacoesCollection;
    }

    public Collection<HistFuncionariosSituacoes> getHistFuncionariosSituacoesCollection1() {
        return histFuncionariosSituacoesCollection1;
    }

    public void setHistFuncionariosSituacoesCollection1(Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection1) {
        this.histFuncionariosSituacoesCollection1 = histFuncionariosSituacoesCollection1;
    }

    public Collection<Autorizacoes> getAutorizacoesCollection() {
        return autorizacoesCollection;
    }

    public void setAutorizacoesCollection(Collection<Autorizacoes> autorizacoesCollection) {
        this.autorizacoesCollection = autorizacoesCollection;
    }

    public Collection<PessoaBancos> getPessoaBancosCollection() {
        return pessoaBancosCollection;
    }

    public void setPessoaBancosCollection(Collection<PessoaBancos> pessoaBancosCollection) {
        this.pessoaBancosCollection = pessoaBancosCollection;
    }

    public Collection<PessoaBancos> getPessoaBancosCollection1() {
        return pessoaBancosCollection1;
    }

    public void setPessoaBancosCollection1(Collection<PessoaBancos> pessoaBancosCollection1) {
        this.pessoaBancosCollection1 = pessoaBancosCollection1;
    }

    public Collection<HistFuncionariosVinculos> getHistFuncionariosVinculosCollection() {
        return histFuncionariosVinculosCollection;
    }

    public void setHistFuncionariosVinculosCollection(Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection) {
        this.histFuncionariosVinculosCollection = histFuncionariosVinculosCollection;
    }

    public Collection<HistFuncionariosVinculos> getHistFuncionariosVinculosCollection1() {
        return histFuncionariosVinculosCollection1;
    }

    public void setHistFuncionariosVinculosCollection1(Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection1) {
        this.histFuncionariosVinculosCollection1 = histFuncionariosVinculosCollection1;
    }

    public Collection<HistUnidadesDiretor> getHistUnidadesDiretorCollection() {
        return histUnidadesDiretorCollection;
    }

    public void setHistUnidadesDiretorCollection(Collection<HistUnidadesDiretor> histUnidadesDiretorCollection) {
        this.histUnidadesDiretorCollection = histUnidadesDiretorCollection;
    }

    public Collection<HistUnidadesDiretor> getHistUnidadesDiretorCollection1() {
        return histUnidadesDiretorCollection1;
    }

    public void setHistUnidadesDiretorCollection1(Collection<HistUnidadesDiretor> histUnidadesDiretorCollection1) {
        this.histUnidadesDiretorCollection1 = histUnidadesDiretorCollection1;
    }

    public Collection<PessoaFuncionarios> getPessoaFuncionariosCollection() {
        return pessoaFuncionariosCollection;
    }

    public void setPessoaFuncionariosCollection(Collection<PessoaFuncionarios> pessoaFuncionariosCollection) {
        this.pessoaFuncionariosCollection = pessoaFuncionariosCollection;
    }

    public Collection<PessoaFuncionarios> getPessoaFuncionariosCollection1() {
        return pessoaFuncionariosCollection1;
    }

    public void setPessoaFuncionariosCollection1(Collection<PessoaFuncionarios> pessoaFuncionariosCollection1) {
        this.pessoaFuncionariosCollection1 = pessoaFuncionariosCollection1;
    }

    public Collection<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoCollection() {
        return histFuncionariosUnidadeLotacaoCollection;
    }

    public void setHistFuncionariosUnidadeLotacaoCollection(Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection) {
        this.histFuncionariosUnidadeLotacaoCollection = histFuncionariosUnidadeLotacaoCollection;
    }

    public Collection<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoCollection1() {
        return histFuncionariosUnidadeLotacaoCollection1;
    }

    public void setHistFuncionariosUnidadeLotacaoCollection1(Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection1) {
        this.histFuncionariosUnidadeLotacaoCollection1 = histFuncionariosUnidadeLotacaoCollection1;
    }

    public Collection<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoCollection() {
        return histFuncionariosUnidadeAtuacaoCollection;
    }

    public void setHistFuncionariosUnidadeAtuacaoCollection(Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection) {
        this.histFuncionariosUnidadeAtuacaoCollection = histFuncionariosUnidadeAtuacaoCollection;
    }

    public Collection<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoCollection1() {
        return histFuncionariosUnidadeAtuacaoCollection1;
    }

    public void setHistFuncionariosUnidadeAtuacaoCollection1(Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection1) {
        this.histFuncionariosUnidadeAtuacaoCollection1 = histFuncionariosUnidadeAtuacaoCollection1;
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
        return "br.com.folha.model.tabelas.PessoaOperadores[ id=" + id + " ]";
    }
    
}
