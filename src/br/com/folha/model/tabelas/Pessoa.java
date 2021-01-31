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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "pessoa", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cpf"})})
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.id = :id"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByFone1", query = "SELECT p FROM Pessoa p WHERE p.fone1 = :fone1"),
    @NamedQuery(name = "Pessoa.findByFone2", query = "SELECT p FROM Pessoa p WHERE p.fone2 = :fone2"),
    @NamedQuery(name = "Pessoa.findByFone3", query = "SELECT p FROM Pessoa p WHERE p.fone3 = :fone3"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByEmailSaude", query = "SELECT p FROM Pessoa p WHERE p.emailSaude = :emailSaude"),
    @NamedQuery(name = "Pessoa.findByDtNascimento", query = "SELECT p FROM Pessoa p WHERE p.dtNascimento = :dtNascimento"),
    @NamedQuery(name = "Pessoa.findByNomePai", query = "SELECT p FROM Pessoa p WHERE p.nomePai = :nomePai"),
    @NamedQuery(name = "Pessoa.findByNomeMae", query = "SELECT p FROM Pessoa p WHERE p.nomeMae = :nomeMae"),
    @NamedQuery(name = "Pessoa.findByDtCadastro", query = "SELECT p FROM Pessoa p WHERE p.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Pessoa.findByDtCancelamento", query = "SELECT p FROM Pessoa p WHERE p.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "Pessoa.findByMoivoCancelamento", query = "SELECT p FROM Pessoa p WHERE p.moivoCancelamento = :moivoCancelamento")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "cpf", nullable = false, length = 20)
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 300)
    private String nome;
    @Column(name = "fone1", length = 30)
    private String fone1;
    @Column(name = "fone2", length = 30)
    private String fone2;
    @Column(name = "fone3", length = 30)
    private String fone3;
    @Column(name = "email", length = 150)
    private String email;
    @Column(name = "email_saude", length = 150)
    private String emailSaude;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @Column(name = "nome_pai", length = 300)
    private String nomePai;
    @Column(name = "nome_mae", length = 300)
    private String nomeMae;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "moivo_cancelamento", length = 300)
    private String moivoCancelamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<PessoaFilhos> pessoaFilhosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<PessoaDocumentosReservista> pessoaDocumentosReservistaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<PessoaFotos> pessoaFotosCollection;
    @OneToMany(mappedBy = "idPessoaFk")
    private Collection<PessoaDocumentos> pessoaDocumentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<PessoaOperadores> pessoaOperadoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<Enderecos> enderecosCollection;
    @OneToMany(mappedBy = "idPessoaFk")
    private Collection<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollection;
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
    private Collection<PessoaDocumentosCtps> pessoaDocumentosCtpsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<PessoaBancos> pessoaBancosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private Collection<HistUnidadesDiretor> histUnidadesDiretorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<PessoaFuncionarios> pessoaFuncionariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection;

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

    public Collection<PessoaFilhos> getPessoaFilhosCollection() {
        return pessoaFilhosCollection;
    }

    public void setPessoaFilhosCollection(Collection<PessoaFilhos> pessoaFilhosCollection) {
        this.pessoaFilhosCollection = pessoaFilhosCollection;
    }

    public Collection<PessoaDocumentosConselho> getPessoaDocumentosConselhoCollection() {
        return pessoaDocumentosConselhoCollection;
    }

    public void setPessoaDocumentosConselhoCollection(Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection) {
        this.pessoaDocumentosConselhoCollection = pessoaDocumentosConselhoCollection;
    }

    public Collection<PessoaDocumentosReservista> getPessoaDocumentosReservistaCollection() {
        return pessoaDocumentosReservistaCollection;
    }

    public void setPessoaDocumentosReservistaCollection(Collection<PessoaDocumentosReservista> pessoaDocumentosReservistaCollection) {
        this.pessoaDocumentosReservistaCollection = pessoaDocumentosReservistaCollection;
    }

    public Collection<PessoaFotos> getPessoaFotosCollection() {
        return pessoaFotosCollection;
    }

    public void setPessoaFotosCollection(Collection<PessoaFotos> pessoaFotosCollection) {
        this.pessoaFotosCollection = pessoaFotosCollection;
    }

    public Collection<PessoaDocumentos> getPessoaDocumentosCollection() {
        return pessoaDocumentosCollection;
    }

    public void setPessoaDocumentosCollection(Collection<PessoaDocumentos> pessoaDocumentosCollection) {
        this.pessoaDocumentosCollection = pessoaDocumentosCollection;
    }

    public Collection<PessoaOperadores> getPessoaOperadoresCollection() {
        return pessoaOperadoresCollection;
    }

    public void setPessoaOperadoresCollection(Collection<PessoaOperadores> pessoaOperadoresCollection) {
        this.pessoaOperadoresCollection = pessoaOperadoresCollection;
    }

    public Collection<Enderecos> getEnderecosCollection() {
        return enderecosCollection;
    }

    public void setEnderecosCollection(Collection<Enderecos> enderecosCollection) {
        this.enderecosCollection = enderecosCollection;
    }

    public Collection<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaoCollection() {
        return pessoaDocumentosHabilitacaoCollection;
    }

    public void setPessoaDocumentosHabilitacaoCollection(Collection<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollection) {
        this.pessoaDocumentosHabilitacaoCollection = pessoaDocumentosHabilitacaoCollection;
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

    public Collection<PessoaDocumentosCtps> getPessoaDocumentosCtpsCollection() {
        return pessoaDocumentosCtpsCollection;
    }

    public void setPessoaDocumentosCtpsCollection(Collection<PessoaDocumentosCtps> pessoaDocumentosCtpsCollection) {
        this.pessoaDocumentosCtpsCollection = pessoaDocumentosCtpsCollection;
    }

    public Collection<PessoaBancos> getPessoaBancosCollection() {
        return pessoaBancosCollection;
    }

    public void setPessoaBancosCollection(Collection<PessoaBancos> pessoaBancosCollection) {
        this.pessoaBancosCollection = pessoaBancosCollection;
    }

    public Collection<HistUnidadesDiretor> getHistUnidadesDiretorCollection() {
        return histUnidadesDiretorCollection;
    }

    public void setHistUnidadesDiretorCollection(Collection<HistUnidadesDiretor> histUnidadesDiretorCollection) {
        this.histUnidadesDiretorCollection = histUnidadesDiretorCollection;
    }

    public Collection<PessoaFuncionarios> getPessoaFuncionariosCollection() {
        return pessoaFuncionariosCollection;
    }

    public void setPessoaFuncionariosCollection(Collection<PessoaFuncionarios> pessoaFuncionariosCollection) {
        this.pessoaFuncionariosCollection = pessoaFuncionariosCollection;
    }

    public Collection<PessoaDocumentosTitulo> getPessoaDocumentosTituloCollection() {
        return pessoaDocumentosTituloCollection;
    }

    public void setPessoaDocumentosTituloCollection(Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection) {
        this.pessoaDocumentosTituloCollection = pessoaDocumentosTituloCollection;
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
        return "br.com.folha.model.tabelas.Pessoa[ id=" + id + " ]";
    }
    
}
