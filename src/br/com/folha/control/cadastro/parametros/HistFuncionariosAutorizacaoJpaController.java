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
import br.com.folha.model.tabelas.Autorizacoes;
import br.com.folha.model.tabelas.HistFuncionariosAutorizacao;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosAutorizacaoJpaController implements Serializable {

    public HistFuncionariosAutorizacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosAutorizacao histFuncionariosAutorizacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autorizacoes idAutorizacaoFk = histFuncionariosAutorizacao.getIdAutorizacaoFk();
            if (idAutorizacaoFk != null) {
                idAutorizacaoFk = em.getReference(idAutorizacaoFk.getClass(), idAutorizacaoFk.getId());
                histFuncionariosAutorizacao.setIdAutorizacaoFk(idAutorizacaoFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosAutorizacao.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                histFuncionariosAutorizacao.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosAutorizacao.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosAutorizacao.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosAutorizacao.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosAutorizacao.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            em.persist(histFuncionariosAutorizacao);
            if (idAutorizacaoFk != null) {
                idAutorizacaoFk.getHistFuncionariosAutorizacaoCollection().add(histFuncionariosAutorizacao);
                idAutorizacaoFk = em.merge(idAutorizacaoFk);
            }
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosAutorizacaoCollection().add(histFuncionariosAutorizacao);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosAutorizacaoCollection().add(histFuncionariosAutorizacao);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosAutorizacaoCollection().add(histFuncionariosAutorizacao);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosAutorizacao histFuncionariosAutorizacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosAutorizacao persistentHistFuncionariosAutorizacao = em.find(HistFuncionariosAutorizacao.class, histFuncionariosAutorizacao.getId());
            Autorizacoes idAutorizacaoFkOld = persistentHistFuncionariosAutorizacao.getIdAutorizacaoFk();
            Autorizacoes idAutorizacaoFkNew = histFuncionariosAutorizacao.getIdAutorizacaoFk();
            PessoaFuncionarios idFuncionarioFkOld = persistentHistFuncionariosAutorizacao.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = histFuncionariosAutorizacao.getIdFuncionarioFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosAutorizacao.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosAutorizacao.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosAutorizacao.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosAutorizacao.getIdOperadorCancelamentoFk();
            if (idAutorizacaoFkNew != null) {
                idAutorizacaoFkNew = em.getReference(idAutorizacaoFkNew.getClass(), idAutorizacaoFkNew.getId());
                histFuncionariosAutorizacao.setIdAutorizacaoFk(idAutorizacaoFkNew);
            }
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                histFuncionariosAutorizacao.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosAutorizacao.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosAutorizacao.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            histFuncionariosAutorizacao = em.merge(histFuncionariosAutorizacao);
            if (idAutorizacaoFkOld != null && !idAutorizacaoFkOld.equals(idAutorizacaoFkNew)) {
                idAutorizacaoFkOld.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacao);
                idAutorizacaoFkOld = em.merge(idAutorizacaoFkOld);
            }
            if (idAutorizacaoFkNew != null && !idAutorizacaoFkNew.equals(idAutorizacaoFkOld)) {
                idAutorizacaoFkNew.getHistFuncionariosAutorizacaoCollection().add(histFuncionariosAutorizacao);
                idAutorizacaoFkNew = em.merge(idAutorizacaoFkNew);
            }
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacao);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getHistFuncionariosAutorizacaoCollection().add(histFuncionariosAutorizacao);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacao);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosAutorizacaoCollection().add(histFuncionariosAutorizacao);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacao);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosAutorizacaoCollection().add(histFuncionariosAutorizacao);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosAutorizacao.getId();
                if (findHistFuncionariosAutorizacao(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosAutorizacao with id " + id + " no longer exists.");
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
            HistFuncionariosAutorizacao histFuncionariosAutorizacao;
            try {
                histFuncionariosAutorizacao = em.getReference(HistFuncionariosAutorizacao.class, id);
                histFuncionariosAutorizacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosAutorizacao with id " + id + " no longer exists.", enfe);
            }
            Autorizacoes idAutorizacaoFk = histFuncionariosAutorizacao.getIdAutorizacaoFk();
            if (idAutorizacaoFk != null) {
                idAutorizacaoFk.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacao);
                idAutorizacaoFk = em.merge(idAutorizacaoFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosAutorizacao.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacao);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosAutorizacao.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacao);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosAutorizacao.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosAutorizacaoCollection().remove(histFuncionariosAutorizacao);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.remove(histFuncionariosAutorizacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosAutorizacao> findHistFuncionariosAutorizacaoEntities() {
        return findHistFuncionariosAutorizacaoEntities(true, -1, -1);
    }

    public List<HistFuncionariosAutorizacao> findHistFuncionariosAutorizacaoEntities(int maxResults, int firstResult) {
        return findHistFuncionariosAutorizacaoEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosAutorizacao> findHistFuncionariosAutorizacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosAutorizacao.class));
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

    public HistFuncionariosAutorizacao findHistFuncionariosAutorizacao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosAutorizacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosAutorizacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosAutorizacao> rt = cq.from(HistFuncionariosAutorizacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
