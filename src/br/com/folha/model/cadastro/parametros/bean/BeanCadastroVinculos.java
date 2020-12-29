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
public class BeanCadastroVinculos {
    
    private long seqVinculo;
    private String nomeVinculo;
    private String descricaoVinculo;

    public BeanCadastroVinculos() {
    }
    
    public BeanCadastroVinculos(long seqVinculo, String nomeVinculo, String descricaoVinculo) {
        this.seqVinculo = seqVinculo;
        this.nomeVinculo = nomeVinculo;
        this.descricaoVinculo = descricaoVinculo;
    }
    
    
    public long getSeqVinculo() {
        return seqVinculo;
    }

    public void setSeqVinculo(long seqVinculo) {
        this.seqVinculo = seqVinculo;
    }

    public String getNomeVinculo() {
        return nomeVinculo;
    }

    public void setNomeVinculo(String nomeVinculo) {
        this.nomeVinculo = nomeVinculo;
    }

    public String getDescricaoVinculo() {
        return descricaoVinculo;
    }

    public void setDescricaoVinculo(String descricaoVinculo) {
        this.descricaoVinculo = descricaoVinculo;
    }
    
    
}
