/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.pessoas;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.pessoas.bean.BeanCadastroPessoas;
import br.com.folha.model.cadastro.pessoas.bean.BeanEnderecoPessoa;
import br.com.folha.model.cadastro.pessoas.bean.BeanWebServiceCep;
import br.com.folha.model.cadastro.pessoas.dao.DaoCadastroPessoas;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.util.UtilidadesDistintas;
import br.com.folha.util.WebServiceCep;
import br.com.folha.view.cadastro.pessoas.TelaCadastroPessoas;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author André Rocha
 */
public class ControleCadastroPessoas {
    
    ControlePrincipal controlePrincipal; 
    BeanPrincipal beanPrincipal; 
    
    TelaCadastroPessoas telaCadastroPessoas;
    BeanCadastroPessoas beanCadastroPessoas = new BeanCadastroPessoas();
    BeanEnderecoPessoa beanEnderecoPessoa = new BeanEnderecoPessoa();
    
    BeanWebServiceCep beanWebServiceCep = new BeanWebServiceCep();
    
    
    DaoCadastroPessoas daoCadastroPessoas = new DaoCadastroPessoas();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    UtilidadesDistintas utilidadesDistintas = new UtilidadesDistintas();
    
    // para colocar os Tipos de Logradouro no combo
    List<BeanSequenciaTexto> listaTiposDeLogradouro;
    
    // para colocar os Tipos de Logradouro no combo
    List<BeanCadastroCidades> listaCidades;
    
