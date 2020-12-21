/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.principal;


import br.com.folha.control.parametros.cadastros.ch_semanal.ControleCadastroCargaHorariaSemanal;
import br.com.folha.dao.parametros.cadastros.cargaHorariaSemanal.DaoCargaHorariaSemanal;
import br.com.folha.model.parametros.cadastros.cargaHorariaSemanal.CargaHorariaSemanal;
import br.com.folha.folha.util.UtilidadesDeTexto;
import br.com.folha.view.principal.Principal;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.JMenuBar;

/**
 *
 * @author andrei
 */

class VerticalMenuBar extends JMenuBar {
  private static final LayoutManager grid = new GridLayout(0,1);
  public VerticalMenuBar() {
    setLayout(grid);
  }
}



public class ControlePrincipal {
    
    int seq_operador;
    int seq_privilegio;
        
    ControlePrincipal ControlePrincipal;
    Principal principal;
    ControleCadastroCargaHorariaSemanal controleCadastroCargaHorariaSemanal = new ControleCadastroCargaHorariaSemanal();
    CargaHorariaSemanal cargaHorariaSemanal = new CargaHorariaSemanal();
    DaoCargaHorariaSemanal daoCargaHorariaSemanal = new DaoCargaHorariaSemanal();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(){
        ControlePrincipal = this;
        Principal principal = new Principal();
        this.principal = principal;
        principal.setDadosIniciais(ControlePrincipal);
        principal.setDefaultCloseOperation(principal.EXIT_ON_CLOSE);
        
        // dimensionamento
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        principal.setSize(width-20, height-100);
        principal.setLocationRelativeTo(null);
    
        principal.setVisible(true);
        
    }
    
    
    public void abrirCadastroCargaHorariaSemanal(){
        ControleCadastroCargaHorariaSemanal c = new ControleCadastroCargaHorariaSemanal();
        c.abrirFrame();
    }
 
    
    
    
}