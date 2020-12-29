/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanVinculos;
import br.com.folha.model.cadastro.parametros.dao.DaoVinculos;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroVinculos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroVinculos {
    
    ControlePrincipal controlePrincipal; // Justificar variaveis
    BeanPrincipal beanPrincipal; //Justificar variaveis
        
    
    TelaCadastroVinculos cadastroVinculos;
    BeanVinculos beanVinculos = new BeanVinculos();
    
    DaoVinculos daoVinculos = new DaoVinculos();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    //Justificar o uso dessas variaveis no argumento do método
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        cadastroVinculos  = new TelaCadastroVinculos(this,beanVinculos);
        cadastroVinculos.setVisible(true);
    }
    
    public boolean cadastrar(String nomeVinculo, String descricaoVinculo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeVinculo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeVinculo);
        descricaoVinculo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoVinculo);
        
        if(nomeVinculo.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um vínculo válido.");}
        
        if(acaoValida==true){
            beanVinculos.setSeqVinculo(0);
            beanVinculos.setNomeVinculo(nomeVinculo);
            beanVinculos.setDescricaoVinculo(descricaoVinculo);
            //executou = daoCargaHorariaSemanal.inserirCargaHorariaSemanal(beanCargaHorariaSemanal);
            executou = daoVinculos.inserirVinculo(beanVinculos);
            cadastroVinculos.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqVinculo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqVinculo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqVinculo);
        
        if(seqVinculo==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqVinculo.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        if(acaoValida==true){
            beanVinculos.setSeqVinculo(Integer.parseInt(seqVinculo));
            beanVinculos.setNomeVinculo("");
            beanVinculos.setDescricaoVinculo("");
            executou =daoVinculos.excluirVinculo(beanVinculos);
            
            cadastroVinculos.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqVinculo, String nomeVinculo, String descricaoVinculo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqVinculo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqVinculo);
        nomeVinculo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeVinculo);
        descricaoVinculo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoVinculo);
                
        // conferindo se a linha foi escolhida
        if(seqVinculo==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqVinculo.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(nomeVinculo.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma carga horária válida.");}
        
        if (acaoValida){
            beanVinculos.setSeqVinculo(Integer.parseInt(seqVinculo));
            beanVinculos.setNomeVinculo(nomeVinculo);
            beanVinculos.setDescricaoVinculo(descricaoVinculo);
            
            //executou =daoCargaHorariaSemanal.alterarCargaHorariaSemanal(beanCargaHorariaSemanal);
             
            executou =daoVinculos.alterarVinculo(beanVinculos);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            cadastroVinculos.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanVinculos> selecionar(){
        List dados =daoVinculos.selecionarVinculo();
        return dados;
    }
    
}