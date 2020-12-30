/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroEscolaridades;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroEscolaridades;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroEscolaridades;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroEscolaridades {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroEscolaridades cadastroEscolaridades;
    BeanCadastroEscolaridades beanEscolaridades = new BeanCadastroEscolaridades();
    
    DaoCadastroEscolaridades daoEscolaridades = new DaoCadastroEscolaridades();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        cadastroEscolaridades  = new TelaCadastroEscolaridades(this,beanEscolaridades);
        cadastroEscolaridades.setVisible(true);
    }
    
    public boolean cadastrar(String nomeEcolaridade, String descricaoEscolaridade){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeEcolaridade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEcolaridade);
        descricaoEscolaridade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEscolaridade);
        
        if(nomeEcolaridade.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma Escolaridade válida.");}
        
        if(acaoValida==true){
            beanEscolaridades.setSeqEscolaridade(0);
            beanEscolaridades.setNomeEscolaridade(nomeEcolaridade);
            beanEscolaridades.setDescricaoEscolaridade(descricaoEscolaridade);
            executou = daoEscolaridades.inserirEscolaridade(beanEscolaridades);
            cadastroEscolaridades.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqEscolaridade){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqEscolaridade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqEscolaridade);
        
        if(seqEscolaridade==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqEscolaridade.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            beanEscolaridades.setSeqEscolaridade(Integer.parseInt(seqEscolaridade));
            beanEscolaridades.setNomeEscolaridade("");
            beanEscolaridades.setDescricaoEscolaridade("");
            executou =daoEscolaridades.excluirEscolaridade(beanEscolaridades);
            
            cadastroEscolaridades.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqEscolaridade, String nomeEscolaridade, String descricaoEscolaridade){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqEscolaridade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqEscolaridade);
        nomeEscolaridade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEscolaridade);
        descricaoEscolaridade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEscolaridade);
                
        // conferindo se a linha foi escolhida
        if(seqEscolaridade==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqEscolaridade.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomeEscolaridade.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma cidade válida.");}
        
        if (acaoValida){
            beanEscolaridades.setSeqEscolaridade(Integer.parseInt(seqEscolaridade));
            beanEscolaridades.setNomeEscolaridade(nomeEscolaridade);
            beanEscolaridades.setDescricaoEscolaridade(descricaoEscolaridade);
                        
            executou =daoEscolaridades.alterarEscolaridade(beanEscolaridades);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            cadastroEscolaridades.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroEscolaridades> selecionar(){
        List dados =daoEscolaridades.selecionarEscolaridade();
        return dados;
    }
    
}