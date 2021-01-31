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
import br.com.folha.model.tabelas.Bancos;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaBancos;
import br.com.folha.model.tabelas.PessoaOperadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaBancosJpaController implements Serializable {

    public PessoaBancosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaBancos pessoaBancos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bancos idBancoFk = pessoaBancos.getIdBancoFk();
            if (idBancoFk != null) {
                idBancoFk = em.getReference(idBancoFk.getClass(), idBancoFk.getId());
                pessoaBancos.setIdBancoFk(idBancoFk);
            }
            Pessoa idPessoaFk = pessoaBancos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaBancos.setIdPessoaFk(idPessoaFk);
            }
            PessoaOperadores idOperadorCadastroFk = pessoaBancos.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk = em.getReference(idOperadorCadastroFk.getClass(), idOperadorCadastroFk.getId());
                pessoaBancos.setIdOperadorCadastroFk(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = pessoaBancos.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk = em.getReference(idOperadorCancelamentoFk.getClass(), idOperadorCancelamentoFk.getId());
                pessoaBancos.setIdOperadorCancelamentoFk(idOperadorCancelamentoFk);
            }
            em.persist(pessoaBancos);
            if (idBancoFk != null) {
                idBancoFk.getPessoaBancosCollection().add(pessoaBancos);
                idBancoFk = em.merge(idBancoFk);
            }
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaBancosCollection().add(pessoaBancos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getPessoaBancosCollection().add(pessoaBancos);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getPessoaBancosCollection().add(pessoaBancos);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaBancos pessoaBancos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaBancos persistentPessoaBancos = em.find(PessoaBancos.class, pessoaBancos.getId());
            Bancos idBancoFkOld = persistentPessoaBancos.getIdBancoFk();
            Bancos idBancoFkNew = pessoaBancos.getIdBancoFk();
            Pessoa idPessoaFkOld = persistentPessoaBancos.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaBancos.getIdPessoaFk();
            PessoaOperadores idOperadorCadastroFkOld = persistentPessoaBancos.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCadastroFkNew = pessoaBancos.getIdOperadorCadastroFk();
            PessoaOperadores idOperadorCancelamentoFkOld = persistentPessoaBancos.getIdOperadorCancelamentoFk();
            PessoaOperadores idOperadorCancelamentoFkNew = pessoaBancos.getIdOperadorCancelamentoFk();
            if (idBancoFkNew != null) {
                idBancoFkNew = em.getReference(idBancoFkNew.getClass(), idBancoFkNew.getId());
                pessoaBancos.setIdBancoFk(idBancoFkNew);
            }
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaBancos.setIdPessoaFk(idPessoaFkNew);
            }
            if (idOperadorCadastroFkNew != null) {
                idOperadorCadastroFkNew = em.getReference(idOperadorCadastroFkNew.getClass(), idOperadorCadastroFkNew.getId());
                pessoaBancos.setIdOperadorCadastroFk(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkNew != null) {
                idOperadorCancelamentoFkNew = em.getReference(idOperadorCancelamentoFkNew.getClass(), idOperadorCancelamentoFkNew.getId());
                pessoaBancos.setIdOperadorCancelamentoFk(idOperadorCancelamentoFkNew);
            }
            pessoaBancos = em.merge(pessoaBancos);
            if (idBancoFkOld != null && !idBancoFkOld.equals(idBancoFkNew)) {
                idBancoFkOld.getPessoaBancosCollection().remove(pessoaBancos);
                idBancoFkOld = em.merge(idBancoFkOld);
            }
            if (idBancoFkNew != null && !idBancoFkNew.equals(idBancoFkOld)) {
                idBancoFkNew.getPessoaBancosCollection().add(pessoaBancos);
                idBancoFkNew = em.merge(idBancoFkNew);
            }
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaBancosCollection().remove(pessoaBancos);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaBancosCollection().add(pessoaBancos);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            if (idOperadorCadastroFkOld != null && !idOperadorCadastroFkOld.equals(idOperadorCadastroFkNew)) {
                idOperadorCadastroFkOld.getPessoaBancosCollection().remove(pessoaBancos);
                idOperadorCadastroFkOld = em.merge(idOperadorCadastroFkOld);
            }
            if (idOperadorCadastroFkNew != null && !idOperadorCadastroFkNew.equals(idOperadorCadastroFkOld)) {
                idOperadorCadastroFkNew.getPessoaBancosCollection().add(pessoaBancos);
                idOperadorCadastroFkNew = em.merge(idOperadorCadastroFkNew);
            }
            if (idOperadorCancelamentoFkOld != null && !idOperadorCancelamentoFkOld.equals(idOperadorCancelamentoFkNew)) {
                idOperadorCancelamentoFkOld.getPessoaBancosCollection().remove(pessoaBancos);
                idOperadorCancelamentoFkOld = em.merge(idOperadorCancelamentoFkOld);
            }
            if (idOperadorCancelamentoFkNew != null && !idOperadorCancelamentoFkNew.equals(idOperadorCancelamentoFkOld)) {
                idOperadorCancelamentoFkNew.getPessoaBancosCollection().add(pessoaBancos);
                idOperadorCancelamentoFkNew = em.merge(idOperadorCancelamentoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaBancos.getId();
                if (findPessoaBancos(id) == null) {
                    throw new NonexistentEntityException("The pessoaBancos with id " + id + " no longer exists.");
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
            PessoaBancos pessoaBancos;
            try {
                pessoaBancos = em.getReference(PessoaBancos.class, id);
                pessoaBancos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaBancos with id " + id + " no longer exists.", enfe);
            }
            Bancos idBancoFk = pessoaBancos.getIdBancoFk();
            if (idBancoFk != null) {
                idBancoFk.getPessoaBancosCollection().remove(pessoaBancos);
                idBancoFk = em.merge(idBancoFk);
            }
            Pessoa idPessoaFk = pessoaBancos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaBancosCollection().remove(pessoaBancos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            PessoaOperadores idOperadorCadastroFk = pessoaBancos.getIdOperadorCadastroFk();
            if (idOperadorCadastroFk != null) {
                idOperadorCadastroFk.getPessoaBancosCollection().remove(pessoaBancos);
                idOperadorCadastroFk = em.merge(idOperadorCadastroFk);
            }
            PessoaOperadores idOperadorCancelamentoFk = pessoaBancos.getIdOperadorCancelamentoFk();
            if (idOperadorCancelamentoFk != null) {
                idOperadorCancelamentoFk.getPessoaBancosCollection().remove(pessoaBancos);
                idOperadorCancelamentoFk = em.merge(idOperadorCancelamentoFk);
            }
            em.remove(pessoaBancos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaBancos> findPessoaBancosEntities() {
        return findPessoaBancosEntities(true, -1, -1);
    }

    public List<PessoaBancos> findPessoaBancosEntities(int maxResults, int firstResult) {
        return findPessoaBancosEntities(false, maxResults, firstResult);
    }

    private List<PessoaBancos> findPessoaBancosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaBancos.class));
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

    public PessoaBancos findPessoaBancos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaBancos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaBancosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaBancos> rt = cq.from(PessoaBancos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
