/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.parametros.cadastros.cargaHorariaSemanal;

import br.com.folha.control.principal.ControlePrincipal;

/**
 *
 * @author andrei
 */
public class BeanCargaHorariaSemanal {

    public ControlePrincipal controlePrincipal;
    int seq_carga_horaria_sem;
    int carga_horaria;
    String descricao_carga_horaria;

    public BeanCargaHorariaSemanal() {
    }

    public BeanCargaHorariaSemanal(int seq_carga_horaria_sem, int carga_horaria, String descricao_carga_horaria) {
        this.seq_carga_horaria_sem = seq_carga_horaria_sem;
        this.carga_horaria = carga_horaria;
        this.descricao_carga_horaria = descricao_carga_horaria;
    }

    public ControlePrincipal getControlePrincipal() {
        return controlePrincipal;
    }

    public void setControlePrincipal(ControlePrincipal controlePrincipal) {
        this.controlePrincipal = controlePrincipal;
    }

    
    
    public int getSeq_carga_horaria_sem() {
        return seq_carga_horaria_sem;
    }

    public void setSeq_carga_horaria_sem(int seq_carga_horaria_sem) {
        this.seq_carga_horaria_sem = seq_carga_horaria_sem;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getDescricao_carga_horaria() {
        return descricao_carga_horaria;
    }

    public void setDescricao_carga_horaria(String descricao_carga_horaria) {
        this.descricao_carga_horaria = descricao_carga_horaria;
    }

    

    


}
