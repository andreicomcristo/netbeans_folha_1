/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroEstadoCivel;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroEstadoCivil;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroEstadoCivil;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroEstadoCivil {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroEstadoCivil cadastroEstadoCivil;
    BeanCadastroEstadoCivel beanCadastroEstadoCivil = new BeanCadastroEstadoCivel();
    
    DaoCadastroEstadoCivil daoCadastroEstadoCivil = new DaoCadastroEstadoCivil();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        cadastroEstadoCivil  = new TelaCadastroEstadoCivil(this,beanCadastroEstadoCivil);
        cadastroEstadoCivil.setVisible(true);
    }
    
    public boolean cadastrar(String nomeEstadoCivil, String descricaoEstadoCivil){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeEstadoCivil = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEstadoCivil);
        descricaoEstadoCivil = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEstadoCivil);
        
        if(nomeEstadoCivil.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um estado civil válido.");}
        
        if(acaoValida==true){
            beanCadastroEstadoCivil.setSeqEstadoCivil(0);
            beanCadastroEstadoCivil.setNomeEstadoCivil(nomeEstadoCivil);
            beanCadastroEstadoCivil.setDescricaoEstadoCivil(descricaoEstadoCivil);
            executou = daoCadastroEstadoCivil.inserirEstadoCivil(beanCadastroEstadoCivil);
            cadastroEstadoCivil.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqEstadoCivil){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqEstadoCivil = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqEstadoCivil);
        
        if(seqEstadoCivil==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqEstadoCivil.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        if(acaoValida==true){
            beanCadastroEstadoCivil.setSeqEstadoCivil(Integer.parseInt(seqEstadoCivil));
            beanCadastroEstadoCivil.setNomeEstadoCivil("");
            beanCadastroEstadoCivil.setDescricaoEstadoCivil("");
            executou =daoCadastroEstadoCivil.excluirEstadoCivil(beanCadastroEstadoCivil);
            
            cadastroEstadoCivil.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqEstadoCivil, String nomeEstadoCivil, String descricapEstadoCivil){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqEstadoCivil = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqEstadoCivil);
        nomeEstadoCivil = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEstadoCivil);
        descricapEstadoCivil = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricapEstadoCivil);
                
        // conferindo se a linha foi escolhida
        if(seqEstadoCivil==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqEstadoCivil.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomeEstadoCivil.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um estado civil válido.");}
        
        if (acaoValida){
            beanCadastroEstadoCivil.setSeqEstadoCivil(Integer.parseInt(seqEstadoCivil));
            beanCadastroEstadoCivil.setNomeEstadoCivil(nomeEstadoCivil);
            beanCadastroEstadoCivil.setDescricaoEstadoCivil(descricapEstadoCivil);
                        
            executou =daoCadastroEstadoCivil.alterarEstadoCivil(beanCadastroEstadoCivil);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            cadastroEstadoCivil.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroEstadoCivel> selecionar(){
        List dados =daoCadastroEstadoCivil.selecionarEstadoCivil();
        return dados;
    }
    
}