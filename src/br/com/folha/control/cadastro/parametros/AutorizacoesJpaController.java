/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.Autorizacoes;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Unidades;
import br.com.folha.model.tabelas.HistFuncionariosAutorizacao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class AutorizacoesJpaController implements Serializable {

    public AutorizacoesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Autorizacoes autorizacoes) {
        if (autorizacoes.getHistFuncionariosAutorizacaoCollection() == null) {
            autorizacoes.setHistFuncionariosAutorizacaoCollection(new ArrayList<HistFuncionariosAutorizacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaFuncionarios idFuncionarioFk = autorizacoes.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                autorizacoes.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCriacaoFk = autorizacoes.getIdOperadorCriacaoFk();
            if (idOperadorCriacaoFk != null) {
                idOperadorCriacaoFk = em.getReference(idOperadorCriacaoFk.getClass(), idOperadorCriacaoFk.getId());
                autorizacoes.setIdOperadorCriacaoFk(idOperadorCriacaoFk);
            }
            Unidades idUnidadeDeSaudeFk = autorizacoes.getIdUnidadeDeSaudeFk();
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk = em.getReference(idUnidadeDeSaudeFk.getClass(), idUnidadeDeSaudeFk.getId());
                autorizacoes.setIdUnidadeDeSaudeFk(idUnidadeDeSaudeFk);
            }
            Collection<HistFuncionariosAutorizacao> attachedHistFuncionariosAutorizacaoCollection = new ArrayList<HistFuncionariosAutorizacao>();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach : autorizacoes.getHistFuncionariosAutorizacaoCollection()) {
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach = em.getReference(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach.getClass(), histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach.getId());
                attachedHistFuncionariosAutorizacaoCollection.add(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacaoToAttach);
            }
            autorizacoes.setHistFuncionariosAutorizacaoCollection(attachedHistFuncionariosAutorizacaoCollection);
            em.persist(autorizacoes);
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getAutorizacoesCollection().add(autorizacoes);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCriacaoFk != null) {
                idOperadorCriacaoFk.getAutorizacoesCollection().add(autorizacoes);
                idOperadorCriacaoFk = em.merge(idOperadorCriacaoFk);
            }
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk.getAutorizacoesCollection().add(autorizacoes);
                idUnidadeDeSaudeFk = em.merge(idUnidadeDeSaudeFk);
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao : autorizacoes.getHistFuncionariosAutorizacaoCollection()) {
                Autorizacoes oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.getIdAutorizacaoFk();
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.setIdAutorizacaoFk(autorizacoes);
                histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                if (oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao != null) {
                    oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                    oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao = em.merge(oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionHistFuncionariosAutorizacao);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Autorizacoes autorizacoes) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autorizacoes persistentAutorizacoes = em.find(Autorizacoes.class, autorizacoes.getId());
            PessoaFuncionarios idFuncionarioFkOld = persistentAutorizacoes.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = autorizacoes.getIdFuncionarioFk();
            PessoaOperadores idOperadorCriacaoFkOld = persistentAutorizacoes.getIdOperadorCriacaoFk();
            PessoaOperadores idOperadorCriacaoFkNew = autorizacoes.getIdOperadorCriacaoFk();
            Unidades idUnidadeDeSaudeFkOld = persistentAutorizacoes.getIdUnidadeDeSaudeFk();
            Unidades idUnidadeDeSaudeFkNew = autorizacoes.getIdUnidadeDeSaudeFk();
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionOld = persistentAutorizacoes.getHistFuncionariosAutorizacaoCollection();
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionNew = autorizacoes.getHistFuncionariosAutorizacaoCollection();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionOld) {
                if (!histFuncionariosAutorizacaoCollectionNew.contains(histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosAutorizacao " + histFuncionariosAutorizacaoCollectionOldHistFuncionariosAutorizacao + " since its idAutorizacaoFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                autorizacoes.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCriacaoFkNew != null) {
                idOperadorCriacaoFkNew = em.getReference(idOperadorCriacaoFkNew.getClass(), idOperadorCriacaoFkNew.getId());
                autorizacoes.setIdOperadorCriacaoFk(idOperadorCriacaoFkNew);
            }
            if (idUnidadeDeSaudeFkNew != null) {
                idUnidadeDeSaudeFkNew = em.getReference(idUnidadeDeSaudeFkNew.getClass(), idUnidadeDeSaudeFkNew.getId());
                autorizacoes.setIdUnidadeDeSaudeFk(idUnidadeDeSaudeFkNew);
            }
            Collection<HistFuncionariosAutorizacao> attachedHistFuncionariosAutorizacaoCollectionNew = new ArrayList<HistFuncionariosAutorizacao>();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach : histFuncionariosAutorizacaoCollectionNew) {
                histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach = em.getReference(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach.getClass(), histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach.getId());
                attachedHistFuncionariosAutorizacaoCollectionNew.add(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacaoToAttach);
            }
            histFuncionariosAutorizacaoCollectionNew = attachedHistFuncionariosAutorizacaoCollectionNew;
            autorizacoes.setHistFuncionariosAutorizacaoCollection(histFuncionariosAutorizacaoCollectionNew);
            autorizacoes = em.merge(autorizacoes);
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getAutorizacoesCollection().remove(autorizacoes);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getAutorizacoesCollection().add(autorizacoes);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCriacaoFkOld != null && !idOperadorCriacaoFkOld.equals(idOperadorCriacaoFkNew)) {
                idOperadorCriacaoFkOld.getAutorizacoesCollection().remove(autorizacoes);
                idOperadorCriacaoFkOld = em.merge(idOperadorCriacaoFkOld);
            }
            if (idOperadorCriacaoFkNew != null && !idOperadorCriacaoFkNew.equals(idOperadorCriacaoFkOld)) {
                idOperadorCriacaoFkNew.getAutorizacoesCollection().add(autorizacoes);
                idOperadorCriacaoFkNew = em.merge(idOperadorCriacaoFkNew);
            }
            if (idUnidadeDeSaudeFkOld != null && !idUnidadeDeSaudeFkOld.equals(idUnidadeDeSaudeFkNew)) {
                idUnidadeDeSaudeFkOld.getAutorizacoesCollection().remove(autorizacoes);
                idUnidadeDeSaudeFkOld = em.merge(idUnidadeDeSaudeFkOld);
            }
            if (idUnidadeDeSaudeFkNew != null && !idUnidadeDeSaudeFkNew.equals(idUnidadeDeSaudeFkOld)) {
                idUnidadeDeSaudeFkNew.getAutorizacoesCollection().add(autorizacoes);
                idUnidadeDeSaudeFkNew = em.merge(idUnidadeDeSaudeFkNew);
            }
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionNew) {
                if (!histFuncionariosAutorizacaoCollectionOld.contains(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao)) {
                    Autorizacoes oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.getIdAutorizacaoFk();
                    histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.setIdAutorizacaoFk(autorizacoes);
                    histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                    if (oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao != null && !oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.equals(autorizacoes)) {
                        oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                        oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao = em.merge(oldIdAutorizacaoFkOfHistFuncionariosAutorizacaoCollectionNewHistFuncionariosAutorizacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = autorizacoes.getId();
                if (findAutorizacoes(id) == null) {
                    throw new NonexistentEntityException("The autorizacoes with id " + id + " no longer exists.");
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
            Autorizacoes autorizacoes;
            try {
                autorizacoes = em.getReference(Autorizacoes.class, id);
                autorizacoes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The autorizacoes with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollectionOrphanCheck = autorizacoes.getHistFuncionariosAutorizacaoCollection();
            for (HistFuncionariosAutorizacao histFuncionariosAutorizacaoCollectionOrphanCheckHistFuncionariosAutorizacao : histFuncionariosAutorizacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Autorizacoes (" + autorizacoes + ") cannot be destroyed since the HistFuncionariosAutorizacao " + histFuncionariosAutorizacaoCollectionOrphanCheckHistFuncionariosAutorizacao + " in its histFuncionariosAutorizacaoCollection field has a non-nullable idAutorizacaoFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            PessoaFuncionarios idFuncionarioFk = autorizacoes.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getAutorizacoesCollection().remove(autorizacoes);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCriacaoFk = autorizacoes.getIdOperadorCriacaoFk();
            if (idOperadorCriacaoFk != null) {
                idOperadorCriacaoFk.getAutorizacoesCollection().remove(autorizacoes);
                idOperadorCriacaoFk = em.merge(idOperadorCriacaoFk);
            }
            Unidades idUnidadeDeSaudeFk = autorizacoes.getIdUnidadeDeSaudeFk();
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk.getAutorizacoesCollection().remove(autorizacoes);
                idUnidadeDeSaudeFk = em.merge(idUnidadeDeSaudeFk);
            }
            em.remove(autorizacoes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Autorizacoes> findAutorizacoesEntities() {
        return findAutorizacoesEntities(true, -1, -1);
    }

    public List<Autorizacoes> findAutorizacoesEntities(int maxResults, int firstResult) {
        return findAutorizacoesEntities(false, maxResults, firstResult);
    }

    private List<Autorizacoes> findAutorizacoesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Autorizacoes.class));
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

    public Autorizacoes findAutorizacoes(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Autorizacoes.class, id);
        } finally {
            em.close();
        }
    }

    public int getAutorizacoesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Autorizacoes> rt = cq.from(Autorizacoes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
