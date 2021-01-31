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
import br.com.folha.model.tabelas.Conselhos;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaDocumentosConselho;
import br.com.folha.model.tabelas.Uf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaDocumentosConselhoJpaController implements Serializable {

    public PessoaDocumentosConselhoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaDocumentosConselho pessoaDocumentosConselho) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conselhos idConselhosFk = pessoaDocumentosConselho.getIdConselhosFk();
            if (idConselhosFk != null) {
                idConselhosFk = em.getReference(idConselhosFk.getClass(), idConselhosFk.getId());
                pessoaDocumentosConselho.setIdConselhosFk(idConselhosFk);
            }
            Pessoa idPessoaFk = pessoaDocumentosConselho.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaDocumentosConselho.setIdPessoaFk(idPessoaFk);
            }
            Uf idUfFk = pessoaDocumentosConselho.getIdUfFk();
            if (idUfFk != null) {
                idUfFk = em.getReference(idUfFk.getClass(), idUfFk.getId());
                pessoaDocumentosConselho.setIdUfFk(idUfFk);
            }
            em.persist(pessoaDocumentosConselho);
            if (idConselhosFk != null) {
                idConselhosFk.getPessoaDocumentosConselhoCollection().add(pessoaDocumentosConselho);
                idConselhosFk = em.merge(idConselhosFk);
            }
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosConselhoCollection().add(pessoaDocumentosConselho);
                idPessoaFk = em.merge(idPessoaFk);
            }
            if (idUfFk != null) {
                idUfFk.getPessoaDocumentosConselhoCollection().add(pessoaDocumentosConselho);
                idUfFk = em.merge(idUfFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaDocumentosConselho pessoaDocumentosConselho) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaDocumentosConselho persistentPessoaDocumentosConselho = em.find(PessoaDocumentosConselho.class, pessoaDocumentosConselho.getId());
            Conselhos idConselhosFkOld = persistentPessoaDocumentosConselho.getIdConselhosFk();
            Conselhos idConselhosFkNew = pessoaDocumentosConselho.getIdConselhosFk();
            Pessoa idPessoaFkOld = persistentPessoaDocumentosConselho.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaDocumentosConselho.getIdPessoaFk();
            Uf idUfFkOld = persistentPessoaDocumentosConselho.getIdUfFk();
            Uf idUfFkNew = pessoaDocumentosConselho.getIdUfFk();
            if (idConselhosFkNew != null) {
                idConselhosFkNew = em.getReference(idConselhosFkNew.getClass(), idConselhosFkNew.getId());
                pessoaDocumentosConselho.setIdConselhosFk(idConselhosFkNew);
            }
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaDocumentosConselho.setIdPessoaFk(idPessoaFkNew);
            }
            if (idUfFkNew != null) {
                idUfFkNew = em.getReference(idUfFkNew.getClass(), idUfFkNew.getId());
                pessoaDocumentosConselho.setIdUfFk(idUfFkNew);
            }
            pessoaDocumentosConselho = em.merge(pessoaDocumentosConselho);
            if (idConselhosFkOld != null && !idConselhosFkOld.equals(idConselhosFkNew)) {
                idConselhosFkOld.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselho);
                idConselhosFkOld = em.merge(idConselhosFkOld);
            }
            if (idConselhosFkNew != null && !idConselhosFkNew.equals(idConselhosFkOld)) {
                idConselhosFkNew.getPessoaDocumentosConselhoCollection().add(pessoaDocumentosConselho);
                idConselhosFkNew = em.merge(idConselhosFkNew);
            }
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselho);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaDocumentosConselhoCollection().add(pessoaDocumentosConselho);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            if (idUfFkOld != null && !idUfFkOld.equals(idUfFkNew)) {
                idUfFkOld.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselho);
                idUfFkOld = em.merge(idUfFkOld);
            }
            if (idUfFkNew != null && !idUfFkNew.equals(idUfFkOld)) {
                idUfFkNew.getPessoaDocumentosConselhoCollection().add(pessoaDocumentosConselho);
                idUfFkNew = em.merge(idUfFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaDocumentosConselho.getId();
                if (findPessoaDocumentosConselho(id) == null) {
                    throw new NonexistentEntityException("The pessoaDocumentosConselho with id " + id + " no longer exists.");
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
            PessoaDocumentosConselho pessoaDocumentosConselho;
            try {
                pessoaDocumentosConselho = em.getReference(PessoaDocumentosConselho.class, id);
                pessoaDocumentosConselho.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaDocumentosConselho with id " + id + " no longer exists.", enfe);
            }
            Conselhos idConselhosFk = pessoaDocumentosConselho.getIdConselhosFk();
            if (idConselhosFk != null) {
                idConselhosFk.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselho);
                idConselhosFk = em.merge(idConselhosFk);
            }
            Pessoa idPessoaFk = pessoaDocumentosConselho.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselho);
                idPessoaFk = em.merge(idPessoaFk);
            }
            Uf idUfFk = pessoaDocumentosConselho.getIdUfFk();
            if (idUfFk != null) {
                idUfFk.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselho);
                idUfFk = em.merge(idUfFk);
            }
            em.remove(pessoaDocumentosConselho);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaDocumentosConselho> findPessoaDocumentosConselhoEntities() {
        return findPessoaDocumentosConselhoEntities(true, -1, -1);
    }

    public List<PessoaDocumentosConselho> findPessoaDocumentosConselhoEntities(int maxResults, int firstResult) {
        return findPessoaDocumentosConselhoEntities(false, maxResults, firstResult);
    }

    private List<PessoaDocumentosConselho> findPessoaDocumentosConselhoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaDocumentosConselho.class));
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

    public PessoaDocumentosConselho findPessoaDocumentosConselho(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaDocumentosConselho.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaDocumentosConselhoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaDocumentosConselho> rt = cq.from(PessoaDocumentosConselho.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
