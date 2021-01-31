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
import br.com.folha.model.tabelas.Enderecos;
import br.com.folha.model.tabelas.TiposLogradouro;
import java.util.ArrayList;
import java.util.Collection;
import br.com.folha.model.tabelas.Unidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class TiposLogradouroJpaController implements Serializable {

    public TiposLogradouroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TiposLogradouro tiposLogradouro) {
        if (tiposLogradouro.getEnderecosCollection() == null) {
            tiposLogradouro.setEnderecosCollection(new ArrayList<Enderecos>());
        }
        if (tiposLogradouro.getUnidadesCollection() == null) {
            tiposLogradouro.setUnidadesCollection(new ArrayList<Unidades>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Enderecos> attachedEnderecosCollection = new ArrayList<Enderecos>();
            for (Enderecos enderecosCollectionEnderecosToAttach : tiposLogradouro.getEnderecosCollection()) {
                enderecosCollectionEnderecosToAttach = em.getReference(enderecosCollectionEnderecosToAttach.getClass(), enderecosCollectionEnderecosToAttach.getId());
                attachedEnderecosCollection.add(enderecosCollectionEnderecosToAttach);
            }
            tiposLogradouro.setEnderecosCollection(attachedEnderecosCollection);
            Collection<Unidades> attachedUnidadesCollection = new ArrayList<Unidades>();
            for (Unidades unidadesCollectionUnidadesToAttach : tiposLogradouro.getUnidadesCollection()) {
                unidadesCollectionUnidadesToAttach = em.getReference(unidadesCollectionUnidadesToAttach.getClass(), unidadesCollectionUnidadesToAttach.getId());
                attachedUnidadesCollection.add(unidadesCollectionUnidadesToAttach);
            }
            tiposLogradouro.setUnidadesCollection(attachedUnidadesCollection);
            em.persist(tiposLogradouro);
            for (Enderecos enderecosCollectionEnderecos : tiposLogradouro.getEnderecosCollection()) {
                TiposLogradouro oldIdTipoLogradouroFkOfEnderecosCollectionEnderecos = enderecosCollectionEnderecos.getIdTipoLogradouroFk();
                enderecosCollectionEnderecos.setIdTipoLogradouroFk(tiposLogradouro);
                enderecosCollectionEnderecos = em.merge(enderecosCollectionEnderecos);
                if (oldIdTipoLogradouroFkOfEnderecosCollectionEnderecos != null) {
                    oldIdTipoLogradouroFkOfEnderecosCollectionEnderecos.getEnderecosCollection().remove(enderecosCollectionEnderecos);
                    oldIdTipoLogradouroFkOfEnderecosCollectionEnderecos = em.merge(oldIdTipoLogradouroFkOfEnderecosCollectionEnderecos);
                }
            }
            for (Unidades unidadesCollectionUnidades : tiposLogradouro.getUnidadesCollection()) {
                TiposLogradouro oldIdTipoLogradouroFkOfUnidadesCollectionUnidades = unidadesCollectionUnidades.getIdTipoLogradouroFk();
                unidadesCollectionUnidades.setIdTipoLogradouroFk(tiposLogradouro);
                unidadesCollectionUnidades = em.merge(unidadesCollectionUnidades);
                if (oldIdTipoLogradouroFkOfUnidadesCollectionUnidades != null) {
                    oldIdTipoLogradouroFkOfUnidadesCollectionUnidades.getUnidadesCollection().remove(unidadesCollectionUnidades);
                    oldIdTipoLogradouroFkOfUnidadesCollectionUnidades = em.merge(oldIdTipoLogradouroFkOfUnidadesCollectionUnidades);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TiposLogradouro tiposLogradouro) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TiposLogradouro persistentTiposLogradouro = em.find(TiposLogradouro.class, tiposLogradouro.getId());
            Collection<Enderecos> enderecosCollectionOld = persistentTiposLogradouro.getEnderecosCollection();
            Collection<Enderecos> enderecosCollectionNew = tiposLogradouro.getEnderecosCollection();
            Collection<Unidades> unidadesCollectionOld = persistentTiposLogradouro.getUnidadesCollection();
            Collection<Unidades> unidadesCollectionNew = tiposLogradouro.getUnidadesCollection();
            List<String> illegalOrphanMessages = null;
            for (Enderecos enderecosCollectionOldEnderecos : enderecosCollectionOld) {
                if (!enderecosCollectionNew.contains(enderecosCollectionOldEnderecos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Enderecos " + enderecosCollectionOldEnderecos + " since its idTipoLogradouroFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Enderecos> attachedEnderecosCollectionNew = new ArrayList<Enderecos>();
            for (Enderecos enderecosCollectionNewEnderecosToAttach : enderecosCollectionNew) {
                enderecosCollectionNewEnderecosToAttach = em.getReference(enderecosCollectionNewEnderecosToAttach.getClass(), enderecosCollectionNewEnderecosToAttach.getId());
                attachedEnderecosCollectionNew.add(enderecosCollectionNewEnderecosToAttach);
            }
            enderecosCollectionNew = attachedEnderecosCollectionNew;
            tiposLogradouro.setEnderecosCollection(enderecosCollectionNew);
            Collection<Unidades> attachedUnidadesCollectionNew = new ArrayList<Unidades>();
            for (Unidades unidadesCollectionNewUnidadesToAttach : unidadesCollectionNew) {
                unidadesCollectionNewUnidadesToAttach = em.getReference(unidadesCollectionNewUnidadesToAttach.getClass(), unidadesCollectionNewUnidadesToAttach.getId());
                attachedUnidadesCollectionNew.add(unidadesCollectionNewUnidadesToAttach);
            }
            unidadesCollectionNew = attachedUnidadesCollectionNew;
            tiposLogradouro.setUnidadesCollection(unidadesCollectionNew);
            tiposLogradouro = em.merge(tiposLogradouro);
            for (Enderecos enderecosCollectionNewEnderecos : enderecosCollectionNew) {
                if (!enderecosCollectionOld.contains(enderecosCollectionNewEnderecos)) {
                    TiposLogradouro oldIdTipoLogradouroFkOfEnderecosCollectionNewEnderecos = enderecosCollectionNewEnderecos.getIdTipoLogradouroFk();
                    enderecosCollectionNewEnderecos.setIdTipoLogradouroFk(tiposLogradouro);
                    enderecosCollectionNewEnderecos = em.merge(enderecosCollectionNewEnderecos);
                    if (oldIdTipoLogradouroFkOfEnderecosCollectionNewEnderecos != null && !oldIdTipoLogradouroFkOfEnderecosCollectionNewEnderecos.equals(tiposLogradouro)) {
                        oldIdTipoLogradouroFkOfEnderecosCollectionNewEnderecos.getEnderecosCollection().remove(enderecosCollectionNewEnderecos);
                        oldIdTipoLogradouroFkOfEnderecosCollectionNewEnderecos = em.merge(oldIdTipoLogradouroFkOfEnderecosCollectionNewEnderecos);
                    }
                }
            }
            for (Unidades unidadesCollectionOldUnidades : unidadesCollectionOld) {
                if (!unidadesCollectionNew.contains(unidadesCollectionOldUnidades)) {
                    unidadesCollectionOldUnidades.setIdTipoLogradouroFk(null);
                    unidadesCollectionOldUnidades = em.merge(unidadesCollectionOldUnidades);
                }
            }
            for (Unidades unidadesCollectionNewUnidades : unidadesCollectionNew) {
                if (!unidadesCollectionOld.contains(unidadesCollectionNewUnidades)) {
                    TiposLogradouro oldIdTipoLogradouroFkOfUnidadesCollectionNewUnidades = unidadesCollectionNewUnidades.getIdTipoLogradouroFk();
                    unidadesCollectionNewUnidades.setIdTipoLogradouroFk(tiposLogradouro);
                    unidadesCollectionNewUnidades = em.merge(unidadesCollectionNewUnidades);
                    if (oldIdTipoLogradouroFkOfUnidadesCollectionNewUnidades != null && !oldIdTipoLogradouroFkOfUnidadesCollectionNewUnidades.equals(tiposLogradouro)) {
                        oldIdTipoLogradouroFkOfUnidadesCollectionNewUnidades.getUnidadesCollection().remove(unidadesCollectionNewUnidades);
                        oldIdTipoLogradouroFkOfUnidadesCollectionNewUnidades = em.merge(oldIdTipoLogradouroFkOfUnidadesCollectionNewUnidades);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tiposLogradouro.getId();
                if (findTiposLogradouro(id) == null) {
                    throw new NonexistentEntityException("The tiposLogradouro with id " + id + " no longer exists.");
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
            TiposLogradouro tiposLogradouro;
            try {
                tiposLogradouro = em.getReference(TiposLogradouro.class, id);
                tiposLogradouro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiposLogradouro with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Enderecos> enderecosCollectionOrphanCheck = tiposLogradouro.getEnderecosCollection();
            for (Enderecos enderecosCollectionOrphanCheckEnderecos : enderecosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TiposLogradouro (" + tiposLogradouro + ") cannot be destroyed since the Enderecos " + enderecosCollectionOrphanCheckEnderecos + " in its enderecosCollection field has a non-nullable idTipoLogradouroFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Unidades> unidadesCollection = tiposLogradouro.getUnidadesCollection();
            for (Unidades unidadesCollectionUnidades : unidadesCollection) {
                unidadesCollectionUnidades.setIdTipoLogradouroFk(null);
                unidadesCollectionUnidades = em.merge(unidadesCollectionUnidades);
            }
            em.remove(tiposLogradouro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TiposLogradouro> findTiposLogradouroEntities() {
        return findTiposLogradouroEntities(true, -1, -1);
    }

    public List<TiposLogradouro> findTiposLogradouroEntities(int maxResults, int firstResult) {
        return findTiposLogradouroEntities(false, maxResults, firstResult);
    }

    private List<TiposLogradouro> findTiposLogradouroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TiposLogradouro.class));
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

    public TiposLogradouro findTiposLogradouro(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TiposLogradouro.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiposLogradouroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TiposLogradouro> rt = cq.from(TiposLogradouro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
