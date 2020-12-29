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
public class BeanCadastroPrivilegios {
    
    private long seqPrivilegio;
    private String nomePrivilegio;
    private String descricaoPrivilegio;

    public BeanCadastroPrivilegios() {
    }

    public BeanCadastroPrivilegios(long seqPrivilegio, String nomePrivilegio, String descricaoPrivilegio) {
        this.seqPrivilegio = seqPrivilegio;
        this.nomePrivilegio = nomePrivilegio;
        this.descricaoPrivilegio = descricaoPrivilegio;
    }
    
    

    public long getSeqPrivilegio() {
        return seqPrivilegio;
    }

    public void setSeqPrivilegio(long seqPrivilegio) {
        this.seqPrivilegio = seqPrivilegio;
    }

    public String getNomePrivilegio() {
        return nomePrivilegio;
    }

    public void setNomePrivilegio(String nomePrivilegio) {
        this.nomePrivilegio = nomePrivilegio;
    }

    public String getDescricaoPrivilegio() {
        return descricaoPrivilegio;
    }

    public void setDescricaoPrivilegio(String descricaoPrivilegio) {
        this.descricaoPrivilegio = descricaoPrivilegio;
    }
    
    
    
}
