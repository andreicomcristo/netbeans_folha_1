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
import br.com.folha.model.tabelas.CargaHorariaSemanal;
import br.com.folha.model.tabelas.HistFuncionariosCargaHoraria;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaOperadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistFuncionariosCargaHorariaJpaController implements Serializable {

    public HistFuncionariosCargaHorariaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistFuncionariosCargaHoraria histFuncionariosCargaHoraria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CargaHorariaSemanal idCargaHorariaSemanalFk = histFuncionariosCargaHoraria.getIdCargaHorariaSemanalFk();
            if (idCargaHorariaSemanalFk != null) {
                idCargaHorariaSemanalFk = em.getReference(idCargaHorariaSemanalFk.getClass(), idCargaHorariaSemanalFk.getId());
                histFuncionariosCargaHoraria.setIdCargaHorariaSemanalFk(idCargaHorariaSemanalFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosCargaHoraria.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk = em.getReference(idFuncionarioFk.getClass(), idFuncionarioFk.getId());
                histFuncionariosCargaHoraria.setIdFuncionarioFk(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosCargaHoraria.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histFuncionariosCargaHoraria.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosCargaHoraria.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                histFuncionariosCargaHoraria.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            em.persist(histFuncionariosCargaHoraria);
            if (idCargaHorariaSemanalFk != null) {
                idCargaHorariaSemanalFk.getHistFuncionariosCargaHorariaCollection().add(histFuncionariosCargaHoraria);
                idCargaHorariaSemanalFk = em.merge(idCargaHorariaSemanalFk);
            }
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosCargaHorariaCollection().add(histFuncionariosCargaHoraria);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosCargaHorariaCollection().add(histFuncionariosCargaHoraria);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosCargaHorariaCollection().add(histFuncionariosCargaHoraria);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistFuncionariosCargaHoraria histFuncionariosCargaHoraria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistFuncionariosCargaHoraria persistentHistFuncionariosCargaHoraria = em.find(HistFuncionariosCargaHoraria.class, histFuncionariosCargaHoraria.getId());
            CargaHorariaSemanal idCargaHorariaSemanalFkOld = persistentHistFuncionariosCargaHoraria.getIdCargaHorariaSemanalFk();
            CargaHorariaSemanal idCargaHorariaSemanalFkNew = histFuncionariosCargaHoraria.getIdCargaHorariaSemanalFk();
            PessoaFuncionarios idFuncionarioFkOld = persistentHistFuncionariosCargaHoraria.getIdFuncionarioFk();
            PessoaFuncionarios idFuncionarioFkNew = histFuncionariosCargaHoraria.getIdFuncionarioFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistFuncionariosCargaHoraria.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histFuncionariosCargaHoraria.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentHistFuncionariosCargaHoraria.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = histFuncionariosCargaHoraria.getIdOperadorCadastroFk();
            if (idCargaHorariaSemanalFkNew != null) {
                idCargaHorariaSemanalFkNew = em.getReference(idCargaHorariaSemanalFkNew.getClass(), idCargaHorariaSemanalFkNew.getId());
                histFuncionariosCargaHoraria.setIdCargaHorariaSemanalFk(idCargaHorariaSemanalFkNew);
            }
            if (idFuncionarioFkNew != null) {
                idFuncionarioFkNew = em.getReference(idFuncionarioFkNew.getClass(), idFuncionarioFkNew.getId());
                histFuncionariosCargaHoraria.setIdFuncionarioFk(idFuncionarioFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histFuncionariosCargaHoraria.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                histFuncionariosCargaHoraria.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            histFuncionariosCargaHoraria = em.merge(histFuncionariosCargaHoraria);
            if (idCargaHorariaSemanalFkOld != null && !idCargaHorariaSemanalFkOld.equals(idCargaHorariaSemanalFkNew)) {
                idCargaHorariaSemanalFkOld.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHoraria);
                idCargaHorariaSemanalFkOld = em.merge(idCargaHorariaSemanalFkOld);
            }
            if (idCargaHorariaSemanalFkNew != null && !idCargaHorariaSemanalFkNew.equals(idCargaHorariaSemanalFkOld)) {
                idCargaHorariaSemanalFkNew.getHistFuncionariosCargaHorariaCollection().add(histFuncionariosCargaHoraria);
                idCargaHorariaSemanalFkNew = em.merge(idCargaHorariaSemanalFkNew);
            }
            if (idFuncionarioFkOld != null && !idFuncionarioFkOld.equals(idFuncionarioFkNew)) {
                idFuncionarioFkOld.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHoraria);
                idFuncionarioFkOld = em.merge(idFuncionarioFkOld);
            }
            if (idFuncionarioFkNew != null && !idFuncionarioFkNew.equals(idFuncionarioFkOld)) {
                idFuncionarioFkNew.getHistFuncionariosCargaHorariaCollection().add(histFuncionariosCargaHoraria);
                idFuncionarioFkNew = em.merge(idFuncionarioFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHoraria);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistFuncionariosCargaHorariaCollection().add(histFuncionariosCargaHoraria);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHoraria);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getHistFuncionariosCargaHorariaCollection().add(histFuncionariosCargaHoraria);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = histFuncionariosCargaHoraria.getId();
                if (findHistFuncionariosCargaHoraria(id) == null) {
                    throw new NonexistentEntityException("The histFuncionariosCargaHoraria with id " + id + " no longer exists.");
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
            HistFuncionariosCargaHoraria histFuncionariosCargaHoraria;
            try {
                histFuncionariosCargaHoraria = em.getReference(HistFuncionariosCargaHoraria.class, id);
                histFuncionariosCargaHoraria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histFuncionariosCargaHoraria with id " + id + " no longer exists.", enfe);
            }
            CargaHorariaSemanal idCargaHorariaSemanalFk = histFuncionariosCargaHoraria.getIdCargaHorariaSemanalFk();
            if (idCargaHorariaSemanalFk != null) {
                idCargaHorariaSemanalFk.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHoraria);
                idCargaHorariaSemanalFk = em.merge(idCargaHorariaSemanalFk);
            }
            PessoaFuncionarios idFuncionarioFk = histFuncionariosCargaHoraria.getIdFuncionarioFk();
            if (idFuncionarioFk != null) {
                idFuncionarioFk.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHoraria);
                idFuncionarioFk = em.merge(idFuncionarioFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = histFuncionariosCargaHoraria.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHoraria);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            PessoaOperadores idOperadorCadastroFk = histFuncionariosCargaHoraria.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getHistFuncionariosCargaHorariaCollection().remove(histFuncionariosCargaHoraria);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            em.remove(histFuncionariosCargaHoraria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistFuncionariosCargaHoraria> findHistFuncionariosCargaHorariaEntities() {
        return findHistFuncionariosCargaHorariaEntities(true, -1, -1);
    }

    public List<HistFuncionariosCargaHoraria> findHistFuncionariosCargaHorariaEntities(int maxResults, int firstResult) {
        return findHistFuncionariosCargaHorariaEntities(false, maxResults, firstResult);
    }

    private List<HistFuncionariosCargaHoraria> findHistFuncionariosCargaHorariaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistFuncionariosCargaHoraria.class));
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

    public HistFuncionariosCargaHoraria findHistFuncionariosCargaHoraria(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistFuncionariosCargaHoraria.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistFuncionariosCargaHorariaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistFuncionariosCargaHoraria> rt = cq.from(HistFuncionariosCargaHoraria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
