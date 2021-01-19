/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.pessoas;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.pessoas.bean.BeanCadastroPessoas;
import br.com.folha.model.cadastro.pessoas.bean.BeanEnderecoPessoa;
import br.com.folha.model.cadastro.pessoas.dao.DaoConsultaCadastroPessoas;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.view.cadastro.pessoas.TelaConsultaCadastroPessoas;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleContultaCadastroPessoas {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
        
    TelaConsultaCadastroPessoas telaConsultaCadastroPessoas;
    BeanCadastroPessoas beanCadastroPessoas = new BeanCadastroPessoas();
    BeanEnderecoPessoa beanEnderecoPessoa = new BeanEnderecoPessoa();
    
    DaoConsultaCadastroPessoas daoConsultaCadastroPessoas = new DaoConsultaCadastroPessoas();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    
    // para colocar os paises no combo
    List<BeanSequenciaTexto> listaPaises;
    
    // para colocar os dados cadastrados na tabela1
    List<BeanCadastroPessoas> listaDadosjTable1;
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        telaConsultaCadastroPessoas  = new TelaConsultaCadastroPessoas(this,beanCadastroPessoas);
        telaConsultaCadastroPessoas.setVisible(true);
    }
    
    public void abrirFrameCadastroPessoas(){
        ControleCadastroPessoas cp = new ControleCadastroPessoas();
        cp.abrirFrame(controlePrincipal, beanPrincipal, beanCadastroPessoas, beanEnderecoPessoa);
    }
    
    public void indicaPessoaAAlterar(int linhaJTable1){
        beanCadastroPessoas.setSeqPessoa(listaDadosjTable1.get(linhaJTable1).getSeqPessoa());
        beanCadastroPessoas.setCpfPessoa(listaDadosjTable1.get(linhaJTable1).getCpfPessoa());
        beanCadastroPessoas.setNomePessoa(listaDadosjTable1.get(linhaJTable1).getNomePessoa());
    }
    
    public boolean cadastrar(String cpfPessoa, String nomePessoa){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        cpfPessoa = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cpfPessoa);
        nomePessoa = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomePessoa);
        
        
        //conferindo se os campos obrigatórios foram preenchidos
        if(cpfPessoa.length()<11){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um cpf válido.");}
        if(nomePessoa.length()<3){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever um nome válido.");}
        
        //Validando CPF
        if(acaoValida==true){
            boolean cpfValido = utilidadesDeTexto.validaCpf(cpfPessoa.substring(0,1), cpfPessoa.substring(1,2), cpfPessoa.substring(2,3), cpfPessoa.substring(3,4), cpfPessoa.substring(4,5), cpfPessoa.substring(5,6), cpfPessoa.substring(6,7), cpfPessoa.substring(7,8), cpfPessoa.substring(8,9), cpfPessoa.substring(9,10), cpfPessoa.substring(10,11)); 
            if(cpfValido == false){acaoValida = false; JOptionPane.showMessageDialog(null, "CPF inválido.");}
        }
        
        boolean cpfJaCadastrado = daoConsultaCadastroPessoas.cpfPessoaCadastrado(cpfPessoa);
        if(cpfJaCadastrado==true){acaoValida = false; JOptionPane.showMessageDialog(null, "CPF já cadastrado. Se você estiver tentando alterar um cadastro já existente, escolha a linha correspondente à pessoa na tabela.");}
        
        if(acaoValida==true){
            beanCadastroPessoas.setSeqPessoa(0);
            beanCadastroPessoas.setCpfPessoa(cpfPessoa);
            beanCadastroPessoas.setNomePessoa(nomePessoa);
            executou = daoConsultaCadastroPessoas.inserirPessoa(beanCadastroPessoas, beanPrincipal);
            if(executou==true){  beanCadastroPessoas.setSeqPessoa(daoConsultaCadastroPessoas.selecionarSeqPessoaPorCpf(beanCadastroPessoas.getCpfPessoa()));}
            telaConsultaCadastroPessoas.preencherJtable1d(this.selecionarPorCpf(beanCadastroPessoas.getCpfPessoa()));
        }
        return executou;
    }
    
    public boolean excluir(int linhajTable1, String motivo){
        boolean executou = false;
        boolean acaoValida = true;
        
        motivo = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivo);
        if(motivo.length()<5){acaoValida=false; JOptionPane.showMessageDialog(null, "Informe um motivo válido.");}
        
        
        if(acaoValida==true){
            beanCadastroPessoas.setSeqPessoa(listaDadosjTable1.get(linhajTable1).getSeqPessoa());
            executou =daoConsultaCadastroPessoas.excluirPessoa(beanCadastroPessoas, beanPrincipal, motivo);
            telaConsultaCadastroPessoas.preencherJtable1d(this.selecionarPorNome(""));
        }
        return executou;
    }
    
    
    public List<BeanCadastroPessoas> selecionarPorNome(String consulta){
        boolean acaoValida = true;
        List dados = null;
        consulta = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(consulta);
        
        if( (consulta.contains("0")) || (consulta.contains("1")) || (consulta.contains("2")) || (consulta.contains("3")) || (consulta.contains("4")) || (consulta.contains("5")) || (consulta.contains("6")) || (consulta.contains("7")) || (consulta.contains("8")) || (consulta.contains("9")) ){
            acaoValida = false; JOptionPane.showMessageDialog(null, "Você escreveu número(s) para uma pesquisa por NOME. Não será pesquisado.");
        }
        // Avaliando se tem números na consulta por nome
        if(acaoValida==true){
            dados =daoConsultaCadastroPessoas.selecionarPessoaPorNome(consulta);
            listaDadosjTable1 = dados;
        }
        return dados;
    }
    
    public List<BeanCadastroPessoas> selecionarPorCpf(String consulta){
        consulta = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(consulta);
        List dados =daoConsultaCadastroPessoas.selecionarPessoaPorCpf(consulta);
        listaDadosjTable1 = dados;
        return dados;
    }
    
    
    
}