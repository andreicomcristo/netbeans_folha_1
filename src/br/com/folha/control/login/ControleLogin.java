/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.login;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.login.dao.DaoLogin;
import br.com.folha.model.login.bean.BeanOperadorLogado;
import br.com.folha.view.login.TelaLogin;

/**
 *
 * @author andrei
 */
public class ControleLogin {
    
    BeanOperadorLogado beanOperadorLogado = new BeanOperadorLogado();
    DaoLogin daoLogin = new DaoLogin();
    TelaLogin telaLogin;
    
    
    public void abrirFrameLogin(ControleLogin controleLogin){
        telaLogin = (new TelaLogin(this, beanOperadorLogado));
        telaLogin.setTitle("SISTEMA FOLHA SESAU");
        telaLogin.setVisible(true);
    }
    
    
    public boolean validacaoOperadorLogin(String cpf1, String senha){ 
        
        boolean operadorValido = daoLogin.selecionarOperadorValido(cpf1, senha);
        
        if (operadorValido == true) {
            beanOperadorLogado = obterOperadorLogado(cpf1);
            ControlePrincipal telaPrincipal = new ControlePrincipal(beanOperadorLogado);
            telaPrincipal.abrirFrame();
            return true;
        } else return false;
    }
    
    
    public BeanOperadorLogado obterOperadorLogado(String cpf1){
        BeanOperadorLogado operadorLogado =  daoLogin.selecionarOperadorLogado(cpf1);
    return operadorLogado;
    }
     
    
}