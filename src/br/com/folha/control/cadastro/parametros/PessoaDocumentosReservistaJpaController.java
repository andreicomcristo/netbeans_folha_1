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
import br.com.folha.model.tabelas.PessoaDocumentosReservista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaDocumentosReservistaJpaController implements Serializable {

    public PessoaDocumentosReservistaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaDocumentosReservista pessoaDocumentosReservista) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa idPessoaFk = pessoaDocumentosReservista.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaDocumentosReservista.setIdPessoaFk(idPessoaFk);
            }
            em.persist(pessoaDocumentosReservista);
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosReservistaCollection().add(pessoaDocumentosReservista);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaDocumentosReservista pessoaDocumentosReservista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaDocumentosReservista persistentPessoaDocumentosReservista = em.find(PessoaDocumentosReservista.class, pessoaDocumentosReservista.getId());
            Pessoa idPessoaFkOld = persistentPessoaDocumentosReservista.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaDocumentosReservista.getIdPessoaFk();
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaDocumentosReservista.setIdPessoaFk(idPessoaFkNew);
            }
            pessoaDocumentosReservista = em.merge(pessoaDocumentosReservista);
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaDocumentosReservistaCollection().remove(pessoaDocumentosReservista);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaDocumentosReservistaCollection().add(pessoaDocumentosReservista);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaDocumentosReservista.getId();
                if (findPessoaDocumentosReservista(id) == null) {
                    throw new NonexistentEntityException("The pessoaDocumentosReservista with id " + id + " no longer exists.");
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
            PessoaDocumentosReservista pessoaDocumentosReservista;
            try {
                pessoaDocumentosReservista = em.getReference(PessoaDocumentosReservista.class, id);
                pessoaDocumentosReservista.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaDocumentosReservista with id " + id + " no longer exists.", enfe);
            }
            Pessoa idPessoaFk = pessoaDocumentosReservista.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosReservistaCollection().remove(pessoaDocumentosReservista);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.remove(pessoaDocumentosReservista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaDocumentosReservista> findPessoaDocumentosReservistaEntities() {
        return findPessoaDocumentosReservistaEntities(true, -1, -1);
    }

    public List<PessoaDocumentosReservista> findPessoaDocumentosReservistaEntities(int maxResults, int firstResult) {
        return findPessoaDocumentosReservistaEntities(false, maxResults, firstResult);
    }

    private List<PessoaDocumentosReservista> findPessoaDocumentosReservistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaDocumentosReservista.class));
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

    public PessoaDocumentosReservista findPessoaDocumentosReservista(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaDocumentosReservista.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaDocumentosReservistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaDocumentosReservista> rt = cq.from(PessoaDocumentosReservista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
