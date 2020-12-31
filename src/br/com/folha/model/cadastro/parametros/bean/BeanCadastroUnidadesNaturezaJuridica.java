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
public class BeanCadastroUnidadesNaturezaJuridica {
    
    private long seqUnidadeNaturezaJurudica;
    private String nomeNaturazaJuridica;
    private String descricaoNaturezaJuridica;

    public BeanCadastroUnidadesNaturezaJuridica() {
    }

    public BeanCadastroUnidadesNaturezaJuridica(long seqUnidadeNaturezaJurudica, String nomeNaturazaJuridica, String descricaoNaturezaJuridica) {
        this.seqUnidadeNaturezaJurudica = seqUnidadeNaturezaJurudica;
        this.nomeNaturazaJuridica = nomeNaturazaJuridica;
        this.descricaoNaturezaJuridica = descricaoNaturezaJuridica;
    }

    public String getDescricaoNaturezaJuridica() {
        return descricaoNaturezaJuridica;
    }

    public void setDescricaoNaturezaJuridica(String descricaoNaturezaJuridica) {
        this.descricaoNaturezaJuridica = descricaoNaturezaJuridica;
    }

    public long getSeqUnidadeNaturezaJurudica() {
        return seqUnidadeNaturezaJurudica;
    }

    public void setSeqUnidadeNaturezaJurudica(long seqUnidadeNaturezaJurudica) {
        this.seqUnidadeNaturezaJurudica = seqUnidadeNaturezaJurudica;
    }

    public String getNomeNaturazaJuridica() {
        return nomeNaturazaJuridica;
    }

    public void setNomeNaturazaJuridica(String nomeNaturazaJuridica) {
        this.nomeNaturazaJuridica = nomeNaturazaJuridica;
    }
    
    
    
}
