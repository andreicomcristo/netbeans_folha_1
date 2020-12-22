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

    private ControlePrincipal controlePrincipal;
    private int seqCargaHorariaSemanal;
    private int cargaHoraria;
    private String descricaoCargaHoraria;

    public BeanCargaHorariaSemanal() {
    }

    public BeanCargaHorariaSemanal(int seqCargaHorariaSemanal, int cargaHoraria, String descricaoCargaHoraria) {
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

    public int getSeqCargaHorariaSemanal() {
        return seqCargaHorariaSemanal;
    }

    public void setSeqCargaHorariaSemanal(int seqCargaHorariaSemanal) {
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
