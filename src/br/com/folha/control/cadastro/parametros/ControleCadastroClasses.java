/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCarreiras;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroClasses;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroClasses;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroCarreiras;
import br.com.folha.view.cadastro.parametros.TelaCadastroClasses;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */

public class ControleCadastroClasses {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroClasses telaCadastroClasses;
    BeanCadastroClasses beanCadastroClasses = new BeanCadastroClasses();
    
    DaoCadastroClasses daoClasses = new DaoCadastroClasses();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroClasses  = new TelaCadastroClasses(this,beanCadastroClasses);
        telaCadastroClasses.setVisible(true);
    }
    
    public boolean cadastrar(String siglaClasse, String nomeClasse, String descricaoClasse){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        siglaClasse = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaClasse);
        nomeClasse = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeClasse);
        descricaoClasse = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoClasse);
        
        if(siglaClasse.length()==0 || nomeClasse.length()==0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escrever uma classe válida.");
        }
        
        if(acaoValida==true){
            beanCadastroClasses.setSeqClasses(0);
            beanCadastroClasses.setSiglaClasse(siglaClasse);
            beanCadastroClasses.setNomeClasse(nomeClasse);
            beanCadastroClasses.setDescricaoClasse(descricaoClasse);
            executou = daoClasses.inserirClasse(beanCadastroClasses);
            telaCadastroClasses.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqClasse){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqClasse = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqClasse);
        
        if(seqClasse==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqClasse.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            beanCadastroClasses.setSeqClasses(Integer.parseInt(seqClasse));
            beanCadastroClasses.setSiglaClasse("");
            beanCadastroClasses.setNomeClasse("");
            beanCadastroClasses.setDescricaoClasse("");
            executou =daoClasses.excluirClasse(beanCadastroClasses);
            
            telaCadastroClasses.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    //public boolean alterar(String seqCarreira, String siglaCarreira, String nomeCarreira, String siglaCarreira){
    public boolean alterar(String seqClasse, String siglaClasse, String nomeClasse, String descricaoClasse){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqClasse = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqClasse);
        siglaClasse = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaClasse);
        nomeClasse = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeClasse);
        descricaoClasse = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoClasse);
                
        // conferindo se a linha foi escolhida
        if(seqClasse==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqClasse.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(siglaClasse.length()==0 || nomeClasse.length()==0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escrever uma classe válida.");
        }
        
        
        if (acaoValida){
            beanCadastroClasses.setSeqClasses(Integer.parseInt(seqClasse));
            beanCadastroClasses.setSiglaClasse(siglaClasse);
            beanCadastroClasses.setNomeClasse(nomeClasse);
            beanCadastroClasses.setDescricaoClasse(descricaoClasse);
                        
            executou =daoClasses.alterarClasse(beanCadastroClasses);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroClasses.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroClasses> selecionar(){
        List dados =daoClasses.selecionarClasses();
        return dados;
    }
    
}