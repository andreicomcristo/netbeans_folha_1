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
public class BeanCadastroPaises {
    
    private long seqPais;
    private String nomePais;

    public BeanCadastroPaises() {
    }

    public BeanCadastroPaises(long seqPais, String nomePais) {
        this.seqPais = seqPais;
        this.nomePais = nomePais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public long getSeqPais() {
        return seqPais;
    }

    public void setSeqPais(long seqPais) {
        this.seqPais = seqPais;
    }
    
    
}
