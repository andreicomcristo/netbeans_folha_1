/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.control.cadastro.parametros.exceptions.PreexistingEntityException;
import br.com.folha.model.tabelas.HistUnidadesDiretor;
import br.com.folha.model.tabelas.HistUnidadesDiretorPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Unidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class HistUnidadesDiretorJpaController implements Serializable {

    public HistUnidadesDiretorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistUnidadesDiretor histUnidadesDiretor) throws PreexistingEntityException, Exception {
        if (histUnidadesDiretor.getHistUnidadesDiretorPK() == null) {
            histUnidadesDiretor.setHistUnidadesDiretorPK(new HistUnidadesDiretorPK());
        }
        histUnidadesDiretor.getHistUnidadesDiretorPK().setIdOperadorCadastroFk(histUnidadesDiretor.getPessoaOperadores().getId());
        histUnidadesDiretor.getHistUnidadesDiretorPK().setId(histUnidadesDiretor.getPessoa().getId());
        histUnidadesDiretor.getHistUnidadesDiretorPK().setIdUnidadeDeSaudeFk(histUnidadesDiretor.getUnidades().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa pessoa = histUnidadesDiretor.getPessoa();
            if (pessoa != null) {
                pessoa = em.getReference(pessoa.getClass(), pessoa.getId());
                histUnidadesDiretor.setPessoa(pessoa);
            }
            PessoaOperadores pessoaOperadores = histUnidadesDiretor.getPessoaOperadores();
            if (pessoaOperadores != null) {
                pessoaOperadores = em.getReference(pessoaOperadores.getClass(), pessoaOperadores.getId());
                histUnidadesDiretor.setPessoaOperadores(pessoaOperadores);
            }
            PessoaOperadores idOperadorCancelamentoFk = histUnidadesDiretor.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                histUnidadesDiretor.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            Unidades unidades = histUnidadesDiretor.getUnidades();
            if (unidades != null) {
                unidades = em.getReference(unidades.getClass(), unidades.getId());
                histUnidadesDiretor.setUnidades(unidades);
            }
            em.persist(histUnidadesDiretor);
            if (pessoa != null) {
                pessoa.getHistUnidadesDiretorCollection().add(histUnidadesDiretor);
                pessoa = em.merge(pessoa);
            }
            if (pessoaOperadores != null) {
                pessoaOperadores.getHistUnidadesDiretorCollection().add(histUnidadesDiretor);
                pessoaOperadores = em.merge(pessoaOperadores);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistUnidadesDiretorCollection().add(histUnidadesDiretor);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            if (unidades != null) {
                unidades.getHistUnidadesDiretorCollection().add(histUnidadesDiretor);
                unidades = em.merge(unidades);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistUnidadesDiretor(histUnidadesDiretor.getHistUnidadesDiretorPK()) != null) {
                throw new PreexistingEntityException("HistUnidadesDiretor " + histUnidadesDiretor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistUnidadesDiretor histUnidadesDiretor) throws NonexistentEntityException, Exception {
        histUnidadesDiretor.getHistUnidadesDiretorPK().setIdOperadorCadastroFk(histUnidadesDiretor.getPessoaOperadores().getId());
        histUnidadesDiretor.getHistUnidadesDiretorPK().setId(histUnidadesDiretor.getPessoa().getId());
        histUnidadesDiretor.getHistUnidadesDiretorPK().setIdUnidadeDeSaudeFk(histUnidadesDiretor.getUnidades().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistUnidadesDiretor persistentHistUnidadesDiretor = em.find(HistUnidadesDiretor.class, histUnidadesDiretor.getHistUnidadesDiretorPK());
            Pessoa pessoaOld = persistentHistUnidadesDiretor.getPessoa();
            Pessoa pessoaNew = histUnidadesDiretor.getPessoa();
            PessoaOperadores pessoaOperadoresOld = persistentHistUnidadesDiretor.getPessoaOperadores();
            PessoaOperadores pessoaOperadoresNew = histUnidadesDiretor.getPessoaOperadores();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentHistUnidadesDiretor.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = histUnidadesDiretor.getIdOperadorCancelamentoFk();
            Unidades unidadesOld = persistentHistUnidadesDiretor.getUnidades();
            Unidades unidadesNew = histUnidadesDiretor.getUnidades();
            if (pessoaNew != null) {
                pessoaNew = em.getReference(pessoaNew.getClass(), pessoaNew.getId());
                histUnidadesDiretor.setPessoa(pessoaNew);
            }
            if (pessoaOperadoresNew != null) {
                pessoaOperadoresNew = em.getReference(pessoaOperadoresNew.getClass(), pessoaOperadoresNew.getId());
                histUnidadesDiretor.setPessoaOperadores(pessoaOperadoresNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                histUnidadesDiretor.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            if (unidadesNew != null) {
                unidadesNew = em.getReference(unidadesNew.getClass(), unidadesNew.getId());
                histUnidadesDiretor.setUnidades(unidadesNew);
            }
            histUnidadesDiretor = em.merge(histUnidadesDiretor);
            if (pessoaOld != null && !pessoaOld.equals(pessoaNew)) {
                pessoaOld.getHistUnidadesDiretorCollection().remove(histUnidadesDiretor);
                pessoaOld = em.merge(pessoaOld);
            }
            if (pessoaNew != null && !pessoaNew.equals(pessoaOld)) {
                pessoaNew.getHistUnidadesDiretorCollection().add(histUnidadesDiretor);
                pessoaNew = em.merge(pessoaNew);
            }
            if (pessoaOperadoresOld != null && !pessoaOperadoresOld.equals(pessoaOperadoresNew)) {
                pessoaOperadoresOld.getHistUnidadesDiretorCollection().remove(histUnidadesDiretor);
                pessoaOperadoresOld = em.merge(pessoaOperadoresOld);
            }
            if (pessoaOperadoresNew != null && !pessoaOperadoresNew.equals(pessoaOperadoresOld)) {
                pessoaOperadoresNew.getHistUnidadesDiretorCollection().add(histUnidadesDiretor);
                pessoaOperadoresNew = em.merge(pessoaOperadoresNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getHistUnidadesDiretorCollection().remove(histUnidadesDiretor);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getHistUnidadesDiretorCollection().add(histUnidadesDiretor);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            if (unidadesOld != null && !unidadesOld.equals(unidadesNew)) {
                unidadesOld.getHistUnidadesDiretorCollection().remove(histUnidadesDiretor);
                unidadesOld = em.merge(unidadesOld);
            }
            if (unidadesNew != null && !unidadesNew.equals(unidadesOld)) {
                unidadesNew.getHistUnidadesDiretorCollection().add(histUnidadesDiretor);
                unidadesNew = em.merge(unidadesNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                HistUnidadesDiretorPK id = histUnidadesDiretor.getHistUnidadesDiretorPK();
                if (findHistUnidadesDiretor(id) == null) {
                    throw new NonexistentEntityException("The histUnidadesDiretor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(HistUnidadesDiretorPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistUnidadesDiretor histUnidadesDiretor;
            try {
                histUnidadesDiretor = em.getReference(HistUnidadesDiretor.class, id);
                histUnidadesDiretor.getHistUnidadesDiretorPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The histUnidadesDiretor with id " + id + " no longer exists.", enfe);
            }
            Pessoa pessoa = histUnidadesDiretor.getPessoa();
            if (pessoa != null) {
                pessoa.getHistUnidadesDiretorCollection().remove(histUnidadesDiretor);
                pessoa = em.merge(pessoa);
            }
            PessoaOperadores pessoaOperadores = histUnidadesDiretor.getPessoaOperadores();
            if (pessoaOperadores != null) {
                pessoaOperadores.getHistUnidadesDiretorCollection().remove(histUnidadesDiretor);
                pessoaOperadores = em.merge(pessoaOperadores);
            }
            PessoaOperadores idOperadorCancelamentoFk = histUnidadesDiretor.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getHistUnidadesDiretorCollection().remove(histUnidadesDiretor);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            Unidades unidades = histUnidadesDiretor.getUnidades();
            if (unidades != null) {
                unidades.getHistUnidadesDiretorCollection().remove(histUnidadesDiretor);
                unidades = em.merge(unidades);
            }
            em.remove(histUnidadesDiretor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistUnidadesDiretor> findHistUnidadesDiretorEntities() {
        return findHistUnidadesDiretorEntities(true, -1, -1);
    }

    public List<HistUnidadesDiretor> findHistUnidadesDiretorEntities(int maxResults, int firstResult) {
        return findHistUnidadesDiretorEntities(false, maxResults, firstResult);
    }

    private List<HistUnidadesDiretor> findHistUnidadesDiretorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistUnidadesDiretor.class));
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

    public HistUnidadesDiretor findHistUnidadesDiretor(HistUnidadesDiretorPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistUnidadesDiretor.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistUnidadesDiretorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistUnidadesDiretor> rt = cq.from(HistUnidadesDiretor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
