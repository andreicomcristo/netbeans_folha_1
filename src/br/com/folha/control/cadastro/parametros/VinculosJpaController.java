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
import br.com.folha.model.tabelas.HistFuncionariosVinculos;
import br.com.folha.model.tabelas.Vinculos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class VinculosJpaController implements Serializable {

    public VinculosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vinculos vinculos) {
        if (vinculos.getHistFuncionariosVinculosCollection() == null) {
            vinculos.setHistFuncionariosVinculosCollection(new ArrayList<HistFuncionariosVinculos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HistFuncionariosVinculos> attachedHistFuncionariosVinculosCollection = new ArrayList<HistFuncionariosVinculos>();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach : vinculos.getHistFuncionariosVinculosCollection()) {
                histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach = em.getReference(histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach.getClass(), histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach.getId());
                attachedHistFuncionariosVinculosCollection.add(histFuncionariosVinculosCollectionHistFuncionariosVinculosToAttach);
            }
            vinculos.setHistFuncionariosVinculosCollection(attachedHistFuncionariosVinculosCollection);
            em.persist(vinculos);
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionHistFuncionariosVinculos : vinculos.getHistFuncionariosVinculosCollection()) {
                Vinculos oldIdVinculoFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos = histFuncionariosVinculosCollectionHistFuncionariosVinculos.getIdVinculoFk();
                histFuncionariosVinculosCollectionHistFuncionariosVinculos.setIdVinculoFk(vinculos);
                histFuncionariosVinculosCollectionHistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollectionHistFuncionariosVinculos);
                if (oldIdVinculoFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos != null) {
                    oldIdVinculoFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculosCollectionHistFuncionariosVinculos);
                    oldIdVinculoFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos = em.merge(oldIdVinculoFkOfHistFuncionariosVinculosCollectionHistFuncionariosVinculos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vinculos vinculos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vinculos persistentVinculos = em.find(Vinculos.class, vinculos.getId());
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionOld = persistentVinculos.getHistFuncionariosVinculosCollection();
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionNew = vinculos.getHistFuncionariosVinculosCollection();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionOldHistFuncionariosVinculos : histFuncionariosVinculosCollectionOld) {
                if (!histFuncionariosVinculosCollectionNew.contains(histFuncionariosVinculosCollectionOldHistFuncionariosVinculos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosVinculos " + histFuncionariosVinculosCollectionOldHistFuncionariosVinculos + " since its idVinculoFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HistFuncionariosVinculos> attachedHistFuncionariosVinculosCollectionNew = new ArrayList<HistFuncionariosVinculos>();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach : histFuncionariosVinculosCollectionNew) {
                histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach = em.getReference(histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach.getClass(), histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach.getId());
                attachedHistFuncionariosVinculosCollectionNew.add(histFuncionariosVinculosCollectionNewHistFuncionariosVinculosToAttach);
            }
            histFuncionariosVinculosCollectionNew = attachedHistFuncionariosVinculosCollectionNew;
            vinculos.setHistFuncionariosVinculosCollection(histFuncionariosVinculosCollectionNew);
            vinculos = em.merge(vinculos);
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionNewHistFuncionariosVinculos : histFuncionariosVinculosCollectionNew) {
                if (!histFuncionariosVinculosCollectionOld.contains(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos)) {
                    Vinculos oldIdVinculoFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos = histFuncionariosVinculosCollectionNewHistFuncionariosVinculos.getIdVinculoFk();
                    histFuncionariosVinculosCollectionNewHistFuncionariosVinculos.setIdVinculoFk(vinculos);
                    histFuncionariosVinculosCollectionNewHistFuncionariosVinculos = em.merge(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                    if (oldIdVinculoFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos != null && !oldIdVinculoFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos.equals(vinculos)) {
                        oldIdVinculoFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                        oldIdVinculoFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos = em.merge(oldIdVinculoFkOfHistFuncionariosVinculosCollectionNewHistFuncionariosVinculos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = vinculos.getId();
                if (findVinculos(id) == null) {
                    throw new NonexistentEntityException("The vinculos with id " + id + " no longer exists.");
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
            Vinculos vinculos;
            try {
                vinculos = em.getReference(Vinculos.class, id);
                vinculos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vinculos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosVinculos> histFuncionariosVinculosCollectionOrphanCheck = vinculos.getHistFuncionariosVinculosCollection();
            for (HistFuncionariosVinculos histFuncionariosVinculosCollectionOrphanCheckHistFuncionariosVinculos : histFuncionariosVinculosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vinculos (" + vinculos + ") cannot be destroyed since the HistFuncionariosVinculos " + histFuncionariosVinculosCollectionOrphanCheckHistFuncionariosVinculos + " in its histFuncionariosVinculosCollection field has a non-nullable idVinculoFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(vinculos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vinculos> findVinculosEntities() {
        return findVinculosEntities(true, -1, -1);
    }

    public List<Vinculos> findVinculosEntities(int maxResults, int firstResult) {
        return findVinculosEntities(false, maxResults, firstResult);
    }

    private List<Vinculos> findVinculosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vinculos.class));
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

    public Vinculos findVinculos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vinculos.class, id);
        } finally {
            em.close();
        }
    }

    public int getVinculosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vinculos> rt = cq.from(Vinculos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
