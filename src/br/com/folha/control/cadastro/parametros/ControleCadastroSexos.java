/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroSexos;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroSexos;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroSexos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroSexos {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroSexos cadastroSexos;
    BeanCadastroSexos beanSexo = new BeanCadastroSexos();
    
    DaoCadastroSexos daoSexo = new DaoCadastroSexos();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        cadastroSexos  = new TelaCadastroSexos(this,beanSexo);
        cadastroSexos.setVisible(true);
    }
    
    public boolean cadastrar(String nomeSexo, String descricaoSexo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeSexo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeSexo);
        descricaoSexo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoSexo);
        
        if(nomeSexo.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um sexo válido.");}
        
        if(acaoValida==true){
            beanSexo.setSeqSexo(0);
            beanSexo.setNomeSexo(nomeSexo);
            beanSexo.setDescricaoSexo(descricaoSexo);
            executou = daoSexo.inserirSexo(beanSexo);
            cadastroSexos.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqSexo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqSexo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqSexo);
        
        if(seqSexo==null){
            
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            
            if(seqSexo.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        
        if(acaoValida==true){
            beanSexo.setSeqSexo(Integer.parseInt(seqSexo));
            beanSexo.setNomeSexo("");
            beanSexo.setDescricaoSexo("");
            executou =daoSexo.excluirSexo(beanSexo);
            
            cadastroSexos.preencherJtable1d(this.selecionar());
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
        if(nomeEscolaridade.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um sexo válido.");}
        
        if (acaoValida){
            beanSexo.setSeqSexo(Integer.parseInt(seqEscolaridade));
            beanSexo.setNomeSexo(nomeEscolaridade);
            beanSexo.setDescricaoSexo(descricaoEscolaridade);
                        
            executou =daoSexo.alterarSexo(beanSexo);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            cadastroSexos.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroSexos> selecionar(){
        List dados =daoSexo.selecionarSexo();
        return dados;
    }
    
}