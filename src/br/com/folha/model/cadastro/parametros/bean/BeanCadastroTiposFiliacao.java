/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.cadastro.parametros.bean;

/**
 *
 * @author andre
 */
public class BeanCadastroTiposFiliacao {
    private long seqTipoFiliacao;
    private String nomeTipoFiliacao;
    private String descricaoTipoFiliacao;

    public BeanCadastroTiposFiliacao() {
    }

    public BeanCadastroTiposFiliacao(long seqTipoFiliacao, String nomeTipoFiliacao, String descricaoTipoFiliacao) {
        this.seqTipoFiliacao = seqTipoFiliacao;
        this.nomeTipoFiliacao = nomeTipoFiliacao;
        this.descricaoTipoFiliacao = descricaoTipoFiliacao;
    }

    public String getDescricaoTipoFiliacao() {
        return descricaoTipoFiliacao;
    }

    public void setDescricaoTipoFiliacao(String descricaoTipoFiliacao) {
        this.descricaoTipoFiliacao = descricaoTipoFiliacao;
    }

    public long getSeqTipoFiliacao() {
        return seqTipoFiliacao;
    }

    public void setSeqTipoFiliacao(long seqTipoFiliacao) {
        this.seqTipoFiliacao = seqTipoFiliacao;
    }

    public String getNomeTipoFiliacao() {
        return nomeTipoFiliacao;
    }

    public void setNomeTipoFiliacao(String nomeTipoFiliacao) {
        this.nomeTipoFiliacao = nomeTipoFiliacao;
    }
    
}
