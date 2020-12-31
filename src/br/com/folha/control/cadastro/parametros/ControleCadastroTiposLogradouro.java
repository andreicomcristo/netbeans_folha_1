/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroTiposLogradouro;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroTiposLogradouros;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroTiposLogradouro;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroTiposLogradouro {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroTiposLogradouro telaCadastroTiposLogradouro;
    BeanCadastroTiposLogradouro beanTiposLogradouro = new BeanCadastroTiposLogradouro();
    
    DaoCadastroTiposLogradouros daoLogradouro = new DaoCadastroTiposLogradouros();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroTiposLogradouro  = new TelaCadastroTiposLogradouro(this,beanTiposLogradouro);
        telaCadastroTiposLogradouro.setVisible(true);
    }
    
    public boolean cadastrar(String nomeLogradouro, String descricaoLogradouro){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeLogradouro = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeLogradouro);
        descricaoLogradouro = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoLogradouro);
        
        if(nomeLogradouro.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um "
                + "logradouro válido.");}
        
        if(acaoValida==true){
            beanTiposLogradouro.setSeqTipoLogradouro(0);
            beanTiposLogradouro.setNomeTipoLogradouro(nomeLogradouro);
            beanTiposLogradouro.setDescricaoTipoLogradouro(descricaoLogradouro);
            executou = daoLogradouro.inserirLogradouro(beanTiposLogradouro);
            telaCadastroTiposLogradouro.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqLogradouro){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqLogradouro = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqLogradouro);
        
        if(seqLogradouro==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqLogradouro.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser "
                    + "excluiída.");}
        }
        
        if(acaoValida==true){
            beanTiposLogradouro.setSeqTipoLogradouro(Integer.parseInt(seqLogradouro));
            beanTiposLogradouro.setNomeTipoLogradouro("");
            beanTiposLogradouro.setDescricaoTipoLogradouro("");
            executou =daoLogradouro.excluirLogradouro(beanTiposLogradouro);
            
            telaCadastroTiposLogradouro.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqLogradouro, String nomeLogradouro, String descricaoLogradouro){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqLogradouro = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqLogradouro);
        nomeLogradouro = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeLogradouro);
        descricaoLogradouro = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoLogradouro);
                
        // conferindo se a linha foi escolhida
        if(seqLogradouro==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqLogradouro.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser"
                    + " excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomeLogradouro.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um"
                + " logradouro válido.");}
        
        if (acaoValida){
            beanTiposLogradouro.setSeqTipoLogradouro(Integer.parseInt(seqLogradouro));
            beanTiposLogradouro.setNomeTipoLogradouro(nomeLogradouro);
            beanTiposLogradouro.setDescricaoTipoLogradouro(descricaoLogradouro);
                        
            executou =daoLogradouro.alterarFiliacao(beanTiposLogradouro);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroTiposLogradouro.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroTiposLogradouro> selecionar(){
        List dados = daoLogradouro.selecionarLogradouro();
        return dados;
    }
    
}