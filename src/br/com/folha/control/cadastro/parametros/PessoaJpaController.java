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
import br.com.folha.model.tabelas.Cidades;
import br.com.folha.model.tabelas.Enderecos;
import br.com.folha.model.tabelas.Escolaridades;
import br.com.folha.model.tabelas.EstadosCivis;
import br.com.folha.model.tabelas.PessoaOperadores;
import br.com.folha.model.tabelas.Sexos;
import br.com.folha.model.tabelas.PessoaFilhos;
import java.util.ArrayList;
import java.util.Collection;
import br.com.folha.model.tabelas.PessoaDocumentosConselho;
import br.com.folha.model.tabelas.PessoaDocumentosReservista;
import br.com.folha.model.tabelas.PessoaFotos;
import br.com.folha.model.tabelas.PessoaDocumentos;
import br.com.folha.model.tabelas.PessoaDocumentosHabilitacao;
import br.com.folha.model.tabelas.PessoaDocumentosCtps;
import br.com.folha.model.tabelas.PessoaBancos;
import br.com.folha.model.tabelas.HistUnidadesDiretor;
import br.com.folha.model.tabelas.Pessoa;
import br.com.folha.model.tabelas.PessoaFuncionarios;
import br.com.folha.model.tabelas.PessoaDocumentosTitulo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ANDREI
 */
public class PessoaJpaController implements Serializable {

