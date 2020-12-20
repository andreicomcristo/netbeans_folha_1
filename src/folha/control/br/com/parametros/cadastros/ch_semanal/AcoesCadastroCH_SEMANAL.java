/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package folha.control.br.com.parametros.cadastros.ch_semanal;

import folha.dao.br.com.parametros.cadastros.ch_semanal.DaoCH_SEMANAL;
import folha.model.br.com.parametros.cadastros.ch_semanal.CH_SEMANAL;
import folha.view.br.com.parametros.cadastros.ch_semanal.CadastroCH_SEMANAL;
import java.util.List;

/**
 *
 * @author andrei
 */
public class AcoesCadastroCH_SEMANAL {
    
    int SEQ_OPERADOR;
    int SEQ_PRIVILEGIO;
        
    AcoesCadastroCH_SEMANAL acoesCadastroCH_SEMANAL;
    CadastroCH_SEMANAL cadastroCH_SEMANAL;
    CH_SEMANAL ch_semanal = new CH_SEMANAL();
    DaoCH_SEMANAL daoCH_SEMANAL = new DaoCH_SEMANAL();
    
    
    public void abrirFrame(){
        acoesCadastroCH_SEMANAL = this;
        CadastroCH_SEMANAL c = new CadastroCH_SEMANAL();
        cadastroCH_SEMANAL = c;
        c.setDadosIniciais(cadastroCH_SEMANAL, this);
        c.setVisible(true);
    }
    
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