/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.model.cadastro.parametros.bean;

/**
 *
 * @author andre
 */
public class BeanCadastroNiveisCargos {
    
    private long seqNivelCargo;
    private String siglaNivelCargo;
    private String nomeNivelCargo;
    private String descricaoNivelCargo;

    public BeanCadastroNiveisCargos() {
    }

    public BeanCadastroNiveisCargos(long seqNIvelCargo, String siglaNivelCargo, String nomeNivelCargo, String descricaoNivelCargo) {
        this.seqNivelCargo = seqNIvelCargo;
        this.siglaNivelCargo = siglaNivelCargo;
        this.nomeNivelCargo = nomeNivelCargo;
        this.descricaoNivelCargo = descricaoNivelCargo;
    }

    public String getDescricaoNivelCargo() {
        return descricaoNivelCargo;
    }

    public void setDescricaoNivelCargo(String descricaoNivelCargo) {
        this.descricaoNivelCargo = descricaoNivelCargo;
    }

    public long getSeqNivelCargo() {
        return seqNivelCargo;
    }

    public void setSeqNivelCargo(long seqNivelCargo) {
        this.seqNivelCargo = seqNivelCargo;
    }

    public String getSiglaNivelCargo() {
        return siglaNivelCargo;
    }

    public void setSiglaNivelCargo(String siglaNivelCargo) {
        this.siglaNivelCargo = siglaNivelCargo;
    }

    public String getNomeNivelCargo() {
        return nomeNivelCargo;
    }

    public void setNomeNivelCargo(String nomeNivelCargo) {
        this.nomeNivelCargo = nomeNivelCargo;
    }
    
    
}
