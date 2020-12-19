/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package folha.parametros.cadastros.classe;

import java.util.List;

/**
 *
 * @author andrei
 */
public class acoesCadastroCH_SEMANAL {

    CadastroCH_SEMANAL CADASTRODECH;
    int SEQ_OPERADOR;
    int SEQ_PRIVILEGIO;
    
    
    acoesCadastroCH_SEMANAL acoesCadastroCH_SEMANAL;
    CadastroCH_SEMANAL cadastroCH_SEMANAL;
    CH_SEMANAL ch_semanal = new CH_SEMANAL();
    DaoCH_SEMANAL daoCH_SEMANAL = new DaoCH_SEMANAL();
    
    
    public boolean cadastrar(CH_SEMANAL ch_semanal){
        boolean executou = false;
        boolean acaoValida = true;
        if(ch_semanal.getCH()==0){acaoValida = false;}
            executou =daoCH_SEMANAL.inserir_CH_SEMANAL(ch_semanal);
        return executou;
    }
    
    public boolean excluir(CH_SEMANAL ch_semanal){
        boolean executou = false;
            executou =daoCH_SEMANAL.excluir_CH_SEMANAL(ch_semanal);
        return executou;
    }
    
    public boolean alterar(CH_SEMANAL ch_semanal){
        boolean executou = false;
            executou =daoCH_SEMANAL.alterar_CH_SEMANAL(ch_semanal);
        return executou;
    }
    
    public List<CH_SEMANAL> selecionar(){
        List dados =daoCH_SEMANAL.selecionar_CH_SEMANAL();
        return dados;
    }
 
    
    
    
}