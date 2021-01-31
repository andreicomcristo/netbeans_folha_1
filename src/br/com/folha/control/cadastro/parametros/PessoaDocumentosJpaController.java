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
import br.com.folha.model.tabelas.PessoaDocumentos;
import br.com.folha.model.tabelas.TiposDeDocumento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaDocumentosJpaController implements Serializable {

    public PessoaDocumentosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaDocumentos pessoaDocumentos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa idPessoaFk = pessoaDocumentos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaDocumentos.setIdPessoaFk(idPessoaFk);
            }
            TiposDeDocumento idTiposDeDocumentoFk = pessoaDocumentos.getIdTiposDeDocumentoFk();
            if (idTiposDeDocumentoFk != null) {
                idTiposDeDocumentoFk = em.getReference(idTiposDeDocumentoFk.getClass(), idTiposDeDocumentoFk.getId());
                pessoaDocumentos.setIdTiposDeDocumentoFk(idTiposDeDocumentoFk);
            }
            em.persist(pessoaDocumentos);
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosCollection().add(pessoaDocumentos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            if (idTiposDeDocumentoFk != null) {
                idTiposDeDocumentoFk.getPessoaDocumentosCollection().add(pessoaDocumentos);
                idTiposDeDocumentoFk = em.merge(idTiposDeDocumentoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaDocumentos pessoaDocumentos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaDocumentos persistentPessoaDocumentos = em.find(PessoaDocumentos.class, pessoaDocumentos.getId());
            Pessoa idPessoaFkOld = persistentPessoaDocumentos.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaDocumentos.getIdPessoaFk();
            TiposDeDocumento idTiposDeDocumentoFkOld = persistentPessoaDocumentos.getIdTiposDeDocumentoFk();
            TiposDeDocumento idTiposDeDocumentoFkNew = pessoaDocumentos.getIdTiposDeDocumentoFk();
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaDocumentos.setIdPessoaFk(idPessoaFkNew);
            }
            if (idTiposDeDocumentoFkNew != null) {
                idTiposDeDocumentoFkNew = em.getReference(idTiposDeDocumentoFkNew.getClass(), idTiposDeDocumentoFkNew.getId());
                pessoaDocumentos.setIdTiposDeDocumentoFk(idTiposDeDocumentoFkNew);
            }
            pessoaDocumentos = em.merge(pessoaDocumentos);
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaDocumentosCollection().remove(pessoaDocumentos);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaDocumentosCollection().add(pessoaDocumentos);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            if (idTiposDeDocumentoFkOld != null && !idTiposDeDocumentoFkOld.equals(idTiposDeDocumentoFkNew)) {
                idTiposDeDocumentoFkOld.getPessoaDocumentosCollection().remove(pessoaDocumentos);
                idTiposDeDocumentoFkOld = em.merge(idTiposDeDocumentoFkOld);
            }
            if (idTiposDeDocumentoFkNew != null && !idTiposDeDocumentoFkNew.equals(idTiposDeDocumentoFkOld)) {
                idTiposDeDocumentoFkNew.getPessoaDocumentosCollection().add(pessoaDocumentos);
                idTiposDeDocumentoFkNew = em.merge(idTiposDeDocumentoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaDocumentos.getId();
                if (findPessoaDocumentos(id) == null) {
                    throw new NonexistentEntityException("The pessoaDocumentos with id " + id + " no longer exists.");
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
            PessoaDocumentos pessoaDocumentos;
            try {
                pessoaDocumentos = em.getReference(PessoaDocumentos.class, id);
                pessoaDocumentos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaDocumentos with id " + id + " no longer exists.", enfe);
            }
            Pessoa idPessoaFk = pessoaDocumentos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosCollection().remove(pessoaDocumentos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            TiposDeDocumento idTiposDeDocumentoFk = pessoaDocumentos.getIdTiposDeDocumentoFk();
            if (idTiposDeDocumentoFk != null) {
                idTiposDeDocumentoFk.getPessoaDocumentosCollection().remove(pessoaDocumentos);
                idTiposDeDocumentoFk = em.merge(idTiposDeDocumentoFk);
            }
            em.remove(pessoaDocumentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaDocumentos> findPessoaDocumentosEntities() {
        return findPessoaDocumentosEntities(true, -1, -1);
    }

    public List<PessoaDocumentos> findPessoaDocumentosEntities(int maxResults, int firstResult) {
        return findPessoaDocumentosEntities(false, maxResults, firstResult);
    }

    private List<PessoaDocumentos> findPessoaDocumentosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaDocumentos.class));
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

    public PessoaDocumentos findPessoaDocumentos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaDocumentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaDocumentosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaDocumentos> rt = cq.from(PessoaDocumentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
