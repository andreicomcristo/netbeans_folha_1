/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroTiposFiliacao;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroTiposFiliacao;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroTiposFiliacao;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroTiposFiliacao {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroTiposFiliacao telaCadastroTiposFiliacao;
    BeanCadastroTiposFiliacao beanTiposFiliacao = new BeanCadastroTiposFiliacao();
    
    DaoCadastroTiposFiliacao daoFiliacao = new DaoCadastroTiposFiliacao();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroTiposFiliacao  = new TelaCadastroTiposFiliacao(this,beanTiposFiliacao);
        telaCadastroTiposFiliacao.setVisible(true);
    }
    
    public boolean cadastrar(String nomeFiliacao, String descricaoFiliacao){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeFiliacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeFiliacao);
        descricaoFiliacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoFiliacao);
        
        if(nomeFiliacao.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma "
                + "filiação válida.");}
        
        if(acaoValida==true){
            beanTiposFiliacao.setSeqTipoFiliacao(0);
            beanTiposFiliacao.setNomeTipoFiliacao(nomeFiliacao);
            beanTiposFiliacao.setDescricaoTipoFiliacao(descricaoFiliacao);
            executou = daoFiliacao.inserirFiliacao(beanTiposFiliacao);
            telaCadastroTiposFiliacao.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqFiliacao){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqFiliacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqFiliacao);
        
        if(seqFiliacao==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqFiliacao.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser "
                    + "excluiída.");}
        }
        
        if(acaoValida==true){
            beanTiposFiliacao.setSeqTipoFiliacao(Integer.parseInt(seqFiliacao));
            beanTiposFiliacao.setNomeTipoFiliacao("");
            beanTiposFiliacao.setDescricaoTipoFiliacao("");
            executou =daoFiliacao.excluirFiliacao(beanTiposFiliacao);
            
            telaCadastroTiposFiliacao.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqFiliacoa, String nomeFiliacao, String descricaoFiliacao){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqFiliacoa = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqFiliacoa);
        nomeFiliacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeFiliacao);
        descricaoFiliacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoFiliacao);
                
        // conferindo se a linha foi escolhida
        if(seqFiliacoa==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqFiliacoa.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser"
                    + " excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomeFiliacao.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma"
                + " filiação válida.");}
        
        if (acaoValida){
            beanTiposFiliacao.setSeqTipoFiliacao(Integer.parseInt(seqFiliacoa));
            beanTiposFiliacao.setNomeTipoFiliacao(nomeFiliacao);
            beanTiposFiliacao.setDescricaoTipoFiliacao(descricaoFiliacao);
                        
            executou =daoFiliacao.alterarFiliacao(beanTiposFiliacao);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroTiposFiliacao.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroTiposFiliacao> selecionar(){
        List dados = daoFiliacao.selecionarFiliacao();
        return dados;
    }
    
}