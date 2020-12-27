/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.inicio;

import br.com.folha.control.login.ControleLogin;

/**
 *
 * @author aom
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ControleLogin c = new ControleLogin();
        c.abrirFrameLogin(c);
    }
    
}
