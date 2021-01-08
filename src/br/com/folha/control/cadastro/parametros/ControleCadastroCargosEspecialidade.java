/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.parametros;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCargosEspecialidade;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.parametros.dao.DaoCadastroCargosEspecialidade;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.parametros.TelaCadastroCargosEspecialidade;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroCargosEspecialidade {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    
    TelaCadastroCargosEspecialidade telaCadastroCargosEspecialidade;
    BeanCadastroCargosEspecialidade beanCargosEspecialidade = new BeanCadastroCargosEspecialidade();
    
    DaoCadastroCargosEspecialidade daoCargosEspedialidade = new DaoCadastroCargosEspecialidade();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    // para colocar os paises no combo
    List<BeanSequenciaTexto> listaCargos;
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaCadastroCargosEspecialidade  = new TelaCadastroCargosEspecialidade(this,beanCargosEspecialidade);
        preencherComboBox();
        telaCadastroCargosEspecialidade.preencherComboBox1(listaCargos);
        telaCadastroCargosEspecialidade.setVisible(true);
    }
    
    public boolean cadastrar(String nomeEspecialidadeCargo, String descricaoEspecialidadeCargo, int indice){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeEspecialidadeCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEspecialidadeCargo);
        descricaoEspecialidadeCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEspecialidadeCargo);
        
        //conferindo se os campos obrigatórios foram preenchidos
        if(indice == 0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escolher um cargo válido.");
        }
        
        if(nomeEspecialidadeCargo.length()==0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escrever uma especialidade válida.");
        }
        
        if(acaoValida==true){
            beanCargosEspecialidade.setSeqEspecialidadeCargo(0);
            beanCargosEspecialidade.setNomeEspecialidadeCargo(nomeEspecialidadeCargo);
            beanCargosEspecialidade.setDescriçãoEspecialidadeCargo(descricaoEspecialidadeCargo);
            beanCargosEspecialidade.setSeqCargo(listaCargos.get(indice-1).getSequencia());
            executou = daoCargosEspedialidade.inserirCargoEspecialidade(beanCargosEspecialidade);
            telaCadastroCargosEspecialidade.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean excluir(String seqEspecialidadeCargo){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqEspecialidadeCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqEspecialidadeCargo);
        
        if(seqEspecialidadeCargo==null){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            if(seqEspecialidadeCargo.length()==0){
                JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
            }
        }
        if(acaoValida==true){
            beanCargosEspecialidade.setSeqEspecialidadeCargo(Integer.parseInt(seqEspecialidadeCargo));
            beanCargosEspecialidade.setNomeEspecialidadeCargo("");
            beanCargosEspecialidade.setDescriçãoEspecialidadeCargo("");
            executou =daoCargosEspedialidade.excluirCargoEspecialidade(beanCargosEspecialidade);
            
            telaCadastroCargosEspecialidade.preencherJtable1d(this.selecionar());
        }
        return executou;
    }
    
    public boolean alterar(String seqEspecialidadeCargo, String nomeEspecialidadeCargo, String descricaoEspecialidadeCargo, int indice){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        seqEspecialidadeCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(seqEspecialidadeCargo);
        nomeEspecialidadeCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEspecialidadeCargo);
        descricaoEspecialidadeCargo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEspecialidadeCargo);
                
        // conferindo se a linha foi escolhida
        if(seqEspecialidadeCargo==null){
            acaoValida = false;
            JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
        }else{
            if(seqEspecialidadeCargo.length()==0){
                JOptionPane.showMessageDialog(null, "Você deve escolher uma linha para ser excluiída.");
            }
        }
        //conferindo se os campos obrigatórios foram preenchidos
        if(indice == 0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escolher um cargo válido.");
        }
        if(nomeEspecialidadeCargo.length()==0){
            acaoValida = false; 
            JOptionPane.showMessageDialog(null, "Você deve escrever uma especialidade válida.");
        }
        
        if (acaoValida){
            beanCargosEspecialidade.setSeqEspecialidadeCargo(Integer.parseInt(seqEspecialidadeCargo));
            beanCargosEspecialidade.setNomeEspecialidadeCargo(nomeEspecialidadeCargo);
            beanCargosEspecialidade.setDescriçãoEspecialidadeCargo(descricaoEspecialidadeCargo);
            beanCargosEspecialidade.setSeqCargo(listaCargos.get(indice-1).getSequencia());
                        
            executou =daoCargosEspedialidade.alterarCargoEspecialidade(beanCargosEspecialidade);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroCargosEspecialidade.preencherJtable1d(this.selecionar());
        }
            return executou;
    }
    
    public List<BeanCadastroCargosEspecialidade> selecionar(){
        List dados =daoCargosEspedialidade.selecionarCargosEspecialidade();
        return dados;
    }
    
    public void preencherComboBox(){
        this.listaCargos =daoCargosEspedialidade.selecionarCargos();
    }
    
}