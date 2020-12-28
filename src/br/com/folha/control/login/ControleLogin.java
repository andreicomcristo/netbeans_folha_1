/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.login;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.login.dao.DaoLogin;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.view.login.TelaLogin;
import br.com.folha.view.principal.TelaPrincipal;

/**
 *
 * @author andrei
 */
public class ControleLogin {
    
    
    DaoLogin daoLogin;
    TelaLogin telaLogin;
    
    BeanPrincipal beanPrincipal;
    TelaPrincipal telaPrincipal;
    
    
    
    public void abrirFrameLogin(ControleLogin controleLogin){
        telaLogin = (new TelaLogin(this, beanPrincipal));
        telaLogin.setTitle("SISTEMA FOLHA SESAU");
        telaLogin.setVisible(true);
    }
    
    public void abrirFrameLogin(ControleLogin controleLogin, DaoLogin daoLogin, TelaLogin telaLogin, BeanPrincipal beanPrincipal,    TelaPrincipal telaPrincipal){
        
        this.daoLogin = daoLogin;
        this.beanPrincipal = beanPrincipal;
        this.telaPrincipal = telaPrincipal;
        
        this.telaLogin = (new TelaLogin(this, beanPrincipal));
        this.telaLogin.setTitle("SISTEMA FOLHA SESAU");
        this.telaLogin.setVisible(true);
    }
    
    
    public boolean validacaoOperadorLogin(String cpf1, String senha){ 
        
        boolean operadorValido = daoLogin.selecionarOperadorValido(cpf1, senha);
        
        if (operadorValido == true) {
            beanPrincipal = obterOperadorLogado(cpf1);
            ControlePrincipal telaPrincipal = new ControlePrincipal(beanPrincipal, this.telaPrincipal);
            telaPrincipal.abrirFrame();
            return true;
        } else return false;
    }
    
    
    public BeanPrincipal obterOperadorLogado(String cpf1){
        BeanPrincipal operadorLogado =  daoLogin.selecionarOperadorLogado(cpf1);
    return operadorLogado;
    }
     
    
}