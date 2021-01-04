/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.principal;


import br.com.folha.control.cadastro.parametros.ControleCadastroBancos;
import br.com.folha.control.cadastro.parametros.ControleCadastroCargaHorariaSemanal;
import br.com.folha.control.cadastro.parametros.ControleCadastroCarreiras;
import br.com.folha.control.cadastro.parametros.ControleCadastroCidades;
import br.com.folha.control.cadastro.parametros.ControleCadastroEscolaridades;
import br.com.folha.control.cadastro.parametros.ControleCadastroEstadoCivil;
import br.com.folha.control.cadastro.parametros.ControleCadastroHabilitacaoCategorias;
import br.com.folha.control.cadastro.parametros.ControleCadastroPrivilegio;
import br.com.folha.control.cadastro.parametros.ControleCadastroSexos;
import br.com.folha.control.cadastro.parametros.ControleCadastroSituacoes;
import br.com.folha.control.cadastro.parametros.ControleCadastroTiposFiliacao;
import br.com.folha.control.cadastro.parametros.ControleCadastroTiposLogradouro;
import br.com.folha.control.cadastro.parametros.ControleCadastroUnidadesNaturezaJuridica;
import br.com.folha.control.cadastro.parametros.ControleCadastroVinculos;
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
    
    BeanPrincipal beanPrincipal;
    TelaPrincipal telaPrincipal;
    
    public ControlePrincipal( BeanPrincipal beanPrincipal, TelaPrincipal telaPrincipal){
        
        this.beanPrincipal = beanPrincipal;
        this.telaPrincipal = telaPrincipal;
        
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
    
    
    
    
    //Métodos que chamam as telas.
    
    public void abrirCadastroCaareiras(){
        ControleCadastroCarreiras ca = new ControleCadastroCarreiras();
        ca.abrirFrame(this, beanPrincipal);
    }
    
    public void abrirCadastroBancos(){
        ControleCadastroBancos cb = new ControleCadastroBancos();
        cb.abrirFrame(this, beanPrincipal);
    }
    
    public void abrirCadastroUnidadesNaturezaJuridica(){
        ControleCadastroUnidadesNaturezaJuridica nj = new ControleCadastroUnidadesNaturezaJuridica();
        nj.abrirFrame(this, beanPrincipal);
    }
    
    public void abrirCadastroTiposLogradouro(){
        ControleCadastroTiposLogradouro tl = new ControleCadastroTiposLogradouro();
        tl.abrirFrame(this, beanPrincipal);
    }
    
    
    public void abrirCadastroTiposFiliacao(){
        ControleCadastroTiposFiliacao tf = new ControleCadastroTiposFiliacao();
        tf.abrirFrame(this, beanPrincipal);
    }
    
    public void abrirCadastroSituacoes(){
        ControleCadastroSituacoes si = new ControleCadastroSituacoes();
        si.abrirFrame(this, beanPrincipal);
    }
     
    public void abrirCadastroHabilitacaoCategorias(){
        ControleCadastroHabilitacaoCategorias h = new ControleCadastroHabilitacaoCategorias();
        h.abrirFrame(this, beanPrincipal);
    }
    
    public void abrirCadastroSexos(){
        ControleCadastroSexos sx = new ControleCadastroSexos();
        sx.abrirFrame(this, beanPrincipal);
    }
     
    public void abrirCadastroEstadoCivil(){
        ControleCadastroEstadoCivil ec = new ControleCadastroEstadoCivil();
        ec.abrirFrame(this, beanPrincipal);
    }
     
    public void abrirCadastroEscolaridades(){
        ControleCadastroEscolaridades e = new ControleCadastroEscolaridades();
        e.abrirFrame(this, beanPrincipal);
    }
    
    public void abrirCadastroCidades(){
        ControleCadastroCidades c = new ControleCadastroCidades();
        c.abrirFrame(this, beanPrincipal);
    }
    
    public void abrirCadastroPrivilegios(){
        ControleCadastroPrivilegio p = new ControleCadastroPrivilegio();
        p.abrirFrame(this, beanPrincipal);
    }
   
    
    public void abrirCadastroVinculos(){
        ControleCadastroVinculos v = new ControleCadastroVinculos();
        v.abrirFrame(this, beanPrincipal);
    }
    
  
    public void abrirCadastroCargaHorariaSemanal(){
        ControleCadastroCargaHorariaSemanal ch = new ControleCadastroCargaHorariaSemanal();
        ch.abrirFrame(this, beanPrincipal);
    }  
    
}