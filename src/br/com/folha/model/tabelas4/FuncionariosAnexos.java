/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.tabelas4;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANDREI
 */
@Entity
@Table(name = "funcionarios_anexos")
@NamedQueries({
    @NamedQuery(name = "FuncionariosAnexos.findAll", query = "SELECT f FROM FuncionariosAnexos f"),
    @NamedQuery(name = "FuncionariosAnexos.findById", query = "SELECT f FROM FuncionariosAnexos f WHERE f.id = :id"),
    @NamedQuery(name = "FuncionariosAnexos.findByIdTipoDeAnexoFk", query = "SELECT f FROM FuncionariosAnexos f WHERE f.idTipoDeAnexoFk = :idTipoDeAnexoFk"),
    @NamedQuery(name = "FuncionariosAnexos.findByDtCadastro", query = "SELECT f FROM FuncionariosAnexos f WHERE f.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "FuncionariosAnexos.findByDtCancelamento", query = "SELECT f FROM FuncionariosAnexos f WHERE f.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "FuncionariosAnexos.findByMotivoCancelamento", query = "SELECT f FROM FuncionariosAnexos f WHERE f.motivoCancelamento = :motivoCancelamento")})
public class FuncionariosAnexos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_de_anexo_fk")
    private Long idTipoDeAnexoFk;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @Lob
    @Column(name = "pdf_anexo")
    private byte[] pdfAnexo;
    @JoinColumn(name = "id_pessoa_funcionario_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaFuncionarios idPessoaFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_tipo_de_anexo_fk", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TiposDeAnexo tiposDeAnexo;

    public FuncionariosAnexos() {
    }

    public FuncionariosAnexos(Long idTipoDeAnexoFk) {
        this.idTipoDeAnexoFk = idTipoDeAnexoFk;
    }

    public FuncionariosAnexos(Long idTipoDeAnexoFk, long id) {
        this.idTipoDeAnexoFk = idTipoDeAnexoFk;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getIdTipoDeAnexoFk() {
        return idTipoDeAnexoFk;
    }

    public void setIdTipoDeAnexoFk(Long idTipoDeAnexoFk) {
        this.idTipoDeAnexoFk = idTipoDeAnexoFk;
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

    public byte[] getPdfAnexo() {
        return pdfAnexo;
    }

    public void setPdfAnexo(byte[] pdfAnexo) {
        this.pdfAnexo = pdfAnexo;
    }

    public PessoaFuncionarios getIdPessoaFuncionarioFk() {
        return idPessoaFuncionarioFk;
    }

    public void setIdPessoaFuncionarioFk(PessoaFuncionarios idPessoaFuncionarioFk) {
        this.idPessoaFuncionarioFk = idPessoaFuncionarioFk;
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

    public TiposDeAnexo getTiposDeAnexo() {
        return tiposDeAnexo;
    }

    public void setTiposDeAnexo(TiposDeAnexo tiposDeAnexo) {
        this.tiposDeAnexo = tiposDeAnexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDeAnexoFk != null ? idTipoDeAnexoFk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionariosAnexos)) {
            return false;
        }
        FuncionariosAnexos other = (FuncionariosAnexos) object;
        if ((this.idTipoDeAnexoFk == null && other.idTipoDeAnexoFk != null) || (this.idTipoDeAnexoFk != null && !this.idTipoDeAnexoFk.equals(other.idTipoDeAnexoFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.folha.model.tabelas4.FuncionariosAnexos[ idTipoDeAnexoFk=" + idTipoDeAnexoFk + " ]";
    }
    
}
