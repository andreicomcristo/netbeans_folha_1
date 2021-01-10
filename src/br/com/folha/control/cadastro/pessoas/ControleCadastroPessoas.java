/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.pessoas;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.pessoas.bean.BeanCadastroPessoas;
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
    
    BeanWebServiceCep beanWebServiceCep = new BeanWebServiceCep();
    
    
    DaoCadastroPessoas daoCadastroPessoas = new DaoCadastroPessoas();
    UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
    UtilidadesDistintas utilidadesDistintas = new UtilidadesDistintas();
    
    // para colocar os paises no combo
    List<BeanSequenciaTexto> listaPaises;
    
    // para colocar os dados cadastrados na tabela1
    List<BeanCadastroCidades> listaDadosjTable1;
    
    public void abrirFrame(ControlePrincipal controlePrincipal, BeanPrincipal beanPrincipal, BeanCadastroPessoas beanCadastroPessoas){
        
        this.controlePrincipal = controlePrincipal;
        this.beanPrincipal = beanPrincipal;
        this.beanCadastroPessoas = beanCadastroPessoas;
        telaCadastroPessoas  = new TelaCadastroPessoas(this,beanCadastroPessoas);
        telaCadastroPessoas.exibirDadosDoCadastrado();
        telaCadastroPessoas.setVisible(true);
        telaCadastroPessoas.mostrarFotografiaInicialmente();
    }
    
    public void abrirNovaConsultaCadastroPessoas(){
        controlePrincipal.abrirConsultaCadastroPessoas();
    }
    
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

    
    
    
}