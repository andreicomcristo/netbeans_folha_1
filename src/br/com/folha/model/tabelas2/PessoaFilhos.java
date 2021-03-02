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
@Table(name = "pessoa_filhos")
@NamedQueries({
    @NamedQuery(name = "PessoaFilhos.findAll", query = "SELECT p FROM PessoaFilhos p")})
public class PessoaFilhos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome_filho")
    private String nomeFilho;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @Column(name = "cpf_filho")
    private String cpfFilho;
    @Column(name = "rg_filho")
    private String rgFilho;
    @Column(name = "rg_dt_emissao_filho")
    @Temporal(TemporalType.DATE)
    private Date rgDtEmissaoFilho;
    @Column(name = "rg_orgao_expedidor")
    private String rgOrgaoExpedidor;
    @Column(name = "numero_certidao_nascimento")
    private String numeroCertidaoNascimento;
    @Column(name = "dt_certidado_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtCertidadoNascimento;
    @Column(name = "cartorio_certidado_nascimento")
    private String cartorioCertidadoNascimento;
    @Column(name = "livro_certidao_nascimento")
    private String livroCertidaoNascimento;
    @Column(name = "folha_certidao_nascimento")
    private String folhaCertidaoNascimento;
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
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_tipo_filiacao_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposDeFiliacao idTipoFiliacaoFk;

    public PessoaFilhos() {
    }

    public PessoaFilhos(Long id) {
        this.id = id;
    }

    public PessoaFilhos(Long id, String nomeFilho) {
        this.id = id;
        this.nomeFilho = nomeFilho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFilho() {
        return nomeFilho;
    }

    public void setNomeFilho(String nomeFilho) {
        this.nomeFilho = nomeFilho;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpfFilho() {
        return cpfFilho;
    }

    public void setCpfFilho(String cpfFilho) {
        this.cpfFilho = cpfFilho;
    }

    public String getRgFilho() {
        return rgFilho;
    }

    public void setRgFilho(String rgFilho) {
        this.rgFilho = rgFilho;
    }

    public Date getRgDtEmissaoFilho() {
        return rgDtEmissaoFilho;
    }

    public void setRgDtEmissaoFilho(Date rgDtEmissaoFilho) {
        this.rgDtEmissaoFilho = rgDtEmissaoFilho;
    }

    public String getRgOrgaoExpedidor() {
        return rgOrgaoExpedidor;
    }

    public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
        this.rgOrgaoExpedidor = rgOrgaoExpedidor;
    }

    public String getNumeroCertidaoNascimento() {
        return numeroCertidaoNascimento;
    }

    public void setNumeroCertidaoNascimento(String numeroCertidaoNascimento) {
        this.numeroCertidaoNascimento = numeroCertidaoNascimento;
    }

    public Date getDtCertidadoNascimento() {
        return dtCertidadoNascimento;
    }

    public void setDtCertidadoNascimento(Date dtCertidadoNascimento) {
        this.dtCertidadoNascimento = dtCertidadoNascimento;
    }

    public String getCartorioCertidadoNascimento() {
        return cartorioCertidadoNascimento;
    }

    public void setCartorioCertidadoNascimento(String cartorioCertidadoNascimento) {
        this.cartorioCertidadoNascimento = cartorioCertidadoNascimento;
    }

    public String getLivroCertidaoNascimento() {
        return livroCertidaoNascimento;
    }

    public void setLivroCertidaoNascimento(String livroCertidaoNascimento) {
        this.livroCertidaoNascimento = livroCertidaoNascimento;
    }

    public String getFolhaCertidaoNascimento() {
        return folhaCertidaoNascimento;
    }

    public void setFolhaCertidaoNascimento(String folhaCertidaoNascimento) {
        this.folhaCertidaoNascimento = folhaCertidaoNascimento;
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

    public TiposDeFiliacao getIdTipoFiliacaoFk() {
        return idTipoFiliacaoFk;
    }

    public void setIdTipoFiliacaoFk(TiposDeFiliacao idTipoFiliacaoFk) {
        this.idTipoFiliacaoFk = idTipoFiliacaoFk;
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
        if (!(object instanceof PessoaFilhos)) {
            return false;
        }
        PessoaFilhos other = (PessoaFilhos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas2.PessoaFilhos[ id=" + id + " ]";
    }
    
}
