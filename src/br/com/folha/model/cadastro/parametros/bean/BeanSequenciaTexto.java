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
public class BeanSequenciaTexto {
    
    private long sequencia;
    private String texto;
    
    public BeanSequenciaTexto() {
    }

    public BeanSequenciaTexto(long sequencia, String texto) {
        this.sequencia = sequencia;
        this.texto = texto;
    }

    public long getSequencia() {
        return sequencia;
    }

    public void setSequencia(long sequencia) {
        this.sequencia = sequencia;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
    
    
}
