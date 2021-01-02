/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroBancos;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroBancos;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroBancos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroBancos {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroBancos telaCadastroBancos;
    BeanCadastroBancos beanCadastroBancos = new BeanCadastroBancos();
    
    DaoCadastroBancos daoBancos = new DaoCadastroBancos();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroBancos  = new TelaCadastroBancos(this,beanCadastroBancos);
        telaCadastroBancos.setVisible(true);
    }
    
    public boolean cadastrar(String codigoBanco, String nomeBanco, String siglaBanco){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        codigoBanco = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(codigoBanco);
        nomeBanco = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeBanco);
        siglaBanco = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaBanco);
        
        if(codigoBanco.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um Banco válido.");}
        if(nomeBanco.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um Banco válido.");}
        
        if(acaoValida==true){
            beanCadastroBancos.setSeqBanco(0);
            beanCadastroBancos.setCodigoBanco(codigoBanco);
            beanCadastroBancos.setNomeBanco(nomeBanco);
            beanCadastroBancos.setSiglaBanco(siglaBanco);
            executou = daoBancos.inserirBanco(beanCadastroBancos);
            telaCadastroBancos.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqBanco){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqBanco = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqBanco);
        
        if(seqBanco==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqBanco.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            beanCadastroBancos.setSeqBanco(Integer.parseInt(seqBanco));
            beanCadastroBancos.setCodigoBanco("");
            beanCadastroBancos.setNomeBanco("");
            beanCadastroBancos.setSiglaBanco("");
            executou =daoBancos.excluirBanco(beanCadastroBancos);
            
            telaCadastroBancos.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqBanco, String codigoBanco, String nomeBanco, String siglaBanco){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqBanco = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqBanco);
        codigoBanco = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(codigoBanco);
        nomeBanco = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeBanco);
        siglaBanco = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaBanco);
                
        // conferindo se a linha foi escolhida
        if(seqBanco==null) {
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqBanco.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(codigoBanco.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um banco válido.");}
        if(nomeBanco.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um banco válido.");}
        
        if (acaoValida){
            beanCadastroBancos.setSeqBanco(Integer.parseInt(seqBanco));
            beanCadastroBancos.setCodigoBanco(codigoBanco);
            beanCadastroBancos.setNomeBanco(nomeBanco);
            beanCadastroBancos.setSiglaBanco(siglaBanco);
                        
            executou =daoBancos.alterarBanco(beanCadastroBancos);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroBancos.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroBancos> selecionar(){
        List dados =daoBancos.selecionarBanco();
        return dados;
    }
    
}