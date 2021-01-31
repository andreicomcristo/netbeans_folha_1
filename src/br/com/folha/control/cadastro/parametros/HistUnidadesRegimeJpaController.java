/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.HistUnidadesRegime;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Unidades;
import br.com.folha.model.tabelas.UnidadesRegime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistUnidadesRegimeJpaController implements Serializable {

    public HistUnidadesRegimeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistUnidadesRegime histUnidadesRegime) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaOperadores idOperadorCadastroFk = histUnidadesRegime.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histUnidadesRegime.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histUnidadesRegime.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histUnidadesRegime.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            Unidades idUnidadeDeSaudeFk = histUnidadesRegime.getIdUnidadeDeSaudeFk();
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk = em.getReference(idUnidadeDeSaudeFk.getClass(), idUnidadeDeSaudeFk.getId());
                histUnidadesRegime.setIdUnidadeDeSaudeFk(idUnidadeDeSaudeFk);
            }
            UnidadesRegime idUnidadeRegimeFk = histUnidadesRegime.getIdUnidadeRegimeFk();
            if (idUnidadeRegimeFk != null) {
                idUnidadeRegimeFk = em.getReference(idUnidadeRegimeFk.getClass(), idUnidadeRegimeFk.getId());
                histUnidadesRegime.setIdUnidadeRegimeFk(idUnidadeRegimeFk);
            }
            em.persist(histUnidadesRegime);
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistUnidadesRegimeCollection().add(histUnidadesRegime);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistUnidadesRegimeCollection().add(histUnidadesRegime);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk.getHistUnidadesRegimeCollection().add(histUnidadesRegime);
                idUnidadeDeSaudeFk = em.merge(idUnidadeDeSaudeFk);
            }
            if (idUnidadeRegimeFk != null) {
                idUnidadeRegimeFk.getHistUnidadesRegimeCollection().add(histUnidadesRegime);
                idUnidadeRegimeFk = em.merge(idUnidadeRegimeFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistUnidadesRegime histUnidadesRegime) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistUnidadesRegime persistentHistUnidadesRegime = em.find(HistUnidadesRegime.class, histUnidadesRegime.getId());
            PessoaOperadores idOperadorCadastroFkOld = persistentHistUnidadesRegime.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histUnidadesRegime.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistUnidadesRegime.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histUnidadesRegime.getIdOperadorCancelamentoFk();
            Unidades idUnidadeDeSaudeFkOld = persistentHistUnidadesRegime.getIdUnidadeDeSaudeFk();
            Unidades idUnidadeDeSaudeFkNew = histUnidadesRegime.getIdUnidadeDeSaudeFk();
            UnidadesRegime idUnidadeRegimeFkOld = persistentHistUnidadesRegime.getIdUnidadeRegimeFk();
            UnidadesRegime idUnidadeRegimeFkNew = histUnidadesRegime.getIdUnidadeRegimeFk();
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histUnidadesRegime.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histUnidadesRegime.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idUnidadeDeSaudeFkNew != null) {
                idUnidadeDeSaudeFkNew = em.getReference(idUnidadeDeSaudeFkNew.getClass(), idUnidadeDeSaudeFkNew.getId());
                histUnidadesRegime.setIdUnidadeDeSaudeFk(idUnidadeDeSaudeFkNew);
            }
            if (idUnidadeRegimeFkNew != null) {
                idUnidadeRegimeFkNew = em.getReference(idUnidadeRegimeFkNew.getClass(), idUnidadeRegimeFkNew.getId());
                histUnidadesRegime.setIdUnidadeRegimeFk(idUnidadeRegimeFkNew);
            }
            histUnidadesRegime = em.merge(histUnidadesRegime);
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistUnidadesRegimeCollection().remove(histUnidadesRegime);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistUnidadesRegimeCollection().add(histUnidadesRegime);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistUnidadesRegimeCollection().remove(histUnidadesRegime);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistUnidadesRegimeCollection().add(histUnidadesRegime);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idUnidadeDeSaudeFkOld != null && !idUnidadeDeSaudeFkOld.equals(idUnidadeDeSaudeFkNew)) {
                idUnidadeDeSaudeFkOld.getHistUnidadesRegimeCollection().remove(histUnidadesRegime);
                idUnidadeDeSaudeFkOld = em.merge(idUnidadeDeSaudeFkOld);
            }
            if (idUnidadeDeSaudeFkNew != null && !idUnidadeDeSaudeFkNew.equals(idUnidadeDeSaudeFkOld)) {
                idUnidadeDeSaudeFkNew.getHistUnidadesRegimeCollection().add(histUnidadesRegime);
                idUnidadeDeSaudeFkNew = em.merge(idUnidadeDeSaudeFkNew);
            }
            if (idUnidadeRegimeFkOld != null && !idUnidadeRegimeFkOld.equals(idUnidadeRegimeFkNew)) {
                idUnidadeRegimeFkOld.getHistUnidadesRegimeCollection().remove(histUnidadesRegime);
                idUnidadeRegimeFkOld = em.merge(idUnidadeRegimeFkOld);
            }
            if (idUnidadeRegimeFkNew != null && !idUnidadeRegimeFkNew.equals(idUnidadeRegimeFkOld)) {
                idUnidadeRegimeFkNew.getHistUnidadesRegimeCollection().add(histUnidadesRegime);
                idUnidadeRegimeFkNew = em.merge(idUnidadeRegimeFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histUnidadesRegime.getId();
                if (findHistUnidadesRegime(id) == null) {
                    throw new NonexistentEntityException("The histUnidadesRegime with id " + id + " no longer exists.");
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
            HistUnidadesRegime histUnidadesRegime;
            try {
                histUnidadesRegime = em.getReference(HistUnidadesRegime.class, id);
                histUnidadesRegime.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histUnidadesRegime with id " + id + " no longer exists.", enfe);
            }
            PessoaOperadores idOperadorCadastroFk = histUnidadesRegime.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistUnidadesRegimeCollection().remove(histUnidadesRegime);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histUnidadesRegime.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistUnidadesRegimeCollection().remove(histUnidadesRegime);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            Unidades idUnidadeDeSaudeFk = histUnidadesRegime.getIdUnidadeDeSaudeFk();
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk.getHistUnidadesRegimeCollection().remove(histUnidadesRegime);
                idUnidadeDeSaudeFk = em.merge(idUnidadeDeSaudeFk);
            }
            UnidadesRegime idUnidadeRegimeFk = histUnidadesRegime.getIdUnidadeRegimeFk();
            if (idUnidadeRegimeFk != null) {
                idUnidadeRegimeFk.getHistUnidadesRegimeCollection().remove(histUnidadesRegime);
                idUnidadeRegimeFk = em.merge(idUnidadeRegimeFk);
            }
            em.remove(histUnidadesRegime);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistUnidadesRegime> findHistUnidadesRegimeEntities() {
        return findHistUnidadesRegimeEntities(true, -1, -1);
    }

    public List<HistUnidadesRegime> findHistUnidadesRegimeEntities(int maxResults, int firstResult) {
        return findHistUnidadesRegimeEntities(false, maxResults, firstResult);
    }

    private List<HistUnidadesRegime> findHistUnidadesRegimeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistUnidadesRegime.class));
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

    public HistUnidadesRegime findHistUnidadesRegime(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistUnidadesRegime.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistUnidadesRegimeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistUnidadesRegime> rt = cq.from(HistUnidadesRegime.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
