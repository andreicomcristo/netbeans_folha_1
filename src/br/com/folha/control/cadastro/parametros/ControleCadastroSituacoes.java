/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroSituacoes;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroSituacoes;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroSituacoes;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroSituacoes {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroSituacoes telaCadastroSituacoes;
    BeanCadastroSituacoes beanSituacoes = new BeanCadastroSituacoes();
    
    DaoCadastroSituacoes daoSituacoes = new DaoCadastroSituacoes();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroSituacoes  = new TelaCadastroSituacoes(this,beanSituacoes);
        telaCadastroSituacoes.setVisible(true);
    }
    
    public boolean cadastrar(String nomeSituacoes, String descricaoSituacoes){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeSituacoes = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeSituacoes);
        descricaoSituacoes = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoSituacoes);
        
        if(nomeSituacoes.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma "
                + "situação válida.");}
        
        if(acaoValida==true){
            beanSituacoes.setSeqSituacao(0);
            beanSituacoes.setNomeSituacao(nomeSituacoes);
            beanSituacoes.setDescricaoSituacao(descricaoSituacoes);
            executou = daoSituacoes.inserirSituacao(beanSituacoes);
            telaCadastroSituacoes.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqSituacao){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqSituacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqSituacao);
        
        if(seqSituacao==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqSituacao.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser "
                    + "excluiída.");}
        }
        
        if(acaoValida==true){
            beanSituacoes.setSeqSituacao(Integer.parseInt(seqSituacao));
            beanSituacoes.setNomeSituacao("");
            beanSituacoes.setDescricaoSituacao("");
            executou =daoSituacoes.excluirSituacao(beanSituacoes);
            
            telaCadastroSituacoes.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqSituacao, String nomeSituacao, String descricaoSituacao){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqSituacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqSituacao);
        nomeSituacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeSituacao);
        descricaoSituacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoSituacao);
                
        // conferindo se a linha foi escolhida
        if(seqSituacao==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqSituacao.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser"
                    + " excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomeSituacao.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma"
                + " situação válida.");}
        
        if (acaoValida){
            beanSituacoes.setSeqSituacao(Integer.parseInt(seqSituacao));
            beanSituacoes.setNomeSituacao(nomeSituacao);
            beanSituacoes.setDescricaoSituacao(descricaoSituacao);
                        
            executou =daoSituacoes.alterarSituacao(beanSituacoes);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroSituacoes.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroSituacoes> selecionar(){
        List dados = daoSituacoes.selecionarSituacao();
        return dados;
    }
    
}