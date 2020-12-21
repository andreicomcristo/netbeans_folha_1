/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.principal;


import br.com.folha.control.parametros.cadastros.ch_semanal.ControleCadastroCargaHorariaSemanal;
import br.com.folha.model.parametros.cadastros.cargaHorariaSemanal.BeanPrincipal;
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


public class ControlePrincipal extends BeanPrincipal {
    
    
    public void abrirFrame(String operador, String privilegio, int seq_operador, int seq_privilegio){
        
        this.setOperador(operador);
        this.setPrivilegio(privilegio);
        this.setSeq_operador(seq_operador);
        this.setSeq_privilegio(seq_privilegio);
        
        this.setPrincipal(new Principal(this));
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
        c.abrirFrame(this);
    }
 
    
    
    
}