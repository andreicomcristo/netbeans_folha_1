/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.control.cadastro.pessoas;


import br.com.folha.control.principal.ControlePrincipal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.pessoas.bean.BeanCadastroPessoas;
import br.com.folha.model.cadastro.pessoas.dao.DaoCadastroPessoas;
import br.com.folha.model.principal.bean.BeanPrincipal;
import br.com.folha.util.UtilidadesDeTexto;
import br.com.folha.util.UtilidadesDistintas;
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
    
    public boolean inserirFotografia(){  
        
        String caminho = navegarPorImagem().toString();
        
        boolean executou = false;
        try{
            File imagemFile = new File(caminho);
            byte[] imagemArray = new byte[(int) imagemFile.length()];
            DataInputStream imagemStream = new DataInputStream(
            new FileInputStream(imagemFile));
            imagemStream.readFully(imagemArray);
            imagemStream.close();
            executou = daoCadastroPessoas.inserirFotografia(imagemArray, beanCadastroPessoas);
        }catch(Exception e){executou = false; JOptionPane.showMessageDialog(null, e.getMessage());}
    
    return executou;
    }
    
    public boolean excluirFotografia(){
        boolean executou = daoCadastroPessoas.excluirFotografia(beanCadastroPessoas);
    return executou;    
    }
    
    
    
    /*
    public boolean inserirFotografia(){
        boolean executou = false;
        boolean acaoValida = true;
        
        try {
            
            
            String arquivo = navegarPorImagem().getAbsolutePath();
            // conferindo se o arquivo é válido
            if(arquivo.length()<4){acaoValida = false; JOptionPane.showMessageDialog(null, "Escolha uma imágem válida.");}else{if(!arquivo.substring(arquivo.length()-4, arquivo.length()).equalsIgnoreCase(".JPG")){acaoValida = false; JOptionPane.showMessageDialog(null, "Escolha uma imágem válida.");}}
            BufferedImage originalImage = ImageIO.read(new File(arquivo));
        
            ByteArrayOutputStream os2 = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", os2);
            InputStream imagemReferencia = new ByteArrayInputStream(os2.toByteArray());  
            if(acaoValida==true){
                executou = daoCadastroPessoas.inserirFotografia(imagemReferencia, beanCadastroPessoas);
            }
            
            
        
        } catch (IOException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
        
        return executou;
        
        
    }
    */
    
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
    
    
    /*
    public boolean cadastrar(String nomeCidade, String siglaEstado, int indice){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeCidade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCidade);
        siglaEstado = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaEstado);
        
        //conferindo se os campos obrigatórios foram preenchidos
        if(indice == 0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher um´país válido.");}
        if(nomeCidade.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma cidade válida.");}
        
        if(acaoValida==true){
            beanCadastroCidades.setSeqCidade(0);
            beanCadastroCidades.setNomeCidade(nomeCidade);
            beanCadastroCidades.setSiglaEstado(siglaEstado);
            beanCadastroCidades.setSeqPais(listaPaises.get(indice-1).getSequencia());
            executou = daoCidades.inserirCidade(beanCadastroCidades);
            telaCadastroCidades.preencherJtable1d(this.selecionar(beanCadastroCidades.getNomeCidade()));
        }
        return executou;
    }
    
    public boolean excluir(int linhajTable1){
        boolean executou = false;
        boolean acaoValida = true;
        
        if(acaoValida==true){
            beanCadastroCidades.setSeqCidade(listaDadosjTable1.get(linhajTable1).getSeqCidade());
            beanCadastroCidades.setNomeCidade("");
            beanCadastroCidades.setSiglaEstado("");
            executou =daoCidades.excluirCidade(beanCadastroCidades);
            
            telaCadastroCidades.preencherJtable1d(this.selecionar(""));
        }
        return executou;
    }
    
    public boolean alterar(int linhajTable1, String nomeCidade, String siglaEstado, int indiceCombo1){
        boolean executou = false;
        boolean acaoValida = true;
        // ARRUMANDO OS TEXTOS
        nomeCidade = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCidade);
        siglaEstado = utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaEstado);
                
        //conferindo se os campos obrigatórios foram preenchidos
        if(indiceCombo1 == 0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escolher um´país válido.");}
        if(nomeCidade.length()==0){acaoValida = false; JOptionPane.showMessageDialog(null, "Você deve escrever uma cidade válida.");}
        
        if (acaoValida){
            beanCadastroCidades.setSeqCidade(this.listaDadosjTable1.get(linhajTable1).getSeqCidade());
            beanCadastroCidades.setNomeCidade(nomeCidade);
            beanCadastroCidades.setSiglaEstado(siglaEstado);
            beanCadastroCidades.setSeqPais(listaPaises.get(indiceCombo1-1).getSequencia());
                        
            executou =daoCidades.alterarCidade(beanCadastroCidades);
            
            //cadastroCargaHorariaSemanal.preencherJtable1d(this.selecionar());
            telaCadastroCidades.preencherJtable1d(this.selecionar(beanCadastroCidades.getNomeCidade()));
        }
            return executou;
    }
    
    public List<BeanCadastroCidades> selecionar(String consulta){
        List dados =daoCidades.selecionarCidade(consulta);
        listaDadosjTable1 = dados;
        return dados;
    }
    
    
    public void preencherComboBox(){
        this.listaPaises =daoCidades.selecionarPaises();
    }
    
    
    
    */
    
    
}