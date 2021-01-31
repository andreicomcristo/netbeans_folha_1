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
import br.com.folha.model.tabelas.Enderecos;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.TiposLogradouro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class EnderecosJpaController implements Serializable {

    public EnderecosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Enderecos enderecos) {
        if (enderecos.getPessoaCollection() == null) {
            enderecos.setPessoaCollection(new ArrayList<Pessoa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cidades idEnderecoCidadeFk = enderecos.getIdEnderecoCidadeFk();
            if (idEnderecoCidadeFk != null) {
                idEnderecoCidadeFk = em.getReference(idEnderecoCidadeFk.getClass(), idEnderecoCidadeFk.getId());
                enderecos.setIdEnderecoCidadeFk(idEnderecoCidadeFk);
            }
            Pessoa idPessoaFk = enderecos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk = em.getReference(idPessoaFk.getClass(), idPessoaFk.getId());
                enderecos.setIdPessoaFk(idPessoaFk);
            }
            TiposLogradouro idTipoLogradouroFk = enderecos.getIdTipoLogradouroFk();
            if (idTipoLogradouroFk != null) {
                idTipoLogradouroFk = em.getReference(idTipoLogradouroFk.getClass(), idTipoLogradouroFk.getId());
                enderecos.setIdTipoLogradouroFk(idTipoLogradouroFk);
            }
            Collection<Pessoa> attachedPessoaCollection = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionPessoaToAttach : enderecos.getPessoaCollection()) {
                pessoaCollectionPessoaToAttach = em.getReference(pessoaCollectionPessoaToAttach.getClass(), pessoaCollectionPessoaToAttach.getId());
                attachedPessoaCollection.add(pessoaCollectionPessoaToAttach);
            }
            enderecos.setPessoaCollection(attachedPessoaCollection);
            em.persist(enderecos);
            if (idEnderecoCidadeFk != null) {
                idEnderecoCidadeFk.getEnderecosCollection().add(enderecos);
                idEnderecoCidadeFk = em.merge(idEnderecoCidadeFk);
            }
            if (idPessoaFk != null) {
                idPessoaFk.getEnderecosCollection().add(enderecos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            if (idTipoLogradouroFk != null) {
                idTipoLogradouroFk.getEnderecosCollection().add(enderecos);
                idTipoLogradouroFk = em.merge(idTipoLogradouroFk);
            }
            for (Pessoa pessoaCollectionPessoa : enderecos.getPessoaCollection()) {
                Enderecos oldSeqEnderecoOfPessoaCollectionPessoa = pessoaCollectionPessoa.getSeqEndereco();
                pessoaCollectionPessoa.setSeqEndereco(enderecos);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
                if (oldSeqEnderecoOfPessoaCollectionPessoa != null) {
                    oldSeqEnderecoOfPessoaCollectionPessoa.getPessoaCollection().remove(pessoaCollectionPessoa);
                    oldSeqEnderecoOfPessoaCollectionPessoa = em.merge(oldSeqEnderecoOfPessoaCollectionPessoa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Enderecos enderecos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Enderecos persistentEnderecos = em.find(Enderecos.class, enderecos.getId());
            Cidades idEnderecoCidadeFkOld = persistentEnderecos.getIdEnderecoCidadeFk();
            Cidades idEnderecoCidadeFkNew = enderecos.getIdEnderecoCidadeFk();
            Pessoa idPessoaFkOld = persistentEnderecos.getIdPessoaFk();
            Pessoa idPessoaFkNew = enderecos.getIdPessoaFk();
            TiposLogradouro idTipoLogradouroFkOld = persistentEnderecos.getIdTipoLogradouroFk();
            TiposLogradouro idTipoLogradouroFkNew = enderecos.getIdTipoLogradouroFk();
            Collection<Pessoa> pessoaCollectionOld = persistentEnderecos.getPessoaCollection();
            Collection<Pessoa> pessoaCollectionNew = enderecos.getPessoaCollection();
            if (idEnderecoCidadeFkNew != null) {
                idEnderecoCidadeFkNew = em.getReference(idEnderecoCidadeFkNew.getClass(), idEnderecoCidadeFkNew.getId());
                enderecos.setIdEnderecoCidadeFk(idEnderecoCidadeFkNew);
            }
            if (idPessoaFkNew != null) {
                idPessoaFkNew = em.getReference(idPessoaFkNew.getClass(), idPessoaFkNew.getId());
                enderecos.setIdPessoaFk(idPessoaFkNew);
            }
            if (idTipoLogradouroFkNew != null) {
                idTipoLogradouroFkNew = em.getReference(idTipoLogradouroFkNew.getClass(), idTipoLogradouroFkNew.getId());
                enderecos.setIdTipoLogradouroFk(idTipoLogradouroFkNew);
            }
            Collection<Pessoa> attachedPessoaCollectionNew = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionNewPessoaToAttach : pessoaCollectionNew) {
                pessoaCollectionNewPessoaToAttach = em.getReference(pessoaCollectionNewPessoaToAttach.getClass(), pessoaCollectionNewPessoaToAttach.getId());
                attachedPessoaCollectionNew.add(pessoaCollectionNewPessoaToAttach);
            }
            pessoaCollectionNew = attachedPessoaCollectionNew;
            enderecos.setPessoaCollection(pessoaCollectionNew);
            enderecos = em.merge(enderecos);
            if (idEnderecoCidadeFkOld != null && !idEnderecoCidadeFkOld.equals(idEnderecoCidadeFkNew)) {
                idEnderecoCidadeFkOld.getEnderecosCollection().remove(enderecos);
                idEnderecoCidadeFkOld = em.merge(idEnderecoCidadeFkOld);
            }
            if (idEnderecoCidadeFkNew != null && !idEnderecoCidadeFkNew.equals(idEnderecoCidadeFkOld)) {
                idEnderecoCidadeFkNew.getEnderecosCollection().add(enderecos);
                idEnderecoCidadeFkNew = em.merge(idEnderecoCidadeFkNew);
            }
            if (idPessoaFkOld != null && !idPessoaFkOld.equals(idPessoaFkNew)) {
                idPessoaFkOld.getEnderecosCollection().remove(enderecos);
                idPessoaFkOld = em.merge(idPessoaFkOld);
            }
            if (idPessoaFkNew != null && !idPessoaFkNew.equals(idPessoaFkOld)) {
                idPessoaFkNew.getEnderecosCollection().add(enderecos);
                idPessoaFkNew = em.merge(idPessoaFkNew);
            }
            if (idTipoLogradouroFkOld != null && !idTipoLogradouroFkOld.equals(idTipoLogradouroFkNew)) {
                idTipoLogradouroFkOld.getEnderecosCollection().remove(enderecos);
                idTipoLogradouroFkOld = em.merge(idTipoLogradouroFkOld);
            }
            if (idTipoLogradouroFkNew != null && !idTipoLogradouroFkNew.equals(idTipoLogradouroFkOld)) {
                idTipoLogradouroFkNew.getEnderecosCollection().add(enderecos);
                idTipoLogradouroFkNew = em.merge(idTipoLogradouroFkNew);
            }
            for (Pessoa pessoaCollectionOldPessoa : pessoaCollectionOld) {
                if (!pessoaCollectionNew.contains(pessoaCollectionOldPessoa)) {
                    pessoaCollectionOldPessoa.setSeqEndereco(null);
                    pessoaCollectionOldPessoa = em.merge(pessoaCollectionOldPessoa);
                }
            }
            for (Pessoa pessoaCollectionNewPessoa : pessoaCollectionNew) {
                if (!pessoaCollectionOld.contains(pessoaCollectionNewPessoa)) {
                    Enderecos oldSeqEnderecoOfPessoaCollectionNewPessoa = pessoaCollectionNewPessoa.getSeqEndereco();
                    pessoaCollectionNewPessoa.setSeqEndereco(enderecos);
                    pessoaCollectionNewPessoa = em.merge(pessoaCollectionNewPessoa);
                    if (oldSeqEnderecoOfPessoaCollectionNewPessoa != null && !oldSeqEnderecoOfPessoaCollectionNewPessoa.equals(enderecos)) {
                        oldSeqEnderecoOfPessoaCollectionNewPessoa.getPessoaCollection().remove(pessoaCollectionNewPessoa);
                        oldSeqEnderecoOfPessoaCollectionNewPessoa = em.merge(oldSeqEnderecoOfPessoaCollectionNewPessoa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = enderecos.getId();
                if (findEnderecos(id) == null) {
                    throw new NonexistentEntityException("The enderecos with id " + id + " no longer exists.");
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
            Enderecos enderecos;
            try {
                enderecos = em.getReference(Enderecos.class, id);
                enderecos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The enderecos with id " + id + " no longer exists.", enfe);
            }
            Cidades idEnderecoCidadeFk = enderecos.getIdEnderecoCidadeFk();
            if (idEnderecoCidadeFk != null) {
                idEnderecoCidadeFk.getEnderecosCollection().remove(enderecos);
                idEnderecoCidadeFk = em.merge(idEnderecoCidadeFk);
            }
            Pessoa idPessoaFk = enderecos.getIdPessoaFk();
            if (idPessoaFk != null) {
                idPessoaFk.getEnderecosCollection().remove(enderecos);
                idPessoaFk = em.merge(idPessoaFk);
            }
            TiposLogradouro idTipoLogradouroFk = enderecos.getIdTipoLogradouroFk();
            if (idTipoLogradouroFk != null) {
                idTipoLogradouroFk.getEnderecosCollection().remove(enderecos);
                idTipoLogradouroFk = em.merge(idTipoLogradouroFk);
            }
            Collection<Pessoa> pessoaCollection = enderecos.getPessoaCollection();
            for (Pessoa pessoaCollectionPessoa : pessoaCollection) {
                pessoaCollectionPessoa.setSeqEndereco(null);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
            }
            em.remove(enderecos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Enderecos> findEnderecosEntities() {
        return findEnderecosEntities(true, -1, -1);
    }

    public List<Enderecos> findEnderecosEntities(int maxResults, int firstResult) {
        return findEnderecosEntities(false, maxResults, firstResult);
    }

    private List<Enderecos> findEnderecosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Enderecos.class));
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

    public Enderecos findEnderecos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Enderecos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnderecosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Enderecos> rt = cq.from(Enderecos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
