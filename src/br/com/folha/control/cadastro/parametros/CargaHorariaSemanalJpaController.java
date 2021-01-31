/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.CargaHorariaSemanal;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.HistFuncionariosCargaHoraria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class CargaHorariaSemanalJpaController implements Serializable {

    public CargaHorariaSemanalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CargaHorariaSemanal cargaHorariaSemanal) {
        if (cargaHorariaSemanal.getHistFuncionariosCargaHorariaCollection() == null) {
            cargaHorariaSemanal.setHistFuncionariosCargaHorariaCollection(new ArrayList<HistFuncionariosCargaHoraria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HistFuncionariosCargaHoraria> attachedHistFuncionariosCargaHorariaCollection = new ArrayList<HistFuncionariosCargaHoraria>();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach : cargaHorariaSemanal.getHistFuncionariosCargaHorariaCollection()) {
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach = em.getReference(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach.getClass(), histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach.getId());
                attachedHistFuncionariosCargaHorariaCollection.add(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHorariaToAttach);
            }
            cargaHorariaSemanal.setHistFuncionariosCargaHorariaCollection(attachedHistFuncionariosCargaHorariaCollection);
            em.persist(cargaHorariaSemanal);
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria : cargaHorariaSemanal.getHistFuncionariosCargaHorariaCollection()) {
                CargaHorariaSemanal oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.getIdCargaHorariaSemanalFk();
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.setIdCargaHorariaSemanalFk(cargaHorariaSemanal);
                histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                if (oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria != null) {
                    oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                    oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria = em.merge(oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionHistFuncionariosCargaHoraria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CargaHorariaSemanal cargaHorariaSemanal) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CargaHorariaSemanal persistentCargaHorariaSemanal = em.find(CargaHorariaSemanal.class, cargaHorariaSemanal.getId());
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollectionOld = persistentCargaHorariaSemanal.getHistFuncionariosCargaHorariaCollection();
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollectionNew = cargaHorariaSemanal.getHistFuncionariosCargaHorariaCollection();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollectionOld) {
                if (!histFuncionariosCargaHorariaCollectionNew.contains(histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCargaHoraria " + histFuncionariosCargaHorariaCollectionOldHistFuncionariosCargaHoraria + " since its idCargaHorariaSemanalFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HistFuncionariosCargaHoraria> attachedHistFuncionariosCargaHorariaCollectionNew = new ArrayList<HistFuncionariosCargaHoraria>();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach : histFuncionariosCargaHorariaCollectionNew) {
                histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach = em.getReference(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach.getClass(), histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach.getId());
                attachedHistFuncionariosCargaHorariaCollectionNew.add(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHorariaToAttach);
            }
            histFuncionariosCargaHorariaCollectionNew = attachedHistFuncionariosCargaHorariaCollectionNew;
            cargaHorariaSemanal.setHistFuncionariosCargaHorariaCollection(histFuncionariosCargaHorariaCollectionNew);
            cargaHorariaSemanal = em.merge(cargaHorariaSemanal);
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollectionNew) {
                if (!histFuncionariosCargaHorariaCollectionOld.contains(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria)) {
                    CargaHorariaSemanal oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.getIdCargaHorariaSemanalFk();
                    histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.setIdCargaHorariaSemanalFk(cargaHorariaSemanal);
                    histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                    if (oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria != null && !oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.equals(cargaHorariaSemanal)) {
                        oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                        oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria = em.merge(oldIdCargaHorariaSemanalFkOfHistFuncionariosCargaHorariaCollectionNewHistFuncionariosCargaHoraria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cargaHorariaSemanal.getId();
                if (findCargaHorariaSemanal(id) == null) {
                    throw new NonexistentEntityException("The cargaHorariaSemanal with id " + id + " no longer exists.");
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
            CargaHorariaSemanal cargaHorariaSemanal;
            try {
                cargaHorariaSemanal = em.getReference(CargaHorariaSemanal.class, id);
                cargaHorariaSemanal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargaHorariaSemanal with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollectionOrphanCheck = cargaHorariaSemanal.getHistFuncionariosCargaHorariaCollection();
            for (HistFuncionariosCargaHoraria histFuncionariosCargaHorariaCollectionOrphanCheckHistFuncionariosCargaHoraria : histFuncionariosCargaHorariaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This CargaHorariaSemanal (" + cargaHorariaSemanal + ") cannot be destroyed since the HistFuncionariosCargaHoraria " + histFuncionariosCargaHorariaCollectionOrphanCheckHistFuncionariosCargaHoraria + " in its histFuncionariosCargaHorariaCollection field has a non-nullable idCargaHorariaSemanalFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cargaHorariaSemanal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CargaHorariaSemanal> findCargaHorariaSemanalEntities() {
        return findCargaHorariaSemanalEntities(true, -1, -1);
    }

    public List<CargaHorariaSemanal> findCargaHorariaSemanalEntities(int maxResults, int firstResult) {
        return findCargaHorariaSemanalEntities(false, maxResults, firstResult);
    }

    private List<CargaHorariaSemanal> findCargaHorariaSemanalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CargaHorariaSemanal.class));
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

    public CargaHorariaSemanal findCargaHorariaSemanal(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CargaHorariaSemanal.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargaHorariaSemanalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CargaHorariaSemanal> rt = cq.from(CargaHorariaSemanal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
