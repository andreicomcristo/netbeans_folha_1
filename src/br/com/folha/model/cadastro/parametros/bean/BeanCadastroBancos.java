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
public class BeanCadastroBancos {
    
    private long seqBanco;
    private String codigoBanco;
    private String nomeBanco;
    private String siglaBanco;

    public BeanCadastroBancos() {
    }

    public BeanCadastroBancos(long seqBanco, String codigoBanco, String nomeBanco, String siglaBanco) {
        this.seqBanco = seqBanco;
        this.codigoBanco = codigoBanco;
        this.nomeBanco = nomeBanco;
        this.siglaBanco = siglaBanco;
    }

    public long getSeqBanco() {
        return seqBanco;
    }

    public void setSeqBanco(long seqBanco) {
        this.seqBanco = seqBanco;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getSiglaBanco() {
        return siglaBanco;
    }

    public void setSiglaBanco(String siglaBanco) {
        this.siglaBanco = siglaBanco;
    }

    
    
    
}
