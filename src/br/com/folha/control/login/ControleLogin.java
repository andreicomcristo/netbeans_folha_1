/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.login;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.dao.login.DaoLogin;
import br.com.folha.model.login.BeanOperadorLogado;
import br.com.folha.view.login.Login;
import javax.swing.JOptionPane;

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
        login.setVisible(true);
    }
    
    
    public boolean validacaoOperadorLogin(String cpf1, String senha){ 
        
        boolean operadorValido = daoLogin.selecionarOperadorValido(cpf1, senha);
        
        //boolean operadorValido = operadorValido(cpf1, senha);
        if (operadorValido == true) {
            beanOperadorLogado = obterOperadorLogado(cpf1);
            //login.dispose(); coloquei ese comando no botão
            ControlePrincipal telaPrincipal = new ControlePrincipal(beanOperadorLogado);
            telaPrincipal.abrirFrame();
            return true;
           // abrirContolePrincipal();
        } else return false;
    }
    
   /* public boolean operadorValido(String cpf, String senha){
        boolean resposta = daoLogin.selecionarOperadorValido(cpf, senha);
    return resposta;
    }*/
    
    public BeanOperadorLogado obterOperadorLogado(String cpf1){
        BeanOperadorLogado operadorLogado =  daoLogin.selecionarOperadorLogado(cpf1);
    return operadorLogado;
    }
     
    /*public void abrirContolePrincipal(){
        ControlePrincipal telaPrincipal = new ControlePrincipal(beanOperadorLogado);
        telaPrincipal.abrirFrame();
    }*/
    
}