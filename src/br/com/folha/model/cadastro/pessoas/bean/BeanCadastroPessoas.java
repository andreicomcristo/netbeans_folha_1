/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.cadastro.pessoas.bean;

/**
 *
 * @author andre
 */
public class BeanCadastroPessoas {
    
    private long seqPessoa;
    private String cpfPessoa;
    private String nomePessoa;
    
    public BeanCadastroPessoas() {
    }

    public BeanCadastroPessoas(long seqPessoa, String cpfPessoa, String nomePessoa) {
        this.seqPessoa = seqPessoa;
        this.cpfPessoa = cpfPessoa;
        this.nomePessoa = nomePessoa;
    }

    public long getSeqPessoa() {
        return seqPessoa;
    }

    public void setSeqPessoa(long seqPessoa) {
        this.seqPessoa = seqPessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    
    
    

}
