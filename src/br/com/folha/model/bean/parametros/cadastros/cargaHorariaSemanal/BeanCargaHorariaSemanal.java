/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.bean.parametros.cadastros.cargaHorariaSemanal;

import br.com.folha.control.principal.ControlePrincipal;

/**
 *
 * @author andrei
 */
public class BeanCargaHorariaSemanal {

    private ControlePrincipal controlePrincipal;
    private long seqCargaHorariaSemanal;
    private int cargaHoraria;
    private String descricaoCargaHoraria;

    public BeanCargaHorariaSemanal() {
    }

    public BeanCargaHorariaSemanal(long seqCargaHorariaSemanal, int cargaHoraria, String descricaoCargaHoraria) {
        this.seqCargaHorariaSemanal = seqCargaHorariaSemanal;
        this.cargaHoraria = cargaHoraria;
        this.descricaoCargaHoraria = descricaoCargaHoraria;
    }

    public ControlePrincipal getControlePrincipal() {
        return controlePrincipal;
    }

    public void setControlePrincipal(ControlePrincipal controlePrincipal) {
        this.controlePrincipal = controlePrincipal;
    }

    public long getSeqCargaHorariaSemanal() {
        return seqCargaHorariaSemanal;
    }

    public void setSeqCargaHorariaSemanal(long seqCargaHorariaSemanal) {
        this.seqCargaHorariaSemanal = seqCargaHorariaSemanal;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricaoCargaHoraria() {
        return descricaoCargaHoraria;
    }

    public void setDescricaoCargaHoraria(String descricaoCargaHoraria) {
        this.descricaoCargaHoraria = descricaoCargaHoraria;
    }

    
    

    


}
