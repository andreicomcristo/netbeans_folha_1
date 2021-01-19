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
public class BeanEnderecoPessoa {
    
    private long seqPessoa;
    private long seqEndereco;
    private long seqTipoLogradouro;
    private String nomeTipoLogradouro;
    private String enderecoLogradouro;
    private String enderecoNumero;
    private String enderecoComplemento;
    private String enderecoBairro;
    private String enderecoCep;
    private long seqEnderecoCidade;
    private String nomeCidade;
    private String siglaEstado;
    private long seqPais;
    private String nomePais;
                            
    
    public BeanEnderecoPessoa() {
    }

    public BeanEnderecoPessoa(long seqPessoa, long seqEndereco, long seqTipoLogradouro, String nomeTipoLogradouro, String enderecoLogradouro, String enderecoNumero, String enderecoComplemento, String enderecoBairro, String enderecoCep, long seqEnderecoCidade, String nomeCidade, String siglaEstado, long seqPais, String nomePais) {
        this.seqPessoa = seqPessoa;
        this.seqEndereco = seqEndereco;
        this.seqTipoLogradouro = seqTipoLogradouro;
        this.nomeTipoLogradouro = nomeTipoLogradouro;
        this.enderecoLogradouro = enderecoLogradouro;
        this.enderecoNumero = enderecoNumero;
        this.enderecoComplemento = enderecoComplemento;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCep = enderecoCep;
        this.seqEnderecoCidade = seqEnderecoCidade;
        this.nomeCidade = nomeCidade;
        this.siglaEstado = siglaEstado;
        this.seqPais = seqPais;
        this.nomePais = nomePais;
    }

    public long getSeqPessoa() {
        return seqPessoa;
    }

    public void setSeqPessoa(long seqPessoa) {
        this.seqPessoa = seqPessoa;
    }

    public long getSeqEndereco() {
        return seqEndereco;
    }

    public void setSeqEndereco(long seqEndereco) {
        this.seqEndereco = seqEndereco;
    }

    public long getSeqTipoLogradouro() {
        return seqTipoLogradouro;
    }

    public void setSeqTipoLogradouro(long seqTipoLogradouro) {
        this.seqTipoLogradouro = seqTipoLogradouro;
    }

    public String getNomeTipoLogradouro() {
        return nomeTipoLogradouro;
    }

    public void setNomeTipoLogradouro(String nomeTipoLogradouro) {
        this.nomeTipoLogradouro = nomeTipoLogradouro;
    }

    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public long getSeqEnderecoCidade() {
        return seqEnderecoCidade;
    }

    public void setSeqEnderecoCidade(long seqEnderecoCidade) {
        this.seqEnderecoCidade = seqEnderecoCidade;
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
