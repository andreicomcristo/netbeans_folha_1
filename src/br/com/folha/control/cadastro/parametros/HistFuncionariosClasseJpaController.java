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
import br.com.folha.model.tabelas.Classes;
import br.com.folha.model.tabelas.HistFuncionariosClasse;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosClasseJpaController implements Serializable {

    public HistFuncionariosClasseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosClasse histFuncionariosClasse) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Classes idClasseFk = histFuncionariosClasse.getIdClasseFk();
            if (idClasseFk != null) {
                idClasseFk = em.getReference(idClasseFk.getClass(), idClasseFk.getId());
                histFuncionariosClasse.setIdClasseFk(idClasseFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosClasse.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                histFuncionariosClasse.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosClasse.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosClasse.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosClasse.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosClasse.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            em.persist(histFuncionariosClasse);
            if (idClasseFk != null) {
                idClasseFk.getHistFuncionariosClasseCollection().add(histFuncionariosClasse);
                idClasseFk = em.merge(idClasseFk);
            }
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosClasseCollection().add(histFuncionariosClasse);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosClasseCollection().add(histFuncionariosClasse);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosClasseCollection().add(histFuncionariosClasse);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosClasse histFuncionariosClasse) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosClasse persistentHistFuncionariosClasse = em.find(HistFuncionariosClasse.class, histFuncionariosClasse.getId());
            Classes idClasseFkOld = persistentHistFuncionariosClasse.getIdClasseFk();
            Classes idClasseFkNew = histFuncionariosClasse.getIdClasseFk();
            PessoaFuncionarios idFuncionarioFkOld = persistentHistFuncionariosClasse.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = histFuncionariosClasse.getIdFuncionarioFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosClasse.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosClasse.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosClasse.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosClasse.getIdOperadorCancelamentoFk();
            if (idClasseFkNew != null) {
                idClasseFkNew = em.getReference(idClasseFkNew.getClass(), idClasseFkNew.getId());
                histFuncionariosClasse.setIdClasseFk(idClasseFkNew);
            }
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                histFuncionariosClasse.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosClasse.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosClasse.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            histFuncionariosClasse = em.merge(histFuncionariosClasse);
            if (idClasseFkOld != null && !idClasseFkOld.equals(idClasseFkNew)) {
                idClasseFkOld.getHistFuncionariosClasseCollection().remove(histFuncionariosClasse);
                idClasseFkOld = em.merge(idClasseFkOld);
            }
            if (idClasseFkNew != null && !idClasseFkNew.equals(idClasseFkOld)) {
                idClasseFkNew.getHistFuncionariosClasseCollection().add(histFuncionariosClasse);
                idClasseFkNew = em.merge(idClasseFkNew);
            }
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getHistFuncionariosClasseCollection().remove(histFuncionariosClasse);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getHistFuncionariosClasseCollection().add(histFuncionariosClasse);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosClasseCollection().remove(histFuncionariosClasse);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosClasseCollection().add(histFuncionariosClasse);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosClasseCollection().remove(histFuncionariosClasse);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosClasseCollection().add(histFuncionariosClasse);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosClasse.getId();
                if (findHistFuncionariosClasse(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosClasse with id " + id + " no longer exists.");
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
            HistFuncionariosClasse histFuncionariosClasse;
            try {
                histFuncionariosClasse = em.getReference(HistFuncionariosClasse.class, id);
                histFuncionariosClasse.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosClasse with id " + id + " no longer exists.", enfe);
            }
            Classes idClasseFk = histFuncionariosClasse.getIdClasseFk();
            if (idClasseFk != null) {
                idClasseFk.getHistFuncionariosClasseCollection().remove(histFuncionariosClasse);
                idClasseFk = em.merge(idClasseFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosClasse.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosClasseCollection().remove(histFuncionariosClasse);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosClasse.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosClasseCollection().remove(histFuncionariosClasse);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosClasse.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosClasseCollection().remove(histFuncionariosClasse);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.remove(histFuncionariosClasse);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosClasse> findHistFuncionariosClasseEntities() {
        return findHistFuncionariosClasseEntities(true, -1, -1);
    }

    public List<HistFuncionariosClasse> findHistFuncionariosClasseEntities(int maxResults, int firstResult) {
        return findHistFuncionariosClasseEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosClasse> findHistFuncionariosClasseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosClasse.class));
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

    public HistFuncionariosClasse findHistFuncionariosClasse(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosClasse.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosClasseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosClasse> rt = cq.from(HistFuncionariosClasse.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
