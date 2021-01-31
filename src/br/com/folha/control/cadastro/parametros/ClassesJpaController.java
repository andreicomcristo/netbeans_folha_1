/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.Classes;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.HistFuncionariosClasse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class ClassesJpaController implements Serializable {

    public ClassesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Classes classes) {
        if (classes.getHistFuncionariosClasseCollection() == null) {
            classes.setHistFuncionariosClasseCollection(new ArrayList<HistFuncionariosClasse>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HistFuncionariosClasse> attachedHistFuncionariosClasseCollection = new ArrayList<HistFuncionariosClasse>();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionHistFuncionariosClasseToAttach : classes.getHistFuncionariosClasseCollection()) {
                histFuncionariosClasseCollectionHistFuncionariosClasseToAttach = em.getReference(histFuncionariosClasseCollectionHistFuncionariosClasseToAttach.getClass(), histFuncionariosClasseCollectionHistFuncionariosClasseToAttach.getId());
                attachedHistFuncionariosClasseCollection.add(histFuncionariosClasseCollectionHistFuncionariosClasseToAttach);
            }
            classes.setHistFuncionariosClasseCollection(attachedHistFuncionariosClasseCollection);
            em.persist(classes);
            for (HistFuncionariosClasse histFuncionariosClasseCollectionHistFuncionariosClasse : classes.getHistFuncionariosClasseCollection()) {
                Classes oldIdClasseFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse = histFuncionariosClasseCollectionHistFuncionariosClasse.getIdClasseFk();
                histFuncionariosClasseCollectionHistFuncionariosClasse.setIdClasseFk(classes);
                histFuncionariosClasseCollectionHistFuncionariosClasse = em.merge(histFuncionariosClasseCollectionHistFuncionariosClasse);
                if (oldIdClasseFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse != null) {
                    oldIdClasseFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse.getHistFuncionariosClasseCollection().remove(histFuncionariosClasseCollectionHistFuncionariosClasse);
                    oldIdClasseFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse = em.merge(oldIdClasseFkOfHistFuncionariosClasseCollectionHistFuncionariosClasse);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Classes classes) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Classes persistentClasses = em.find(Classes.class, classes.getId());
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionOld = persistentClasses.getHistFuncionariosClasseCollection();
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionNew = classes.getHistFuncionariosClasseCollection();
            List<String> illegalOrphanMessages = null;
            for (HistFuncionariosClasse histFuncionariosClasseCollectionOldHistFuncionariosClasse : histFuncionariosClasseCollectionOld) {
                if (!histFuncionariosClasseCollectionNew.contains(histFuncionariosClasseCollectionOldHistFuncionariosClasse)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistFuncionariosClasse " + histFuncionariosClasseCollectionOldHistFuncionariosClasse + " since its idClasseFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HistFuncionariosClasse> attachedHistFuncionariosClasseCollectionNew = new ArrayList<HistFuncionariosClasse>();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach : histFuncionariosClasseCollectionNew) {
                histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach = em.getReference(histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach.getClass(), histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach.getId());
                attachedHistFuncionariosClasseCollectionNew.add(histFuncionariosClasseCollectionNewHistFuncionariosClasseToAttach);
            }
            histFuncionariosClasseCollectionNew = attachedHistFuncionariosClasseCollectionNew;
            classes.setHistFuncionariosClasseCollection(histFuncionariosClasseCollectionNew);
            classes = em.merge(classes);
            for (HistFuncionariosClasse histFuncionariosClasseCollectionNewHistFuncionariosClasse : histFuncionariosClasseCollectionNew) {
                if (!histFuncionariosClasseCollectionOld.contains(histFuncionariosClasseCollectionNewHistFuncionariosClasse)) {
                    Classes oldIdClasseFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse = histFuncionariosClasseCollectionNewHistFuncionariosClasse.getIdClasseFk();
                    histFuncionariosClasseCollectionNewHistFuncionariosClasse.setIdClasseFk(classes);
                    histFuncionariosClasseCollectionNewHistFuncionariosClasse = em.merge(histFuncionariosClasseCollectionNewHistFuncionariosClasse);
                    if (oldIdClasseFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse != null && !oldIdClasseFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse.equals(classes)) {
                        oldIdClasseFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse.getHistFuncionariosClasseCollection().remove(histFuncionariosClasseCollectionNewHistFuncionariosClasse);
                        oldIdClasseFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse = em.merge(oldIdClasseFkOfHistFuncionariosClasseCollectionNewHistFuncionariosClasse);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = classes.getId();
                if (findClasses(id) == null) {
                    throw new NonexistentEntityException("The classes with id " + id + " no longer exists.");
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
            Classes classes;
            try {
                classes = em.getReference(Classes.class, id);
                classes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The classes with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HistFuncionariosClasse> histFuncionariosClasseCollectionOrphanCheck = classes.getHistFuncionariosClasseCollection();
            for (HistFuncionariosClasse histFuncionariosClasseCollectionOrphanCheckHistFuncionariosClasse : histFuncionariosClasseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Classes (" + classes + ") cannot be destroyed since the HistFuncionariosClasse " + histFuncionariosClasseCollectionOrphanCheckHistFuncionariosClasse + " in its histFuncionariosClasseCollection field has a non-nullable idClasseFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(classes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Classes> findClassesEntities() {
        return findClassesEntities(true, -1, -1);
    }

    public List<Classes> findClassesEntities(int maxResults, int firstResult) {
        return findClassesEntities(false, maxResults, firstResult);
    }

    private List<Classes> findClassesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Classes.class));
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

    public Classes findClasses(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Classes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClassesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Classes> rt = cq.from(Classes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
