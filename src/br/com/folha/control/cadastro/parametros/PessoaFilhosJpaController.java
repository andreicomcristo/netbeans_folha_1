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
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaFilhos;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.TiposDeFiliacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaFilhosJpaController implements Serializable {

    public PessoaFilhosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaFilhos pessoaFilhos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa idPessoaFk = pessoaFilhos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaFilhos.setIdPessoaFk(idPessoaFk);
            }
            PessoaOperadores idOperadorCadastroFk = pessoaFilhos.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                pessoaFilhos.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = pessoaFilhos.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                pessoaFilhos.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            TiposDeFiliacao idTipoFiliacaoFk = pessoaFilhos.getIdTipoFiliacaoFk();
            if (idTipoFiliacaoFk != null) {
                idTipoFiliacaoFk = em.getReference(idTipoFiliacaoFk.getClass(), idTipoFiliacaoFk.getId());
                pessoaFilhos.setIdTipoFiliacaoFk(idTipoFiliacaoFk);
            }
            em.persist(pessoaFilhos);
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaFilhosCollection().add(pessoaFilhos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getPessoaFilhosCollection().add(pessoaFilhos);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getPessoaFilhosCollection().add(pessoaFilhos);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idTipoFiliacaoFk != null) {
                idTipoFiliacaoFk.getPessoaFilhosCollection().add(pessoaFilhos);
                idTipoFiliacaoFk = em.merge(idTipoFiliacaoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaFilhos pessoaFilhos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaFilhos persistentPessoaFilhos = em.find(PessoaFilhos.class, pessoaFilhos.getId());
            Pessoa idPessoaFkOld = persistentPessoaFilhos.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaFilhos.getIdPessoaFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentPessoaFilhos.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = pessoaFilhos.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentPessoaFilhos.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = pessoaFilhos.getIdOperadorCancelamentoFk();
            TiposDeFiliacao idTipoFiliacaoFkOld = persistentPessoaFilhos.getIdTipoFiliacaoFk();
            TiposDeFiliacao idTipoFiliacaoFkNew = pessoaFilhos.getIdTipoFiliacaoFk();
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaFilhos.setIdPessoaFk(idPessoaFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                pessoaFilhos.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                pessoaFilhos.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idTipoFiliacaoFkNew != null) {
                idTipoFiliacaoFkNew = em.getReference(idTipoFiliacaoFkNew.getClass(), idTipoFiliacaoFkNew.getId());
                pessoaFilhos.setIdTipoFiliacaoFk(idTipoFiliacaoFkNew);
            }
            pessoaFilhos = em.merge(pessoaFilhos);
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaFilhosCollection().remove(pessoaFilhos);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaFilhosCollection().add(pessoaFilhos);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getPessoaFilhosCollection().remove(pessoaFilhos);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getPessoaFilhosCollection().add(pessoaFilhos);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getPessoaFilhosCollection().remove(pessoaFilhos);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getPessoaFilhosCollection().add(pessoaFilhos);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idTipoFiliacaoFkOld != null && !idTipoFiliacaoFkOld.equals(idTipoFiliacaoFkNew)) {
                idTipoFiliacaoFkOld.getPessoaFilhosCollection().remove(pessoaFilhos);
                idTipoFiliacaoFkOld = em.merge(idTipoFiliacaoFkOld);
            }
            if (idTipoFiliacaoFkNew != null && !idTipoFiliacaoFkNew.equals(idTipoFiliacaoFkOld)) {
                idTipoFiliacaoFkNew.getPessoaFilhosCollection().add(pessoaFilhos);
                idTipoFiliacaoFkNew = em.merge(idTipoFiliacaoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaFilhos.getId();
                if (findPessoaFilhos(id) == null) {
                    throw new NonexistentEntityException("The pessoaFilhos with id " + id + " no longer exists.");
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
            PessoaFilhos pessoaFilhos;
            try {
                pessoaFilhos = em.getReference(PessoaFilhos.class, id);
                pessoaFilhos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaFilhos with id " + id + " no longer exists.", enfe);
            }
            Pessoa idPessoaFk = pessoaFilhos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaFilhosCollection().remove(pessoaFilhos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            PessoaOperadores idOperadorCadastroFk = pessoaFilhos.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getPessoaFilhosCollection().remove(pessoaFilhos);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = pessoaFilhos.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getPessoaFilhosCollection().remove(pessoaFilhos);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            TiposDeFiliacao idTipoFiliacaoFk = pessoaFilhos.getIdTipoFiliacaoFk();
            if (idTipoFiliacaoFk != null) {
                idTipoFiliacaoFk.getPessoaFilhosCollection().remove(pessoaFilhos);
                idTipoFiliacaoFk = em.merge(idTipoFiliacaoFk);
            }
            em.remove(pessoaFilhos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaFilhos> findPessoaFilhosEntities() {
        return findPessoaFilhosEntities(true, -1, -1);
    }

    public List<PessoaFilhos> findPessoaFilhosEntities(int maxResults, int firstResult) {
        return findPessoaFilhosEntities(false, maxResults, firstResult);
    }

    private List<PessoaFilhos> findPessoaFilhosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaFilhos.class));
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

    public PessoaFilhos findPessoaFilhos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaFilhos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaFilhosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaFilhos> rt = cq.from(PessoaFilhos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
