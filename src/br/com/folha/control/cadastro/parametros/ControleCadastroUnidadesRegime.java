/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroNiveisCargos;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroNiveisCargos;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroClasses;
import br.com.folha.view.cadastro.parametros.TelaCadastroNiveisCargos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */

public class ControleCadastroUnidadesRegime {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroNiveisCargos telaCadastroNivelCargos;
    BeanCadastroNiveisCargos beanCadastroNivelCargos = new BeanCadastroNiveisCargos();
    
    DaoCadastroNiveisCargos daoCadastroNivelCargo = new DaoCadastroNiveisCargos();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroNivelCargos  = new TelaCadastroNiveisCargos(this,beanCadastroNivelCargos);
        telaCadastroNivelCargos.setVisible(true);
    }
    
    public boolean cadastrar(String siglaNIvelCargo, String nomeNivelCargo, String descricaoNivelCargo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        siglaNIvelCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaNIvelCargo);
        nomeNivelCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeNivelCargo);
        descricaoNivelCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoNivelCargo);
        
        if(siglaNIvelCargo.length()==0 || nomeNivelCargo.length()==0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escrever um nível de cargo válido.");
        }
        
        if(acaoValida==true){
            beanCadastroNivelCargos.setSeqNivelCargo(0);
            beanCadastroNivelCargos.setSiglaNivelCargo(siglaNIvelCargo);
            beanCadastroNivelCargos.setNomeNivelCargo(nomeNivelCargo);
            beanCadastroNivelCargos.setDescricaoNivelCargo(descricaoNivelCargo);
            executou = daoCadastroNivelCargo.inserirNivelCargo(beanCadastroNivelCargos);
            telaCadastroNivelCargos.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqNivelCargo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqNivelCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqNivelCargo);
        
        if(seqNivelCargo==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqNivelCargo.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            beanCadastroNivelCargos.setSeqNivelCargo(Integer.parseInt(seqNivelCargo));
            beanCadastroNivelCargos.setSiglaNivelCargo("");
            beanCadastroNivelCargos.setNomeNivelCargo("");
            beanCadastroNivelCargos.setDescricaoNivelCargo("");
            executou =daoCadastroNivelCargo.excluirNivelCargo(beanCadastroNivelCargos);
            
            telaCadastroNivelCargos.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqNivelCargo, String siglaNivelCargo, String nomeNivelCargo, String descricaoNivelCargo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqNivelCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqNivelCargo);
        siglaNivelCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaNivelCargo);
        nomeNivelCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeNivelCargo);
        descricaoNivelCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoNivelCargo);
                
        // conferindo se a linha foi escolhida
        if(seqNivelCargo==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqNivelCargo.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(siglaNivelCargo.length()==0 || nomeNivelCargo.length()==0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escrever um nível de cargo válido.");
        }
        
        
        if (acaoValida){
            beanCadastroNivelCargos.setSeqNivelCargo(Integer.parseInt(seqNivelCargo));
            beanCadastroNivelCargos.setSiglaNivelCargo(siglaNivelCargo);
            beanCadastroNivelCargos.setNomeNivelCargo(nomeNivelCargo);
            beanCadastroNivelCargos.setDescricaoNivelCargo(descricaoNivelCargo);
                        
            executou =daoCadastroNivelCargo.alterarNivelCargo(beanCadastroNivelCargos);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroNivelCargos.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroNiveisCargos> selecionar(){
        List dados =daoCadastroNivelCargo.selecionarNiveisCargo();
        return dados;
    }
    
}