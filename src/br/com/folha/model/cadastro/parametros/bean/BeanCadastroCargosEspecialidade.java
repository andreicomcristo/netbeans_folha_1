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
public class BeanCadastroCargosEspecialidade {
    
    private long seqEspecialidadeCargo;
    private String nomeEspecialidadeCargo;
    private String descriçãoEspecialidadeCargo;
    private long seqCargo;
    private String nomeCargo;

    public BeanCadastroCargosEspecialidade() {
    }

    public BeanCadastroCargosEspecialidade(long seqEspecialidadeCargo, String nomeEspecialidadeCargo, String descriçãoEspecialidadeCargo, long seqCargo, String nomeCargo) {
        this.seqEspecialidadeCargo = seqEspecialidadeCargo;
        this.nomeEspecialidadeCargo = nomeEspecialidadeCargo;
        this.descriçãoEspecialidadeCargo = descriçãoEspecialidadeCargo;
        this.seqCargo = seqCargo;
        this.nomeCargo = nomeCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public long getSeqEspecialidadeCargo() {
        return seqEspecialidadeCargo;
    }

    public void setSeqEspecialidadeCargo(long seqEspecialidadeCargo) {
        this.seqEspecialidadeCargo = seqEspecialidadeCargo;
    }

    public String getNomeEspecialidadeCargo() {
        return nomeEspecialidadeCargo;
    }

    public void setNomeEspecialidadeCargo(String nomeEspecialidadeCargo) {
        this.nomeEspecialidadeCargo = nomeEspecialidadeCargo;
    }

    public String getDescriçãoEspecialidadeCargo() {
        return descriçãoEspecialidadeCargo;
    }

    public void setDescriçãoEspecialidadeCargo(String descriçãoEspecialidadeCargo) {
        this.descriçãoEspecialidadeCargo = descriçãoEspecialidadeCargo;
    }

    public long getSeqCargo() {
        return seqCargo;
    }

    public void setSeqCargo(long seqCargo) {
        this.seqCargo = seqCargo;
    }
     
    
}
