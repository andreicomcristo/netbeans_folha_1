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
import br.com.folha.model.tabelas.HistFuncionariosSituacoes;
import br.com.folha.model.tabelas.Situacoes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class SituacoesJpaController implements Serializable {

    public SituacoesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Situacoes situacoes) {
        if (situacoes.getHistFuncionariosSituacoesCollection() == null) {
            situacoes.setHistFuncionariosSituacoesCollection(new ArrayList<HistFuncionariosSituacoes>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HistFuncionariosSituacoes> attachedHistFuncionariosSituacoesCollection = new ArrayList<HistFuncionariosSituacoes>();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach : situacoes.getHistFuncionariosSituacoesCollection()) {
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach = em.getReference(histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach.getClass(), histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach.getId());
                attachedHistFuncionariosSituacoesCollection.add(histFuncionariosSituacoesCollectionHistFuncionariosSituacoesToAttach);
            }
            situacoes.setHistFuncionariosSituacoesCollection(attachedHistFuncionariosSituacoesCollection);
            em.persist(situacoes);
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionHistFuncionariosSituacoes : situacoes.getHistFuncionariosSituacoesCollection()) {
                Situacoes oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes = histFuncionariosSituacoesCollectionHistFuncionariosSituacoes.getIdSituacaoFk();
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoes.setIdSituacaoFk(situacoes);
                histFuncionariosSituacoesCollectionHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                if (oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes != null) {
                    oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                    oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes = em.merge(oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionHistFuncionariosSituacoes);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Situacoes situacoes) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Situacoes persistentSituacoes = em.find(Situacoes.class, situacoes.getId());
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollectionOld = persistentSituacoes.getHistFuncionariosSituacoesCollection();
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollectionNew = situacoes.getHistFuncionariosSituacoesCollection();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes : histFuncionariosSituacoesCollectionOld) {
                if (!histFuncionariosSituacoesCollectionNew.contains(histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosSituacoes " + histFuncionariosSituacoesCollectionOldHistFuncionariosSituacoes + " since its idSituacaoFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HistFuncionariosSituacoes> attachedHistFuncionariosSituacoesCollectionNew = new ArrayList<HistFuncionariosSituacoes>();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach : histFuncionariosSituacoesCollectionNew) {
                histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach = em.getReference(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach.getClass(), histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach.getId());
                attachedHistFuncionariosSituacoesCollectionNew.add(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoesToAttach);
            }
            histFuncionariosSituacoesCollectionNew = attachedHistFuncionariosSituacoesCollectionNew;
            situacoes.setHistFuncionariosSituacoesCollection(histFuncionariosSituacoesCollectionNew);
            situacoes = em.merge(situacoes);
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes : histFuncionariosSituacoesCollectionNew) {
                if (!histFuncionariosSituacoesCollectionOld.contains(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes)) {
                    Situacoes oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.getIdSituacaoFk();
                    histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.setIdSituacaoFk(situacoes);
                    histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = em.merge(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                    if (oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes != null && !oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.equals(situacoes)) {
                        oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                        oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes = em.merge(oldIdSituacaoFkOfHistFuncionariosSituacoesCollectionNewHistFuncionariosSituacoes);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = situacoes.getId();
                if (findSituacoes(id) == null) {
                    throw new NonexistentEntityException("The situacoes with id " + id + " no longer exists.");
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
            Situacoes situacoes;
            try {
                situacoes = em.getReference(Situacoes.class, id);
                situacoes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The situacoes with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosSituacoes> histFuncionariosSituacoesCollectionOrphanCheck = situacoes.getHistFuncionariosSituacoesCollection();
            for (HistFuncionariosSituacoes histFuncionariosSituacoesCollectionOrphanCheckHistFuncionariosSituacoes : histFuncionariosSituacoesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Situacoes (" + situacoes + ") cannot be destroyed since the HistFuncionariosSituacoes " + histFuncionariosSituacoesCollectionOrphanCheckHistFuncionariosSituacoes + " in its histFuncionariosSituacoesCollection field has a non-nullable idSituacaoFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(situacoes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Situacoes> findSituacoesEntities() {
        return findSituacoesEntities(true, -1, -1);
    }

    public List<Situacoes> findSituacoesEntities(int maxResults, int firstResult) {
        return findSituacoesEntities(false, maxResults, firstResult);
    }

    private List<Situacoes> findSituacoesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Situacoes.class));
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

    public Situacoes findSituacoes(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Situacoes.class, id);
        } finally {
            em.close();
        }
    }

    public int getSituacoesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Situacoes> rt = cq.from(Situacoes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
