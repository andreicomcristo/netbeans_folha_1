/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.parametros.cadastros.ch_semanal;


import br.com.folha.dao.parametros.cadastros.cargaHorariaSemanal.DaoCargaHorariaSemanal;
import br.com.folha.model.parametros.cadastros.cargaHorariaSemanal.CargaHorariaSemanal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.parametros.cadastros.cargaHorariaSemanal.CadastroCargaHorariaSemanal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andrei
 */
public class ControleCadastroCargaHorariaSemanal {
    
    int seq_operador;
    int seq_privilegio;
        
    ControleCadastroCargaHorariaSemanal controleCadastroCargaHorariaSemanal;
    CadastroCargaHorariaSemanal cadastroCargaHorariaSemanal;
    CargaHorariaSemanal cargaHorariaSemanal = new CargaHorariaSemanal();
    DaoCargaHorariaSemanal daoCargaHorariaSemanal = new DaoCargaHorariaSemanal();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(){
        controleCadastroCargaHorariaSemanal = this;
        CadastroCargaHorariaSemanal c = new CadastroCargaHorariaSemanal();
        cadastroCargaHorariaSemanal = c;
        c.setDadosIniciais(this);
        c.clicaBotaoBuscar();
        c.setVisible(true);
    }
    
    public boolean cadastrar(String cargaHoraria, String descricaoCargaHoraria){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        cargaHoraria = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargaHoraria);
        descricaoCargaHoraria = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCargaHoraria);
        
        if(cargaHoraria.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carga horária válida.");}
        
        if(acaoValida==true){
            cargaHorariaSemanal.setSeq_carga_horaria_sem(0);
            cargaHorariaSemanal.setCarga_horaria(Integer.parseInt(cargaHoraria));
            cargaHorariaSemanal.setDescricao_carga_horaria(descricaoCargaHoraria);
            executou =daoCargaHorariaSemanal.inserirCargaHorariaSemanal(cargaHorariaSemanal);
            
            cadastroCargaHorariaSemanal.clicaBotaoBuscar();
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
            cargaHorariaSemanal.setSeq_carga_horaria_sem(Integer.parseInt(seqCargaHorariaSemanal));
            cargaHorariaSemanal.setCarga_horaria(0);
            cargaHorariaSemanal.setDescricao_carga_horaria("");
            executou =daoCargaHorariaSemanal.excluirCargaHorariaSemanal(cargaHorariaSemanal);
            
            cadastroCargaHorariaSemanal.clicaBotaoBuscar();
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
        
        if(acaoValida==true){
            cargaHorariaSemanal.setSeq_carga_horaria_sem(Integer.parseInt(seqCargaHorariaSemanal));
            cargaHorariaSemanal.setCarga_horaria(Integer.parseInt(cargaHoraria));
            cargaHorariaSemanal.setDescricao_carga_horaria(descricaoCargaHoraria);
            
            executou =daoCargaHorariaSemanal.alterarCargaHorariaSemanal(cargaHorariaSemanal);
            
            cadastroCargaHorariaSemanal.clicaBotaoBuscar();
        }
            return executou;
    }
    
    public List<CargaHorariaSemanal> selecionar(){
        List dados =daoCargaHorariaSemanal.selecionarCargaHorariaSemanal();
        return dados;
    }
 
    
    
    
}