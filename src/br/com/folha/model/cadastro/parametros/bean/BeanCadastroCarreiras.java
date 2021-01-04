
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
public class BeanCadastroCarreiras {
    
    private long seqCarreira;
    private String siglaCarreira;
    private String nomeCarreira;
    private String  descricaoCarreira;

    public BeanCadastroCarreiras() {
    }

    public BeanCadastroCarreiras(long seqCarreira, String siglaCarreira, String nomeCarreira, String descricaoCarreira) {
        this.seqCarreira = seqCarreira;
        this.siglaCarreira = siglaCarreira;
        this.nomeCarreira = nomeCarreira;
        this.descricaoCarreira = descricaoCarreira;
    }

    public String getDescricaoCarreira() {
        return descricaoCarreira;
    }

    public void setDescricaoCarreira(String descricaoCarreira) {
        this.descricaoCarreira = descricaoCarreira;
    }

    public long getSeqCarreira() {
        return seqCarreira;
    }

    public void setSeqCarreira(long seqCarreira) {
        this.seqCarreira = seqCarreira;
    }

    public String getSiglaCarreira() {
        return siglaCarreira;
    }

    public void setSiglaCarreira(String siglaCarreira) {
        this.siglaCarreira = siglaCarreira;
    }

    public String getNomeCarreira() {
        return nomeCarreira;
    }

    public void setNomeCarreira(String nomeCarreira) {
        this.nomeCarreira = nomeCarreira;
    }
    
}
