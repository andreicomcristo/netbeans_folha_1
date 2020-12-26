/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.principal;


import br.com.folha.control.cadastro.parametros.ControleCadastroCargaHorariaSemanal;
import br.com.folha.model.login.bean.BeanOperadorLogado;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.view.principal.Principal;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;

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
        
       
        
        this.setPrincipal(new Principal(this));
        getPrincipal().setDefaultCloseOperation(getPrincipal().EXIT_ON_CLOSE);
        
        // dimensionamento
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        getPrincipal().setSize(width-20, height-100);
        getPrincipal().setLocationRelativeTo(null);
    
        Date hoje = new Date();
        String dia = String.valueOf(hoje.getDate());
        if(dia.length()<2){dia = "0"+dia;}
        String mes = String.valueOf(hoje.getMonth()+1);
        if(mes.length()<2){mes = "0"+mes;}
        String ano = String.valueOf(hoje.getYear()+1900);
        String nomeDia = "";
        
        switch(hoje.getDay()){
            case 0 :
                nomeDia = "Domingo"; break;
            case 1 :
                nomeDia = "Segunda-feira"; break;
            case 2 :
                nomeDia = "Terça-feira"; break;
            case 3 :
                nomeDia = "Quarta-feira"; break;
            case 4 :
                nomeDia = "Quinta-feira"; break;
            case 5 :
                nomeDia = "Sexta-feira"; break;
            case 6 :
                nomeDia = "Sábado"; break;
        }
                
        
        
        getPrincipal().setTitle("["+getCpf()+"]"+" ["+getOperador()+"]"+" ["+getPrivilegio()+"] "+nomeDia +", "+dia+"-"+mes+"-"+ano+".");
        
        getPrincipal().setVisible(true);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void abrirCadastroCargaHorariaSemanal(){
        ControleCadastroCargaHorariaSemanal c = new ControleCadastroCargaHorariaSemanal();
        c.abrirFrame(this);
    }
 
    
    
    
}