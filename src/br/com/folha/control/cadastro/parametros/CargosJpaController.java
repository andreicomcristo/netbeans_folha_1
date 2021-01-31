/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.Cargos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.NiveisCargo;
import br.com.folha.model.tabelas.CargosEspecialidade;
import java.util.ArrayList;
import java.util.Collection;
import br.com.folha.model.tabelas.HistFuncionariosCargos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class CargosJpaController implements Serializable {

    public CargosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cargos cargos) {
        if (cargos.getCargosEspecialidadeCollection() == null) {
            cargos.setCargosEspecialidadeCollection(new ArrayList<CargosEspecialidade>());
        }
        if (cargos.getHistFuncionariosCargosCollection() == null) {
            cargos.setHistFuncionariosCargosCollection(new ArrayList<HistFuncionariosCargos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NiveisCargo idNivelCargoFk = cargos.getIdNivelCargoFk();
            if (idNivelCargoFk != null) {
                idNivelCargoFk = em.getReference(idNivelCargoFk.getClass(), idNivelCargoFk.getId());
                cargos.setIdNivelCargoFk(idNivelCargoFk);
            }
            Collection<CargosEspecialidade> attachedCargosEspecialidadeCollection = new ArrayList<CargosEspecialidade>();
            for (CargosEspecialidade cargosEspecialidadeCollectionCargosEspecialidadeToAttach : cargos.getCargosEspecialidadeCollection()) {
                cargosEspecialidadeCollectionCargosEspecialidadeToAttach = em.getReference(cargosEspecialidadeCollectionCargosEspecialidadeToAttach.getClass(), cargosEspecialidadeCollectionCargosEspecialidadeToAttach.getId());
                attachedCargosEspecialidadeCollection.add(cargosEspecialidadeCollectionCargosEspecialidadeToAttach);
            }
            cargos.setCargosEspecialidadeCollection(attachedCargosEspecialidadeCollection);
            Collection<HistFuncionariosCargos> attachedHistFuncionariosCargosCollection = new ArrayList<HistFuncionariosCargos>();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionHistFuncionariosCargosToAttach : cargos.getHistFuncionariosCargosCollection()) {
                histFuncionariosCargosCollectionHistFuncionariosCargosToAttach = em.getReference(histFuncionariosCargosCollectionHistFuncionariosCargosToAttach.getClass(), histFuncionariosCargosCollectionHistFuncionariosCargosToAttach.getId());
                attachedHistFuncionariosCargosCollection.add(histFuncionariosCargosCollectionHistFuncionariosCargosToAttach);
            }
            cargos.setHistFuncionariosCargosCollection(attachedHistFuncionariosCargosCollection);
            em.persist(cargos);
            if (idNivelCargoFk != null) {
                idNivelCargoFk.getCargosCollection().add(cargos);
                idNivelCargoFk = em.merge(idNivelCargoFk);
            }
            for (CargosEspecialidade cargosEspecialidadeCollectionCargosEspecialidade : cargos.getCargosEspecialidadeCollection()) {
                Cargos oldIdCargoFkOfCargosEspecialidadeCollectionCargosEspecialidade = cargosEspecialidadeCollectionCargosEspecialidade.getIdCargoFk();
                cargosEspecialidadeCollectionCargosEspecialidade.setIdCargoFk(cargos);
                cargosEspecialidadeCollectionCargosEspecialidade = em.merge(cargosEspecialidadeCollectionCargosEspecialidade);
                if (oldIdCargoFkOfCargosEspecialidadeCollectionCargosEspecialidade != null) {
                    oldIdCargoFkOfCargosEspecialidadeCollectionCargosEspecialidade.getCargosEspecialidadeCollection().remove(cargosEspecialidadeCollectionCargosEspecialidade);
                    oldIdCargoFkOfCargosEspecialidadeCollectionCargosEspecialidade = em.merge(oldIdCargoFkOfCargosEspecialidadeCollectionCargosEspecialidade);
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollectionHistFuncionariosCargos : cargos.getHistFuncionariosCargosCollection()) {
                Cargos oldIdCargoFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos = histFuncionariosCargosCollectionHistFuncionariosCargos.getIdCargoFk();
                histFuncionariosCargosCollectionHistFuncionariosCargos.setIdCargoFk(cargos);
                histFuncionariosCargosCollectionHistFuncionariosCargos = em.merge(histFuncionariosCargosCollectionHistFuncionariosCargos);
                if (oldIdCargoFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos != null) {
                    oldIdCargoFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos.getHistFuncionariosCargosCollection().remove(histFuncionariosCargosCollectionHistFuncionariosCargos);
                    oldIdCargoFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos = em.merge(oldIdCargoFkOfHistFuncionariosCargosCollectionHistFuncionariosCargos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cargos cargos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargos persistentCargos = em.find(Cargos.class, cargos.getId());
            NiveisCargo idNivelCargoFkOld = persistentCargos.getIdNivelCargoFk();
            NiveisCargo idNivelCargoFkNew = cargos.getIdNivelCargoFk();
            Collection<CargosEspecialidade> cargosEspecialidadeCollectionOld = persistentCargos.getCargosEspecialidadeCollection();
            Collection<CargosEspecialidade> cargosEspecialidadeCollectionNew = cargos.getCargosEspecialidadeCollection();
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionOld = persistentCargos.getHistFuncionariosCargosCollection();
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionNew = cargos.getHistFuncionariosCargosCollection();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosCargos histFuncionariosCargosCollectionOldHistFuncionariosCargos : histFuncionariosCargosCollectionOld) {
                if (!histFuncionariosCargosCollectionNew.contains(histFuncionariosCargosCollectionOldHistFuncionariosCargos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosCargos " + histFuncionariosCargosCollectionOldHistFuncionariosCargos + " since its idCargoFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idNivelCargoFkNew != null) {
                idNivelCargoFkNew = em.getReference(idNivelCargoFkNew.getClass(), idNivelCargoFkNew.getId());
                cargos.setIdNivelCargoFk(idNivelCargoFkNew);
            }
            Collection<CargosEspecialidade> attachedCargosEspecialidadeCollectionNew = new ArrayList<CargosEspecialidade>();
            for (CargosEspecialidade cargosEspecialidadeCollectionNewCargosEspecialidadeToAttach : cargosEspecialidadeCollectionNew) {
                cargosEspecialidadeCollectionNewCargosEspecialidadeToAttach = em.getReference(cargosEspecialidadeCollectionNewCargosEspecialidadeToAttach.getClass(), cargosEspecialidadeCollectionNewCargosEspecialidadeToAttach.getId());
                attachedCargosEspecialidadeCollectionNew.add(cargosEspecialidadeCollectionNewCargosEspecialidadeToAttach);
            }
            cargosEspecialidadeCollectionNew = attachedCargosEspecialidadeCollectionNew;
            cargos.setCargosEspecialidadeCollection(cargosEspecialidadeCollectionNew);
            Collection<HistFuncionariosCargos> attachedHistFuncionariosCargosCollectionNew = new ArrayList<HistFuncionariosCargos>();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach : histFuncionariosCargosCollectionNew) {
                histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach = em.getReference(histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach.getClass(), histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach.getId());
                attachedHistFuncionariosCargosCollectionNew.add(histFuncionariosCargosCollectionNewHistFuncionariosCargosToAttach);
            }
            histFuncionariosCargosCollectionNew = attachedHistFuncionariosCargosCollectionNew;
            cargos.setHistFuncionariosCargosCollection(histFuncionariosCargosCollectionNew);
            cargos = em.merge(cargos);
            if (idNivelCargoFkOld != null && !idNivelCargoFkOld.equals(idNivelCargoFkNew)) {
                idNivelCargoFkOld.getCargosCollection().remove(cargos);
                idNivelCargoFkOld = em.merge(idNivelCargoFkOld);
            }
            if (idNivelCargoFkNew != null && !idNivelCargoFkNew.equals(idNivelCargoFkOld)) {
                idNivelCargoFkNew.getCargosCollection().add(cargos);
                idNivelCargoFkNew = em.merge(idNivelCargoFkNew);
            }
            for (CargosEspecialidade cargosEspecialidadeCollectionOldCargosEspecialidade : cargosEspecialidadeCollectionOld) {
                if (!cargosEspecialidadeCollectionNew.contains(cargosEspecialidadeCollectionOldCargosEspecialidade)) {
                    cargosEspecialidadeCollectionOldCargosEspecialidade.setIdCargoFk(null);
                    cargosEspecialidadeCollectionOldCargosEspecialidade = em.merge(cargosEspecialidadeCollectionOldCargosEspecialidade);
                }
            }
            for (CargosEspecialidade cargosEspecialidadeCollectionNewCargosEspecialidade : cargosEspecialidadeCollectionNew) {
                if (!cargosEspecialidadeCollectionOld.contains(cargosEspecialidadeCollectionNewCargosEspecialidade)) {
                    Cargos oldIdCargoFkOfCargosEspecialidadeCollectionNewCargosEspecialidade = cargosEspecialidadeCollectionNewCargosEspecialidade.getIdCargoFk();
                    cargosEspecialidadeCollectionNewCargosEspecialidade.setIdCargoFk(cargos);
                    cargosEspecialidadeCollectionNewCargosEspecialidade = em.merge(cargosEspecialidadeCollectionNewCargosEspecialidade);
                    if (oldIdCargoFkOfCargosEspecialidadeCollectionNewCargosEspecialidade != null && !oldIdCargoFkOfCargosEspecialidadeCollectionNewCargosEspecialidade.equals(cargos)) {
                        oldIdCargoFkOfCargosEspecialidadeCollectionNewCargosEspecialidade.getCargosEspecialidadeCollection().remove(cargosEspecialidadeCollectionNewCargosEspecialidade);
                        oldIdCargoFkOfCargosEspecialidadeCollectionNewCargosEspecialidade = em.merge(oldIdCargoFkOfCargosEspecialidadeCollectionNewCargosEspecialidade);
                    }
                }
            }
            for (HistFuncionariosCargos histFuncionariosCargosCollectionNewHistFuncionariosCargos : histFuncionariosCargosCollectionNew) {
                if (!histFuncionariosCargosCollectionOld.contains(histFuncionariosCargosCollectionNewHistFuncionariosCargos)) {
                    Cargos oldIdCargoFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos = histFuncionariosCargosCollectionNewHistFuncionariosCargos.getIdCargoFk();
                    histFuncionariosCargosCollectionNewHistFuncionariosCargos.setIdCargoFk(cargos);
                    histFuncionariosCargosCollectionNewHistFuncionariosCargos = em.merge(histFuncionariosCargosCollectionNewHistFuncionariosCargos);
                    if (oldIdCargoFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos != null && !oldIdCargoFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos.equals(cargos)) {
                        oldIdCargoFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos.getHistFuncionariosCargosCollection().remove(histFuncionariosCargosCollectionNewHistFuncionariosCargos);
                        oldIdCargoFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos = em.merge(oldIdCargoFkOfHistFuncionariosCargosCollectionNewHistFuncionariosCargos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cargos.getId();
                if (findCargos(id) == null) {
                    throw new NonexistentEntityException("The cargos with id " + id + " no longer exists.");
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
            Cargos cargos;
            try {
                cargos = em.getReference(Cargos.class, id);
                cargos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosCargos> histFuncionariosCargosCollectionOrphanCheck = cargos.getHistFuncionariosCargosCollection();
            for (HistFuncionariosCargos histFuncionariosCargosCollectionOrphanCheckHistFuncionariosCargos : histFuncionariosCargosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cargos (" + cargos + ") cannot be destroyed since the HistFuncionariosCargos " + histFuncionariosCargosCollectionOrphanCheckHistFuncionariosCargos + " in its histFuncionariosCargosCollection field has a non-nullable idCargoFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            NiveisCargo idNivelCargoFk = cargos.getIdNivelCargoFk();
            if (idNivelCargoFk != null) {
                idNivelCargoFk.getCargosCollection().remove(cargos);
                idNivelCargoFk = em.merge(idNivelCargoFk);
            }
            Collection<CargosEspecialidade> cargosEspecialidadeCollection = cargos.getCargosEspecialidadeCollection();
            for (CargosEspecialidade cargosEspecialidadeCollectionCargosEspecialidade : cargosEspecialidadeCollection) {
                cargosEspecialidadeCollectionCargosEspecialidade.setIdCargoFk(null);
                cargosEspecialidadeCollectionCargosEspecialidade = em.merge(cargosEspecialidadeCollectionCargosEspecialidade);
            }
            em.remove(cargos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cargos> findCargosEntities() {
        return findCargosEntities(true, -1, -1);
    }

    public List<Cargos> findCargosEntities(int maxResults, int firstResult) {
        return findCargosEntities(false, maxResults, firstResult);
    }

    private List<Cargos> findCargosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cargos.class));
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

    public Cargos findCargos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cargos.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cargos> rt = cq.from(Cargos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
