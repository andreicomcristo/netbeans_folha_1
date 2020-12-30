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
public class BeanCadastroEscolaridades {
    
    private long seqEscolaridade;
    private String nomeEscolaridade;
    private String descricaoEscolaridade;

    public BeanCadastroEscolaridades() {
    }

    public BeanCadastroEscolaridades(long seqEscolaridade, String nomeEscolaridade, String descricaoEscolaridade) {
        this.seqEscolaridade = seqEscolaridade;
        this.nomeEscolaridade = nomeEscolaridade;
        this.descricaoEscolaridade = descricaoEscolaridade;
    }

    public String getDescricaoEscolaridade() {
        return descricaoEscolaridade;
    }

    public void setDescricaoEscolaridade(String descricaoEscolaridade) {
        this.descricaoEscolaridade = descricaoEscolaridade;
    }

    public long getSeqEscolaridade() {
        return seqEscolaridade;
    }

    public void setSeqEscolaridade(long seqEscolaridade) {
        this.seqEscolaridade = seqEscolaridade;
    }

    public String getNomeEscolaridade() {
        return nomeEscolaridade;
    }

    public void setNomeEscolaridade(String nomeEscolaridade) {
        this.nomeEscolaridade = nomeEscolaridade;
    }
    
    
    
}
