/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.beanWeb;

/**
 *
 * @author andrei
 */
public class BeanWebCargaHorariaSemanal {

    
    private String seqCargaHorariaSemanal;
    private String cargaHoraria;
    private String descricaoCargaHoraria;

    public BeanWebCargaHorariaSemanal() {
    }

    public BeanWebCargaHorariaSemanal(String seqCargaHorariaSemanal, String cargaHoraria, String descricaoCargaHoraria) {
        this.seqCargaHorariaSemanal = seqCargaHorariaSemanal;
        this.cargaHoraria = cargaHoraria;
        this.descricaoCargaHoraria = descricaoCargaHoraria;
    }

    public String getSeqCargaHorariaSemanal() {
        return seqCargaHorariaSemanal;
    }

    public void setSeqCargaHorariaSemanal(String seqCargaHorariaSemanal) {
        this.seqCargaHorariaSemanal = seqCargaHorariaSemanal;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricaoCargaHoraria() {
        return descricaoCargaHoraria;
    }

    public void setDescricaoCargaHoraria(String descricaoCargaHoraria) {
        this.descricaoCargaHoraria = descricaoCargaHoraria;
    }

        

    


}
