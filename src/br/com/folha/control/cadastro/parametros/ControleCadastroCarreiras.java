/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCarreiras;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroCarreiras;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroCarreiras;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */

public class ControleCadastroCarreiras {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroCarreiras telaCadastroCarreiras;
    BeanCadastroCarreiras beanCadastroCarreiras = new BeanCadastroCarreiras();
    
    DaoCadastroCarreiras daocarreiras = new DaoCadastroCarreiras();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroCarreiras  = new TelaCadastroCarreiras(this,beanCadastroCarreiras);
        telaCadastroCarreiras.setVisible(true);
    }
    
    public boolean cadastrar(String siglaCarreira, String nomeCarreira, String descricaoCarreira){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        siglaCarreira = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaCarreira);
        nomeCarreira = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCarreira);
        descricaoCarreira = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCarreira);
        
        if(siglaCarreira.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carreir válida.");}
        if(nomeCarreira.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carreira válida.");}
        
        if(acaoValida==true){
            beanCadastroCarreiras.setSeqCarreira(0);
            beanCadastroCarreiras.setSiglaCarreira(siglaCarreira);
            beanCadastroCarreiras.setNomeCarreira(nomeCarreira);
            beanCadastroCarreiras.setDescricaoCarreira(descricaoCarreira);
            executou = daocarreiras.inserirCarreira(beanCadastroCarreiras);
            telaCadastroCarreiras.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqCarreira){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqCarreira = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqCarreira);
        
        if(seqCarreira==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqCarreira.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            beanCadastroCarreiras.setSeqCarreira(Integer.parseInt(seqCarreira));
            beanCadastroCarreiras.setSiglaCarreira("");
            beanCadastroCarreiras.setNomeCarreira("");
            beanCadastroCarreiras.setDescricaoCarreira("");
            executou =daocarreiras.excluirCarreira(beanCadastroCarreiras);
            
            telaCadastroCarreiras.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    //public boolean alterar(String seqCarreira, String siglaCarreira, String nomeCarreira, String siglaCarreira){
    public boolean alterar(String seqCarreira, String siglaCarreira, String nomeCarreira, String descricaoCarreira){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqCarreira = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqCarreira);
        siglaCarreira = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaCarreira);
        nomeCarreira = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCarreira);
        descricaoCarreira = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCarreira);
                
        // conferindo se a linha foi escolhida
        if(seqCarreira==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqCarreira.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(siglaCarreira.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma careira válida.");}
        if(nomeCarreira.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carreira válida.");}
        
        if (acaoValida){
            beanCadastroCarreiras.setSeqCarreira(Integer.parseInt(seqCarreira));
            beanCadastroCarreiras.setSiglaCarreira(siglaCarreira);
            beanCadastroCarreiras.setNomeCarreira(nomeCarreira);
            beanCadastroCarreiras.setDescricaoCarreira(descricaoCarreira);
                        
            executou =daocarreiras.alterarCarreira(beanCadastroCarreiras);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroCarreiras.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroCarreiras> selecionar(){
        List dados =daocarreiras.selecionarCarreira();
        return dados;
    }
    
}