    public PessoaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pessoa pessoa) {
        if (pessoa.getPessoaFilhosCollection() == null) {
            pessoa.setPessoaFilhosCollection(new ArrayList<PessoaFilhos>());
        }
        if (pessoa.getPessoaDocumentosConselhoCollection() == null) {
            pessoa.setPessoaDocumentosConselhoCollection(new ArrayList<PessoaDocumentosConselho>());
        }
        if (pessoa.getPessoaDocumentosReservistaCollection() == null) {
            pessoa.setPessoaDocumentosReservistaCollection(new ArrayList<PessoaDocumentosReservista>());
        }
        if (pessoa.getPessoaFotosCollection() == null) {
            pessoa.setPessoaFotosCollection(new ArrayList<PessoaFotos>());
        }
        if (pessoa.getPessoaDocumentosCollection() == null) {
            pessoa.setPessoaDocumentosCollection(new ArrayList<PessoaDocumentos>());
        }
        if (pessoa.getPessoaOperadoresCollection() == null) {
            pessoa.setPessoaOperadoresCollection(new ArrayList<PessoaOperadores>());
        }
        if (pessoa.getEnderecosCollection() == null) {
            pessoa.setEnderecosCollection(new ArrayList<Enderecos>());
        }
        if (pessoa.getPessoaDocumentosHabilitacaoCollection() == null) {
            pessoa.setPessoaDocumentosHabilitacaoCollection(new ArrayList<PessoaDocumentosHabilitacao>());
        }
        if (pessoa.getPessoaDocumentosCtpsCollection() == null) {
            pessoa.setPessoaDocumentosCtpsCollection(new ArrayList<PessoaDocumentosCtps>());
        }
        if (pessoa.getPessoaBancosCollection() == null) {
            pessoa.setPessoaBancosCollection(new ArrayList<PessoaBancos>());
        }
        if (pessoa.getHistUnidadesDiretorCollection() == null) {
            pessoa.setHistUnidadesDiretorCollection(new ArrayList<HistUnidadesDiretor>());
        }
        if (pessoa.getPessoaFuncionariosCollection() == null) {
            pessoa.setPessoaFuncionariosCollection(new ArrayList<PessoaFuncionarios>());
        }
        if (pessoa.getPessoaDocumentosTituloCollection() == null) {
            pessoa.setPessoaDocumentosTituloCollection(new ArrayList<PessoaDocumentosTitulo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cidades seqCidadeNatal = pessoa.getSeqCidadeNatal();
            if (seqCidadeNatal != null) {
                seqCidadeNatal = em.getReference(seqCidadeNatal.getClass(), seqCidadeNatal.getId());
                pessoa.setSeqCidadeNatal(seqCidadeNatal);
            }
            Enderecos seqEndereco = pessoa.getSeqEndereco();
            if (seqEndereco != null) {
                seqEndereco = em.getReference(seqEndereco.getClass(), seqEndereco.getId());
                pessoa.setSeqEndereco(seqEndereco);
            }
            Escolaridades seqEscolaridade = pessoa.getSeqEscolaridade();
            if (seqEscolaridade != null) {
                seqEscolaridade = em.getReference(seqEscolaridade.getClass(), seqEscolaridade.getId());
                pessoa.setSeqEscolaridade(seqEscolaridade);
            }
            EstadosCivis seqEstadoCivil = pessoa.getSeqEstadoCivil();
            if (seqEstadoCivil != null) {
                seqEstadoCivil = em.getReference(seqEstadoCivil.getClass(), seqEstadoCivil.getId());
                pessoa.setSeqEstadoCivil(seqEstadoCivil);
            }
            PessoaOperadores seqOperadorCadastro = pessoa.getSeqOperadorCadastro();
            if (seqOperadorCadastro != null) {
                seqOperadorCadastro = em.getReference(seqOperadorCadastro.getClass(), seqOperadorCadastro.getId());
                pessoa.setSeqOperadorCadastro(seqOperadorCadastro);
            }
            PessoaOperadores seqOperadorCancelamento = pessoa.getSeqOperadorCancelamento();
            if (seqOperadorCancelamento != null) {
                seqOperadorCancelamento = em.getReference(seqOperadorCancelamento.getClass(), seqOperadorCancelamento.getId());
                pessoa.setSeqOperadorCancelamento(seqOperadorCancelamento);
            }
            Sexos seqSexoDeclarado = pessoa.getSeqSexoDeclarado();
            if (seqSexoDeclarado != null) {
                seqSexoDeclarado = em.getReference(seqSexoDeclarado.getClass(), seqSexoDeclarado.getId());
                pessoa.setSeqSexoDeclarado(seqSexoDeclarado);
            }
            Sexos seqSexo = pessoa.getSeqSexo();
            if (seqSexo != null) {
                seqSexo = em.getReference(seqSexo.getClass(), seqSexo.getId());
                pessoa.setSeqSexo(seqSexo);
            }
            Collection<PessoaFilhos> attachedPessoaFilhosCollection = new ArrayList<PessoaFilhos>();
            for (PessoaFilhos pessoaFilhosCollectionPessoaFilhosToAttach : pessoa.getPessoaFilhosCollection()) {
                pessoaFilhosCollectionPessoaFilhosToAttach = em.getReference(pessoaFilhosCollectionPessoaFilhosToAttach.getClass(), pessoaFilhosCollectionPessoaFilhosToAttach.getId());
                attachedPessoaFilhosCollection.add(pessoaFilhosCollectionPessoaFilhosToAttach);
            }
            pessoa.setPessoaFilhosCollection(attachedPessoaFilhosCollection);
            Collection<PessoaDocumentosConselho> attachedPessoaDocumentosConselhoCollection = new ArrayList<PessoaDocumentosConselho>();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach : pessoa.getPessoaDocumentosConselhoCollection()) {
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach = em.getReference(pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach.getClass(), pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach.getId());
                attachedPessoaDocumentosConselhoCollection.add(pessoaDocumentosConselhoCollectionPessoaDocumentosConselhoToAttach);
            }
            pessoa.setPessoaDocumentosConselhoCollection(attachedPessoaDocumentosConselhoCollection);
            Collection<PessoaDocumentosReservista> attachedPessoaDocumentosReservistaCollection = new ArrayList<PessoaDocumentosReservista>();
            for (PessoaDocumentosReservista pessoaDocumentosReservistaCollectionPessoaDocumentosReservistaToAttach : pessoa.getPessoaDocumentosReservistaCollection()) {
                pessoaDocumentosReservistaCollectionPessoaDocumentosReservistaToAttach = em.getReference(pessoaDocumentosReservistaCollectionPessoaDocumentosReservistaToAttach.getClass(), pessoaDocumentosReservistaCollectionPessoaDocumentosReservistaToAttach.getId());
                attachedPessoaDocumentosReservistaCollection.add(pessoaDocumentosReservistaCollectionPessoaDocumentosReservistaToAttach);
            }
            pessoa.setPessoaDocumentosReservistaCollection(attachedPessoaDocumentosReservistaCollection);
            Collection<PessoaFotos> attachedPessoaFotosCollection = new ArrayList<PessoaFotos>();
            for (PessoaFotos pessoaFotosCollectionPessoaFotosToAttach : pessoa.getPessoaFotosCollection()) {
                pessoaFotosCollectionPessoaFotosToAttach = em.getReference(pessoaFotosCollectionPessoaFotosToAttach.getClass(), pessoaFotosCollectionPessoaFotosToAttach.getId());
                attachedPessoaFotosCollection.add(pessoaFotosCollectionPessoaFotosToAttach);
            }
            pessoa.setPessoaFotosCollection(attachedPessoaFotosCollection);
            Collection<PessoaDocumentos> attachedPessoaDocumentosCollection = new ArrayList<PessoaDocumentos>();
            for (PessoaDocumentos pessoaDocumentosCollectionPessoaDocumentosToAttach : pessoa.getPessoaDocumentosCollection()) {
                pessoaDocumentosCollectionPessoaDocumentosToAttach = em.getReference(pessoaDocumentosCollectionPessoaDocumentosToAttach.getClass(), pessoaDocumentosCollectionPessoaDocumentosToAttach.getId());
                attachedPessoaDocumentosCollection.add(pessoaDocumentosCollectionPessoaDocumentosToAttach);
            }
            pessoa.setPessoaDocumentosCollection(attachedPessoaDocumentosCollection);
            Collection<PessoaOperadores> attachedPessoaOperadoresCollection = new ArrayList<PessoaOperadores>();
            for (PessoaOperadores pessoaOperadoresCollectionPessoaOperadoresToAttach : pessoa.getPessoaOperadoresCollection()) {
                pessoaOperadoresCollectionPessoaOperadoresToAttach = em.getReference(pessoaOperadoresCollectionPessoaOperadoresToAttach.getClass(), pessoaOperadoresCollectionPessoaOperadoresToAttach.getId());
                attachedPessoaOperadoresCollection.add(pessoaOperadoresCollectionPessoaOperadoresToAttach);
            }
            pessoa.setPessoaOperadoresCollection(attachedPessoaOperadoresCollection);
            Collection<Enderecos> attachedEnderecosCollection = new ArrayList<Enderecos>();
            for (Enderecos enderecosCollectionEnderecosToAttach : pessoa.getEnderecosCollection()) {
                enderecosCollectionEnderecosToAttach = em.getReference(enderecosCollectionEnderecosToAttach.getClass(), enderecosCollectionEnderecosToAttach.getId());
                attachedEnderecosCollection.add(enderecosCollectionEnderecosToAttach);
            }
            pessoa.setEnderecosCollection(attachedEnderecosCollection);
            Collection<PessoaDocumentosHabilitacao> attachedPessoaDocumentosHabilitacaoCollection = new ArrayList<PessoaDocumentosHabilitacao>();
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach : pessoa.getPessoaDocumentosHabilitacaoCollection()) {
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach = em.getReference(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach.getClass(), pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach.getId());
                attachedPessoaDocumentosHabilitacaoCollection.add(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacaoToAttach);
            }
            pessoa.setPessoaDocumentosHabilitacaoCollection(attachedPessoaDocumentosHabilitacaoCollection);
            Collection<PessoaDocumentosCtps> attachedPessoaDocumentosCtpsCollection = new ArrayList<PessoaDocumentosCtps>();
            for (PessoaDocumentosCtps pessoaDocumentosCtpsCollectionPessoaDocumentosCtpsToAttach : pessoa.getPessoaDocumentosCtpsCollection()) {
                pessoaDocumentosCtpsCollectionPessoaDocumentosCtpsToAttach = em.getReference(pessoaDocumentosCtpsCollectionPessoaDocumentosCtpsToAttach.getClass(), pessoaDocumentosCtpsCollectionPessoaDocumentosCtpsToAttach.getId());
                attachedPessoaDocumentosCtpsCollection.add(pessoaDocumentosCtpsCollectionPessoaDocumentosCtpsToAttach);
            }
            pessoa.setPessoaDocumentosCtpsCollection(attachedPessoaDocumentosCtpsCollection);
            Collection<PessoaBancos> attachedPessoaBancosCollection = new ArrayList<PessoaBancos>();
            for (PessoaBancos pessoaBancosCollectionPessoaBancosToAttach : pessoa.getPessoaBancosCollection()) {
                pessoaBancosCollectionPessoaBancosToAttach = em.getReference(pessoaBancosCollectionPessoaBancosToAttach.getClass(), pessoaBancosCollectionPessoaBancosToAttach.getId());
                attachedPessoaBancosCollection.add(pessoaBancosCollectionPessoaBancosToAttach);
            }
            pessoa.setPessoaBancosCollection(attachedPessoaBancosCollection);
            Collection<HistUnidadesDiretor> attachedHistUnidadesDiretorCollection = new ArrayList<HistUnidadesDiretor>();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionHistUnidadesDiretorToAttach : pessoa.getHistUnidadesDiretorCollection()) {
                histUnidadesDiretorCollectionHistUnidadesDiretorToAttach = em.getReference(histUnidadesDiretorCollectionHistUnidadesDiretorToAttach.getClass(), histUnidadesDiretorCollectionHistUnidadesDiretorToAttach.getHistUnidadesDiretorPK());
                attachedHistUnidadesDiretorCollection.add(histUnidadesDiretorCollectionHistUnidadesDiretorToAttach);
            }
            pessoa.setHistUnidadesDiretorCollection(attachedHistUnidadesDiretorCollection);
            Collection<PessoaFuncionarios> attachedPessoaFuncionariosCollection = new ArrayList<PessoaFuncionarios>();
            for (PessoaFuncionarios pessoaFuncionariosCollectionPessoaFuncionariosToAttach : pessoa.getPessoaFuncionariosCollection()) {
                pessoaFuncionariosCollectionPessoaFuncionariosToAttach = em.getReference(pessoaFuncionariosCollectionPessoaFuncionariosToAttach.getClass(), pessoaFuncionariosCollectionPessoaFuncionariosToAttach.getId());
                attachedPessoaFuncionariosCollection.add(pessoaFuncionariosCollectionPessoaFuncionariosToAttach);
            }
            pessoa.setPessoaFuncionariosCollection(attachedPessoaFuncionariosCollection);
            Collection<PessoaDocumentosTitulo> attachedPessoaDocumentosTituloCollection = new ArrayList<PessoaDocumentosTitulo>();
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach : pessoa.getPessoaDocumentosTituloCollection()) {
                pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach = em.getReference(pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach.getClass(), pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach.getId());
                attachedPessoaDocumentosTituloCollection.add(pessoaDocumentosTituloCollectionPessoaDocumentosTituloToAttach);
            }
            pessoa.setPessoaDocumentosTituloCollection(attachedPessoaDocumentosTituloCollection);
            em.persist(pessoa);
            if (seqCidadeNatal != null) {
                seqCidadeNatal.getPessoaCollection().add(pessoa);
                seqCidadeNatal = em.merge(seqCidadeNatal);
            }
            if (seqEndereco != null) {
                Pessoa oldIdPessoaFkOfSeqEndereco = seqEndereco.getIdPessoaFk();
                if (oldIdPessoaFkOfSeqEndereco != null) {
                    oldIdPessoaFkOfSeqEndereco.setSeqEndereco(null);
                    oldIdPessoaFkOfSeqEndereco = em.merge(oldIdPessoaFkOfSeqEndereco);
                }
                seqEndereco.setIdPessoaFk(pessoa);
                seqEndereco = em.merge(seqEndereco);
            }
            if (seqEscolaridade != null) {
                seqEscolaridade.getPessoaCollection().add(pessoa);
                seqEscolaridade = em.merge(seqEscolaridade);
            }
            if (seqEstadoCivil != null) {
                seqEstadoCivil.getPessoaCollection().add(pessoa);
                seqEstadoCivil = em.merge(seqEstadoCivil);
            }
            if (seqOperadorCadastro != null) {
                Pessoa oldIdPessoaFkOfSeqOperadorCadastro = seqOperadorCadastro.getIdPessoaFk();
                if (oldIdPessoaFkOfSeqOperadorCadastro != null) {
                    oldIdPessoaFkOfSeqOperadorCadastro.setSeqOperadorCadastro(null);
                    oldIdPessoaFkOfSeqOperadorCadastro = em.merge(oldIdPessoaFkOfSeqOperadorCadastro);
                }
                seqOperadorCadastro.setIdPessoaFk(pessoa);
                seqOperadorCadastro = em.merge(seqOperadorCadastro);
            }
            if (seqOperadorCancelamento != null) {
                Pessoa oldIdPessoaFkOfSeqOperadorCancelamento = seqOperadorCancelamento.getIdPessoaFk();
                if (oldIdPessoaFkOfSeqOperadorCancelamento != null) {
                    oldIdPessoaFkOfSeqOperadorCancelamento.setSeqOperadorCancelamento(null);
                    oldIdPessoaFkOfSeqOperadorCancelamento = em.merge(oldIdPessoaFkOfSeqOperadorCancelamento);
                }
                seqOperadorCancelamento.setIdPessoaFk(pessoa);
                seqOperadorCancelamento = em.merge(seqOperadorCancelamento);
            }
            if (seqSexoDeclarado != null) {
                seqSexoDeclarado.getPessoaCollection().add(pessoa);
                seqSexoDeclarado = em.merge(seqSexoDeclarado);
            }
            if (seqSexo != null) {
                seqSexo.getPessoaCollection().add(pessoa);
                seqSexo = em.merge(seqSexo);
            }
            for (PessoaFilhos pessoaFilhosCollectionPessoaFilhos : pessoa.getPessoaFilhosCollection()) {
                Pessoa oldIdPessoaFkOfPessoaFilhosCollectionPessoaFilhos = pessoaFilhosCollectionPessoaFilhos.getIdPessoaFk();
                pessoaFilhosCollectionPessoaFilhos.setIdPessoaFk(pessoa);
                pessoaFilhosCollectionPessoaFilhos = em.merge(pessoaFilhosCollectionPessoaFilhos);
                if (oldIdPessoaFkOfPessoaFilhosCollectionPessoaFilhos != null) {
                    oldIdPessoaFkOfPessoaFilhosCollectionPessoaFilhos.getPessoaFilhosCollection().remove(pessoaFilhosCollectionPessoaFilhos);
                    oldIdPessoaFkOfPessoaFilhosCollectionPessoaFilhos = em.merge(oldIdPessoaFkOfPessoaFilhosCollectionPessoaFilhos);
                }
            }
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionPessoaDocumentosConselho : pessoa.getPessoaDocumentosConselhoCollection()) {
                Pessoa oldIdPessoaFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho = pessoaDocumentosConselhoCollectionPessoaDocumentosConselho.getIdPessoaFk();
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho.setIdPessoaFk(pessoa);
                pessoaDocumentosConselhoCollectionPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                if (oldIdPessoaFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho != null) {
                    oldIdPessoaFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                    oldIdPessoaFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho = em.merge(oldIdPessoaFkOfPessoaDocumentosConselhoCollectionPessoaDocumentosConselho);
                }
            }
            for (PessoaDocumentosReservista pessoaDocumentosReservistaCollectionPessoaDocumentosReservista : pessoa.getPessoaDocumentosReservistaCollection()) {
                Pessoa oldIdPessoaFkOfPessoaDocumentosReservistaCollectionPessoaDocumentosReservista = pessoaDocumentosReservistaCollectionPessoaDocumentosReservista.getIdPessoaFk();
                pessoaDocumentosReservistaCollectionPessoaDocumentosReservista.setIdPessoaFk(pessoa);
                pessoaDocumentosReservistaCollectionPessoaDocumentosReservista = em.merge(pessoaDocumentosReservistaCollectionPessoaDocumentosReservista);
                if (oldIdPessoaFkOfPessoaDocumentosReservistaCollectionPessoaDocumentosReservista != null) {
                    oldIdPessoaFkOfPessoaDocumentosReservistaCollectionPessoaDocumentosReservista.getPessoaDocumentosReservistaCollection().remove(pessoaDocumentosReservistaCollectionPessoaDocumentosReservista);
                    oldIdPessoaFkOfPessoaDocumentosReservistaCollectionPessoaDocumentosReservista = em.merge(oldIdPessoaFkOfPessoaDocumentosReservistaCollectionPessoaDocumentosReservista);
                }
            }
            for (PessoaFotos pessoaFotosCollectionPessoaFotos : pessoa.getPessoaFotosCollection()) {
                Pessoa oldIdPessoaFkOfPessoaFotosCollectionPessoaFotos = pessoaFotosCollectionPessoaFotos.getIdPessoaFk();
                pessoaFotosCollectionPessoaFotos.setIdPessoaFk(pessoa);
                pessoaFotosCollectionPessoaFotos = em.merge(pessoaFotosCollectionPessoaFotos);
                if (oldIdPessoaFkOfPessoaFotosCollectionPessoaFotos != null) {
                    oldIdPessoaFkOfPessoaFotosCollectionPessoaFotos.getPessoaFotosCollection().remove(pessoaFotosCollectionPessoaFotos);
                    oldIdPessoaFkOfPessoaFotosCollectionPessoaFotos = em.merge(oldIdPessoaFkOfPessoaFotosCollectionPessoaFotos);
                }
            }
            for (PessoaDocumentos pessoaDocumentosCollectionPessoaDocumentos : pessoa.getPessoaDocumentosCollection()) {
                Pessoa oldIdPessoaFkOfPessoaDocumentosCollectionPessoaDocumentos = pessoaDocumentosCollectionPessoaDocumentos.getIdPessoaFk();
                pessoaDocumentosCollectionPessoaDocumentos.setIdPessoaFk(pessoa);
                pessoaDocumentosCollectionPessoaDocumentos = em.merge(pessoaDocumentosCollectionPessoaDocumentos);
                if (oldIdPessoaFkOfPessoaDocumentosCollectionPessoaDocumentos != null) {
                    oldIdPessoaFkOfPessoaDocumentosCollectionPessoaDocumentos.getPessoaDocumentosCollection().remove(pessoaDocumentosCollectionPessoaDocumentos);
                    oldIdPessoaFkOfPessoaDocumentosCollectionPessoaDocumentos = em.merge(oldIdPessoaFkOfPessoaDocumentosCollectionPessoaDocumentos);
                }
            }
            for (PessoaOperadores pessoaOperadoresCollectionPessoaOperadores : pessoa.getPessoaOperadoresCollection()) {
                Pessoa oldIdPessoaFkOfPessoaOperadoresCollectionPessoaOperadores = pessoaOperadoresCollectionPessoaOperadores.getIdPessoaFk();
                pessoaOperadoresCollectionPessoaOperadores.setIdPessoaFk(pessoa);
                pessoaOperadoresCollectionPessoaOperadores = em.merge(pessoaOperadoresCollectionPessoaOperadores);
                if (oldIdPessoaFkOfPessoaOperadoresCollectionPessoaOperadores != null) {
                    oldIdPessoaFkOfPessoaOperadoresCollectionPessoaOperadores.getPessoaOperadoresCollection().remove(pessoaOperadoresCollectionPessoaOperadores);
                    oldIdPessoaFkOfPessoaOperadoresCollectionPessoaOperadores = em.merge(oldIdPessoaFkOfPessoaOperadoresCollectionPessoaOperadores);
                }
            }
            for (Enderecos enderecosCollectionEnderecos : pessoa.getEnderecosCollection()) {
                Pessoa oldIdPessoaFkOfEnderecosCollectionEnderecos = enderecosCollectionEnderecos.getIdPessoaFk();
                enderecosCollectionEnderecos.setIdPessoaFk(pessoa);
                enderecosCollectionEnderecos = em.merge(enderecosCollectionEnderecos);
                if (oldIdPessoaFkOfEnderecosCollectionEnderecos != null) {
                    oldIdPessoaFkOfEnderecosCollectionEnderecos.getEnderecosCollection().remove(enderecosCollectionEnderecos);
                    oldIdPessoaFkOfEnderecosCollectionEnderecos = em.merge(oldIdPessoaFkOfEnderecosCollectionEnderecos);
                }
            }
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao : pessoa.getPessoaDocumentosHabilitacaoCollection()) {
                Pessoa oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao = pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao.getIdPessoaFk();
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao.setIdPessoaFk(pessoa);
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao);
                if (oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao != null) {
                    oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao.getPessoaDocumentosHabilitacaoCollection().remove(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao);
                    oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao = em.merge(oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao);
                }
            }
            for (PessoaDocumentosCtps pessoaDocumentosCtpsCollectionPessoaDocumentosCtps : pessoa.getPessoaDocumentosCtpsCollection()) {
                Pessoa oldIdPessoaFkOfPessoaDocumentosCtpsCollectionPessoaDocumentosCtps = pessoaDocumentosCtpsCollectionPessoaDocumentosCtps.getIdPessoaFk();
                pessoaDocumentosCtpsCollectionPessoaDocumentosCtps.setIdPessoaFk(pessoa);
                pessoaDocumentosCtpsCollectionPessoaDocumentosCtps = em.merge(pessoaDocumentosCtpsCollectionPessoaDocumentosCtps);
                if (oldIdPessoaFkOfPessoaDocumentosCtpsCollectionPessoaDocumentosCtps != null) {
                    oldIdPessoaFkOfPessoaDocumentosCtpsCollectionPessoaDocumentosCtps.getPessoaDocumentosCtpsCollection().remove(pessoaDocumentosCtpsCollectionPessoaDocumentosCtps);
                    oldIdPessoaFkOfPessoaDocumentosCtpsCollectionPessoaDocumentosCtps = em.merge(oldIdPessoaFkOfPessoaDocumentosCtpsCollectionPessoaDocumentosCtps);
                }
            }
            for (PessoaBancos pessoaBancosCollectionPessoaBancos : pessoa.getPessoaBancosCollection()) {
                Pessoa oldIdPessoaFkOfPessoaBancosCollectionPessoaBancos = pessoaBancosCollectionPessoaBancos.getIdPessoaFk();
                pessoaBancosCollectionPessoaBancos.setIdPessoaFk(pessoa);
                pessoaBancosCollectionPessoaBancos = em.merge(pessoaBancosCollectionPessoaBancos);
                if (oldIdPessoaFkOfPessoaBancosCollectionPessoaBancos != null) {
                    oldIdPessoaFkOfPessoaBancosCollectionPessoaBancos.getPessoaBancosCollection().remove(pessoaBancosCollectionPessoaBancos);
                    oldIdPessoaFkOfPessoaBancosCollectionPessoaBancos = em.merge(oldIdPessoaFkOfPessoaBancosCollectionPessoaBancos);
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionHistUnidadesDiretor : pessoa.getHistUnidadesDiretorCollection()) {
                Pessoa oldPessoaOfHistUnidadesDiretorCollectionHistUnidadesDiretor = histUnidadesDiretorCollectionHistUnidadesDiretor.getPessoa();
                histUnidadesDiretorCollectionHistUnidadesDiretor.setPessoa(pessoa);
                histUnidadesDiretorCollectionHistUnidadesDiretor = em.merge(histUnidadesDiretorCollectionHistUnidadesDiretor);
                if (oldPessoaOfHistUnidadesDiretorCollectionHistUnidadesDiretor != null) {
                    oldPessoaOfHistUnidadesDiretorCollectionHistUnidadesDiretor.getHistUnidadesDiretorCollection().remove(histUnidadesDiretorCollectionHistUnidadesDiretor);
                    oldPessoaOfHistUnidadesDiretorCollectionHistUnidadesDiretor = em.merge(oldPessoaOfHistUnidadesDiretorCollectionHistUnidadesDiretor);
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollectionPessoaFuncionarios : pessoa.getPessoaFuncionariosCollection()) {
                Pessoa oldIdPessoaFkOfPessoaFuncionariosCollectionPessoaFuncionarios = pessoaFuncionariosCollectionPessoaFuncionarios.getIdPessoaFk();
                pessoaFuncionariosCollectionPessoaFuncionarios.setIdPessoaFk(pessoa);
                pessoaFuncionariosCollectionPessoaFuncionarios = em.merge(pessoaFuncionariosCollectionPessoaFuncionarios);
                if (oldIdPessoaFkOfPessoaFuncionariosCollectionPessoaFuncionarios != null) {
                    oldIdPessoaFkOfPessoaFuncionariosCollectionPessoaFuncionarios.getPessoaFuncionariosCollection().remove(pessoaFuncionariosCollectionPessoaFuncionarios);
                    oldIdPessoaFkOfPessoaFuncionariosCollectionPessoaFuncionarios = em.merge(oldIdPessoaFkOfPessoaFuncionariosCollectionPessoaFuncionarios);
                }
            }
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionPessoaDocumentosTitulo : pessoa.getPessoaDocumentosTituloCollection()) {
                Pessoa oldIdPessoaFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo = pessoaDocumentosTituloCollectionPessoaDocumentosTitulo.getIdPessoaFk();
                pessoaDocumentosTituloCollectionPessoaDocumentosTitulo.setIdPessoaFk(pessoa);
                pessoaDocumentosTituloCollectionPessoaDocumentosTitulo = em.merge(pessoaDocumentosTituloCollectionPessoaDocumentosTitulo);
                if (oldIdPessoaFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo != null) {
                    oldIdPessoaFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo.getPessoaDocumentosTituloCollection().remove(pessoaDocumentosTituloCollectionPessoaDocumentosTitulo);
                    oldIdPessoaFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo = em.merge(oldIdPessoaFkOfPessoaDocumentosTituloCollectionPessoaDocumentosTitulo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pessoa pessoa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa persistentPessoa = em.find(Pessoa.class, pessoa.getId());
            Cidades seqCidadeNatalOld = persistentPessoa.getSeqCidadeNatal();
            Cidades seqCidadeNatalNew = pessoa.getSeqCidadeNatal();
            Enderecos seqEnderecoOld = persistentPessoa.getSeqEndereco();
            Enderecos seqEnderecoNew = pessoa.getSeqEndereco();
            Escolaridades seqEscolaridadeOld = persistentPessoa.getSeqEscolaridade();
            Escolaridades seqEscolaridadeNew = pessoa.getSeqEscolaridade();
            EstadosCivis seqEstadoCivilOld = persistentPessoa.getSeqEstadoCivil();
            EstadosCivis seqEstadoCivilNew = pessoa.getSeqEstadoCivil();
            PessoaOperadores seqOperadorCadastroOld = persistentPessoa.getSeqOperadorCadastro();
            PessoaOperadores seqOperadorCadastroNew = pessoa.getSeqOperadorCadastro();
            PessoaOperadores seqOperadorCancelamentoOld = persistentPessoa.getSeqOperadorCancelamento();
            PessoaOperadores seqOperadorCancelamentoNew = pessoa.getSeqOperadorCancelamento();
            Sexos seqSexoDeclaradoOld = persistentPessoa.getSeqSexoDeclarado();
            Sexos seqSexoDeclaradoNew = pessoa.getSeqSexoDeclarado();
            Sexos seqSexoOld = persistentPessoa.getSeqSexo();
            Sexos seqSexoNew = pessoa.getSeqSexo();
            Collection<PessoaFilhos> pessoaFilhosCollectionOld = persistentPessoa.getPessoaFilhosCollection();
            Collection<PessoaFilhos> pessoaFilhosCollectionNew = pessoa.getPessoaFilhosCollection();
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollectionOld = persistentPessoa.getPessoaDocumentosConselhoCollection();
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollectionNew = pessoa.getPessoaDocumentosConselhoCollection();
            Collection<PessoaDocumentosReservista> pessoaDocumentosReservistaCollectionOld = persistentPessoa.getPessoaDocumentosReservistaCollection();
            Collection<PessoaDocumentosReservista> pessoaDocumentosReservistaCollectionNew = pessoa.getPessoaDocumentosReservistaCollection();
            Collection<PessoaFotos> pessoaFotosCollectionOld = persistentPessoa.getPessoaFotosCollection();
            Collection<PessoaFotos> pessoaFotosCollectionNew = pessoa.getPessoaFotosCollection();
            Collection<PessoaDocumentos> pessoaDocumentosCollectionOld = persistentPessoa.getPessoaDocumentosCollection();
            Collection<PessoaDocumentos> pessoaDocumentosCollectionNew = pessoa.getPessoaDocumentosCollection();
            Collection<PessoaOperadores> pessoaOperadoresCollectionOld = persistentPessoa.getPessoaOperadoresCollection();
            Collection<PessoaOperadores> pessoaOperadoresCollectionNew = pessoa.getPessoaOperadoresCollection();
            Collection<Enderecos> enderecosCollectionOld = persistentPessoa.getEnderecosCollection();
            Collection<Enderecos> enderecosCollectionNew = pessoa.getEnderecosCollection();
            Collection<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollectionOld = persistentPessoa.getPessoaDocumentosHabilitacaoCollection();
            Collection<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollectionNew = pessoa.getPessoaDocumentosHabilitacaoCollection();
            Collection<PessoaDocumentosCtps> pessoaDocumentosCtpsCollectionOld = persistentPessoa.getPessoaDocumentosCtpsCollection();
            Collection<PessoaDocumentosCtps> pessoaDocumentosCtpsCollectionNew = pessoa.getPessoaDocumentosCtpsCollection();
            Collection<PessoaBancos> pessoaBancosCollectionOld = persistentPessoa.getPessoaBancosCollection();
            Collection<PessoaBancos> pessoaBancosCollectionNew = pessoa.getPessoaBancosCollection();
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionOld = persistentPessoa.getHistUnidadesDiretorCollection();
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionNew = pessoa.getHistUnidadesDiretorCollection();
            Collection<PessoaFuncionarios> pessoaFuncionariosCollectionOld = persistentPessoa.getPessoaFuncionariosCollection();
            Collection<PessoaFuncionarios> pessoaFuncionariosCollectionNew = pessoa.getPessoaFuncionariosCollection();
            Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollectionOld = persistentPessoa.getPessoaDocumentosTituloCollection();
            Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollectionNew = pessoa.getPessoaDocumentosTituloCollection();
            List<String> illegalOrphanMessages = null;
            if (seqEnderecoOld != null && !seqEnderecoOld.equals(seqEnderecoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Enderecos " + seqEnderecoOld + " since its idPessoaFk field is not nullable.");
            }
            if (seqOperadorCadastroOld != null && !seqOperadorCadastroOld.equals(seqOperadorCadastroNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain PessoaOperadores " + seqOperadorCadastroOld + " since its idPessoaFk field is not nullable.");
            }
            if (seqOperadorCancelamentoOld != null && !seqOperadorCancelamentoOld.equals(seqOperadorCancelamentoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain PessoaOperadores " + seqOperadorCancelamentoOld + " since its idPessoaFk field is not nullable.");
            }
            for (PessoaFilhos pessoaFilhosCollectionOldPessoaFilhos : pessoaFilhosCollectionOld) {
                if (!pessoaFilhosCollectionNew.contains(pessoaFilhosCollectionOldPessoaFilhos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaFilhos " + pessoaFilhosCollectionOldPessoaFilhos + " since its idPessoaFk field is not nullable.");
                }
            }
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho : pessoaDocumentosConselhoCollectionOld) {
                if (!pessoaDocumentosConselhoCollectionNew.contains(pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaDocumentosConselho " + pessoaDocumentosConselhoCollectionOldPessoaDocumentosConselho + " since its idPessoaFk field is not nullable.");
                }
            }
            for (PessoaDocumentosReservista pessoaDocumentosReservistaCollectionOldPessoaDocumentosReservista : pessoaDocumentosReservistaCollectionOld) {
                if (!pessoaDocumentosReservistaCollectionNew.contains(pessoaDocumentosReservistaCollectionOldPessoaDocumentosReservista)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaDocumentosReservista " + pessoaDocumentosReservistaCollectionOldPessoaDocumentosReservista + " since its idPessoaFk field is not nullable.");
                }
            }
            for (PessoaFotos pessoaFotosCollectionOldPessoaFotos : pessoaFotosCollectionOld) {
                if (!pessoaFotosCollectionNew.contains(pessoaFotosCollectionOldPessoaFotos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaFotos " + pessoaFotosCollectionOldPessoaFotos + " since its idPessoaFk field is not nullable.");
                }
            }
            for (PessoaOperadores pessoaOperadoresCollectionOldPessoaOperadores : pessoaOperadoresCollectionOld) {
                if (!pessoaOperadoresCollectionNew.contains(pessoaOperadoresCollectionOldPessoaOperadores)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaOperadores " + pessoaOperadoresCollectionOldPessoaOperadores + " since its idPessoaFk field is not nullable.");
                }
            }
            for (Enderecos enderecosCollectionOldEnderecos : enderecosCollectionOld) {
                if (!enderecosCollectionNew.contains(enderecosCollectionOldEnderecos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Enderecos " + enderecosCollectionOldEnderecos + " since its idPessoaFk field is not nullable.");
                }
            }
            for (PessoaDocumentosCtps pessoaDocumentosCtpsCollectionOldPessoaDocumentosCtps : pessoaDocumentosCtpsCollectionOld) {
                if (!pessoaDocumentosCtpsCollectionNew.contains(pessoaDocumentosCtpsCollectionOldPessoaDocumentosCtps)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaDocumentosCtps " + pessoaDocumentosCtpsCollectionOldPessoaDocumentosCtps + " since its idPessoaFk field is not nullable.");
                }
            }
            for (PessoaBancos pessoaBancosCollectionOldPessoaBancos : pessoaBancosCollectionOld) {
                if (!pessoaBancosCollectionNew.contains(pessoaBancosCollectionOldPessoaBancos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaBancos " + pessoaBancosCollectionOldPessoaBancos + " since its idPessoaFk field is not nullable.");
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionOldHistUnidadesDiretor : histUnidadesDiretorCollectionOld) {
                if (!histUnidadesDiretorCollectionNew.contains(histUnidadesDiretorCollectionOldHistUnidadesDiretor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistUnidadesDiretor " + histUnidadesDiretorCollectionOldHistUnidadesDiretor + " since its pessoa field is not nullable.");
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollectionOldPessoaFuncionarios : pessoaFuncionariosCollectionOld) {
                if (!pessoaFuncionariosCollectionNew.contains(pessoaFuncionariosCollectionOldPessoaFuncionarios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaFuncionarios " + pessoaFuncionariosCollectionOldPessoaFuncionarios + " since its idPessoaFk field is not nullable.");
                }
            }
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionOldPessoaDocumentosTitulo : pessoaDocumentosTituloCollectionOld) {
                if (!pessoaDocumentosTituloCollectionNew.contains(pessoaDocumentosTituloCollectionOldPessoaDocumentosTitulo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PessoaDocumentosTitulo " + pessoaDocumentosTituloCollectionOldPessoaDocumentosTitulo + " since its idPessoaFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (seqCidadeNatalNew != null) {
                seqCidadeNatalNew = em.getReference(seqCidadeNatalNew.getClass(), seqCidadeNatalNew.getId());
                pessoa.setSeqCidadeNatal(seqCidadeNatalNew);
            }
            if (seqEnderecoNew != null) {
                seqEnderecoNew = em.getReference(seqEnderecoNew.getClass(), seqEnderecoNew.getId());
                pessoa.setSeqEndereco(seqEnderecoNew);
            }
            if (seqEscolaridadeNew != null) {
                seqEscolaridadeNew = em.getReference(seqEscolaridadeNew.getClass(), seqEscolaridadeNew.getId());
                pessoa.setSeqEscolaridade(seqEscolaridadeNew);
            }
            if (seqEstadoCivilNew != null) {
                seqEstadoCivilNew = em.getReference(seqEstadoCivilNew.getClass(), seqEstadoCivilNew.getId());
                pessoa.setSeqEstadoCivil(seqEstadoCivilNew);
            }
            if (seqOperadorCadastroNew != null) {
                seqOperadorCadastroNew = em.getReference(seqOperadorCadastroNew.getClass(), seqOperadorCadastroNew.getId());
                pessoa.setSeqOperadorCadastro(seqOperadorCadastroNew);
            }
            if (seqOperadorCancelamentoNew != null) {
                seqOperadorCancelamentoNew = em.getReference(seqOperadorCancelamentoNew.getClass(), seqOperadorCancelamentoNew.getId());
                pessoa.setSeqOperadorCancelamento(seqOperadorCancelamentoNew);
            }
            if (seqSexoDeclaradoNew != null) {
                seqSexoDeclaradoNew = em.getReference(seqSexoDeclaradoNew.getClass(), seqSexoDeclaradoNew.getId());
                pessoa.setSeqSexoDeclarado(seqSexoDeclaradoNew);
            }
            if (seqSexoNew != null) {
                seqSexoNew = em.getReference(seqSexoNew.getClass(), seqSexoNew.getId());
                pessoa.setSeqSexo(seqSexoNew);
            }
            Collection<PessoaFilhos> attachedPessoaFilhosCollectionNew = new ArrayList<PessoaFilhos>();
            for (PessoaFilhos pessoaFilhosCollectionNewPessoaFilhosToAttach : pessoaFilhosCollectionNew) {
                pessoaFilhosCollectionNewPessoaFilhosToAttach = em.getReference(pessoaFilhosCollectionNewPessoaFilhosToAttach.getClass(), pessoaFilhosCollectionNewPessoaFilhosToAttach.getId());
                attachedPessoaFilhosCollectionNew.add(pessoaFilhosCollectionNewPessoaFilhosToAttach);
            }
            pessoaFilhosCollectionNew = attachedPessoaFilhosCollectionNew;
            pessoa.setPessoaFilhosCollection(pessoaFilhosCollectionNew);
            Collection<PessoaDocumentosConselho> attachedPessoaDocumentosConselhoCollectionNew = new ArrayList<PessoaDocumentosConselho>();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach : pessoaDocumentosConselhoCollectionNew) {
                pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach = em.getReference(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach.getClass(), pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach.getId());
                attachedPessoaDocumentosConselhoCollectionNew.add(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselhoToAttach);
            }
            pessoaDocumentosConselhoCollectionNew = attachedPessoaDocumentosConselhoCollectionNew;
            pessoa.setPessoaDocumentosConselhoCollection(pessoaDocumentosConselhoCollectionNew);
            Collection<PessoaDocumentosReservista> attachedPessoaDocumentosReservistaCollectionNew = new ArrayList<PessoaDocumentosReservista>();
            for (PessoaDocumentosReservista pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservistaToAttach : pessoaDocumentosReservistaCollectionNew) {
                pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservistaToAttach = em.getReference(pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservistaToAttach.getClass(), pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservistaToAttach.getId());
                attachedPessoaDocumentosReservistaCollectionNew.add(pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservistaToAttach);
            }
            pessoaDocumentosReservistaCollectionNew = attachedPessoaDocumentosReservistaCollectionNew;
            pessoa.setPessoaDocumentosReservistaCollection(pessoaDocumentosReservistaCollectionNew);
            Collection<PessoaFotos> attachedPessoaFotosCollectionNew = new ArrayList<PessoaFotos>();
            for (PessoaFotos pessoaFotosCollectionNewPessoaFotosToAttach : pessoaFotosCollectionNew) {
                pessoaFotosCollectionNewPessoaFotosToAttach = em.getReference(pessoaFotosCollectionNewPessoaFotosToAttach.getClass(), pessoaFotosCollectionNewPessoaFotosToAttach.getId());
                attachedPessoaFotosCollectionNew.add(pessoaFotosCollectionNewPessoaFotosToAttach);
            }
            pessoaFotosCollectionNew = attachedPessoaFotosCollectionNew;
            pessoa.setPessoaFotosCollection(pessoaFotosCollectionNew);
            Collection<PessoaDocumentos> attachedPessoaDocumentosCollectionNew = new ArrayList<PessoaDocumentos>();
            for (PessoaDocumentos pessoaDocumentosCollectionNewPessoaDocumentosToAttach : pessoaDocumentosCollectionNew) {
                pessoaDocumentosCollectionNewPessoaDocumentosToAttach = em.getReference(pessoaDocumentosCollectionNewPessoaDocumentosToAttach.getClass(), pessoaDocumentosCollectionNewPessoaDocumentosToAttach.getId());
                attachedPessoaDocumentosCollectionNew.add(pessoaDocumentosCollectionNewPessoaDocumentosToAttach);
            }
            pessoaDocumentosCollectionNew = attachedPessoaDocumentosCollectionNew;
            pessoa.setPessoaDocumentosCollection(pessoaDocumentosCollectionNew);
            Collection<PessoaOperadores> attachedPessoaOperadoresCollectionNew = new ArrayList<PessoaOperadores>();
            for (PessoaOperadores pessoaOperadoresCollectionNewPessoaOperadoresToAttach : pessoaOperadoresCollectionNew) {
                pessoaOperadoresCollectionNewPessoaOperadoresToAttach = em.getReference(pessoaOperadoresCollectionNewPessoaOperadoresToAttach.getClass(), pessoaOperadoresCollectionNewPessoaOperadoresToAttach.getId());
                attachedPessoaOperadoresCollectionNew.add(pessoaOperadoresCollectionNewPessoaOperadoresToAttach);
            }
            pessoaOperadoresCollectionNew = attachedPessoaOperadoresCollectionNew;
            pessoa.setPessoaOperadoresCollection(pessoaOperadoresCollectionNew);
            Collection<Enderecos> attachedEnderecosCollectionNew = new ArrayList<Enderecos>();
            for (Enderecos enderecosCollectionNewEnderecosToAttach : enderecosCollectionNew) {
                enderecosCollectionNewEnderecosToAttach = em.getReference(enderecosCollectionNewEnderecosToAttach.getClass(), enderecosCollectionNewEnderecosToAttach.getId());
                attachedEnderecosCollectionNew.add(enderecosCollectionNewEnderecosToAttach);
            }
            enderecosCollectionNew = attachedEnderecosCollectionNew;
            pessoa.setEnderecosCollection(enderecosCollectionNew);
            Collection<PessoaDocumentosHabilitacao> attachedPessoaDocumentosHabilitacaoCollectionNew = new ArrayList<PessoaDocumentosHabilitacao>();
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach : pessoaDocumentosHabilitacaoCollectionNew) {
                pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach = em.getReference(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach.getClass(), pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach.getId());
                attachedPessoaDocumentosHabilitacaoCollectionNew.add(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacaoToAttach);
            }
            pessoaDocumentosHabilitacaoCollectionNew = attachedPessoaDocumentosHabilitacaoCollectionNew;
            pessoa.setPessoaDocumentosHabilitacaoCollection(pessoaDocumentosHabilitacaoCollectionNew);
            Collection<PessoaDocumentosCtps> attachedPessoaDocumentosCtpsCollectionNew = new ArrayList<PessoaDocumentosCtps>();
            for (PessoaDocumentosCtps pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtpsToAttach : pessoaDocumentosCtpsCollectionNew) {
                pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtpsToAttach = em.getReference(pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtpsToAttach.getClass(), pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtpsToAttach.getId());
                attachedPessoaDocumentosCtpsCollectionNew.add(pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtpsToAttach);
            }
            pessoaDocumentosCtpsCollectionNew = attachedPessoaDocumentosCtpsCollectionNew;
            pessoa.setPessoaDocumentosCtpsCollection(pessoaDocumentosCtpsCollectionNew);
            Collection<PessoaBancos> attachedPessoaBancosCollectionNew = new ArrayList<PessoaBancos>();
            for (PessoaBancos pessoaBancosCollectionNewPessoaBancosToAttach : pessoaBancosCollectionNew) {
                pessoaBancosCollectionNewPessoaBancosToAttach = em.getReference(pessoaBancosCollectionNewPessoaBancosToAttach.getClass(), pessoaBancosCollectionNewPessoaBancosToAttach.getId());
                attachedPessoaBancosCollectionNew.add(pessoaBancosCollectionNewPessoaBancosToAttach);
            }
            pessoaBancosCollectionNew = attachedPessoaBancosCollectionNew;
            pessoa.setPessoaBancosCollection(pessoaBancosCollectionNew);
            Collection<HistUnidadesDiretor> attachedHistUnidadesDiretorCollectionNew = new ArrayList<HistUnidadesDiretor>();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach : histUnidadesDiretorCollectionNew) {
                histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach = em.getReference(histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach.getClass(), histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach.getHistUnidadesDiretorPK());
                attachedHistUnidadesDiretorCollectionNew.add(histUnidadesDiretorCollectionNewHistUnidadesDiretorToAttach);
            }
            histUnidadesDiretorCollectionNew = attachedHistUnidadesDiretorCollectionNew;
            pessoa.setHistUnidadesDiretorCollection(histUnidadesDiretorCollectionNew);
            Collection<PessoaFuncionarios> attachedPessoaFuncionariosCollectionNew = new ArrayList<PessoaFuncionarios>();
            for (PessoaFuncionarios pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach : pessoaFuncionariosCollectionNew) {
                pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach = em.getReference(pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach.getClass(), pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach.getId());
                attachedPessoaFuncionariosCollectionNew.add(pessoaFuncionariosCollectionNewPessoaFuncionariosToAttach);
            }
            pessoaFuncionariosCollectionNew = attachedPessoaFuncionariosCollectionNew;
            pessoa.setPessoaFuncionariosCollection(pessoaFuncionariosCollectionNew);
            Collection<PessoaDocumentosTitulo> attachedPessoaDocumentosTituloCollectionNew = new ArrayList<PessoaDocumentosTitulo>();
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach : pessoaDocumentosTituloCollectionNew) {
                pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach = em.getReference(pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach.getClass(), pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach.getId());
                attachedPessoaDocumentosTituloCollectionNew.add(pessoaDocumentosTituloCollectionNewPessoaDocumentosTituloToAttach);
            }
            pessoaDocumentosTituloCollectionNew = attachedPessoaDocumentosTituloCollectionNew;
            pessoa.setPessoaDocumentosTituloCollection(pessoaDocumentosTituloCollectionNew);
            pessoa = em.merge(pessoa);
            if (seqCidadeNatalOld != null && !seqCidadeNatalOld.equals(seqCidadeNatalNew)) {
                seqCidadeNatalOld.getPessoaCollection().remove(pessoa);
                seqCidadeNatalOld = em.merge(seqCidadeNatalOld);
            }
            if (seqCidadeNatalNew != null && !seqCidadeNatalNew.equals(seqCidadeNatalOld)) {
                seqCidadeNatalNew.getPessoaCollection().add(pessoa);
                seqCidadeNatalNew = em.merge(seqCidadeNatalNew);
            }
            if (seqEnderecoNew != null && !seqEnderecoNew.equals(seqEnderecoOld)) {
                Pessoa oldIdPessoaFkOfSeqEndereco = seqEnderecoNew.getIdPessoaFk();
                if (oldIdPessoaFkOfSeqEndereco != null) {
                    oldIdPessoaFkOfSeqEndereco.setSeqEndereco(null);
                    oldIdPessoaFkOfSeqEndereco = em.merge(oldIdPessoaFkOfSeqEndereco);
                }
                seqEnderecoNew.setIdPessoaFk(pessoa);
                seqEnderecoNew = em.merge(seqEnderecoNew);
            }
            if (seqEscolaridadeOld != null && !seqEscolaridadeOld.equals(seqEscolaridadeNew)) {
                seqEscolaridadeOld.getPessoaCollection().remove(pessoa);
                seqEscolaridadeOld = em.merge(seqEscolaridadeOld);
            }
            if (seqEscolaridadeNew != null && !seqEscolaridadeNew.equals(seqEscolaridadeOld)) {
                seqEscolaridadeNew.getPessoaCollection().add(pessoa);
                seqEscolaridadeNew = em.merge(seqEscolaridadeNew);
            }
            if (seqEstadoCivilOld != null && !seqEstadoCivilOld.equals(seqEstadoCivilNew)) {
                seqEstadoCivilOld.getPessoaCollection().remove(pessoa);
                seqEstadoCivilOld = em.merge(seqEstadoCivilOld);
            }
            if (seqEstadoCivilNew != null && !seqEstadoCivilNew.equals(seqEstadoCivilOld)) {
                seqEstadoCivilNew.getPessoaCollection().add(pessoa);
                seqEstadoCivilNew = em.merge(seqEstadoCivilNew);
            }
            if (seqOperadorCadastroNew != null && !seqOperadorCadastroNew.equals(seqOperadorCadastroOld)) {
                Pessoa oldIdPessoaFkOfSeqOperadorCadastro = seqOperadorCadastroNew.getIdPessoaFk();
                if (oldIdPessoaFkOfSeqOperadorCadastro != null) {
                    oldIdPessoaFkOfSeqOperadorCadastro.setSeqOperadorCadastro(null);
                    oldIdPessoaFkOfSeqOperadorCadastro = em.merge(oldIdPessoaFkOfSeqOperadorCadastro);
                }
                seqOperadorCadastroNew.setIdPessoaFk(pessoa);
                seqOperadorCadastroNew = em.merge(seqOperadorCadastroNew);
            }
            if (seqOperadorCancelamentoNew != null && !seqOperadorCancelamentoNew.equals(seqOperadorCancelamentoOld)) {
                Pessoa oldIdPessoaFkOfSeqOperadorCancelamento = seqOperadorCancelamentoNew.getIdPessoaFk();
                if (oldIdPessoaFkOfSeqOperadorCancelamento != null) {
                    oldIdPessoaFkOfSeqOperadorCancelamento.setSeqOperadorCancelamento(null);
                    oldIdPessoaFkOfSeqOperadorCancelamento = em.merge(oldIdPessoaFkOfSeqOperadorCancelamento);
                }
                seqOperadorCancelamentoNew.setIdPessoaFk(pessoa);
                seqOperadorCancelamentoNew = em.merge(seqOperadorCancelamentoNew);
            }
            if (seqSexoDeclaradoOld != null && !seqSexoDeclaradoOld.equals(seqSexoDeclaradoNew)) {
                seqSexoDeclaradoOld.getPessoaCollection().remove(pessoa);
                seqSexoDeclaradoOld = em.merge(seqSexoDeclaradoOld);
            }
            if (seqSexoDeclaradoNew != null && !seqSexoDeclaradoNew.equals(seqSexoDeclaradoOld)) {
                seqSexoDeclaradoNew.getPessoaCollection().add(pessoa);
                seqSexoDeclaradoNew = em.merge(seqSexoDeclaradoNew);
            }
            if (seqSexoOld != null && !seqSexoOld.equals(seqSexoNew)) {
                seqSexoOld.getPessoaCollection().remove(pessoa);
                seqSexoOld = em.merge(seqSexoOld);
            }
            if (seqSexoNew != null && !seqSexoNew.equals(seqSexoOld)) {
                seqSexoNew.getPessoaCollection().add(pessoa);
                seqSexoNew = em.merge(seqSexoNew);
            }
            for (PessoaFilhos pessoaFilhosCollectionNewPessoaFilhos : pessoaFilhosCollectionNew) {
                if (!pessoaFilhosCollectionOld.contains(pessoaFilhosCollectionNewPessoaFilhos)) {
                    Pessoa oldIdPessoaFkOfPessoaFilhosCollectionNewPessoaFilhos = pessoaFilhosCollectionNewPessoaFilhos.getIdPessoaFk();
                    pessoaFilhosCollectionNewPessoaFilhos.setIdPessoaFk(pessoa);
                    pessoaFilhosCollectionNewPessoaFilhos = em.merge(pessoaFilhosCollectionNewPessoaFilhos);
                    if (oldIdPessoaFkOfPessoaFilhosCollectionNewPessoaFilhos != null && !oldIdPessoaFkOfPessoaFilhosCollectionNewPessoaFilhos.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaFilhosCollectionNewPessoaFilhos.getPessoaFilhosCollection().remove(pessoaFilhosCollectionNewPessoaFilhos);
                        oldIdPessoaFkOfPessoaFilhosCollectionNewPessoaFilhos = em.merge(oldIdPessoaFkOfPessoaFilhosCollectionNewPessoaFilhos);
                    }
                }
            }
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho : pessoaDocumentosConselhoCollectionNew) {
                if (!pessoaDocumentosConselhoCollectionOld.contains(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho)) {
                    Pessoa oldIdPessoaFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.getIdPessoaFk();
                    pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.setIdPessoaFk(pessoa);
                    pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = em.merge(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                    if (oldIdPessoaFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho != null && !oldIdPessoaFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho.getPessoaDocumentosConselhoCollection().remove(pessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                        oldIdPessoaFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho = em.merge(oldIdPessoaFkOfPessoaDocumentosConselhoCollectionNewPessoaDocumentosConselho);
                    }
                }
            }
            for (PessoaDocumentosReservista pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista : pessoaDocumentosReservistaCollectionNew) {
                if (!pessoaDocumentosReservistaCollectionOld.contains(pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista)) {
                    Pessoa oldIdPessoaFkOfPessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista = pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista.getIdPessoaFk();
                    pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista.setIdPessoaFk(pessoa);
                    pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista = em.merge(pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista);
                    if (oldIdPessoaFkOfPessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista != null && !oldIdPessoaFkOfPessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista.getPessoaDocumentosReservistaCollection().remove(pessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista);
                        oldIdPessoaFkOfPessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista = em.merge(oldIdPessoaFkOfPessoaDocumentosReservistaCollectionNewPessoaDocumentosReservista);
                    }
                }
            }
            for (PessoaFotos pessoaFotosCollectionNewPessoaFotos : pessoaFotosCollectionNew) {
                if (!pessoaFotosCollectionOld.contains(pessoaFotosCollectionNewPessoaFotos)) {
                    Pessoa oldIdPessoaFkOfPessoaFotosCollectionNewPessoaFotos = pessoaFotosCollectionNewPessoaFotos.getIdPessoaFk();
                    pessoaFotosCollectionNewPessoaFotos.setIdPessoaFk(pessoa);
                    pessoaFotosCollectionNewPessoaFotos = em.merge(pessoaFotosCollectionNewPessoaFotos);
                    if (oldIdPessoaFkOfPessoaFotosCollectionNewPessoaFotos != null && !oldIdPessoaFkOfPessoaFotosCollectionNewPessoaFotos.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaFotosCollectionNewPessoaFotos.getPessoaFotosCollection().remove(pessoaFotosCollectionNewPessoaFotos);
                        oldIdPessoaFkOfPessoaFotosCollectionNewPessoaFotos = em.merge(oldIdPessoaFkOfPessoaFotosCollectionNewPessoaFotos);
                    }
                }
            }
            for (PessoaDocumentos pessoaDocumentosCollectionOldPessoaDocumentos : pessoaDocumentosCollectionOld) {
                if (!pessoaDocumentosCollectionNew.contains(pessoaDocumentosCollectionOldPessoaDocumentos)) {
                    pessoaDocumentosCollectionOldPessoaDocumentos.setIdPessoaFk(null);
                    pessoaDocumentosCollectionOldPessoaDocumentos = em.merge(pessoaDocumentosCollectionOldPessoaDocumentos);
                }
            }
            for (PessoaDocumentos pessoaDocumentosCollectionNewPessoaDocumentos : pessoaDocumentosCollectionNew) {
                if (!pessoaDocumentosCollectionOld.contains(pessoaDocumentosCollectionNewPessoaDocumentos)) {
                    Pessoa oldIdPessoaFkOfPessoaDocumentosCollectionNewPessoaDocumentos = pessoaDocumentosCollectionNewPessoaDocumentos.getIdPessoaFk();
                    pessoaDocumentosCollectionNewPessoaDocumentos.setIdPessoaFk(pessoa);
                    pessoaDocumentosCollectionNewPessoaDocumentos = em.merge(pessoaDocumentosCollectionNewPessoaDocumentos);
                    if (oldIdPessoaFkOfPessoaDocumentosCollectionNewPessoaDocumentos != null && !oldIdPessoaFkOfPessoaDocumentosCollectionNewPessoaDocumentos.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaDocumentosCollectionNewPessoaDocumentos.getPessoaDocumentosCollection().remove(pessoaDocumentosCollectionNewPessoaDocumentos);
                        oldIdPessoaFkOfPessoaDocumentosCollectionNewPessoaDocumentos = em.merge(oldIdPessoaFkOfPessoaDocumentosCollectionNewPessoaDocumentos);
                    }
                }
            }
            for (PessoaOperadores pessoaOperadoresCollectionNewPessoaOperadores : pessoaOperadoresCollectionNew) {
                if (!pessoaOperadoresCollectionOld.contains(pessoaOperadoresCollectionNewPessoaOperadores)) {
                    Pessoa oldIdPessoaFkOfPessoaOperadoresCollectionNewPessoaOperadores = pessoaOperadoresCollectionNewPessoaOperadores.getIdPessoaFk();
                    pessoaOperadoresCollectionNewPessoaOperadores.setIdPessoaFk(pessoa);
                    pessoaOperadoresCollectionNewPessoaOperadores = em.merge(pessoaOperadoresCollectionNewPessoaOperadores);
                    if (oldIdPessoaFkOfPessoaOperadoresCollectionNewPessoaOperadores != null && !oldIdPessoaFkOfPessoaOperadoresCollectionNewPessoaOperadores.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaOperadoresCollectionNewPessoaOperadores.getPessoaOperadoresCollection().remove(pessoaOperadoresCollectionNewPessoaOperadores);
                        oldIdPessoaFkOfPessoaOperadoresCollectionNewPessoaOperadores = em.merge(oldIdPessoaFkOfPessoaOperadoresCollectionNewPessoaOperadores);
                    }
                }
            }
            for (Enderecos enderecosCollectionNewEnderecos : enderecosCollectionNew) {
                if (!enderecosCollectionOld.contains(enderecosCollectionNewEnderecos)) {
                    Pessoa oldIdPessoaFkOfEnderecosCollectionNewEnderecos = enderecosCollectionNewEnderecos.getIdPessoaFk();
                    enderecosCollectionNewEnderecos.setIdPessoaFk(pessoa);
                    enderecosCollectionNewEnderecos = em.merge(enderecosCollectionNewEnderecos);
                    if (oldIdPessoaFkOfEnderecosCollectionNewEnderecos != null && !oldIdPessoaFkOfEnderecosCollectionNewEnderecos.equals(pessoa)) {
                        oldIdPessoaFkOfEnderecosCollectionNewEnderecos.getEnderecosCollection().remove(enderecosCollectionNewEnderecos);
                        oldIdPessoaFkOfEnderecosCollectionNewEnderecos = em.merge(oldIdPessoaFkOfEnderecosCollectionNewEnderecos);
                    }
                }
            }
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao : pessoaDocumentosHabilitacaoCollectionOld) {
                if (!pessoaDocumentosHabilitacaoCollectionNew.contains(pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao)) {
                    pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao.setIdPessoaFk(null);
                    pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacaoCollectionOldPessoaDocumentosHabilitacao);
                }
            }
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao : pessoaDocumentosHabilitacaoCollectionNew) {
                if (!pessoaDocumentosHabilitacaoCollectionOld.contains(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao)) {
                    Pessoa oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao = pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao.getIdPessoaFk();
                    pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao.setIdPessoaFk(pessoa);
                    pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao);
                    if (oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao != null && !oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao.getPessoaDocumentosHabilitacaoCollection().remove(pessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao);
                        oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao = em.merge(oldIdPessoaFkOfPessoaDocumentosHabilitacaoCollectionNewPessoaDocumentosHabilitacao);
                    }
                }
            }
            for (PessoaDocumentosCtps pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps : pessoaDocumentosCtpsCollectionNew) {
                if (!pessoaDocumentosCtpsCollectionOld.contains(pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps)) {
                    Pessoa oldIdPessoaFkOfPessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps = pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps.getIdPessoaFk();
                    pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps.setIdPessoaFk(pessoa);
                    pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps = em.merge(pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps);
                    if (oldIdPessoaFkOfPessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps != null && !oldIdPessoaFkOfPessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps.getPessoaDocumentosCtpsCollection().remove(pessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps);
                        oldIdPessoaFkOfPessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps = em.merge(oldIdPessoaFkOfPessoaDocumentosCtpsCollectionNewPessoaDocumentosCtps);
                    }
                }
            }
            for (PessoaBancos pessoaBancosCollectionNewPessoaBancos : pessoaBancosCollectionNew) {
                if (!pessoaBancosCollectionOld.contains(pessoaBancosCollectionNewPessoaBancos)) {
                    Pessoa oldIdPessoaFkOfPessoaBancosCollectionNewPessoaBancos = pessoaBancosCollectionNewPessoaBancos.getIdPessoaFk();
                    pessoaBancosCollectionNewPessoaBancos.setIdPessoaFk(pessoa);
                    pessoaBancosCollectionNewPessoaBancos = em.merge(pessoaBancosCollectionNewPessoaBancos);
                    if (oldIdPessoaFkOfPessoaBancosCollectionNewPessoaBancos != null && !oldIdPessoaFkOfPessoaBancosCollectionNewPessoaBancos.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaBancosCollectionNewPessoaBancos.getPessoaBancosCollection().remove(pessoaBancosCollectionNewPessoaBancos);
                        oldIdPessoaFkOfPessoaBancosCollectionNewPessoaBancos = em.merge(oldIdPessoaFkOfPessoaBancosCollectionNewPessoaBancos);
                    }
                }
            }
            for (HistUnidadesDiretor histUnidadesDiretorCollectionNewHistUnidadesDiretor : histUnidadesDiretorCollectionNew) {
                if (!histUnidadesDiretorCollectionOld.contains(histUnidadesDiretorCollectionNewHistUnidadesDiretor)) {
                    Pessoa oldPessoaOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor = histUnidadesDiretorCollectionNewHistUnidadesDiretor.getPessoa();
                    histUnidadesDiretorCollectionNewHistUnidadesDiretor.setPessoa(pessoa);
                    histUnidadesDiretorCollectionNewHistUnidadesDiretor = em.merge(histUnidadesDiretorCollectionNewHistUnidadesDiretor);
                    if (oldPessoaOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor != null && !oldPessoaOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor.equals(pessoa)) {
                        oldPessoaOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor.getHistUnidadesDiretorCollection().remove(histUnidadesDiretorCollectionNewHistUnidadesDiretor);
                        oldPessoaOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor = em.merge(oldPessoaOfHistUnidadesDiretorCollectionNewHistUnidadesDiretor);
                    }
                }
            }
            for (PessoaFuncionarios pessoaFuncionariosCollectionNewPessoaFuncionarios : pessoaFuncionariosCollectionNew) {
                if (!pessoaFuncionariosCollectionOld.contains(pessoaFuncionariosCollectionNewPessoaFuncionarios)) {
                    Pessoa oldIdPessoaFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios = pessoaFuncionariosCollectionNewPessoaFuncionarios.getIdPessoaFk();
                    pessoaFuncionariosCollectionNewPessoaFuncionarios.setIdPessoaFk(pessoa);
                    pessoaFuncionariosCollectionNewPessoaFuncionarios = em.merge(pessoaFuncionariosCollectionNewPessoaFuncionarios);
                    if (oldIdPessoaFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios != null && !oldIdPessoaFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios.getPessoaFuncionariosCollection().remove(pessoaFuncionariosCollectionNewPessoaFuncionarios);
                        oldIdPessoaFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios = em.merge(oldIdPessoaFkOfPessoaFuncionariosCollectionNewPessoaFuncionarios);
                    }
                }
            }
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo : pessoaDocumentosTituloCollectionNew) {
                if (!pessoaDocumentosTituloCollectionOld.contains(pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo)) {
                    Pessoa oldIdPessoaFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo = pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo.getIdPessoaFk();
                    pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo.setIdPessoaFk(pessoa);
                    pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo = em.merge(pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo);
                    if (oldIdPessoaFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo != null && !oldIdPessoaFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo.equals(pessoa)) {
                        oldIdPessoaFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo.getPessoaDocumentosTituloCollection().remove(pessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo);
                        oldIdPessoaFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo = em.merge(oldIdPessoaFkOfPessoaDocumentosTituloCollectionNewPessoaDocumentosTitulo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoa.getId();
                if (findPessoa(id) == null) {
                    throw new NonexistentEntityException("The pessoa with id " + id + " no longer exists.");
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
            Pessoa pessoa;
            try {
                pessoa = em.getReference(Pessoa.class, id);
                pessoa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Enderecos seqEnderecoOrphanCheck = pessoa.getSeqEndereco();
            if (seqEnderecoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the Enderecos " + seqEnderecoOrphanCheck + " in its seqEndereco field has a non-nullable idPessoaFk field.");
            }
            PessoaOperadores seqOperadorCadastroOrphanCheck = pessoa.getSeqOperadorCadastro();
            if (seqOperadorCadastroOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaOperadores " + seqOperadorCadastroOrphanCheck + " in its seqOperadorCadastro field has a non-nullable idPessoaFk field.");
            }
            PessoaOperadores seqOperadorCancelamentoOrphanCheck = pessoa.getSeqOperadorCancelamento();
            if (seqOperadorCancelamentoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaOperadores " + seqOperadorCancelamentoOrphanCheck + " in its seqOperadorCancelamento field has a non-nullable idPessoaFk field.");
            }
            Collection<PessoaFilhos> pessoaFilhosCollectionOrphanCheck = pessoa.getPessoaFilhosCollection();
            for (PessoaFilhos pessoaFilhosCollectionOrphanCheckPessoaFilhos : pessoaFilhosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaFilhos " + pessoaFilhosCollectionOrphanCheckPessoaFilhos + " in its pessoaFilhosCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<PessoaDocumentosConselho> pessoaDocumentosConselhoCollectionOrphanCheck = pessoa.getPessoaDocumentosConselhoCollection();
            for (PessoaDocumentosConselho pessoaDocumentosConselhoCollectionOrphanCheckPessoaDocumentosConselho : pessoaDocumentosConselhoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaDocumentosConselho " + pessoaDocumentosConselhoCollectionOrphanCheckPessoaDocumentosConselho + " in its pessoaDocumentosConselhoCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<PessoaDocumentosReservista> pessoaDocumentosReservistaCollectionOrphanCheck = pessoa.getPessoaDocumentosReservistaCollection();
            for (PessoaDocumentosReservista pessoaDocumentosReservistaCollectionOrphanCheckPessoaDocumentosReservista : pessoaDocumentosReservistaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaDocumentosReservista " + pessoaDocumentosReservistaCollectionOrphanCheckPessoaDocumentosReservista + " in its pessoaDocumentosReservistaCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<PessoaFotos> pessoaFotosCollectionOrphanCheck = pessoa.getPessoaFotosCollection();
            for (PessoaFotos pessoaFotosCollectionOrphanCheckPessoaFotos : pessoaFotosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaFotos " + pessoaFotosCollectionOrphanCheckPessoaFotos + " in its pessoaFotosCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<PessoaOperadores> pessoaOperadoresCollectionOrphanCheck = pessoa.getPessoaOperadoresCollection();
            for (PessoaOperadores pessoaOperadoresCollectionOrphanCheckPessoaOperadores : pessoaOperadoresCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaOperadores " + pessoaOperadoresCollectionOrphanCheckPessoaOperadores + " in its pessoaOperadoresCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<Enderecos> enderecosCollectionOrphanCheck = pessoa.getEnderecosCollection();
            for (Enderecos enderecosCollectionOrphanCheckEnderecos : enderecosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the Enderecos " + enderecosCollectionOrphanCheckEnderecos + " in its enderecosCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<PessoaDocumentosCtps> pessoaDocumentosCtpsCollectionOrphanCheck = pessoa.getPessoaDocumentosCtpsCollection();
            for (PessoaDocumentosCtps pessoaDocumentosCtpsCollectionOrphanCheckPessoaDocumentosCtps : pessoaDocumentosCtpsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaDocumentosCtps " + pessoaDocumentosCtpsCollectionOrphanCheckPessoaDocumentosCtps + " in its pessoaDocumentosCtpsCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<PessoaBancos> pessoaBancosCollectionOrphanCheck = pessoa.getPessoaBancosCollection();
            for (PessoaBancos pessoaBancosCollectionOrphanCheckPessoaBancos : pessoaBancosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaBancos " + pessoaBancosCollectionOrphanCheckPessoaBancos + " in its pessoaBancosCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<HistUnidadesDiretor> histUnidadesDiretorCollectionOrphanCheck = pessoa.getHistUnidadesDiretorCollection();
            for (HistUnidadesDiretor histUnidadesDiretorCollectionOrphanCheckHistUnidadesDiretor : histUnidadesDiretorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the HistUnidadesDiretor " + histUnidadesDiretorCollectionOrphanCheckHistUnidadesDiretor + " in its histUnidadesDiretorCollection field has a non-nullable pessoa field.");
            }
            Collection<PessoaFuncionarios> pessoaFuncionariosCollectionOrphanCheck = pessoa.getPessoaFuncionariosCollection();
            for (PessoaFuncionarios pessoaFuncionariosCollectionOrphanCheckPessoaFuncionarios : pessoaFuncionariosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaFuncionarios " + pessoaFuncionariosCollectionOrphanCheckPessoaFuncionarios + " in its pessoaFuncionariosCollection field has a non-nullable idPessoaFk field.");
            }
            Collection<PessoaDocumentosTitulo> pessoaDocumentosTituloCollectionOrphanCheck = pessoa.getPessoaDocumentosTituloCollection();
            for (PessoaDocumentosTitulo pessoaDocumentosTituloCollectionOrphanCheckPessoaDocumentosTitulo : pessoaDocumentosTituloCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the PessoaDocumentosTitulo " + pessoaDocumentosTituloCollectionOrphanCheckPessoaDocumentosTitulo + " in its pessoaDocumentosTituloCollection field has a non-nullable idPessoaFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cidades seqCidadeNatal = pessoa.getSeqCidadeNatal();
            if (seqCidadeNatal != null) {
                seqCidadeNatal.getPessoaCollection().remove(pessoa);
                seqCidadeNatal = em.merge(seqCidadeNatal);
            }
            Escolaridades seqEscolaridade = pessoa.getSeqEscolaridade();
            if (seqEscolaridade != null) {
                seqEscolaridade.getPessoaCollection().remove(pessoa);
                seqEscolaridade = em.merge(seqEscolaridade);
            }
            EstadosCivis seqEstadoCivil = pessoa.getSeqEstadoCivil();
            if (seqEstadoCivil != null) {
                seqEstadoCivil.getPessoaCollection().remove(pessoa);
                seqEstadoCivil = em.merge(seqEstadoCivil);
            }
            Sexos seqSexoDeclarado = pessoa.getSeqSexoDeclarado();
            if (seqSexoDeclarado != null) {
                seqSexoDeclarado.getPessoaCollection().remove(pessoa);
                seqSexoDeclarado = em.merge(seqSexoDeclarado);
            }
            Sexos seqSexo = pessoa.getSeqSexo();
            if (seqSexo != null) {
                seqSexo.getPessoaCollection().remove(pessoa);
                seqSexo = em.merge(seqSexo);
            }
            Collection<PessoaDocumentos> pessoaDocumentosCollection = pessoa.getPessoaDocumentosCollection();
            for (PessoaDocumentos pessoaDocumentosCollectionPessoaDocumentos : pessoaDocumentosCollection) {
                pessoaDocumentosCollectionPessoaDocumentos.setIdPessoaFk(null);
                pessoaDocumentosCollectionPessoaDocumentos = em.merge(pessoaDocumentosCollectionPessoaDocumentos);
            }
            Collection<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollection = pessoa.getPessoaDocumentosHabilitacaoCollection();
            for (PessoaDocumentosHabilitacao pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao : pessoaDocumentosHabilitacaoCollection) {
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao.setIdPessoaFk(null);
                pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao = em.merge(pessoaDocumentosHabilitacaoCollectionPessoaDocumentosHabilitacao);
            }
            em.remove(pessoa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pessoa> findPessoaEntities() {
        return findPessoaEntities(true, -1, -1);
    }

    public List<Pessoa> findPessoaEntities(int maxResults, int firstResult) {
        return findPessoaEntities(false, maxResults, firstResult);
    }

    private List<Pessoa> findPessoaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pessoa.class));
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

    public Pessoa findPessoa(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pessoa.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pessoa> rt = cq.from(Pessoa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
