/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.Cargos;
import br.com.folha.model.tabelas.CargosEspecialidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class CargosEspecialidadeJpaController implements Serializable {

    public CargosEspecialidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CargosEspecialidade cargosEspecialidade) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargos idCargoFk = cargosEspecialidade.getIdCargoFk();
            if (idCargoFk != null) {
                idCargoFk = em.getReference(idCargoFk.getClass(), idCargoFk.getId());
                cargosEspecialidade.setIdCargoFk(idCargoFk);
            }
            em.persist(cargosEspecialidade);
            if (idCargoFk != null) {
                idCargoFk.getCargosEspecialidadeCollection().add(cargosEspecialidade);
                idCargoFk = em.merge(idCargoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CargosEspecialidade cargosEspecialidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CargosEspecialidade persistentCargosEspecialidade = em.find(CargosEspecialidade.class, cargosEspecialidade.getId());
            Cargos idCargoFkOld = persistentCargosEspecialidade.getIdCargoFk();
            Cargos idCargoFkNew = cargosEspecialidade.getIdCargoFk();
            if (idCargoFkNew != null) {
                idCargoFkNew = em.getReference(idCargoFkNew.getClass(), idCargoFkNew.getId());
                cargosEspecialidade.setIdCargoFk(idCargoFkNew);
            }
            cargosEspecialidade = em.merge(cargosEspecialidade);
            if (idCargoFkOld != null && !idCargoFkOld.equals(idCargoFkNew)) {
                idCargoFkOld.getCargosEspecialidadeCollection().remove(cargosEspecialidade);
                idCargoFkOld = em.merge(idCargoFkOld);
            }
            if (idCargoFkNew != null && !idCargoFkNew.equals(idCargoFkOld)) {
                idCargoFkNew.getCargosEspecialidadeCollection().add(cargosEspecialidade);
                idCargoFkNew = em.merge(idCargoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cargosEspecialidade.getId();
                if (findCargosEspecialidade(id) == null) {
                    throw new NonexistentEntityException("The cargosEspecialidade with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CargosEspecialidade cargosEspecialidade;
            try {
                cargosEspecialidade = em.getReference(CargosEspecialidade.class, id);
                cargosEspecialidade.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargosEspecialidade with id " + id + " no longer exists.", enfe);
            }
            Cargos idCargoFk = cargosEspecialidade.getIdCargoFk();
            if (idCargoFk != null) {
                idCargoFk.getCargosEspecialidadeCollection().remove(cargosEspecialidade);
                idCargoFk = em.merge(idCargoFk);
            }
            em.remove(cargosEspecialidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CargosEspecialidade> findCargosEspecialidadeEntities() {
        return findCargosEspecialidadeEntities(true, -1, -1);
    }

    public List<CargosEspecialidade> findCargosEspecialidadeEntities(int maxResults, int firstResult) {
        return findCargosEspecialidadeEntities(false, maxResults, firstResult);
    }

    private List<CargosEspecialidade> findCargosEspecialidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CargosEspecialidade.class));
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

    public CargosEspecialidade findCargosEspecialidade(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CargosEspecialidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargosEspecialidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CargosEspecialidade> rt = cq.from(CargosEspecialidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
