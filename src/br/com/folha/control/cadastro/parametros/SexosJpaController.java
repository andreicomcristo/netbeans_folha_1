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
import br.com.folha.model.tabelas.Sexos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class SexosJpaController implements Serializable {

    public SexosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sexos sexos) {
        if (sexos.getPessoaCollection() == null) {
            sexos.setPessoaCollection(new ArrayList<Pessoa>());
        }
        if (sexos.getPessoaCollection1() == null) {
            sexos.setPessoaCollection1(new ArrayList<Pessoa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pessoa> attachedPessoaCollection = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionPessoaToAttach : sexos.getPessoaCollection()) {
                pessoaCollectionPessoaToAttach = em.getReference(pessoaCollectionPessoaToAttach.getClass(), pessoaCollectionPessoaToAttach.getId());
                attachedPessoaCollection.add(pessoaCollectionPessoaToAttach);
            }
            sexos.setPessoaCollection(attachedPessoaCollection);
            Collection<Pessoa> attachedPessoaCollection1 = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollection1PessoaToAttach : sexos.getPessoaCollection1()) {
                pessoaCollection1PessoaToAttach = em.getReference(pessoaCollection1PessoaToAttach.getClass(), pessoaCollection1PessoaToAttach.getId());
                attachedPessoaCollection1.add(pessoaCollection1PessoaToAttach);
            }
            sexos.setPessoaCollection1(attachedPessoaCollection1);
            em.persist(sexos);
            for (Pessoa pessoaCollectionPessoa : sexos.getPessoaCollection()) {
                Sexos oldSeqSexoDeclaradoOfPessoaCollectionPessoa = pessoaCollectionPessoa.getSeqSexoDeclarado();
                pessoaCollectionPessoa.setSeqSexoDeclarado(sexos);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
                if (oldSeqSexoDeclaradoOfPessoaCollectionPessoa != null) {
                    oldSeqSexoDeclaradoOfPessoaCollectionPessoa.getPessoaCollection().remove(pessoaCollectionPessoa);
                    oldSeqSexoDeclaradoOfPessoaCollectionPessoa = em.merge(oldSeqSexoDeclaradoOfPessoaCollectionPessoa);
                }
            }
            for (Pessoa pessoaCollection1Pessoa : sexos.getPessoaCollection1()) {
                Sexos oldSeqSexoOfPessoaCollection1Pessoa = pessoaCollection1Pessoa.getSeqSexo();
                pessoaCollection1Pessoa.setSeqSexo(sexos);
                pessoaCollection1Pessoa = em.merge(pessoaCollection1Pessoa);
                if (oldSeqSexoOfPessoaCollection1Pessoa != null) {
                    oldSeqSexoOfPessoaCollection1Pessoa.getPessoaCollection1().remove(pessoaCollection1Pessoa);
                    oldSeqSexoOfPessoaCollection1Pessoa = em.merge(oldSeqSexoOfPessoaCollection1Pessoa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sexos sexos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sexos persistentSexos = em.find(Sexos.class, sexos.getId());
            Collection<Pessoa> pessoaCollectionOld = persistentSexos.getPessoaCollection();
            Collection<Pessoa> pessoaCollectionNew = sexos.getPessoaCollection();
            Collection<Pessoa> pessoaCollection1Old = persistentSexos.getPessoaCollection1();
            Collection<Pessoa> pessoaCollection1New = sexos.getPessoaCollection1();
            Collection<Pessoa> attachedPessoaCollectionNew = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionNewPessoaToAttach : pessoaCollectionNew) {
                pessoaCollectionNewPessoaToAttach = em.getReference(pessoaCollectionNewPessoaToAttach.getClass(), pessoaCollectionNewPessoaToAttach.getId());
                attachedPessoaCollectionNew.add(pessoaCollectionNewPessoaToAttach);
            }
            pessoaCollectionNew = attachedPessoaCollectionNew;
            sexos.setPessoaCollection(pessoaCollectionNew);
            Collection<Pessoa> attachedPessoaCollection1New = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollection1NewPessoaToAttach : pessoaCollection1New) {
                pessoaCollection1NewPessoaToAttach = em.getReference(pessoaCollection1NewPessoaToAttach.getClass(), pessoaCollection1NewPessoaToAttach.getId());
                attachedPessoaCollection1New.add(pessoaCollection1NewPessoaToAttach);
            }
            pessoaCollection1New = attachedPessoaCollection1New;
            sexos.setPessoaCollection1(pessoaCollection1New);
            sexos = em.merge(sexos);
            for (Pessoa pessoaCollectionOldPessoa : pessoaCollectionOld) {
                if (!pessoaCollectionNew.contains(pessoaCollectionOldPessoa)) {
                    pessoaCollectionOldPessoa.setSeqSexoDeclarado(null);
                    pessoaCollectionOldPessoa = em.merge(pessoaCollectionOldPessoa);
                }
            }
            for (Pessoa pessoaCollectionNewPessoa : pessoaCollectionNew) {
                if (!pessoaCollectionOld.contains(pessoaCollectionNewPessoa)) {
                    Sexos oldSeqSexoDeclaradoOfPessoaCollectionNewPessoa = pessoaCollectionNewPessoa.getSeqSexoDeclarado();
                    pessoaCollectionNewPessoa.setSeqSexoDeclarado(sexos);
                    pessoaCollectionNewPessoa = em.merge(pessoaCollectionNewPessoa);
                    if (oldSeqSexoDeclaradoOfPessoaCollectionNewPessoa != null && !oldSeqSexoDeclaradoOfPessoaCollectionNewPessoa.equals(sexos)) {
                        oldSeqSexoDeclaradoOfPessoaCollectionNewPessoa.getPessoaCollection().remove(pessoaCollectionNewPessoa);
                        oldSeqSexoDeclaradoOfPessoaCollectionNewPessoa = em.merge(oldSeqSexoDeclaradoOfPessoaCollectionNewPessoa);
                    }
                }
            }
            for (Pessoa pessoaCollection1OldPessoa : pessoaCollection1Old) {
                if (!pessoaCollection1New.contains(pessoaCollection1OldPessoa)) {
                    pessoaCollection1OldPessoa.setSeqSexo(null);
                    pessoaCollection1OldPessoa = em.merge(pessoaCollection1OldPessoa);
                }
            }
            for (Pessoa pessoaCollection1NewPessoa : pessoaCollection1New) {
                if (!pessoaCollection1Old.contains(pessoaCollection1NewPessoa)) {
                    Sexos oldSeqSexoOfPessoaCollection1NewPessoa = pessoaCollection1NewPessoa.getSeqSexo();
                    pessoaCollection1NewPessoa.setSeqSexo(sexos);
                    pessoaCollection1NewPessoa = em.merge(pessoaCollection1NewPessoa);
                    if (oldSeqSexoOfPessoaCollection1NewPessoa != null && !oldSeqSexoOfPessoaCollection1NewPessoa.equals(sexos)) {
                        oldSeqSexoOfPessoaCollection1NewPessoa.getPessoaCollection1().remove(pessoaCollection1NewPessoa);
                        oldSeqSexoOfPessoaCollection1NewPessoa = em.merge(oldSeqSexoOfPessoaCollection1NewPessoa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = sexos.getId();
                if (findSexos(id) == null) {
                    throw new NonexistentEntityException("The sexos with id " + id + " no longer exists.");
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
            Sexos sexos;
            try {
                sexos = em.getReference(Sexos.class, id);
                sexos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sexos with id " + id + " no longer exists.", enfe);
            }
            Collection<Pessoa> pessoaCollection = sexos.getPessoaCollection();
            for (Pessoa pessoaCollectionPessoa : pessoaCollection) {
                pessoaCollectionPessoa.setSeqSexoDeclarado(null);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
            }
            Collection<Pessoa> pessoaCollection1 = sexos.getPessoaCollection1();
            for (Pessoa pessoaCollection1Pessoa : pessoaCollection1) {
                pessoaCollection1Pessoa.setSeqSexo(null);
                pessoaCollection1Pessoa = em.merge(pessoaCollection1Pessoa);
            }
            em.remove(sexos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sexos> findSexosEntities() {
        return findSexosEntities(true, -1, -1);
    }

    public List<Sexos> findSexosEntities(int maxResults, int firstResult) {
        return findSexosEntities(false, maxResults, firstResult);
    }

    private List<Sexos> findSexosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sexos.class));
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

    public Sexos findSexos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sexos.class, id);
        } finally {
            em.close();
        }
    }

    public int getSexosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sexos> rt = cq.from(Sexos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
