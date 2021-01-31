/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import br.com.folha.model.tabelas.Cidades;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.Paises;
import br.com.folha.model.tabelas.Uf;
import br.com.folha.model.tabelas.Enderecos;
import java.util.ArrayList;
import java.util.Collection;
import br.com.folha.model.tabelas.Unidades;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaDocumentosTitulo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class CidadesJpaController implements Serializable {

    public CidadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cidades cidades) {
        if (cidades.getEnderecosCollection() == null) {
            cidades.setEnderecosCollection(new ArrayList<Enderecos>());
        }
        if (cidades.getUnidadesCollection() == null) {
            cidades.setUnidadesCollection(new ArrayList<Unidades>());
        }
        if (cidades.getPessoaCollection() == null) {
            cidades.setPessoaCollection(new ArrayList<Pessoa>());
        }
        if (cidades.getPessoaDocumentosTituloCollection() == null) {
            cidades.setPessoaDocumentosTituloCollection(new ArrayList<PessoaDocumentosTitulo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paises idPaisFk = cidades.getIdPaisFk();
            if (idPaisFk != null) {
                idPaisFk = em.getReference(idPaisFk.getClass(), idPaisFk.getId());
                cidades.setIdPaisFk(idPaisFk);
            }
            Uf idUfFk = cidades.getIdUfFk();
            if (idUfFk != null) {
                idUfFk = em.getReference(idUfFk.getClass(), idUfFk.getId());
                cidades.setIdUfFk(idUfFk);
            }
            Collection<Enderecos> attachedEnderecosCollection = new ArrayList<Enderecos>();
            for (Enderecos enderecosCollectionEnderecosToAttach : cidades.getEnderecosCollection()) {
                enderecosCollectionEnderecosToAttach = em.getReference(enderecosCollectionEnderecosToAttach.getClass(), enderecosCollectionEnderecosToAttach.getId());
                attachedEnderecosCollection.add(enderecosCollectionEnderecosToAttach);
            }
            cidades.setEnderecosCollection(attachedEnderecosCollection);
            Collection<Unidades> attachedUnidadesCollection = new ArrayList<Unidades>();
            for (Unidades unidadesCollectionUnidadesToAttach : cidades.getUnidadesCollection()) {
                unidadesCollectionUnidadesToAttach = em.getReference(unidadesCollectionUnidadesToAttach.getClass(), unidadesCollectionUnidadesToAttach.getId());
                attachedUnidadesCollection.add(unidadesCollectionUnidadesToAttach);
            }
            cidades.setUnidadesCollection(attachedUnidadesCollection);
            Collection<Pessoa> attachedPessoaCollection = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionPessoaToAttach : cidades.getPessoaCollection()) {
                pessoaCollectionPessoaToAttach = em.getReference(pessoaCollectionPessoaToAttach.getClass(), pessoaCollectionPessoaToAttach.getId());
                attachedPessoaCollection.add(pessoaCollectionPessoaToAttach);
            }
            cidades.setPessoaCollection(attachedPessoaCollection);
            Collection<PessoaDocumentosTitulo> attachedPessoaDocumentosTituloCollection = new ArrayList<PessoaDocumentosTitulo>();
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach : cidades.getPessoaDocumentosTituloCollection()) {
                pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach = em.getReference(pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach.getClass(), pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach.getId());
                attachedPessoaDocumentosTituloCollection.add(pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach);
            }
            cidades.setPessoaDocumentosTituloCollection(attachedPessoaDocumentosTituloCollection);
            em.persist(cidades);
            if (idPaisFk != null) {
                idPaisFk.getCidadesCollection().add(cidades);
                idPaisFk = em.merge(idPaisFk);
            }
            if (idUfFk != null) {
                idUfFk.getCidadesCollection().add(cidades);
                idUfFk = em.merge(idUfFk);
            }
            for (Enderecos enderecosCollectionEnderecos : cidades.getEnderecosCollection()) {
                Cidades oldIdEnderecoCidadeFkOfEnderecosCollectionEnderecos = enderecosCollectionEnderecos.getIdEnderecoCidadeFk();
                enderecosCollectionEnderecos.setIdEnderecoCidadeFk(cidades);
                enderecosCollectionEnderecos = em.merge(enderecosCollectionEnderecos);
                if (oldIdEnderecoCidadeFkOfEnderecosCollectionEnderecos != null) {
                    oldIdEnderecoCidadeFkOfEnderecosCollectionEnderecos.getEnderecosCollection().remove(enderecosCollectionEnderecos);
                    oldIdEnderecoCidadeFkOfEnderecosCollectionEnderecos = em.merge(oldIdEnderecoCidadeFkOfEnderecosCollectionEnderecos);
                }
            }
            for (Unidades unidadesCollectionUnidades : cidades.getUnidadesCollection()) {
                Cidades oldIdEnderecoCidadeFkOfUnidadesCollectionUnidades = unidadesCollectionUnidades.getIdEnderecoCidadeFk();
                unidadesCollectionUnidades.setIdEnderecoCidadeFk(cidades);
                unidadesCollectionUnidades = em.merge(unidadesCollectionUnidades);
                if (oldIdEnderecoCidadeFkOfUnidadesCollectionUnidades != null) {
                    oldIdEnderecoCidadeFkOfUnidadesCollectionUnidades.getUnidadesCollection().remove(unidadesCollectionUnidades);
                    oldIdEnderecoCidadeFkOfUnidadesCollectionUnidades = em.merge(oldIdEnderecoCidadeFkOfUnidadesCollectionUnidades);
                }
            }
            for (Pessoa pessoaCollectionPessoa : cidades.getPessoaCollection()) {
                Cidades oldSeqCidadeNatalOfPessoaCollectionPessoa = pessoaCollectionPessoa.getSeqCidadeNatal();
                pessoaCollectionPessoa.setSeqCidadeNatal(cidades);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
                if (oldSeqCidadeNatalOfPessoaCollectionPessoa != null) {
                    oldSeqCidadeNatalOfPessoaCollectionPessoa.getPessoaCollection().remove(pessoaCollectionPessoa);
                    oldSeqCidadeNatalOfPessoaCollectionPessoa = em.merge(oldSeqCidadeNatalOfPessoaCollectionPessoa);
                }
            }
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionPessoaDocumentosTitulo : cidades.getPessoaDocumentosTituloCollection()) {
                Cidades oldIdCidadeFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo = pessoaDocumentosTituloCollectionPessoaDocumentosTitulo.getIdCidadeFk();
                pessoaDocumentosTituloCollectionPessoaDocumentosTitulo.setIdCidadeFk(cidades);
                pessoaDocumentosTituloCollectionPessoaDocumentosTitulo = em.merge(pessoaDocumentosTituloCollectionPessoaDocumentosTitulo);
                if (oldIdCidadeFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo != null) {
                    oldIdCidadeFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo.getPessoaDocumentosTituloCollection().remove(pessoaDocumentosTituloCollectionPessoaDocumentosTitulo);
                    oldIdCidadeFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo = em.merge(oldIdCidadeFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cidades cidades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cidades persistentCidades = em.find(Cidades.class, cidades.getId());
            Paises idPaisFkOld = persistentCidades.getIdPaisFk();
            Paises idPaisFkNew = cidades.getIdPaisFk();
            Uf idUfFkOld = persistentCidades.getIdUfFk();
            Uf idUfFkNew = cidades.getIdUfFk();
            Collection<Enderecos> enderecosCollectionOld = persistentCidades.getEnderecosCollection();
            Collection<Enderecos> enderecosCollectionNew = cidades.getEnderecosCollection();
            Collection<Unidades> unidadesCollectionOld = persistentCidades.getUnidadesCollection();
            Collection<Unidades> unidadesCollectionNew = cidades.getUnidadesCollection();
            Collection<Pessoa> pessoaCollectionOld = persistentCidades.getPessoaCollection();
            Collection<Pessoa> pessoaCollectionNew = cidades.getPessoaCollection();
            Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollectionOld = persistentCidades.getPessoaDocumentosTituloCollection();
            Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollectionNew = cidades.getPessoaDocumentosTituloCollection();
            if (idPaisFkNew != null) {
                idPaisFkNew = em.getReference(idPaisFkNew.getClass(), idPaisFkNew.getId());
                cidades.setIdPaisFk(idPaisFkNew);
            }
            if (idUfFkNew != null) {
                idUfFkNew = em.getReference(idUfFkNew.getClass(), idUfFkNew.getId());
                cidades.setIdUfFk(idUfFkNew);
            }
            Collection<Enderecos> attachedEnderecosCollectionNew = new ArrayList<Enderecos>();
            for (Enderecos enderecosCollectionNewEnderecosToAttach : enderecosCollectionNew) {
                enderecosCollectionNewEnderecosToAttach = em.getReference(enderecosCollectionNewEnderecosToAttach.getClass(), enderecosCollectionNewEnderecosToAttach.getId());
                attachedEnderecosCollectionNew.add(enderecosCollectionNewEnderecosToAttach);
            }
            enderecosCollectionNew = attachedEnderecosCollectionNew;
            cidades.setEnderecosCollection(enderecosCollectionNew);
            Collection<Unidades> attachedUnidadesCollectionNew = new ArrayList<Unidades>();
            for (Unidades unidadesCollectionNewUnidadesToAttach : unidadesCollectionNew) {
                unidadesCollectionNewUnidadesToAttach = em.getReference(unidadesCollectionNewUnidadesToAttach.getClass(), unidadesCollectionNewUnidadesToAttach.getId());
                attachedUnidadesCollectionNew.add(unidadesCollectionNewUnidadesToAttach);
            }
            unidadesCollectionNew = attachedUnidadesCollectionNew;
            cidades.setUnidadesCollection(unidadesCollectionNew);
            Collection<Pessoa> attachedPessoaCollectionNew = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionNewPessoaToAttach : pessoaCollectionNew) {
                pessoaCollectionNewPessoaToAttach = em.getReference(pessoaCollectionNewPessoaToAttach.getClass(), pessoaCollectionNewPessoaToAttach.getId());
                attachedPessoaCollectionNew.add(pessoaCollectionNewPessoaToAttach);
            }
            pessoaCollectionNew = attachedPessoaCollectionNew;
            cidades.setPessoaCollection(pessoaCollectionNew);
            Collection<PessoaDocumentosTitulo> attachedPessoaDocumentosTituloCollectionNew = new ArrayList<PessoaDocumentosTitulo>();
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach : pessoaDocumentosTituloCollectionNew) {
                pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach = em.getReference(pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach.getClass(), pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach.getId());
                attachedPessoaDocumentosTituloCollectionNew.add(pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach);
            }
            pessoaDocumentosTituloCollectionNew = attachedPessoaDocumentosTituloCollectionNew;
            cidades.setPessoaDocumentosTituloCollection(pessoaDocumentosTituloCollectionNew);
            cidades = em.merge(cidades);
            if (idPaisFkOld != null && !idPaisFkOld.equals(idPaisFkNew)) {
                idPaisFkOld.getCidadesCollection().remove(cidades);
                idPaisFkOld = em.merge(idPaisFkOld);
            }
            if (idPaisFkNew != null && !idPaisFkNew.equals(idPaisFkOld)) {
                idPaisFkNew.getCidadesCollection().add(cidades);
                idPaisFkNew = em.merge(idPaisFkNew);
            }
            if (idUfFkOld != null && !idUfFkOld.equals(idUfFkNew)) {
                idUfFkOld.getCidadesCollection().remove(cidades);
                idUfFkOld = em.merge(idUfFkOld);
            }
            if (idUfFkNew != null && !idUfFkNew.equals(idUfFkOld)) {
                idUfFkNew.getCidadesCollection().add(cidades);
                idUfFkNew = em.merge(idUfFkNew);
            }
            for (Enderecos enderecosCollectionOldEnderecos : enderecosCollectionOld) {
                if (!enderecosCollectionNew.contains(enderecosCollectionOldEnderecos)) {
                    enderecosCollectionOldEnderecos.setIdEnderecoCidadeFk(null);
                    enderecosCollectionOldEnderecos = em.merge(enderecosCollectionOldEnderecos);
                }
            }
            for (Enderecos enderecosCollectionNewEnderecos : enderecosCollectionNew) {
                if (!enderecosCollectionOld.contains(enderecosCollectionNewEnderecos)) {
                    Cidades oldIdEnderecoCidadeFkOfEnderecosCollectionNewEnderecos = enderecosCollectionNewEnderecos.getIdEnderecoCidadeFk();
                    enderecosCollectionNewEnderecos.setIdEnderecoCidadeFk(cidades);
                    enderecosCollectionNewEnderecos = em.merge(enderecosCollectionNewEnderecos);
                    if (oldIdEnderecoCidadeFkOfEnderecosCollectionNewEnderecos != null && !oldIdEnderecoCidadeFkOfEnderecosCollectionNewEnderecos.equals(cidades)) {
                        oldIdEnderecoCidadeFkOfEnderecosCollectionNewEnderecos.getEnderecosCollection().remove(enderecosCollectionNewEnderecos);
                        oldIdEnderecoCidadeFkOfEnderecosCollectionNewEnderecos = em.merge(oldIdEnderecoCidadeFkOfEnderecosCollectionNewEnderecos);
                    }
                }
            }
            for (Unidades unidadesCollectionOldUnidades : unidadesCollectionOld) {
                if (!unidadesCollectionNew.contains(unidadesCollectionOldUnidades)) {
                    unidadesCollectionOldUnidades.setIdEnderecoCidadeFk(null);
                    unidadesCollectionOldUnidades = em.merge(unidadesCollectionOldUnidades);
                }
            }
            for (Unidades unidadesCollectionNewUnidades : unidadesCollectionNew) {
                if (!unidadesCollectionOld.contains(unidadesCollectionNewUnidades)) {
                    Cidades oldIdEnderecoCidadeFkOfUnidadesCollectionNewUnidades = unidadesCollectionNewUnidades.getIdEnderecoCidadeFk();
                    unidadesCollectionNewUnidades.setIdEnderecoCidadeFk(cidades);
                    unidadesCollectionNewUnidades = em.merge(unidadesCollectionNewUnidades);
                    if (oldIdEnderecoCidadeFkOfUnidadesCollectionNewUnidades != null && !oldIdEnderecoCidadeFkOfUnidadesCollectionNewUnidades.equals(cidades)) {
                        oldIdEnderecoCidadeFkOfUnidadesCollectionNewUnidades.getUnidadesCollection().remove(unidadesCollectionNewUnidades);
                        oldIdEnderecoCidadeFkOfUnidadesCollectionNewUnidades = em.merge(oldIdEnderecoCidadeFkOfUnidadesCollectionNewUnidades);
                    }
                }
            }
            for (Pessoa pessoaCollectionOldPessoa : pessoaCollectionOld) {
                if (!pessoaCollectionNew.contains(pessoaCollectionOldPessoa)) {
                    pessoaCollectionOldPessoa.setSeqCidadeNatal(null);
                    pessoaCollectionOldPessoa = em.merge(pessoaCollectionOldPessoa);
                }
            }
            for (Pessoa pessoaCollectionNewPessoa : pessoaCollectionNew) {
                if (!pessoaCollectionOld.contains(pessoaCollectionNewPessoa)) {
                    Cidades oldSeqCidadeNatalOfPessoaCollectionNewPessoa = pessoaCollectionNewPessoa.getSeqCidadeNatal();
                    pessoaCollectionNewPessoa.setSeqCidadeNatal(cidades);
                    pessoaCollectionNewPessoa = em.merge(pessoaCollectionNewPessoa);
                    if (oldSeqCidadeNatalOfPessoaCollectionNewPessoa != null && !oldSeqCidadeNatalOfPessoaCollectionNewPessoa.equals(cidades)) {
                        oldSeqCidadeNatalOfPessoaCollectionNewPessoa.getPessoaCollection().remove(pessoaCollectionNewPessoa);
                        oldSeqCidadeNatalOfPessoaCollectionNewPessoa = em.merge(oldSeqCidadeNatalOfPessoaCollectionNewPessoa);
                    }
                }
            }
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionOldPessoaDocumentosTitulo : pessoaDocumentosTituloCollectionOld) {
                if (!pessoaDocumentosTituloCollectionNew.contains(pessoaDocumentosTituloCollectionOldPessoaDocumentosTitulo)) {
                    pessoaDocumentosTituloCollectionOldPessoaDocumentosTitulo.setIdCidadeFk(null);
                    pessoaDocumentosTituloCollectionOldPessoaDocumentosTitulo = em.merge(pessoaDocumentosTituloCollectionOldPessoaDocumentosTitulo);
                }
            }
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo : pessoaDocumentosTituloCollectionNew) {
                if (!pessoaDocumentosTituloCollectionOld.contains(pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo)) {
                    Cidades oldIdCidadeFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo = pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo.getIdCidadeFk();
                    pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo.setIdCidadeFk(cidades);
                    pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo = em.merge(pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo);
                    if (oldIdCidadeFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo != null && !oldIdCidadeFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo.equals(cidades)) {
                        oldIdCidadeFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo.getPessoaDocumentosTituloCollection().remove(pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo);
                        oldIdCidadeFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo = em.merge(oldIdCidadeFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cidades.getId();
                if (findCidades(id) == null) {
                    throw new NonexistentEntityException("The cidades with id " + id + " no longer exists.");
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
            Cidades cidades;
            try {
                cidades = em.getReference(Cidades.class, id);
                cidades.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cidades with id " + id + " no longer exists.", enfe);
            }
            Paises idPaisFk = cidades.getIdPaisFk();
            if (idPaisFk != null) {
                idPaisFk.getCidadesCollection().remove(cidades);
                idPaisFk = em.merge(idPaisFk);
            }
            Uf idUfFk = cidades.getIdUfFk();
            if (idUfFk != null) {
                idUfFk.getCidadesCollection().remove(cidades);
                idUfFk = em.merge(idUfFk);
            }
            Collection<Enderecos> enderecosCollection = cidades.getEnderecosCollection();
            for (Enderecos enderecosCollectionEnderecos : enderecosCollection) {
                enderecosCollectionEnderecos.setIdEnderecoCidadeFk(null);
                enderecosCollectionEnderecos = em.merge(enderecosCollectionEnderecos);
            }
            Collection<Unidades> unidadesCollection = cidades.getUnidadesCollection();
            for (Unidades unidadesCollectionUnidades : unidadesCollection) {
                unidadesCollectionUnidades.setIdEnderecoCidadeFk(null);
                unidadesCollectionUnidades = em.merge(unidadesCollectionUnidades);
            }
            Collection<Pessoa> pessoaCollection = cidades.getPessoaCollection();
            for (Pessoa pessoaCollectionPessoa : pessoaCollection) {
                pessoaCollectionPessoa.setSeqCidadeNatal(null);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
            }
            Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection = cidades.getPessoaDocumentosTituloCollection();
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionPessoaDocumentosTitulo : pessoaDocumentosTituloCollection) {
                pessoaDocumentosTituloCollectionPessoaDocumentosTitulo.setIdCidadeFk(null);
                pessoaDocumentosTituloCollectionPessoaDocumentosTitulo = em.merge(pessoaDocumentosTituloCollectionPessoaDocumentosTitulo);
            }
            em.remove(cidades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cidades> findCidadesEntities() {
        return findCidadesEntities(true, -1, -1);
    }

    public List<Cidades> findCidadesEntities(int maxResults, int firstResult) {
        return findCidadesEntities(false, maxResults, firstResult);
    }

    private List<Cidades> findCidadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cidades.class));
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

    public Cidades findCidades(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cidades.class, id);
        } finally {
            em.close();
        }
    }

    public int getCidadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cidades> rt = cq.from(Cidades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
