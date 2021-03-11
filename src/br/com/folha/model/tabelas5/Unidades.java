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
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "nome_empresarial")
    private String nomeEmpresarial;
    @Column(name = "cnes")
    private String cnes;
    @Column(name = "fone1")
    private String fone1;
    @Column(name = "endereco_logradouro")
    private String enderecoLogradouro;
    @Column(name = "endereco_numero")
    private String enderecoNumero;
    @Column(name = "endereco_complemento")
    private String enderecoComplemento;
    @Column(name = "endereco_bairro")
    private String enderecoBairro;
    @Column(name = "endereco_cep")
    private String enderecoCep;
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
    @OneToMany(mappedBy = "idUnidadeAtuacaoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(mappedBy = "idUnidadeLotacaoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList1;
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
    @JoinColumn(name = "id_natureza_juridica_fk", referencedColumnName = "id")
    @ManyToOne
    private UnidadesNaturezaJuridica idNaturezaJuridicaFk;
    @JoinColumn(name = "id_unidades_regime_fk", referencedColumnName = "id")
    @ManyToOne
    private UnidadesRegime idUnidadesRegimeFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeDeSaudeFk")
    private List<HistUnidadesRegime> histUnidadesRegimeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList;
    @OneToMany(mappedBy = "idUnidadeLancamentoFk")
    private List<FuncionariosFerias> funcionariosFeriasList;
    @OneToMany(mappedBy = "idUnidadeDeSaudeFk")
    private List<Autorizacoes> autorizacoesList;
    @OneToMany(mappedBy = "idUnidadeDeSaudeFk")
    private List<HistUnidadesDiretor> histUnidadesDiretorList;
    @OneToMany(mappedBy = "idUnidadeAtuacaoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList;

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

    public UnidadesNaturezaJuridica getIdNaturezaJuridicaFk() {
        return idNaturezaJuridicaFk;
    }

    public void setIdNaturezaJuridicaFk(UnidadesNaturezaJuridica idNaturezaJuridicaFk) {
        this.idNaturezaJuridicaFk = idNaturezaJuridicaFk;
    }

    public UnidadesRegime getIdUnidadesRegimeFk() {
        return idUnidadesRegimeFk;
    }

    public void setIdUnidadesRegimeFk(UnidadesRegime idUnidadesRegimeFk) {
        this.idUnidadesRegimeFk = idUnidadesRegimeFk;
    }

    public List<HistUnidadesRegime> getHistUnidadesRegimeList() {
        return histUnidadesRegimeList;
    }

    public void setHistUnidadesRegimeList(List<HistUnidadesRegime> histUnidadesRegimeList) {
        this.histUnidadesRegimeList = histUnidadesRegimeList;
    }

    public List<AcessoOperadoresUnidades> getAcessoOperadoresUnidadesList() {
        return acessoOperadoresUnidadesList;
    }

    public void setAcessoOperadoresUnidadesList(List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList) {
        this.acessoOperadoresUnidadesList = acessoOperadoresUnidadesList;
    }

    public List<FuncionariosFerias> getFuncionariosFeriasList() {
        return funcionariosFeriasList;
    }

    public void setFuncionariosFeriasList(List<FuncionariosFerias> funcionariosFeriasList) {
        this.funcionariosFeriasList = funcionariosFeriasList;
    }

    public List<Autorizacoes> getAutorizacoesList() {
        return autorizacoesList;
    }

    public void setAutorizacoesList(List<Autorizacoes> autorizacoesList) {
        this.autorizacoesList = autorizacoesList;
    }

    public List<HistUnidadesDiretor> getHistUnidadesDiretorList() {
        return histUnidadesDiretorList;
    }

    public void setHistUnidadesDiretorList(List<HistUnidadesDiretor> histUnidadesDiretorList) {
        this.histUnidadesDiretorList = histUnidadesDiretorList;
    }

    public List<PessoaFuncionarios> getPessoaFuncionariosList() {
        return pessoaFuncionariosList;
    }

    public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
        this.pessoaFuncionariosList = pessoaFuncionariosList;
    }

    public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoList() {
        return histFuncionariosUnidadeLotacaoList;
    }

    public void setHistFuncionariosUnidadeLotacaoList(List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList) {
        this.histFuncionariosUnidadeLotacaoList = histFuncionariosUnidadeLotacaoList;
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
        return "br.com.folha.model.tabelas5.Unidades[ id=" + id + " ]";
    }
    
}
