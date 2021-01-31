/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.HistFuncionariosVinculos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Vinculos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosVinculosJpaController implements Serializable {

    public HistFuncionariosVinculosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosVinculos histFuncionariosVinculos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaFuncionarios idFuncionarioFk = histFuncionariosVinculos.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                histFuncionariosVinculos.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosVinculos.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosVinculos.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosVinculos.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosVinculos.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            Vinculos idVinculoFk = histFuncionariosVinculos.getIdVinculoFk();
            if (idVinculoFk != null) {
                idVinculoFk = em.getReference(idVinculoFk.getClass(), idVinculoFk.getId());
                histFuncionariosVinculos.setIdVinculoFk(idVinculoFk);
            }
            em.persist(histFuncionariosVinculos);
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosVinculosCollection().add(histFuncionariosVinculos);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosVinculosCollection().add(histFuncionariosVinculos);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosVinculosCollection().add(histFuncionariosVinculos);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idVinculoFk != null) {
                idVinculoFk.getHistFuncionariosVinculosCollection().add(histFuncionariosVinculos);
                idVinculoFk = em.merge(idVinculoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosVinculos histFuncionariosVinculos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosVinculos persistentHistFuncionariosVinculos = em.find(HistFuncionariosVinculos.class, histFuncionariosVinculos.getId());
            PessoaFuncionarios idFuncionarioFkOld = persistentHistFuncionariosVinculos.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = histFuncionariosVinculos.getIdFuncionarioFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosVinculos.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosVinculos.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosVinculos.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosVinculos.getIdOperadorCancelamentoFk();
            Vinculos idVinculoFkOld = persistentHistFuncionariosVinculos.getIdVinculoFk();
            Vinculos idVinculoFkNew = histFuncionariosVinculos.getIdVinculoFk();
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                histFuncionariosVinculos.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosVinculos.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosVinculos.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idVinculoFkNew != null) {
                idVinculoFkNew = em.getReference(idVinculoFkNew.getClass(), idVinculoFkNew.getId());
                histFuncionariosVinculos.setIdVinculoFk(idVinculoFkNew);
            }
            histFuncionariosVinculos = em.merge(histFuncionariosVinculos);
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculos);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getHistFuncionariosVinculosCollection().add(histFuncionariosVinculos);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculos);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosVinculosCollection().add(histFuncionariosVinculos);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculos);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosVinculosCollection().add(histFuncionariosVinculos);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idVinculoFkOld != null && !idVinculoFkOld.equals(idVinculoFkNew)) {
                idVinculoFkOld.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculos);
                idVinculoFkOld = em.merge(idVinculoFkOld);
            }
            if (idVinculoFkNew != null && !idVinculoFkNew.equals(idVinculoFkOld)) {
                idVinculoFkNew.getHistFuncionariosVinculosCollection().add(histFuncionariosVinculos);
                idVinculoFkNew = em.merge(idVinculoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosVinculos.getId();
                if (findHistFuncionariosVinculos(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosVinculos with id " + id + " no longer exists.");
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
            HistFuncionariosVinculos histFuncionariosVinculos;
            try {
                histFuncionariosVinculos = em.getReference(HistFuncionariosVinculos.class, id);
                histFuncionariosVinculos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosVinculos with id " + id + " no longer exists.", enfe);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosVinculos.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculos);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosVinculos.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculos);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosVinculos.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculos);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            Vinculos idVinculoFk = histFuncionariosVinculos.getIdVinculoFk();
            if (idVinculoFk != null) {
                idVinculoFk.getHistFuncionariosVinculosCollection().remove(histFuncionariosVinculos);
                idVinculoFk = em.merge(idVinculoFk);
            }
            em.remove(histFuncionariosVinculos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosVinculos> findHistFuncionariosVinculosEntities() {
        return findHistFuncionariosVinculosEntities(true, -1, -1);
    }

    public List<HistFuncionariosVinculos> findHistFuncionariosVinculosEntities(int maxResults, int firstResult) {
        return findHistFuncionariosVinculosEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosVinculos> findHistFuncionariosVinculosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosVinculos.class));
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

    public HistFuncionariosVinculos findHistFuncionariosVinculos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosVinculos.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosVinculosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosVinculos> rt = cq.from(HistFuncionariosVinculos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
