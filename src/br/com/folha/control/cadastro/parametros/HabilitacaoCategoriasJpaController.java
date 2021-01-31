/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.HabilitacaoCategorias;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaDocumentosHabilitacao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HabilitacaoCategoriasJpaController implements Serializable {

    public HabilitacaoCategoriasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HabilitacaoCategorias habilitacaoCategorias) {
        if (habilitacaoCategorias.getPessoaDocumentosHabilitacaoCollection() == null) {
            habilitacaoCategorias.setPessoaDocumentosHabilitacaoCollection(new ArrayList<PessoaDocumentosHabilitacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<PessoaDocumentosHabilitacao> attachedPessoaDocumentosHabilitacaoCollection = new ArrayList<PessoaDocumentosHabilitacao>();
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach : habilitacaoCategorias.getPessoaDocumentosHabilitacaoCollection()) {
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach = em.getReference(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach.getClass(), pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach.getId());
                attachedPessoaDocumentosHabilitacaoCollection.add(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach);
            }
            habilitacaoCategorias.setPessoaDocumentosHabilitacaoCollection(attachedPessoaDocumentosHabilitacaoCollection);
            em.persist(habilitacaoCategorias);
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao : habilitacaoCategorias.getPessoaDocumentosHabilitacaoCollection()) {
                HabilitacaoCategorias oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao = pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao.getIdHabilitacaoCategoriasFk();
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao.setIdHabilitacaoCategoriasFk(habilitacaoCategorias);
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao);
                if (oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao != null) {
                    oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao.getPessoaDocumentosHabilitacaoCollection().remove(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao);
                    oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao = em.merge(oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HabilitacaoCategorias habilitacaoCategorias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HabilitacaoCategorias persistentHabilitacaoCategorias = em.find(HabilitacaoCategorias.class, habilitacaoCategorias.getId());
            Collection<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollectionOld = persistentHabilitacaoCategorias.getPessoaDocumentosHabilitacaoCollection();
            Collection<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollectionNew = habilitacaoCategorias.getPessoaDocumentosHabilitacaoCollection();
            Collection<PessoaDocumentosHabilitacao> attachedPessoaDocumentosHabilitacaoCollectionNew = new ArrayList<PessoaDocumentosHabilitacao>();
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach : pessoaDocumentosHabilitacaoCollectionNew) {
                pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach = em.getReference(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach.getClass(), pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach.getId());
                attachedPessoaDocumentosHabilitacaoCollectionNew.add(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach);
            }
            pessoaDocumentosHabilitacaoCollectionNew = attachedPessoaDocumentosHabilitacaoCollectionNew;
            habilitacaoCategorias.setPessoaDocumentosHabilitacaoCollection(pessoaDocumentosHabilitacaoCollectionNew);
            habilitacaoCategorias = em.merge(habilitacaoCategorias);
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao : pessoaDocumentosHabilitacaoCollectionOld) {
                if (!pessoaDocumentosHabilitacaoCollectionNew.contains(pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao)) {
                    pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao.setIdHabilitacaoCategoriasFk(null);
                    pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao);
                }
            }
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao : pessoaDocumentosHabilitacaoCollectionNew) {
                if (!pessoaDocumentosHabilitacaoCollectionOld.contains(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao)) {
                    HabilitacaoCategorias oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao = pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao.getIdHabilitacaoCategoriasFk();
                    pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao.setIdHabilitacaoCategoriasFk(habilitacaoCategorias);
                    pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao);
                    if (oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao != null && !oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao.equals(habilitacaoCategorias)) {
                        oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao.getPessoaDocumentosHabilitacaoCollection().remove(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao);
                        oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao = em.merge(oldIdHabilitacaoCategoriasFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = habilitacaoCategorias.getId();
                if (findHabilitacaoCategorias(id) == null) {
                    throw new NonexistentEntityException("The habilitacaoCategorias with id " + id + " no longer exists.");
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
            HabilitacaoCategorias habilitacaoCategorias;
            try {
                habilitacaoCategorias = em.getReference(HabilitacaoCategorias.class, id);
                habilitacaoCategorias.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The habilitacaoCategorias with id " + id + " no longer exists.", enfe);
            }
            Collection<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollection = habilitacaoCategorias.getPessoaDocumentosHabilitacaoCollection();
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao : pessoaDocumentosHabilitacaoCollection) {
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao.setIdHabilitacaoCategoriasFk(null);
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao);
            }
            em.remove(habilitacaoCategorias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HabilitacaoCategorias> findHabilitacaoCategoriasEntities() {
        return findHabilitacaoCategoriasEntities(true, -1, -1);
    }

    public List<HabilitacaoCategorias> findHabilitacaoCategoriasEntities(int maxResults, int firstResult) {
        return findHabilitacaoCategoriasEntities(false, maxResults, firstResult);
    }

    private List<HabilitacaoCategorias> findHabilitacaoCategoriasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HabilitacaoCategorias.class));
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

    public HabilitacaoCategorias findHabilitacaoCategorias(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HabilitacaoCategorias.class, id);
        } finally {
            em.close();
        }
    }

    public int getHabilitacaoCategoriasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HabilitacaoCategorias> rt = cq.from(HabilitacaoCategorias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
