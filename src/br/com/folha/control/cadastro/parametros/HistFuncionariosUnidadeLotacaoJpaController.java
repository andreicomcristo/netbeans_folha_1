/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.HistFuncionariosUnidadeLotacao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Unidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosUnidadeLotacaoJpaController implements Serializable {

    public HistFuncionariosUnidadeLotacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaOperadores idOperadorCadastroFk = histFuncionariosUnidadeLotacao.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosUnidadeLotacao.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosUnidadeLotacao.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosUnidadeLotacao.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            Unidades idUnidadeFk = histFuncionariosUnidadeLotacao.getIdUnidadeFk();
            if (idUnidadeFk != null) {
                idUnidadeFk = em.getReference(idUnidadeFk.getClass(), idUnidadeFk.getId());
                histFuncionariosUnidadeLotacao.setIdUnidadeFk(idUnidadeFk);
            }
            em.persist(histFuncionariosUnidadeLotacao);
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosUnidadeLotacaoCollection().add(histFuncionariosUnidadeLotacao);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosUnidadeLotacaoCollection().add(histFuncionariosUnidadeLotacao);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idUnidadeFk != null) {
                idUnidadeFk.getHistFuncionariosUnidadeLotacaoCollection().add(histFuncionariosUnidadeLotacao);
                idUnidadeFk = em.merge(idUnidadeFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosUnidadeLotacao persistentHistFuncionariosUnidadeLotacao = em.find(HistFuncionariosUnidadeLotacao.class, histFuncionariosUnidadeLotacao.getId());
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosUnidadeLotacao.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosUnidadeLotacao.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosUnidadeLotacao.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosUnidadeLotacao.getIdOperadorCancelamentoFk();
            Unidades idUnidadeFkOld = persistentHistFuncionariosUnidadeLotacao.getIdUnidadeFk();
            Unidades idUnidadeFkNew = histFuncionariosUnidadeLotacao.getIdUnidadeFk();
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosUnidadeLotacao.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosUnidadeLotacao.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idUnidadeFkNew != null) {
                idUnidadeFkNew = em.getReference(idUnidadeFkNew.getClass(), idUnidadeFkNew.getId());
                histFuncionariosUnidadeLotacao.setIdUnidadeFk(idUnidadeFkNew);
            }
            histFuncionariosUnidadeLotacao = em.merge(histFuncionariosUnidadeLotacao);
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacao);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosUnidadeLotacaoCollection().add(histFuncionariosUnidadeLotacao);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacao);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosUnidadeLotacaoCollection().add(histFuncionariosUnidadeLotacao);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idUnidadeFkOld != null && !idUnidadeFkOld.equals(idUnidadeFkNew)) {
                idUnidadeFkOld.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacao);
                idUnidadeFkOld = em.merge(idUnidadeFkOld);
            }
            if (idUnidadeFkNew != null && !idUnidadeFkNew.equals(idUnidadeFkOld)) {
                idUnidadeFkNew.getHistFuncionariosUnidadeLotacaoCollection().add(histFuncionariosUnidadeLotacao);
                idUnidadeFkNew = em.merge(idUnidadeFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosUnidadeLotacao.getId();
                if (findHistFuncionariosUnidadeLotacao(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosUnidadeLotacao with id " + id + " no longer exists.");
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
            HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao;
            try {
                histFuncionariosUnidadeLotacao = em.getReference(HistFuncionariosUnidadeLotacao.class, id);
                histFuncionariosUnidadeLotacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosUnidadeLotacao with id " + id + " no longer exists.", enfe);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosUnidadeLotacao.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacao);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosUnidadeLotacao.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacao);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            Unidades idUnidadeFk = histFuncionariosUnidadeLotacao.getIdUnidadeFk();
            if (idUnidadeFk != null) {
                idUnidadeFk.getHistFuncionariosUnidadeLotacaoCollection().remove(histFuncionariosUnidadeLotacao);
                idUnidadeFk = em.merge(idUnidadeFk);
            }
            em.remove(histFuncionariosUnidadeLotacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosUnidadeLotacao> findHistFuncionariosUnidadeLotacaoEntities() {
        return findHistFuncionariosUnidadeLotacaoEntities(true, -1, -1);
    }

    public List<HistFuncionariosUnidadeLotacao> findHistFuncionariosUnidadeLotacaoEntities(int maxResults, int firstResult) {
        return findHistFuncionariosUnidadeLotacaoEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosUnidadeLotacao> findHistFuncionariosUnidadeLotacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosUnidadeLotacao.class));
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

    public HistFuncionariosUnidadeLotacao findHistFuncionariosUnidadeLotacao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosUnidadeLotacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosUnidadeLotacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosUnidadeLotacao> rt = cq.from(HistFuncionariosUnidadeLotacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
