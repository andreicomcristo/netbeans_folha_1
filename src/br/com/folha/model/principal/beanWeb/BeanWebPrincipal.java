/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.principal.beanWeb;

import br.com.folha.view.principal.TelaPrincipal;

/**
 *
 * @author andrei
 */
public class BeanWebPrincipal {
    
    
    private String operador;
    private String cpf;
    private String privilegio;
    private String seqOperador;
    private String seqPrivilegio;

    public BeanWebPrincipal() {
    }

    public BeanWebPrincipal(String operador, String cpf, String privilegio, String seqOperador, String seqPrivilegio) {
        this.operador = operador;
        this.cpf = cpf;
        this.privilegio = privilegio;
        this.seqOperador = seqOperador;
        this.seqPrivilegio = seqPrivilegio;
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

    public String getSeqOperador() {
        return seqOperador;
    }

    public void setSeqOperador(String seqOperador) {
        this.seqOperador = seqOperador;
    }

    public String getSeqPrivilegio() {
        return seqPrivilegio;
    }

    public void setSeqPrivilegio(String seqPrivilegio) {
        this.seqPrivilegio = seqPrivilegio;
    }

    
    


}
