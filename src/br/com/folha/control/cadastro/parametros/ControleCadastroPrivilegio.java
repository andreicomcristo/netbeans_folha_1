/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroPrivilegios;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroPrivilegios;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroPrivilegios;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroPrivilegio {
    
    ControlePrincipal controlePrincipal; // Justificar variaveis
    BeanPrincipal beanPrincipal; //Justificar variaveis
        
    
    TelaCadastroPrivilegios cadastroPrivilegios;
    BeanCadastroPrivilegios beanPrivilegios = new BeanCadastroPrivilegios();
    
    DaoCadastroPrivilegios daoPrivilegios = new DaoCadastroPrivilegios();
    
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    //Justificar o uso dessas variaveis no argumento do método
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        cadastroPrivilegios  = new TelaCadastroPrivilegios(this,beanPrivilegios);
        cadastroPrivilegios.setVisible(true);
    }
    
    public boolean cadastrar(String nomePrivilegio, String descricaoPrivilegio){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomePrivilegio = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomePrivilegio);
        descricaoPrivilegio = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoPrivilegio);
        
        if(nomePrivilegio.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um privilégio válido.");}
        
        if(acaoValida==true){
            beanPrivilegios.setSeqPrivilegio(0);
            beanPrivilegios.setNomePrivilegio(nomePrivilegio);
            beanPrivilegios.setDescricaoPrivilegio(descricaoPrivilegio);
            executou = daoPrivilegios.inserirPrivilegios(beanPrivilegios);
            cadastroPrivilegios.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqPrivilegio){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqPrivilegio = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqPrivilegio);
        
        if(seqPrivilegio==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqPrivilegio.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        if(acaoValida==true){
            beanPrivilegios.setSeqPrivilegio(Integer.parseInt(seqPrivilegio));
            beanPrivilegios.setNomePrivilegio("");
            beanPrivilegios.setDescricaoPrivilegio("");
            executou =daoPrivilegios.excluirPrivilegio(beanPrivilegios);
            
            cadastroPrivilegios.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqPrivilegio, String nomePrivilegio, String descricaoPrivilegio){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqPrivilegio = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqPrivilegio);
        nomePrivilegio = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomePrivilegio);
        descricaoPrivilegio = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoPrivilegio);
                
        // conferindo se a linha foi escolhida
        if(seqPrivilegio==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqPrivilegio.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomePrivilegio.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um privilégio válido.");}
        
        if (acaoValida){
            beanPrivilegios.setSeqPrivilegio(Integer.parseInt(seqPrivilegio));
            beanPrivilegios.setNomePrivilegio(nomePrivilegio);
            beanPrivilegios.setDescricaoPrivilegio(descricaoPrivilegio);
                        
            executou =daoPrivilegios.alterarPrivilegio(beanPrivilegios);
      
            cadastroPrivilegios.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroPrivilegios> selecionar(){
        
        List dados =daoPrivilegios.selecionarPrivilegio();
        return dados;
        
    }
    
}