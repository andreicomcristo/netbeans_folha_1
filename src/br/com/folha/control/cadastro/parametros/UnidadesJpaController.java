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
import br.com.folha.model.tabelas.Cidades;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.TiposLogradouro;
import br.com.folha.model.tabelas.HistUnidadesRegime;
import java.util.ArrayList;
import java.util.Collection;
import br.com.folha.model.tabelas.Autorizacoes;
import br.com.folha.model.tabelas.HistUnidadesDiretor;
import br.com.folha.model.tabelas.HistFuncionariosUnidadeLotacao;
import br.com.folha.model.tabelas.HistFuncionariosUnidadeAtuacao;
import br.com.folha.model.tabelas.Unidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class UnidadesJpaController implements Serializable {

    public UnidadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Unidades unidades) {
        if (unidades.getHistUnidadesRegimeCollection() == null) {
            unidades.setHistUnidadesRegimeCollection(new ArrayList<HistUnidadesRegime>());
        }
        if (unidades.getAutorizacoesCollection() == null) {
            unidades.setAutorizacoesCollection(new ArrayList<Autorizacoes>());
        }
        if (unidades.getHistUnidadesDiretorCollection() == null) {
            unidades.setHistUnidadesDiretorCollection(new ArrayList<HistUnidadesDiretor>());
        }
        if (unidades.getHistFuncionariosUnidadeLotacaoCollection() == null) {
            unidades.setHistFuncionariosUnidadeLotacaoCollection(new ArrayList<HistFuncionariosUnidadeLotacao>());
        }
        if (unidades.getHistFuncionariosUnidadeAtuacaoCollection() == null) {
            unidades.setHistFuncionariosUnidadeAtuacaoCollection(new ArrayList<HistFuncionariosUnidadeAtuacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cidades idEnderecoCidadeFk = unidades.getIdEnderecoCidadeFk();
            if (idEnderecoCidadeFk != null) {
                idEnderecoCidadeFk = em.getReference(idEnderecoCidadeFk.getClass(), idEnderecoCidadeFk.getId());
                unidades.setIdEnderecoCidadeFk(idEnderecoCidadeFk);
            }
            PessoaOperadores idOperadorCadastroFk = unidades.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                unidades.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = unidades.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                unidades.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            TiposLogradouro idTipoLogradouroFk = unidades.getIdTipoLogradouroFk();
            if (idTipoLogradouroFk != null) {
                idTipoLogradouroFk = em.getReference(idTipoLogradouroFk.getClass(), idTipoLogradouroFk.getId());
                unidades.setIdTipoLogradouroFk(idTipoLogradouroFk);
            }
            Collection<HistUnidadesRegime> attachedHistUnidadesRegimeCollection = new ArrayList<HistUnidadesRegime>();
            for (HistUnidadesRegime histUnidadesRegimeCollectionHistUnidadesRegimeToAttach : unidades.getHistUnidadesRegimeCollection()) {
                histUnidadesRegimeCollectionHistUnidadesRegimeToAttach = em.getReference(histUnidadesRegimeCollectionHistUnidadesRegimeToAttach.getClass(), histUnidadesRegimeCollectionHistUnidadesRegimeToAttach.getId());
                attachedHistUnidadesRegimeCollection.add(histUnidadesRegimeCollectionHistUnidadesRegimeToAttach);
            }
            unidades.setHistUnidadesRegimeCollection(attachedHistUnidadesRegimeCollection);
            Collection<Autorizacoes> attachedAutorizacoesCollection = new ArrayList<Autorizacoes>();
            for (Autorizacoes autorizacoesCollectionAutorizacoesToAttach : unidades.getAutorizacoesCollection()) {
                autorizacoesCollectionAutorizacoesToAttach = em.getReference(autorizacoesCollectionAutorizacoesToAttach.getClass(), autorizacoesCollectionAutorizacoesToAttach.getId());
                attachedAutorizacoesCollection.add(autorizacoesCollectionAutorizacoesToAttach);
            }
            unidades.setAutorizacoesCollection(attachedAutorizacoesCollection);
            Collection<HistUnidadesDiretor> attachedHistUnidadesDiretorCollection = new ArrayList<HistUnidadesDiretor>();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionHistUnidadesDiretorToAttach : unidades.getHistUnidadesDiretorCollection()) {
                histUnidadesDiretorCollectionHistUnidadesDiretorToAttach = em.getReference(histUnidadesDiretorCollectionHistUnidadesDiretorToAttach.getClass(), histUnidadesDiretorCollectionHistUnidadesDiretorToAttach.getHistUnidadesDiretorPK());
                attachedHistUnidadesDiretorCollection.add(histUnidadesDiretorCollectionHistUnidadesDiretorToAttach);
            }
            unidades.setHistUnidadesDiretorCollection(attachedHistUnidadesDiretorCollection);
            Collection<HistFuncionariosUnidadeLotacao> attachedHistFuncionariosUnidadeLotacaoCollection = new ArrayList<HistFuncionariosUnidadeLotacao>();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach : unidades.getHistFuncionariosUnidadeLotacaoCollection()) {
                histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach = em.getReference(histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach.getClass(), histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach.getId());
                attachedHistFuncionariosUnidadeLotacaoCollection.add(histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacaoToAttach);
            }
            unidades.setHistFuncionariosUnidadeLotacaoCollection(attachedHistFuncionariosUnidadeLotacaoCollection);
            Collection<HistFuncionariosUnidadeAtuacao> attachedHistFuncionariosUnidadeAtuacaoCollection = new ArrayList<HistFuncionariosUnidadeAtuacao>();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach : unidades.getHistFuncionariosUnidadeAtuacaoCollection()) {
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach = em.getReference(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach.getClass(), histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach.getId());
                attachedHistFuncionariosUnidadeAtuacaoCollection.add(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacaoToAttach);
            }
            unidades.setHistFuncionariosUnidadeAtuacaoCollection(attachedHistFuncionariosUnidadeAtuacaoCollection);
            em.persist(unidades);
            if (idEnderecoCidadeFk != null) {
                idEnderecoCidadeFk.getUnidadesCollection().add(unidades);
                idEnderecoCidadeFk = em.merge(idEnderecoCidadeFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getUnidadesCollection().add(unidades);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getUnidadesCollection().add(unidades);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idTipoLogradouroFk != null) {
                idTipoLogradouroFk.getUnidadesCollection().add(unidades);
                idTipoLogradouroFk = em.merge(idTipoLogradouroFk);
            }
            for (HistUnidadesRegime histUnidadesRegimeCollectionHistUnidadesRegime : unidades.getHistUnidadesRegimeCollection()) {
                Unidades oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime = histUnidadesRegimeCollectionHistUnidadesRegime.getIdUnidadeDeSaudeFk();
                histUnidadesRegimeCollectionHistUnidadesRegime.setIdUnidadeDeSaudeFk(unidades);
                histUnidadesRegimeCollectionHistUnidadesRegime = em.merge(histUnidadesRegimeCollectionHistUnidadesRegime);
                if (oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime != null) {
                    oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime.getHistUnidadesRegimeCollection().remove(histUnidadesRegimeCollectionHistUnidadesRegime);
                    oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime = em.merge(oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime);
                }
            }
            for (Autorizacoes autorizacoesCollectionAutorizacoes : unidades.getAutorizacoesCollection()) {
                Unidades oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionAutorizacoes = autorizacoesCollectionAutorizacoes.getIdUnidadeDeSaudeFk();
                autorizacoesCollectionAutorizacoes.setIdUnidadeDeSaudeFk(unidades);
                autorizacoesCollectionAutorizacoes = em.merge(autorizacoesCollectionAutorizacoes);
                if (oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionAutorizacoes != null) {
                    oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionAutorizacoes.getAutorizacoesCollection().remove(autorizacoesCollectionAutorizacoes);
                    oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionAutorizacoes = em.merge(oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionAutorizacoes);
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionHistUnidadesDiretor : unidades.getHistUnidadesDiretorCollection()) {
                Unidades oldUnidadesOfHistUnidadesDiretorCollectionHistUnidadesDiretor = histUnidadesDiretorCollectionHistUnidadesDiretor.getUnidades();
                histUnidadesDiretorCollectionHistUnidadesDiretor.setUnidades(unidades);
                histUnidadesDiretorCollectionHistUnidadesDiretor = em.merge(histUnidadesDiretorCollectionHistUnidadesDiretor);
                if (oldUnidadesOfHistUnidadesDiretorCollectionHistUnidadesDiretor != null) {
                    oldUnidadesOfHistUnidadesDiretorCollectionHistUnidadesDiretor.getHistUnidadesDiretorCollection().remove(histUnidadesDiretorCollectionHistUnidadesDiretor);
                    oldUnidadesOfHistUnidadesDiretorCollectionHistUnidadesDiretor = em.merge(oldUnidadesOfHistUnidadesDiretorCollectionHistUnidadesDiretor);
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao : unidades.getHistFuncionariosUnidadeLotacaoCollection()) {
                Unidades oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao = histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao.getIdUnidadeFk();
                histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao.setIdUnidadeFk(unidades);
                histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao);
                if (oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao != null) {
                    oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao);
                    oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao = em.merge(oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionHistFuncionariosUnidadeLotacao);
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao : unidades.getHistFuncionariosUnidadeAtuacaoCollection()) {
                Unidades oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.getIdUnidadeFk();
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.setIdUnidadeFk(unidades);
                histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                if (oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao != null) {
                    oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                    oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao = em.merge(oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionHistFuncionariosUnidadeAtuacao);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Unidades unidades) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Unidades persistentUnidades = em.find(Unidades.class, unidades.getId());
            Cidades idEnderecoCidadeFkOld = persistentUnidades.getIdEnderecoCidadeFk();
            Cidades idEnderecoCidadeFkNew = unidades.getIdEnderecoCidadeFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentUnidades.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = unidades.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentUnidades.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = unidades.getIdOperadorCancelamentoFk();
            TiposLogradouro idTipoLogradouroFkOld = persistentUnidades.getIdTipoLogradouroFk();
            TiposLogradouro idTipoLogradouroFkNew = unidades.getIdTipoLogradouroFk();
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionOld = persistentUnidades.getHistUnidadesRegimeCollection();
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionNew = unidades.getHistUnidadesRegimeCollection();
            Collection<Autorizacoes> autorizacoesCollectionOld = persistentUnidades.getAutorizacoesCollection();
            Collection<Autorizacoes> autorizacoesCollectionNew = unidades.getAutorizacoesCollection();
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionOld = persistentUnidades.getHistUnidadesDiretorCollection();
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionNew = unidades.getHistUnidadesDiretorCollection();
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollectionOld = persistentUnidades.getHistFuncionariosUnidadeLotacaoCollection();
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollectionNew = unidades.getHistFuncionariosUnidadeLotacaoCollection();
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionOld = persistentUnidades.getHistFuncionariosUnidadeAtuacaoCollection();
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionNew = unidades.getHistFuncionariosUnidadeAtuacaoCollection();
            List<String> illegalOrphanMessages = null;
            for (HistUnidadesRegime histUnidadesRegimeCollectionOldHistUnidadesRegime : histUnidadesRegimeCollectionOld) {
                if (!histUnidadesRegimeCollectionNew.contains(histUnidadesRegimeCollectionOldHistUnidadesRegime)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistUnidadesRegime " + histUnidadesRegimeCollectionOldHistUnidadesRegime + " since its idUnidadeDeSaudeFk field is not nullable.");
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionOldHistUnidadesDiretor : histUnidadesDiretorCollectionOld) {
                if (!histUnidadesDiretorCollectionNew.contains(histUnidadesDiretorCollectionOldHistUnidadesDiretor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistUnidadesDiretor " + histUnidadesDiretorCollectionOldHistUnidadesDiretor + " since its unidades field is not nullable.");
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionOldHistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollectionOld) {
                if (!histFuncionariosUnidadeLotacaoCollectionNew.contains(histFuncionariosUnidadeLotacaoCollectionOldHistFuncionariosUnidadeLotacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosUnidadeLotacao " + histFuncionariosUnidadeLotacaoCollectionOldHistFuncionariosUnidadeLotacao + " since its idUnidadeFk field is not nullable.");
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionOld) {
                if (!histFuncionariosUnidadeAtuacaoCollectionNew.contains(histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosUnidadeAtuacao " + histFuncionariosUnidadeAtuacaoCollectionOldHistFuncionariosUnidadeAtuacao + " since its idUnidadeFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEnderecoCidadeFkNew != null) {
                idEnderecoCidadeFkNew = em.getReference(idEnderecoCidadeFkNew.getClass(), idEnderecoCidadeFkNew.getId());
                unidades.setIdEnderecoCidadeFk(idEnderecoCidadeFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                unidades.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                unidades.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idTipoLogradouroFkNew != null) {
                idTipoLogradouroFkNew = em.getReference(idTipoLogradouroFkNew.getClass(), idTipoLogradouroFkNew.getId());
                unidades.setIdTipoLogradouroFk(idTipoLogradouroFkNew);
            }
            Collection<HistUnidadesRegime> attachedHistUnidadesRegimeCollectionNew = new ArrayList<HistUnidadesRegime>();
            for (HistUnidadesRegime histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach : histUnidadesRegimeCollectionNew) {
                histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach = em.getReference(histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach.getClass(), histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach.getId());
                attachedHistUnidadesRegimeCollectionNew.add(histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach);
            }
            histUnidadesRegimeCollectionNew = attachedHistUnidadesRegimeCollectionNew;
            unidades.setHistUnidadesRegimeCollection(histUnidadesRegimeCollectionNew);
            Collection<Autorizacoes> attachedAutorizacoesCollectionNew = new ArrayList<Autorizacoes>();
            for (Autorizacoes autorizacoesCollectionNewAutorizacoesToAttach : autorizacoesCollectionNew) {
                autorizacoesCollectionNewAutorizacoesToAttach = em.getReference(autorizacoesCollectionNewAutorizacoesToAttach.getClass(), autorizacoesCollectionNewAutorizacoesToAttach.getId());
                attachedAutorizacoesCollectionNew.add(autorizacoesCollectionNewAutorizacoesToAttach);
            }
            autorizacoesCollectionNew = attachedAutorizacoesCollectionNew;
            unidades.setAutorizacoesCollection(autorizacoesCollectionNew);
            Collection<HistUnidadesDiretor> attachedHistUnidadesDiretorCollectionNew = new ArrayList<HistUnidadesDiretor>();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach : histUnidadesDiretorCollectionNew) {
                histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach = em.getReference(histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach.getClass(), histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach.getHistUnidadesDiretorPK());
                attachedHistUnidadesDiretorCollectionNew.add(histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach);
            }
            histUnidadesDiretorCollectionNew = attachedHistUnidadesDiretorCollectionNew;
            unidades.setHistUnidadesDiretorCollection(histUnidadesDiretorCollectionNew);
            Collection<HistFuncionariosUnidadeLotacao> attachedHistFuncionariosUnidadeLotacaoCollectionNew = new ArrayList<HistFuncionariosUnidadeLotacao>();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach : histFuncionariosUnidadeLotacaoCollectionNew) {
                histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach = em.getReference(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach.getClass(), histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach.getId());
                attachedHistFuncionariosUnidadeLotacaoCollectionNew.add(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacaoToAttach);
            }
            histFuncionariosUnidadeLotacaoCollectionNew = attachedHistFuncionariosUnidadeLotacaoCollectionNew;
            unidades.setHistFuncionariosUnidadeLotacaoCollection(histFuncionariosUnidadeLotacaoCollectionNew);
            Collection<HistFuncionariosUnidadeAtuacao> attachedHistFuncionariosUnidadeAtuacaoCollectionNew = new ArrayList<HistFuncionariosUnidadeAtuacao>();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach : histFuncionariosUnidadeAtuacaoCollectionNew) {
                histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach = em.getReference(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach.getClass(), histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach.getId());
                attachedHistFuncionariosUnidadeAtuacaoCollectionNew.add(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacaoToAttach);
            }
            histFuncionariosUnidadeAtuacaoCollectionNew = attachedHistFuncionariosUnidadeAtuacaoCollectionNew;
            unidades.setHistFuncionariosUnidadeAtuacaoCollection(histFuncionariosUnidadeAtuacaoCollectionNew);
            unidades = em.merge(unidades);
            if (idEnderecoCidadeFkOld != null && !idEnderecoCidadeFkOld.equals(idEnderecoCidadeFkNew)) {
                idEnderecoCidadeFkOld.getUnidadesCollection().remove(unidades);
                idEnderecoCidadeFkOld = em.merge(idEnderecoCidadeFkOld);
            }
            if (idEnderecoCidadeFkNew != null && !idEnderecoCidadeFkNew.equals(idEnderecoCidadeFkOld)) {
                idEnderecoCidadeFkNew.getUnidadesCollection().add(unidades);
                idEnderecoCidadeFkNew = em.merge(idEnderecoCidadeFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getUnidadesCollection().remove(unidades);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getUnidadesCollection().add(unidades);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getUnidadesCollection().remove(unidades);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getUnidadesCollection().add(unidades);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idTipoLogradouroFkOld != null && !idTipoLogradouroFkOld.equals(idTipoLogradouroFkNew)) {
                idTipoLogradouroFkOld.getUnidadesCollection().remove(unidades);
                idTipoLogradouroFkOld = em.merge(idTipoLogradouroFkOld);
            }
            if (idTipoLogradouroFkNew != null && !idTipoLogradouroFkNew.equals(idTipoLogradouroFkOld)) {
                idTipoLogradouroFkNew.getUnidadesCollection().add(unidades);
                idTipoLogradouroFkNew = em.merge(idTipoLogradouroFkNew);
            }
            for (HistUnidadesRegime histUnidadesRegimeCollectionNewHistUnidadesRegime : histUnidadesRegimeCollectionNew) {
                if (!histUnidadesRegimeCollectionOld.contains(histUnidadesRegimeCollectionNewHistUnidadesRegime)) {
                    Unidades oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime = histUnidadesRegimeCollectionNewHistUnidadesRegime.getIdUnidadeDeSaudeFk();
                    histUnidadesRegimeCollectionNewHistUnidadesRegime.setIdUnidadeDeSaudeFk(unidades);
                    histUnidadesRegimeCollectionNewHistUnidadesRegime = em.merge(histUnidadesRegimeCollectionNewHistUnidadesRegime);
                    if (oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime != null && !oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime.equals(unidades)) {
                        oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime.getHistUnidadesRegimeCollection().remove(histUnidadesRegimeCollectionNewHistUnidadesRegime);
                        oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime = em.merge(oldIdUnidadeDeSaudeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime);
                    }
                }
            }
            for (Autorizacoes autorizacoesCollectionOldAutorizacoes : autorizacoesCollectionOld) {
                if (!autorizacoesCollectionNew.contains(autorizacoesCollectionOldAutorizacoes)) {
                    autorizacoesCollectionOldAutorizacoes.setIdUnidadeDeSaudeFk(null);
                    autorizacoesCollectionOldAutorizacoes = em.merge(autorizacoesCollectionOldAutorizacoes);
                }
            }
            for (Autorizacoes autorizacoesCollectionNewAutorizacoes : autorizacoesCollectionNew) {
                if (!autorizacoesCollectionOld.contains(autorizacoesCollectionNewAutorizacoes)) {
                    Unidades oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionNewAutorizacoes = autorizacoesCollectionNewAutorizacoes.getIdUnidadeDeSaudeFk();
                    autorizacoesCollectionNewAutorizacoes.setIdUnidadeDeSaudeFk(unidades);
                    autorizacoesCollectionNewAutorizacoes = em.merge(autorizacoesCollectionNewAutorizacoes);
                    if (oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionNewAutorizacoes != null && !oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionNewAutorizacoes.equals(unidades)) {
                        oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionNewAutorizacoes.getAutorizacoesCollection().remove(autorizacoesCollectionNewAutorizacoes);
                        oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionNewAutorizacoes = em.merge(oldIdUnidadeDeSaudeFkOfAutorizacoesCollectionNewAutorizacoes);
                    }
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionNewHistUnidadesDiretor : histUnidadesDiretorCollectionNew) {
                if (!histUnidadesDiretorCollectionOld.contains(histUnidadesDiretorCollectionNewHistUnidadesDiretor)) {
                    Unidades oldUnidadesOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor = histUnidadesDiretorCollectionNewHistUnidadesDiretor.getUnidades();
                    histUnidadesDiretorCollectionNewHistUnidadesDiretor.setUnidades(unidades);
                    histUnidadesDiretorCollectionNewHistUnidadesDiretor = em.merge(histUnidadesDiretorCollectionNewHistUnidadesDiretor);
                    if (oldUnidadesOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor != null && !oldUnidadesOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor.equals(unidades)) {
                        oldUnidadesOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor.getHistUnidadesDiretorCollection().remove(histUnidadesDiretorCollectionNewHistUnidadesDiretor);
                        oldUnidadesOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor = em.merge(oldUnidadesOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor);
                    }
                }
            }
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollectionNew) {
                if (!histFuncionariosUnidadeLotacaoCollectionOld.contains(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao)) {
                    Unidades oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao = histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao.getIdUnidadeFk();
                    histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao.setIdUnidadeFk(unidades);
                    histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao);
                    if (oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao != null && !oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao.equals(unidades)) {
                        oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao);
                        oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao = em.merge(oldIdUnidadeFkOfHistFuncionariosUnidadeLotacaoCollectionNewHistFuncionariosUnidadeLotacao);
                    }
                }
            }
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionNew) {
                if (!histFuncionariosUnidadeAtuacaoCollectionOld.contains(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao)) {
                    Unidades oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.getIdUnidadeFk();
                    histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.setIdUnidadeFk(unidades);
                    histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                    if (oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao != null && !oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.equals(unidades)) {
                        oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                        oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao = em.merge(oldIdUnidadeFkOfHistFuncionariosUnidadeAtuacaoCollectionNewHistFuncionariosUnidadeAtuacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = unidades.getId();
                if (findUnidades(id) == null) {
                    throw new NonexistentEntityException("The unidades with id " + id + " no longer exists.");
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
            Unidades unidades;
            try {
                unidades = em.getReference(Unidades.class, id);
                unidades.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidades with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionOrphanCheck = unidades.getHistUnidadesRegimeCollection();
            for (HistUnidadesRegime histUnidadesRegimeCollectionOrphanCheckHistUnidadesRegime : histUnidadesRegimeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Unidades (" + unidades + ") cannot be destroyed since the HistUnidadesRegime " + histUnidadesRegimeCollectionOrphanCheckHistUnidadesRegime + " in its histUnidadesRegimeCollection field has a non-nullable idUnidadeDeSaudeFk field.");
            }
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionOrphanCheck = unidades.getHistUnidadesDiretorCollection();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionOrphanCheckHistUnidadesDiretor : histUnidadesDiretorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Unidades (" + unidades + ") cannot be destroyed since the HistUnidadesDiretor " + histUnidadesDiretorCollectionOrphanCheckHistUnidadesDiretor + " in its histUnidadesDiretorCollection field has a non-nullable unidades field.");
            }
            Collection<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollectionOrphanCheck = unidades.getHistFuncionariosUnidadeLotacaoCollection();
            for (HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaoCollectionOrphanCheckHistFuncionariosUnidadeLotacao : histFuncionariosUnidadeLotacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Unidades (" + unidades + ") cannot be destroyed since the HistFuncionariosUnidadeLotacao " + histFuncionariosUnidadeLotacaoCollectionOrphanCheckHistFuncionariosUnidadeLotacao + " in its histFuncionariosUnidadeLotacaoCollection field has a non-nullable idUnidadeFk field.");
            }
            Collection<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollectionOrphanCheck = unidades.getHistFuncionariosUnidadeAtuacaoCollection();
            for (HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaoCollectionOrphanCheckHistFuncionariosUnidadeAtuacao : histFuncionariosUnidadeAtuacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Unidades (" + unidades + ") cannot be destroyed since the HistFuncionariosUnidadeAtuacao " + histFuncionariosUnidadeAtuacaoCollectionOrphanCheckHistFuncionariosUnidadeAtuacao + " in its histFuncionariosUnidadeAtuacaoCollection field has a non-nullable idUnidadeFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cidades idEnderecoCidadeFk = unidades.getIdEnderecoCidadeFk();
            if (idEnderecoCidadeFk != null) {
                idEnderecoCidadeFk.getUnidadesCollection().remove(unidades);
                idEnderecoCidadeFk = em.merge(idEnderecoCidadeFk);
            }
            PessoaOperadores idOperadorCadastroFk = unidades.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getUnidadesCollection().remove(unidades);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = unidades.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getUnidadesCollection().remove(unidades);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            TiposLogradouro idTipoLogradouroFk = unidades.getIdTipoLogradouroFk();
            if (idTipoLogradouroFk != null) {
                idTipoLogradouroFk.getUnidadesCollection().remove(unidades);
                idTipoLogradouroFk = em.merge(idTipoLogradouroFk);
            }
            Collection<Autorizacoes> autorizacoesCollection = unidades.getAutorizacoesCollection();
            for (Autorizacoes autorizacoesCollectionAutorizacoes : autorizacoesCollection) {
                autorizacoesCollectionAutorizacoes.setIdUnidadeDeSaudeFk(null);
                autorizacoesCollectionAutorizacoes = em.merge(autorizacoesCollectionAutorizacoes);
            }
            em.remove(unidades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Unidades> findUnidadesEntities() {
        return findUnidadesEntities(true, -1, -1);
    }

    public List<Unidades> findUnidadesEntities(int maxResults, int firstResult) {
        return findUnidadesEntities(false, maxResults, firstResult);
    }

    private List<Unidades> findUnidadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Unidades.class));
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

    public Unidades findUnidades(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Unidades.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Unidades> rt = cq.from(Unidades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
