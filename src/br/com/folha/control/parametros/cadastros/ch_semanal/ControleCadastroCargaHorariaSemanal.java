/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.parametros.cadastros.ch_semanal;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.dao.parametros.cadastros.cargaHorariaSemanal.DaoCargaHorariaSemanal;
import br.com.folha.model.parametros.cadastros.cargaHorariaSemanal.BeanCargaHorariaSemanal;
import br.com.folha.model.util.UtilidadesDeTexto;
import br.com.folha.view.parametros.cadastros.cargaHorariaSemanal.CadastroCargaHorariaSemanal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andrei
 */
public class ControleCadastroCargaHorariaSemanal extends BeanCargaHorariaSemanal{
    
        
    CadastroCargaHorariaSemanal cadastroCargaHorariaSemanal;
    BeanCargaHorariaSemanal cargaHorariaSemanal = new BeanCargaHorariaSemanal();
    DaoCargaHorariaSemanal daoCargaHorariaSemanal = new DaoCargaHorariaSemanal();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    public void abrirFrame(ControlePrincipal controlePrincipal){
        this.setControlePrincipal(controlePrincipal);
        cadastroCargaHorariaSemanal  = new CadastroCargaHorariaSemanal(this);
        cadastroCargaHorariaSemanal.setVisible(true);
    }
    
    public boolean cadastrar(String cargaHoraria, String descricaoCargaHoraria){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        cargaHoraria = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargaHoraria);
        descricaoCargaHoraria = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCargaHoraria);
        
        if(cargaHoraria.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carga horária válida.");}
        
        if(acaoValida==true){
            cargaHorariaSemanal.setSeqCargaHorariaSemanal(0);
            cargaHorariaSemanal.setCargaHoraria(Integer.parseInt(cargaHoraria));
            cargaHorariaSemanal.setDescricaoCargaHoraria(descricaoCargaHoraria);
            executou =daoCargaHorariaSemanal.inserirCargaHorariaSemanal(cargaHorariaSemanal);
            
            cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqCargaHorariaSemanal){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqCargaHorariaSemanal = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqCargaHorariaSemanal);
        
        if(seqCargaHorariaSemanal==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqCargaHorariaSemanal.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        if(acaoValida==true){
            cargaHorariaSemanal.setSeqCargaHorariaSemanal(Integer.parseInt(seqCargaHorariaSemanal));
            cargaHorariaSemanal.setCargaHoraria(0);
            cargaHorariaSemanal.setDescricaoCargaHoraria("");
            executou =daoCargaHorariaSemanal.excluirCargaHorariaSemanal(cargaHorariaSemanal);
            
            cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqCargaHorariaSemanal, String cargaHoraria, String descricaoCargaHoraria){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqCargaHorariaSemanal = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqCargaHorariaSemanal);
        cargaHoraria = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargaHoraria);
        descricaoCargaHoraria = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCargaHoraria);
                
        // conferindo se a linha foi escolhida
        if(seqCargaHorariaSemanal==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqCargaHorariaSemanal.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(cargaHoraria.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carga horária válida.");}
        
        if (acaoValida){
            cargaHorariaSemanal.setSeqCargaHorariaSemanal(Integer.parseInt(seqCargaHorariaSemanal));
            cargaHorariaSemanal.setCargaHoraria(Integer.parseInt(cargaHoraria));
            cargaHorariaSemanal.setDescricaoCargaHoraria(descricaoCargaHoraria);
            
            executou =daoCargaHorariaSemanal.alterarCargaHorariaSemanal(cargaHorariaSemanal);
            
            cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCargaHorariaSemanal> selecionar(){
        List dados =daoCargaHorariaSemanal.selecionarCargaHorariaSemanal();
        return dados;
    }
 
    
    
    
}