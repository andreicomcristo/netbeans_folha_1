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
import br.com.folha.model.tabelas.Cidades;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaDocumentosTitulo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaDocumentosTituloJpaController implements Serializable {

    public PessoaDocumentosTituloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cidades idCidadeFk = pessoaDocumentosTitulo.getIdCidadeFk();
            if (idCidadeFk != null) {
                idCidadeFk = em.getReference(idCidadeFk.getClass(), idCidadeFk.getId());
                pessoaDocumentosTitulo.setIdCidadeFk(idCidadeFk);
            }
            Pessoa idPessoaFk = pessoaDocumentosTitulo.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                pessoaDocumentosTitulo.setIdPessoaFk(idPessoaFk);
            }
            em.persist(pessoaDocumentosTitulo);
            if (idCidadeFk != null) {
                idCidadeFk.getPessoaDocumentosTituloCollection().add(pessoaDocumentosTitulo);
                idCidadeFk = em.merge(idCidadeFk);
            }
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosTituloCollection().add(pessoaDocumentosTitulo);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaDocumentosTitulo pessoaDocumentosTitulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaDocumentosTitulo persistentPessoaDocumentosTitulo = em.find(PessoaDocumentosTitulo.class, pessoaDocumentosTitulo.getId());
            Cidades idCidadeFkOld = persistentPessoaDocumentosTitulo.getIdCidadeFk();
            Cidades idCidadeFkNew = pessoaDocumentosTitulo.getIdCidadeFk();
            Pessoa idPessoaFkOld = persistentPessoaDocumentosTitulo.getIdPessoaFk();
            Pessoa idPessoaFkNew = pessoaDocumentosTitulo.getIdPessoaFk();
            if (idCidadeFkNew != null) {
                idCidadeFkNew = em.getReference(idCidadeFkNew.getClass(), idCidadeFkNew.getId());
                pessoaDocumentosTitulo.setIdCidadeFk(idCidadeFkNew);
            }
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                pessoaDocumentosTitulo.setIdPessoaFk(idPessoaFkNew);
            }
            pessoaDocumentosTitulo = em.merge(pessoaDocumentosTitulo);
            if (idCidadeFkOld != null && !idCidadeFkOld.equals(idCidadeFkNew)) {
                idCidadeFkOld.getPessoaDocumentosTituloCollection().remove(pessoaDocumentosTitulo);
                idCidadeFkOld = em.merge(idCidadeFkOld);
            }
            if (idCidadeFkNew != null && !idCidadeFkNew.equals(idCidadeFkOld)) {
                idCidadeFkNew.getPessoaDocumentosTituloCollection().add(pessoaDocumentosTitulo);
                idCidadeFkNew = em.merge(idCidadeFkNew);
            }
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getPessoaDocumentosTituloCollection().remove(pessoaDocumentosTitulo);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getPessoaDocumentosTituloCollection().add(pessoaDocumentosTitulo);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaDocumentosTitulo.getId();
                if (findPessoaDocumentosTitulo(id) == null) {
                    throw new NonexistentEntityException("The pessoaDocumentosTitulo with id " + id + " no longer exists.");
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
            PessoaDocumentosTitulo pessoaDocumentosTitulo;
            try {
                pessoaDocumentosTitulo = em.getReference(PessoaDocumentosTitulo.class, id);
                pessoaDocumentosTitulo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaDocumentosTitulo with id " + id + " no longer exists.", enfe);
            }
            Cidades idCidadeFk = pessoaDocumentosTitulo.getIdCidadeFk();
            if (idCidadeFk != null) {
                idCidadeFk.getPessoaDocumentosTituloCollection().remove(pessoaDocumentosTitulo);
                idCidadeFk = em.merge(idCidadeFk);
            }
            Pessoa idPessoaFk = pessoaDocumentosTitulo.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getPessoaDocumentosTituloCollection().remove(pessoaDocumentosTitulo);
                idPessoaFk = em.merge(idPessoaFk);
            }
            em.remove(pessoaDocumentosTitulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaDocumentosTitulo> findPessoaDocumentosTituloEntities() {
        return findPessoaDocumentosTituloEntities(true, -1, -1);
    }

    public List<PessoaDocumentosTitulo> findPessoaDocumentosTituloEntities(int maxResults, int firstResult) {
        return findPessoaDocumentosTituloEntities(false, maxResults, firstResult);
    }

    private List<PessoaDocumentosTitulo> findPessoaDocumentosTituloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaDocumentosTitulo.class));
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

    public PessoaDocumentosTitulo findPessoaDocumentosTitulo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaDocumentosTitulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaDocumentosTituloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaDocumentosTitulo> rt = cq.from(PessoaDocumentosTitulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
