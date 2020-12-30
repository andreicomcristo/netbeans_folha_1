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
public class BeanCadastroSexos {
    
    private long seqSexo;
    private String nomeSexo;
    private String descricaoSexo;

    public BeanCadastroSexos() {
    }

    public BeanCadastroSexos(long seqSexo, String nomeSexo, String descricaoSexo) {
        this.seqSexo = seqSexo;
        this.nomeSexo = nomeSexo;
        this.descricaoSexo = descricaoSexo;
    }

    public String getDescricaoSexo() {
        return descricaoSexo;
    }

    public void setDescricaoSexo(String descricaoSexo) {
        this.descricaoSexo = descricaoSexo;
    }

    public long getSeqSexo() {
        return seqSexo;
    }

    public void setSeqSexo(long seqSexo) {
        this.seqSexo = seqSexo;
    }

    public String getNomeSexo() {
        return nomeSexo;
    }

    public void setNomeSexo(String nomeSexo) {
        this.nomeSexo = nomeSexo;
    }
    
    
}
