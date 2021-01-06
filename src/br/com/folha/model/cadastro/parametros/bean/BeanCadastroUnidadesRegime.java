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
public class BeanCadastroUnidadesRegime {
    
    private long seqRegimeUnidLotacao;
    private String siglaRegimeUnidLotacao;
    private String nomeRegimeUnidLotacao;
    private String descricaoRegimeUnidLotacao;

    public BeanCadastroUnidadesRegime() {
    }

    public BeanCadastroUnidadesRegime(long seqRegimeUnidLotacao, String siglaRegimeUnidLotacao, String nomeRegimeUnidLotacao, String descicaoRegimeUnidLotacao) {
        this.seqRegimeUnidLotacao = seqRegimeUnidLotacao;
        this.siglaRegimeUnidLotacao = siglaRegimeUnidLotacao;
        this.nomeRegimeUnidLotacao = nomeRegimeUnidLotacao;
        this.descricaoRegimeUnidLotacao = descicaoRegimeUnidLotacao;
    }

    public String getDescricaoRegimeUnidLotacao() {
        return descricaoRegimeUnidLotacao;
    }

    public void setDescricaoRegimeUnidLotacao(String descricaoRegimeUnidLotacao) {
        this.descricaoRegimeUnidLotacao = descricaoRegimeUnidLotacao;
    }

    public long getSeqRegimeUnidLotacao() {
        return seqRegimeUnidLotacao;
    }

    public void setSeqRegimeUnidLotacao(long seqRegimeUnidLotacao) {
        this.seqRegimeUnidLotacao = seqRegimeUnidLotacao;
    }

    public String getSiglaRegimeUnidLotacao() {
        return siglaRegimeUnidLotacao;
    }

    public void setSiglaRegimeUnidLotacao(String siglaRegimeUnidLotacao) {
        this.siglaRegimeUnidLotacao = siglaRegimeUnidLotacao;
    }

    public String getNomeRegimeUnidLotacao() {
        return nomeRegimeUnidLotacao;
    }

    public void setNomeRegimeUnidLotacao(String nomeRegimeUnidLotacao) {
        this.nomeRegimeUnidLotacao = nomeRegimeUnidLotacao;
    }
    
    
}
