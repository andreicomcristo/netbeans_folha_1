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
public class BeanCadastroTiposLogradouro {
    
    private long seqTipoLogradouro;
    private String nomeTipoLogradouro;
    private String descricaoTipoLogradouro;

    public BeanCadastroTiposLogradouro() {
    }

    public BeanCadastroTiposLogradouro(long seqTipoLogradouro, String nomeTipoLogradouro, String descricaoTipoLogradouro) {
        this.seqTipoLogradouro = seqTipoLogradouro;
        this.nomeTipoLogradouro = nomeTipoLogradouro;
        this.descricaoTipoLogradouro = descricaoTipoLogradouro;
    }

    public String getDescricaoTipoLogradouro() {
        return descricaoTipoLogradouro;
    }

    public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
        this.descricaoTipoLogradouro = descricaoTipoLogradouro;
    }

    public long getSeqTipoLogradouro() {
        return seqTipoLogradouro;
    }

    public void setSeqTipoLogradouro(long seqTipoLogradouro) {
        this.seqTipoLogradouro = seqTipoLogradouro;
    }

    public String getNomeTipoLogradouro() {
        return nomeTipoLogradouro;
    }

    public void setNomeTipoLogradouro(String nomeTipoLogradouro) {
        this.nomeTipoLogradouro = nomeTipoLogradouro;
    }
    
    
}
