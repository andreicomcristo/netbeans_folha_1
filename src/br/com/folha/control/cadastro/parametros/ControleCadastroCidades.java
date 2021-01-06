/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroCidades;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroCidades;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroCidades {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroCidades telaCadastroCidades;
    BeanCadastroCidades beanCidades = new BeanCadastroCidades();
    
    DaoCadastroCidades daoCidades = new DaoCadastroCidades();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    // para colocar os paises no combo
    List<BeanSequenciaTexto> listaPaises;
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroCidades  = new TelaCadastroCidades(this,beanCidades);
        preencherComboBox();
        telaCadastroCidades.preencherComboBox1(listaPaises);
        telaCadastroCidades.setVisible(true);
    }
    
    public boolean cadastrar(String nomeCidade, String siglaCidade, int indice){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeCidade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCidade);
        siglaCidade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaCidade);
        
        //conferindo se os campos obrigatórios foram preenchidos
        if(indice == 0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher um´país válido.");}
        if(nomeCidade.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma cidade válida.");}
        
        if(acaoValida==true){
            beanCidades.setSeqCidade(0);
            beanCidades.setNomeCidade(nomeCidade);
            beanCidades.setSiglaEstado(siglaCidade);
            beanCidades.setSeqPais(listaPaises.get(indice-1).getSequencia());
            executou = daoCidades.inserirCidade(beanCidades);
            telaCadastroCidades.preencherJtable1d(this.selecionar());
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
            beanCidades.setSeqCidade(Integer.parseInt(seqVinculo));
            beanCidades.setNomeCidade("");
            beanCidades.setSiglaEstado("");
            executou =daoCidades.excluirCidade(beanCidades);
            
            telaCadastroCidades.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqCidade, String nomeCidade, String siglaEstado, int indice){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqCidade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqCidade);
        nomeCidade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCidade);
        siglaEstado = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaEstado);
                
        // conferindo se a linha foi escolhida
        if(seqCidade==null){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}else{
            if(seqCidade.length()==0){JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");}
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(indice == 0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher um´país válido.");}
        if(nomeCidade.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma cidade válida.");}
        
        if (acaoValida){
            beanCidades.setSeqCidade(Integer.parseInt(seqCidade));
            beanCidades.setNomeCidade(nomeCidade);
            beanCidades.setSiglaEstado(siglaEstado);
            beanCidades.setSeqPais(listaPaises.get(indice-1).getSequencia());
                        
            executou =daoCidades.alterarCidade(beanCidades);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroCidades.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroCidades> selecionar(){
        List dados =daoCidades.selecionarCidade();
        return dados;
    }
    
    
    public void preencherComboBox(){
        this.listaPaises =daoCidades.selecionarPaises();
    }
    
}