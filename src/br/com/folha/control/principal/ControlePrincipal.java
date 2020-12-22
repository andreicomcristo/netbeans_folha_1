/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.principal;


import br.com.folha.control.parametros.cadastros.ch_semanal.ControleCadastroCargaHorariaSemanal;
import br.com.folha.model.login.BeanOperadorLogado;
import br.com.folha.model.principal.BeanPrincipal;
import br.com.folha.view.principal.Principal;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author andrei
 */



public class ControlePrincipal extends BeanPrincipal {
    
    public ControlePrincipal(BeanOperadorLogado beanOperadorLogado){
        this.setOperador(beanOperadorLogado.getNome());
        this.setCpf(beanOperadorLogado.getCpf());
        this.setPrivilegio(beanOperadorLogado.getPrivilegio());
        this.setSeqOperador(beanOperadorLogado.getSeqOperador());
        this.setSeqPrivilegio(beanOperadorLogado.getSeqPrivilegio());
    } 
    
    public void abrirFrame(){
        
        /*  Os atributos acima devem ser referenciados na validação da classe
            login da camada controler e o método abrirFrame deve receber o valor 
            boolen retornado do objeto ControleLogin para abrir a tela principal.
        */       
        
        this.setPrincipal(new Principal(this));
        getPrincipal().setDefaultCloseOperation(getPrincipal().EXIT_ON_CLOSE);
        
        // dimensionamento
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        getPrincipal().setSize(width-20, height-100);
        getPrincipal().setLocationRelativeTo(null);
    
        getPrincipal().setTitle("["+getCpf()+"]"+" ["+getOperador()+"]"+" ["+getPrivilegio()+"]");
        
        getPrincipal().setVisible(true);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void abrirCadastroCargaHorariaSemanal(){
        ControleCadastroCargaHorariaSemanal c = new ControleCadastroCargaHorariaSemanal();
        c.abrirFrame(this);
    }
 
    
    
    
}