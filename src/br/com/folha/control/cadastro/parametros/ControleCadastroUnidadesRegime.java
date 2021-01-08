/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroUnidadesRegime;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroUnidadesRegime;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroUnidadesRegime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */

public class ControleCadastroUnidadesRegime {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroUnidadesRegime telaCadastroUnidadesRegime;
    BeanCadastroUnidadesRegime beanCadastroUnidadesRegime = new BeanCadastroUnidadesRegime();
    
    DaoCadastroUnidadesRegime daoCadastroUnidadesRegime = new DaoCadastroUnidadesRegime();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroUnidadesRegime  = new TelaCadastroUnidadesRegime(this,beanCadastroUnidadesRegime);
        telaCadastroUnidadesRegime.setVisible(true);
    }
    
    public boolean cadastrar(String siglaUnidadeRegime, String nomeUnidadeRegime, String descricaoUnidadeRegime){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        siglaUnidadeRegime = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaUnidadeRegime);
        nomeUnidadeRegime = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeUnidadeRegime);
        descricaoUnidadeRegime = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoUnidadeRegime);
        
        if(siglaUnidadeRegime.length()==0 || nomeUnidadeRegime.length()==0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escrever uma unidade válida.");
        }
        
        if(acaoValida==true){
            beanCadastroUnidadesRegime.setSeqRegimeUnidLotacao(0);
            beanCadastroUnidadesRegime.setSiglaRegimeUnidLotacao(siglaUnidadeRegime);
            beanCadastroUnidadesRegime.setNomeRegimeUnidLotacao(nomeUnidadeRegime);
            beanCadastroUnidadesRegime.setDescricaoRegimeUnidLotacao(descricaoUnidadeRegime);
            executou = daoCadastroUnidadesRegime.inserirUnidadeRegime(beanCadastroUnidadesRegime);
            telaCadastroUnidadesRegime.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqUnidadeRegime){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqUnidadeRegime = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqUnidadeRegime);
        
        if(seqUnidadeRegime==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqUnidadeRegime.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            beanCadastroUnidadesRegime.setSeqRegimeUnidLotacao(Integer.parseInt(seqUnidadeRegime));
            beanCadastroUnidadesRegime.setSiglaRegimeUnidLotacao("");
            beanCadastroUnidadesRegime.setNomeRegimeUnidLotacao("");
            beanCadastroUnidadesRegime.setDescricaoRegimeUnidLotacao("");
            executou =daoCadastroUnidadesRegime.excluirUnidadeRegime(beanCadastroUnidadesRegime);
            
            telaCadastroUnidadesRegime.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqUnidadeRegime, String siglaUnidadeRegime, String nomeUnidadeRegime, String descricaoUnidadeRegime){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqUnidadeRegime = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqUnidadeRegime);
        siglaUnidadeRegime = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaUnidadeRegime);
        nomeUnidadeRegime = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeUnidadeRegime);
        descricaoUnidadeRegime = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoUnidadeRegime);
                
        // conferindo se a linha foi escolhida
        if(seqUnidadeRegime==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqUnidadeRegime.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(siglaUnidadeRegime.length()==0 || nomeUnidadeRegime.length()==0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escrever uma unidade válida.");
        }
        
        
        if (acaoValida){
            beanCadastroUnidadesRegime.setSeqRegimeUnidLotacao(Integer.parseInt(seqUnidadeRegime));
            beanCadastroUnidadesRegime.setSiglaRegimeUnidLotacao(siglaUnidadeRegime);
            beanCadastroUnidadesRegime.setNomeRegimeUnidLotacao(nomeUnidadeRegime);
            beanCadastroUnidadesRegime.setDescricaoRegimeUnidLotacao(descricaoUnidadeRegime);
                        
            executou =daoCadastroUnidadesRegime.alterarUnidadeRegime(beanCadastroUnidadesRegime);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroUnidadesRegime.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroUnidadesRegime> selecionar(){
        List dados =daoCadastroUnidadesRegime.selecionarUnidadesRegime();
        return dados;
    }
    
}