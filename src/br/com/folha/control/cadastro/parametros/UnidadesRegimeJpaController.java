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
import br.com.folha.model.tabelas.HistUnidadesRegime;
import br.com.folha.model.tabelas.UnidadesRegime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class UnidadesRegimeJpaController implements Serializable {

    public UnidadesRegimeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UnidadesRegime unidadesRegime) {
        if (unidadesRegime.getHistUnidadesRegimeCollection() == null) {
            unidadesRegime.setHistUnidadesRegimeCollection(new ArrayList<HistUnidadesRegime>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HistUnidadesRegime> attachedHistUnidadesRegimeCollection = new ArrayList<HistUnidadesRegime>();
            for (HistUnidadesRegime histUnidadesRegimeCollectionHistUnidadesRegimeToAttach : unidadesRegime.getHistUnidadesRegimeCollection()) {
                histUnidadesRegimeCollectionHistUnidadesRegimeToAttach = em.getReference(histUnidadesRegimeCollectionHistUnidadesRegimeToAttach.getClass(), histUnidadesRegimeCollectionHistUnidadesRegimeToAttach.getId());
                attachedHistUnidadesRegimeCollection.add(histUnidadesRegimeCollectionHistUnidadesRegimeToAttach);
            }
            unidadesRegime.setHistUnidadesRegimeCollection(attachedHistUnidadesRegimeCollection);
            em.persist(unidadesRegime);
            for (HistUnidadesRegime histUnidadesRegimeCollectionHistUnidadesRegime : unidadesRegime.getHistUnidadesRegimeCollection()) {
                UnidadesRegime oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime = histUnidadesRegimeCollectionHistUnidadesRegime.getIdUnidadeRegimeFk();
                histUnidadesRegimeCollectionHistUnidadesRegime.setIdUnidadeRegimeFk(unidadesRegime);
                histUnidadesRegimeCollectionHistUnidadesRegime = em.merge(histUnidadesRegimeCollectionHistUnidadesRegime);
                if (oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime != null) {
                    oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime.getHistUnidadesRegimeCollection().remove(histUnidadesRegimeCollectionHistUnidadesRegime);
                    oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime = em.merge(oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionHistUnidadesRegime);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UnidadesRegime unidadesRegime) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UnidadesRegime persistentUnidadesRegime = em.find(UnidadesRegime.class, unidadesRegime.getId());
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionOld = persistentUnidadesRegime.getHistUnidadesRegimeCollection();
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionNew = unidadesRegime.getHistUnidadesRegimeCollection();
            List<String> illegalOrphanMessages = null;
            for (HistUnidadesRegime histUnidadesRegimeCollectionOldHistUnidadesRegime : histUnidadesRegimeCollectionOld) {
                if (!histUnidadesRegimeCollectionNew.contains(histUnidadesRegimeCollectionOldHistUnidadesRegime)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistUnidadesRegime " + histUnidadesRegimeCollectionOldHistUnidadesRegime + " since its idUnidadeRegimeFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HistUnidadesRegime> attachedHistUnidadesRegimeCollectionNew = new ArrayList<HistUnidadesRegime>();
            for (HistUnidadesRegime histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach : histUnidadesRegimeCollectionNew) {
                histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach = em.getReference(histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach.getClass(), histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach.getId());
                attachedHistUnidadesRegimeCollectionNew.add(histUnidadesRegimeCollectionNewHistUnidadesRegimeToAttach);
            }
            histUnidadesRegimeCollectionNew = attachedHistUnidadesRegimeCollectionNew;
            unidadesRegime.setHistUnidadesRegimeCollection(histUnidadesRegimeCollectionNew);
            unidadesRegime = em.merge(unidadesRegime);
            for (HistUnidadesRegime histUnidadesRegimeCollectionNewHistUnidadesRegime : histUnidadesRegimeCollectionNew) {
                if (!histUnidadesRegimeCollectionOld.contains(histUnidadesRegimeCollectionNewHistUnidadesRegime)) {
                    UnidadesRegime oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime = histUnidadesRegimeCollectionNewHistUnidadesRegime.getIdUnidadeRegimeFk();
                    histUnidadesRegimeCollectionNewHistUnidadesRegime.setIdUnidadeRegimeFk(unidadesRegime);
                    histUnidadesRegimeCollectionNewHistUnidadesRegime = em.merge(histUnidadesRegimeCollectionNewHistUnidadesRegime);
                    if (oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime != null && !oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime.equals(unidadesRegime)) {
                        oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime.getHistUnidadesRegimeCollection().remove(histUnidadesRegimeCollectionNewHistUnidadesRegime);
                        oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime = em.merge(oldIdUnidadeRegimeFkOfHistUnidadesRegimeCollectionNewHistUnidadesRegime);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = unidadesRegime.getId();
                if (findUnidadesRegime(id) == null) {
                    throw new NonexistentEntityException("The unidadesRegime with id " + id + " no longer exists.");
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
            UnidadesRegime unidadesRegime;
            try {
                unidadesRegime = em.getReference(UnidadesRegime.class, id);
                unidadesRegime.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidadesRegime with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistUnidadesRegime> histUnidadesRegimeCollectionOrphanCheck = unidadesRegime.getHistUnidadesRegimeCollection();
            for (HistUnidadesRegime histUnidadesRegimeCollectionOrphanCheckHistUnidadesRegime : histUnidadesRegimeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UnidadesRegime (" + unidadesRegime + ") cannot be destroyed since the HistUnidadesRegime " + histUnidadesRegimeCollectionOrphanCheckHistUnidadesRegime + " in its histUnidadesRegimeCollection field has a non-nullable idUnidadeRegimeFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(unidadesRegime);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UnidadesRegime> findUnidadesRegimeEntities() {
        return findUnidadesRegimeEntities(true, -1, -1);
    }

    public List<UnidadesRegime> findUnidadesRegimeEntities(int maxResults, int firstResult) {
        return findUnidadesRegimeEntities(false, maxResults, firstResult);
    }

    private List<UnidadesRegime> findUnidadesRegimeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UnidadesRegime.class));
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

    public UnidadesRegime findUnidadesRegime(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UnidadesRegime.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadesRegimeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UnidadesRegime> rt = cq.from(UnidadesRegime.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
