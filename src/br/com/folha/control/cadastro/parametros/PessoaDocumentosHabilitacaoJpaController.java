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
import br.com.folha.model.tabelas.HabilitacaoCategorias;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaDocumentosHabilitacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaDocumentosHabilitacaoJpaController implements Serializable {

    public PessoaDocumentosHabilitacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HabilitacaoCategorias idHabilitacaoCategoriasFk = pessoaDocumentosHabilitacao.getIdHabilitacaoCategoriasFk();
            if (idHabilitacaoCategoriasFk != null) {
                idHabilitacaoCategoriasFk = em.getReference(idHabilitacaoCategoriasFk.getClass(), idHabilitacaoCategoriasFk.getId());
                pessoaDocumentosHabilitacao.setIdHabilitacaoCategoriasFk(idHabilitacaoCategoriasFk);
            }
            Pessoa idPessoaFk = pessoaDocumentosHabilitacao.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaDocumentosHabilitacao.setIdPessoaFk(idPessoaFk);
            }
            em.persist(pessoaDocumentosHabilitacao);
            if (idHabilitacaoCategoriasFk != null) {
                idHabilitacaoCategoriasFk.getPessoaDocumentosHabilitacaoCollection().add(pessoaDocumentosHabilitacao);
                idHabilitacaoCategoriasFk = em.merge(idHabilitacaoCategoriasFk);
            }
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosHabilitacaoCollection().add(pessoaDocumentosHabilitacao);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaDocumentosHabilitacao persistentPessoaDocumentosHabilitacao = em.find(PessoaDocumentosHabilitacao.class, pessoaDocumentosHabilitacao.getId());
            HabilitacaoCategorias idHabilitacaoCategoriasFkOld = persistentPessoaDocumentosHabilitacao.getIdHabilitacaoCategoriasFk();
            HabilitacaoCategorias idHabilitacaoCategoriasFkNew = pessoaDocumentosHabilitacao.getIdHabilitacaoCategoriasFk();
            Pessoa idPessoaFkOld = persistentPessoaDocumentosHabilitacao.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaDocumentosHabilitacao.getIdPessoaFk();
            if (idHabilitacaoCategoriasFkNew != null) {
                idHabilitacaoCategoriasFkNew = em.getReference(idHabilitacaoCategoriasFkNew.getClass(), idHabilitacaoCategoriasFkNew.getId());
                pessoaDocumentosHabilitacao.setIdHabilitacaoCategoriasFk(idHabilitacaoCategoriasFkNew);
            }
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaDocumentosHabilitacao.setIdPessoaFk(idPessoaFkNew);
            }
            pessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacao);
            if (idHabilitacaoCategoriasFkOld != null && !idHabilitacaoCategoriasFkOld.equals(idHabilitacaoCategoriasFkNew)) {
                idHabilitacaoCategoriasFkOld.getPessoaDocumentosHabilitacaoCollection().remove(pessoaDocumentosHabilitacao);
                idHabilitacaoCategoriasFkOld = em.merge(idHabilitacaoCategoriasFkOld);
            }
            if (idHabilitacaoCategoriasFkNew != null && !idHabilitacaoCategoriasFkNew.equals(idHabilitacaoCategoriasFkOld)) {
                idHabilitacaoCategoriasFkNew.getPessoaDocumentosHabilitacaoCollection().add(pessoaDocumentosHabilitacao);
                idHabilitacaoCategoriasFkNew = em.merge(idHabilitacaoCategoriasFkNew);
            }
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaDocumentosHabilitacaoCollection().remove(pessoaDocumentosHabilitacao);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaDocumentosHabilitacaoCollection().add(pessoaDocumentosHabilitacao);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaDocumentosHabilitacao.getId();
                if (findPessoaDocumentosHabilitacao(id) == null) {
                    throw new NonexistentEntityException("The pessoaDocumentosHabilitacao with id " + id + " no longer exists.");
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
            PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao;
            try {
                pessoaDocumentosHabilitacao = em.getReference(PessoaDocumentosHabilitacao.class, id);
                pessoaDocumentosHabilitacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaDocumentosHabilitacao with id " + id + " no longer exists.", enfe);
            }
            HabilitacaoCategorias idHabilitacaoCategoriasFk = pessoaDocumentosHabilitacao.getIdHabilitacaoCategoriasFk();
            if (idHabilitacaoCategoriasFk != null) {
                idHabilitacaoCategoriasFk.getPessoaDocumentosHabilitacaoCollection().remove(pessoaDocumentosHabilitacao);
                idHabilitacaoCategoriasFk = em.merge(idHabilitacaoCategoriasFk);
            }
            Pessoa idPessoaFk = pessoaDocumentosHabilitacao.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosHabilitacaoCollection().remove(pessoaDocumentosHabilitacao);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.remove(pessoaDocumentosHabilitacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaDocumentosHabilitacao> findPessoaDocumentosHabilitacaoEntities() {
        return findPessoaDocumentosHabilitacaoEntities(true, -1, -1);
    }

    public List<PessoaDocumentosHabilitacao> findPessoaDocumentosHabilitacaoEntities(int maxResults, int firstResult) {
        return findPessoaDocumentosHabilitacaoEntities(false, maxResults, firstResult);
    }

    private List<PessoaDocumentosHabilitacao> findPessoaDocumentosHabilitacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaDocumentosHabilitacao.class));
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

    public PessoaDocumentosHabilitacao findPessoaDocumentosHabilitacao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaDocumentosHabilitacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaDocumentosHabilitacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaDocumentosHabilitacao> rt = cq.from(PessoaDocumentosHabilitacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
