/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.Bancos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaBancos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class BancosJpaController implements Serializable {

    public BancosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bancos bancos) {
        if (bancos.getPessoaBancosCollection() == null) {
            bancos.setPessoaBancosCollection(new ArrayList<PessoaBancos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<PessoaBancos> attachedPessoaBancosCollection = new ArrayList<PessoaBancos>();
            for (PessoaBancos pessoaBancosCollectionPessoaBancosToAttach : bancos.getPessoaBancosCollection()) {
                pessoaBancosCollectionPessoaBancosToAttach = em.getReference(pessoaBancosCollectionPessoaBancosToAttach.getClass(), pessoaBancosCollectionPessoaBancosToAttach.getId());
                attachedPessoaBancosCollection.add(pessoaBancosCollectionPessoaBancosToAttach);
            }
            bancos.setPessoaBancosCollection(attachedPessoaBancosCollection);
            em.persist(bancos);
            for (PessoaBancos pessoaBancosCollectionPessoaBancos : bancos.getPessoaBancosCollection()) {
                Bancos oldIdBancoFkOfPessoaBancosCollectionPessoaBancos = pessoaBancosCollectionPessoaBancos.getIdBancoFk();
                pessoaBancosCollectionPessoaBancos.setIdBancoFk(bancos);
                pessoaBancosCollectionPessoaBancos = em.merge(pessoaBancosCollectionPessoaBancos);
                if (oldIdBancoFkOfPessoaBancosCollectionPessoaBancos != null) {
                    oldIdBancoFkOfPessoaBancosCollectionPessoaBancos.getPessoaBancosCollection().remove(pessoaBancosCollectionPessoaBancos);
                    oldIdBancoFkOfPessoaBancosCollectionPessoaBancos = em.merge(oldIdBancoFkOfPessoaBancosCollectionPessoaBancos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bancos bancos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bancos persistentBancos = em.find(Bancos.class, bancos.getId());
            Collection<PessoaBancos> pessoaBancosCollectionOld = persistentBancos.getPessoaBancosCollection();
            Collection<PessoaBancos> pessoaBancosCollectionNew = bancos.getPessoaBancosCollection();
            List<String> illegalOrphanMessages = null;
            for (PessoaBancos pessoaBancosCollectionOldPessoaBancos : pessoaBancosCollectionOld) {
                if (!pessoaBancosCollectionNew.contains(pessoaBancosCollectionOldPessoaBancos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaBancos " + pessoaBancosCollectionOldPessoaBancos + " since its idBancoFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<PessoaBancos> attachedPessoaBancosCollectionNew = new ArrayList<PessoaBancos>();
            for (PessoaBancos pessoaBancosCollectionNewPessoaBancosToAttach : pessoaBancosCollectionNew) {
                pessoaBancosCollectionNewPessoaBancosToAttach = em.getReference(pessoaBancosCollectionNewPessoaBancosToAttach.getClass(), pessoaBancosCollectionNewPessoaBancosToAttach.getId());
                attachedPessoaBancosCollectionNew.add(pessoaBancosCollectionNewPessoaBancosToAttach);
            }
            pessoaBancosCollectionNew = attachedPessoaBancosCollectionNew;
            bancos.setPessoaBancosCollection(pessoaBancosCollectionNew);
            bancos = em.merge(bancos);
            for (PessoaBancos pessoaBancosCollectionNewPessoaBancos : pessoaBancosCollectionNew) {
                if (!pessoaBancosCollectionOld.contains(pessoaBancosCollectionNewPessoaBancos)) {
                    Bancos oldIdBancoFkOfPessoaBancosCollectionNewPessoaBancos = pessoaBancosCollectionNewPessoaBancos.getIdBancoFk();
                    pessoaBancosCollectionNewPessoaBancos.setIdBancoFk(bancos);
                    pessoaBancosCollectionNewPessoaBancos = em.merge(pessoaBancosCollectionNewPessoaBancos);
                    if (oldIdBancoFkOfPessoaBancosCollectionNewPessoaBancos != null && !oldIdBancoFkOfPessoaBancosCollectionNewPessoaBancos.equals(bancos)) {
                        oldIdBancoFkOfPessoaBancosCollectionNewPessoaBancos.getPessoaBancosCollection().remove(pessoaBancosCollectionNewPessoaBancos);
                        oldIdBancoFkOfPessoaBancosCollectionNewPessoaBancos = em.merge(oldIdBancoFkOfPessoaBancosCollectionNewPessoaBancos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = bancos.getId();
                if (findBancos(id) == null) {
                    throw new NonexistentEntityException("The bancos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bancos bancos;
            try {
                bancos = em.getReference(Bancos.class, id);
                bancos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bancos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<PessoaBancos> pessoaBancosCollectionOrphanCheck = bancos.getPessoaBancosCollection();
            for (PessoaBancos pessoaBancosCollectionOrphanCheckPessoaBancos : pessoaBancosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Bancos (" + bancos + ") cannot be destroyed since the PessoaBancos " + pessoaBancosCollectionOrphanCheckPessoaBancos + " in its pessoaBancosCollection field has a non-nullable idBancoFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(bancos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bancos> findBancosEntities() {
        return findBancosEntities(true, -1, -1);
    }

    public List<Bancos> findBancosEntities(int maxResults, int firstResult) {
        return findBancosEntities(false, maxResults, firstResult);
    }

    private List<Bancos> findBancosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bancos.class));
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

    public Bancos findBancos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bancos.class, id);
        } finally {
            em.close();
        }
    }

    public int getBancosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bancos> rt = cq.from(Bancos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
