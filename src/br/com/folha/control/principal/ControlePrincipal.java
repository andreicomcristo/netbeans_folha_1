/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.principal;


import br.com.folha.control.cadastro.parametros.ControleCadastroCargaHorariaSemanal;
import br.com.folha.model.login.bean.BeanOperadorLogado;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.view.principal.TelaPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;

/**
 *
 * @author andrei
 */



public class ControlePrincipal {
    
    BeanPrincipal beanPrincipal = new BeanPrincipal();
    TelaPrincipal telaPrincipal = new TelaPrincipal();
    
    public ControlePrincipal(BeanOperadorLogado beanOperadorLogado){
        beanPrincipal.setOperador(beanOperadorLogado.getNome());
        beanPrincipal.setCpf(beanOperadorLogado.getCpf());
        beanPrincipal.setPrivilegio(beanOperadorLogado.getPrivilegio());
        beanPrincipal.setSeqOperador(beanOperadorLogado.getSeqOperador());
        beanPrincipal.setSeqPrivilegio(beanOperadorLogado.getSeqPrivilegio());
    } 
    
    public void abrirFrame(){
        
       
        
        telaPrincipal = (new TelaPrincipal(this, beanPrincipal));
        telaPrincipal.setDefaultCloseOperation(telaPrincipal.EXIT_ON_CLOSE);
        
        // dimensionamento
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        telaPrincipal.setSize(width-20, height-100);
        telaPrincipal.setLocationRelativeTo(null);
    
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
                
        
        
        telaPrincipal.setTitle("Operador logado: "+" ["+beanPrincipal.getOperador()+"]"+" ["+beanPrincipal.getPrivilegio()+"] "+nomeDia +", "+dia+"-"+mes+"-"+ano+".");
        
        telaPrincipal.setVisible(true);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void abrirCadastroCargaHorariaSemanal(){
        ControleCadastroCargaHorariaSemanal c = new ControleCadastroCargaHorariaSemanal();
        c.abrirFrame(this, beanPrincipal);
    }
 
    
    
    
}