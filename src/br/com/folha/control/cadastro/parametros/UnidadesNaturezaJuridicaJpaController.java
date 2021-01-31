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
import br.com.folha.model.tabelas.HistUnidadesNaturezaJuridica;
import br.com.folha.model.tabelas.UnidadesNaturezaJuridica;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class UnidadesNaturezaJuridicaJpaController implements Serializable {

    public UnidadesNaturezaJuridicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UnidadesNaturezaJuridica unidadesNaturezaJuridica) {
        if (unidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection() == null) {
            unidadesNaturezaJuridica.setHistUnidadesNaturezaJuridicaCollection(new ArrayList<HistUnidadesNaturezaJuridica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HistUnidadesNaturezaJuridica> attachedHistUnidadesNaturezaJuridicaCollection = new ArrayList<HistUnidadesNaturezaJuridica>();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach : unidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection()) {
                histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach = em.getReference(histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach.getClass(), histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach.getId());
                attachedHistUnidadesNaturezaJuridicaCollection.add(histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridicaToAttach);
            }
            unidadesNaturezaJuridica.setHistUnidadesNaturezaJuridicaCollection(attachedHistUnidadesNaturezaJuridicaCollection);
            em.persist(unidadesNaturezaJuridica);
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica : unidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection()) {
                UnidadesNaturezaJuridica oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica = histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica.getIdUnidadeDeSaudeFk();
                histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica.setIdUnidadeDeSaudeFk(unidadesNaturezaJuridica);
                histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica);
                if (oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica != null) {
                    oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica);
                    oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica = em.merge(oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionHistUnidadesNaturezaJuridica);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UnidadesNaturezaJuridica unidadesNaturezaJuridica) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UnidadesNaturezaJuridica persistentUnidadesNaturezaJuridica = em.find(UnidadesNaturezaJuridica.class, unidadesNaturezaJuridica.getId());
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollectionOld = persistentUnidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection();
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollectionNew = unidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection();
            List<String> illegalOrphanMessages = null;
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionOldHistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollectionOld) {
                if (!histUnidadesNaturezaJuridicaCollectionNew.contains(histUnidadesNaturezaJuridicaCollectionOldHistUnidadesNaturezaJuridica)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistUnidadesNaturezaJuridica " + histUnidadesNaturezaJuridicaCollectionOldHistUnidadesNaturezaJuridica + " since its idUnidadeDeSaudeFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HistUnidadesNaturezaJuridica> attachedHistUnidadesNaturezaJuridicaCollectionNew = new ArrayList<HistUnidadesNaturezaJuridica>();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach : histUnidadesNaturezaJuridicaCollectionNew) {
                histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach = em.getReference(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach.getClass(), histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach.getId());
                attachedHistUnidadesNaturezaJuridicaCollectionNew.add(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridicaToAttach);
            }
            histUnidadesNaturezaJuridicaCollectionNew = attachedHistUnidadesNaturezaJuridicaCollectionNew;
            unidadesNaturezaJuridica.setHistUnidadesNaturezaJuridicaCollection(histUnidadesNaturezaJuridicaCollectionNew);
            unidadesNaturezaJuridica = em.merge(unidadesNaturezaJuridica);
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollectionNew) {
                if (!histUnidadesNaturezaJuridicaCollectionOld.contains(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica)) {
                    UnidadesNaturezaJuridica oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica = histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica.getIdUnidadeDeSaudeFk();
                    histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica.setIdUnidadeDeSaudeFk(unidadesNaturezaJuridica);
                    histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica);
                    if (oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica != null && !oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica.equals(unidadesNaturezaJuridica)) {
                        oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica);
                        oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica = em.merge(oldIdUnidadeDeSaudeFkOfHistUnidadesNaturezaJuridicaCollectionNewHistUnidadesNaturezaJuridica);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = unidadesNaturezaJuridica.getId();
                if (findUnidadesNaturezaJuridica(id) == null) {
                    throw new NonexistentEntityException("The unidadesNaturezaJuridica with id " + id + " no longer exists.");
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
            UnidadesNaturezaJuridica unidadesNaturezaJuridica;
            try {
                unidadesNaturezaJuridica = em.getReference(UnidadesNaturezaJuridica.class, id);
                unidadesNaturezaJuridica.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidadesNaturezaJuridica with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollectionOrphanCheck = unidadesNaturezaJuridica.getHistUnidadesNaturezaJuridicaCollection();
            for (HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicaCollectionOrphanCheckHistUnidadesNaturezaJuridica : histUnidadesNaturezaJuridicaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UnidadesNaturezaJuridica (" + unidadesNaturezaJuridica + ") cannot be destroyed since the HistUnidadesNaturezaJuridica " + histUnidadesNaturezaJuridicaCollectionOrphanCheckHistUnidadesNaturezaJuridica + " in its histUnidadesNaturezaJuridicaCollection field has a non-nullable idUnidadeDeSaudeFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(unidadesNaturezaJuridica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UnidadesNaturezaJuridica> findUnidadesNaturezaJuridicaEntities() {
        return findUnidadesNaturezaJuridicaEntities(true, -1, -1);
    }

    public List<UnidadesNaturezaJuridica> findUnidadesNaturezaJuridicaEntities(int maxResults, int firstResult) {
        return findUnidadesNaturezaJuridicaEntities(false, maxResults, firstResult);
    }

    private List<UnidadesNaturezaJuridica> findUnidadesNaturezaJuridicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UnidadesNaturezaJuridica.class));
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

    public UnidadesNaturezaJuridica findUnidadesNaturezaJuridica(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UnidadesNaturezaJuridica.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadesNaturezaJuridicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UnidadesNaturezaJuridica> rt = cq.from(UnidadesNaturezaJuridica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
