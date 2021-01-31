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
import br.com.folha.model.tabelas.PessoaDocumentosCtps;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaDocumentosCtpsJpaController implements Serializable {

    public PessoaDocumentosCtpsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaDocumentosCtps pessoaDocumentosCtps) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa idPessoaFk = pessoaDocumentosCtps.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaDocumentosCtps.setIdPessoaFk(idPessoaFk);
            }
            em.persist(pessoaDocumentosCtps);
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosCtpsCollection().add(pessoaDocumentosCtps);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaDocumentosCtps pessoaDocumentosCtps) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaDocumentosCtps persistentPessoaDocumentosCtps = em.find(PessoaDocumentosCtps.class, pessoaDocumentosCtps.getId());
            Pessoa idPessoaFkOld = persistentPessoaDocumentosCtps.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaDocumentosCtps.getIdPessoaFk();
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaDocumentosCtps.setIdPessoaFk(idPessoaFkNew);
            }
            pessoaDocumentosCtps = em.merge(pessoaDocumentosCtps);
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaDocumentosCtpsCollection().remove(pessoaDocumentosCtps);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaDocumentosCtpsCollection().add(pessoaDocumentosCtps);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaDocumentosCtps.getId();
                if (findPessoaDocumentosCtps(id) == null) {
                    throw new NonexistentEntityException("The pessoaDocumentosCtps with id " + id + " no longer exists.");
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
            PessoaDocumentosCtps pessoaDocumentosCtps;
            try {
                pessoaDocumentosCtps = em.getReference(PessoaDocumentosCtps.class, id);
                pessoaDocumentosCtps.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaDocumentosCtps with id " + id + " no longer exists.", enfe);
            }
            Pessoa idPessoaFk = pessoaDocumentosCtps.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosCtpsCollection().remove(pessoaDocumentosCtps);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.remove(pessoaDocumentosCtps);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaDocumentosCtps> findPessoaDocumentosCtpsEntities() {
        return findPessoaDocumentosCtpsEntities(true, -1, -1);
    }

    public List<PessoaDocumentosCtps> findPessoaDocumentosCtpsEntities(int maxResults, int firstResult) {
        return findPessoaDocumentosCtpsEntities(false, maxResults, firstResult);
    }

    private List<PessoaDocumentosCtps> findPessoaDocumentosCtpsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaDocumentosCtps.class));
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

    public PessoaDocumentosCtps findPessoaDocumentosCtps(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaDocumentosCtps.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaDocumentosCtpsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaDocumentosCtps> rt = cq.from(PessoaDocumentosCtps.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
