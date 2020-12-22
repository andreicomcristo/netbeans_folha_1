/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.principal;

import br.com.folha.view.principal.Principal;

/**
 *
 * @author andrei
 */
public class BeanPrincipal {
    
    private Principal principal;
    private String operador;
    private String cpf;
    private String privilegio;
    private int seqOperador;
    private int seqPrivilegio;

    public BeanPrincipal() {
    }

    public BeanPrincipal(String operador, String cpf, String privilegio, int seqOperador, int seqPrivilegio) {
        this.operador = operador;
        this.cpf = cpf;
        this.privilegio = privilegio;
        this.seqOperador = seqOperador;
        this.seqPrivilegio = seqPrivilegio;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
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
