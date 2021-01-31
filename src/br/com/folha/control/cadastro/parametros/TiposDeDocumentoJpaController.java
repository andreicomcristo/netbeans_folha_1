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
import br.com.folha.model.tabelas.PessoaDocumentos;
import br.com.folha.model.tabelas.TiposDeDocumento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class TiposDeDocumentoJpaController implements Serializable {

    public TiposDeDocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TiposDeDocumento tiposDeDocumento) {
        if (tiposDeDocumento.getPessoaDocumentosCollection() == null) {
            tiposDeDocumento.setPessoaDocumentosCollection(new ArrayList<PessoaDocumentos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<PessoaDocumentos> attachedPessoaDocumentosCollection = new ArrayList<PessoaDocumentos>();
            for (PessoaDocumentos pessoaDocumentosCollectionPessoaDocumentosToAttach : tiposDeDocumento.getPessoaDocumentosCollection()) {
                pessoaDocumentosCollectionPessoaDocumentosToAttach = em.getReference(pessoaDocumentosCollectionPessoaDocumentosToAttach.getClass(), pessoaDocumentosCollectionPessoaDocumentosToAttach.getId());
                attachedPessoaDocumentosCollection.add(pessoaDocumentosCollectionPessoaDocumentosToAttach);
            }
            tiposDeDocumento.setPessoaDocumentosCollection(attachedPessoaDocumentosCollection);
            em.persist(tiposDeDocumento);
            for (PessoaDocumentos pessoaDocumentosCollectionPessoaDocumentos : tiposDeDocumento.getPessoaDocumentosCollection()) {
                TiposDeDocumento oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionPessoaDocumentos = pessoaDocumentosCollectionPessoaDocumentos.getIdTiposDeDocumentoFk();
                pessoaDocumentosCollectionPessoaDocumentos.setIdTiposDeDocumentoFk(tiposDeDocumento);
                pessoaDocumentosCollectionPessoaDocumentos = em.merge(pessoaDocumentosCollectionPessoaDocumentos);
                if (oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionPessoaDocumentos != null) {
                    oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionPessoaDocumentos.getPessoaDocumentosCollection().remove(pessoaDocumentosCollectionPessoaDocumentos);
                    oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionPessoaDocumentos = em.merge(oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionPessoaDocumentos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TiposDeDocumento tiposDeDocumento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TiposDeDocumento persistentTiposDeDocumento = em.find(TiposDeDocumento.class, tiposDeDocumento.getId());
            Collection<PessoaDocumentos> pessoaDocumentosCollectionOld = persistentTiposDeDocumento.getPessoaDocumentosCollection();
            Collection<PessoaDocumentos> pessoaDocumentosCollectionNew = tiposDeDocumento.getPessoaDocumentosCollection();
            Collection<PessoaDocumentos> attachedPessoaDocumentosCollectionNew = new ArrayList<PessoaDocumentos>();
            for (PessoaDocumentos pessoaDocumentosCollectionNewPessoaDocumentosToAttach : pessoaDocumentosCollectionNew) {
                pessoaDocumentosCollectionNewPessoaDocumentosToAttach = em.getReference(pessoaDocumentosCollectionNewPessoaDocumentosToAttach.getClass(), pessoaDocumentosCollectionNewPessoaDocumentosToAttach.getId());
                attachedPessoaDocumentosCollectionNew.add(pessoaDocumentosCollectionNewPessoaDocumentosToAttach);
            }
            pessoaDocumentosCollectionNew = attachedPessoaDocumentosCollectionNew;
            tiposDeDocumento.setPessoaDocumentosCollection(pessoaDocumentosCollectionNew);
            tiposDeDocumento = em.merge(tiposDeDocumento);
            for (PessoaDocumentos pessoaDocumentosCollectionOldPessoaDocumentos : pessoaDocumentosCollectionOld) {
                if (!pessoaDocumentosCollectionNew.contains(pessoaDocumentosCollectionOldPessoaDocumentos)) {
                    pessoaDocumentosCollectionOldPessoaDocumentos.setIdTiposDeDocumentoFk(null);
                    pessoaDocumentosCollectionOldPessoaDocumentos = em.merge(pessoaDocumentosCollectionOldPessoaDocumentos);
                }
            }
            for (PessoaDocumentos pessoaDocumentosCollectionNewPessoaDocumentos : pessoaDocumentosCollectionNew) {
                if (!pessoaDocumentosCollectionOld.contains(pessoaDocumentosCollectionNewPessoaDocumentos)) {
                    TiposDeDocumento oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionNewPessoaDocumentos = pessoaDocumentosCollectionNewPessoaDocumentos.getIdTiposDeDocumentoFk();
                    pessoaDocumentosCollectionNewPessoaDocumentos.setIdTiposDeDocumentoFk(tiposDeDocumento);
                    pessoaDocumentosCollectionNewPessoaDocumentos = em.merge(pessoaDocumentosCollectionNewPessoaDocumentos);
                    if (oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionNewPessoaDocumentos != null && !oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionNewPessoaDocumentos.equals(tiposDeDocumento)) {
                        oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionNewPessoaDocumentos.getPessoaDocumentosCollection().remove(pessoaDocumentosCollectionNewPessoaDocumentos);
                        oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionNewPessoaDocumentos = em.merge(oldIdTiposDeDocumentoFkOfPessoaDocumentosCollectionNewPessoaDocumentos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tiposDeDocumento.getId();
                if (findTiposDeDocumento(id) == null) {
                    throw new NonexistentEntityException("The tiposDeDocumento with id " + id + " no longer exists.");
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
            TiposDeDocumento tiposDeDocumento;
            try {
                tiposDeDocumento = em.getReference(TiposDeDocumento.class, id);
                tiposDeDocumento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiposDeDocumento with id " + id + " no longer exists.", enfe);
            }
            Collection<PessoaDocumentos> pessoaDocumentosCollection = tiposDeDocumento.getPessoaDocumentosCollection();
            for (PessoaDocumentos pessoaDocumentosCollectionPessoaDocumentos : pessoaDocumentosCollection) {
                pessoaDocumentosCollectionPessoaDocumentos.setIdTiposDeDocumentoFk(null);
                pessoaDocumentosCollectionPessoaDocumentos = em.merge(pessoaDocumentosCollectionPessoaDocumentos);
            }
            em.remove(tiposDeDocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TiposDeDocumento> findTiposDeDocumentoEntities() {
        return findTiposDeDocumentoEntities(true, -1, -1);
    }

    public List<TiposDeDocumento> findTiposDeDocumentoEntities(int maxResults, int firstResult) {
        return findTiposDeDocumentoEntities(false, maxResults, firstResult);
    }

    private List<TiposDeDocumento> findTiposDeDocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TiposDeDocumento.class));
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

    public TiposDeDocumento findTiposDeDocumento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TiposDeDocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiposDeDocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TiposDeDocumento> rt = cq.from(TiposDeDocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
