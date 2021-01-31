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
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaFotos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaFotosJpaController implements Serializable {

    public PessoaFotosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaFotos pessoaFotos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa idPessoaFk = pessoaFotos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaFotos.setIdPessoaFk(idPessoaFk);
            }
            em.persist(pessoaFotos);
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaFotosCollection().add(pessoaFotos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaFotos pessoaFotos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaFotos persistentPessoaFotos = em.find(PessoaFotos.class, pessoaFotos.getId());
            Pessoa idPessoaFkOld = persistentPessoaFotos.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaFotos.getIdPessoaFk();
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaFotos.setIdPessoaFk(idPessoaFkNew);
            }
            pessoaFotos = em.merge(pessoaFotos);
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaFotosCollection().remove(pessoaFotos);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaFotosCollection().add(pessoaFotos);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaFotos.getId();
                if (findPessoaFotos(id) == null) {
                    throw new NonexistentEntityException("The pessoaFotos with id " + id + " no longer exists.");
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
            PessoaFotos pessoaFotos;
            try {
                pessoaFotos = em.getReference(PessoaFotos.class, id);
                pessoaFotos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaFotos with id " + id + " no longer exists.", enfe);
            }
            Pessoa idPessoaFk = pessoaFotos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaFotosCollection().remove(pessoaFotos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.remove(pessoaFotos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaFotos> findPessoaFotosEntities() {
        return findPessoaFotosEntities(true, -1, -1);
    }

    public List<PessoaFotos> findPessoaFotosEntities(int maxResults, int firstResult) {
        return findPessoaFotosEntities(false, maxResults, firstResult);
    }

    private List<PessoaFotos> findPessoaFotosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaFotos.class));
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

    public PessoaFotos findPessoaFotos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaFotos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaFotosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaFotos> rt = cq.from(PessoaFotos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
