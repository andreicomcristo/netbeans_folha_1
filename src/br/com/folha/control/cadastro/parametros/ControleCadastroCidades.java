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
    BeanCadastroCidades beanCadastroCidades = new BeanCadastroCidades();
    
    DaoCadastroCidades daoCidades = new DaoCadastroCidades();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    // para colocar os paises no combo
    List<BeanSequenciaTexto> listaPaises;
    
    // para colocar os dados cadastrados na tabela1
    List<BeanCadastroCidades> listaDadosjTable1;
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroCidades  = new TelaCadastroCidades(this,beanCadastroCidades);
        preencherComboBox();
        telaCadastroCidades.preencherComboBox1(listaPaises);
        telaCadastroCidades.setVisible(true);
    }
    
    public boolean cadastrar(String nomeCidade, String siglaEstado, int indice){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeCidade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCidade);
        siglaEstado = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaEstado);
        
        //conferindo se os campos obrigatórios foram preenchidos
        if(indice == 0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher um´país válido.");}
        if(nomeCidade.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma cidade válida.");}
        
        if(acaoValida==true){
            beanCadastroCidades.setSeqCidade(0);
            beanCadastroCidades.setNomeCidade(nomeCidade);
            beanCadastroCidades.setSiglaEstado(siglaEstado);
            beanCadastroCidades.setSeqPais(listaPaises.get(indice-1).getSequencia());
            executou = daoCidades.inserirCidade(beanCadastroCidades);
            telaCadastroCidades.preencherJtable1d(this.selecionar(beanCadastroCidades.getNomeCidade()));
        }
        return executou;
    }
    
    public boolean excluir(int linhajTable1){
        boolean executou = false;
        boolean acaoValida = true;
        
        if(acaoValida==true){
            beanCadastroCidades.setSeqCidade(listaDadosjTable1.get(linhajTable1).getSeqCidade());
            beanCadastroCidades.setNomeCidade("");
            beanCadastroCidades.setSiglaEstado("");
            executou =daoCidades.excluirCidade(beanCadastroCidades);
            
            telaCadastroCidades.preencherJtable1d(this.selecionar(""));
        }
        return executou;
    }
    
    public boolean alterar(int linhajTable1, String nomeCidade, String siglaEstado, int indiceCombo1){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeCidade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCidade);
        siglaEstado = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaEstado);
                
        //conferindo se os campos obrigatórios foram preenchidos
        if(indiceCombo1 == 0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escolher um´país válido.");
        }
        if(nomeCidade.length()==0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escrever uma cidade válida.");
        }
        
        if (acaoValida){
            beanCadastroCidades.setSeqCidade(this.listaDadosjTable1.get(linhajTable1).getSeqCidade());
            beanCadastroCidades.setNomeCidade(nomeCidade);
            beanCadastroCidades.setSiglaEstado(siglaEstado);
            beanCadastroCidades.setSeqPais(listaPaises.get(indiceCombo1-1).getSequencia());
                        
            executou =daoCidades.alterarCidade(beanCadastroCidades);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroCidades.preencherJtable1d(this.selecionar(beanCadastroCidades.getNomeCidade()));
        }
            return executou;
    }
    
    public List<BeanCadastroCidades> selecionar(String consulta){
        List dados =daoCidades.selecionarCidade(consulta);
        listaDadosjTable1 = dados;
        return dados;
    }
    
    public void preencherComboBox(){
        this.listaPaises =daoCidades.selecionarPaises();
    }
    
}