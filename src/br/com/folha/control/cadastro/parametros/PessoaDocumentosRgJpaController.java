/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.PessoaDocumentosRg;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.Uf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaDocumentosRgJpaController implements Serializable {

    public PessoaDocumentosRgJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaDocumentosRg pessoaDocumentosRg) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uf idUfEmissao = pessoaDocumentosRg.getIdUfEmissao();
            if (idUfEmissao != null) {
                idUfEmissao = em.getReference(idUfEmissao.getClass(), idUfEmissao.getId());
                pessoaDocumentosRg.setIdUfEmissao(idUfEmissao);
            }
            em.persist(pessoaDocumentosRg);
            if (idUfEmissao != null) {
                idUfEmissao.getPessoaDocumentosRgCollection().add(pessoaDocumentosRg);
                idUfEmissao = em.merge(idUfEmissao);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaDocumentosRg pessoaDocumentosRg) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaDocumentosRg persistentPessoaDocumentosRg = em.find(PessoaDocumentosRg.class, pessoaDocumentosRg.getId());
            Uf idUfEmissaoOld = persistentPessoaDocumentosRg.getIdUfEmissao();
            Uf idUfEmissaoNew = pessoaDocumentosRg.getIdUfEmissao();
            if (idUfEmissaoNew != null) {
                idUfEmissaoNew = em.getReference(idUfEmissaoNew.getClass(), idUfEmissaoNew.getId());
                pessoaDocumentosRg.setIdUfEmissao(idUfEmissaoNew);
            }
            pessoaDocumentosRg = em.merge(pessoaDocumentosRg);
            if (idUfEmissaoOld != null && !idUfEmissaoOld.equals(idUfEmissaoNew)) {
                idUfEmissaoOld.getPessoaDocumentosRgCollection().remove(pessoaDocumentosRg);
                idUfEmissaoOld = em.merge(idUfEmissaoOld);
            }
            if (idUfEmissaoNew != null && !idUfEmissaoNew.equals(idUfEmissaoOld)) {
                idUfEmissaoNew.getPessoaDocumentosRgCollection().add(pessoaDocumentosRg);
                idUfEmissaoNew = em.merge(idUfEmissaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaDocumentosRg.getId();
                if (findPessoaDocumentosRg(id) == null) {
                    throw new NonexistentEntityException("The pessoaDocumentosRg with id " + id + " no longer exists.");
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
            PessoaDocumentosRg pessoaDocumentosRg;
            try {
                pessoaDocumentosRg = em.getReference(PessoaDocumentosRg.class, id);
                pessoaDocumentosRg.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaDocumentosRg with id " + id + " no longer exists.", enfe);
            }
            Uf idUfEmissao = pessoaDocumentosRg.getIdUfEmissao();
            if (idUfEmissao != null) {
                idUfEmissao.getPessoaDocumentosRgCollection().remove(pessoaDocumentosRg);
                idUfEmissao = em.merge(idUfEmissao);
            }
            em.remove(pessoaDocumentosRg);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaDocumentosRg> findPessoaDocumentosRgEntities() {
        return findPessoaDocumentosRgEntities(true, -1, -1);
    }

    public List<PessoaDocumentosRg> findPessoaDocumentosRgEntities(int maxResults, int firstResult) {
        return findPessoaDocumentosRgEntities(false, maxResults, firstResult);
    }

    private List<PessoaDocumentosRg> findPessoaDocumentosRgEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaDocumentosRg.class));
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

    public PessoaDocumentosRg findPessoaDocumentosRg(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaDocumentosRg.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaDocumentosRgCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaDocumentosRg> rt = cq.from(PessoaDocumentosRg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
