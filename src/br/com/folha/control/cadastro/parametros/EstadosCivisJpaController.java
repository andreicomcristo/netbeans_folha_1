/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.EstadosCivis;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.Pessoa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class EstadosCivisJpaController implements Serializable {

    public EstadosCivisJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadosCivis estadosCivis) {
        if (estadosCivis.getPessoaCollection() == null) {
            estadosCivis.setPessoaCollection(new ArrayList<Pessoa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pessoa> attachedPessoaCollection = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionPessoaToAttach : estadosCivis.getPessoaCollection()) {
                pessoaCollectionPessoaToAttach = em.getReference(pessoaCollectionPessoaToAttach.getClass(), pessoaCollectionPessoaToAttach.getId());
                attachedPessoaCollection.add(pessoaCollectionPessoaToAttach);
            }
            estadosCivis.setPessoaCollection(attachedPessoaCollection);
            em.persist(estadosCivis);
            for (Pessoa pessoaCollectionPessoa : estadosCivis.getPessoaCollection()) {
                EstadosCivis oldSeqEstadoCivilOfPessoaCollectionPessoa = pessoaCollectionPessoa.getSeqEstadoCivil();
                pessoaCollectionPessoa.setSeqEstadoCivil(estadosCivis);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
                if (oldSeqEstadoCivilOfPessoaCollectionPessoa != null) {
                    oldSeqEstadoCivilOfPessoaCollectionPessoa.getPessoaCollection().remove(pessoaCollectionPessoa);
                    oldSeqEstadoCivilOfPessoaCollectionPessoa = em.merge(oldSeqEstadoCivilOfPessoaCollectionPessoa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadosCivis estadosCivis) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadosCivis persistentEstadosCivis = em.find(EstadosCivis.class, estadosCivis.getId());
            Collection<Pessoa> pessoaCollectionOld = persistentEstadosCivis.getPessoaCollection();
            Collection<Pessoa> pessoaCollectionNew = estadosCivis.getPessoaCollection();
            Collection<Pessoa> attachedPessoaCollectionNew = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionNewPessoaToAttach : pessoaCollectionNew) {
                pessoaCollectionNewPessoaToAttach = em.getReference(pessoaCollectionNewPessoaToAttach.getClass(), pessoaCollectionNewPessoaToAttach.getId());
                attachedPessoaCollectionNew.add(pessoaCollectionNewPessoaToAttach);
            }
            pessoaCollectionNew = attachedPessoaCollectionNew;
            estadosCivis.setPessoaCollection(pessoaCollectionNew);
            estadosCivis = em.merge(estadosCivis);
            for (Pessoa pessoaCollectionOldPessoa : pessoaCollectionOld) {
                if (!pessoaCollectionNew.contains(pessoaCollectionOldPessoa)) {
                    pessoaCollectionOldPessoa.setSeqEstadoCivil(null);
                    pessoaCollectionOldPessoa = em.merge(pessoaCollectionOldPessoa);
                }
            }
            for (Pessoa pessoaCollectionNewPessoa : pessoaCollectionNew) {
                if (!pessoaCollectionOld.contains(pessoaCollectionNewPessoa)) {
                    EstadosCivis oldSeqEstadoCivilOfPessoaCollectionNewPessoa = pessoaCollectionNewPessoa.getSeqEstadoCivil();
                    pessoaCollectionNewPessoa.setSeqEstadoCivil(estadosCivis);
                    pessoaCollectionNewPessoa = em.merge(pessoaCollectionNewPessoa);
                    if (oldSeqEstadoCivilOfPessoaCollectionNewPessoa != null && !oldSeqEstadoCivilOfPessoaCollectionNewPessoa.equals(estadosCivis)) {
                        oldSeqEstadoCivilOfPessoaCollectionNewPessoa.getPessoaCollection().remove(pessoaCollectionNewPessoa);
                        oldSeqEstadoCivilOfPessoaCollectionNewPessoa = em.merge(oldSeqEstadoCivilOfPessoaCollectionNewPessoa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estadosCivis.getId();
                if (findEstadosCivis(id) == null) {
                    throw new NonexistentEntityException("The estadosCivis with id " + id + " no longer exists.");
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
            EstadosCivis estadosCivis;
            try {
                estadosCivis = em.getReference(EstadosCivis.class, id);
                estadosCivis.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadosCivis with id " + id + " no longer exists.", enfe);
            }
            Collection<Pessoa> pessoaCollection = estadosCivis.getPessoaCollection();
            for (Pessoa pessoaCollectionPessoa : pessoaCollection) {
                pessoaCollectionPessoa.setSeqEstadoCivil(null);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
            }
            em.remove(estadosCivis);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadosCivis> findEstadosCivisEntities() {
        return findEstadosCivisEntities(true, -1, -1);
    }

    public List<EstadosCivis> findEstadosCivisEntities(int maxResults, int firstResult) {
        return findEstadosCivisEntities(false, maxResults, firstResult);
    }

    private List<EstadosCivis> findEstadosCivisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadosCivis.class));
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

    public EstadosCivis findEstadosCivis(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadosCivis.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadosCivisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadosCivis> rt = cq.from(EstadosCivis.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
