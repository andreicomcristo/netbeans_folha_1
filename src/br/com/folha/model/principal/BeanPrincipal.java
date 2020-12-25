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
    private long seqOperador;
    private long seqPrivilegio;

    public BeanPrincipal() {
    }

    public BeanPrincipal(String operador, String cpf, String privilegio, long seqOperador, long seqPrivilegio) {
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
