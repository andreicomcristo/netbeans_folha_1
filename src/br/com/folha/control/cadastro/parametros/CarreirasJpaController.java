/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.Carreiras;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.HistFuncionariosCarreira;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class CarreirasJpaController implements Serializable {

    public CarreirasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carreiras carreiras) {
        if (carreiras.getHistFuncionariosCarreiraCollection() == null) {
            carreiras.setHistFuncionariosCarreiraCollection(new ArrayList<HistFuncionariosCarreira>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HistFuncionariosCarreira> attachedHistFuncionariosCarreiraCollection = new ArrayList<HistFuncionariosCarreira>();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach : carreiras.getHistFuncionariosCarreiraCollection()) {
                histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach = em.getReference(histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach.getClass(), histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach.getId());
                attachedHistFuncionariosCarreiraCollection.add(histFuncionariosCarreiraCollectionHistFuncionariosCarreiraToAttach);
            }
            carreiras.setHistFuncionariosCarreiraCollection(attachedHistFuncionariosCarreiraCollection);
            em.persist(carreiras);
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionHistFuncionariosCarreira : carreiras.getHistFuncionariosCarreiraCollection()) {
                Carreiras oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira = histFuncionariosCarreiraCollectionHistFuncionariosCarreira.getIdCarreiraFk();
                histFuncionariosCarreiraCollectionHistFuncionariosCarreira.setIdCarreiraFk(carreiras);
                histFuncionariosCarreiraCollectionHistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                if (oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira != null) {
                    oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                    oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira = em.merge(oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionHistFuncionariosCarreira);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carreiras carreiras) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carreiras persistentCarreiras = em.find(Carreiras.class, carreiras.getId());
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionOld = persistentCarreiras.getHistFuncionariosCarreiraCollection();
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionNew = carreiras.getHistFuncionariosCarreiraCollection();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira : histFuncionariosCarreiraCollectionOld) {
                if (!histFuncionariosCarreiraCollectionNew.contains(histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCarreira " + histFuncionariosCarreiraCollectionOldHistFuncionariosCarreira + " since its idCarreiraFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HistFuncionariosCarreira> attachedHistFuncionariosCarreiraCollectionNew = new ArrayList<HistFuncionariosCarreira>();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach : histFuncionariosCarreiraCollectionNew) {
                histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach = em.getReference(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach.getClass(), histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach.getId());
                attachedHistFuncionariosCarreiraCollectionNew.add(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreiraToAttach);
            }
            histFuncionariosCarreiraCollectionNew = attachedHistFuncionariosCarreiraCollectionNew;
            carreiras.setHistFuncionariosCarreiraCollection(histFuncionariosCarreiraCollectionNew);
            carreiras = em.merge(carreiras);
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira : histFuncionariosCarreiraCollectionNew) {
                if (!histFuncionariosCarreiraCollectionOld.contains(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira)) {
                    Carreiras oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.getIdCarreiraFk();
                    histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.setIdCarreiraFk(carreiras);
                    histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = em.merge(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                    if (oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira != null && !oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.equals(carreiras)) {
                        oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                        oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira = em.merge(oldIdCarreiraFkOfHistFuncionariosCarreiraCollectionNewHistFuncionariosCarreira);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = carreiras.getId();
                if (findCarreiras(id) == null) {
                    throw new NonexistentEntityException("The carreiras with id " + id + " no longer exists.");
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
            Carreiras carreiras;
            try {
                carreiras = em.getReference(Carreiras.class, id);
                carreiras.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carreiras with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosCarreira> histFuncionariosCarreiraCollectionOrphanCheck = carreiras.getHistFuncionariosCarreiraCollection();
            for (HistFuncionariosCarreira histFuncionariosCarreiraCollectionOrphanCheckHistFuncionariosCarreira : histFuncionariosCarreiraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Carreiras (" + carreiras + ") cannot be destroyed since the HistFuncionariosCarreira " + histFuncionariosCarreiraCollectionOrphanCheckHistFuncionariosCarreira + " in its histFuncionariosCarreiraCollection field has a non-nullable idCarreiraFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(carreiras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carreiras> findCarreirasEntities() {
        return findCarreirasEntities(true, -1, -1);
    }

    public List<Carreiras> findCarreirasEntities(int maxResults, int firstResult) {
        return findCarreirasEntities(false, maxResults, firstResult);
    }

    private List<Carreiras> findCarreirasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carreiras.class));
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

    public Carreiras findCarreiras(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carreiras.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarreirasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carreiras> rt = cq.from(Carreiras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
