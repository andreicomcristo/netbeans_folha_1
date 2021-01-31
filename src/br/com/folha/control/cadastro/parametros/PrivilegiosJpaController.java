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
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Privilegios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PrivilegiosJpaController implements Serializable {

    public PrivilegiosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Privilegios privilegios) {
        if (privilegios.getPessoaOperadoresCollection() == null) {
            privilegios.setPessoaOperadoresCollection(new ArrayList<PessoaOperadores>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<PessoaOperadores> attachedPessoaOperadoresCollection = new ArrayList<PessoaOperadores>();
            for (PessoaOperadores pessoaOperadoresCollectionPessoaOperadoresToAttach : privilegios.getPessoaOperadoresCollection()) {
                pessoaOperadoresCollectionPessoaOperadoresToAttach = em.getReference(pessoaOperadoresCollectionPessoaOperadoresToAttach.getClass(), pessoaOperadoresCollectionPessoaOperadoresToAttach.getId());
                attachedPessoaOperadoresCollection.add(pessoaOperadoresCollectionPessoaOperadoresToAttach);
            }
            privilegios.setPessoaOperadoresCollection(attachedPessoaOperadoresCollection);
            em.persist(privilegios);
            for (PessoaOperadores pessoaOperadoresCollectionPessoaOperadores : privilegios.getPessoaOperadoresCollection()) {
                Privilegios oldSeqPrivilegioOfPessoaOperadoresCollectionPessoaOperadores = pessoaOperadoresCollectionPessoaOperadores.getSeqPrivilegio();
                pessoaOperadoresCollectionPessoaOperadores.setSeqPrivilegio(privilegios);
                pessoaOperadoresCollectionPessoaOperadores = em.merge(pessoaOperadoresCollectionPessoaOperadores);
                if (oldSeqPrivilegioOfPessoaOperadoresCollectionPessoaOperadores != null) {
                    oldSeqPrivilegioOfPessoaOperadoresCollectionPessoaOperadores.getPessoaOperadoresCollection().remove(pessoaOperadoresCollectionPessoaOperadores);
                    oldSeqPrivilegioOfPessoaOperadoresCollectionPessoaOperadores = em.merge(oldSeqPrivilegioOfPessoaOperadoresCollectionPessoaOperadores);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Privilegios privilegios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Privilegios persistentPrivilegios = em.find(Privilegios.class, privilegios.getId());
            Collection<PessoaOperadores> pessoaOperadoresCollectionOld = persistentPrivilegios.getPessoaOperadoresCollection();
            Collection<PessoaOperadores> pessoaOperadoresCollectionNew = privilegios.getPessoaOperadoresCollection();
            Collection<PessoaOperadores> attachedPessoaOperadoresCollectionNew = new ArrayList<PessoaOperadores>();
            for (PessoaOperadores pessoaOperadoresCollectionNewPessoaOperadoresToAttach : pessoaOperadoresCollectionNew) {
                pessoaOperadoresCollectionNewPessoaOperadoresToAttach = em.getReference(pessoaOperadoresCollectionNewPessoaOperadoresToAttach.getClass(), pessoaOperadoresCollectionNewPessoaOperadoresToAttach.getId());
                attachedPessoaOperadoresCollectionNew.add(pessoaOperadoresCollectionNewPessoaOperadoresToAttach);
            }
            pessoaOperadoresCollectionNew = attachedPessoaOperadoresCollectionNew;
            privilegios.setPessoaOperadoresCollection(pessoaOperadoresCollectionNew);
            privilegios = em.merge(privilegios);
            for (PessoaOperadores pessoaOperadoresCollectionOldPessoaOperadores : pessoaOperadoresCollectionOld) {
                if (!pessoaOperadoresCollectionNew.contains(pessoaOperadoresCollectionOldPessoaOperadores)) {
                    pessoaOperadoresCollectionOldPessoaOperadores.setSeqPrivilegio(null);
                    pessoaOperadoresCollectionOldPessoaOperadores = em.merge(pessoaOperadoresCollectionOldPessoaOperadores);
                }
            }
            for (PessoaOperadores pessoaOperadoresCollectionNewPessoaOperadores : pessoaOperadoresCollectionNew) {
                if (!pessoaOperadoresCollectionOld.contains(pessoaOperadoresCollectionNewPessoaOperadores)) {
                    Privilegios oldSeqPrivilegioOfPessoaOperadoresCollectionNewPessoaOperadores = pessoaOperadoresCollectionNewPessoaOperadores.getSeqPrivilegio();
                    pessoaOperadoresCollectionNewPessoaOperadores.setSeqPrivilegio(privilegios);
                    pessoaOperadoresCollectionNewPessoaOperadores = em.merge(pessoaOperadoresCollectionNewPessoaOperadores);
                    if (oldSeqPrivilegioOfPessoaOperadoresCollectionNewPessoaOperadores != null && !oldSeqPrivilegioOfPessoaOperadoresCollectionNewPessoaOperadores.equals(privilegios)) {
                        oldSeqPrivilegioOfPessoaOperadoresCollectionNewPessoaOperadores.getPessoaOperadoresCollection().remove(pessoaOperadoresCollectionNewPessoaOperadores);
                        oldSeqPrivilegioOfPessoaOperadoresCollectionNewPessoaOperadores = em.merge(oldSeqPrivilegioOfPessoaOperadoresCollectionNewPessoaOperadores);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = privilegios.getId();
                if (findPrivilegios(id) == null) {
                    throw new NonexistentEntityException("The privilegios with id " + id + " no longer exists.");
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
            Privilegios privilegios;
            try {
                privilegios = em.getReference(Privilegios.class, id);
                privilegios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The privilegios with id " + id + " no longer exists.", enfe);
            }
            Collection<PessoaOperadores> pessoaOperadoresCollection = privilegios.getPessoaOperadoresCollection();
            for (PessoaOperadores pessoaOperadoresCollectionPessoaOperadores : pessoaOperadoresCollection) {
                pessoaOperadoresCollectionPessoaOperadores.setSeqPrivilegio(null);
                pessoaOperadoresCollectionPessoaOperadores = em.merge(pessoaOperadoresCollectionPessoaOperadores);
            }
            em.remove(privilegios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Privilegios> findPrivilegiosEntities() {
        return findPrivilegiosEntities(true, -1, -1);
    }

    public List<Privilegios> findPrivilegiosEntities(int maxResults, int firstResult) {
        return findPrivilegiosEntities(false, maxResults, firstResult);
    }

    private List<Privilegios> findPrivilegiosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Privilegios.class));
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

    public Privilegios findPrivilegios(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Privilegios.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrivilegiosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Privilegios> rt = cq.from(Privilegios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
