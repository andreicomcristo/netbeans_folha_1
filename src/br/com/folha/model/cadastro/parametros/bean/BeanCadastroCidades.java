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
public class BeanCadastroCidades {
    
    private long seqCidade;
    private String nomeCidade;
    private String siglaEstado;
    private long seqPais;
    private String nomePais;

    public BeanCadastroCidades() {
    }

    public BeanCadastroCidades(long seqCidade, String nomeCidade, String siglaEstado, long seqPais, String nomePais) {
        this.seqCidade = seqCidade;
        this.nomeCidade = nomeCidade;
        this.siglaEstado = siglaEstado;
        this.seqPais = seqPais;
        this.nomePais = nomePais;
    }

    public long getSeqCidade() {
        return seqCidade;
    }

    public void setSeqCidade(long seqCidade) {
        this.seqCidade = seqCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public long getSeqPais() {
        return seqPais;
    }

    public void setSeqPais(long seqPais) {
        this.seqPais = seqPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    
    

}
