/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.parametros.cadastros.cargaHorariaSemanal;

import br.com.folha.view.login.Login;

/**
 *
 * @author andrei
 */
public class BeanLogin {
    
    public Login login;
    String operador;
    String privilegio;
    int seq_operador;
    int seq_privilegio;

    public BeanLogin() {
    }

    public BeanLogin(String operador, String privilegio, int seq_operador, int seq_privilegio) {
        this.operador = operador;
        this.privilegio = privilegio;
        this.seq_operador = seq_operador;
        this.seq_privilegio = seq_privilegio;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    
    
    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public int getSeq_operador() {
        return seq_operador;
    }

    public void setSeq_operador(int seq_operador) {
        this.seq_operador = seq_operador;
    }

    public int getSeq_privilegio() {
        return seq_privilegio;
    }

    public void setSeq_privilegio(int seq_privilegio) {
        this.seq_privilegio = seq_privilegio;
    }

    
    

    


}
