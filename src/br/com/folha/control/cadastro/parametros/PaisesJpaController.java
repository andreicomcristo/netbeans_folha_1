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
import br.com.folha.model.tabelas.Cidades;
import br.com.folha.model.tabelas.Paises;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PaisesJpaController implements Serializable {

    public PaisesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paises paises) {
        if (paises.getCidadesCollection() == null) {
            paises.setCidadesCollection(new ArrayList<Cidades>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cidades> attachedCidadesCollection = new ArrayList<Cidades>();
            for (Cidades cidadesCollectionCidadesToAttach : paises.getCidadesCollection()) {
                cidadesCollectionCidadesToAttach = em.getReference(cidadesCollectionCidadesToAttach.getClass(), cidadesCollectionCidadesToAttach.getId());
                attachedCidadesCollection.add(cidadesCollectionCidadesToAttach);
            }
            paises.setCidadesCollection(attachedCidadesCollection);
            em.persist(paises);
            for (Cidades cidadesCollectionCidades : paises.getCidadesCollection()) {
                Paises oldIdPaisFkOfCidadesCollectionCidades = cidadesCollectionCidades.getIdPaisFk();
                cidadesCollectionCidades.setIdPaisFk(paises);
                cidadesCollectionCidades = em.merge(cidadesCollectionCidades);
                if (oldIdPaisFkOfCidadesCollectionCidades != null) {
                    oldIdPaisFkOfCidadesCollectionCidades.getCidadesCollection().remove(cidadesCollectionCidades);
                    oldIdPaisFkOfCidadesCollectionCidades = em.merge(oldIdPaisFkOfCidadesCollectionCidades);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paises paises) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paises persistentPaises = em.find(Paises.class, paises.getId());
            Collection<Cidades> cidadesCollectionOld = persistentPaises.getCidadesCollection();
            Collection<Cidades> cidadesCollectionNew = paises.getCidadesCollection();
            List<String> illegalOrphanMessages = null;
            for (Cidades cidadesCollectionOldCidades : cidadesCollectionOld) {
                if (!cidadesCollectionNew.contains(cidadesCollectionOldCidades)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cidades " + cidadesCollectionOldCidades + " since its idPaisFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Cidades> attachedCidadesCollectionNew = new ArrayList<Cidades>();
            for (Cidades cidadesCollectionNewCidadesToAttach : cidadesCollectionNew) {
                cidadesCollectionNewCidadesToAttach = em.getReference(cidadesCollectionNewCidadesToAttach.getClass(), cidadesCollectionNewCidadesToAttach.getId());
                attachedCidadesCollectionNew.add(cidadesCollectionNewCidadesToAttach);
            }
            cidadesCollectionNew = attachedCidadesCollectionNew;
            paises.setCidadesCollection(cidadesCollectionNew);
            paises = em.merge(paises);
            for (Cidades cidadesCollectionNewCidades : cidadesCollectionNew) {
                if (!cidadesCollectionOld.contains(cidadesCollectionNewCidades)) {
                    Paises oldIdPaisFkOfCidadesCollectionNewCidades = cidadesCollectionNewCidades.getIdPaisFk();
                    cidadesCollectionNewCidades.setIdPaisFk(paises);
                    cidadesCollectionNewCidades = em.merge(cidadesCollectionNewCidades);
                    if (oldIdPaisFkOfCidadesCollectionNewCidades != null && !oldIdPaisFkOfCidadesCollectionNewCidades.equals(paises)) {
                        oldIdPaisFkOfCidadesCollectionNewCidades.getCidadesCollection().remove(cidadesCollectionNewCidades);
                        oldIdPaisFkOfCidadesCollectionNewCidades = em.merge(oldIdPaisFkOfCidadesCollectionNewCidades);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = paises.getId();
                if (findPaises(id) == null) {
                    throw new NonexistentEntityException("The paises with id " + id + " no longer exists.");
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
            Paises paises;
            try {
                paises = em.getReference(Paises.class, id);
                paises.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paises with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Cidades> cidadesCollectionOrphanCheck = paises.getCidadesCollection();
            for (Cidades cidadesCollectionOrphanCheckCidades : cidadesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paises (" + paises + ") cannot be destroyed since the Cidades " + cidadesCollectionOrphanCheckCidades + " in its cidadesCollection field has a non-nullable idPaisFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(paises);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paises> findPaisesEntities() {
        return findPaisesEntities(true, -1, -1);
    }

    public List<Paises> findPaisesEntities(int maxResults, int firstResult) {
        return findPaisesEntities(false, maxResults, firstResult);
    }

    private List<Paises> findPaisesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paises.class));
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

    public Paises findPaises(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paises.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaisesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paises> rt = cq.from(Paises.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
