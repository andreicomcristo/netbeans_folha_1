/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.Escolaridades;
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
public class EscolaridadesJpaController implements Serializable {

    public EscolaridadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Escolaridades escolaridades) {
        if (escolaridades.getPessoaCollection() == null) {
            escolaridades.setPessoaCollection(new ArrayList<Pessoa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pessoa> attachedPessoaCollection = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionPessoaToAttach : escolaridades.getPessoaCollection()) {
                pessoaCollectionPessoaToAttach = em.getReference(pessoaCollectionPessoaToAttach.getClass(), pessoaCollectionPessoaToAttach.getId());
                attachedPessoaCollection.add(pessoaCollectionPessoaToAttach);
            }
            escolaridades.setPessoaCollection(attachedPessoaCollection);
            em.persist(escolaridades);
            for (Pessoa pessoaCollectionPessoa : escolaridades.getPessoaCollection()) {
                Escolaridades oldSeqEscolaridadeOfPessoaCollectionPessoa = pessoaCollectionPessoa.getSeqEscolaridade();
                pessoaCollectionPessoa.setSeqEscolaridade(escolaridades);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
                if (oldSeqEscolaridadeOfPessoaCollectionPessoa != null) {
                    oldSeqEscolaridadeOfPessoaCollectionPessoa.getPessoaCollection().remove(pessoaCollectionPessoa);
                    oldSeqEscolaridadeOfPessoaCollectionPessoa = em.merge(oldSeqEscolaridadeOfPessoaCollectionPessoa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Escolaridades escolaridades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Escolaridades persistentEscolaridades = em.find(Escolaridades.class, escolaridades.getId());
            Collection<Pessoa> pessoaCollectionOld = persistentEscolaridades.getPessoaCollection();
            Collection<Pessoa> pessoaCollectionNew = escolaridades.getPessoaCollection();
            Collection<Pessoa> attachedPessoaCollectionNew = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionNewPessoaToAttach : pessoaCollectionNew) {
                pessoaCollectionNewPessoaToAttach = em.getReference(pessoaCollectionNewPessoaToAttach.getClass(), pessoaCollectionNewPessoaToAttach.getId());
                attachedPessoaCollectionNew.add(pessoaCollectionNewPessoaToAttach);
            }
            pessoaCollectionNew = attachedPessoaCollectionNew;
            escolaridades.setPessoaCollection(pessoaCollectionNew);
            escolaridades = em.merge(escolaridades);
            for (Pessoa pessoaCollectionOldPessoa : pessoaCollectionOld) {
                if (!pessoaCollectionNew.contains(pessoaCollectionOldPessoa)) {
                    pessoaCollectionOldPessoa.setSeqEscolaridade(null);
                    pessoaCollectionOldPessoa = em.merge(pessoaCollectionOldPessoa);
                }
            }
            for (Pessoa pessoaCollectionNewPessoa : pessoaCollectionNew) {
                if (!pessoaCollectionOld.contains(pessoaCollectionNewPessoa)) {
                    Escolaridades oldSeqEscolaridadeOfPessoaCollectionNewPessoa = pessoaCollectionNewPessoa.getSeqEscolaridade();
                    pessoaCollectionNewPessoa.setSeqEscolaridade(escolaridades);
                    pessoaCollectionNewPessoa = em.merge(pessoaCollectionNewPessoa);
                    if (oldSeqEscolaridadeOfPessoaCollectionNewPessoa != null && !oldSeqEscolaridadeOfPessoaCollectionNewPessoa.equals(escolaridades)) {
                        oldSeqEscolaridadeOfPessoaCollectionNewPessoa.getPessoaCollection().remove(pessoaCollectionNewPessoa);
                        oldSeqEscolaridadeOfPessoaCollectionNewPessoa = em.merge(oldSeqEscolaridadeOfPessoaCollectionNewPessoa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = escolaridades.getId();
                if (findEscolaridades(id) == null) {
                    throw new NonexistentEntityException("The escolaridades with id " + id + " no longer exists.");
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
            Escolaridades escolaridades;
            try {
                escolaridades = em.getReference(Escolaridades.class, id);
                escolaridades.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The escolaridades with id " + id + " no longer exists.", enfe);
            }
            Collection<Pessoa> pessoaCollection = escolaridades.getPessoaCollection();
            for (Pessoa pessoaCollectionPessoa : pessoaCollection) {
                pessoaCollectionPessoa.setSeqEscolaridade(null);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
            }
            em.remove(escolaridades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Escolaridades> findEscolaridadesEntities() {
        return findEscolaridadesEntities(true, -1, -1);
    }

    public List<Escolaridades> findEscolaridadesEntities(int maxResults, int firstResult) {
        return findEscolaridadesEntities(false, maxResults, firstResult);
    }

    private List<Escolaridades> findEscolaridadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Escolaridades.class));
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

    public Escolaridades findEscolaridades(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Escolaridades.class, id);
        } finally {
            em.close();
        }
    }

    public int getEscolaridadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Escolaridades> rt = cq.from(Escolaridades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
