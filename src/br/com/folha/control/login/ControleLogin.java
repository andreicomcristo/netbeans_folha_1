/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.login;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.dao.login.DaoLogin;
import br.com.folha.model.login.BeanOperadorLogado;
import br.com.folha.view.login.Login;

/**
 *
 * @author andrei
 */
public class ControleLogin extends BeanOperadorLogado{
    
    BeanOperadorLogado beanOperadorLogado = new BeanOperadorLogado();
    DaoLogin daoLogin = new DaoLogin();
    Login login;
    
    
    public void abrirFrameLogin(ControleLogin controleLogin){
        login = (new Login(this));
        login.setTitle("SISTEMA FOLHA SESAU");
        login.setVisible(true);
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