/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.inicio;

import br.com.folha.control.login.ControleLogin;
import br.com.folha.model.dao.login.dao.DaoLogin;
import br.com.folha.model.bean.principal.beanSwing.BeanPrincipal;
import br.com.folha.view.login.TelaLogin;
import br.com.folha.view.principal.TelaPrincipal;

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
        
        BeanPrincipal beanPrincipal = new BeanPrincipal();
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        
        DaoLogin daoLogin = new DaoLogin();
        ControleLogin controleLogin = new ControleLogin();
        TelaLogin telaLogin = new TelaLogin(controleLogin, beanPrincipal);
        
        
        
        
        controleLogin.abrirFrameLogin(controleLogin, daoLogin, telaLogin, beanPrincipal, telaPrincipal);
    }
    
}
