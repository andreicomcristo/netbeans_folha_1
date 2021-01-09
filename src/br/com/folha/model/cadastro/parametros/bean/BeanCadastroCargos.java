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
public class BeanCadastroCargos {
    
    private long seqCargo;
    private String nomeCargo;
    private String descricaoCargo;
    private long seqNivelCargo;
    private String nomeNivelCargo;

    public BeanCadastroCargos() {
    }

    
    public BeanCadastroCargos(long seqCargo, String nomeCargo, String descricaoCargo, long seqNivelCargo, String nomeNivelCargo) {
        this.seqCargo = seqCargo;
        this.nomeCargo = nomeCargo;
        this.descricaoCargo = descricaoCargo;
        this.seqNivelCargo = seqNivelCargo;
        this.nomeNivelCargo = nomeNivelCargo;
    }

    public String getNomeNivelCargo() {
        return nomeNivelCargo;
    }

    public void setNomeNivelCargo(String nomeNivelCargo) {
        this.nomeNivelCargo = nomeNivelCargo;
    }

    public long getSeqCargo() {
        return seqCargo;
    }

    public void setSeqCargo(long seqCargo) {
        this.seqCargo = seqCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public long getSeqNivelCargo() {
        return seqNivelCargo;
    }

    public void setSeqNivelCargo(long seqNivelCargo) {
        this.seqNivelCargo = seqNivelCargo;
    }

    
    
}
