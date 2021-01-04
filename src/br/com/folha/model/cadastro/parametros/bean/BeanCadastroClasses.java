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
public class BeanCadastroClasses {
    
    private long seqClasses;
    private String siglaClasse;
    private String nomeClasse;
    private String descricaoClasse;

    public BeanCadastroClasses() {
    }

    public BeanCadastroClasses(long seqClasses, String siglaClasse, String nomeClasse, String descricaoClasse) {
        this.seqClasses = seqClasses;
        this.siglaClasse = siglaClasse;
        this.nomeClasse = nomeClasse;
        this.descricaoClasse = descricaoClasse;
    }

    public String getDescricaoClasse() {
        return descricaoClasse;
    }

    public void setDescricaoClasse(String descricaoClasse) {
        this.descricaoClasse = descricaoClasse;
    }

    public long getSeqClasses() {
        return seqClasses;
    }

    public void setSeqClasses(long seqClasses) {
        this.seqClasses = seqClasses;
    }

    public String getSiglaClasse() {
        return siglaClasse;
    }

    public void setSiglaClasse(String siglaClasse) {
        this.siglaClasse = siglaClasse;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }
            
    
}
