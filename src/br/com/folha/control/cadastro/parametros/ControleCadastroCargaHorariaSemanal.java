/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.dao.DaoCargaHorariaSemanal;
import br.com.folha.model.cadastro.parametros.bean.BeanCargaHorariaSemanal;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroCargaHorariaSemanal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andrei
 */
public class ControleCadastroCargaHorariaSemanal {
    
    ControlePrincipal controlePrincipal;    
    BeanPrincipal beanPrincipal;
    
    TelaCadastroCargaHorariaSemanal cadastroCargaHorariaSemanal;
    BeanCargaHorariaSemanal beanCargaHorariaSemanal = new BeanCargaHorariaSemanal();
    
    DaoCargaHorariaSemanal daoCargaHorariaSemanal = new DaoCargaHorariaSemanal();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        cadastroCargaHorariaSemanal  = new TelaCadastroCargaHorariaSemanal(this, beanCargaHorariaSemanal);
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
            beanCargaHorariaSemanal.setSeqCargaHorariaSemanal(0);
            beanCargaHorariaSemanal.setCargaHoraria(Integer.parseInt(cargaHoraria));
            beanCargaHorariaSemanal.setDescricaoCargaHoraria(descricaoCargaHoraria);
            executou = daoCargaHorariaSemanal.inserirCargaHorariaSemanal(beanCargaHorariaSemanal);
            
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
            beanCargaHorariaSemanal.setSeqCargaHorariaSemanal(Integer.parseInt(seqCargaHorariaSemanal));
            beanCargaHorariaSemanal.setCargaHoraria(0);
            beanCargaHorariaSemanal.setDescricaoCargaHoraria("");
            executou =daoCargaHorariaSemanal.excluirCargaHorariaSemanal(beanCargaHorariaSemanal);
            
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
            beanCargaHorariaSemanal.setSeqCargaHorariaSemanal(Integer.parseInt(seqCargaHorariaSemanal));
            beanCargaHorariaSemanal.setCargaHoraria(Integer.parseInt(cargaHoraria));
            beanCargaHorariaSemanal.setDescricaoCargaHoraria(descricaoCargaHoraria);
            
            executou =daoCargaHorariaSemanal.alterarCargaHorariaSemanal(beanCargaHorariaSemanal);
            
            cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCargaHorariaSemanal> selecionar(){
        List dados =daoCargaHorariaSemanal.selecionarCargaHorariaSemanal();
        return dados;
    }
 
    
    
    
}