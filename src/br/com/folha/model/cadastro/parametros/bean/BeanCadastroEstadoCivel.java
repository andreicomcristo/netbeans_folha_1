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
public class BeanCadastroEstadoCivel {
    
private long seqEstadoCivil;
private String nomeEstadoCivil;
private String descricaoEstadoCivil;

    public BeanCadastroEstadoCivel() {
    }

    public BeanCadastroEstadoCivel(long seqEstadoCivil, String nomeEstadoCivil, String descricaoEstadoCivil) {
        this.seqEstadoCivil = seqEstadoCivil;
        this.nomeEstadoCivil = nomeEstadoCivil;
        this.descricaoEstadoCivil = descricaoEstadoCivil;
    }

    public String getDescricaoEstadoCivil() {
        return descricaoEstadoCivil;
    }

    public void setDescricaoEstadoCivil(String descricaoEstadoCivil) {
        this.descricaoEstadoCivil = descricaoEstadoCivil;
    }

    public long getSeqEstadoCivil() {
        return seqEstadoCivil;
    }

    public void setSeqEstadoCivil(long seqEstadoCivil) {
        this.seqEstadoCivil = seqEstadoCivil;
    }

    public String getNomeEstadoCivil() {
        return nomeEstadoCivil;
    }

    public void setNomeEstadoCivil(String nomeEstadoCivil) {
        this.nomeEstadoCivil = nomeEstadoCivil;
    }


    
}
