/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCargos;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroCargos;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroCargos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroCargos {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroCargos telaCadastroCargos;
    BeanCadastroCargos beanCadastroCargos = new BeanCadastroCargos();
    
    DaoCadastroCargos daoCargos = new DaoCadastroCargos();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    // para colocar os paises no combo
    List<BeanSequenciaTexto> listaPaises;
    
    // para colocar os dados cadastrados na tabela1
    List<BeanCadastroCargos> listaDadosjTable1;
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroCargos  = new TelaCadastroCargos(this,beanCadastroCargos);
        preencherComboBox();
        telaCadastroCargos.preencherComboBox1(listaPaises);
        telaCadastroCargos.setVisible(true);
    }
    
    public boolean cadastrar(String nomeCargo, String descricaoCargo, int indice){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCargo);
        descricaoCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCargo);
        
        //conferindo se os campos obrigatórios foram preenchidos
        if(indice == 0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escolher um cargo válido.");
        }
        if(nomeCargo.length()==0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escrever uma cargo válido.");
        }
        
        if(acaoValida==true){
            beanCadastroCargos.setSeqCargo(0);
            beanCadastroCargos.setNomeCargo(nomeCargo);
            beanCadastroCargos.setDescricaoCargo(descricaoCargo);
            beanCadastroCargos.setSeqNivelCargo(listaPaises.get(indice-1).getSequencia());
            executou = daoCargos.inserirCargos(beanCadastroCargos);
            telaCadastroCargos.preencherJtable1d(this.selecionar(beanCadastroCargos.getNomeCargo()));
        }
        return executou;
    }
    
    public boolean excluir(int linhajTable1){
        boolean executou = false;
        boolean acaoValida = true;
        
        if(acaoValida==true){
            beanCadastroCargos.setSeqCargo(listaDadosjTable1.get(linhajTable1).getSeqCargo());
            beanCadastroCargos.setNomeCargo("");
            beanCadastroCargos.setDescricaoCargo("");
            executou =daoCargos.excluirCargos(beanCadastroCargos);
            
            telaCadastroCargos.preencherJtable1d(this.selecionar(""));
        }
        return executou;
    }
    
    public boolean alterar(int linhajTable1, String nomeCargo, String descricaoCargo, int indiceCombo1){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCargo);
        descricaoCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCargo);
                
        //conferindo se os campos obrigatórios foram preenchidos
        if(indiceCombo1 == 0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escolher um cargo válido.");
        }
        if(nomeCargo.length()==0){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escrever um cargo  válido.");
        }
        
        if (acaoValida){
            beanCadastroCargos.setSeqCargo(this.listaDadosjTable1.get(linhajTable1).getSeqCargo());
            beanCadastroCargos.setNomeCargo(nomeCargo);
            beanCadastroCargos.setDescricaoCargo(descricaoCargo);
            beanCadastroCargos.setSeqNivelCargo(listaPaises.get(indiceCombo1-1).getSequencia());
                        
            executou =daoCargos.alterarCargos(beanCadastroCargos);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroCargos.preencherJtable1d(this.selecionar(beanCadastroCargos.getNomeCargo()));
        }
            return executou;
    }
    
    public List<BeanCadastroCargos> selecionar(String consulta){
        List dados =daoCargos.selecionarCargos(consulta);
        listaDadosjTable1 = dados;
        return dados;
    }
    
    
    public void preencherComboBox(){
        this.listaPaises =daoCargos.selecionarPaises();
    }
    
}