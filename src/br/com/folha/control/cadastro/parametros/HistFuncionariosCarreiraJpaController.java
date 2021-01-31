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
import br.com.folha.model.tabelas.Carreiras;
import br.com.folha.model.tabelas.HistFuncionariosCarreira;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosCarreiraJpaController implements Serializable {

    public HistFuncionariosCarreiraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosCarreira histFuncionariosCarreira) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carreiras idCarreiraFk = histFuncionariosCarreira.getIdCarreiraFk();
            if (idCarreiraFk != null) {
                idCarreiraFk = em.getReference(idCarreiraFk.getClass(), idCarreiraFk.getId());
                histFuncionariosCarreira.setIdCarreiraFk(idCarreiraFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosCarreira.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                histFuncionariosCarreira.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosCarreira.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosCarreira.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosCarreira.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosCarreira.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            em.persist(histFuncionariosCarreira);
            if (idCarreiraFk != null) {
                idCarreiraFk.getHistFuncionariosCarreiraCollection().add(histFuncionariosCarreira);
                idCarreiraFk = em.merge(idCarreiraFk);
            }
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosCarreiraCollection().add(histFuncionariosCarreira);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosCarreiraCollection().add(histFuncionariosCarreira);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosCarreiraCollection().add(histFuncionariosCarreira);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosCarreira histFuncionariosCarreira) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosCarreira persistentHistFuncionariosCarreira = em.find(HistFuncionariosCarreira.class, histFuncionariosCarreira.getId());
            Carreiras idCarreiraFkOld = persistentHistFuncionariosCarreira.getIdCarreiraFk();
            Carreiras idCarreiraFkNew = histFuncionariosCarreira.getIdCarreiraFk();
            PessoaFuncionarios idFuncionarioFkOld = persistentHistFuncionariosCarreira.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = histFuncionariosCarreira.getIdFuncionarioFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosCarreira.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosCarreira.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosCarreira.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosCarreira.getIdOperadorCancelamentoFk();
            if (idCarreiraFkNew != null) {
                idCarreiraFkNew = em.getReference(idCarreiraFkNew.getClass(), idCarreiraFkNew.getId());
                histFuncionariosCarreira.setIdCarreiraFk(idCarreiraFkNew);
            }
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                histFuncionariosCarreira.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosCarreira.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosCarreira.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            histFuncionariosCarreira = em.merge(histFuncionariosCarreira);
            if (idCarreiraFkOld != null && !idCarreiraFkOld.equals(idCarreiraFkNew)) {
                idCarreiraFkOld.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreira);
                idCarreiraFkOld = em.merge(idCarreiraFkOld);
            }
            if (idCarreiraFkNew != null && !idCarreiraFkNew.equals(idCarreiraFkOld)) {
                idCarreiraFkNew.getHistFuncionariosCarreiraCollection().add(histFuncionariosCarreira);
                idCarreiraFkNew = em.merge(idCarreiraFkNew);
            }
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreira);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getHistFuncionariosCarreiraCollection().add(histFuncionariosCarreira);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreira);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosCarreiraCollection().add(histFuncionariosCarreira);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreira);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosCarreiraCollection().add(histFuncionariosCarreira);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosCarreira.getId();
                if (findHistFuncionariosCarreira(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosCarreira with id " + id + " no longer exists.");
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
            HistFuncionariosCarreira histFuncionariosCarreira;
            try {
                histFuncionariosCarreira = em.getReference(HistFuncionariosCarreira.class, id);
                histFuncionariosCarreira.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosCarreira with id " + id + " no longer exists.", enfe);
            }
            Carreiras idCarreiraFk = histFuncionariosCarreira.getIdCarreiraFk();
            if (idCarreiraFk != null) {
                idCarreiraFk.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreira);
                idCarreiraFk = em.merge(idCarreiraFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosCarreira.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreira);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosCarreira.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreira);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosCarreira.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosCarreiraCollection().remove(histFuncionariosCarreira);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.remove(histFuncionariosCarreira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosCarreira> findHistFuncionariosCarreiraEntities() {
        return findHistFuncionariosCarreiraEntities(true, -1, -1);
    }

    public List<HistFuncionariosCarreira> findHistFuncionariosCarreiraEntities(int maxResults, int firstResult) {
        return findHistFuncionariosCarreiraEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosCarreira> findHistFuncionariosCarreiraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosCarreira.class));
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

    public HistFuncionariosCarreira findHistFuncionariosCarreira(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosCarreira.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosCarreiraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosCarreira> rt = cq.from(HistFuncionariosCarreira.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
