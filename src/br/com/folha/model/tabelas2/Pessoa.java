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
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "fone1")
    private String fone1;
    @Column(name = "fone2")
    private String fone2;
    @Column(name = "fone3")
    private String fone3;
    @Column(name = "email")
    private String email;
    @Column(name = "email_saude")
    private String emailSaude;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @Column(name = "nome_pai")
    private String nomePai;
    @Column(name = "nome_mae")
    private String nomeMae;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "moivo_cancelamento")
    private String moivoCancelamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaFilhos> pessoaFilhosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaDocumentosConselho> pessoaDocumentosConselhoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaDocumentosReservista> pessoaDocumentosReservistaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaFotos> pessoaFotosList;
    @OneToMany(mappedBy = "idPessoaFk")
    private List<PessoaDocumentos> pessoaDocumentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaOperadores> pessoaOperadoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<Enderecos> enderecosList;
    @OneToMany(mappedBy = "idPessoaFk")
    private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList;
    @JoinColumn(name = "seq_cidade_natal", referencedColumnName = "id")
    @ManyToOne
    private Cidades seqCidadeNatal;
    @JoinColumn(name = "seq_endereco", referencedColumnName = "id")
    @ManyToOne
    private Enderecos seqEndereco;
    @JoinColumn(name = "seq_escolaridade", referencedColumnName = "id")
    @ManyToOne
    private Escolaridades seqEscolaridade;
    @JoinColumn(name = "seq_estado_civil", referencedColumnName = "id")
    @ManyToOne
    private EstadosCivis seqEstadoCivil;
    @JoinColumn(name = "seq_operador_cadastro", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores seqOperadorCadastro;
    @JoinColumn(name = "seq_operador_cancelamento", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores seqOperadorCancelamento;
    @JoinColumn(name = "seq_sexo_declarado", referencedColumnName = "id")
    @ManyToOne
    private Sexos seqSexoDeclarado;
    @JoinColumn(name = "seq_sexo", referencedColumnName = "id")
    @ManyToOne
    private Sexos seqSexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaDocumentosCtps> pessoaDocumentosCtpsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaBancos> pessoaBancosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<HistUnidadesDiretor> histUnidadesDiretorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaDocumentosTitulo> pessoaDocumentosTituloList;

    public Pessoa() {
    }

    public Pessoa(Long id) {
        this.id = id;
    }

    public Pessoa(Long id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getFone3() {
        return fone3;
    }

    public void setFone3(String fone3) {
        this.fone3 = fone3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailSaude() {
        return emailSaude;
    }

    public void setEmailSaude(String emailSaude) {
        this.emailSaude = emailSaude;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
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

    public String getMoivoCancelamento() {
        return moivoCancelamento;
    }

    public void setMoivoCancelamento(String moivoCancelamento) {
        this.moivoCancelamento = moivoCancelamento;
    }

    public List<PessoaFilhos> getPessoaFilhosList() {
        return pessoaFilhosList;
    }

    public void setPessoaFilhosList(List<PessoaFilhos> pessoaFilhosList) {
        this.pessoaFilhosList = pessoaFilhosList;
    }

    public List<PessoaDocumentosConselho> getPessoaDocumentosConselhoList() {
        return pessoaDocumentosConselhoList;
    }

    public void setPessoaDocumentosConselhoList(List<PessoaDocumentosConselho> pessoaDocumentosConselhoList) {
        this.pessoaDocumentosConselhoList = pessoaDocumentosConselhoList;
    }

    public List<PessoaDocumentosReservista> getPessoaDocumentosReservistaList() {
        return pessoaDocumentosReservistaList;
    }

    public void setPessoaDocumentosReservistaList(List<PessoaDocumentosReservista> pessoaDocumentosReservistaList) {
        this.pessoaDocumentosReservistaList = pessoaDocumentosReservistaList;
    }

    public List<PessoaFotos> getPessoaFotosList() {
        return pessoaFotosList;
    }

    public void setPessoaFotosList(List<PessoaFotos> pessoaFotosList) {
        this.pessoaFotosList = pessoaFotosList;
    }

    public List<PessoaDocumentos> getPessoaDocumentosList() {
        return pessoaDocumentosList;
    }

    public void setPessoaDocumentosList(List<PessoaDocumentos> pessoaDocumentosList) {
        this.pessoaDocumentosList = pessoaDocumentosList;
    }

    public List<PessoaOperadores> getPessoaOperadoresList() {
        return pessoaOperadoresList;
    }

    public void setPessoaOperadoresList(List<PessoaOperadores> pessoaOperadoresList) {
        this.pessoaOperadoresList = pessoaOperadoresList;
    }

    public List<Enderecos> getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List<Enderecos> enderecosList) {
        this.enderecosList = enderecosList;
    }

    public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaoList() {
        return pessoaDocumentosHabilitacaoList;
    }

    public void setPessoaDocumentosHabilitacaoList(List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList) {
        this.pessoaDocumentosHabilitacaoList = pessoaDocumentosHabilitacaoList;
    }

    public Cidades getSeqCidadeNatal() {
        return seqCidadeNatal;
    }

    public void setSeqCidadeNatal(Cidades seqCidadeNatal) {
        this.seqCidadeNatal = seqCidadeNatal;
    }

    public Enderecos getSeqEndereco() {
        return seqEndereco;
    }

    public void setSeqEndereco(Enderecos seqEndereco) {
        this.seqEndereco = seqEndereco;
    }

    public Escolaridades getSeqEscolaridade() {
        return seqEscolaridade;
    }

    public void setSeqEscolaridade(Escolaridades seqEscolaridade) {
        this.seqEscolaridade = seqEscolaridade;
    }

    public EstadosCivis getSeqEstadoCivil() {
        return seqEstadoCivil;
    }

    public void setSeqEstadoCivil(EstadosCivis seqEstadoCivil) {
        this.seqEstadoCivil = seqEstadoCivil;
    }

    public PessoaOperadores getSeqOperadorCadastro() {
        return seqOperadorCadastro;
    }

    public void setSeqOperadorCadastro(PessoaOperadores seqOperadorCadastro) {
        this.seqOperadorCadastro = seqOperadorCadastro;
    }

    public PessoaOperadores getSeqOperadorCancelamento() {
        return seqOperadorCancelamento;
    }

    public void setSeqOperadorCancelamento(PessoaOperadores seqOperadorCancelamento) {
        this.seqOperadorCancelamento = seqOperadorCancelamento;
    }

    public Sexos getSeqSexoDeclarado() {
        return seqSexoDeclarado;
    }

    public void setSeqSexoDeclarado(Sexos seqSexoDeclarado) {
        this.seqSexoDeclarado = seqSexoDeclarado;
    }

    public Sexos getSeqSexo() {
        return seqSexo;
    }

    public void setSeqSexo(Sexos seqSexo) {
        this.seqSexo = seqSexo;
    }

    public List<PessoaDocumentosCtps> getPessoaDocumentosCtpsList() {
        return pessoaDocumentosCtpsList;
    }

    public void setPessoaDocumentosCtpsList(List<PessoaDocumentosCtps> pessoaDocumentosCtpsList) {
        this.pessoaDocumentosCtpsList = pessoaDocumentosCtpsList;
    }

    public List<PessoaBancos> getPessoaBancosList() {
        return pessoaBancosList;
    }

    public void setPessoaBancosList(List<PessoaBancos> pessoaBancosList) {
        this.pessoaBancosList = pessoaBancosList;
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

    public List<PessoaDocumentosTitulo> getPessoaDocumentosTituloList() {
        return pessoaDocumentosTituloList;
    }

    public void setPessoaDocumentosTituloList(List<PessoaDocumentosTitulo> pessoaDocumentosTituloList) {
        this.pessoaDocumentosTituloList = pessoaDocumentosTituloList;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.Pessoa[ id=" + id + " ]";
    }
    
}
