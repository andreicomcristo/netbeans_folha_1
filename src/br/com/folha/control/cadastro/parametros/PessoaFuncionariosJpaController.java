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
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.HistFuncionariosAutorizacao;
import java.util.ArrayList;
import java.util.Collection;
import br.com.folha.model.tabelas.HistFuncionariosClasse;
import br.com.folha.model.tabelas.HistFuncionariosCargaHoraria;
import br.com.folha.model.tabelas.HistFuncionariosCargos;
import br.com.folha.model.tabelas.HistFuncionariosCarreira;
import br.com.folha.model.tabelas.HistFuncionariosSituacoes;
import br.com.folha.model.tabelas.Autorizacoes;
import br.com.folha.model.tabelas.HistFuncionariosVinculos;
import br.com.folha.model.tabelas.HistFuncionariosUnidadeAtuacao;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaFuncionariosJpaController implements Serializable {

    public PessoaFuncionariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaFuncionarios pessoaFuncionarios) {
        if (pessoaFuncionarios.getHistFuncionariosAutorizacaoCollection() == null) {
            pessoaFuncionarios.setHistFuncionariosAutorizacaoCollection(new ArrayList<HistFuncionariosAutorizacao>());
        }
        if (pessoaFuncionarios.getHistFuncionariosClasseCollection() == null) {
            pessoaFuncionarios.setHistFuncionariosClasseCollection(new ArrayList<HistFuncionariosClasse>());
        }
        if (pessoaFuncionarios.getHistFuncionariosCargaHorariaCollection() == null) {
            pessoaFuncionarios.setHistFuncionariosCargaHorariaCollection(new ArrayList<HistFuncionariosCargaHoraria>());
        }
        if (pessoaFuncionarios.getHistFuncionariosCargosCollection() == null) {
            pessoaFuncionarios.setHistFuncionariosCargosCollection(new ArrayList<HistFuncionariosCargos>());
        }
        if (pessoaFuncionarios.getHistFuncionariosCarreiraCollection() == null) {
            pessoaFuncionarios.setHistFuncionariosCarreiraCollection(new ArrayList<HistFuncionariosCarreira>());
        }
        if (pessoaFuncionarios.getHistFuncionariosSituacoesCollection() == null) {
            pessoaFuncionarios.setHistFuncionariosSituacoesCollection(new ArrayList<HistFuncionariosSituacoes>());
        }
        if (pessoaFuncionarios.getAutorizacoesCollection() == null) {
            pessoaFuncionarios.setAutorizacoesCollection(new ArrayList<Autorizacoes>());
        }
        if (pessoaFuncionarios.getHistFuncionariosVinculosCollection() == null) {
            pessoaFuncionarios.setHistFuncionariosVinculosCollection(new ArrayList<HistFuncionariosVinculos>());
        }
        if (pessoaFuncionarios.getHistFuncionariosUnidadeAtuacaoCollection() == null) {
            pessoaFuncionarios.setHistFuncionariosUnidadeAtuacaoCollection(new ArrayList<HistFuncionariosUnidadeAtuacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa idPessoaFk = pessoaFuncionarios.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaFuncionarios.setIdPessoaFk(idPessoaFk);
            }
            PessoaOperadores idOperadorCadastroFk = pessoaFuncionarios.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                pessoaFuncionarios.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = pessoaFuncionarios.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                pessoaFuncionarios.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            Collection<HistFuncionariosAutorizacao> attachedHistFuncionariosAutorizacaoCollection = new ArrayList<HistFuncionariosAutorizacao>();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach : pessoaFuncionarios.getHistFuncionariosAutorizacaoCollection()) {
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach = em.getReference(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach.getClass(), histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach.getId());
                attachedHistFuncionariosAutorizacaoCollection.add(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach);
            }
            pessoaFuncionarios.setHistFuncionariosAutorizacaoCollection(attachedHistFuncionariosAutorizacaoCollection);
            Collection<HistFuncionariosClasse> attachedHistFuncionariosClasseCollection = new ArrayList<HistFuncionariosClasse>();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionHistFuncionariosClasseToAttach : pessoaFuncionarios.getHistFuncionariosClasseCollection()) {
                histFuncionariosClasseCollectionHistFuncionariosClasseToAttach = em.getReference(histFuncionariosClasseCollectionHistFuncionariosClasseToAttach.getClass(), histFuncionariosClasseCollectionHistFuncionariosClasseToAttach.getId());
                attachedHistFuncionariosClasseCollection.add(histFuncionariosClasseCollectionHistFuncionariosClasseToAttach);
            }
            pessoaFuncionarios.setHistFuncionariosClasseCollection(attachedHistFuncionariosClasseCollection);
            Collection<HistFuncionariosCargaHoraria> attachedHistFuncionariosCargaHorariaCollection = new ArrayList<HistFuncionariosCargaHoraria>();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach : pessoaFuncionarios.getHistFuncionariosCargaHorariaCollection()) {
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach = em.getReference(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach.getClass(), histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach.getId());
                attachedHistFuncionariosCargaHorariaCollection.add(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach);
            }
            pessoaFuncionarios.setHistFuncionariosCargaHorariaCollection(attachedHistFuncionariosCargaHorariaCollection);
            Collection<HistFuncionariosCargos> attachedHistFuncionariosCargosCollection = new ArrayList<HistFuncionariosCargos>();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionHistFuncionariosCargosToAttach : pessoaFuncionarios.getHistFuncionariosCargosCollection()) {
                histFuncionariosCargosCollectionHistFuncionariosCargosToAttach = em.getReference(histFuncionariosCargosCollectionHistFuncionariosCargosToAttach.getClass(), histFuncionariosCargosCollectionHistFuncionariosCargosToAttach.getId());
                attachedHistFuncionariosCargosCollection.add(histFuncionariosCargosCollectionHistFuncionariosCargosToAttach);
            }
            pessoaFuncionarios.setHistFuncionariosCargosCollection(attachedHistFuncionariosCargosCollection);
            Collection<HistFuncionariosCarreira> attachedHistFuncionariosCarreiraCollection = new ArrayList<HistFuncionariosCarreira>();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach : pessoaFuncionarios.getHistFuncionariosCarreiraCollection()) {
                histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach = em.getReference(histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach.getClass(), histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach.getId());
                attachedHistFuncionariosCarreiraCollection.add(histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach);
            }
            pessoaFuncionarios.setHistFuncionariosCarreiraCollection(attachedHistFuncionariosCarreiraCollection);
            Collection<HistFuncionariosSituacoes> attachedHistFuncionariosSituacoesCollection = new ArrayList<HistFuncionariosSituacoes>();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach : pessoaFuncionarios.getHistFuncionariosSituacoesCollection()) {
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach = em.getReference(histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach.getClass(), histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach.getId());
                attachedHistFuncionariosSituacoesCollection.add(histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach);
            }
            pessoaFuncionarios.setHistFuncionariosSituacoesCollection(attachedHistFuncionariosSituacoesCollection);
            Collection<Autorizacoes> attachedAutorizacoesCollection = new ArrayList<Autorizacoes>();
            for (Autorizacoes autorizacoesCollectionAutorizacoesToAttach : pessoaFuncionarios.getAutorizacoesCollection()) {
                autorizacoesCollectionAutorizacoesToAttach = em.getReference(autorizacoesCollectionAutorizacoesToAttach.getClass(), autorizacoesCollectionAutorizacoesToAttach.getId());
                attachedAutorizacoesCollection.add(autorizacoesCollectionAutorizacoesToAttach);
            }
            pessoaFuncionarios.setAutorizacoesCollection(attachedAutorizacoesCollection);
            Collection<HistFuncionariosVinculos> attachedHistFuncionariosVinculosCollection = new ArrayList<HistFuncionariosVinculos>();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach : pessoaFuncionarios.getHistFuncionariosVinculosCollection()) {
                histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach = em.getReference(histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach.getClass(), histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach.getId());
                attachedHistFuncionariosVinculosCollection.add(histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach);
            }
            pessoaFuncionarios.setHistFuncionariosVinculosCollection(attachedHistFuncionariosVinculosCollection);
            Collection<HistFuncionariosUnidadeAtuacao> attachedHistFuncionariosUnidadeAtuacaoCollection = new ArrayList<HistFuncionariosUnidadeAtuacao>();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach : pessoaFuncionarios.getHistFuncionariosUnidadeAtuacaoCollection()) {
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach = em.getReference(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach.getClass(), histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach.getId());
                attachedHistFuncionariosUnidadeAtuacaoCollection.add(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach);
            }
            pessoaFuncionarios.setHistFuncionariosUnidadeAtuacaoCollection(attachedHistFuncionariosUnidadeAtuacaoCollection);
            em.persist(pessoaFuncionarios);
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaFuncionariosCollection().add(pessoaFuncionarios);
                idPessoaFk = em.merge(idPessoaFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getPessoaFuncionariosCollection().add(pessoaFuncionarios);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getPessoaFuncionariosCollection().add(pessoaFuncionarios);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao : pessoaFuncionarios.getHistFuncionariosAutorizacaoCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.getIdFuncionarioFk();
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.setIdFuncionarioFk(pessoaFuncionarios);
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                if (oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao != null) {
                    oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                    oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = em.merge(oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollectionHistFuncionariosClasse : pessoaFuncionarios.getHistFuncionariosClasseCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse = histFuncionariosClasseCollectionHistFuncionariosClasse.getIdFuncionarioFk();
                histFuncionariosClasseCollectionHistFuncionariosClasse.setIdFuncionarioFk(pessoaFuncionarios);
                histFuncionariosClasseCollectionHistFuncionariosClasse = em.merge(histFuncionariosClasseCollectionHistFuncionariosClasse);
                if (oldIdFuncionarioFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse != null) {
                    oldIdFuncionarioFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse.getHistFuncionariosClasseCollection().remove(histFuncionariosClasseCollectionHistFuncionariosClasse);
                    oldIdFuncionarioFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse = em.merge(oldIdFuncionarioFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse);
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria : pessoaFuncionarios.getHistFuncionariosCargaHorariaCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.getIdFuncionarioFk();
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.setIdFuncionarioFk(pessoaFuncionarios);
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                if (oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria != null) {
                    oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                    oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = em.merge(oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollectionHistFuncionariosCargos : pessoaFuncionarios.getHistFuncionariosCargosCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos = histFuncionariosCargosCollectionHistFuncionariosCargos.getIdFuncionarioFk();
                histFuncionariosCargosCollectionHistFuncionariosCargos.setIdFuncionarioFk(pessoaFuncionarios);
                histFuncionariosCargosCollectionHistFuncionariosCargos = em.merge(histFuncionariosCargosCollectionHistFuncionariosCargos);
                if (oldIdFuncionarioFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos != null) {
                    oldIdFuncionarioFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos.getHistFuncionariosCargosCollection().remove(histFuncionariosCargosCollectionHistFuncionariosCargos);
                    oldIdFuncionarioFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos = em.merge(oldIdFuncionarioFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos);
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionHistFuncionariosCarreira : pessoaFuncionarios.getHistFuncionariosCarreiraCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira = histFuncionariosCarreiraCollectionHistFuncionariosCarreira.getIdFuncionarioFk();
                histFuncionariosCarreiraCollectionHistFuncionariosCarreira.setIdFuncionarioFk(pessoaFuncionarios);
                histFuncionariosCarreiraCollectionHistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                if (oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira != null) {
                    oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                    oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira = em.merge(oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionHistFuncionariosSituacoes : pessoaFuncionarios.getHistFuncionariosSituacoesCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes = histFuncionariosSituacoesCollectionHistFuncionariosSituacoes.getIdFuncionarioFk();
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoes.setIdFuncionarioFk(pessoaFuncionarios);
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                if (oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes != null) {
                    oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                    oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes = em.merge(oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                }
            }
            for (Autorizacoes autorizacoesCollectionAutorizacoes : pessoaFuncionarios.getAutorizacoesCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfAutorizacoesCollectionAutorizacoes = autorizacoesCollectionAutorizacoes.getIdFuncionarioFk();
                autorizacoesCollectionAutorizacoes.setIdFuncionarioFk(pessoaFuncionarios);
                autorizacoesCollectionAutorizacoes = em.merge(autorizacoesCollectionAutorizacoes);
                if (oldIdFuncionarioFkOfAutorizacoesCollectionAutorizacoes != null) {
                    oldIdFuncionarioFkOfAutorizacoesCollectionAutorizacoes.getAutorizacoesCollection().remove(autorizacoesCollectionAutorizacoes);
                    oldIdFuncionarioFkOfAutorizacoesCollectionAutorizacoes = em.merge(oldIdFuncionarioFkOfAutorizacoesCollectionAutorizacoes);
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionHistFuncionariosVinculos : pessoaFuncionarios.getHistFuncionariosVinculosCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos = histFuncionariosVinculosCollectionHistFuncionariosVinculos.getIdFuncionarioFk();
                histFuncionariosVinculosCollectionHistFuncionariosVinculos.setIdFuncionarioFk(pessoaFuncionarios);
                histFuncionariosVinculosCollectionHistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollectionHistFuncionariosVinculos);
                if (oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos != null) {
                    oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculosCollectionHistFuncionariosVinculos);
                    oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos = em.merge(oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos);
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao : pessoaFuncionarios.getHistFuncionariosUnidadeAtuacaoCollection()) {
                PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.getIdFuncionarioFk();
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.setIdFuncionarioFk(pessoaFuncionarios);
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                if (oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao != null) {
                    oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                    oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = em.merge(oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaFuncionarios pessoaFuncionarios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaFuncionarios persistentPessoaFuncionarios = em.find(PessoaFuncionarios.class, pessoaFuncionarios.getId());
            Pessoa idPessoaFkOld = persistentPessoaFuncionarios.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaFuncionarios.getIdPessoaFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentPessoaFuncionarios.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = pessoaFuncionarios.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentPessoaFuncionarios.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = pessoaFuncionarios.getIdOperadorCancelamentoFk();
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionOld = persistentPessoaFuncionarios.getHistFuncionariosAutorizacaoCollection();
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionNew = pessoaFuncionarios.getHistFuncionariosAutorizacaoCollection();
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionOld = persistentPessoaFuncionarios.getHistFuncionariosClasseCollection();
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionNew = pessoaFuncionarios.getHistFuncionariosClasseCollection();
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollectionOld = persistentPessoaFuncionarios.getHistFuncionariosCargaHorariaCollection();
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollectionNew = pessoaFuncionarios.getHistFuncionariosCargaHorariaCollection();
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionOld = persistentPessoaFuncionarios.getHistFuncionariosCargosCollection();
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionNew = pessoaFuncionarios.getHistFuncionariosCargosCollection();
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionOld = persistentPessoaFuncionarios.getHistFuncionariosCarreiraCollection();
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionNew = pessoaFuncionarios.getHistFuncionariosCarreiraCollection();
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollectionOld = persistentPessoaFuncionarios.getHistFuncionariosSituacoesCollection();
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollectionNew = pessoaFuncionarios.getHistFuncionariosSituacoesCollection();
            Collection<Autorizacoes> autorizacoesCollectionOld = persistentPessoaFuncionarios.getAutorizacoesCollection();
            Collection<Autorizacoes> autorizacoesCollectionNew = pessoaFuncionarios.getAutorizacoesCollection();
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionOld = persistentPessoaFuncionarios.getHistFuncionariosVinculosCollection();
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionNew = pessoaFuncionarios.getHistFuncionariosVinculosCollection();
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionOld = persistentPessoaFuncionarios.getHistFuncionariosUnidadeAtuacaoCollection();
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionNew = pessoaFuncionarios.getHistFuncionariosUnidadeAtuacaoCollection();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionOld) {
                if (!histFuncionariosAutorizacaoCollectionNew.contains(histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosAutorizacao " + histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao + " since its idFuncionarioFk field is not nullable.");
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollectionOldHistFuncionariosClasse : histFuncionariosClasseCollectionOld) {
                if (!histFuncionariosClasseCollectionNew.contains(histFuncionariosClasseCollectionOldHistFuncionariosClasse)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosClasse " + histFuncionariosClasseCollectionOldHistFuncionariosClasse + " since its idFuncionarioFk field is not nullable.");
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollectionOld) {
                if (!histFuncionariosCargaHorariaCollectionNew.contains(histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCargaHoraria " + histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria + " since its idFuncionarioFk field is not nullable.");
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollectionOldHistFuncionariosCargos : histFuncionariosCargosCollectionOld) {
                if (!histFuncionariosCargosCollectionNew.contains(histFuncionariosCargosCollectionOldHistFuncionariosCargos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCargos " + histFuncionariosCargosCollectionOldHistFuncionariosCargos + " since its idFuncionarioFk field is not nullable.");
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira : histFuncionariosCarreiraCollectionOld) {
                if (!histFuncionariosCarreiraCollectionNew.contains(histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCarreira " + histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira + " since its idFuncionarioFk field is not nullable.");
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes : histFuncionariosSituacoesCollectionOld) {
                if (!histFuncionariosSituacoesCollectionNew.contains(histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosSituacoes " + histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes + " since its idFuncionarioFk field is not nullable.");
                }
            }
            for (Autorizacoes autorizacoesCollectionOldAutorizacoes : autorizacoesCollectionOld) {
                if (!autorizacoesCollectionNew.contains(autorizacoesCollectionOldAutorizacoes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Autorizacoes " + autorizacoesCollectionOldAutorizacoes + " since its idFuncionarioFk field is not nullable.");
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionOldHistFuncionariosVinculos : histFuncionariosVinculosCollectionOld) {
                if (!histFuncionariosVinculosCollectionNew.contains(histFuncionariosVinculosCollectionOldHistFuncionariosVinculos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosVinculos " + histFuncionariosVinculosCollectionOldHistFuncionariosVinculos + " since its idFuncionarioFk field is not nullable.");
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionOld) {
                if (!histFuncionariosUnidadeAtuacaoCollectionNew.contains(histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosUnidadeAtuacao " + histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao + " since its idFuncionarioFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaFuncionarios.setIdPessoaFk(idPessoaFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                pessoaFuncionarios.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                pessoaFuncionarios.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            Collection<HistFuncionariosAutorizacao> attachedHistFuncionariosAutorizacaoCollectionNew = new ArrayList<HistFuncionariosAutorizacao>();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach : histFuncionariosAutorizacaoCollectionNew) {
                histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach = em.getReference(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach.getClass(), histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach.getId());
                attachedHistFuncionariosAutorizacaoCollectionNew.add(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach);
            }
            histFuncionariosAutorizacaoCollectionNew = attachedHistFuncionariosAutorizacaoCollectionNew;
            pessoaFuncionarios.setHistFuncionariosAutorizacaoCollection(histFuncionariosAutorizacaoCollectionNew);
            Collection<HistFuncionariosClasse> attachedHistFuncionariosClasseCollectionNew = new ArrayList<HistFuncionariosClasse>();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach : histFuncionariosClasseCollectionNew) {
                histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach = em.getReference(histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach.getClass(), histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach.getId());
                attachedHistFuncionariosClasseCollectionNew.add(histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach);
            }
            histFuncionariosClasseCollectionNew = attachedHistFuncionariosClasseCollectionNew;
            pessoaFuncionarios.setHistFuncionariosClasseCollection(histFuncionariosClasseCollectionNew);
            Collection<HistFuncionariosCargaHoraria> attachedHistFuncionariosCargaHorariaCollectionNew = new ArrayList<HistFuncionariosCargaHoraria>();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach : histFuncionariosCargaHorariaCollectionNew) {
                histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach = em.getReference(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach.getClass(), histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach.getId());
                attachedHistFuncionariosCargaHorariaCollectionNew.add(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach);
            }
            histFuncionariosCargaHorariaCollectionNew = attachedHistFuncionariosCargaHorariaCollectionNew;
            pessoaFuncionarios.setHistFuncionariosCargaHorariaCollection(histFuncionariosCargaHorariaCollectionNew);
            Collection<HistFuncionariosCargos> attachedHistFuncionariosCargosCollectionNew = new ArrayList<HistFuncionariosCargos>();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach : histFuncionariosCargosCollectionNew) {
                histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach = em.getReference(histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach.getClass(), histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach.getId());
                attachedHistFuncionariosCargosCollectionNew.add(histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach);
            }
            histFuncionariosCargosCollectionNew = attachedHistFuncionariosCargosCollectionNew;
            pessoaFuncionarios.setHistFuncionariosCargosCollection(histFuncionariosCargosCollectionNew);
            Collection<HistFuncionariosCarreira> attachedHistFuncionariosCarreiraCollectionNew = new ArrayList<HistFuncionariosCarreira>();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach : histFuncionariosCarreiraCollectionNew) {
                histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach = em.getReference(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach.getClass(), histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach.getId());
                attachedHistFuncionariosCarreiraCollectionNew.add(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach);
            }
            histFuncionariosCarreiraCollectionNew = attachedHistFuncionariosCarreiraCollectionNew;
            pessoaFuncionarios.setHistFuncionariosCarreiraCollection(histFuncionariosCarreiraCollectionNew);
            Collection<HistFuncionariosSituacoes> attachedHistFuncionariosSituacoesCollectionNew = new ArrayList<HistFuncionariosSituacoes>();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach : histFuncionariosSituacoesCollectionNew) {
                histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach = em.getReference(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach.getClass(), histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach.getId());
                attachedHistFuncionariosSituacoesCollectionNew.add(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach);
            }
            histFuncionariosSituacoesCollectionNew = attachedHistFuncionariosSituacoesCollectionNew;
            pessoaFuncionarios.setHistFuncionariosSituacoesCollection(histFuncionariosSituacoesCollectionNew);
            Collection<Autorizacoes> attachedAutorizacoesCollectionNew = new ArrayList<Autorizacoes>();
            for (Autorizacoes autorizacoesCollectionNewAutorizacoesToAttach : autorizacoesCollectionNew) {
                autorizacoesCollectionNewAutorizacoesToAttach = em.getReference(autorizacoesCollectionNewAutorizacoesToAttach.getClass(), autorizacoesCollectionNewAutorizacoesToAttach.getId());
                attachedAutorizacoesCollectionNew.add(autorizacoesCollectionNewAutorizacoesToAttach);
            }
            autorizacoesCollectionNew = attachedAutorizacoesCollectionNew;
            pessoaFuncionarios.setAutorizacoesCollection(autorizacoesCollectionNew);
            Collection<HistFuncionariosVinculos> attachedHistFuncionariosVinculosCollectionNew = new ArrayList<HistFuncionariosVinculos>();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach : histFuncionariosVinculosCollectionNew) {
                histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach = em.getReference(histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach.getClass(), histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach.getId());
                attachedHistFuncionariosVinculosCollectionNew.add(histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach);
            }
            histFuncionariosVinculosCollectionNew = attachedHistFuncionariosVinculosCollectionNew;
            pessoaFuncionarios.setHistFuncionariosVinculosCollection(histFuncionariosVinculosCollectionNew);
            Collection<HistFuncionariosUnidadeAtuacao> attachedHistFuncionariosUnidadeAtuacaoCollectionNew = new ArrayList<HistFuncionariosUnidadeAtuacao>();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach : histFuncionariosUnidadeAtuacaoCollectionNew) {
                histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach = em.getReference(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach.getClass(), histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach.getId());
                attachedHistFuncionariosUnidadeAtuacaoCollectionNew.add(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach);
            }
            histFuncionariosUnidadeAtuacaoCollectionNew = attachedHistFuncionariosUnidadeAtuacaoCollectionNew;
            pessoaFuncionarios.setHistFuncionariosUnidadeAtuacaoCollection(histFuncionariosUnidadeAtuacaoCollectionNew);
            pessoaFuncionarios = em.merge(pessoaFuncionarios);
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaFuncionariosCollection().remove(pessoaFuncionarios);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaFuncionariosCollection().add(pessoaFuncionarios);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getPessoaFuncionariosCollection().remove(pessoaFuncionarios);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getPessoaFuncionariosCollection().add(pessoaFuncionarios);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getPessoaFuncionariosCollection().remove(pessoaFuncionarios);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getPessoaFuncionariosCollection().add(pessoaFuncionarios);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionNew) {
                if (!histFuncionariosAutorizacaoCollectionOld.contains(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.getIdFuncionarioFk();
                    histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.setIdFuncionarioFk(pessoaFuncionarios);
                    histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                    if (oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao != null && !oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                        oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = em.merge(oldIdFuncionarioFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                    }
                }
            }
            for (HistFuncionariosClasse histFuncionariosClasseCollectionNewHistFuncionariosClasse : histFuncionariosClasseCollectionNew) {
                if (!histFuncionariosClasseCollectionOld.contains(histFuncionariosClasseCollectionNewHistFuncionariosClasse)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse = histFuncionariosClasseCollectionNewHistFuncionariosClasse.getIdFuncionarioFk();
                    histFuncionariosClasseCollectionNewHistFuncionariosClasse.setIdFuncionarioFk(pessoaFuncionarios);
                    histFuncionariosClasseCollectionNewHistFuncionariosClasse = em.merge(histFuncionariosClasseCollectionNewHistFuncionariosClasse);
                    if (oldIdFuncionarioFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse != null && !oldIdFuncionarioFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse.getHistFuncionariosClasseCollection().remove(histFuncionariosClasseCollectionNewHistFuncionariosClasse);
                        oldIdFuncionarioFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse = em.merge(oldIdFuncionarioFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse);
                    }
                }
            }
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollectionNew) {
                if (!histFuncionariosCargaHorariaCollectionOld.contains(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.getIdFuncionarioFk();
                    histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.setIdFuncionarioFk(pessoaFuncionarios);
                    histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                    if (oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria != null && !oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                        oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = em.merge(oldIdFuncionarioFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                    }
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollectionNewHistFuncionariosCargos : histFuncionariosCargosCollectionNew) {
                if (!histFuncionariosCargosCollectionOld.contains(histFuncionariosCargosCollectionNewHistFuncionariosCargos)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos = histFuncionariosCargosCollectionNewHistFuncionariosCargos.getIdFuncionarioFk();
                    histFuncionariosCargosCollectionNewHistFuncionariosCargos.setIdFuncionarioFk(pessoaFuncionarios);
                    histFuncionariosCargosCollectionNewHistFuncionariosCargos = em.merge(histFuncionariosCargosCollectionNewHistFuncionariosCargos);
                    if (oldIdFuncionarioFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos != null && !oldIdFuncionarioFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos.getHistFuncionariosCargosCollection().remove(histFuncionariosCargosCollectionNewHistFuncionariosCargos);
                        oldIdFuncionarioFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos = em.merge(oldIdFuncionarioFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos);
                    }
                }
            }
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira : histFuncionariosCarreiraCollectionNew) {
                if (!histFuncionariosCarreiraCollectionOld.contains(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.getIdFuncionarioFk();
                    histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.setIdFuncionarioFk(pessoaFuncionarios);
                    histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                    if (oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira != null && !oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                        oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = em.merge(oldIdFuncionarioFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                    }
                }
            }
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes : histFuncionariosSituacoesCollectionNew) {
                if (!histFuncionariosSituacoesCollectionOld.contains(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.getIdFuncionarioFk();
                    histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.setIdFuncionarioFk(pessoaFuncionarios);
                    histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                    if (oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes != null && !oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                        oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = em.merge(oldIdFuncionarioFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                    }
                }
            }
            for (Autorizacoes autorizacoesCollectionNewAutorizacoes : autorizacoesCollectionNew) {
                if (!autorizacoesCollectionOld.contains(autorizacoesCollectionNewAutorizacoes)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfAutorizacoesCollectionNewAutorizacoes = autorizacoesCollectionNewAutorizacoes.getIdFuncionarioFk();
                    autorizacoesCollectionNewAutorizacoes.setIdFuncionarioFk(pessoaFuncionarios);
                    autorizacoesCollectionNewAutorizacoes = em.merge(autorizacoesCollectionNewAutorizacoes);
                    if (oldIdFuncionarioFkOfAutorizacoesCollectionNewAutorizacoes != null && !oldIdFuncionarioFkOfAutorizacoesCollectionNewAutorizacoes.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfAutorizacoesCollectionNewAutorizacoes.getAutorizacoesCollection().remove(autorizacoesCollectionNewAutorizacoes);
                        oldIdFuncionarioFkOfAutorizacoesCollectionNewAutorizacoes = em.merge(oldIdFuncionarioFkOfAutorizacoesCollectionNewAutorizacoes);
                    }
                }
            }
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionNewHistFuncionariosVinculos : histFuncionariosVinculosCollectionNew) {
                if (!histFuncionariosVinculosCollectionOld.contains(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos = histFuncionariosVinculosCollectionNewHistFuncionariosVinculos.getIdFuncionarioFk();
                    histFuncionariosVinculosCollectionNewHistFuncionariosVinculos.setIdFuncionarioFk(pessoaFuncionarios);
                    histFuncionariosVinculosCollectionNewHistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                    if (oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos != null && !oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                        oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos = em.merge(oldIdFuncionarioFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                    }
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionNew) {
                if (!histFuncionariosUnidadeAtuacaoCollectionOld.contains(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao)) {
                    PessoaFuncionarios oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.getIdFuncionarioFk();
                    histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.setIdFuncionarioFk(pessoaFuncionarios);
                    histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                    if (oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao != null && !oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.equals(pessoaFuncionarios)) {
                        oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                        oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = em.merge(oldIdFuncionarioFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaFuncionarios.getId();
                if (findPessoaFuncionarios(id) == null) {
                    throw new NonexistentEntityException("The pessoaFuncionarios with id " + id + " no longer exists.");
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
            PessoaFuncionarios pessoaFuncionarios;
            try {
                pessoaFuncionarios = em.getReference(PessoaFuncionarios.class, id);
                pessoaFuncionarios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaFuncionarios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionOrphanCheck = pessoaFuncionarios.getHistFuncionariosAutorizacaoCollection();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionOrphanCheckHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the HistFuncionariosAutorizacao " + histFuncionariosAutorizacaoCollectionOrphanCheckHistFuncionariosAutorizacao + " in its histFuncionariosAutorizacaoCollection field has a non-nullable idFuncionarioFk field.");
            }
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionOrphanCheck = pessoaFuncionarios.getHistFuncionariosClasseCollection();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionOrphanCheckHistFuncionariosClasse : histFuncionariosClasseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the HistFuncionariosClasse " + histFuncionariosClasseCollectionOrphanCheckHistFuncionariosClasse + " in its histFuncionariosClasseCollection field has a non-nullable idFuncionarioFk field.");
            }
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollectionOrphanCheck = pessoaFuncionarios.getHistFuncionariosCargaHorariaCollection();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionOrphanCheckHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the HistFuncionariosCargaHoraria " + histFuncionariosCargaHorariaCollectionOrphanCheckHistFuncionariosCargaHoraria + " in its histFuncionariosCargaHorariaCollection field has a non-nullable idFuncionarioFk field.");
            }
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionOrphanCheck = pessoaFuncionarios.getHistFuncionariosCargosCollection();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionOrphanCheckHistFuncionariosCargos : histFuncionariosCargosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the HistFuncionariosCargos " + histFuncionariosCargosCollectionOrphanCheckHistFuncionariosCargos + " in its histFuncionariosCargosCollection field has a non-nullable idFuncionarioFk field.");
            }
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionOrphanCheck = pessoaFuncionarios.getHistFuncionariosCarreiraCollection();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionOrphanCheckHistFuncionariosCarreira : histFuncionariosCarreiraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the HistFuncionariosCarreira " + histFuncionariosCarreiraCollectionOrphanCheckHistFuncionariosCarreira + " in its histFuncionariosCarreiraCollection field has a non-nullable idFuncionarioFk field.");
            }
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollectionOrphanCheck = pessoaFuncionarios.getHistFuncionariosSituacoesCollection();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionOrphanCheckHistFuncionariosSituacoes : histFuncionariosSituacoesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the HistFuncionariosSituacoes " + histFuncionariosSituacoesCollectionOrphanCheckHistFuncionariosSituacoes + " in its histFuncionariosSituacoesCollection field has a non-nullable idFuncionarioFk field.");
            }
            Collection<Autorizacoes> autorizacoesCollectionOrphanCheck = pessoaFuncionarios.getAutorizacoesCollection();
            for (Autorizacoes autorizacoesCollectionOrphanCheckAutorizacoes : autorizacoesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the Autorizacoes " + autorizacoesCollectionOrphanCheckAutorizacoes + " in its autorizacoesCollection field has a non-nullable idFuncionarioFk field.");
            }
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionOrphanCheck = pessoaFuncionarios.getHistFuncionariosVinculosCollection();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionOrphanCheckHistFuncionariosVinculos : histFuncionariosVinculosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the HistFuncionariosVinculos " + histFuncionariosVinculosCollectionOrphanCheckHistFuncionariosVinculos + " in its histFuncionariosVinculosCollection field has a non-nullable idFuncionarioFk field.");
            }
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionOrphanCheck = pessoaFuncionarios.getHistFuncionariosUnidadeAtuacaoCollection();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionOrphanCheckHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PessoaFuncionarios (" + pessoaFuncionarios + ") cannot be destroyed since the HistFuncionariosUnidadeAtuacao " + histFuncionariosUnidadeAtuacaoCollectionOrphanCheckHistFuncionariosUnidadeAtuacao + " in its histFuncionariosUnidadeAtuacaoCollection field has a non-nullable idFuncionarioFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Pessoa idPessoaFk = pessoaFuncionarios.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaFuncionariosCollection().remove(pessoaFuncionarios);
                idPessoaFk = em.merge(idPessoaFk);
            }
            PessoaOperadores idOperadorCadastroFk = pessoaFuncionarios.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getPessoaFuncionariosCollection().remove(pessoaFuncionarios);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = pessoaFuncionarios.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getPessoaFuncionariosCollection().remove(pessoaFuncionarios);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.remove(pessoaFuncionarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaFuncionarios> findPessoaFuncionariosEntities() {
        return findPessoaFuncionariosEntities(true, -1, -1);
    }

    public List<PessoaFuncionarios> findPessoaFuncionariosEntities(int maxResults, int firstResult) {
        return findPessoaFuncionariosEntities(false, maxResults, firstResult);
    }

    private List<PessoaFuncionarios> findPessoaFuncionariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaFuncionarios.class));
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

    public PessoaFuncionarios findPessoaFuncionarios(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaFuncionarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaFuncionariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaFuncionarios> rt = cq.from(PessoaFuncionarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
