/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package folha.control.br.com.parametros.cadastros.ch_semanal;


import folha.dao.br.com.parametros.cadastros.ch_semanal.DaoCargaHorariaSemanal;
import folha.model.br.com.parametros.cadastros.ch_semanal.CargaHorariaSemanal;
import folha.util.UtilidadesDeTexto;
import folha.view.br.com.parametros.cadastros.ch_semanal.CadastroCargaHorariaSemanal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andrei
 */
public class AcoesCadastroCargaHorariaSemanal {
    
    int SEQ_OPERADOR;
    int SEQ_PRIVILEGIO;
        
    AcoesCadastroCargaHorariaSemanal acoesCadastroCH_SEMANAL;
    CadastroCargaHorariaSemanal cadastroCH_SEMANAL;
    CargaHorariaSemanal ch_semanal = new CargaHorariaSemanal();
    DaoCargaHorariaSemanal daoCH_SEMANAL = new DaoCargaHorariaSemanal();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(){
        acoesCadastroCH_SEMANAL = this;
        CadastroCargaHorariaSemanal c = new CadastroCargaHorariaSemanal();
        cadastroCH_SEMANAL = c;
        c.setDadosIniciais(cadastroCH_SEMANAL, this);
        c.setVisible(true);
    }
    
    public boolean cadastrar(String cH, String dESCRICAO_CH){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        cH = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cH);
        dESCRICAO_CH = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(dESCRICAO_CH);
        
        if(cH.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carga horária válida.");}
        
        if(acaoValida==true){
            ch_semanal.setSEQ_CH_SEMANAL(0);
            ch_semanal.setCH(Integer.parseInt(cH));
            ch_semanal.setDESCRICAO_CH(dESCRICAO_CH);
            executou =daoCH_SEMANAL.inserir_CH_SEMANAL(ch_semanal);
        }
        return executou;
    }
    
    public boolean excluir(String sEQ_CH_SEMANAL){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        sEQ_CH_SEMANAL = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(sEQ_CH_SEMANAL);
        
        if(sEQ_CH_SEMANAL==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(sEQ_CH_SEMANAL.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        if(acaoValida==true){
            ch_semanal.setSEQ_CH_SEMANAL(Integer.parseInt(sEQ_CH_SEMANAL));
            ch_semanal.setCH(0);
            ch_semanal.setDESCRICAO_CH("");
            executou =daoCH_SEMANAL.excluir_CH_SEMANAL(ch_semanal);
        }
        return executou;
    }
    
    public boolean alterar(String sEQ_CH_SEMANAL, String cH, String dESCRICAO_CH){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        sEQ_CH_SEMANAL = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(sEQ_CH_SEMANAL);
        cH = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cH);
        dESCRICAO_CH = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(dESCRICAO_CH);
                
        // conferindo se a linha foi escolhida
        if(sEQ_CH_SEMANAL==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(sEQ_CH_SEMANAL.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(cH.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carga horária válida.");}
        
        if(acaoValida==true){
            executou =daoCH_SEMANAL.alterar_CH_SEMANAL(ch_semanal);
        }
            return executou;
    }
    
    public List<CargaHorariaSemanal> selecionar(){
        List dados =daoCH_SEMANAL.selecionar_CH_SEMANAL();
        return dados;
    }
 
    
    
    
}