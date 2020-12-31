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
public class BeanCadastroSituacoes {
    
    private long seqSituacao;
    private String nomeSituacao;
    private String descricaoSituacao;

    public BeanCadastroSituacoes() {
    }

    public BeanCadastroSituacoes(long seqSituacao, String nomeSituacao, String descricaoSituacao) {
        this.seqSituacao = seqSituacao;
        this.nomeSituacao = nomeSituacao;
        this.descricaoSituacao = descricaoSituacao;
    }

    public String getDescricaoSituacao() {
        return descricaoSituacao;
    }

    public void setDescricaoSituacao(String descricaoSituacao) {
        this.descricaoSituacao = descricaoSituacao;
    }

    public long getSeqSituacao() {
        return seqSituacao;
    }

    public void setSeqSituacao(long seqSituacao) {
        this.seqSituacao = seqSituacao;
    }

    public String getNomeSituacao() {
        return nomeSituacao;
    }

    public void setNomeSituacao(String nomeSituacao) {
        this.nomeSituacao = nomeSituacao;
    }
    
    
    
}
