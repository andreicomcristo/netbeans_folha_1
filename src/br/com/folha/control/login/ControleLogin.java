/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.login;


import br.com.folha.dao.parametros.cadastros.cargaHorariaSemanal.DaoCargaHorariaSemanal;
import br.com.folha.model.parametros.cadastros.cargaHorariaSemanal.BeanCargaHorariaSemanal;
import br.com.folha.model.parametros.cadastros.cargaHorariaSemanal.BeanLogin;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.login.Login;

/**
 *
 * @author andrei
 */
public class ControleLogin extends BeanLogin{
    
        
    
    BeanCargaHorariaSemanal cargaHorariaSemanal = new BeanCargaHorariaSemanal();
    DaoCargaHorariaSemanal daoCargaHorariaSemanal = new DaoCargaHorariaSemanal();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    
    
    public void abrirFrameLogin(ControleLogin controleLogin){
        setLogin(new Login(this));
        login.setVisible(true);
    }
    
    
    
    
 
    
    
    
}