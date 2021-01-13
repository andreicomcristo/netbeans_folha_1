/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroPaises;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroPaises;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroPaises;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroPaises {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroPaises telaCadastroPaises;
    BeanCadastroPaises beanCadastroPaises = new BeanCadastroPaises();
    
    DaoCadastroPaises daoPais = new DaoCadastroPaises();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroPaises  = new TelaCadastroPaises(this,beanCadastroPaises);
        telaCadastroPaises.setVisible(true);
    }
    
    public boolean cadastrar(String nomePais){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        
        nomePais = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomePais);
        
        
        if(nomePais.length()==0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escrever um País válido.");
        }
        
        if(acaoValida==true){
            beanCadastroPaises.setSeqPais(0);            
            beanCadastroPaises.setNomePais(nomePais);            
            executou = daoPais.inserirPais(beanCadastroPaises);
            telaCadastroPaises.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqPais){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqPais = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqPais);
        
        if(seqPais==null){
            
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqPais.length()==0){
                JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            
            beanCadastroPaises.setSeqPais(Integer.parseInt(seqPais));            
            beanCadastroPaises.setNomePais("");       
            executou =daoPais.excluirPais(beanCadastroPaises);
            
            telaCadastroPaises.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqPais, String nomePais){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqPais = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqPais);        
        nomePais = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomePais);        
                
        // conferindo se a linha foi escolhida
        if(seqPais==null) {
            
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqPais.length()==0){
                JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
            }
        }
        //conferindo se os campos obrigatórios foram preenchidos
        
        if(nomePais.length()==0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escrever um banco válido.");
        }
        
        if (acaoValida){
            beanCadastroPaises.setSeqPais(Integer.parseInt(seqPais));            
            beanCadastroPaises.setNomePais(nomePais);            
                        
            executou =daoPais.alterarPais(beanCadastroPaises);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroPaises.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroPaises> selecionar(){
        List dados =daoPais.selecionarPais();
        return dados;
    }
    
}