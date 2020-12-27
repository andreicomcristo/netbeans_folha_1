/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.login.bean;

/**
 *
 * @author andrei
 */
public class BeanOperadorLogado { 
    
    private String nome;
    private String cpf;
    private String privilegio;
    private long seqOperador;
    private long seqPrivilegio;
    

    public BeanOperadorLogado() {
    }

    public BeanOperadorLogado(String nome, String cpf, String privilegio, long seqOperador, long seqPrivilegio) {
        this.nome = nome;
        this.cpf = cpf;
        this.privilegio = privilegio;
        this.seqOperador = seqOperador;
        this.seqPrivilegio = seqPrivilegio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public long getSeqOperador() {
        return seqOperador;
    }

    public void setSeqOperador(long seqOperador) {
        this.seqOperador = seqOperador;
    }

    public long getSeqPrivilegio() {
        return seqPrivilegio;
    }

    public void setSeqPrivilegio(long seqPrivilegio) {
        this.seqPrivilegio = seqPrivilegio;
    }

}
