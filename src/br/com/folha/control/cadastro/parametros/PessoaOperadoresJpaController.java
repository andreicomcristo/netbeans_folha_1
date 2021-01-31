/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.Privilegios;
import br.com.folha.model.tabelas.HistFuncionariosAutorizacao;
import java.util.ArrayList;
import java.util.Collection;
import br.com.folha.model.tabelas.HistFuncionariosClasse;
import br.com.folha.model.tabelas.HistFuncionariosCargaHoraria;
import br.com.folha.model.tabelas.HistFuncionariosCargos;
import br.com.folha.model.tabelas.PessoaFilhos;
import br.com.folha.model.tabelas.Unidades;
import br.com.folha.model.tabelas.HistUnidadesNaturezaJuridica;
import br.com.folha.model.tabelas.HistUnidadesRegime;
import br.com.folha.model.tabelas.HistFuncionariosCarreira;
import br.com.folha.model.tabelas.HistFuncionariosSituacoes;
import br.com.folha.model.tabelas.Autorizacoes;
import br.com.folha.model.tabelas.PessoaBancos;
import br.com.folha.model.tabelas.HistFuncionariosVinculos;
import br.com.folha.model.tabelas.HistUnidadesDiretor;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.HistFuncionariosUnidadeLotacao;
import br.com.folha.model.tabelas.HistFuncionariosUnidadeAtuacao;
import br.com.folha.model.tabelas.PessoaOperadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaOperadoresJpaController implements Serializable {

    public PessoaOperadoresJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaOperadores pessoaOperadores) {
        if (pessoaOperadores.getHistFuncionariosAutorizacaoCollection() == null) {
            pessoaOperadores.setHistFuncionariosAutorizacaoCollection(new ArrayList<HistFuncionariosAutorizacao>());
        }
        if (pessoaOperadores.getHistFuncionariosAutorizacaoCollection1() == null) {
            pessoaOperadores.setHistFuncionariosAutorizacaoCollection1(new ArrayList<HistFuncionariosAutorizacao>());
        }
        if (pessoaOperadores.getHistFuncionariosClasseCollection() == null) {
            pessoaOperadores.setHistFuncionariosClasseCollection(new ArrayList<HistFuncionariosClasse>());
        }
        if (pessoaOperadores.getHistFuncionariosClasseCollection1() == null) {
            pessoaOperadores.setHistFuncionariosClasseCollection1(new ArrayList<HistFuncionariosClasse>());
        }
        if (pessoaOperadores.getHistFuncionariosCargaHorariaCollection() == null) {
            pessoaOperadores.setHistFuncionariosCargaHorariaCollection(new ArrayList<HistFuncionariosCargaHoraria>());
        }
        if (pessoaOperadores.getHistFuncionariosCargaHorariaCollection1() == null) {
            pessoaOperadores.setHistFuncionariosCargaHorariaCollection1(new ArrayList<HistFuncionariosCargaHoraria>());
        }
        if (pessoaOperadores.getHistFuncionariosCargosCollection() == null) {
            pessoaOperadores.setHistFuncionariosCargosCollection(new ArrayList<HistFuncionariosCargos>());
        }
        if (pessoaOperadores.getHistFuncionariosCargosCollection1() == null) {
            pessoaOperadores.setHistFuncionariosCargosCollection1(new ArrayList<HistFuncionariosCargos>());
        }
        if (pessoaOperadores.getPessoaFilhosCollection() == null) {
            pessoaOperadores.setPessoaFilhosCollection(new ArrayList<PessoaFilhos>());
        }
        if (pessoaOperadores.getPessoaFilhosCollection1() == null) {
            pessoaOperadores.setPessoaFilhosCollection1(new ArrayList<PessoaFilhos>());
        }
        if (pessoaOperadores.getUnidadesCollection() == null) {
            pessoaOperadores.setUnidadesCollection(new ArrayList<Unidades>());
        }
        if (pessoaOperadores.getUnidadesCollection1() == null) {
            pessoaOperadores.setUnidadesCollection1(new ArrayList<Unidades>());
        }
        if (pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection() == null) {
            pessoaOperadores.setHistUnidadesNaturezaJuridicaCollection(new ArrayList<HistUnidadesNaturezaJuridica>());
        }
        if (pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection1() == null) {
            pessoaOperadores.setHistUnidadesNaturezaJuridicaCollection1(new ArrayList<HistUnidadesNaturezaJuridica>());
        }
        if (pessoaOperadores.getHistUnidadesRegimeCollection() == null) {
            pessoaOperadores.setHistUnidadesRegimeCollection(new ArrayList<HistUnidadesRegime>());
        }
        if (pessoaOperadores.getHistUnidadesRegimeCollection1() == null) {
            pessoaOperadores.setHistUnidadesRegimeCollection1(new ArrayList<HistUnidadesRegime>());
        }
        if (pessoaOperadores.getPessoaCollection() == null) {
            pessoaOperadores.setPessoaCollection(new ArrayList<Pessoa>());
        }
        if (pessoaOperadores.getPessoaCollection1() == null) {
            pessoaOperadores.setPessoaCollection1(new ArrayList<Pessoa>());
        }
        if (pessoaOperadores.getHistFuncionariosCarreiraCollection() == null) {
            pessoaOperadores.setHistFuncionariosCarreiraCollection(new ArrayList<HistFuncionariosCarreira>());
        }
        if (pessoaOperadores.getHistFuncionariosCarreiraCollection1() == null) {
            pessoaOperadores.setHistFuncionariosCarreiraCollection1(new ArrayList<HistFuncionariosCarreira>());
        }
        if (pessoaOperadores.getHistFuncionariosSituacoesCollection() == null) {
            pessoaOperadores.setHistFuncionariosSituacoesCollection(new ArrayList<HistFuncionariosSituacoes>());
        }
        if (pessoaOperadores.getHistFuncionariosSituacoesCollection1() == null) {
            pessoaOperadores.setHistFuncionariosSituacoesCollection1(new ArrayList<HistFuncionariosSituacoes>());
        }
        if (pessoaOperadores.getAutorizacoesCollection() == null) {
            pessoaOperadores.setAutorizacoesCollection(new ArrayList<Autorizacoes>());
        }
        if (pessoaOperadores.getPessoaBancosCollection() == null) {
            pessoaOperadores.setPessoaBancosCollection(new ArrayList<PessoaBancos>());
        }
        if (pessoaOperadores.getPessoaBancosCollection1() == null) {
            pessoaOperadores.setPessoaBancosCollection1(new ArrayList<PessoaBancos>());
        }
        if (pessoaOperadores.getHistFuncionariosVinculosCollection() == null) {
            pessoaOperadores.setHistFuncionariosVinculosCollection(new ArrayList<HistFuncionariosVinculos>());
        }
        if (pessoaOperadores.getHistFuncionariosVinculosCollection1() == null) {
            pessoaOperadores.setHistFuncionariosVinculosCollection1(new ArrayList<HistFuncionariosVinculos>());
        }
        if (pessoaOperadores.getHistUnidadesDiretorCollection() == null) {
            pessoaOperadores.setHistUnidadesDiretorCollection(new ArrayList<HistUnidadesDiretor>());
        }
        if (pessoaOperadores.getHistUnidadesDiretorCollection1() == null) {
            pessoaOperadores.setHistUnidadesDiretorCollection1(new ArrayList<HistUnidadesDiretor>());
        }
        if (pessoaOperadores.getPessoaFuncionariosCollection() == null) {
            pessoaOperadores.setPessoaFuncionariosCollection(new ArrayList<PessoaFuncionarios>());
        }
        if (pessoaOperadores.getPessoaFuncionariosCollection1() == null) {
            pessoaOperadores.setPessoaFuncionariosCollection1(new ArrayList<PessoaFuncionarios>());
        }
        if (pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection() == null) {
            pessoaOperadores.setHistFuncionariosUnidadeLotacaoCollection(new ArrayList<HistFuncionariosUnidadeLotacao>());
        }
        if (pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection1() == null) {
            pessoaOperadores.setHistFuncionariosUnidadeLotacaoCollection1(new ArrayList<HistFuncionariosUnidadeLotacao>());
        }
        if (pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection() == null) {
            pessoaOperadores.setHistFuncionariosUnidadeAtuacaoCollection(new ArrayList<HistFuncionariosUnidadeAtuacao>());
        }
        if (pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection1() == null) {
            pessoaOperadores.setHistFuncionariosUnidadeAtuacaoCollection1(new ArrayList<HistFuncionariosUnidadeAtuacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa idPessoaFk = pessoaOperadores.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaOperadores.setIdPessoaFk(idPessoaFk);
            }
            Privilegios seqPrivilegio = pessoaOperadores.getSeqPrivilegio();
            if (seqPrivilegio != null) {
                seqPrivilegio = em.getReference(seqPrivilegio.getClass(), seqPrivilegio.getId());
                pessoaOperadores.setSeqPrivilegio(seqPrivilegio);
            }
            Collection<HistFuncionariosAutorizacao> attachedHistFuncionariosAutorizacaoCollection = new ArrayList<HistFuncionariosAutorizacao>();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach : pessoaOperadores.getHistFuncionariosAutorizacaoCollection()) {
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach = em.getReference(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach.getClass(), histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach.getId());
                attachedHistFuncionariosAutorizacaoCollection.add(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach);
            }
            pessoaOperadores.setHistFuncionariosAutorizacaoCollection(attachedHistFuncionariosAutorizacaoCollection);
            Collection<HistFuncionariosAutorizacao> attachedHistFuncionariosAutorizacaoCollection1 = new ArrayList<HistFuncionariosAutorizacao>();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacaoToAttach : pessoaOperadores.getHistFuncionariosAutorizacaoCollection1()) {
                histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacaoToAttach = em.getReference(histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacaoToAttach.getClass(), histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacaoToAttach.getId());
                attachedHistFuncionariosAutorizacaoCollection1.add(histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacaoToAttach);
            }
            pessoaOperadores.setHistFuncionariosAutorizacaoCollection1(attachedHistFuncionariosAutorizacaoCollection1);
            Collection<HistFuncionariosClasse> attachedHistFuncionariosClasseCollection = new ArrayList<HistFuncionariosClasse>();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionHistFuncionariosClasseToAttach : pessoaOperadores.getHistFuncionariosClasseCollection()) {
                histFuncionariosClasseCollectionHistFuncionariosClasseToAttach = em.getReference(histFuncionariosClasseCollectionHistFuncionariosClasseToAttach.getClass(), histFuncionariosClasseCollectionHistFuncionariosClasseToAttach.getId());
                attachedHistFuncionariosClasseCollection.add(histFuncionariosClasseCollectionHistFuncionariosClasseToAttach);
            }
            pessoaOperadores.setHistFuncionariosClasseCollection(attachedHistFuncionariosClasseCollection);
            Collection<HistFuncionariosClasse> attachedHistFuncionariosClasseCollection1 = new ArrayList<HistFuncionariosClasse>();
            for (HistFuncionariosClasse histFuncionariosClasseCollection1HistFuncionariosClasseToAttach : pessoaOperadores.getHistFuncionariosClasseCollection1()) {
                histFuncionariosClasseCollection1HistFuncionariosClasseToAttach = em.getReference(histFuncionariosClasseCollection1HistFuncionariosClasseToAttach.getClass(), histFuncionariosClasseCollection1HistFuncionariosClasseToAttach.getId());
                attachedHistFuncionariosClasseCollection1.add(histFuncionariosClasseCollection1HistFuncionariosClasseToAttach);
            }
            pessoaOperadores.setHistFuncionariosClasseCollection1(attachedHistFuncionariosClasseCollection1);
            Collection<HistFuncionariosCargaHoraria> attachedHistFuncionariosCargaHorariaCollection = new ArrayList<HistFuncionariosCargaHoraria>();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach : pessoaOperadores.getHistFuncionariosCargaHorariaCollection()) {
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach = em.getReference(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach.getClass(), histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach.getId());
                attachedHistFuncionariosCargaHorariaCollection.add(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach);
            }
            pessoaOperadores.setHistFuncionariosCargaHorariaCollection(attachedHistFuncionariosCargaHorariaCollection);
            Collection<HistFuncionariosCargaHoraria> attachedHistFuncionariosCargaHorariaCollection1 = new ArrayList<HistFuncionariosCargaHoraria>();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHorariaToAttach : pessoaOperadores.getHistFuncionariosCargaHorariaCollection1()) {
                histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHorariaToAttach = em.getReference(histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHorariaToAttach.getClass(), histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHorariaToAttach.getId());
                attachedHistFuncionariosCargaHorariaCollection1.add(histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHorariaToAttach);
            }
            pessoaOperadores.setHistFuncionariosCargaHorariaCollection1(attachedHistFuncionariosCargaHorariaCollection1);
            Collection<HistFuncionariosCargos> attachedHistFuncionariosCargosCollection = new ArrayList<HistFuncionariosCargos>();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionHistFuncionariosCargosToAttach : pessoaOperadores.getHistFuncionariosCargosCollection()) {
                histFuncionariosCargosCollectionHistFuncionariosCargosToAttach = em.getReference(histFuncionariosCargosCollectionHistFuncionariosCargosToAttach.getClass(), histFuncionariosCargosCollectionHistFuncionariosCargosToAttach.getId());
                attachedHistFuncionariosCargosCollection.add(histFuncionariosCargosCollectionHistFuncionariosCargosToAttach);
            }
            pessoaOperadores.setHistFuncionariosCargosCollection(attachedHistFuncionariosCargosCollection);
            Collection<HistFuncionariosCargos> attachedHistFuncionariosCargosCollection1 = new ArrayList<HistFuncionariosCargos>();
            for (HistFuncionariosCargos histFuncionariosCargosCollection1HistFuncionariosCargosToAttach : pessoaOperadores.getHistFuncionariosCargosCollection1()) {
                histFuncionariosCargosCollection1HistFuncionariosCargosToAttach = em.getReference(histFuncionariosCargosCollection1HistFuncionariosCargosToAttach.getClass(), histFuncionariosCargosCollection1HistFuncionariosCargosToAttach.getId());
                attachedHistFuncionariosCargosCollection1.add(histFuncionariosCargosCollection1HistFuncionariosCargosToAttach);
            }
            pessoaOperadores.setHistFuncionariosCargosCollection1(attachedHistFuncionariosCargosCollection1);
            Collection<PessoaFilhos> attachedPessoaFilhosCollection = new ArrayList<PessoaFilhos>();
            for (PessoaFilhos pessoaFilhosCollectionPessoaFilhosToAttach : pessoaOperadores.getPessoaFilhosCollection()) {
                pessoaFilhosCollectionPessoaFilhosToAttach = em.getReference(pessoaFilhosCollectionPessoaFilhosToAttach.getClass(), pessoaFilhosCollectionPessoaFilhosToAttach.getId());
                attachedPessoaFilhosCollection.add(pessoaFilhosCollectionPessoaFilhosToAttach);
            }
            pessoaOperadores.setPessoaFilhosCollection(attachedPessoaFilhosCollection);
            Collection<PessoaFilhos> attachedPessoaFilhosCollection1 = new ArrayList<PessoaFilhos>();
            for (PessoaFilhos pessoaFilhosCollection1PessoaFilhosToAttach : pessoaOperadores.getPessoaFilhosCollection1()) {
                pessoaFilhosCollection1PessoaFilhosToAttach = em.getReference(pessoaFilhosCollection1PessoaFilhosToAttach.getClass(), pessoaFilhosCollection1PessoaFilhosToAttach.getId());
                attachedPessoaFilhosCollection1.add(pessoaFilhosCollection1PessoaFilhosToAttach);
            }
            pessoaOperadores.setPessoaFilhosCollection1(attachedPessoaFilhosCollection1);
            Collection<Unidades> attachedUnidadesCollection = new ArrayList<Unidades>();
            for (Unidades unidadesCollectionUnidadesToAttach : pessoaOperadores.getUnidadesCollection()) {
                unidadesCollectionUnidadesToAttach = em.getReference(unidadesCollectionUnidadesToAttach.getClass(), unidadesCollectionUnidadesToAttach.getId());
                attachedUnidadesCollection.add(unidadesCollectionUnidadesToAttach);
            }
            pessoaOperadores.setUnidadesCollection(attachedUnidadesCollection);
            Collection<Unidades> attachedUnidadesCollection1 = new ArrayList<Unidades>();
            for (Unidades unidadesCollection1UnidadesToAttach : pessoaOperadores.getUnidadesCollection1()) {
                unidadesCollection1UnidadesToAttach = em.getReference(unidadesCollection1UnidadesToAttach.getClass(), unidadesCollection1UnidadesToAttach.getId());
                attachedUnidadesCollection1.add(unidadesCollection1UnidadesToAttach);
            }
            pessoaOperadores.setUnidadesCollection1(attachedUnidadesCollection1);
            Collection<HistUnidadesNaturezaJuridica> attachedHistUnidadesNaturezaJuridicaCollection = new ArrayList<HistUnidadesNaturezaJuridica>();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach : pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection()) {
                histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach = em.getReference(histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach.getClass(), histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach.getId());
                attachedHistUnidadesNaturezaJuridicaCollection.add(histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach);
            }
            pessoaOperadores.setHistUnidadesNaturezaJuridicaCollection(attachedHistUnidadesNaturezaJuridicaCollection);
            Collection<HistUnidadesNaturezaJuridica> attachedHistUnidadesNaturezaJuridicaCollection1 = new ArrayList<HistUnidadesNaturezaJuridica>();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridicaToAttach : pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection1()) {
                histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridicaToAttach = em.getReference(histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridicaToAttach.getClass(), histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridicaToAttach.getId());
                attachedHistUnidadesNaturezaJuridicaCollection1.add(histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridicaToAttach);
            }
            pessoaOperadores.setHistUnidadesNaturezaJuridicaCollection1(attachedHistUnidadesNaturezaJuridicaCollection1);
            Collection<HistUnidadesRegime> attachedHistUnidadesRegimeCollection = new ArrayList<HistUnidadesRegime>();
            for (HistUnidadesRegime histUnidadesRegimeCollectionHistUnidadesRegimeToAttach : pessoaOperadores.getHistUnidadesRegimeCollection()) {
                histUnidadesRegimeCollectionHistUnidadesRegimeToAttach = em.getReference(histUnidadesRegimeCollectionHistUnidadesRegimeToAttach.getClass(), histUnidadesRegimeCollectionHistUnidadesRegimeToAttach.getId());
                attachedHistUnidadesRegimeCollection.add(histUnidadesRegimeCollectionHistUnidadesRegimeToAttach);
            }
            pessoaOperadores.setHistUnidadesRegimeCollection(attachedHistUnidadesRegimeCollection);
            Collection<HistUnidadesRegime> attachedHistUnidadesRegimeCollection1 = new ArrayList<HistUnidadesRegime>();
            for (HistUnidadesRegime histUnidadesRegimeCollection1HistUnidadesRegimeToAttach : pessoaOperadores.getHistUnidadesRegimeCollection1()) {
                histUnidadesRegimeCollection1HistUnidadesRegimeToAttach = em.getReference(histUnidadesRegimeCollection1HistUnidadesRegimeToAttach.getClass(), histUnidadesRegimeCollection1HistUnidadesRegimeToAttach.getId());
                attachedHistUnidadesRegimeCollection1.add(histUnidadesRegimeCollection1HistUnidadesRegimeToAttach);
            }
            pessoaOperadores.setHistUnidadesRegimeCollection1(attachedHistUnidadesRegimeCollection1);
            Collection<Pessoa> attachedPessoaCollection = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionPessoaToAttach : pessoaOperadores.getPessoaCollection()) {
                pessoaCollectionPessoaToAttach = em.getReference(pessoaCollectionPessoaToAttach.getClass(), pessoaCollectionPessoaToAttach.getId());
                attachedPessoaCollection.add(pessoaCollectionPessoaToAttach);
            }
            pessoaOperadores.setPessoaCollection(attachedPessoaCollection);
            Collection<Pessoa> attachedPessoaCollection1 = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollection1PessoaToAttach : pessoaOperadores.getPessoaCollection1()) {
                pessoaCollection1PessoaToAttach = em.getReference(pessoaCollection1PessoaToAttach.getClass(), pessoaCollection1PessoaToAttach.getId());
                attachedPessoaCollection1.add(pessoaCollection1PessoaToAttach);
            }
            pessoaOperadores.setPessoaCollection1(attachedPessoaCollection1);
            Collection<HistFuncionariosCarreira> attachedHistFuncionariosCarreiraCollection = new ArrayList<HistFuncionariosCarreira>();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach : pessoaOperadores.getHistFuncionariosCarreiraCollection()) {
                histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach = em.getReference(histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach.getClass(), histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach.getId());
                attachedHistFuncionariosCarreiraCollection.add(histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach);
            }
            pessoaOperadores.setHistFuncionariosCarreiraCollection(attachedHistFuncionariosCarreiraCollection);
            Collection<HistFuncionariosCarreira> attachedHistFuncionariosCarreiraCollection1 = new ArrayList<HistFuncionariosCarreira>();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollection1HistFuncionariosCarreiraToAttach : pessoaOperadores.getHistFuncionariosCarreiraCollection1()) {
                histFuncionariosCarreiraCollection1HistFuncionariosCarreiraToAttach = em.getReference(histFuncionariosCarreiraCollection1HistFuncionariosCarreiraToAttach.getClass(), histFuncionariosCarreiraCollection1HistFuncionariosCarreiraToAttach.getId());
                attachedHistFuncionariosCarreiraCollection1.add(histFuncionariosCarreiraCollection1HistFuncionariosCarreiraToAttach);
            }
            pessoaOperadores.setHistFuncionariosCarreiraCollection1(attachedHistFuncionariosCarreiraCollection1);
            Collection<HistFuncionariosSituacoes> attachedHistFuncionariosSituacoesCollection = new ArrayList<HistFuncionariosSituacoes>();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach : pessoaOperadores.getHistFuncionariosSituacoesCollection()) {
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach = em.getReference(histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach.getClass(), histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach.getId());
                attachedHistFuncionariosSituacoesCollection.add(histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach);
            }
            pessoaOperadores.setHistFuncionariosSituacoesCollection(attachedHistFuncionariosSituacoesCollection);
            Collection<HistFuncionariosSituacoes> attachedHistFuncionariosSituacoesCollection1 = new ArrayList<HistFuncionariosSituacoes>();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollection1HistFuncionariosSituacoesToAttach : pessoaOperadores.getHistFuncionariosSituacoesCollection1()) {
                histFuncionariosSituacoesCollection1HistFuncionariosSituacoesToAttach = em.getReference(histFuncionariosSituacoesCollection1HistFuncionariosSituacoesToAttach.getClass(), histFuncionariosSituacoesCollection1HistFuncionariosSituacoesToAttach.getId());
                attachedHistFuncionariosSituacoesCollection1.add(histFuncionariosSituacoesCollection1HistFuncionariosSituacoesToAttach);
            }
            pessoaOperadores.setHistFuncionariosSituacoesCollection1(attachedHistFuncionariosSituacoesCollection1);
            Collection<Autorizacoes> attachedAutorizacoesCollection = new ArrayList<Autorizacoes>();
            for (Autorizacoes autorizacoesCollectionAutorizacoesToAttach : pessoaOperadores.getAutorizacoesCollection()) {
                autorizacoesCollectionAutorizacoesToAttach = em.getReference(autorizacoesCollectionAutorizacoesToAttach.getClass(), autorizacoesCollectionAutorizacoesToAttach.getId());
                attachedAutorizacoesCollection.add(autorizacoesCollectionAutorizacoesToAttach);
            }
            pessoaOperadores.setAutorizacoesCollection(attachedAutorizacoesCollection);
            Collection<PessoaBancos> attachedPessoaBancosCollection = new ArrayList<PessoaBancos>();
            for (PessoaBancos pessoaBancosCollectionPessoaBancosToAttach : pessoaOperadores.getPessoaBancosCollection()) {
                pessoaBancosCollectionPessoaBancosToAttach = em.getReference(pessoaBancosCollectionPessoaBancosToAttach.getClass(), pessoaBancosCollectionPessoaBancosToAttach.getId());
                attachedPessoaBancosCollection.add(pessoaBancosCollectionPessoaBancosToAttach);
            }
            pessoaOperadores.setPessoaBancosCollection(attachedPessoaBancosCollection);
            Collection<PessoaBancos> attachedPessoaBancosCollection1 = new ArrayList<PessoaBancos>();
            for (PessoaBancos pessoaBancosCollection1PessoaBancosToAttach : pessoaOperadores.getPessoaBancosCollection1()) {
                pessoaBancosCollection1PessoaBancosToAttach = em.getReference(pessoaBancosCollection1PessoaBancosToAttach.getClass(), pessoaBancosCollection1PessoaBancosToAttach.getId());
                attachedPessoaBancosCollection1.add(pessoaBancosCollection1PessoaBancosToAttach);
            }
            pessoaOperadores.setPessoaBancosCollection1(attachedPessoaBancosCollection1);
            Collection<HistFuncionariosVinculos> attachedHistFuncionariosVinculosCollection = new ArrayList<HistFuncionariosVinculos>();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach : pessoaOperadores.getHistFuncionariosVinculosCollection()) {
                histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach = em.getReference(histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach.getClass(), histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach.getId());
                attachedHistFuncionariosVinculosCollection.add(histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach);
            }
            pessoaOperadores.setHistFuncionariosVinculosCollection(attachedHistFuncionariosVinculosCollection);
            Collection<HistFuncionariosVinculos> attachedHistFuncionariosVinculosCollection1 = new ArrayList<HistFuncionariosVinculos>();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollection1HistFuncionariosVinculosToAttach : pessoaOperadores.getHistFuncionariosVinculosCollection1()) {
                histFuncionariosVinculosCollection1HistFuncionariosVinculosToAttach = em.getReference(histFuncionariosVinculosCollection1HistFuncionariosVinculosToAttach.getClass(), histFuncionariosVinculosCollection1HistFuncionariosVinculosToAttach.getId());
                attachedHistFuncionariosVinculosCollection1.add(histFuncionariosVinculosCollection1HistFuncionariosVinculosToAttach);
            }
            pessoaOperadores.setHistFuncionariosVinculosCollection1(attachedHistFuncionariosVinculosCollection1);
            Collection<HistUnidadesDiretor> attachedHistUnidadesDiretorCollection = new ArrayList<HistUnidadesDiretor>();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionHistUnidadesDiretorToAttach : pessoaOperadores.getHistUnidadesDiretorCollection()) {
                histUnidadesDiretorCollectionHistUnidadesDiretorToAttach = em.getReference(histUnidadesDiretorCollectionHistUnidadesDiretorToAttach.getClass(), histUnidadesDiretorCollectionHistUnidadesDiretorToAttach.getHistUnidadesDiretorPK());
                attachedHistUnidadesDiretorCollection.add(histUnidadesDiretorCollectionHistUnidadesDiretorToAttach);
            }
            pessoaOperadores.setHistUnidadesDiretorCollection(attachedHistUnidadesDiretorCollection);
            Collection<HistUnidadesDiretor> attachedHistUnidadesDiretorCollection1 = new ArrayList<HistUnidadesDiretor>();
            for (HistUnidadesDiretor histUnidadesDiretorCollection1HistUnidadesDiretorToAttach : pessoaOperadores.getHistUnidadesDiretorCollection1()) {
                histUnidadesDiretorCollection1HistUnidadesDiretorToAttach = em.getReference(histUnidadesDiretorCollection1HistUnidadesDiretorToAttach.getClass(), histUnidadesDiretorCollection1HistUnidadesDiretorToAttach.getHistUnidadesDiretorPK());
                attachedHistUnidadesDiretorCollection1.add(histUnidadesDiretorCollection1HistUnidadesDiretorToAttach);
            }
            pessoaOperadores.setHistUnidadesDiretorCollection1(attachedHistUnidadesDiretorCollection1);
            Collection<PessoaFuncionarios> attachedPessoaFuncionariosCollection = new ArrayList<PessoaFuncionarios>();
            for (PessoaFuncionarios pessoaFuncionariosCollectionPessoaFuncionariosToAttach : pessoaOperadores.getPessoaFuncionariosCollection()) {
                pessoaFuncionariosCollectionPessoaFuncionariosToAttach = em.getReference(pessoaFuncionariosCollectionPessoaFuncionariosToAttach.getClass(), pessoaFuncionariosCollectionPessoaFuncionariosToAttach.getId());
                attachedPessoaFuncionariosCollection.add(pessoaFuncionariosCollectionPessoaFuncionariosToAttach);
            }
            pessoaOperadores.setPessoaFuncionariosCollection(attachedPessoaFuncionariosCollection);
            Collection<PessoaFuncionarios> attachedPessoaFuncionariosCollection1 = new ArrayList<PessoaFuncionarios>();
            for (PessoaFuncionarios pessoaFuncionariosCollection1PessoaFuncionariosToAttach : pessoaOperadores.getPessoaFuncionariosCollection1()) {
                pessoaFuncionariosCollection1PessoaFuncionariosToAttach = em.getReference(pessoaFuncionariosCollection1PessoaFuncionariosToAttach.getClass(), pessoaFuncionariosCollection1PessoaFuncionariosToAttach.getId());
                attachedPessoaFuncionariosCollection1.add(pessoaFuncionariosCollection1PessoaFuncionariosToAttach);
            }
            pessoaOperadores.setPessoaFuncionariosCollection1(attachedPessoaFuncionariosCollection1);
            Collection<HistFuncionariosUnidadeLotacao> attachedHistFuncionariosUnidadeLotacaoCollection = new ArrayList<HistFuncionariosUnidadeLotacao>();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach : pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection()) {
                histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach = em.getReference(histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach.getClass(), histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach.getId());
                attachedHistFuncionariosUnidadeLotacaoCollection.add(histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach);
            }
            pessoaOperadores.setHistFuncionariosUnidadeLotacaoCollection(attachedHistFuncionariosUnidadeLotacaoCollection);
            Collection<HistFuncionariosUnidadeLotacao> attachedHistFuncionariosUnidadeLotacaoCollection1 = new ArrayList<HistFuncionariosUnidadeLotacao>();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacaoToAttach : pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection1()) {
                histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacaoToAttach = em.getReference(histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacaoToAttach.getClass(), histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacaoToAttach.getId());
                attachedHistFuncionariosUnidadeLotacaoCollection1.add(histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacaoToAttach);
            }
            pessoaOperadores.setHistFuncionariosUnidadeLotacaoCollection1(attachedHistFuncionariosUnidadeLotacaoCollection1);
            Collection<HistFuncionariosUnidadeAtuacao> attachedHistFuncionariosUnidadeAtuacaoCollection = new ArrayList<HistFuncionariosUnidadeAtuacao>();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach : pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection()) {
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach = em.getReference(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach.getClass(), histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach.getId());
                attachedHistFuncionariosUnidadeAtuacaoCollection.add(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach);
            }
            pessoaOperadores.setHistFuncionariosUnidadeAtuacaoCollection(attachedHistFuncionariosUnidadeAtuacaoCollection);
            Collection<HistFuncionariosUnidadeAtuacao> attachedHistFuncionariosUnidadeAtuacaoCollection1 = new ArrayList<HistFuncionariosUnidadeAtuacao>();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacaoToAttach : pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection1()) {
                histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacaoToAttach = em.getReference(histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacaoToAttach.getClass(), histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacaoToAttach.getId());
                attachedHistFuncionariosUnidadeAtuacaoCollection1.add(histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacaoToAttach);
            }
            pessoaOperadores.setHistFuncionariosUnidadeAtuacaoCollection1(attachedHistFuncionariosUnidadeAtuacaoCollection1);
            em.persist(pessoaOperadores);
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaOperadoresCollection().add(pessoaOperadores);
                idPessoaFk = em.merge(idPessoaFk);
            }
            if (seqPrivilegio != null) {
                seqPrivilegio.getPessoaOperadoresCollection().add(pessoaOperadores);
                seqPrivilegio = em.merge(seqPrivilegio);
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao : pessoaOperadores.getHistFuncionariosAutorizacaoCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.getIdOperadorCadastroFk();
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                if (oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                    oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                }
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao : pessoaOperadores.getHistFuncionariosAutorizacaoCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao = histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao.getIdOperadorCancelamentoFk();
                histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao.getHistFuncionariosAutorizacaoCollection1().remove(histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao);
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollectionHistFuncionariosClasse : pessoaOperadores.getHistFuncionariosClasseCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse = histFuncionariosClasseCollectionHistFuncionariosClasse.getIdOperadorCadastroFk();
                histFuncionariosClasseCollectionHistFuncionariosClasse.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosClasseCollectionHistFuncionariosClasse = em.merge(histFuncionariosClasseCollectionHistFuncionariosClasse);
                if (oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse.getHistFuncionariosClasseCollection().remove(histFuncionariosClasseCollectionHistFuncionariosClasse);
                    oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse);
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollection1HistFuncionariosClasse : pessoaOperadores.getHistFuncionariosClasseCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1HistFuncionariosClasse = histFuncionariosClasseCollection1HistFuncionariosClasse.getIdOperadorCancelamentoFk();
                histFuncionariosClasseCollection1HistFuncionariosClasse.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosClasseCollection1HistFuncionariosClasse = em.merge(histFuncionariosClasseCollection1HistFuncionariosClasse);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1HistFuncionariosClasse != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1HistFuncionariosClasse.getHistFuncionariosClasseCollection1().remove(histFuncionariosClasseCollection1HistFuncionariosClasse);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1HistFuncionariosClasse = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1HistFuncionariosClasse);
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria : pessoaOperadores.getHistFuncionariosCargaHorariaCollection()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.getIdOperadorCancelamentoFk();
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria : pessoaOperadores.getHistFuncionariosCargaHorariaCollection1()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria = histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria.getIdOperadorCadastroFk();
                histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria);
                if (oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria.getHistFuncionariosCargaHorariaCollection1().remove(histFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria);
                    oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1HistFuncionariosCargaHoraria);
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollectionHistFuncionariosCargos : pessoaOperadores.getHistFuncionariosCargosCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos = histFuncionariosCargosCollectionHistFuncionariosCargos.getIdOperadorCadastroFk();
                histFuncionariosCargosCollectionHistFuncionariosCargos.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosCargosCollectionHistFuncionariosCargos = em.merge(histFuncionariosCargosCollectionHistFuncionariosCargos);
                if (oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos.getHistFuncionariosCargosCollection().remove(histFuncionariosCargosCollectionHistFuncionariosCargos);
                    oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos);
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollection1HistFuncionariosCargos : pessoaOperadores.getHistFuncionariosCargosCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1HistFuncionariosCargos = histFuncionariosCargosCollection1HistFuncionariosCargos.getIdOperadorCancelamentoFk();
                histFuncionariosCargosCollection1HistFuncionariosCargos.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosCargosCollection1HistFuncionariosCargos = em.merge(histFuncionariosCargosCollection1HistFuncionariosCargos);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1HistFuncionariosCargos != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1HistFuncionariosCargos.getHistFuncionariosCargosCollection1().remove(histFuncionariosCargosCollection1HistFuncionariosCargos);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1HistFuncionariosCargos = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1HistFuncionariosCargos);
                }
            }
            for (PessoaFilhos pessoaFilhosCollectionPessoaFilhos : pessoaOperadores.getPessoaFilhosCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfPessoaFilhosCollectionPessoaFilhos = pessoaFilhosCollectionPessoaFilhos.getIdOperadorCadastroFk();
                pessoaFilhosCollectionPessoaFilhos.setIdOperadorCadastroFk(pessoaOperadores);
                pessoaFilhosCollectionPessoaFilhos = em.merge(pessoaFilhosCollectionPessoaFilhos);
                if (oldIdOperadorCadastroFkOfPessoaFilhosCollectionPessoaFilhos != null) {
                    oldIdOperadorCadastroFkOfPessoaFilhosCollectionPessoaFilhos.getPessoaFilhosCollection().remove(pessoaFilhosCollectionPessoaFilhos);
                    oldIdOperadorCadastroFkOfPessoaFilhosCollectionPessoaFilhos = em.merge(oldIdOperadorCadastroFkOfPessoaFilhosCollectionPessoaFilhos);
                }
            }
            for (PessoaFilhos pessoaFilhosCollection1PessoaFilhos : pessoaOperadores.getPessoaFilhosCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1PessoaFilhos = pessoaFilhosCollection1PessoaFilhos.getIdOperadorCancelamentoFk();
                pessoaFilhosCollection1PessoaFilhos.setIdOperadorCancelamentoFk(pessoaOperadores);
                pessoaFilhosCollection1PessoaFilhos = em.merge(pessoaFilhosCollection1PessoaFilhos);
                if (oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1PessoaFilhos != null) {
                    oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1PessoaFilhos.getPessoaFilhosCollection1().remove(pessoaFilhosCollection1PessoaFilhos);
                    oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1PessoaFilhos = em.merge(oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1PessoaFilhos);
                }
            }
            for (Unidades unidadesCollectionUnidades : pessoaOperadores.getUnidadesCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfUnidadesCollectionUnidades = unidadesCollectionUnidades.getIdOperadorCadastroFk();
                unidadesCollectionUnidades.setIdOperadorCadastroFk(pessoaOperadores);
                unidadesCollectionUnidades = em.merge(unidadesCollectionUnidades);
                if (oldIdOperadorCadastroFkOfUnidadesCollectionUnidades != null) {
                    oldIdOperadorCadastroFkOfUnidadesCollectionUnidades.getUnidadesCollection().remove(unidadesCollectionUnidades);
                    oldIdOperadorCadastroFkOfUnidadesCollectionUnidades = em.merge(oldIdOperadorCadastroFkOfUnidadesCollectionUnidades);
                }
            }
            for (Unidades unidadesCollection1Unidades : pessoaOperadores.getUnidadesCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfUnidadesCollection1Unidades = unidadesCollection1Unidades.getIdOperadorCancelamentoFk();
                unidadesCollection1Unidades.setIdOperadorCancelamentoFk(pessoaOperadores);
                unidadesCollection1Unidades = em.merge(unidadesCollection1Unidades);
                if (oldIdOperadorCancelamentoFkOfUnidadesCollection1Unidades != null) {
                    oldIdOperadorCancelamentoFkOfUnidadesCollection1Unidades.getUnidadesCollection1().remove(unidadesCollection1Unidades);
                    oldIdOperadorCancelamentoFkOfUnidadesCollection1Unidades = em.merge(oldIdOperadorCancelamentoFkOfUnidadesCollection1Unidades);
                }
            }
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica : pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica = histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica.getIdOperadorCadastroFk();
                histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica.setIdOperadorCadastroFk(pessoaOperadores);
                histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica);
                if (oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica != null) {
                    oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica);
                    oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica = em.merge(oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica);
                }
            }
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica : pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica = histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica.getIdOperadorCancelamentoFk();
                histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica.setIdOperadorCancelamentoFk(pessoaOperadores);
                histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica);
                if (oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica != null) {
                    oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection1().remove(histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica);
                    oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica = em.merge(oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica);
                }
            }
            for (HistUnidadesRegime histUnidadesRegimeCollectionHistUnidadesRegime : pessoaOperadores.getHistUnidadesRegimeCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionHistUnidadesRegime = histUnidadesRegimeCollectionHistUnidadesRegime.getIdOperadorCadastroFk();
                histUnidadesRegimeCollectionHistUnidadesRegime.setIdOperadorCadastroFk(pessoaOperadores);
                histUnidadesRegimeCollectionHistUnidadesRegime = em.merge(histUnidadesRegimeCollectionHistUnidadesRegime);
                if (oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionHistUnidadesRegime != null) {
                    oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionHistUnidadesRegime.getHistUnidadesRegimeCollection().remove(histUnidadesRegimeCollectionHistUnidadesRegime);
                    oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionHistUnidadesRegime = em.merge(oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionHistUnidadesRegime);
                }
            }
            for (HistUnidadesRegime histUnidadesRegimeCollection1HistUnidadesRegime : pessoaOperadores.getHistUnidadesRegimeCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1HistUnidadesRegime = histUnidadesRegimeCollection1HistUnidadesRegime.getIdOperadorCancelamentoFk();
                histUnidadesRegimeCollection1HistUnidadesRegime.setIdOperadorCancelamentoFk(pessoaOperadores);
                histUnidadesRegimeCollection1HistUnidadesRegime = em.merge(histUnidadesRegimeCollection1HistUnidadesRegime);
                if (oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1HistUnidadesRegime != null) {
                    oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1HistUnidadesRegime.getHistUnidadesRegimeCollection1().remove(histUnidadesRegimeCollection1HistUnidadesRegime);
                    oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1HistUnidadesRegime = em.merge(oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1HistUnidadesRegime);
                }
            }
            for (Pessoa pessoaCollectionPessoa : pessoaOperadores.getPessoaCollection()) {
                PessoaOperadores oldSeqOperadorCadastroOfPessoaCollectionPessoa = pessoaCollectionPessoa.getSeqOperadorCadastro();
                pessoaCollectionPessoa.setSeqOperadorCadastro(pessoaOperadores);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
                if (oldSeqOperadorCadastroOfPessoaCollectionPessoa != null) {
                    oldSeqOperadorCadastroOfPessoaCollectionPessoa.getPessoaCollection().remove(pessoaCollectionPessoa);
                    oldSeqOperadorCadastroOfPessoaCollectionPessoa = em.merge(oldSeqOperadorCadastroOfPessoaCollectionPessoa);
                }
            }
            for (Pessoa pessoaCollection1Pessoa : pessoaOperadores.getPessoaCollection1()) {
                PessoaOperadores oldSeqOperadorCancelamentoOfPessoaCollection1Pessoa = pessoaCollection1Pessoa.getSeqOperadorCancelamento();
                pessoaCollection1Pessoa.setSeqOperadorCancelamento(pessoaOperadores);
                pessoaCollection1Pessoa = em.merge(pessoaCollection1Pessoa);
                if (oldSeqOperadorCancelamentoOfPessoaCollection1Pessoa != null) {
                    oldSeqOperadorCancelamentoOfPessoaCollection1Pessoa.getPessoaCollection1().remove(pessoaCollection1Pessoa);
                    oldSeqOperadorCancelamentoOfPessoaCollection1Pessoa = em.merge(oldSeqOperadorCancelamentoOfPessoaCollection1Pessoa);
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionHistFuncionariosCarreira : pessoaOperadores.getHistFuncionariosCarreiraCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira = histFuncionariosCarreiraCollectionHistFuncionariosCarreira.getIdOperadorCadastroFk();
                histFuncionariosCarreiraCollectionHistFuncionariosCarreira.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosCarreiraCollectionHistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                if (oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                    oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollection1HistFuncionariosCarreira : pessoaOperadores.getHistFuncionariosCarreiraCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1HistFuncionariosCarreira = histFuncionariosCarreiraCollection1HistFuncionariosCarreira.getIdOperadorCancelamentoFk();
                histFuncionariosCarreiraCollection1HistFuncionariosCarreira.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosCarreiraCollection1HistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollection1HistFuncionariosCarreira);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1HistFuncionariosCarreira != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1HistFuncionariosCarreira.getHistFuncionariosCarreiraCollection1().remove(histFuncionariosCarreiraCollection1HistFuncionariosCarreira);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1HistFuncionariosCarreira = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1HistFuncionariosCarreira);
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionHistFuncionariosSituacoes : pessoaOperadores.getHistFuncionariosSituacoesCollection()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes = histFuncionariosSituacoesCollectionHistFuncionariosSituacoes.getIdOperadorCancelamentoFk();
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoes.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollection1HistFuncionariosSituacoes : pessoaOperadores.getHistFuncionariosSituacoesCollection1()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1HistFuncionariosSituacoes = histFuncionariosSituacoesCollection1HistFuncionariosSituacoes.getIdOperadorCadastroFk();
                histFuncionariosSituacoesCollection1HistFuncionariosSituacoes.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosSituacoesCollection1HistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollection1HistFuncionariosSituacoes);
                if (oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1HistFuncionariosSituacoes != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1HistFuncionariosSituacoes.getHistFuncionariosSituacoesCollection1().remove(histFuncionariosSituacoesCollection1HistFuncionariosSituacoes);
                    oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1HistFuncionariosSituacoes = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1HistFuncionariosSituacoes);
                }
            }
            for (Autorizacoes autorizacoesCollectionAutorizacoes : pessoaOperadores.getAutorizacoesCollection()) {
                PessoaOperadores oldIdOperadorCriacaoFkOfAutorizacoesCollectionAutorizacoes = autorizacoesCollectionAutorizacoes.getIdOperadorCriacaoFk();
                autorizacoesCollectionAutorizacoes.setIdOperadorCriacaoFk(pessoaOperadores);
                autorizacoesCollectionAutorizacoes = em.merge(autorizacoesCollectionAutorizacoes);
                if (oldIdOperadorCriacaoFkOfAutorizacoesCollectionAutorizacoes != null) {
                    oldIdOperadorCriacaoFkOfAutorizacoesCollectionAutorizacoes.getAutorizacoesCollection().remove(autorizacoesCollectionAutorizacoes);
                    oldIdOperadorCriacaoFkOfAutorizacoesCollectionAutorizacoes = em.merge(oldIdOperadorCriacaoFkOfAutorizacoesCollectionAutorizacoes);
                }
            }
            for (PessoaBancos pessoaBancosCollectionPessoaBancos : pessoaOperadores.getPessoaBancosCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfPessoaBancosCollectionPessoaBancos = pessoaBancosCollectionPessoaBancos.getIdOperadorCadastroFk();
                pessoaBancosCollectionPessoaBancos.setIdOperadorCadastroFk(pessoaOperadores);
                pessoaBancosCollectionPessoaBancos = em.merge(pessoaBancosCollectionPessoaBancos);
                if (oldIdOperadorCadastroFkOfPessoaBancosCollectionPessoaBancos != null) {
                    oldIdOperadorCadastroFkOfPessoaBancosCollectionPessoaBancos.getPessoaBancosCollection().remove(pessoaBancosCollectionPessoaBancos);
                    oldIdOperadorCadastroFkOfPessoaBancosCollectionPessoaBancos = em.merge(oldIdOperadorCadastroFkOfPessoaBancosCollectionPessoaBancos);
                }
            }
            for (PessoaBancos pessoaBancosCollection1PessoaBancos : pessoaOperadores.getPessoaBancosCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfPessoaBancosCollection1PessoaBancos = pessoaBancosCollection1PessoaBancos.getIdOperadorCancelamentoFk();
                pessoaBancosCollection1PessoaBancos.setIdOperadorCancelamentoFk(pessoaOperadores);
                pessoaBancosCollection1PessoaBancos = em.merge(pessoaBancosCollection1PessoaBancos);
                if (oldIdOperadorCancelamentoFkOfPessoaBancosCollection1PessoaBancos != null) {
                    oldIdOperadorCancelamentoFkOfPessoaBancosCollection1PessoaBancos.getPessoaBancosCollection1().remove(pessoaBancosCollection1PessoaBancos);
                    oldIdOperadorCancelamentoFkOfPessoaBancosCollection1PessoaBancos = em.merge(oldIdOperadorCancelamentoFkOfPessoaBancosCollection1PessoaBancos);
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionHistFuncionariosVinculos : pessoaOperadores.getHistFuncionariosVinculosCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos = histFuncionariosVinculosCollectionHistFuncionariosVinculos.getIdOperadorCadastroFk();
                histFuncionariosVinculosCollectionHistFuncionariosVinculos.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosVinculosCollectionHistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollectionHistFuncionariosVinculos);
                if (oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculosCollectionHistFuncionariosVinculos);
                    oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos);
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollection1HistFuncionariosVinculos : pessoaOperadores.getHistFuncionariosVinculosCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1HistFuncionariosVinculos = histFuncionariosVinculosCollection1HistFuncionariosVinculos.getIdOperadorCancelamentoFk();
                histFuncionariosVinculosCollection1HistFuncionariosVinculos.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosVinculosCollection1HistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollection1HistFuncionariosVinculos);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1HistFuncionariosVinculos != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1HistFuncionariosVinculos.getHistFuncionariosVinculosCollection1().remove(histFuncionariosVinculosCollection1HistFuncionariosVinculos);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1HistFuncionariosVinculos = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1HistFuncionariosVinculos);
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionHistUnidadesDiretor : pessoaOperadores.getHistUnidadesDiretorCollection()) {
                PessoaOperadores oldPessoaOperadoresOfHistUnidadesDiretorCollectionHistUnidadesDiretor = histUnidadesDiretorCollectionHistUnidadesDiretor.getPessoaOperadores();
                histUnidadesDiretorCollectionHistUnidadesDiretor.setPessoaOperadores(pessoaOperadores);
                histUnidadesDiretorCollectionHistUnidadesDiretor = em.merge(histUnidadesDiretorCollectionHistUnidadesDiretor);
                if (oldPessoaOperadoresOfHistUnidadesDiretorCollectionHistUnidadesDiretor != null) {
                    oldPessoaOperadoresOfHistUnidadesDiretorCollectionHistUnidadesDiretor.getHistUnidadesDiretorCollection().remove(histUnidadesDiretorCollectionHistUnidadesDiretor);
                    oldPessoaOperadoresOfHistUnidadesDiretorCollectionHistUnidadesDiretor = em.merge(oldPessoaOperadoresOfHistUnidadesDiretorCollectionHistUnidadesDiretor);
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollection1HistUnidadesDiretor : pessoaOperadores.getHistUnidadesDiretorCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1HistUnidadesDiretor = histUnidadesDiretorCollection1HistUnidadesDiretor.getIdOperadorCancelamentoFk();
                histUnidadesDiretorCollection1HistUnidadesDiretor.setIdOperadorCancelamentoFk(pessoaOperadores);
                histUnidadesDiretorCollection1HistUnidadesDiretor = em.merge(histUnidadesDiretorCollection1HistUnidadesDiretor);
                if (oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1HistUnidadesDiretor != null) {
                    oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1HistUnidadesDiretor.getHistUnidadesDiretorCollection1().remove(histUnidadesDiretorCollection1HistUnidadesDiretor);
                    oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1HistUnidadesDiretor = em.merge(oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1HistUnidadesDiretor);
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollectionPessoaFuncionarios : pessoaOperadores.getPessoaFuncionariosCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionPessoaFuncionarios = pessoaFuncionariosCollectionPessoaFuncionarios.getIdOperadorCadastroFk();
                pessoaFuncionariosCollectionPessoaFuncionarios.setIdOperadorCadastroFk(pessoaOperadores);
                pessoaFuncionariosCollectionPessoaFuncionarios = em.merge(pessoaFuncionariosCollectionPessoaFuncionarios);
                if (oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionPessoaFuncionarios != null) {
                    oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionPessoaFuncionarios.getPessoaFuncionariosCollection().remove(pessoaFuncionariosCollectionPessoaFuncionarios);
                    oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionPessoaFuncionarios = em.merge(oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionPessoaFuncionarios);
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollection1PessoaFuncionarios : pessoaOperadores.getPessoaFuncionariosCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1PessoaFuncionarios = pessoaFuncionariosCollection1PessoaFuncionarios.getIdOperadorCancelamentoFk();
                pessoaFuncionariosCollection1PessoaFuncionarios.setIdOperadorCancelamentoFk(pessoaOperadores);
                pessoaFuncionariosCollection1PessoaFuncionarios = em.merge(pessoaFuncionariosCollection1PessoaFuncionarios);
                if (oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1PessoaFuncionarios != null) {
                    oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1PessoaFuncionarios.getPessoaFuncionariosCollection1().remove(pessoaFuncionariosCollection1PessoaFuncionarios);
                    oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1PessoaFuncionarios = em.merge(oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1PessoaFuncionarios);
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao : pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao = histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao.getIdOperadorCadastroFk();
                histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao);
                if (oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao);
                    oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao);
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao : pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao = histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao.getIdOperadorCancelamentoFk();
                histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao.getHistFuncionariosUnidadeLotacaoCollection1().remove(histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao);
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao : pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection()) {
                PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.getIdOperadorCadastroFk();
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.setIdOperadorCadastroFk(pessoaOperadores);
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                if (oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao != null) {
                    oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                    oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao : pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection1()) {
                PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao = histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao.getIdOperadorCancelamentoFk();
                histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao.setIdOperadorCancelamentoFk(pessoaOperadores);
                histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao);
                if (oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao != null) {
                    oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao.getHistFuncionariosUnidadeAtuacaoCollection1().remove(histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao);
                    oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaOperadores pessoaOperadores) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaOperadores persistentPessoaOperadores = em.find(PessoaOperadores.class, pessoaOperadores.getId());
            Pessoa idPessoaFkOld = persistentPessoaOperadores.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaOperadores.getIdPessoaFk();
            Privilegios seqPrivilegioOld = persistentPessoaOperadores.getSeqPrivilegio();
            Privilegios seqPrivilegioNew = pessoaOperadores.getSeqPrivilegio();
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionOld = persistentPessoaOperadores.getHistFuncionariosAutorizacaoCollection();
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionNew = pessoaOperadores.getHistFuncionariosAutorizacaoCollection();
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection1Old = persistentPessoaOperadores.getHistFuncionariosAutorizacaoCollection1();
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection1New = pessoaOperadores.getHistFuncionariosAutorizacaoCollection1();
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionOld = persistentPessoaOperadores.getHistFuncionariosClasseCollection();
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionNew = pessoaOperadores.getHistFuncionariosClasseCollection();
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollection1Old = persistentPessoaOperadores.getHistFuncionariosClasseCollection1();
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollection1New = pessoaOperadores.getHistFuncionariosClasseCollection1();
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollectionOld = persistentPessoaOperadores.getHistFuncionariosCargaHorariaCollection();
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollectionNew = pessoaOperadores.getHistFuncionariosCargaHorariaCollection();
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection1Old = persistentPessoaOperadores.getHistFuncionariosCargaHorariaCollection1();
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection1New = pessoaOperadores.getHistFuncionariosCargaHorariaCollection1();
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionOld = persistentPessoaOperadores.getHistFuncionariosCargosCollection();
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionNew = pessoaOperadores.getHistFuncionariosCargosCollection();
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollection1Old = persistentPessoaOperadores.getHistFuncionariosCargosCollection1();
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollection1New = pessoaOperadores.getHistFuncionariosCargosCollection1();
            Collection<PessoaFilhos> pessoaFilhosCollectionOld = persistentPessoaOperadores.getPessoaFilhosCollection();
            Collection<PessoaFilhos> pessoaFilhosCollectionNew = pessoaOperadores.getPessoaFilhosCollection();
            Collection<PessoaFilhos> pessoaFilhosCollection1Old = persistentPessoaOperadores.getPessoaFilhosCollection1();
            Collection<PessoaFilhos> pessoaFilhosCollection1New = pessoaOperadores.getPessoaFilhosCollection1();
            Collection<Unidades> unidadesCollectionOld = persistentPessoaOperadores.getUnidadesCollection();
            Collection<Unidades> unidadesCollectionNew = pessoaOperadores.getUnidadesCollection();
            Collection<Unidades> unidadesCollection1Old = persistentPessoaOperadores.getUnidadesCollection1();
            Collection<Unidades> unidadesCollection1New = pessoaOperadores.getUnidadesCollection1();
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollectionOld = persistentPessoaOperadores.getHistUnidadesNaturezaJuridicaCollection();
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollectionNew = pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection();
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection1Old = persistentPessoaOperadores.getHistUnidadesNaturezaJuridicaCollection1();
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection1New = pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection1();
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionOld = persistentPessoaOperadores.getHistUnidadesRegimeCollection();
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionNew = pessoaOperadores.getHistUnidadesRegimeCollection();
            Collection<HistUnidadesRegime> histUnidadesRegimeCollection1Old = persistentPessoaOperadores.getHistUnidadesRegimeCollection1();
            Collection<HistUnidadesRegime> histUnidadesRegimeCollection1New = pessoaOperadores.getHistUnidadesRegimeCollection1();
            Collection<Pessoa> pessoaCollectionOld = persistentPessoaOperadores.getPessoaCollection();
            Collection<Pessoa> pessoaCollectionNew = pessoaOperadores.getPessoaCollection();
            Collection<Pessoa> pessoaCollection1Old = persistentPessoaOperadores.getPessoaCollection1();
            Collection<Pessoa> pessoaCollection1New = pessoaOperadores.getPessoaCollection1();
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionOld = persistentPessoaOperadores.getHistFuncionariosCarreiraCollection();
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionNew = pessoaOperadores.getHistFuncionariosCarreiraCollection();
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection1Old = persistentPessoaOperadores.getHistFuncionariosCarreiraCollection1();
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection1New = pessoaOperadores.getHistFuncionariosCarreiraCollection1();
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollectionOld = persistentPessoaOperadores.getHistFuncionariosSituacoesCollection();
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollectionNew = pessoaOperadores.getHistFuncionariosSituacoesCollection();
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection1Old = persistentPessoaOperadores.getHistFuncionariosSituacoesCollection1();
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection1New = pessoaOperadores.getHistFuncionariosSituacoesCollection1();
            Collection<Autorizacoes> autorizacoesCollectionOld = persistentPessoaOperadores.getAutorizacoesCollection();
            Collection<Autorizacoes> autorizacoesCollectionNew = pessoaOperadores.getAutorizacoesCollection();
            Collection<PessoaBancos> pessoaBancosCollectionOld = persistentPessoaOperadores.getPessoaBancosCollection();
            Collection<PessoaBancos> pessoaBancosCollectionNew = pessoaOperadores.getPessoaBancosCollection();
            Collection<PessoaBancos> pessoaBancosCollection1Old = persistentPessoaOperadores.getPessoaBancosCollection1();
            Collection<PessoaBancos> pessoaBancosCollection1New = pessoaOperadores.getPessoaBancosCollection1();
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionOld = persistentPessoaOperadores.getHistFuncionariosVinculosCollection();
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionNew = pessoaOperadores.getHistFuncionariosVinculosCollection();
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection1Old = persistentPessoaOperadores.getHistFuncionariosVinculosCollection1();
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection1New = pessoaOperadores.getHistFuncionariosVinculosCollection1();
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionOld = persistentPessoaOperadores.getHistUnidadesDiretorCollection();
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionNew = pessoaOperadores.getHistUnidadesDiretorCollection();
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollection1Old = persistentPessoaOperadores.getHistUnidadesDiretorCollection1();
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollection1New = pessoaOperadores.getHistUnidadesDiretorCollection1();
            Collection<PessoaFuncionarios> pessoaFuncionariosCollectionOld = persistentPessoaOperadores.getPessoaFuncionariosCollection();
            Collection<PessoaFuncionarios> pessoaFuncionariosCollectionNew = pessoaOperadores.getPessoaFuncionariosCollection();
            Collection<PessoaFuncionarios> pessoaFuncionariosCollection1Old = persistentPessoaOperadores.getPessoaFuncionariosCollection1();
            Collection<PessoaFuncionarios> pessoaFuncionariosCollection1New = pessoaOperadores.getPessoaFuncionariosCollection1();
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollectionOld = persistentPessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection();
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollectionNew = pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection();
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection1Old = persistentPessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection1();
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection1New = pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection1();
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionOld = persistentPessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection();
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionNew = pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection();
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection1Old = persistentPessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection1();
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection1New = pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection1();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionOld) {
                if (!histFuncionariosAutorizacaoCollectionNew.contains(histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosAutorizacao " + histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollectionOldHistFuncionariosClasse : histFuncionariosClasseCollectionOld) {
                if (!histFuncionariosClasseCollectionNew.contains(histFuncionariosClasseCollectionOldHistFuncionariosClasse)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosClasse " + histFuncionariosClasseCollectionOldHistFuncionariosClasse + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollection1OldHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollection1Old) {
                if (!histFuncionariosCargaHorariaCollection1New.contains(histFuncionariosCargaHorariaCollection1OldHistFuncionariosCargaHoraria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCargaHoraria " + histFuncionariosCargaHorariaCollection1OldHistFuncionariosCargaHoraria + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollectionOldHistFuncionariosCargos : histFuncionariosCargosCollectionOld) {
                if (!histFuncionariosCargosCollectionNew.contains(histFuncionariosCargosCollectionOldHistFuncionariosCargos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCargos " + histFuncionariosCargosCollectionOldHistFuncionariosCargos + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionOldHistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollectionOld) {
                if (!histUnidadesNaturezaJuridicaCollectionNew.contains(histUnidadesNaturezaJuridicaCollectionOldHistUnidadesNaturezaJuridica)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistUnidadesNaturezaJuridica " + histUnidadesNaturezaJuridicaCollectionOldHistUnidadesNaturezaJuridica + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistUnidadesRegime histUnidadesRegimeCollectionOldHistUnidadesRegime : histUnidadesRegimeCollectionOld) {
                if (!histUnidadesRegimeCollectionNew.contains(histUnidadesRegimeCollectionOldHistUnidadesRegime)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistUnidadesRegime " + histUnidadesRegimeCollectionOldHistUnidadesRegime + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira : histFuncionariosCarreiraCollectionOld) {
                if (!histFuncionariosCarreiraCollectionNew.contains(histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCarreira " + histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollection1OldHistFuncionariosSituacoes : histFuncionariosSituacoesCollection1Old) {
                if (!histFuncionariosSituacoesCollection1New.contains(histFuncionariosSituacoesCollection1OldHistFuncionariosSituacoes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosSituacoes " + histFuncionariosSituacoesCollection1OldHistFuncionariosSituacoes + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (Autorizacoes autorizacoesCollectionOldAutorizacoes : autorizacoesCollectionOld) {
                if (!autorizacoesCollectionNew.contains(autorizacoesCollectionOldAutorizacoes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Autorizacoes " + autorizacoesCollectionOldAutorizacoes + " since its idOperadorCriacaoFk field is not nullable.");
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionOldHistFuncionariosVinculos : histFuncionariosVinculosCollectionOld) {
                if (!histFuncionariosVinculosCollectionNew.contains(histFuncionariosVinculosCollectionOldHistFuncionariosVinculos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosVinculos " + histFuncionariosVinculosCollectionOldHistFuncionariosVinculos + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionOldHistUnidadesDiretor : histUnidadesDiretorCollectionOld) {
                if (!histUnidadesDiretorCollectionNew.contains(histUnidadesDiretorCollectionOldHistUnidadesDiretor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistUnidadesDiretor " + histUnidadesDiretorCollectionOldHistUnidadesDiretor + " since its pessoaOperadores field is not nullable.");
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionOldHistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollectionOld) {
                if (!histFuncionariosUnidadeLotacaoCollectionNew.contains(histFuncionariosUnidadeLotacaoCollectionOldHistFuncionariosUnidadeLotacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosUnidadeLotacao " + histFuncionariosUnidadeLotacaoCollectionOldHistFuncionariosUnidadeLotacao + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionOld) {
                if (!histFuncionariosUnidadeAtuacaoCollectionNew.contains(histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosUnidadeAtuacao " + histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao + " since its idOperadorCadastroFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaOperadores.setIdPessoaFk(idPessoaFkNew);
            }
            if (seqPrivilegioNew != null) {
                seqPrivilegioNew = em.getReference(seqPrivilegioNew.getClass(), seqPrivilegioNew.getId());
                pessoaOperadores.setSeqPrivilegio(seqPrivilegioNew);
            }
            Collection<HistFuncionariosAutorizacao> attachedHistFuncionariosAutorizacaoCollectionNew = new ArrayList<HistFuncionariosAutorizacao>();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach : histFuncionariosAutorizacaoCollectionNew) {
                histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach = em.getReference(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach.getClass(), histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach.getId());
                attachedHistFuncionariosAutorizacaoCollectionNew.add(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach);
            }
            histFuncionariosAutorizacaoCollectionNew = attachedHistFuncionariosAutorizacaoCollectionNew;
            pessoaOperadores.setHistFuncionariosAutorizacaoCollection(histFuncionariosAutorizacaoCollectionNew);
            Collection<HistFuncionariosAutorizacao> attachedHistFuncionariosAutorizacaoCollection1New = new ArrayList<HistFuncionariosAutorizacao>();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacaoToAttach : histFuncionariosAutorizacaoCollection1New) {
                histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacaoToAttach = em.getReference(histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacaoToAttach.getClass(), histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacaoToAttach.getId());
                attachedHistFuncionariosAutorizacaoCollection1New.add(histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacaoToAttach);
            }
            histFuncionariosAutorizacaoCollection1New = attachedHistFuncionariosAutorizacaoCollection1New;
            pessoaOperadores.setHistFuncionariosAutorizacaoCollection1(histFuncionariosAutorizacaoCollection1New);
            Collection<HistFuncionariosClasse> attachedHistFuncionariosClasseCollectionNew = new ArrayList<HistFuncionariosClasse>();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach : histFuncionariosClasseCollectionNew) {
                histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach = em.getReference(histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach.getClass(), histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach.getId());
                attachedHistFuncionariosClasseCollectionNew.add(histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach);
            }
            histFuncionariosClasseCollectionNew = attachedHistFuncionariosClasseCollectionNew;
            pessoaOperadores.setHistFuncionariosClasseCollection(histFuncionariosClasseCollectionNew);
            Collection<HistFuncionariosClasse> attachedHistFuncionariosClasseCollection1New = new ArrayList<HistFuncionariosClasse>();
            for (HistFuncionariosClasse histFuncionariosClasseCollection1NewHistFuncionariosClasseToAttach : histFuncionariosClasseCollection1New) {
                histFuncionariosClasseCollection1NewHistFuncionariosClasseToAttach = em.getReference(histFuncionariosClasseCollection1NewHistFuncionariosClasseToAttach.getClass(), histFuncionariosClasseCollection1NewHistFuncionariosClasseToAttach.getId());
                attachedHistFuncionariosClasseCollection1New.add(histFuncionariosClasseCollection1NewHistFuncionariosClasseToAttach);
            }
            histFuncionariosClasseCollection1New = attachedHistFuncionariosClasseCollection1New;
            pessoaOperadores.setHistFuncionariosClasseCollection1(histFuncionariosClasseCollection1New);
            Collection<HistFuncionariosCargaHoraria> attachedHistFuncionariosCargaHorariaCollectionNew = new ArrayList<HistFuncionariosCargaHoraria>();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach : histFuncionariosCargaHorariaCollectionNew) {
                histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach = em.getReference(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach.getClass(), histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach.getId());
                attachedHistFuncionariosCargaHorariaCollectionNew.add(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach);
            }
            histFuncionariosCargaHorariaCollectionNew = attachedHistFuncionariosCargaHorariaCollectionNew;
            pessoaOperadores.setHistFuncionariosCargaHorariaCollection(histFuncionariosCargaHorariaCollectionNew);
            Collection<HistFuncionariosCargaHoraria> attachedHistFuncionariosCargaHorariaCollection1New = new ArrayList<HistFuncionariosCargaHoraria>();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHorariaToAttach : histFuncionariosCargaHorariaCollection1New) {
                histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHorariaToAttach = em.getReference(histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHorariaToAttach.getClass(), histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHorariaToAttach.getId());
                attachedHistFuncionariosCargaHorariaCollection1New.add(histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHorariaToAttach);
            }
            histFuncionariosCargaHorariaCollection1New = attachedHistFuncionariosCargaHorariaCollection1New;
            pessoaOperadores.setHistFuncionariosCargaHorariaCollection1(histFuncionariosCargaHorariaCollection1New);
            Collection<HistFuncionariosCargos> attachedHistFuncionariosCargosCollectionNew = new ArrayList<HistFuncionariosCargos>();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach : histFuncionariosCargosCollectionNew) {
                histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach = em.getReference(histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach.getClass(), histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach.getId());
                attachedHistFuncionariosCargosCollectionNew.add(histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach);
            }
            histFuncionariosCargosCollectionNew = attachedHistFuncionariosCargosCollectionNew;
            pessoaOperadores.setHistFuncionariosCargosCollection(histFuncionariosCargosCollectionNew);
            Collection<HistFuncionariosCargos> attachedHistFuncionariosCargosCollection1New = new ArrayList<HistFuncionariosCargos>();
            for (HistFuncionariosCargos histFuncionariosCargosCollection1NewHistFuncionariosCargosToAttach : histFuncionariosCargosCollection1New) {
                histFuncionariosCargosCollection1NewHistFuncionariosCargosToAttach = em.getReference(histFuncionariosCargosCollection1NewHistFuncionariosCargosToAttach.getClass(), histFuncionariosCargosCollection1NewHistFuncionariosCargosToAttach.getId());
                attachedHistFuncionariosCargosCollection1New.add(histFuncionariosCargosCollection1NewHistFuncionariosCargosToAttach);
            }
            histFuncionariosCargosCollection1New = attachedHistFuncionariosCargosCollection1New;
            pessoaOperadores.setHistFuncionariosCargosCollection1(histFuncionariosCargosCollection1New);
            Collection<PessoaFilhos> attachedPessoaFilhosCollectionNew = new ArrayList<PessoaFilhos>();
            for (PessoaFilhos pessoaFilhosCollectionNewPessoaFilhosToAttach : pessoaFilhosCollectionNew) {
                pessoaFilhosCollectionNewPessoaFilhosToAttach = em.getReference(pessoaFilhosCollectionNewPessoaFilhosToAttach.getClass(), pessoaFilhosCollectionNewPessoaFilhosToAttach.getId());
                attachedPessoaFilhosCollectionNew.add(pessoaFilhosCollectionNewPessoaFilhosToAttach);
            }
            pessoaFilhosCollectionNew = attachedPessoaFilhosCollectionNew;
            pessoaOperadores.setPessoaFilhosCollection(pessoaFilhosCollectionNew);
            Collection<PessoaFilhos> attachedPessoaFilhosCollection1New = new ArrayList<PessoaFilhos>();
            for (PessoaFilhos pessoaFilhosCollection1NewPessoaFilhosToAttach : pessoaFilhosCollection1New) {
                pessoaFilhosCollection1NewPessoaFilhosToAttach = em.getReference(pessoaFilhosCollection1NewPessoaFilhosToAttach.getClass(), pessoaFilhosCollection1NewPessoaFilhosToAttach.getId());
                attachedPessoaFilhosCollection1New.add(pessoaFilhosCollection1NewPessoaFilhosToAttach);
            }
            pessoaFilhosCollection1New = attachedPessoaFilhosCollection1New;
            pessoaOperadores.setPessoaFilhosCollection1(pessoaFilhosCollection1New);
            Collection<Unidades> attachedUnidadesCollectionNew = new ArrayList<Unidades>();
            for (Unidades unidadesCollectionNewUnidadesToAttach : unidadesCollectionNew) {
                unidadesCollectionNewUnidadesToAttach = em.getReference(unidadesCollectionNewUnidadesToAttach.getClass(), unidadesCollectionNewUnidadesToAttach.getId());
                attachedUnidadesCollectionNew.add(unidadesCollectionNewUnidadesToAttach);
            }
            unidadesCollectionNew = attachedUnidadesCollectionNew;
            pessoaOperadores.setUnidadesCollection(unidadesCollectionNew);
            Collection<Unidades> attachedUnidadesCollection1New = new ArrayList<Unidades>();
            for (Unidades unidadesCollection1NewUnidadesToAttach : unidadesCollection1New) {
                unidadesCollection1NewUnidadesToAttach = em.getReference(unidadesCollection1NewUnidadesToAttach.getClass(), unidadesCollection1NewUnidadesToAttach.getId());
                attachedUnidadesCollection1New.add(unidadesCollection1NewUnidadesToAttach);
            }
            unidadesCollection1New = attachedUnidadesCollection1New;
            pessoaOperadores.setUnidadesCollection1(unidadesCollection1New);
            Collection<HistUnidadesNaturezaJuridica> attachedHistUnidadesNaturezaJuridicaCollectionNew = new ArrayList<HistUnidadesNaturezaJuridica>();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach : histUnidadesNaturezaJuridicaCollectionNew) {
                histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach = em.getReference(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach.getClass(), histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach.getId());
                attachedHistUnidadesNaturezaJuridicaCollectionNew.add(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach);
            }
            histUnidadesNaturezaJuridicaCollectionNew = attachedHistUnidadesNaturezaJuridicaCollectionNew;
            pessoaOperadores.setHistUnidadesNaturezaJuridicaCollection(histUnidadesNaturezaJuridicaCollectionNew);
            Collection<HistUnidadesNaturezaJuridica> attachedHistUnidadesNaturezaJuridicaCollection1New = new ArrayList<HistUnidadesNaturezaJuridica>();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridicaToAttach : histUnidadesNaturezaJuridicaCollection1New) {
                histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridicaToAttach = em.getReference(histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridicaToAttach.getClass(), histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridicaToAttach.getId());
                attachedHistUnidadesNaturezaJuridicaCollection1New.add(histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridicaToAttach);
            }
            histUnidadesNaturezaJuridicaCollection1New = attachedHistUnidadesNaturezaJuridicaCollection1New;
            pessoaOperadores.setHistUnidadesNaturezaJuridicaCollection1(histUnidadesNaturezaJuridicaCollection1New);
            Collection<HistUnidadesRegime> attachedHistUnidadesRegimeCollectionNew = new ArrayList<HistUnidadesRegime>();
            for (HistUnidadesRegime histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach : histUnidadesRegimeCollectionNew) {
                histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach = em.getReference(histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach.getClass(), histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach.getId());
                attachedHistUnidadesRegimeCollectionNew.add(histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach);
            }
            histUnidadesRegimeCollectionNew = attachedHistUnidadesRegimeCollectionNew;
            pessoaOperadores.setHistUnidadesRegimeCollection(histUnidadesRegimeCollectionNew);
            Collection<HistUnidadesRegime> attachedHistUnidadesRegimeCollection1New = new ArrayList<HistUnidadesRegime>();
            for (HistUnidadesRegime histUnidadesRegimeCollection1NewHistUnidadesRegimeToAttach : histUnidadesRegimeCollection1New) {
                histUnidadesRegimeCollection1NewHistUnidadesRegimeToAttach = em.getReference(histUnidadesRegimeCollection1NewHistUnidadesRegimeToAttach.getClass(), histUnidadesRegimeCollection1NewHistUnidadesRegimeToAttach.getId());
                attachedHistUnidadesRegimeCollection1New.add(histUnidadesRegimeCollection1NewHistUnidadesRegimeToAttach);
            }
            histUnidadesRegimeCollection1New = attachedHistUnidadesRegimeCollection1New;
            pessoaOperadores.setHistUnidadesRegimeCollection1(histUnidadesRegimeCollection1New);
            Collection<Pessoa> attachedPessoaCollectionNew = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionNewPessoaToAttach : pessoaCollectionNew) {
                pessoaCollectionNewPessoaToAttach = em.getReference(pessoaCollectionNewPessoaToAttach.getClass(), pessoaCollectionNewPessoaToAttach.getId());
                attachedPessoaCollectionNew.add(pessoaCollectionNewPessoaToAttach);
            }
            pessoaCollectionNew = attachedPessoaCollectionNew;
            pessoaOperadores.setPessoaCollection(pessoaCollectionNew);
            Collection<Pessoa> attachedPessoaCollection1New = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollection1NewPessoaToAttach : pessoaCollection1New) {
                pessoaCollection1NewPessoaToAttach = em.getReference(pessoaCollection1NewPessoaToAttach.getClass(), pessoaCollection1NewPessoaToAttach.getId());
                attachedPessoaCollection1New.add(pessoaCollection1NewPessoaToAttach);
            }
            pessoaCollection1New = attachedPessoaCollection1New;
            pessoaOperadores.setPessoaCollection1(pessoaCollection1New);
            Collection<HistFuncionariosCarreira> attachedHistFuncionariosCarreiraCollectionNew = new ArrayList<HistFuncionariosCarreira>();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach : histFuncionariosCarreiraCollectionNew) {
                histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach = em.getReference(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach.getClass(), histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach.getId());
                attachedHistFuncionariosCarreiraCollectionNew.add(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach);
            }
            histFuncionariosCarreiraCollectionNew = attachedHistFuncionariosCarreiraCollectionNew;
            pessoaOperadores.setHistFuncionariosCarreiraCollection(histFuncionariosCarreiraCollectionNew);
            Collection<HistFuncionariosCarreira> attachedHistFuncionariosCarreiraCollection1New = new ArrayList<HistFuncionariosCarreira>();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollection1NewHistFuncionariosCarreiraToAttach : histFuncionariosCarreiraCollection1New) {
                histFuncionariosCarreiraCollection1NewHistFuncionariosCarreiraToAttach = em.getReference(histFuncionariosCarreiraCollection1NewHistFuncionariosCarreiraToAttach.getClass(), histFuncionariosCarreiraCollection1NewHistFuncionariosCarreiraToAttach.getId());
                attachedHistFuncionariosCarreiraCollection1New.add(histFuncionariosCarreiraCollection1NewHistFuncionariosCarreiraToAttach);
            }
            histFuncionariosCarreiraCollection1New = attachedHistFuncionariosCarreiraCollection1New;
            pessoaOperadores.setHistFuncionariosCarreiraCollection1(histFuncionariosCarreiraCollection1New);
            Collection<HistFuncionariosSituacoes> attachedHistFuncionariosSituacoesCollectionNew = new ArrayList<HistFuncionariosSituacoes>();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach : histFuncionariosSituacoesCollectionNew) {
                histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach = em.getReference(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach.getClass(), histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach.getId());
                attachedHistFuncionariosSituacoesCollectionNew.add(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach);
            }
            histFuncionariosSituacoesCollectionNew = attachedHistFuncionariosSituacoesCollectionNew;
            pessoaOperadores.setHistFuncionariosSituacoesCollection(histFuncionariosSituacoesCollectionNew);
            Collection<HistFuncionariosSituacoes> attachedHistFuncionariosSituacoesCollection1New = new ArrayList<HistFuncionariosSituacoes>();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoesToAttach : histFuncionariosSituacoesCollection1New) {
                histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoesToAttach = em.getReference(histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoesToAttach.getClass(), histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoesToAttach.getId());
                attachedHistFuncionariosSituacoesCollection1New.add(histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoesToAttach);
            }
            histFuncionariosSituacoesCollection1New = attachedHistFuncionariosSituacoesCollection1New;
            pessoaOperadores.setHistFuncionariosSituacoesCollection1(histFuncionariosSituacoesCollection1New);
            Collection<Autorizacoes> attachedAutorizacoesCollectionNew = new ArrayList<Autorizacoes>();
            for (Autorizacoes autorizacoesCollectionNewAutorizacoesToAttach : autorizacoesCollectionNew) {
                autorizacoesCollectionNewAutorizacoesToAttach = em.getReference(autorizacoesCollectionNewAutorizacoesToAttach.getClass(), autorizacoesCollectionNewAutorizacoesToAttach.getId());
                attachedAutorizacoesCollectionNew.add(autorizacoesCollectionNewAutorizacoesToAttach);
            }
            autorizacoesCollectionNew = attachedAutorizacoesCollectionNew;
            pessoaOperadores.setAutorizacoesCollection(autorizacoesCollectionNew);
            Collection<PessoaBancos> attachedPessoaBancosCollectionNew = new ArrayList<PessoaBancos>();
            for (PessoaBancos pessoaBancosCollectionNewPessoaBancosToAttach : pessoaBancosCollectionNew) {
                pessoaBancosCollectionNewPessoaBancosToAttach = em.getReference(pessoaBancosCollectionNewPessoaBancosToAttach.getClass(), pessoaBancosCollectionNewPessoaBancosToAttach.getId());
                attachedPessoaBancosCollectionNew.add(pessoaBancosCollectionNewPessoaBancosToAttach);
            }
            pessoaBancosCollectionNew = attachedPessoaBancosCollectionNew;
            pessoaOperadores.setPessoaBancosCollection(pessoaBancosCollectionNew);
            Collection<PessoaBancos> attachedPessoaBancosCollection1New = new ArrayList<PessoaBancos>();
            for (PessoaBancos pessoaBancosCollection1NewPessoaBancosToAttach : pessoaBancosCollection1New) {
                pessoaBancosCollection1NewPessoaBancosToAttach = em.getReference(pessoaBancosCollection1NewPessoaBancosToAttach.getClass(), pessoaBancosCollection1NewPessoaBancosToAttach.getId());
                attachedPessoaBancosCollection1New.add(pessoaBancosCollection1NewPessoaBancosToAttach);
            }
            pessoaBancosCollection1New = attachedPessoaBancosCollection1New;
            pessoaOperadores.setPessoaBancosCollection1(pessoaBancosCollection1New);
            Collection<HistFuncionariosVinculos> attachedHistFuncionariosVinculosCollectionNew = new ArrayList<HistFuncionariosVinculos>();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach : histFuncionariosVinculosCollectionNew) {
                histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach = em.getReference(histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach.getClass(), histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach.getId());
                attachedHistFuncionariosVinculosCollectionNew.add(histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach);
            }
            histFuncionariosVinculosCollectionNew = attachedHistFuncionariosVinculosCollectionNew;
            pessoaOperadores.setHistFuncionariosVinculosCollection(histFuncionariosVinculosCollectionNew);
            Collection<HistFuncionariosVinculos> attachedHistFuncionariosVinculosCollection1New = new ArrayList<HistFuncionariosVinculos>();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollection1NewHistFuncionariosVinculosToAttach : histFuncionariosVinculosCollection1New) {
                histFuncionariosVinculosCollection1NewHistFuncionariosVinculosToAttach = em.getReference(histFuncionariosVinculosCollection1NewHistFuncionariosVinculosToAttach.getClass(), histFuncionariosVinculosCollection1NewHistFuncionariosVinculosToAttach.getId());
                attachedHistFuncionariosVinculosCollection1New.add(histFuncionariosVinculosCollection1NewHistFuncionariosVinculosToAttach);
            }
            histFuncionariosVinculosCollection1New = attachedHistFuncionariosVinculosCollection1New;
            pessoaOperadores.setHistFuncionariosVinculosCollection1(histFuncionariosVinculosCollection1New);
            Collection<HistUnidadesDiretor> attachedHistUnidadesDiretorCollectionNew = new ArrayList<HistUnidadesDiretor>();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach : histUnidadesDiretorCollectionNew) {
                histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach = em.getReference(histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach.getClass(), histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach.getHistUnidadesDiretorPK());
                attachedHistUnidadesDiretorCollectionNew.add(histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach);
            }
            histUnidadesDiretorCollectionNew = attachedHistUnidadesDiretorCollectionNew;
            pessoaOperadores.setHistUnidadesDiretorCollection(histUnidadesDiretorCollectionNew);
            Collection<HistUnidadesDiretor> attachedHistUnidadesDiretorCollection1New = new ArrayList<HistUnidadesDiretor>();
            for (HistUnidadesDiretor histUnidadesDiretorCollection1NewHistUnidadesDiretorToAttach : histUnidadesDiretorCollection1New) {
                histUnidadesDiretorCollection1NewHistUnidadesDiretorToAttach = em.getReference(histUnidadesDiretorCollection1NewHistUnidadesDiretorToAttach.getClass(), histUnidadesDiretorCollection1NewHistUnidadesDiretorToAttach.getHistUnidadesDiretorPK());
                attachedHistUnidadesDiretorCollection1New.add(histUnidadesDiretorCollection1NewHistUnidadesDiretorToAttach);
            }
            histUnidadesDiretorCollection1New = attachedHistUnidadesDiretorCollection1New;
            pessoaOperadores.setHistUnidadesDiretorCollection1(histUnidadesDiretorCollection1New);
            Collection<PessoaFuncionarios> attachedPessoaFuncionariosCollectionNew = new ArrayList<PessoaFuncionarios>();
            for (PessoaFuncionarios pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach : pessoaFuncionariosCollectionNew) {
                pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach = em.getReference(pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach.getClass(), pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach.getId());
                attachedPessoaFuncionariosCollectionNew.add(pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach);
            }
            pessoaFuncionariosCollectionNew = attachedPessoaFuncionariosCollectionNew;
            pessoaOperadores.setPessoaFuncionariosCollection(pessoaFuncionariosCollectionNew);
            Collection<PessoaFuncionarios> attachedPessoaFuncionariosCollection1New = new ArrayList<PessoaFuncionarios>();
            for (PessoaFuncionarios pessoaFuncionariosCollection1NewPessoaFuncionariosToAttach : pessoaFuncionariosCollection1New) {
                pessoaFuncionariosCollection1NewPessoaFuncionariosToAttach = em.getReference(pessoaFuncionariosCollection1NewPessoaFuncionariosToAttach.getClass(), pessoaFuncionariosCollection1NewPessoaFuncionariosToAttach.getId());
                attachedPessoaFuncionariosCollection1New.add(pessoaFuncionariosCollection1NewPessoaFuncionariosToAttach);
            }
            pessoaFuncionariosCollection1New = attachedPessoaFuncionariosCollection1New;
            pessoaOperadores.setPessoaFuncionariosCollection1(pessoaFuncionariosCollection1New);
            Collection<HistFuncionariosUnidadeLotacao> attachedHistFuncionariosUnidadeLotacaoCollectionNew = new ArrayList<HistFuncionariosUnidadeLotacao>();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach : histFuncionariosUnidadeLotacaoCollectionNew) {
                histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach = em.getReference(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach.getClass(), histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach.getId());
                attachedHistFuncionariosUnidadeLotacaoCollectionNew.add(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach);
            }
            histFuncionariosUnidadeLotacaoCollectionNew = attachedHistFuncionariosUnidadeLotacaoCollectionNew;
            pessoaOperadores.setHistFuncionariosUnidadeLotacaoCollection(histFuncionariosUnidadeLotacaoCollectionNew);
            Collection<HistFuncionariosUnidadeLotacao> attachedHistFuncionariosUnidadeLotacaoCollection1New = new ArrayList<HistFuncionariosUnidadeLotacao>();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacaoToAttach : histFuncionariosUnidadeLotacaoCollection1New) {
                histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacaoToAttach = em.getReference(histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacaoToAttach.getClass(), histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacaoToAttach.getId());
                attachedHistFuncionariosUnidadeLotacaoCollection1New.add(histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacaoToAttach);
            }
            histFuncionariosUnidadeLotacaoCollection1New = attachedHistFuncionariosUnidadeLotacaoCollection1New;
            pessoaOperadores.setHistFuncionariosUnidadeLotacaoCollection1(histFuncionariosUnidadeLotacaoCollection1New);
            Collection<HistFuncionariosUnidadeAtuacao> attachedHistFuncionariosUnidadeAtuacaoCollectionNew = new ArrayList<HistFuncionariosUnidadeAtuacao>();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach : histFuncionariosUnidadeAtuacaoCollectionNew) {
                histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach = em.getReference(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach.getClass(), histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach.getId());
                attachedHistFuncionariosUnidadeAtuacaoCollectionNew.add(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach);
            }
            histFuncionariosUnidadeAtuacaoCollectionNew = attachedHistFuncionariosUnidadeAtuacaoCollectionNew;
            pessoaOperadores.setHistFuncionariosUnidadeAtuacaoCollection(histFuncionariosUnidadeAtuacaoCollectionNew);
            Collection<HistFuncionariosUnidadeAtuacao> attachedHistFuncionariosUnidadeAtuacaoCollection1New = new ArrayList<HistFuncionariosUnidadeAtuacao>();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacaoToAttach : histFuncionariosUnidadeAtuacaoCollection1New) {
                histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacaoToAttach = em.getReference(histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacaoToAttach.getClass(), histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacaoToAttach.getId());
                attachedHistFuncionariosUnidadeAtuacaoCollection1New.add(histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacaoToAttach);
            }
            histFuncionariosUnidadeAtuacaoCollection1New = attachedHistFuncionariosUnidadeAtuacaoCollection1New;
            pessoaOperadores.setHistFuncionariosUnidadeAtuacaoCollection1(histFuncionariosUnidadeAtuacaoCollection1New);
            pessoaOperadores = em.merge(pessoaOperadores);
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaOperadoresCollection().remove(pessoaOperadores);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaOperadoresCollection().add(pessoaOperadores);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            if (seqPrivilegioOld != null && !seqPrivilegioOld.equals(seqPrivilegioNew)) {
                seqPrivilegioOld.getPessoaOperadoresCollection().remove(pessoaOperadores);
                seqPrivilegioOld = em.merge(seqPrivilegioOld);
            }
            if (seqPrivilegioNew != null && !seqPrivilegioNew.equals(seqPrivilegioOld)) {
                seqPrivilegioNew.getPessoaOperadoresCollection().add(pessoaOperadores);
                seqPrivilegioNew = em.merge(seqPrivilegioNew);
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionNew) {
                if (!histFuncionariosAutorizacaoCollectionOld.contains(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.getIdOperadorCadastroFk();
                    histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao != null && !oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                        oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                    }
                }
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollection1OldHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollection1Old) {
                if (!histFuncionariosAutorizacaoCollection1New.contains(histFuncionariosAutorizacaoCollection1OldHistFuncionariosAutorizacao)) {
                    histFuncionariosAutorizacaoCollection1OldHistFuncionariosAutorizacao.setIdOperadorCancelamentoFk(null);
                    histFuncionariosAutorizacaoCollection1OldHistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollection1OldHistFuncionariosAutorizacao);
                }
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollection1New) {
                if (!histFuncionariosAutorizacaoCollection1Old.contains(histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao = histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao.getIdOperadorCancelamentoFk();
                    histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao.getHistFuncionariosAutorizacaoCollection1().remove(histFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosAutorizacaoCollection1NewHistFuncionariosAutorizacao);
                    }
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollectionNewHistFuncionariosClasse : histFuncionariosClasseCollectionNew) {
                if (!histFuncionariosClasseCollectionOld.contains(histFuncionariosClasseCollectionNewHistFuncionariosClasse)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse = histFuncionariosClasseCollectionNewHistFuncionariosClasse.getIdOperadorCadastroFk();
                    histFuncionariosClasseCollectionNewHistFuncionariosClasse.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosClasseCollectionNewHistFuncionariosClasse = em.merge(histFuncionariosClasseCollectionNewHistFuncionariosClasse);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse != null && !oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse.getHistFuncionariosClasseCollection().remove(histFuncionariosClasseCollectionNewHistFuncionariosClasse);
                        oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse);
                    }
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollection1OldHistFuncionariosClasse : histFuncionariosClasseCollection1Old) {
                if (!histFuncionariosClasseCollection1New.contains(histFuncionariosClasseCollection1OldHistFuncionariosClasse)) {
                    histFuncionariosClasseCollection1OldHistFuncionariosClasse.setIdOperadorCancelamentoFk(null);
                    histFuncionariosClasseCollection1OldHistFuncionariosClasse = em.merge(histFuncionariosClasseCollection1OldHistFuncionariosClasse);
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollection1NewHistFuncionariosClasse : histFuncionariosClasseCollection1New) {
                if (!histFuncionariosClasseCollection1Old.contains(histFuncionariosClasseCollection1NewHistFuncionariosClasse)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1NewHistFuncionariosClasse = histFuncionariosClasseCollection1NewHistFuncionariosClasse.getIdOperadorCancelamentoFk();
                    histFuncionariosClasseCollection1NewHistFuncionariosClasse.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosClasseCollection1NewHistFuncionariosClasse = em.merge(histFuncionariosClasseCollection1NewHistFuncionariosClasse);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1NewHistFuncionariosClasse != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1NewHistFuncionariosClasse.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1NewHistFuncionariosClasse.getHistFuncionariosClasseCollection1().remove(histFuncionariosClasseCollection1NewHistFuncionariosClasse);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1NewHistFuncionariosClasse = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosClasseCollection1NewHistFuncionariosClasse);
                    }
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollectionOld) {
                if (!histFuncionariosCargaHorariaCollectionNew.contains(histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria)) {
                    histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria.setIdOperadorCancelamentoFk(null);
                    histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria);
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollectionNew) {
                if (!histFuncionariosCargaHorariaCollectionOld.contains(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.getIdOperadorCancelamentoFk();
                    histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                    }
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollection1New) {
                if (!histFuncionariosCargaHorariaCollection1Old.contains(histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria = histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria.getIdOperadorCadastroFk();
                    histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria != null && !oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria.getHistFuncionariosCargaHorariaCollection1().remove(histFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria);
                        oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosCargaHorariaCollection1NewHistFuncionariosCargaHoraria);
                    }
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollectionNewHistFuncionariosCargos : histFuncionariosCargosCollectionNew) {
                if (!histFuncionariosCargosCollectionOld.contains(histFuncionariosCargosCollectionNewHistFuncionariosCargos)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos = histFuncionariosCargosCollectionNewHistFuncionariosCargos.getIdOperadorCadastroFk();
                    histFuncionariosCargosCollectionNewHistFuncionariosCargos.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosCargosCollectionNewHistFuncionariosCargos = em.merge(histFuncionariosCargosCollectionNewHistFuncionariosCargos);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos != null && !oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos.getHistFuncionariosCargosCollection().remove(histFuncionariosCargosCollectionNewHistFuncionariosCargos);
                        oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos);
                    }
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollection1OldHistFuncionariosCargos : histFuncionariosCargosCollection1Old) {
                if (!histFuncionariosCargosCollection1New.contains(histFuncionariosCargosCollection1OldHistFuncionariosCargos)) {
                    histFuncionariosCargosCollection1OldHistFuncionariosCargos.setIdOperadorCancelamentoFk(null);
                    histFuncionariosCargosCollection1OldHistFuncionariosCargos = em.merge(histFuncionariosCargosCollection1OldHistFuncionariosCargos);
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollection1NewHistFuncionariosCargos : histFuncionariosCargosCollection1New) {
                if (!histFuncionariosCargosCollection1Old.contains(histFuncionariosCargosCollection1NewHistFuncionariosCargos)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1NewHistFuncionariosCargos = histFuncionariosCargosCollection1NewHistFuncionariosCargos.getIdOperadorCancelamentoFk();
                    histFuncionariosCargosCollection1NewHistFuncionariosCargos.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosCargosCollection1NewHistFuncionariosCargos = em.merge(histFuncionariosCargosCollection1NewHistFuncionariosCargos);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1NewHistFuncionariosCargos != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1NewHistFuncionariosCargos.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1NewHistFuncionariosCargos.getHistFuncionariosCargosCollection1().remove(histFuncionariosCargosCollection1NewHistFuncionariosCargos);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1NewHistFuncionariosCargos = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosCargosCollection1NewHistFuncionariosCargos);
                    }
                }
            }
            for (PessoaFilhos pessoaFilhosCollectionOldPessoaFilhos : pessoaFilhosCollectionOld) {
                if (!pessoaFilhosCollectionNew.contains(pessoaFilhosCollectionOldPessoaFilhos)) {
                    pessoaFilhosCollectionOldPessoaFilhos.setIdOperadorCadastroFk(null);
                    pessoaFilhosCollectionOldPessoaFilhos = em.merge(pessoaFilhosCollectionOldPessoaFilhos);
                }
            }
            for (PessoaFilhos pessoaFilhosCollectionNewPessoaFilhos : pessoaFilhosCollectionNew) {
                if (!pessoaFilhosCollectionOld.contains(pessoaFilhosCollectionNewPessoaFilhos)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfPessoaFilhosCollectionNewPessoaFilhos = pessoaFilhosCollectionNewPessoaFilhos.getIdOperadorCadastroFk();
                    pessoaFilhosCollectionNewPessoaFilhos.setIdOperadorCadastroFk(pessoaOperadores);
                    pessoaFilhosCollectionNewPessoaFilhos = em.merge(pessoaFilhosCollectionNewPessoaFilhos);
                    if (oldIdOperadorCadastroFkOfPessoaFilhosCollectionNewPessoaFilhos != null && !oldIdOperadorCadastroFkOfPessoaFilhosCollectionNewPessoaFilhos.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfPessoaFilhosCollectionNewPessoaFilhos.getPessoaFilhosCollection().remove(pessoaFilhosCollectionNewPessoaFilhos);
                        oldIdOperadorCadastroFkOfPessoaFilhosCollectionNewPessoaFilhos = em.merge(oldIdOperadorCadastroFkOfPessoaFilhosCollectionNewPessoaFilhos);
                    }
                }
            }
            for (PessoaFilhos pessoaFilhosCollection1OldPessoaFilhos : pessoaFilhosCollection1Old) {
                if (!pessoaFilhosCollection1New.contains(pessoaFilhosCollection1OldPessoaFilhos)) {
                    pessoaFilhosCollection1OldPessoaFilhos.setIdOperadorCancelamentoFk(null);
                    pessoaFilhosCollection1OldPessoaFilhos = em.merge(pessoaFilhosCollection1OldPessoaFilhos);
                }
            }
            for (PessoaFilhos pessoaFilhosCollection1NewPessoaFilhos : pessoaFilhosCollection1New) {
                if (!pessoaFilhosCollection1Old.contains(pessoaFilhosCollection1NewPessoaFilhos)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1NewPessoaFilhos = pessoaFilhosCollection1NewPessoaFilhos.getIdOperadorCancelamentoFk();
                    pessoaFilhosCollection1NewPessoaFilhos.setIdOperadorCancelamentoFk(pessoaOperadores);
                    pessoaFilhosCollection1NewPessoaFilhos = em.merge(pessoaFilhosCollection1NewPessoaFilhos);
                    if (oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1NewPessoaFilhos != null && !oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1NewPessoaFilhos.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1NewPessoaFilhos.getPessoaFilhosCollection1().remove(pessoaFilhosCollection1NewPessoaFilhos);
                        oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1NewPessoaFilhos = em.merge(oldIdOperadorCancelamentoFkOfPessoaFilhosCollection1NewPessoaFilhos);
                    }
                }
            }
            for (Unidades unidadesCollectionOldUnidades : unidadesCollectionOld) {
                if (!unidadesCollectionNew.contains(unidadesCollectionOldUnidades)) {
                    unidadesCollectionOldUnidades.setIdOperadorCadastroFk(null);
                    unidadesCollectionOldUnidades = em.merge(unidadesCollectionOldUnidades);
                }
            }
            for (Unidades unidadesCollectionNewUnidades : unidadesCollectionNew) {
                if (!unidadesCollectionOld.contains(unidadesCollectionNewUnidades)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfUnidadesCollectionNewUnidades = unidadesCollectionNewUnidades.getIdOperadorCadastroFk();
                    unidadesCollectionNewUnidades.setIdOperadorCadastroFk(pessoaOperadores);
                    unidadesCollectionNewUnidades = em.merge(unidadesCollectionNewUnidades);
                    if (oldIdOperadorCadastroFkOfUnidadesCollectionNewUnidades != null && !oldIdOperadorCadastroFkOfUnidadesCollectionNewUnidades.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfUnidadesCollectionNewUnidades.getUnidadesCollection().remove(unidadesCollectionNewUnidades);
                        oldIdOperadorCadastroFkOfUnidadesCollectionNewUnidades = em.merge(oldIdOperadorCadastroFkOfUnidadesCollectionNewUnidades);
                    }
                }
            }
            for (Unidades unidadesCollection1OldUnidades : unidadesCollection1Old) {
                if (!unidadesCollection1New.contains(unidadesCollection1OldUnidades)) {
                    unidadesCollection1OldUnidades.setIdOperadorCancelamentoFk(null);
                    unidadesCollection1OldUnidades = em.merge(unidadesCollection1OldUnidades);
                }
            }
            for (Unidades unidadesCollection1NewUnidades : unidadesCollection1New) {
                if (!unidadesCollection1Old.contains(unidadesCollection1NewUnidades)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfUnidadesCollection1NewUnidades = unidadesCollection1NewUnidades.getIdOperadorCancelamentoFk();
                    unidadesCollection1NewUnidades.setIdOperadorCancelamentoFk(pessoaOperadores);
                    unidadesCollection1NewUnidades = em.merge(unidadesCollection1NewUnidades);
                    if (oldIdOperadorCancelamentoFkOfUnidadesCollection1NewUnidades != null && !oldIdOperadorCancelamentoFkOfUnidadesCollection1NewUnidades.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfUnidadesCollection1NewUnidades.getUnidadesCollection1().remove(unidadesCollection1NewUnidades);
                        oldIdOperadorCancelamentoFkOfUnidadesCollection1NewUnidades = em.merge(oldIdOperadorCancelamentoFkOfUnidadesCollection1NewUnidades);
                    }
                }
            }
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollectionNew) {
                if (!histUnidadesNaturezaJuridicaCollectionOld.contains(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica = histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica.getIdOperadorCadastroFk();
                    histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica.setIdOperadorCadastroFk(pessoaOperadores);
                    histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica);
                    if (oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica != null && !oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica);
                        oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica = em.merge(oldIdOperadorCadastroFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica);
                    }
                }
            }
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollection1OldHistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollection1Old) {
                if (!histUnidadesNaturezaJuridicaCollection1New.contains(histUnidadesNaturezaJuridicaCollection1OldHistUnidadesNaturezaJuridica)) {
                    histUnidadesNaturezaJuridicaCollection1OldHistUnidadesNaturezaJuridica.setIdOperadorCancelamentoFk(null);
                    histUnidadesNaturezaJuridicaCollection1OldHistUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridicaCollection1OldHistUnidadesNaturezaJuridica);
                }
            }
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollection1New) {
                if (!histUnidadesNaturezaJuridicaCollection1Old.contains(histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica = histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica.getIdOperadorCancelamentoFk();
                    histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica);
                    if (oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica != null && !oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection1().remove(histUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica);
                        oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica = em.merge(oldIdOperadorCancelamentoFkOfHistUnidadesNaturezaJuridicaCollection1NewHistUnidadesNaturezaJuridica);
                    }
                }
            }
            for (HistUnidadesRegime histUnidadesRegimeCollectionNewHistUnidadesRegime : histUnidadesRegimeCollectionNew) {
                if (!histUnidadesRegimeCollectionOld.contains(histUnidadesRegimeCollectionNewHistUnidadesRegime)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime = histUnidadesRegimeCollectionNewHistUnidadesRegime.getIdOperadorCadastroFk();
                    histUnidadesRegimeCollectionNewHistUnidadesRegime.setIdOperadorCadastroFk(pessoaOperadores);
                    histUnidadesRegimeCollectionNewHistUnidadesRegime = em.merge(histUnidadesRegimeCollectionNewHistUnidadesRegime);
                    if (oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime != null && !oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime.getHistUnidadesRegimeCollection().remove(histUnidadesRegimeCollectionNewHistUnidadesRegime);
                        oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime = em.merge(oldIdOperadorCadastroFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime);
                    }
                }
            }
            for (HistUnidadesRegime histUnidadesRegimeCollection1OldHistUnidadesRegime : histUnidadesRegimeCollection1Old) {
                if (!histUnidadesRegimeCollection1New.contains(histUnidadesRegimeCollection1OldHistUnidadesRegime)) {
                    histUnidadesRegimeCollection1OldHistUnidadesRegime.setIdOperadorCancelamentoFk(null);
                    histUnidadesRegimeCollection1OldHistUnidadesRegime = em.merge(histUnidadesRegimeCollection1OldHistUnidadesRegime);
                }
            }
            for (HistUnidadesRegime histUnidadesRegimeCollection1NewHistUnidadesRegime : histUnidadesRegimeCollection1New) {
                if (!histUnidadesRegimeCollection1Old.contains(histUnidadesRegimeCollection1NewHistUnidadesRegime)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1NewHistUnidadesRegime = histUnidadesRegimeCollection1NewHistUnidadesRegime.getIdOperadorCancelamentoFk();
                    histUnidadesRegimeCollection1NewHistUnidadesRegime.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histUnidadesRegimeCollection1NewHistUnidadesRegime = em.merge(histUnidadesRegimeCollection1NewHistUnidadesRegime);
                    if (oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1NewHistUnidadesRegime != null && !oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1NewHistUnidadesRegime.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1NewHistUnidadesRegime.getHistUnidadesRegimeCollection1().remove(histUnidadesRegimeCollection1NewHistUnidadesRegime);
                        oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1NewHistUnidadesRegime = em.merge(oldIdOperadorCancelamentoFkOfHistUnidadesRegimeCollection1NewHistUnidadesRegime);
                    }
                }
            }
            for (Pessoa pessoaCollectionOldPessoa : pessoaCollectionOld) {
                if (!pessoaCollectionNew.contains(pessoaCollectionOldPessoa)) {
                    pessoaCollectionOldPessoa.setSeqOperadorCadastro(null);
                    pessoaCollectionOldPessoa = em.merge(pessoaCollectionOldPessoa);
                }
            }
            for (Pessoa pessoaCollectionNewPessoa : pessoaCollectionNew) {
                if (!pessoaCollectionOld.contains(pessoaCollectionNewPessoa)) {
                    PessoaOperadores oldSeqOperadorCadastroOfPessoaCollectionNewPessoa = pessoaCollectionNewPessoa.getSeqOperadorCadastro();
                    pessoaCollectionNewPessoa.setSeqOperadorCadastro(pessoaOperadores);
                    pessoaCollectionNewPessoa = em.merge(pessoaCollectionNewPessoa);
                    if (oldSeqOperadorCadastroOfPessoaCollectionNewPessoa != null && !oldSeqOperadorCadastroOfPessoaCollectionNewPessoa.equals(pessoaOperadores)) {
                        oldSeqOperadorCadastroOfPessoaCollectionNewPessoa.getPessoaCollection().remove(pessoaCollectionNewPessoa);
                        oldSeqOperadorCadastroOfPessoaCollectionNewPessoa = em.merge(oldSeqOperadorCadastroOfPessoaCollectionNewPessoa);
                    }
                }
            }
            for (Pessoa pessoaCollection1OldPessoa : pessoaCollection1Old) {
                if (!pessoaCollection1New.contains(pessoaCollection1OldPessoa)) {
                    pessoaCollection1OldPessoa.setSeqOperadorCancelamento(null);
                    pessoaCollection1OldPessoa = em.merge(pessoaCollection1OldPessoa);
                }
            }
            for (Pessoa pessoaCollection1NewPessoa : pessoaCollection1New) {
                if (!pessoaCollection1Old.contains(pessoaCollection1NewPessoa)) {
                    PessoaOperadores oldSeqOperadorCancelamentoOfPessoaCollection1NewPessoa = pessoaCollection1NewPessoa.getSeqOperadorCancelamento();
                    pessoaCollection1NewPessoa.setSeqOperadorCancelamento(pessoaOperadores);
                    pessoaCollection1NewPessoa = em.merge(pessoaCollection1NewPessoa);
                    if (oldSeqOperadorCancelamentoOfPessoaCollection1NewPessoa != null && !oldSeqOperadorCancelamentoOfPessoaCollection1NewPessoa.equals(pessoaOperadores)) {
                        oldSeqOperadorCancelamentoOfPessoaCollection1NewPessoa.getPessoaCollection1().remove(pessoaCollection1NewPessoa);
                        oldSeqOperadorCancelamentoOfPessoaCollection1NewPessoa = em.merge(oldSeqOperadorCancelamentoOfPessoaCollection1NewPessoa);
                    }
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira : histFuncionariosCarreiraCollectionNew) {
                if (!histFuncionariosCarreiraCollectionOld.contains(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.getIdOperadorCadastroFk();
                    histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira != null && !oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                        oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                    }
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollection1OldHistFuncionariosCarreira : histFuncionariosCarreiraCollection1Old) {
                if (!histFuncionariosCarreiraCollection1New.contains(histFuncionariosCarreiraCollection1OldHistFuncionariosCarreira)) {
                    histFuncionariosCarreiraCollection1OldHistFuncionariosCarreira.setIdOperadorCancelamentoFk(null);
                    histFuncionariosCarreiraCollection1OldHistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollection1OldHistFuncionariosCarreira);
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollection1NewHistFuncionariosCarreira : histFuncionariosCarreiraCollection1New) {
                if (!histFuncionariosCarreiraCollection1Old.contains(histFuncionariosCarreiraCollection1NewHistFuncionariosCarreira)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1NewHistFuncionariosCarreira = histFuncionariosCarreiraCollection1NewHistFuncionariosCarreira.getIdOperadorCancelamentoFk();
                    histFuncionariosCarreiraCollection1NewHistFuncionariosCarreira.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosCarreiraCollection1NewHistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollection1NewHistFuncionariosCarreira);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1NewHistFuncionariosCarreira != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1NewHistFuncionariosCarreira.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1NewHistFuncionariosCarreira.getHistFuncionariosCarreiraCollection1().remove(histFuncionariosCarreiraCollection1NewHistFuncionariosCarreira);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1NewHistFuncionariosCarreira = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosCarreiraCollection1NewHistFuncionariosCarreira);
                    }
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes : histFuncionariosSituacoesCollectionOld) {
                if (!histFuncionariosSituacoesCollectionNew.contains(histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes)) {
                    histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes.setIdOperadorCancelamentoFk(null);
                    histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes);
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes : histFuncionariosSituacoesCollectionNew) {
                if (!histFuncionariosSituacoesCollectionOld.contains(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.getIdOperadorCancelamentoFk();
                    histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                    }
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes : histFuncionariosSituacoesCollection1New) {
                if (!histFuncionariosSituacoesCollection1Old.contains(histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes = histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes.getIdOperadorCadastroFk();
                    histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes != null && !oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes.getHistFuncionariosSituacoesCollection1().remove(histFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes);
                        oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosSituacoesCollection1NewHistFuncionariosSituacoes);
                    }
                }
            }
            for (Autorizacoes autorizacoesCollectionNewAutorizacoes : autorizacoesCollectionNew) {
                if (!autorizacoesCollectionOld.contains(autorizacoesCollectionNewAutorizacoes)) {
                    PessoaOperadores oldIdOperadorCriacaoFkOfAutorizacoesCollectionNewAutorizacoes = autorizacoesCollectionNewAutorizacoes.getIdOperadorCriacaoFk();
                    autorizacoesCollectionNewAutorizacoes.setIdOperadorCriacaoFk(pessoaOperadores);
                    autorizacoesCollectionNewAutorizacoes = em.merge(autorizacoesCollectionNewAutorizacoes);
                    if (oldIdOperadorCriacaoFkOfAutorizacoesCollectionNewAutorizacoes != null && !oldIdOperadorCriacaoFkOfAutorizacoesCollectionNewAutorizacoes.equals(pessoaOperadores)) {
                        oldIdOperadorCriacaoFkOfAutorizacoesCollectionNewAutorizacoes.getAutorizacoesCollection().remove(autorizacoesCollectionNewAutorizacoes);
                        oldIdOperadorCriacaoFkOfAutorizacoesCollectionNewAutorizacoes = em.merge(oldIdOperadorCriacaoFkOfAutorizacoesCollectionNewAutorizacoes);
                    }
                }
            }
            for (PessoaBancos pessoaBancosCollectionOldPessoaBancos : pessoaBancosCollectionOld) {
                if (!pessoaBancosCollectionNew.contains(pessoaBancosCollectionOldPessoaBancos)) {
                    pessoaBancosCollectionOldPessoaBancos.setIdOperadorCadastroFk(null);
                    pessoaBancosCollectionOldPessoaBancos = em.merge(pessoaBancosCollectionOldPessoaBancos);
                }
            }
            for (PessoaBancos pessoaBancosCollectionNewPessoaBancos : pessoaBancosCollectionNew) {
                if (!pessoaBancosCollectionOld.contains(pessoaBancosCollectionNewPessoaBancos)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfPessoaBancosCollectionNewPessoaBancos = pessoaBancosCollectionNewPessoaBancos.getIdOperadorCadastroFk();
                    pessoaBancosCollectionNewPessoaBancos.setIdOperadorCadastroFk(pessoaOperadores);
                    pessoaBancosCollectionNewPessoaBancos = em.merge(pessoaBancosCollectionNewPessoaBancos);
                    if (oldIdOperadorCadastroFkOfPessoaBancosCollectionNewPessoaBancos != null && !oldIdOperadorCadastroFkOfPessoaBancosCollectionNewPessoaBancos.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfPessoaBancosCollectionNewPessoaBancos.getPessoaBancosCollection().remove(pessoaBancosCollectionNewPessoaBancos);
                        oldIdOperadorCadastroFkOfPessoaBancosCollectionNewPessoaBancos = em.merge(oldIdOperadorCadastroFkOfPessoaBancosCollectionNewPessoaBancos);
                    }
                }
            }
            for (PessoaBancos pessoaBancosCollection1OldPessoaBancos : pessoaBancosCollection1Old) {
                if (!pessoaBancosCollection1New.contains(pessoaBancosCollection1OldPessoaBancos)) {
                    pessoaBancosCollection1OldPessoaBancos.setIdOperadorCancelamentoFk(null);
                    pessoaBancosCollection1OldPessoaBancos = em.merge(pessoaBancosCollection1OldPessoaBancos);
                }
            }
            for (PessoaBancos pessoaBancosCollection1NewPessoaBancos : pessoaBancosCollection1New) {
                if (!pessoaBancosCollection1Old.contains(pessoaBancosCollection1NewPessoaBancos)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfPessoaBancosCollection1NewPessoaBancos = pessoaBancosCollection1NewPessoaBancos.getIdOperadorCancelamentoFk();
                    pessoaBancosCollection1NewPessoaBancos.setIdOperadorCancelamentoFk(pessoaOperadores);
                    pessoaBancosCollection1NewPessoaBancos = em.merge(pessoaBancosCollection1NewPessoaBancos);
                    if (oldIdOperadorCancelamentoFkOfPessoaBancosCollection1NewPessoaBancos != null && !oldIdOperadorCancelamentoFkOfPessoaBancosCollection1NewPessoaBancos.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfPessoaBancosCollection1NewPessoaBancos.getPessoaBancosCollection1().remove(pessoaBancosCollection1NewPessoaBancos);
                        oldIdOperadorCancelamentoFkOfPessoaBancosCollection1NewPessoaBancos = em.merge(oldIdOperadorCancelamentoFkOfPessoaBancosCollection1NewPessoaBancos);
                    }
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionNewHistFuncionariosVinculos : histFuncionariosVinculosCollectionNew) {
                if (!histFuncionariosVinculosCollectionOld.contains(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos = histFuncionariosVinculosCollectionNewHistFuncionariosVinculos.getIdOperadorCadastroFk();
                    histFuncionariosVinculosCollectionNewHistFuncionariosVinculos.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosVinculosCollectionNewHistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos != null && !oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                        oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                    }
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollection1OldHistFuncionariosVinculos : histFuncionariosVinculosCollection1Old) {
                if (!histFuncionariosVinculosCollection1New.contains(histFuncionariosVinculosCollection1OldHistFuncionariosVinculos)) {
                    histFuncionariosVinculosCollection1OldHistFuncionariosVinculos.setIdOperadorCancelamentoFk(null);
                    histFuncionariosVinculosCollection1OldHistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollection1OldHistFuncionariosVinculos);
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollection1NewHistFuncionariosVinculos : histFuncionariosVinculosCollection1New) {
                if (!histFuncionariosVinculosCollection1Old.contains(histFuncionariosVinculosCollection1NewHistFuncionariosVinculos)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1NewHistFuncionariosVinculos = histFuncionariosVinculosCollection1NewHistFuncionariosVinculos.getIdOperadorCancelamentoFk();
                    histFuncionariosVinculosCollection1NewHistFuncionariosVinculos.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosVinculosCollection1NewHistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollection1NewHistFuncionariosVinculos);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1NewHistFuncionariosVinculos != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1NewHistFuncionariosVinculos.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1NewHistFuncionariosVinculos.getHistFuncionariosVinculosCollection1().remove(histFuncionariosVinculosCollection1NewHistFuncionariosVinculos);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1NewHistFuncionariosVinculos = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosVinculosCollection1NewHistFuncionariosVinculos);
                    }
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionNewHistUnidadesDiretor : histUnidadesDiretorCollectionNew) {
                if (!histUnidadesDiretorCollectionOld.contains(histUnidadesDiretorCollectionNewHistUnidadesDiretor)) {
                    PessoaOperadores oldPessoaOperadoresOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor = histUnidadesDiretorCollectionNewHistUnidadesDiretor.getPessoaOperadores();
                    histUnidadesDiretorCollectionNewHistUnidadesDiretor.setPessoaOperadores(pessoaOperadores);
                    histUnidadesDiretorCollectionNewHistUnidadesDiretor = em.merge(histUnidadesDiretorCollectionNewHistUnidadesDiretor);
                    if (oldPessoaOperadoresOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor != null && !oldPessoaOperadoresOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor.equals(pessoaOperadores)) {
                        oldPessoaOperadoresOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor.getHistUnidadesDiretorCollection().remove(histUnidadesDiretorCollectionNewHistUnidadesDiretor);
                        oldPessoaOperadoresOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor = em.merge(oldPessoaOperadoresOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor);
                    }
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollection1OldHistUnidadesDiretor : histUnidadesDiretorCollection1Old) {
                if (!histUnidadesDiretorCollection1New.contains(histUnidadesDiretorCollection1OldHistUnidadesDiretor)) {
                    histUnidadesDiretorCollection1OldHistUnidadesDiretor.setIdOperadorCancelamentoFk(null);
                    histUnidadesDiretorCollection1OldHistUnidadesDiretor = em.merge(histUnidadesDiretorCollection1OldHistUnidadesDiretor);
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollection1NewHistUnidadesDiretor : histUnidadesDiretorCollection1New) {
                if (!histUnidadesDiretorCollection1Old.contains(histUnidadesDiretorCollection1NewHistUnidadesDiretor)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1NewHistUnidadesDiretor = histUnidadesDiretorCollection1NewHistUnidadesDiretor.getIdOperadorCancelamentoFk();
                    histUnidadesDiretorCollection1NewHistUnidadesDiretor.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histUnidadesDiretorCollection1NewHistUnidadesDiretor = em.merge(histUnidadesDiretorCollection1NewHistUnidadesDiretor);
                    if (oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1NewHistUnidadesDiretor != null && !oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1NewHistUnidadesDiretor.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1NewHistUnidadesDiretor.getHistUnidadesDiretorCollection1().remove(histUnidadesDiretorCollection1NewHistUnidadesDiretor);
                        oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1NewHistUnidadesDiretor = em.merge(oldIdOperadorCancelamentoFkOfHistUnidadesDiretorCollection1NewHistUnidadesDiretor);
                    }
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollectionOldPessoaFuncionarios : pessoaFuncionariosCollectionOld) {
                if (!pessoaFuncionariosCollectionNew.contains(pessoaFuncionariosCollectionOldPessoaFuncionarios)) {
                    pessoaFuncionariosCollectionOldPessoaFuncionarios.setIdOperadorCadastroFk(null);
                    pessoaFuncionariosCollectionOldPessoaFuncionarios = em.merge(pessoaFuncionariosCollectionOldPessoaFuncionarios);
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollectionNewPessoaFuncionarios : pessoaFuncionariosCollectionNew) {
                if (!pessoaFuncionariosCollectionOld.contains(pessoaFuncionariosCollectionNewPessoaFuncionarios)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios = pessoaFuncionariosCollectionNewPessoaFuncionarios.getIdOperadorCadastroFk();
                    pessoaFuncionariosCollectionNewPessoaFuncionarios.setIdOperadorCadastroFk(pessoaOperadores);
                    pessoaFuncionariosCollectionNewPessoaFuncionarios = em.merge(pessoaFuncionariosCollectionNewPessoaFuncionarios);
                    if (oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios != null && !oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios.getPessoaFuncionariosCollection().remove(pessoaFuncionariosCollectionNewPessoaFuncionarios);
                        oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios = em.merge(oldIdOperadorCadastroFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios);
                    }
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollection1OldPessoaFuncionarios : pessoaFuncionariosCollection1Old) {
                if (!pessoaFuncionariosCollection1New.contains(pessoaFuncionariosCollection1OldPessoaFuncionarios)) {
                    pessoaFuncionariosCollection1OldPessoaFuncionarios.setIdOperadorCancelamentoFk(null);
                    pessoaFuncionariosCollection1OldPessoaFuncionarios = em.merge(pessoaFuncionariosCollection1OldPessoaFuncionarios);
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollection1NewPessoaFuncionarios : pessoaFuncionariosCollection1New) {
                if (!pessoaFuncionariosCollection1Old.contains(pessoaFuncionariosCollection1NewPessoaFuncionarios)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1NewPessoaFuncionarios = pessoaFuncionariosCollection1NewPessoaFuncionarios.getIdOperadorCancelamentoFk();
                    pessoaFuncionariosCollection1NewPessoaFuncionarios.setIdOperadorCancelamentoFk(pessoaOperadores);
                    pessoaFuncionariosCollection1NewPessoaFuncionarios = em.merge(pessoaFuncionariosCollection1NewPessoaFuncionarios);
                    if (oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1NewPessoaFuncionarios != null && !oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1NewPessoaFuncionarios.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1NewPessoaFuncionarios.getPessoaFuncionariosCollection1().remove(pessoaFuncionariosCollection1NewPessoaFuncionarios);
                        oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1NewPessoaFuncionarios = em.merge(oldIdOperadorCancelamentoFkOfPessoaFuncionariosCollection1NewPessoaFuncionarios);
                    }
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollectionNew) {
                if (!histFuncionariosUnidadeLotacaoCollectionOld.contains(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao = histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao.getIdOperadorCadastroFk();
                    histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao != null && !oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao);
                        oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao);
                    }
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollection1OldHistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollection1Old) {
                if (!histFuncionariosUnidadeLotacaoCollection1New.contains(histFuncionariosUnidadeLotacaoCollection1OldHistFuncionariosUnidadeLotacao)) {
                    histFuncionariosUnidadeLotacaoCollection1OldHistFuncionariosUnidadeLotacao.setIdOperadorCancelamentoFk(null);
                    histFuncionariosUnidadeLotacaoCollection1OldHistFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacaoCollection1OldHistFuncionariosUnidadeLotacao);
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollection1New) {
                if (!histFuncionariosUnidadeLotacaoCollection1Old.contains(histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao = histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao.getIdOperadorCancelamentoFk();
                    histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao.getHistFuncionariosUnidadeLotacaoCollection1().remove(histFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeLotacaoCollection1NewHistFuncionariosUnidadeLotacao);
                    }
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionNew) {
                if (!histFuncionariosUnidadeAtuacaoCollectionOld.contains(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao)) {
                    PessoaOperadores oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.getIdOperadorCadastroFk();
                    histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.setIdOperadorCadastroFk(pessoaOperadores);
                    histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                    if (oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao != null && !oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.equals(pessoaOperadores)) {
                        oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                        oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = em.merge(oldIdOperadorCadastroFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                    }
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollection1OldHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollection1Old) {
                if (!histFuncionariosUnidadeAtuacaoCollection1New.contains(histFuncionariosUnidadeAtuacaoCollection1OldHistFuncionariosUnidadeAtuacao)) {
                    histFuncionariosUnidadeAtuacaoCollection1OldHistFuncionariosUnidadeAtuacao.setIdOperadorCancelamentoFk(null);
                    histFuncionariosUnidadeAtuacaoCollection1OldHistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollection1OldHistFuncionariosUnidadeAtuacao);
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollection1New) {
                if (!histFuncionariosUnidadeAtuacaoCollection1Old.contains(histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao)) {
                    PessoaOperadores oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao = histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao.getIdOperadorCancelamentoFk();
                    histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao.setIdOperadorCancelamentoFk(pessoaOperadores);
                    histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao);
                    if (oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao != null && !oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao.equals(pessoaOperadores)) {
                        oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao.getHistFuncionariosUnidadeAtuacaoCollection1().remove(histFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao);
                        oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao = em.merge(oldIdOperadorCancelamentoFkOfHistFuncionariosUnidadeAtuacaoCollection1NewHistFuncionariosUnidadeAtuacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaOperadores.getId();
                if (findPessoaOperadores(id) == null) {
                    throw new NonexistentEntityException("The pessoaOperadores with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaOperadores pessoaOperadores;
            try {
                pessoaOperadores = em.getReference(PessoaOperadores.class, id);
                pessoaOperadores.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaOperadores with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionOrphanCheck = pessoaOperadores.getHistFuncionariosAutorizacaoCollection();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionOrphanCheckHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosAutorizacao " + histFuncionariosAutorizacaoCollectionOrphanCheckHistFuncionariosAutorizacao + " in its histFuncionariosAutorizacaoCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionOrphanCheck = pessoaOperadores.getHistFuncionariosClasseCollection();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionOrphanCheckHistFuncionariosClasse : histFuncionariosClasseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosClasse " + histFuncionariosClasseCollectionOrphanCheckHistFuncionariosClasse + " in its histFuncionariosClasseCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection1OrphanCheck = pessoaOperadores.getHistFuncionariosCargaHorariaCollection1();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollection1OrphanCheckHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosCargaHoraria " + histFuncionariosCargaHorariaCollection1OrphanCheckHistFuncionariosCargaHoraria + " in its histFuncionariosCargaHorariaCollection1 field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionOrphanCheck = pessoaOperadores.getHistFuncionariosCargosCollection();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionOrphanCheckHistFuncionariosCargos : histFuncionariosCargosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosCargos " + histFuncionariosCargosCollectionOrphanCheckHistFuncionariosCargos + " in its histFuncionariosCargosCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollectionOrphanCheck = pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionOrphanCheckHistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistUnidadesNaturezaJuridica " + histUnidadesNaturezaJuridicaCollectionOrphanCheckHistUnidadesNaturezaJuridica + " in its histUnidadesNaturezaJuridicaCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionOrphanCheck = pessoaOperadores.getHistUnidadesRegimeCollection();
            for (HistUnidadesRegime histUnidadesRegimeCollectionOrphanCheckHistUnidadesRegime : histUnidadesRegimeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistUnidadesRegime " + histUnidadesRegimeCollectionOrphanCheckHistUnidadesRegime + " in its histUnidadesRegimeCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionOrphanCheck = pessoaOperadores.getHistFuncionariosCarreiraCollection();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionOrphanCheckHistFuncionariosCarreira : histFuncionariosCarreiraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosCarreira " + histFuncionariosCarreiraCollectionOrphanCheckHistFuncionariosCarreira + " in its histFuncionariosCarreiraCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection1OrphanCheck = pessoaOperadores.getHistFuncionariosSituacoesCollection1();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollection1OrphanCheckHistFuncionariosSituacoes : histFuncionariosSituacoesCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosSituacoes " + histFuncionariosSituacoesCollection1OrphanCheckHistFuncionariosSituacoes + " in its histFuncionariosSituacoesCollection1 field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<Autorizacoes> autorizacoesCollectionOrphanCheck = pessoaOperadores.getAutorizacoesCollection();
            for (Autorizacoes autorizacoesCollectionOrphanCheckAutorizacoes : autorizacoesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the Autorizacoes " + autorizacoesCollectionOrphanCheckAutorizacoes + " in its autorizacoesCollection field has a non-nullable idOperadorCriacaoFk field.");
            }
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionOrphanCheck = pessoaOperadores.getHistFuncionariosVinculosCollection();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionOrphanCheckHistFuncionariosVinculos : histFuncionariosVinculosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosVinculos " + histFuncionariosVinculosCollectionOrphanCheckHistFuncionariosVinculos + " in its histFuncionariosVinculosCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionOrphanCheck = pessoaOperadores.getHistUnidadesDiretorCollection();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionOrphanCheckHistUnidadesDiretor : histUnidadesDiretorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistUnidadesDiretor " + histUnidadesDiretorCollectionOrphanCheckHistUnidadesDiretor + " in its histUnidadesDiretorCollection field has a non-nullable pessoaOperadores field.");
            }
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollectionOrphanCheck = pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionOrphanCheckHistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosUnidadeLotacao " + histFuncionariosUnidadeLotacaoCollectionOrphanCheckHistFuncionariosUnidadeLotacao + " in its histFuncionariosUnidadeLotacaoCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionOrphanCheck = pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionOrphanCheckHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaOperadores (" + pessoaOperadores + ") cannot be destroyed since the HistFuncionariosUnidadeAtuacao " + histFuncionariosUnidadeAtuacaoCollectionOrphanCheckHistFuncionariosUnidadeAtuacao + " in its histFuncionariosUnidadeAtuacaoCollection field has a non-nullable idOperadorCadastroFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Pessoa idPessoaFk = pessoaOperadores.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaOperadoresCollection().remove(pessoaOperadores);
                idPessoaFk = em.merge(idPessoaFk);
            }
            Privilegios seqPrivilegio = pessoaOperadores.getSeqPrivilegio();
            if (seqPrivilegio != null) {
                seqPrivilegio.getPessoaOperadoresCollection().remove(pessoaOperadores);
                seqPrivilegio = em.merge(seqPrivilegio);
            }
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection1 = pessoaOperadores.getHistFuncionariosAutorizacaoCollection1();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollection1) {
                histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao.setIdOperadorCancelamentoFk(null);
                histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollection1HistFuncionariosAutorizacao);
            }
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollection1 = pessoaOperadores.getHistFuncionariosClasseCollection1();
            for (HistFuncionariosClasse histFuncionariosClasseCollection1HistFuncionariosClasse : histFuncionariosClasseCollection1) {
                histFuncionariosClasseCollection1HistFuncionariosClasse.setIdOperadorCancelamentoFk(null);
                histFuncionariosClasseCollection1HistFuncionariosClasse = em.merge(histFuncionariosClasseCollection1HistFuncionariosClasse);
            }
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection = pessoaOperadores.getHistFuncionariosCargaHorariaCollection();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollection) {
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.setIdOperadorCancelamentoFk(null);
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
            }
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollection1 = pessoaOperadores.getHistFuncionariosCargosCollection1();
            for (HistFuncionariosCargos histFuncionariosCargosCollection1HistFuncionariosCargos : histFuncionariosCargosCollection1) {
                histFuncionariosCargosCollection1HistFuncionariosCargos.setIdOperadorCancelamentoFk(null);
                histFuncionariosCargosCollection1HistFuncionariosCargos = em.merge(histFuncionariosCargosCollection1HistFuncionariosCargos);
            }
            Collection<PessoaFilhos> pessoaFilhosCollection = pessoaOperadores.getPessoaFilhosCollection();
            for (PessoaFilhos pessoaFilhosCollectionPessoaFilhos : pessoaFilhosCollection) {
                pessoaFilhosCollectionPessoaFilhos.setIdOperadorCadastroFk(null);
                pessoaFilhosCollectionPessoaFilhos = em.merge(pessoaFilhosCollectionPessoaFilhos);
            }
            Collection<PessoaFilhos> pessoaFilhosCollection1 = pessoaOperadores.getPessoaFilhosCollection1();
            for (PessoaFilhos pessoaFilhosCollection1PessoaFilhos : pessoaFilhosCollection1) {
                pessoaFilhosCollection1PessoaFilhos.setIdOperadorCancelamentoFk(null);
                pessoaFilhosCollection1PessoaFilhos = em.merge(pessoaFilhosCollection1PessoaFilhos);
            }
            Collection<Unidades> unidadesCollection = pessoaOperadores.getUnidadesCollection();
            for (Unidades unidadesCollectionUnidades : unidadesCollection) {
                unidadesCollectionUnidades.setIdOperadorCadastroFk(null);
                unidadesCollectionUnidades = em.merge(unidadesCollectionUnidades);
            }
            Collection<Unidades> unidadesCollection1 = pessoaOperadores.getUnidadesCollection1();
            for (Unidades unidadesCollection1Unidades : unidadesCollection1) {
                unidadesCollection1Unidades.setIdOperadorCancelamentoFk(null);
                unidadesCollection1Unidades = em.merge(unidadesCollection1Unidades);
            }
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection1 = pessoaOperadores.getHistUnidadesNaturezaJuridicaCollection1();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollection1) {
                histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica.setIdOperadorCancelamentoFk(null);
                histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridicaCollection1HistUnidadesNaturezaJuridica);
            }
            Collection<HistUnidadesRegime> histUnidadesRegimeCollection1 = pessoaOperadores.getHistUnidadesRegimeCollection1();
            for (HistUnidadesRegime histUnidadesRegimeCollection1HistUnidadesRegime : histUnidadesRegimeCollection1) {
                histUnidadesRegimeCollection1HistUnidadesRegime.setIdOperadorCancelamentoFk(null);
                histUnidadesRegimeCollection1HistUnidadesRegime = em.merge(histUnidadesRegimeCollection1HistUnidadesRegime);
            }
            Collection<Pessoa> pessoaCollection = pessoaOperadores.getPessoaCollection();
            for (Pessoa pessoaCollectionPessoa : pessoaCollection) {
                pessoaCollectionPessoa.setSeqOperadorCadastro(null);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
            }
            Collection<Pessoa> pessoaCollection1 = pessoaOperadores.getPessoaCollection1();
            for (Pessoa pessoaCollection1Pessoa : pessoaCollection1) {
                pessoaCollection1Pessoa.setSeqOperadorCancelamento(null);
                pessoaCollection1Pessoa = em.merge(pessoaCollection1Pessoa);
            }
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollection1 = pessoaOperadores.getHistFuncionariosCarreiraCollection1();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollection1HistFuncionariosCarreira : histFuncionariosCarreiraCollection1) {
                histFuncionariosCarreiraCollection1HistFuncionariosCarreira.setIdOperadorCancelamentoFk(null);
                histFuncionariosCarreiraCollection1HistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollection1HistFuncionariosCarreira);
            }
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection = pessoaOperadores.getHistFuncionariosSituacoesCollection();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionHistFuncionariosSituacoes : histFuncionariosSituacoesCollection) {
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoes.setIdOperadorCancelamentoFk(null);
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
            }
            Collection<PessoaBancos> pessoaBancosCollection = pessoaOperadores.getPessoaBancosCollection();
            for (PessoaBancos pessoaBancosCollectionPessoaBancos : pessoaBancosCollection) {
                pessoaBancosCollectionPessoaBancos.setIdOperadorCadastroFk(null);
                pessoaBancosCollectionPessoaBancos = em.merge(pessoaBancosCollectionPessoaBancos);
            }
            Collection<PessoaBancos> pessoaBancosCollection1 = pessoaOperadores.getPessoaBancosCollection1();
            for (PessoaBancos pessoaBancosCollection1PessoaBancos : pessoaBancosCollection1) {
                pessoaBancosCollection1PessoaBancos.setIdOperadorCancelamentoFk(null);
                pessoaBancosCollection1PessoaBancos = em.merge(pessoaBancosCollection1PessoaBancos);
            }
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollection1 = pessoaOperadores.getHistFuncionariosVinculosCollection1();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollection1HistFuncionariosVinculos : histFuncionariosVinculosCollection1) {
                histFuncionariosVinculosCollection1HistFuncionariosVinculos.setIdOperadorCancelamentoFk(null);
                histFuncionariosVinculosCollection1HistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollection1HistFuncionariosVinculos);
            }
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollection1 = pessoaOperadores.getHistUnidadesDiretorCollection1();
            for (HistUnidadesDiretor histUnidadesDiretorCollection1HistUnidadesDiretor : histUnidadesDiretorCollection1) {
                histUnidadesDiretorCollection1HistUnidadesDiretor.setIdOperadorCancelamentoFk(null);
                histUnidadesDiretorCollection1HistUnidadesDiretor = em.merge(histUnidadesDiretorCollection1HistUnidadesDiretor);
            }
            Collection<PessoaFuncionarios> pessoaFuncionariosCollection = pessoaOperadores.getPessoaFuncionariosCollection();
            for (PessoaFuncionarios pessoaFuncionariosCollectionPessoaFuncionarios : pessoaFuncionariosCollection) {
                pessoaFuncionariosCollectionPessoaFuncionarios.setIdOperadorCadastroFk(null);
                pessoaFuncionariosCollectionPessoaFuncionarios = em.merge(pessoaFuncionariosCollectionPessoaFuncionarios);
            }
            Collection<PessoaFuncionarios> pessoaFuncionariosCollection1 = pessoaOperadores.getPessoaFuncionariosCollection1();
            for (PessoaFuncionarios pessoaFuncionariosCollection1PessoaFuncionarios : pessoaFuncionariosCollection1) {
                pessoaFuncionariosCollection1PessoaFuncionarios.setIdOperadorCancelamentoFk(null);
                pessoaFuncionariosCollection1PessoaFuncionarios = em.merge(pessoaFuncionariosCollection1PessoaFuncionarios);
            }
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection1 = pessoaOperadores.getHistFuncionariosUnidadeLotacaoCollection1();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollection1) {
                histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao.setIdOperadorCancelamentoFk(null);
                histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacaoCollection1HistFuncionariosUnidadeLotacao);
            }
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection1 = pessoaOperadores.getHistFuncionariosUnidadeAtuacaoCollection1();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollection1) {
                histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao.setIdOperadorCancelamentoFk(null);
                histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollection1HistFuncionariosUnidadeAtuacao);
            }
            em.remove(pessoaOperadores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaOperadores> findPessoaOperadoresEntities() {
        return findPessoaOperadoresEntities(true, -1, -1);
    }

    public List<PessoaOperadores> findPessoaOperadoresEntities(int maxResults, int firstResult) {
        return findPessoaOperadoresEntities(false, maxResults, firstResult);
    }

    private List<PessoaOperadores> findPessoaOperadoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaOperadores.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PessoaOperadores findPessoaOperadores(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaOperadores.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaOperadoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaOperadores> rt = cq.from(PessoaOperadores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
