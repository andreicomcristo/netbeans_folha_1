/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.HistFuncionariosUnidadeAtuacao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Unidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosUnidadeAtuacaoJpaController implements Serializable {

    public HistFuncionariosUnidadeAtuacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaFuncionarios idFuncionarioFk = histFuncionariosUnidadeAtuacao.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                histFuncionariosUnidadeAtuacao.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosUnidadeAtuacao.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosUnidadeAtuacao.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosUnidadeAtuacao.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosUnidadeAtuacao.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            Unidades idUnidadeFk = histFuncionariosUnidadeAtuacao.getIdUnidadeFk();
            if (idUnidadeFk != null) {
                idUnidadeFk = em.getReference(idUnidadeFk.getClass(), idUnidadeFk.getId());
                histFuncionariosUnidadeAtuacao.setIdUnidadeFk(idUnidadeFk);
            }
            em.persist(histFuncionariosUnidadeAtuacao);
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosUnidadeAtuacaoCollection().add(histFuncionariosUnidadeAtuacao);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosUnidadeAtuacaoCollection().add(histFuncionariosUnidadeAtuacao);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosUnidadeAtuacaoCollection().add(histFuncionariosUnidadeAtuacao);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idUnidadeFk != null) {
                idUnidadeFk.getHistFuncionariosUnidadeAtuacaoCollection().add(histFuncionariosUnidadeAtuacao);
                idUnidadeFk = em.merge(idUnidadeFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosUnidadeAtuacao persistentHistFuncionariosUnidadeAtuacao = em.find(HistFuncionariosUnidadeAtuacao.class, histFuncionariosUnidadeAtuacao.getId());
            PessoaFuncionarios idFuncionarioFkOld = persistentHistFuncionariosUnidadeAtuacao.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = histFuncionariosUnidadeAtuacao.getIdFuncionarioFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosUnidadeAtuacao.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosUnidadeAtuacao.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosUnidadeAtuacao.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosUnidadeAtuacao.getIdOperadorCancelamentoFk();
            Unidades idUnidadeFkOld = persistentHistFuncionariosUnidadeAtuacao.getIdUnidadeFk();
            Unidades idUnidadeFkNew = histFuncionariosUnidadeAtuacao.getIdUnidadeFk();
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                histFuncionariosUnidadeAtuacao.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosUnidadeAtuacao.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosUnidadeAtuacao.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idUnidadeFkNew != null) {
                idUnidadeFkNew = em.getReference(idUnidadeFkNew.getClass(), idUnidadeFkNew.getId());
                histFuncionariosUnidadeAtuacao.setIdUnidadeFk(idUnidadeFkNew);
            }
            histFuncionariosUnidadeAtuacao = em.merge(histFuncionariosUnidadeAtuacao);
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacao);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getHistFuncionariosUnidadeAtuacaoCollection().add(histFuncionariosUnidadeAtuacao);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacao);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosUnidadeAtuacaoCollection().add(histFuncionariosUnidadeAtuacao);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacao);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosUnidadeAtuacaoCollection().add(histFuncionariosUnidadeAtuacao);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idUnidadeFkOld != null && !idUnidadeFkOld.equals(idUnidadeFkNew)) {
                idUnidadeFkOld.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacao);
                idUnidadeFkOld = em.merge(idUnidadeFkOld);
            }
            if (idUnidadeFkNew != null && !idUnidadeFkNew.equals(idUnidadeFkOld)) {
                idUnidadeFkNew.getHistFuncionariosUnidadeAtuacaoCollection().add(histFuncionariosUnidadeAtuacao);
                idUnidadeFkNew = em.merge(idUnidadeFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosUnidadeAtuacao.getId();
                if (findHistFuncionariosUnidadeAtuacao(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosUnidadeAtuacao with id " + id + " no longer exists.");
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
            HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao;
            try {
                histFuncionariosUnidadeAtuacao = em.getReference(HistFuncionariosUnidadeAtuacao.class, id);
                histFuncionariosUnidadeAtuacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosUnidadeAtuacao with id " + id + " no longer exists.", enfe);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosUnidadeAtuacao.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacao);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosUnidadeAtuacao.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacao);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosUnidadeAtuacao.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacao);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            Unidades idUnidadeFk = histFuncionariosUnidadeAtuacao.getIdUnidadeFk();
            if (idUnidadeFk != null) {
                idUnidadeFk.getHistFuncionariosUnidadeAtuacaoCollection().remove(histFuncionariosUnidadeAtuacao);
                idUnidadeFk = em.merge(idUnidadeFk);
            }
            em.remove(histFuncionariosUnidadeAtuacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosUnidadeAtuacao> findHistFuncionariosUnidadeAtuacaoEntities() {
        return findHistFuncionariosUnidadeAtuacaoEntities(true, -1, -1);
    }

    public List<HistFuncionariosUnidadeAtuacao> findHistFuncionariosUnidadeAtuacaoEntities(int maxResults, int firstResult) {
        return findHistFuncionariosUnidadeAtuacaoEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosUnidadeAtuacao> findHistFuncionariosUnidadeAtuacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosUnidadeAtuacao.class));
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

    public HistFuncionariosUnidadeAtuacao findHistFuncionariosUnidadeAtuacao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosUnidadeAtuacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosUnidadeAtuacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosUnidadeAtuacao> rt = cq.from(HistFuncionariosUnidadeAtuacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
