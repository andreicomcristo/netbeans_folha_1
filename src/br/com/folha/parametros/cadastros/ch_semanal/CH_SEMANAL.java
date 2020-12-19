/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.parametros.cadastros.ch_semanal;



/**
 *
 * @author andrei
 */
public class CH_SEMANAL {


   int SEQ_CH_SEMANAL;
   int CH;
   String DESCRICAO_CH;

    public CH_SEMANAL() {
    }

    public CH_SEMANAL(int SEQ_CH_SEMANAL, int CH, String DESCRICAO_CH) {
        this.SEQ_CH_SEMANAL = SEQ_CH_SEMANAL;
        this.CH = CH;
        this.DESCRICAO_CH = DESCRICAO_CH;
    }

    public int getSEQ_CH_SEMANAL() {
        return SEQ_CH_SEMANAL;
    }

    public void setSEQ_CH_SEMANAL(int SEQ_CH_SEMANAL) {
        this.SEQ_CH_SEMANAL = SEQ_CH_SEMANAL;
    }

    public int getCH() {
        return CH;
    }

    public void setCH(int CH) {
        this.CH = CH;
    }

    public String getDESCRICAO_CH() {
        return DESCRICAO_CH;
    }

    public void setDESCRICAO_CH(String DESCRICAO_CH) {
        this.DESCRICAO_CH = DESCRICAO_CH;
    }

    


}
