/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.folha.control.cadastro.parametros;

import br.com.folha.control.cadastro.parametros.exceptions.IllegalOrphanException;
import br.com.folha.control.cadastro.parametros.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.folha.model.tabelas.PessoaDocumentosConselho;
import java.util.ArrayList;
import java.util.Collection;
import br.com.folha.model.tabelas.Cidades;
import br.com.folha.model.tabelas.PessoaDocumentosRg;
import br.com.folha.model.tabelas.Uf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class UfJpaController implements Serializable {

    public UfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Uf uf) {
        if (uf.getPessoaDocumentosConselhoCollection() == null) {
            uf.setPessoaDocumentosConselhoCollection(new ArrayList<PessoaDocumentosConselho>());
        }
        if (uf.getCidadesCollection() == null) {
            uf.setCidadesCollection(new ArrayList<Cidades>());
        }
        if (uf.getPessoaDocumentosRgCollection() == null) {
            uf.setPessoaDocumentosRgCollection(new ArrayList<PessoaDocumentosRg>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<PessoaDocumentosConselho> attachedPessoaDocumentosConselhoCollection = new ArrayList<PessoaDocumentosConselho>();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach : uf.getPessoaDocumentosConselhoCollection()) {
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach = em.getReference(pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach.getClass(), pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach.getId());
                attachedPessoaDocumentosConselhoCollection.add(pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach);
            }
            uf.setPessoaDocumentosConselhoCollection(attachedPessoaDocumentosConselhoCollection);
            Collection<Cidades> attachedCidadesCollection = new ArrayList<Cidades>();
            for (Cidades cidadesCollectionCidadesToAttach : uf.getCidadesCollection()) {
                cidadesCollectionCidadesToAttach = em.getReference(cidadesCollectionCidadesToAttach.getClass(), cidadesCollectionCidadesToAttach.getId());
                attachedCidadesCollection.add(cidadesCollectionCidadesToAttach);
            }
            uf.setCidadesCollection(attachedCidadesCollection);
            Collection<PessoaDocumentosRg> attachedPessoaDocumentosRgCollection = new ArrayList<PessoaDocumentosRg>();
            for (PessoaDocumentosRg pessoaDocumentosRgCollectionPessoaDocumentosRgToAttach : uf.getPessoaDocumentosRgCollection()) {
                pessoaDocumentosRgCollectionPessoaDocumentosRgToAttach = em.getReference(pessoaDocumentosRgCollectionPessoaDocumentosRgToAttach.getClass(), pessoaDocumentosRgCollectionPessoaDocumentosRgToAttach.getId());
                attachedPessoaDocumentosRgCollection.add(pessoaDocumentosRgCollectionPessoaDocumentosRgToAttach);
            }
            uf.setPessoaDocumentosRgCollection(attachedPessoaDocumentosRgCollection);
            em.persist(uf);
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionPessoaDocumentosConselho : uf.getPessoaDocumentosConselhoCollection()) {
                Uf oldIdUfFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho = pessoaDocumentosConselhoCollectionPessoaDocumentosConselho.getIdUfFk();
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho.setIdUfFk(uf);
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                if (oldIdUfFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho != null) {
                    oldIdUfFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                    oldIdUfFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho = em.merge(oldIdUfFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                }
            }
            for (Cidades cidadesCollectionCidades : uf.getCidadesCollection()) {
                Uf oldIdUfFkOfCidadesCollectionCidades = cidadesCollectionCidades.getIdUfFk();
                cidadesCollectionCidades.setIdUfFk(uf);
                cidadesCollectionCidades = em.merge(cidadesCollectionCidades);
                if (oldIdUfFkOfCidadesCollectionCidades != null) {
                    oldIdUfFkOfCidadesCollectionCidades.getCidadesCollection().remove(cidadesCollectionCidades);
                    oldIdUfFkOfCidadesCollectionCidades = em.merge(oldIdUfFkOfCidadesCollectionCidades);
                }
            }
            for (PessoaDocumentosRg pessoaDocumentosRgCollectionPessoaDocumentosRg : uf.getPessoaDocumentosRgCollection()) {
                Uf oldIdUfEmissaoOfPessoaDocumentosRgCollectionPessoaDocumentosRg = pessoaDocumentosRgCollectionPessoaDocumentosRg.getIdUfEmissao();
                pessoaDocumentosRgCollectionPessoaDocumentosRg.setIdUfEmissao(uf);
                pessoaDocumentosRgCollectionPessoaDocumentosRg = em.merge(pessoaDocumentosRgCollectionPessoaDocumentosRg);
                if (oldIdUfEmissaoOfPessoaDocumentosRgCollectionPessoaDocumentosRg != null) {
                    oldIdUfEmissaoOfPessoaDocumentosRgCollectionPessoaDocumentosRg.getPessoaDocumentosRgCollection().remove(pessoaDocumentosRgCollectionPessoaDocumentosRg);
                    oldIdUfEmissaoOfPessoaDocumentosRgCollectionPessoaDocumentosRg = em.merge(oldIdUfEmissaoOfPessoaDocumentosRgCollectionPessoaDocumentosRg);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Uf uf) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uf persistentUf = em.find(Uf.class, uf.getId());
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollectionOld = persistentUf.getPessoaDocumentosConselhoCollection();
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollectionNew = uf.getPessoaDocumentosConselhoCollection();
            Collection<Cidades> cidadesCollectionOld = persistentUf.getCidadesCollection();
            Collection<Cidades> cidadesCollectionNew = uf.getCidadesCollection();
            Collection<PessoaDocumentosRg> pessoaDocumentosRgCollectionOld = persistentUf.getPessoaDocumentosRgCollection();
            Collection<PessoaDocumentosRg> pessoaDocumentosRgCollectionNew = uf.getPessoaDocumentosRgCollection();
            List<String> illegalOrphanMessages = null;
            for (Cidades cidadesCollectionOldCidades : cidadesCollectionOld) {
                if (!cidadesCollectionNew.contains(cidadesCollectionOldCidades)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cidades " + cidadesCollectionOldCidades + " since its idUfFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<PessoaDocumentosConselho> attachedPessoaDocumentosConselhoCollectionNew = new ArrayList<PessoaDocumentosConselho>();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach : pessoaDocumentosConselhoCollectionNew) {
                pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach = em.getReference(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach.getClass(), pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach.getId());
                attachedPessoaDocumentosConselhoCollectionNew.add(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach);
            }
            pessoaDocumentosConselhoCollectionNew = attachedPessoaDocumentosConselhoCollectionNew;
            uf.setPessoaDocumentosConselhoCollection(pessoaDocumentosConselhoCollectionNew);
            Collection<Cidades> attachedCidadesCollectionNew = new ArrayList<Cidades>();
            for (Cidades cidadesCollectionNewCidadesToAttach : cidadesCollectionNew) {
                cidadesCollectionNewCidadesToAttach = em.getReference(cidadesCollectionNewCidadesToAttach.getClass(), cidadesCollectionNewCidadesToAttach.getId());
                attachedCidadesCollectionNew.add(cidadesCollectionNewCidadesToAttach);
            }
            cidadesCollectionNew = attachedCidadesCollectionNew;
            uf.setCidadesCollection(cidadesCollectionNew);
            Collection<PessoaDocumentosRg> attachedPessoaDocumentosRgCollectionNew = new ArrayList<PessoaDocumentosRg>();
            for (PessoaDocumentosRg pessoaDocumentosRgCollectionNewPessoaDocumentosRgToAttach : pessoaDocumentosRgCollectionNew) {
                pessoaDocumentosRgCollectionNewPessoaDocumentosRgToAttach = em.getReference(pessoaDocumentosRgCollectionNewPessoaDocumentosRgToAttach.getClass(), pessoaDocumentosRgCollectionNewPessoaDocumentosRgToAttach.getId());
                attachedPessoaDocumentosRgCollectionNew.add(pessoaDocumentosRgCollectionNewPessoaDocumentosRgToAttach);
            }
            pessoaDocumentosRgCollectionNew = attachedPessoaDocumentosRgCollectionNew;
            uf.setPessoaDocumentosRgCollection(pessoaDocumentosRgCollectionNew);
            uf = em.merge(uf);
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho : pessoaDocumentosConselhoCollectionOld) {
                if (!pessoaDocumentosConselhoCollectionNew.contains(pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho)) {
                    pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho.setIdUfFk(null);
                    pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho);
                }
            }
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho : pessoaDocumentosConselhoCollectionNew) {
                if (!pessoaDocumentosConselhoCollectionOld.contains(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho)) {
                    Uf oldIdUfFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.getIdUfFk();
                    pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.setIdUfFk(uf);
                    pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                    if (oldIdUfFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho != null && !oldIdUfFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.equals(uf)) {
                        oldIdUfFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                        oldIdUfFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = em.merge(oldIdUfFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                    }
                }
            }
            for (Cidades cidadesCollectionNewCidades : cidadesCollectionNew) {
                if (!cidadesCollectionOld.contains(cidadesCollectionNewCidades)) {
                    Uf oldIdUfFkOfCidadesCollectionNewCidades = cidadesCollectionNewCidades.getIdUfFk();
                    cidadesCollectionNewCidades.setIdUfFk(uf);
                    cidadesCollectionNewCidades = em.merge(cidadesCollectionNewCidades);
                    if (oldIdUfFkOfCidadesCollectionNewCidades != null && !oldIdUfFkOfCidadesCollectionNewCidades.equals(uf)) {
                        oldIdUfFkOfCidadesCollectionNewCidades.getCidadesCollection().remove(cidadesCollectionNewCidades);
                        oldIdUfFkOfCidadesCollectionNewCidades = em.merge(oldIdUfFkOfCidadesCollectionNewCidades);
                    }
                }
            }
            for (PessoaDocumentosRg pessoaDocumentosRgCollectionOldPessoaDocumentosRg : pessoaDocumentosRgCollectionOld) {
                if (!pessoaDocumentosRgCollectionNew.contains(pessoaDocumentosRgCollectionOldPessoaDocumentosRg)) {
                    pessoaDocumentosRgCollectionOldPessoaDocumentosRg.setIdUfEmissao(null);
                    pessoaDocumentosRgCollectionOldPessoaDocumentosRg = em.merge(pessoaDocumentosRgCollectionOldPessoaDocumentosRg);
                }
            }
            for (PessoaDocumentosRg pessoaDocumentosRgCollectionNewPessoaDocumentosRg : pessoaDocumentosRgCollectionNew) {
                if (!pessoaDocumentosRgCollectionOld.contains(pessoaDocumentosRgCollectionNewPessoaDocumentosRg)) {
                    Uf oldIdUfEmissaoOfPessoaDocumentosRgCollectionNewPessoaDocumentosRg = pessoaDocumentosRgCollectionNewPessoaDocumentosRg.getIdUfEmissao();
                    pessoaDocumentosRgCollectionNewPessoaDocumentosRg.setIdUfEmissao(uf);
                    pessoaDocumentosRgCollectionNewPessoaDocumentosRg = em.merge(pessoaDocumentosRgCollectionNewPessoaDocumentosRg);
                    if (oldIdUfEmissaoOfPessoaDocumentosRgCollectionNewPessoaDocumentosRg != null && !oldIdUfEmissaoOfPessoaDocumentosRgCollectionNewPessoaDocumentosRg.equals(uf)) {
                        oldIdUfEmissaoOfPessoaDocumentosRgCollectionNewPessoaDocumentosRg.getPessoaDocumentosRgCollection().remove(pessoaDocumentosRgCollectionNewPessoaDocumentosRg);
                        oldIdUfEmissaoOfPessoaDocumentosRgCollectionNewPessoaDocumentosRg = em.merge(oldIdUfEmissaoOfPessoaDocumentosRgCollectionNewPessoaDocumentosRg);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = uf.getId();
                if (findUf(id) == null) {
                    throw new NonexistentEntityException("The uf with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uf uf;
            try {
                uf = em.getReference(Uf.class, id);
                uf.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The uf with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Cidades> cidadesCollectionOrphanCheck = uf.getCidadesCollection();
            for (Cidades cidadesCollectionOrphanCheckCidades : cidadesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Cidades " + cidadesCollectionOrphanCheckCidades + " in its cidadesCollection field has a non-nullable idUfFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection = uf.getPessoaDocumentosConselhoCollection();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionPessoaDocumentosConselho : pessoaDocumentosConselhoCollection) {
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho.setIdUfFk(null);
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
            }
            Collection<PessoaDocumentosRg> pessoaDocumentosRgCollection = uf.getPessoaDocumentosRgCollection();
            for (PessoaDocumentosRg pessoaDocumentosRgCollectionPessoaDocumentosRg : pessoaDocumentosRgCollection) {
                pessoaDocumentosRgCollectionPessoaDocumentosRg.setIdUfEmissao(null);
                pessoaDocumentosRgCollectionPessoaDocumentosRg = em.merge(pessoaDocumentosRgCollectionPessoaDocumentosRg);
            }
            em.remove(uf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Uf> findUfEntities() {
        return findUfEntities(true, -1, -1);
    }

    public List<Uf> findUfEntities(int maxResults, int firstResult) {
        return findUfEntities(false, maxResults, firstResult);
    }

    private List<Uf> findUfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Uf.class));
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

    public Uf findUf(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Uf.class, id);
        } finally {
            em.close();
        }
    }

    public int getUfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Uf> rt = cq.from(Uf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
