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
import br.com.folha.model.tabelas.Cargos;
import br.com.folha.model.tabelas.HistFuncionariosCargos;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosCargosJpaController implements Serializable {

    public HistFuncionariosCargosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosCargos histFuncionariosCargos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargos idCargoFk = histFuncionariosCargos.getIdCargoFk();
            if (idCargoFk != null) {
                idCargoFk = em.getReference(idCargoFk.getClass(), idCargoFk.getId());
                histFuncionariosCargos.setIdCargoFk(idCargoFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosCargos.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                histFuncionariosCargos.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosCargos.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosCargos.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosCargos.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosCargos.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            em.persist(histFuncionariosCargos);
            if (idCargoFk != null) {
                idCargoFk.getHistFuncionariosCargosCollection().add(histFuncionariosCargos);
                idCargoFk = em.merge(idCargoFk);
            }
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosCargosCollection().add(histFuncionariosCargos);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosCargosCollection().add(histFuncionariosCargos);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosCargosCollection().add(histFuncionariosCargos);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosCargos histFuncionariosCargos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosCargos persistentHistFuncionariosCargos = em.find(HistFuncionariosCargos.class, histFuncionariosCargos.getId());
            Cargos idCargoFkOld = persistentHistFuncionariosCargos.getIdCargoFk();
            Cargos idCargoFkNew = histFuncionariosCargos.getIdCargoFk();
            PessoaFuncionarios idFuncionarioFkOld = persistentHistFuncionariosCargos.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = histFuncionariosCargos.getIdFuncionarioFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosCargos.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosCargos.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosCargos.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosCargos.getIdOperadorCancelamentoFk();
            if (idCargoFkNew != null) {
                idCargoFkNew = em.getReference(idCargoFkNew.getClass(), idCargoFkNew.getId());
                histFuncionariosCargos.setIdCargoFk(idCargoFkNew);
            }
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                histFuncionariosCargos.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosCargos.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosCargos.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            histFuncionariosCargos = em.merge(histFuncionariosCargos);
            if (idCargoFkOld != null && !idCargoFkOld.equals(idCargoFkNew)) {
                idCargoFkOld.getHistFuncionariosCargosCollection().remove(histFuncionariosCargos);
                idCargoFkOld = em.merge(idCargoFkOld);
            }
            if (idCargoFkNew != null && !idCargoFkNew.equals(idCargoFkOld)) {
                idCargoFkNew.getHistFuncionariosCargosCollection().add(histFuncionariosCargos);
                idCargoFkNew = em.merge(idCargoFkNew);
            }
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getHistFuncionariosCargosCollection().remove(histFuncionariosCargos);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getHistFuncionariosCargosCollection().add(histFuncionariosCargos);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosCargosCollection().remove(histFuncionariosCargos);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosCargosCollection().add(histFuncionariosCargos);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosCargosCollection().remove(histFuncionariosCargos);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosCargosCollection().add(histFuncionariosCargos);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosCargos.getId();
                if (findHistFuncionariosCargos(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosCargos with id " + id + " no longer exists.");
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
            HistFuncionariosCargos histFuncionariosCargos;
            try {
                histFuncionariosCargos = em.getReference(HistFuncionariosCargos.class, id);
                histFuncionariosCargos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosCargos with id " + id + " no longer exists.", enfe);
            }
            Cargos idCargoFk = histFuncionariosCargos.getIdCargoFk();
            if (idCargoFk != null) {
                idCargoFk.getHistFuncionariosCargosCollection().remove(histFuncionariosCargos);
                idCargoFk = em.merge(idCargoFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosCargos.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosCargosCollection().remove(histFuncionariosCargos);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosCargos.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosCargosCollection().remove(histFuncionariosCargos);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosCargos.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosCargosCollection().remove(histFuncionariosCargos);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.remove(histFuncionariosCargos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosCargos> findHistFuncionariosCargosEntities() {
        return findHistFuncionariosCargosEntities(true, -1, -1);
    }

    public List<HistFuncionariosCargos> findHistFuncionariosCargosEntities(int maxResults, int firstResult) {
        return findHistFuncionariosCargosEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosCargos> findHistFuncionariosCargosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosCargos.class));
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

    public HistFuncionariosCargos findHistFuncionariosCargos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosCargos.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosCargosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosCargos> rt = cq.from(HistFuncionariosCargos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
