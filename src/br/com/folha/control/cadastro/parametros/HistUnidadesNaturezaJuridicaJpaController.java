/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.HistUnidadesNaturezaJuridica;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.UnidadesNaturezaJuridica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistUnidadesNaturezaJuridicaJpaController implements Serializable {

    public HistUnidadesNaturezaJuridicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridica) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaOperadores idOperadorCadastroFk = histUnidadesNaturezaJuridica.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histUnidadesNaturezaJuridica.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histUnidadesNaturezaJuridica.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histUnidadesNaturezaJuridica.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            UnidadesNaturezaJuridica idUnidadeDeSaudeFk = histUnidadesNaturezaJuridica.getIdUnidadeDeSaudeFk();
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk = em.getReference(idUnidadeDeSaudeFk.getClass(), idUnidadeDeSaudeFk.getId());
                histUnidadesNaturezaJuridica.setIdUnidadeDeSaudeFk(idUnidadeDeSaudeFk);
            }
            em.persist(histUnidadesNaturezaJuridica);
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistUnidadesNaturezaJuridicaCollection().add(histUnidadesNaturezaJuridica);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistUnidadesNaturezaJuridicaCollection().add(histUnidadesNaturezaJuridica);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk.getHistUnidadesNaturezaJuridicaCollection().add(histUnidadesNaturezaJuridica);
                idUnidadeDeSaudeFk = em.merge(idUnidadeDeSaudeFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistUnidadesNaturezaJuridica persistentHistUnidadesNaturezaJuridica = em.find(HistUnidadesNaturezaJuridica.class, histUnidadesNaturezaJuridica.getId());
            PessoaOperadores idOperadorCadastroFkOld = persistentHistUnidadesNaturezaJuridica.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histUnidadesNaturezaJuridica.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistUnidadesNaturezaJuridica.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histUnidadesNaturezaJuridica.getIdOperadorCancelamentoFk();
            UnidadesNaturezaJuridica idUnidadeDeSaudeFkOld = persistentHistUnidadesNaturezaJuridica.getIdUnidadeDeSaudeFk();
            UnidadesNaturezaJuridica idUnidadeDeSaudeFkNew = histUnidadesNaturezaJuridica.getIdUnidadeDeSaudeFk();
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histUnidadesNaturezaJuridica.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histUnidadesNaturezaJuridica.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idUnidadeDeSaudeFkNew != null) {
                idUnidadeDeSaudeFkNew = em.getReference(idUnidadeDeSaudeFkNew.getClass(), idUnidadeDeSaudeFkNew.getId());
                histUnidadesNaturezaJuridica.setIdUnidadeDeSaudeFk(idUnidadeDeSaudeFkNew);
            }
            histUnidadesNaturezaJuridica = em.merge(histUnidadesNaturezaJuridica);
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridica);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistUnidadesNaturezaJuridicaCollection().add(histUnidadesNaturezaJuridica);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridica);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistUnidadesNaturezaJuridicaCollection().add(histUnidadesNaturezaJuridica);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idUnidadeDeSaudeFkOld != null && !idUnidadeDeSaudeFkOld.equals(idUnidadeDeSaudeFkNew)) {
                idUnidadeDeSaudeFkOld.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridica);
                idUnidadeDeSaudeFkOld = em.merge(idUnidadeDeSaudeFkOld);
            }
            if (idUnidadeDeSaudeFkNew != null && !idUnidadeDeSaudeFkNew.equals(idUnidadeDeSaudeFkOld)) {
                idUnidadeDeSaudeFkNew.getHistUnidadesNaturezaJuridicaCollection().add(histUnidadesNaturezaJuridica);
                idUnidadeDeSaudeFkNew = em.merge(idUnidadeDeSaudeFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histUnidadesNaturezaJuridica.getId();
                if (findHistUnidadesNaturezaJuridica(id) == null) {
                    throw new NonexistentEntityException("The histUnidadesNaturezaJuridica with id " + id + " no longer exists.");
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
            HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridica;
            try {
                histUnidadesNaturezaJuridica = em.getReference(HistUnidadesNaturezaJuridica.class, id);
                histUnidadesNaturezaJuridica.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histUnidadesNaturezaJuridica with id " + id + " no longer exists.", enfe);
            }
            PessoaOperadores idOperadorCadastroFk = histUnidadesNaturezaJuridica.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridica);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histUnidadesNaturezaJuridica.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridica);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            UnidadesNaturezaJuridica idUnidadeDeSaudeFk = histUnidadesNaturezaJuridica.getIdUnidadeDeSaudeFk();
            if (idUnidadeDeSaudeFk != null) {
                idUnidadeDeSaudeFk.getHistUnidadesNaturezaJuridicaCollection().remove(histUnidadesNaturezaJuridica);
                idUnidadeDeSaudeFk = em.merge(idUnidadeDeSaudeFk);
            }
            em.remove(histUnidadesNaturezaJuridica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistUnidadesNaturezaJuridica> findHistUnidadesNaturezaJuridicaEntities() {
        return findHistUnidadesNaturezaJuridicaEntities(true, -1, -1);
    }

    public List<HistUnidadesNaturezaJuridica> findHistUnidadesNaturezaJuridicaEntities(int maxResults, int firstResult) {
        return findHistUnidadesNaturezaJuridicaEntities(false, maxResults, firstResult);
    }

    private List<HistUnidadesNaturezaJuridica> findHistUnidadesNaturezaJuridicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistUnidadesNaturezaJuridica.class));
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

    public HistUnidadesNaturezaJuridica findHistUnidadesNaturezaJuridica(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistUnidadesNaturezaJuridica.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistUnidadesNaturezaJuridicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistUnidadesNaturezaJuridica> rt = cq.from(HistUnidadesNaturezaJuridica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
