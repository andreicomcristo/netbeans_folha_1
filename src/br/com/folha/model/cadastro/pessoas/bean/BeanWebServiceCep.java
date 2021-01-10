/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.cadastro.pessoas.bean;

import br.com.folha.model.cadastro.parametros.bean.*;

/**
 *
 * @author andre
 */
public class BeanWebServiceCep {
    
    private String tipoLogradouro;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String siglaEstado;
    
    public BeanWebServiceCep() {
    }

    public BeanWebServiceCep(String tipoLogradouro, String logradouro, String bairro, String cidade, String siglaEstado) {
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.siglaEstado = siglaEstado;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    
    
    

}
