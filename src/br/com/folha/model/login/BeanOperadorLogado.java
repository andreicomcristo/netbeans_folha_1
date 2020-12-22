/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.login;

import br.com.folha.view.login.Login;

/**
 *
 * @author andrei
 */
public class BeanOperadorLogado { 
    private Login login;
    private String nome;
    private String cpf;
    private String privilegio;
    private int seqOperador;
    private int seqPrivilegio;
    

    public BeanOperadorLogado() {
    }

    public BeanOperadorLogado(String nome, String cpf, String privilegio, int seqOperador, int seqPrivilegio) {
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

    public int getSeqOperador() {
        return seqOperador;
    }

    public void setSeqOperador(int seqOperador) {
        this.seqOperador = seqOperador;
    }

    public int getSeqPrivilegio() {
        return seqPrivilegio;
    }

    public void setSeqPrivilegio(int seqPrivilegio) {
        this.seqPrivilegio = seqPrivilegio;
    }

    

    


}
