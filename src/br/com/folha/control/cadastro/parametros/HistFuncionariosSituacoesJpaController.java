/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.HistFuncionariosSituacoes;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Situacoes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosSituacoesJpaController implements Serializable {

    public HistFuncionariosSituacoesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosSituacoes histFuncionariosSituacoes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaFuncionarios idFuncionarioFk = histFuncionariosSituacoes.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                histFuncionariosSituacoes.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosSituacoes.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosSituacoes.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosSituacoes.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosSituacoes.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            Situacoes idSituacaoFk = histFuncionariosSituacoes.getIdSituacaoFk();
            if (idSituacaoFk != null) {
                idSituacaoFk = em.getReference(idSituacaoFk.getClass(), idSituacaoFk.getId());
                histFuncionariosSituacoes.setIdSituacaoFk(idSituacaoFk);
            }
            em.persist(histFuncionariosSituacoes);
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosSituacoesCollection().add(histFuncionariosSituacoes);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosSituacoesCollection().add(histFuncionariosSituacoes);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosSituacoesCollection().add(histFuncionariosSituacoes);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idSituacaoFk != null) {
                idSituacaoFk.getHistFuncionariosSituacoesCollection().add(histFuncionariosSituacoes);
                idSituacaoFk = em.merge(idSituacaoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosSituacoes histFuncionariosSituacoes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosSituacoes persistentHistFuncionariosSituacoes = em.find(HistFuncionariosSituacoes.class, histFuncionariosSituacoes.getId());
            PessoaFuncionarios idFuncionarioFkOld = persistentHistFuncionariosSituacoes.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = histFuncionariosSituacoes.getIdFuncionarioFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosSituacoes.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosSituacoes.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosSituacoes.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosSituacoes.getIdOperadorCadastroFk();
            Situacoes idSituacaoFkOld = persistentHistFuncionariosSituacoes.getIdSituacaoFk();
            Situacoes idSituacaoFkNew = histFuncionariosSituacoes.getIdSituacaoFk();
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                histFuncionariosSituacoes.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosSituacoes.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosSituacoes.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idSituacaoFkNew != null) {
                idSituacaoFkNew = em.getReference(idSituacaoFkNew.getClass(), idSituacaoFkNew.getId());
                histFuncionariosSituacoes.setIdSituacaoFk(idSituacaoFkNew);
            }
            histFuncionariosSituacoes = em.merge(histFuncionariosSituacoes);
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoes);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getHistFuncionariosSituacoesCollection().add(histFuncionariosSituacoes);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoes);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosSituacoesCollection().add(histFuncionariosSituacoes);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoes);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosSituacoesCollection().add(histFuncionariosSituacoes);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idSituacaoFkOld != null && !idSituacaoFkOld.equals(idSituacaoFkNew)) {
                idSituacaoFkOld.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoes);
                idSituacaoFkOld = em.merge(idSituacaoFkOld);
            }
            if (idSituacaoFkNew != null && !idSituacaoFkNew.equals(idSituacaoFkOld)) {
                idSituacaoFkNew.getHistFuncionariosSituacoesCollection().add(histFuncionariosSituacoes);
                idSituacaoFkNew = em.merge(idSituacaoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosSituacoes.getId();
                if (findHistFuncionariosSituacoes(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosSituacoes with id " + id + " no longer exists.");
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
            HistFuncionariosSituacoes histFuncionariosSituacoes;
            try {
                histFuncionariosSituacoes = em.getReference(HistFuncionariosSituacoes.class, id);
                histFuncionariosSituacoes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosSituacoes with id " + id + " no longer exists.", enfe);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosSituacoes.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoes);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosSituacoes.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoes);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosSituacoes.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoes);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            Situacoes idSituacaoFk = histFuncionariosSituacoes.getIdSituacaoFk();
            if (idSituacaoFk != null) {
                idSituacaoFk.getHistFuncionariosSituacoesCollection().remove(histFuncionariosSituacoes);
                idSituacaoFk = em.merge(idSituacaoFk);
            }
            em.remove(histFuncionariosSituacoes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosSituacoes> findHistFuncionariosSituacoesEntities() {
        return findHistFuncionariosSituacoesEntities(true, -1, -1);
    }

    public List<HistFuncionariosSituacoes> findHistFuncionariosSituacoesEntities(int maxResults, int firstResult) {
        return findHistFuncionariosSituacoesEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosSituacoes> findHistFuncionariosSituacoesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosSituacoes.class));
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

    public HistFuncionariosSituacoes findHistFuncionariosSituacoes(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosSituacoes.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosSituacoesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosSituacoes> rt = cq.from(HistFuncionariosSituacoes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
