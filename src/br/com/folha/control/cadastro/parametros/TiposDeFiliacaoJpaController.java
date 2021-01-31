/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaFilhos;
import br.com.folha.model.tabelas.TiposDeFiliacao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class TiposDeFiliacaoJpaController implements Serializable {

    public TiposDeFiliacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TiposDeFiliacao tiposDeFiliacao) {
        if (tiposDeFiliacao.getPessoaFilhosCollection() == null) {
            tiposDeFiliacao.setPessoaFilhosCollection(new ArrayList<PessoaFilhos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<PessoaFilhos> attachedPessoaFilhosCollection = new ArrayList<PessoaFilhos>();
            for (PessoaFilhos pessoaFilhosCollectionPessoaFilhosToAttach : tiposDeFiliacao.getPessoaFilhosCollection()) {
                pessoaFilhosCollectionPessoaFilhosToAttach = em.getReference(pessoaFilhosCollectionPessoaFilhosToAttach.getClass(), pessoaFilhosCollectionPessoaFilhosToAttach.getId());
                attachedPessoaFilhosCollection.add(pessoaFilhosCollectionPessoaFilhosToAttach);
            }
            tiposDeFiliacao.setPessoaFilhosCollection(attachedPessoaFilhosCollection);
            em.persist(tiposDeFiliacao);
            for (PessoaFilhos pessoaFilhosCollectionPessoaFilhos : tiposDeFiliacao.getPessoaFilhosCollection()) {
                TiposDeFiliacao oldIdTipoFiliacaoFkOfPessoaFilhosCollectionPessoaFilhos = pessoaFilhosCollectionPessoaFilhos.getIdTipoFiliacaoFk();
                pessoaFilhosCollectionPessoaFilhos.setIdTipoFiliacaoFk(tiposDeFiliacao);
                pessoaFilhosCollectionPessoaFilhos = em.merge(pessoaFilhosCollectionPessoaFilhos);
                if (oldIdTipoFiliacaoFkOfPessoaFilhosCollectionPessoaFilhos != null) {
                    oldIdTipoFiliacaoFkOfPessoaFilhosCollectionPessoaFilhos.getPessoaFilhosCollection().remove(pessoaFilhosCollectionPessoaFilhos);
                    oldIdTipoFiliacaoFkOfPessoaFilhosCollectionPessoaFilhos = em.merge(oldIdTipoFiliacaoFkOfPessoaFilhosCollectionPessoaFilhos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TiposDeFiliacao tiposDeFiliacao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TiposDeFiliacao persistentTiposDeFiliacao = em.find(TiposDeFiliacao.class, tiposDeFiliacao.getId());
            Collection<PessoaFilhos> pessoaFilhosCollectionOld = persistentTiposDeFiliacao.getPessoaFilhosCollection();
            Collection<PessoaFilhos> pessoaFilhosCollectionNew = tiposDeFiliacao.getPessoaFilhosCollection();
            List<String> illegalOrphanMessages = null;
            for (PessoaFilhos pessoaFilhosCollectionOldPessoaFilhos : pessoaFilhosCollectionOld) {
                if (!pessoaFilhosCollectionNew.contains(pessoaFilhosCollectionOldPessoaFilhos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaFilhos " + pessoaFilhosCollectionOldPessoaFilhos + " since its idTipoFiliacaoFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<PessoaFilhos> attachedPessoaFilhosCollectionNew = new ArrayList<PessoaFilhos>();
            for (PessoaFilhos pessoaFilhosCollectionNewPessoaFilhosToAttach : pessoaFilhosCollectionNew) {
                pessoaFilhosCollectionNewPessoaFilhosToAttach = em.getReference(pessoaFilhosCollectionNewPessoaFilhosToAttach.getClass(), pessoaFilhosCollectionNewPessoaFilhosToAttach.getId());
                attachedPessoaFilhosCollectionNew.add(pessoaFilhosCollectionNewPessoaFilhosToAttach);
            }
            pessoaFilhosCollectionNew = attachedPessoaFilhosCollectionNew;
            tiposDeFiliacao.setPessoaFilhosCollection(pessoaFilhosCollectionNew);
            tiposDeFiliacao = em.merge(tiposDeFiliacao);
            for (PessoaFilhos pessoaFilhosCollectionNewPessoaFilhos : pessoaFilhosCollectionNew) {
                if (!pessoaFilhosCollectionOld.contains(pessoaFilhosCollectionNewPessoaFilhos)) {
                    TiposDeFiliacao oldIdTipoFiliacaoFkOfPessoaFilhosCollectionNewPessoaFilhos = pessoaFilhosCollectionNewPessoaFilhos.getIdTipoFiliacaoFk();
                    pessoaFilhosCollectionNewPessoaFilhos.setIdTipoFiliacaoFk(tiposDeFiliacao);
                    pessoaFilhosCollectionNewPessoaFilhos = em.merge(pessoaFilhosCollectionNewPessoaFilhos);
                    if (oldIdTipoFiliacaoFkOfPessoaFilhosCollectionNewPessoaFilhos != null && !oldIdTipoFiliacaoFkOfPessoaFilhosCollectionNewPessoaFilhos.equals(tiposDeFiliacao)) {
                        oldIdTipoFiliacaoFkOfPessoaFilhosCollectionNewPessoaFilhos.getPessoaFilhosCollection().remove(pessoaFilhosCollectionNewPessoaFilhos);
                        oldIdTipoFiliacaoFkOfPessoaFilhosCollectionNewPessoaFilhos = em.merge(oldIdTipoFiliacaoFkOfPessoaFilhosCollectionNewPessoaFilhos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tiposDeFiliacao.getId();
                if (findTiposDeFiliacao(id) == null) {
                    throw new NonexistentEntityException("The tiposDeFiliacao with id " + id + " no longer exists.");
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
            TiposDeFiliacao tiposDeFiliacao;
            try {
                tiposDeFiliacao = em.getReference(TiposDeFiliacao.class, id);
                tiposDeFiliacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiposDeFiliacao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<PessoaFilhos> pessoaFilhosCollectionOrphanCheck = tiposDeFiliacao.getPessoaFilhosCollection();
            for (PessoaFilhos pessoaFilhosCollectionOrphanCheckPessoaFilhos : pessoaFilhosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TiposDeFiliacao (" + tiposDeFiliacao + ") cannot be destroyed since the PessoaFilhos " + pessoaFilhosCollectionOrphanCheckPessoaFilhos + " in its pessoaFilhosCollection field has a non-nullable idTipoFiliacaoFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tiposDeFiliacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TiposDeFiliacao> findTiposDeFiliacaoEntities() {
        return findTiposDeFiliacaoEntities(true, -1, -1);
    }

    public List<TiposDeFiliacao> findTiposDeFiliacaoEntities(int maxResults, int firstResult) {
        return findTiposDeFiliacaoEntities(false, maxResults, firstResult);
    }

    private List<TiposDeFiliacao> findTiposDeFiliacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TiposDeFiliacao.class));
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

    public TiposDeFiliacao findTiposDeFiliacao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TiposDeFiliacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiposDeFiliacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TiposDeFiliacao> rt = cq.from(TiposDeFiliacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
