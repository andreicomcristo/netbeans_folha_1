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
public class BeanCadastroHabilitacaoCategorias {
    
    private long seqHabilitacaoCategoria;
    private String nomeHabilitacaoCategoria;
    private String descricaoHabilitacaoCategoria;

    public BeanCadastroHabilitacaoCategorias() {
    }

    public BeanCadastroHabilitacaoCategorias(long seqHabilitacaoCategoria, String nomeHabilitacaoCategoria, String descricaoHabilitacaoCategoria) {
        this.seqHabilitacaoCategoria = seqHabilitacaoCategoria;
        this.nomeHabilitacaoCategoria = nomeHabilitacaoCategoria;
        this.descricaoHabilitacaoCategoria = descricaoHabilitacaoCategoria;
    }

    public String getDescricaoHabilitacaoCategoria() {
        return descricaoHabilitacaoCategoria;
    }

    public void setDescricaoHabilitacaoCategoria(String descricaoHabilitacaoCategoria) {
        this.descricaoHabilitacaoCategoria = descricaoHabilitacaoCategoria;
    }

    public long getSeqHabilitacaoCategoria() {
        return seqHabilitacaoCategoria;
    }

    public void setSeqHabilitacaoCategoria(long seqHabilitacaoCategoria) {
        this.seqHabilitacaoCategoria = seqHabilitacaoCategoria;
    }

    public String getNomeHabilitacaoCategoria() {
        return nomeHabilitacaoCategoria;
    }

    public void setNomeHabilitacaoCategoria(String nomeHabilitacaoCategoria) {
        this.nomeHabilitacaoCategoria = nomeHabilitacaoCategoria;
    }
    
    
    
}
