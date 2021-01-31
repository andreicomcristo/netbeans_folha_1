/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.Conselhos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaDocumentosConselho;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class ConselhosJpaController implements Serializable {

    public ConselhosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conselhos conselhos) {
        if (conselhos.getPessoaDocumentosConselhoCollection() == null) {
            conselhos.setPessoaDocumentosConselhoCollection(new ArrayList<PessoaDocumentosConselho>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<PessoaDocumentosConselho> attachedPessoaDocumentosConselhoCollection = new ArrayList<PessoaDocumentosConselho>();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach : conselhos.getPessoaDocumentosConselhoCollection()) {
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach = em.getReference(pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach.getClass(), pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach.getId());
                attachedPessoaDocumentosConselhoCollection.add(pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach);
            }
            conselhos.setPessoaDocumentosConselhoCollection(attachedPessoaDocumentosConselhoCollection);
            em.persist(conselhos);
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionPessoaDocumentosConselho : conselhos.getPessoaDocumentosConselhoCollection()) {
                Conselhos oldIdConselhosFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho = pessoaDocumentosConselhoCollectionPessoaDocumentosConselho.getIdConselhosFk();
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho.setIdConselhosFk(conselhos);
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                if (oldIdConselhosFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho != null) {
                    oldIdConselhosFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                    oldIdConselhosFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho = em.merge(oldIdConselhosFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conselhos conselhos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conselhos persistentConselhos = em.find(Conselhos.class, conselhos.getId());
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollectionOld = persistentConselhos.getPessoaDocumentosConselhoCollection();
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollectionNew = conselhos.getPessoaDocumentosConselhoCollection();
            Collection<PessoaDocumentosConselho> attachedPessoaDocumentosConselhoCollectionNew = new ArrayList<PessoaDocumentosConselho>();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach : pessoaDocumentosConselhoCollectionNew) {
                pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach = em.getReference(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach.getClass(), pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach.getId());
                attachedPessoaDocumentosConselhoCollectionNew.add(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach);
            }
            pessoaDocumentosConselhoCollectionNew = attachedPessoaDocumentosConselhoCollectionNew;
            conselhos.setPessoaDocumentosConselhoCollection(pessoaDocumentosConselhoCollectionNew);
            conselhos = em.merge(conselhos);
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho : pessoaDocumentosConselhoCollectionOld) {
                if (!pessoaDocumentosConselhoCollectionNew.contains(pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho)) {
                    pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho.setIdConselhosFk(null);
                    pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho);
                }
            }
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho : pessoaDocumentosConselhoCollectionNew) {
                if (!pessoaDocumentosConselhoCollectionOld.contains(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho)) {
                    Conselhos oldIdConselhosFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.getIdConselhosFk();
                    pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.setIdConselhosFk(conselhos);
                    pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                    if (oldIdConselhosFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho != null && !oldIdConselhosFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.equals(conselhos)) {
                        oldIdConselhosFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                        oldIdConselhosFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = em.merge(oldIdConselhosFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = conselhos.getId();
                if (findConselhos(id) == null) {
                    throw new NonexistentEntityException("The conselhos with id " + id + " no longer exists.");
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
            Conselhos conselhos;
            try {
                conselhos = em.getReference(Conselhos.class, id);
                conselhos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conselhos with id " + id + " no longer exists.", enfe);
            }
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection = conselhos.getPessoaDocumentosConselhoCollection();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionPessoaDocumentosConselho : pessoaDocumentosConselhoCollection) {
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho.setIdConselhosFk(null);
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
            }
            em.remove(conselhos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conselhos> findConselhosEntities() {
        return findConselhosEntities(true, -1, -1);
    }

    public List<Conselhos> findConselhosEntities(int maxResults, int firstResult) {
        return findConselhosEntities(false, maxResults, firstResult);
    }

    private List<Conselhos> findConselhosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conselhos.class));
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

    public Conselhos findConselhos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conselhos.class, id);
        } finally {
            em.close();
        }
    }

    public int getConselhosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conselhos> rt = cq.from(Conselhos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
