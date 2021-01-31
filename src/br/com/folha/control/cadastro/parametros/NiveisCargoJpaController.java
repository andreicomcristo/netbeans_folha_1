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
import br.com.folha.model.tabelas.Cargos;
import br.com.folha.model.tabelas.NiveisCargo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class NiveisCargoJpaController implements Serializable {

    public NiveisCargoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NiveisCargo niveisCargo) {
        if (niveisCargo.getCargosCollection() == null) {
            niveisCargo.setCargosCollection(new ArrayList<Cargos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cargos> attachedCargosCollection = new ArrayList<Cargos>();
            for (Cargos cargosCollectionCargosToAttach : niveisCargo.getCargosCollection()) {
                cargosCollectionCargosToAttach = em.getReference(cargosCollectionCargosToAttach.getClass(), cargosCollectionCargosToAttach.getId());
                attachedCargosCollection.add(cargosCollectionCargosToAttach);
            }
            niveisCargo.setCargosCollection(attachedCargosCollection);
            em.persist(niveisCargo);
            for (Cargos cargosCollectionCargos : niveisCargo.getCargosCollection()) {
                NiveisCargo oldIdNivelCargoFkOfCargosCollectionCargos = cargosCollectionCargos.getIdNivelCargoFk();
                cargosCollectionCargos.setIdNivelCargoFk(niveisCargo);
                cargosCollectionCargos = em.merge(cargosCollectionCargos);
                if (oldIdNivelCargoFkOfCargosCollectionCargos != null) {
                    oldIdNivelCargoFkOfCargosCollectionCargos.getCargosCollection().remove(cargosCollectionCargos);
                    oldIdNivelCargoFkOfCargosCollectionCargos = em.merge(oldIdNivelCargoFkOfCargosCollectionCargos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NiveisCargo niveisCargo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NiveisCargo persistentNiveisCargo = em.find(NiveisCargo.class, niveisCargo.getId());
            Collection<Cargos> cargosCollectionOld = persistentNiveisCargo.getCargosCollection();
            Collection<Cargos> cargosCollectionNew = niveisCargo.getCargosCollection();
            List<String> illegalOrphanMessages = null;
            for (Cargos cargosCollectionOldCargos : cargosCollectionOld) {
                if (!cargosCollectionNew.contains(cargosCollectionOldCargos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cargos " + cargosCollectionOldCargos + " since its idNivelCargoFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Cargos> attachedCargosCollectionNew = new ArrayList<Cargos>();
            for (Cargos cargosCollectionNewCargosToAttach : cargosCollectionNew) {
                cargosCollectionNewCargosToAttach = em.getReference(cargosCollectionNewCargosToAttach.getClass(), cargosCollectionNewCargosToAttach.getId());
                attachedCargosCollectionNew.add(cargosCollectionNewCargosToAttach);
            }
            cargosCollectionNew = attachedCargosCollectionNew;
            niveisCargo.setCargosCollection(cargosCollectionNew);
            niveisCargo = em.merge(niveisCargo);
            for (Cargos cargosCollectionNewCargos : cargosCollectionNew) {
                if (!cargosCollectionOld.contains(cargosCollectionNewCargos)) {
                    NiveisCargo oldIdNivelCargoFkOfCargosCollectionNewCargos = cargosCollectionNewCargos.getIdNivelCargoFk();
                    cargosCollectionNewCargos.setIdNivelCargoFk(niveisCargo);
                    cargosCollectionNewCargos = em.merge(cargosCollectionNewCargos);
                    if (oldIdNivelCargoFkOfCargosCollectionNewCargos != null && !oldIdNivelCargoFkOfCargosCollectionNewCargos.equals(niveisCargo)) {
                        oldIdNivelCargoFkOfCargosCollectionNewCargos.getCargosCollection().remove(cargosCollectionNewCargos);
                        oldIdNivelCargoFkOfCargosCollectionNewCargos = em.merge(oldIdNivelCargoFkOfCargosCollectionNewCargos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = niveisCargo.getId();
                if (findNiveisCargo(id) == null) {
                    throw new NonexistentEntityException("The niveisCargo with id " + id + " no longer exists.");
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
            NiveisCargo niveisCargo;
            try {
                niveisCargo = em.getReference(NiveisCargo.class, id);
                niveisCargo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The niveisCargo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Cargos> cargosCollectionOrphanCheck = niveisCargo.getCargosCollection();
            for (Cargos cargosCollectionOrphanCheckCargos : cargosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This NiveisCargo (" + niveisCargo + ") cannot be destroyed since the Cargos " + cargosCollectionOrphanCheckCargos + " in its cargosCollection field has a non-nullable idNivelCargoFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(niveisCargo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NiveisCargo> findNiveisCargoEntities() {
        return findNiveisCargoEntities(true, -1, -1);
    }

    public List<NiveisCargo> findNiveisCargoEntities(int maxResults, int firstResult) {
        return findNiveisCargoEntities(false, maxResults, firstResult);
    }

    private List<NiveisCargo> findNiveisCargoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NiveisCargo.class));
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

    public NiveisCargo findNiveisCargo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NiveisCargo.class, id);
        } finally {
            em.close();
        }
    }

    public int getNiveisCargoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NiveisCargo> rt = cq.from(NiveisCargo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
