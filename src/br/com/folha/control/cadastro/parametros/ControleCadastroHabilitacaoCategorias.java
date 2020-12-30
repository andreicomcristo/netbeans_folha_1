/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroHabilitacaoCategorias;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroHabilitacaoCategorias;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroHabilitacaoCategorias;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroHabilitacaoCategorias {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroHabilitacaoCategorias cadastroHabilitacao;
    BeanCadastroHabilitacaoCategorias beanHabilitacao = new BeanCadastroHabilitacaoCategorias();
    
    DaoCadastroHabilitacaoCategorias daoHabilitacao = new DaoCadastroHabilitacaoCategorias();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        cadastroHabilitacao  = new TelaCadastroHabilitacaoCategorias(this,beanHabilitacao);
        cadastroHabilitacao.setVisible(true);
    }
    
    public boolean cadastrar(String nomeHabilitacao, String descricaoHabilitacao){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeHabilitacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeHabilitacao);
        descricaoHabilitacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoHabilitacao);
        
        if(nomeHabilitacao.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma"
                + " categoria de habilitação válida.");}
        
        if(acaoValida==true){
            beanHabilitacao.setSeqHabilitacaoCategoria(0);
            beanHabilitacao.setNomeHabilitacaoCategoria(nomeHabilitacao);
            beanHabilitacao.setDescricaoHabilitacaoCategoria(descricaoHabilitacao);
            executou = daoHabilitacao.inserirHabilitacaoCategorias(beanHabilitacao);
            cadastroHabilitacao.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqHabilitacao){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqHabilitacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqHabilitacao);
        
        if(seqHabilitacao==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqHabilitacao.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            beanHabilitacao.setSeqHabilitacaoCategoria(Integer.parseInt(seqHabilitacao));
            beanHabilitacao.setNomeHabilitacaoCategoria("");
            beanHabilitacao.setDescricaoHabilitacaoCategoria("");
            executou =daoHabilitacao.excluirHabilitacaoCategorias(beanHabilitacao);
            
            cadastroHabilitacao.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqHabilitacao, String nomeHabilitacao, String descricaoHabilitacao){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqHabilitacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqHabilitacao);
        nomeHabilitacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeHabilitacao);
        descricaoHabilitacao = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoHabilitacao);
                
        // conferindo se a linha foi escolhida
        if(seqHabilitacao==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqHabilitacao.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser "
                    + "excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomeHabilitacao.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma"
                + " categoria de habilitação válida.");}
        
        if (acaoValida){
            beanHabilitacao.setSeqHabilitacaoCategoria(Integer.parseInt(seqHabilitacao));
            beanHabilitacao.setNomeHabilitacaoCategoria(nomeHabilitacao);
            beanHabilitacao.setDescricaoHabilitacaoCategoria(descricaoHabilitacao);
                        
            executou =daoHabilitacao.alterarHabilitacaoCategorias(beanHabilitacao);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            cadastroHabilitacao.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroHabilitacaoCategorias> selecionar(){
        List dados =daoHabilitacao.selecionarHabilitacao();
        return dados;
    }
    
}