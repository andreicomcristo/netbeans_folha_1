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
@Table(name = "unidades")
@NamedQueries({
    @NamedQuery(name = "Unidades.findAll", query = "SELECT u FROM Unidades u"),
    @NamedQuery(name = "Unidades.findById", query = "SELECT u FROM Unidades u WHERE u.id = :id"),
    @NamedQuery(name = "Unidades.findByNomeFantasia", query = "SELECT u FROM Unidades u WHERE u.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Unidades.findByNomeEmpresarial", query = "SELECT u FROM Unidades u WHERE u.nomeEmpresarial = :nomeEmpresarial"),
    @NamedQuery(name = "Unidades.findByCnes", query = "SELECT u FROM Unidades u WHERE u.cnes = :cnes"),
    @NamedQuery(name = "Unidades.findByIdNaturezaJuridicaFk", query = "SELECT u FROM Unidades u WHERE u.idNaturezaJuridicaFk = :idNaturezaJuridicaFk"),
    @NamedQuery(name = "Unidades.findByIdEnderecoUnidadeFk", query = "SELECT u FROM Unidades u WHERE u.idEnderecoUnidadeFk = :idEnderecoUnidadeFk"),
    @NamedQuery(name = "Unidades.findByFone1", query = "SELECT u FROM Unidades u WHERE u.fone1 = :fone1"),
    @NamedQuery(name = "Unidades.findByEnderecoLogradouro", query = "SELECT u FROM Unidades u WHERE u.enderecoLogradouro = :enderecoLogradouro"),
    @NamedQuery(name = "Unidades.findByEnderecoNumero", query = "SELECT u FROM Unidades u WHERE u.enderecoNumero = :enderecoNumero"),
    @NamedQuery(name = "Unidades.findByEnderecoComplemento", query = "SELECT u FROM Unidades u WHERE u.enderecoComplemento = :enderecoComplemento"),
    @NamedQuery(name = "Unidades.findByEnderecoBairro", query = "SELECT u FROM Unidades u WHERE u.enderecoBairro = :enderecoBairro"),
    @NamedQuery(name = "Unidades.findByEnderecoCep", query = "SELECT u FROM Unidades u WHERE u.enderecoCep = :enderecoCep"),
    @NamedQuery(name = "Unidades.findByDtCadastro", query = "SELECT u FROM Unidades u WHERE u.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Unidades.findByMotivoCadastro", query = "SELECT u FROM Unidades u WHERE u.motivoCadastro = :motivoCadastro"),
    @NamedQuery(name = "Unidades.findByDtCancelamento", query = "SELECT u FROM Unidades u WHERE u.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "Unidades.findByMotivoCancelamento", query = "SELECT u FROM Unidades u WHERE u.motivoCancelamento = :motivoCancelamento")})
public class Unidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_fantasia", nullable = false, length = 300)
    private String nomeFantasia;
    @Column(name = "nome_empresarial", length = 300)
    private String nomeEmpresarial;
    @Column(name = "cnes", length = 50)
    private String cnes;
    @Column(name = "id_natureza_juridica_fk")
    private BigInteger idNaturezaJuridicaFk;
    @Column(name = "id_endereco_unidade_fk")
    private BigInteger idEnderecoUnidadeFk;
    @Column(name = "fone1", length = 40)
    private String fone1;
    @Column(name = "endereco_logradouro", length = 300)
    private String enderecoLogradouro;
    @Column(name = "endereco_numero", length = 150)
    private String enderecoNumero;
    @Column(name = "endereco_complemento", length = 300)
    private String enderecoComplemento;
    @Column(name = "endereco_bairro", length = 300)
    private String enderecoBairro;
    @Column(name = "endereco_cep", length = 50)
    private String enderecoCep;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "motivo_cadastro", length = 300)
    private String motivoCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento", length = 300)
    private String motivoCancelamento;
    @JoinColumn(name = "id_endereco_cidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Cidades idEnderecoCidadeFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_tipo_logradouro_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposLogradouro idTipoLogradouroFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeDeSaudeFk")
    private Collection<HistUnidadesRegime> histUnidadesRegimeCollection;
    @OneToMany(mappedBy = "idUnidadeDeSaudeFk")
    private Collection<Autorizacoes> autorizacoesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidades")
    private Collection<HistUnidadesDiretor> histUnidadesDiretorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection;

    public Unidades() {
    }

    public Unidades(Long id) {
        this.id = id;
    }

    public Unidades(Long id, String nomeFantasia) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    public void setNomeEmpresarial(String nomeEmpresarial) {
        this.nomeEmpresarial = nomeEmpresarial;
    }

    public String getCnes() {
        return cnes;
    }

    public void setCnes(String cnes) {
        this.cnes = cnes;
    }

    public BigInteger getIdNaturezaJuridicaFk() {
        return idNaturezaJuridicaFk;
    }

    public void setIdNaturezaJuridicaFk(BigInteger idNaturezaJuridicaFk) {
        this.idNaturezaJuridicaFk = idNaturezaJuridicaFk;
    }

    public BigInteger getIdEnderecoUnidadeFk() {
        return idEnderecoUnidadeFk;
    }

    public void setIdEnderecoUnidadeFk(BigInteger idEnderecoUnidadeFk) {
        this.idEnderecoUnidadeFk = idEnderecoUnidadeFk;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
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

    public Cidades getIdEnderecoCidadeFk() {
        return idEnderecoCidadeFk;
    }

    public void setIdEnderecoCidadeFk(Cidades idEnderecoCidadeFk) {
        this.idEnderecoCidadeFk = idEnderecoCidadeFk;
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

    public TiposLogradouro getIdTipoLogradouroFk() {
        return idTipoLogradouroFk;
    }

    public void setIdTipoLogradouroFk(TiposLogradouro idTipoLogradouroFk) {
        this.idTipoLogradouroFk = idTipoLogradouroFk;
    }

    public Collection<HistUnidadesRegime> getHistUnidadesRegimeCollection() {
        return histUnidadesRegimeCollection;
    }

    public void setHistUnidadesRegimeCollection(Collection<HistUnidadesRegime> histUnidadesRegimeCollection) {
        this.histUnidadesRegimeCollection = histUnidadesRegimeCollection;
    }

    public Collection<Autorizacoes> getAutorizacoesCollection() {
        return autorizacoesCollection;
    }

    public void setAutorizacoesCollection(Collection<Autorizacoes> autorizacoesCollection) {
        this.autorizacoesCollection = autorizacoesCollection;
    }

    public Collection<HistUnidadesDiretor> getHistUnidadesDiretorCollection() {
        return histUnidadesDiretorCollection;
    }

    public void setHistUnidadesDiretorCollection(Collection<HistUnidadesDiretor> histUnidadesDiretorCollection) {
        this.histUnidadesDiretorCollection = histUnidadesDiretorCollection;
    }

    public Collection<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoCollection() {
        return histFuncionariosUnidadeLotacaoCollection;
    }

    public void setHistFuncionariosUnidadeLotacaoCollection(Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection) {
        this.histFuncionariosUnidadeLotacaoCollection = histFuncionariosUnidadeLotacaoCollection;
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
        if (!(object instanceof Unidades)) {
            return false;
        }
        Unidades other = (Unidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas.Unidades[ id=" + id + " ]";
    }
    
}
