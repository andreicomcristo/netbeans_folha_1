/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroUnidadesNaturezaJuridica;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroUnidadesNaturezaJurudica;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroUnidadesNaturezaJuridica;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroUnidadesNaturezaJuridica {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroUnidadesNaturezaJuridica telaCadastroNaturezaJuridica;
    BeanCadastroUnidadesNaturezaJuridica beanNaturezaJuridica = new BeanCadastroUnidadesNaturezaJuridica();
    
    DaoCadastroUnidadesNaturezaJurudica daoNaturezaJuridica = new DaoCadastroUnidadesNaturezaJurudica();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroNaturezaJuridica  = new TelaCadastroUnidadesNaturezaJuridica(this,beanNaturezaJuridica);
        telaCadastroNaturezaJuridica.setVisible(true);
    }
    
    public boolean cadastrar(String nomeNaturezaJuridica, String descricaoNaturezaJuridica){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeNaturezaJuridica = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeNaturezaJuridica);
        descricaoNaturezaJuridica = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoNaturezaJuridica);
        
        if(nomeNaturezaJuridica.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma "
                + "natureza jurídica válida.");}
        
        if(acaoValida==true){
            beanNaturezaJuridica.setSeqUnidadeNaturezaJurudica(0);
            beanNaturezaJuridica.setNomeNaturazaJuridica(nomeNaturezaJuridica);
            beanNaturezaJuridica.setDescricaoNaturezaJuridica(descricaoNaturezaJuridica);
            executou = daoNaturezaJuridica.inserirNaturezaJuridica(beanNaturezaJuridica);
            telaCadastroNaturezaJuridica.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqNaturezaJuridica){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqNaturezaJuridica = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqNaturezaJuridica);
        
        if(seqNaturezaJuridica==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqNaturezaJuridica.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser "
                    + "excluiída.");}
        }
        
        if(acaoValida==true){
            beanNaturezaJuridica.setSeqUnidadeNaturezaJurudica(Integer.parseInt(seqNaturezaJuridica));
            beanNaturezaJuridica.setNomeNaturazaJuridica("");
            beanNaturezaJuridica.setDescricaoNaturezaJuridica("");
            executou =daoNaturezaJuridica.excluirNaturezaJuridica(beanNaturezaJuridica);
            
            telaCadastroNaturezaJuridica.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqNaturezaJuridica, String nomeNaturezaJuridica, String descricaoNaturezaJuridica){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqNaturezaJuridica = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqNaturezaJuridica);
        nomeNaturezaJuridica = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeNaturezaJuridica);
        descricaoNaturezaJuridica = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoNaturezaJuridica);
                
        // conferindo se a linha foi escolhida
        if(seqNaturezaJuridica==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqNaturezaJuridica.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser"
                    + " excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomeNaturezaJuridica.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma"
                + " natureza jurídica válida.");}
        
        if (acaoValida){
            beanNaturezaJuridica.setSeqUnidadeNaturezaJurudica(Integer.parseInt(seqNaturezaJuridica));
            beanNaturezaJuridica.setNomeNaturazaJuridica(nomeNaturezaJuridica);
            beanNaturezaJuridica.setDescricaoNaturezaJuridica(descricaoNaturezaJuridica);
                        
            executou =daoNaturezaJuridica.alterarNaturezaJuridica(beanNaturezaJuridica);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroNaturezaJuridica.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroUnidadesNaturezaJuridica> selecionar(){
        List dados = daoNaturezaJuridica.selecionarNaturezaJuridica();
        return dados;
    }
    
}