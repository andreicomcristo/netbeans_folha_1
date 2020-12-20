/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package folha.control.br.com.parametros.cadastros.ch_semanal;

import folha.dao.br.com.parametros.cadastros.ch_semanal.DaoCargaHorariaSemanal;
import folha.model.br.com.parametros.cadastros.ch_semanal.CargaHorariaSemanal;
import folha.view.br.com.parametros.cadastros.ch_semanal.CadastroCargaHorariaSemanal;
import java.util.List;

/**
 *
 * @author andrei
 */
public class AcoesCadastroCargaHorariaSemanal {
    
    int SeqOperador;
    int SeqPrivilegio;
        
    AcoesCadastroCargaHorariaSemanal acoesCadastroCargaHorariaSemanal;
    CadastroCargaHorariaSemanal cadastroCargaHorariaSemanal;
    CargaHorariaSemanal chSemanal = new CargaHorariaSemanal();
    DaoCargaHorariaSemanal daoChSemanal = new DaoCargaHorariaSemanal();
    
    
    public void abrirFrame(){
        acoesCadastroCargaHorariaSemanal = this;
        CadastroCargaHorariaSemanal c = new CadastroCargaHorariaSemanal();
        cadastroCargaHorariaSemanal = c;
        c.setDadosIniciais(cadastroCargaHorariaSemanal, this);
        c.setVisible(true);
    }
    
    public boolean cadastrar(CargaHorariaSemanal ch_semanal){
        boolean executou = false;
        boolean acaoValida = true;
        if(ch_semanal.getCH()==0){acaoValida = false;}
            executou =daoChSemanal.inserir_CH_SEMANAL(ch_semanal);
        return executou;
    }
    
    public boolean excluir(CargaHorariaSemanal ch_semanal){
        boolean executou = false;
            executou =daoChSemanal.excluir_CH_SEMANAL(ch_semanal);
        return executou;
    }
    
    public boolean alterar(CargaHorariaSemanal ch_semanal){
        boolean executou = false;
            executou =daoChSemanal.alterar_CH_SEMANAL(ch_semanal);
        return executou;
    }
    
    public List<CargaHorariaSemanal> selecionar(){
        List dados =daoChSemanal.selecionar_CH_SEMANAL();
        return dados;
    }
 
    
    
    
}