    // para colocar os dados cadastrados na tabela1
    List<BeanEnderecoPessoa> listaDadosjTable1;
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal, BeanCadastroPessoas beanCadastroPessoas, BeanEnderecoPessoa beanEnderecoPessoa ){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        this.beanCadastroPessoas = beanCadastroPessoas;
        this.beanEnderecoPessoa = beanEnderecoPessoa;
        telaCadastroPessoas  = new TelaCadastroPessoas(this,beanCadastroPessoas, beanEnderecoPessoa);
        telaCadastroPessoas.exibirDadosDoCadastrado();
        telaCadastroPessoas.setVisible(true);
        //preencher lista tipos de logradouro
        preencherComboBox1();
        telaCadastroPessoas.preencherComboBox1(listaTiposDeLogradouro);
        //preencher lista Cidades
        preencherComboBox2();
        telaCadastroPessoas.preencherComboBox2(listaCidades);
        telaCadastroPessoas.preencherJtable1d(selecionarEnderecos());
        
        
        telaCadastroPessoas.mostrarFotografiaInicialmente();
        
    }
    
    public void abrirNovaConsultaCadastroPessoas(){
        controlePrincipal.abrirConsultaCadastroPessoas();
    }
    
    // Aba Fotografia
    public boolean inserirFotografia(){  
        
        String caminho = navegarPorImagem().toString();
        
        boolean executou = false;
        try{
            File imagemFile = new File(caminho);
            byte[] imagemArray = new byte[(int) imagemFile.length()];
            DataInputStream imagemStream = new DataInputStream(new FileInputStream(imagemFile));
            imagemStream.readFully(imagemArray);
            imagemStream.close();
            executou = daoCadastroPessoas.inserirFotografia(imagemArray, beanCadastroPessoas);
        }catch(Exception e){executou = false; JOptionPane.showMessageDialog(null, e.getMessage());}
    
    return executou;
    }
    
    public boolean excluirFotografia(){
        boolean executou = false;
        boolean acaoValida = true;
        
        String confirmacao1 = JOptionPane.showInputDialog("Caso queira excluir a fotografia, digite 1");
        String confirmacao3 = JOptionPane.showInputDialog("Se realmente deseja excluir a fotografia, digite 3");
        
        if((!confirmacao1.equalsIgnoreCase("1"))  || (!confirmacao3.equalsIgnoreCase("3"))  ){ acaoValida = false; JOptionPane.showMessageDialog(null, "Você não confirmou a exclusão.");}
        
        if(acaoValida==true){
            executou = daoCadastroPessoas.excluirFotografia(beanCadastroPessoas);
        }
    return executou;    
    }
    
    public void mostrarFotografiaTelaCadastroPessoas(){
        telaCadastroPessoas.mostrarFotografia();
    }
    
    public File navegarPorImagem(){
        JFileChooser fileChooser = new JFileChooser();
        int answer = fileChooser.showOpenDialog(null);
    
        return fileChooser.getSelectedFile();
    }
    
    public ImageIcon buscarFotografia(){
    
        Image newimg = null;
        
        Image imagem = daoCadastroPessoas.getFotoSeqPessoa(beanCadastroPessoas.getSeqPessoa());
            BufferedImage bufferedImage = null;
                
        try {
            if(imagem!=null){
            bufferedImage = utilidadesDistintas.toBufferedImage(imagem) ;
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
                if(bufferedImage!=null){
                    // recalculando tamanho da imagem
                    newimg = bufferedImage.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); 
                }
    
    return new ImageIcon(newimg);
    }
    
    
    // Aba Enderecos
    public  BeanWebServiceCep buscarDadosEnderecoPorCepWebServiceCep(String cep) {
                boolean acaoValida = true;
                if(cep.length()!=8){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve digitar um CEP com oito caracteres.");}
        
                BeanWebServiceCep beanWebServiceCep = new BeanWebServiceCep();
                WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
                
                if(acaoValida==true){
                    if (webServiceCep.wasSuccessful()) {
                            beanWebServiceCep.setTipoLogradouro(webServiceCep.getLogradouroType()); 
                            beanWebServiceCep.setLogradouro(webServiceCep.getLogradouro()); 
                            beanWebServiceCep.setBairro(webServiceCep.getBairro());                        
                            beanWebServiceCep.setCidade(webServiceCep.getCidade());
                            beanWebServiceCep.setSiglaEstado(webServiceCep.getUf());
                            
                            //Ajustando Textos
                            if(beanWebServiceCep.getTipoLogradouro()!=null){beanWebServiceCep.setTipoLogradouro( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo( beanWebServiceCep.getTipoLogradouro() ) );}
                            if(beanWebServiceCep.getLogradouro()!=null){beanWebServiceCep.setLogradouro( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo( beanWebServiceCep.getLogradouro() ) );}
                            if(beanWebServiceCep.getBairro()!=null){beanWebServiceCep.setBairro( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo( beanWebServiceCep.getBairro() ) );}
                            if(beanWebServiceCep.getCidade()!=null){beanWebServiceCep.setCidade( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo( beanWebServiceCep.getCidade() ) );}
                            if(beanWebServiceCep.getSiglaEstado()!=null){beanWebServiceCep.setSiglaEstado( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo( beanWebServiceCep.getSiglaEstado() ) );}
                            
                            
                            this.beanWebServiceCep = beanWebServiceCep;
                    } else {
                             JOptionPane.showMessageDialog(null, webServiceCep.getResultText());
                    }
                }       
	return beanWebServiceCep;		
	}

    public void preencherComboBox1(){
        this.listaTiposDeLogradouro =daoCadastroPessoas.selecionarTiposDeLogradouro();
    }
    
    public void preencherComboBox2(){
        this.listaCidades =daoCadastroPessoas.selecionarCidades();
    }
    
    public List<BeanEnderecoPessoa> selecionarEnderecos(){
        List dados =daoCadastroPessoas.selecionarEndereco(this.beanCadastroPessoas.getSeqPessoa());
        listaDadosjTable1 = dados;
        selecionarEnderecoParaPessoa();
        return dados;
    }
    
    public void selecionarEnderecoParaPessoa(){
        BeanEnderecoPessoa beanEnderecoPessoa = new BeanEnderecoPessoa();
        if(!this.listaDadosjTable1.isEmpty()){
           beanEnderecoPessoa.setEnderecoBairro(this.listaDadosjTable1.get(0).getEnderecoBairro());
           beanEnderecoPessoa.setEnderecoCep(this.listaDadosjTable1.get(0).getEnderecoCep());
           beanEnderecoPessoa.setEnderecoComplemento(this.listaDadosjTable1.get(0).getEnderecoComplemento());
           beanEnderecoPessoa.setEnderecoLogradouro(this.listaDadosjTable1.get(0).getEnderecoLogradouro());
           beanEnderecoPessoa.setEnderecoNumero(this.listaDadosjTable1.get(0).getEnderecoNumero());
           beanEnderecoPessoa.setNomeCidade(this.listaDadosjTable1.get(0).getNomeCidade());
           beanEnderecoPessoa.setNomePais(this.listaDadosjTable1.get(0).getNomePais());
           beanEnderecoPessoa.setNomeTipoLogradouro(this.listaDadosjTable1.get(0).getNomeTipoLogradouro());
           beanEnderecoPessoa.setSeqEndereco(this.listaDadosjTable1.get(0).getSeqEndereco());
           beanEnderecoPessoa.setSeqEnderecoCidade(this.listaDadosjTable1.get(0).getSeqEnderecoCidade());
           beanEnderecoPessoa.setSeqPais(this.listaDadosjTable1.get(0).getSeqPais());
           beanEnderecoPessoa.setSeqPessoa(this.listaDadosjTable1.get(0).getSeqPessoa());
           beanEnderecoPessoa.setSeqTipoLogradouro(this.listaDadosjTable1.get(0).getSeqTipoLogradouro());
           beanEnderecoPessoa.setSiglaEstado(this.listaDadosjTable1.get(0).getSiglaEstado());
           
        }
        
        this.beanEnderecoPessoa = beanEnderecoPessoa;
        
        
    }
    
    public boolean excluirEnderecoPessoa(){
        boolean executou = false;
        boolean acaoValida = true;
        
        String confirmacao = JOptionPane.showInputDialog(null, "Se estiver certo(a) de que deseja excluir este endereço, tecle 3");
        if(!confirmacao.equalsIgnoreCase("3")){acaoValida = false;}
        
        if(acaoValida==true){
            executou = daoCadastroPessoas.excluirEnderecoPessoa(beanEnderecoPessoa);
        }
        return executou;
    }
    
    
}