    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.pessoas.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.pessoas.bean.BeanCadastroPessoas;
import br.com.folha.model.cadastro.pessoas.bean.BeanEnderecoPessoa;
import br.com.folha.util.ConnectionFactory;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author André
 */
public class DaoCadastroPessoas {

    Connection con = null;
    

    public boolean excluirFotografia(BeanCadastroPessoas beanCadastroPessoas){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.pessoa_fotos where public.pessoa_fotos.seq_pessoa = ? ");

                        stmt.setLong(1, beanCadastroPessoas.getSeqPessoa());
			stmt.execute();
			stmt.close();

			con.close();
                        executou = true;

		} catch (Exception e) {
                    executou = false;
                    JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} finally{

			try{
				con.close();

			}catch (SQLException e){JOptionPane.showMessageDialog(null, e.getMessage());
			}
                }
    return executou;    
    }
 
    // Inserinfo Foto no Banco 
    public boolean inserirFotografia(byte[] imagemArray, BeanCadastroPessoas beanCadastroPessoas){
        
                boolean executou = true;
		try {

			con = ConnectionFactory.getConnection();

                        
                            if(true){
                                                                                   // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.pessoa_fotos (seq_pessoa, fotografia) values (?,?)");

            stmt.setLong(1,beanCadastroPessoas.getSeqPessoa());  
            stmt.setBytes(2, imagemArray);
            
            //stmt.setBinaryStream(2,imagemReferencia, 1000000);
            
            
            
			stmt.execute();
			stmt.close();
                            }
                
                        
			con.close();

                        executou = true;
                        
		} catch (Exception e) {executou = false; JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} finally{

			try{
				con.close();

			}catch (SQLException e){JOptionPane.showMessageDialog(null, e.getMessage());
			}
                }
    return executou;    
    } 
     
     // Pegando foto do Banco
    public Image  getFotoSeqPessoa(Long seq_pessoa) {

       byte[] imgData = null;
       ImageIcon icon = new ImageIcon();

     try {

       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select fotografia from public.pessoa_fotos where seq_pessoa = ? and seq_pessoa_foto = (select max (seq_pessoa_foto) from public.pessoa_fotos where seq_pessoa = ? and fotografia is not null)");
             
             stmt.setLong(1, seq_pessoa);
             stmt.setLong(2, seq_pessoa);

             
             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   imgData = rs.getBytes("fotografia");
                   icon = new ImageIcon(imgData);
		   
             }

         } finally {
             try {
                 con.close();
             } catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());
                 e.printStackTrace();
             }
         }
     } catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());
         e.printStackTrace();
     }

     return icon.getImage();

 }
    
    // Pegando Tipos de logradouro
    public List<BeanSequenciaTexto> selecionarTiposDeLogradouro() {
        List<BeanSequenciaTexto> listaConsulta = new ArrayList<BeanSequenciaTexto>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select distinct seq_tipo_logradouro, nome_tipo_logradouro from public.tipos_logradouro order by nome_tipo_logradouro");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long sequencia = rs.getLong("seq_tipo_logradouro");
                   String texto = rs.getString("nome_tipo_logradouro");
                   

                 listaConsulta.add(new BeanSequenciaTexto(sequencia, texto));

             }

         } finally {
             try {
                 con.close();
             } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());
                 e.printStackTrace();
             }
         }
     } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());
         e.printStackTrace();
     }

     return listaConsulta;

 }
    
    public List<BeanCadastroCidades> selecionarCidades() {
        List<BeanCadastroCidades> listaConsulta = new ArrayList<BeanCadastroCidades>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_cidade, nome_cidade, sigla_estado, cidades.seq_pais, nome_pais from public.cidades inner join public.paises on public.cidades.seq_pais = public.paises.seq_pais order by nome_cidade, sigla_estado, nome_pais ");

             

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqCidade = rs.getLong("seq_cidade");
                   String nomeCidada = rs.getString("nome_cidade");
                   String siglaCidade = rs.getString("Sigla_estado");
                   long seqPais = rs.getLong("seq_Pais");
                   String nomePais = rs.getString("nome_Pais");

                 listaConsulta.add(new BeanCadastroCidades(seqCidade, nomeCidada, siglaCidade, seqPais, nomePais));

             }

         } finally {
             try {
                 con.close();
             } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());
                 e.printStackTrace();
             }
         }
     } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());
         e.printStackTrace();
     }

     return listaConsulta;

 }

    public List<BeanEnderecoPessoa> selecionarEndereco(Long sequencia) {
        List<BeanEnderecoPessoa> listaConsulta = new ArrayList<BeanEnderecoPessoa>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select pessoa.seq_pessoa, enderecos.seq_endereco, enderecos.seq_tipo_logradouro, tipos_logradouro.nome_tipo_logradouro, enderecos.endereco_logradouro, enderecos.endereco_numero, enderecos.endereco_complemento, enderecos.endereco_bairro, enderecos.endereco_cep, cidades.seq_cidade, cidades.nome_cidade, cidades.sigla_estado, paises.seq_pais, paises.nome_pais from public.pessoa inner join public.enderecos on public.enderecos.seq_endereco = public.pessoa.seq_endereco inner join public.tipos_logradouro on public.enderecos.seq_tipo_logradouro = public.tipos_logradouro.seq_tipo_logradouro inner join public.cidades on public.cidades.seq_cidade= public.enderecos.seq_endereco_cidade inner join public.paises on public.paises.seq_pais = public.cidades.seq_pais where public.pessoa.seq_pessoa = ? and public.pessoa.dt_cancelamento is null");

              stmt.setLong(1, sequencia);

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                 
                long seqPessoa = rs.getLong("seq_pessoa");
                long seqEndereco = rs.getLong("seq_endereco");
                long seqTipoLogradouro = rs.getLong("seq_tipo_logradouro");
                String nomeTipoLogradouro = rs.getString("nome_tipo_logradouro");
                String enderecoLogradouro = rs.getString("endereco_logradouro");
                String enderecoNumero = rs.getString("endereco_numero");
                String enderecoComplemento = rs.getString("endereco_complemento");
                String enderecoBairro = rs.getString("endereco_bairro");
                String enderecoCep = rs.getString("endereco_cep");
                long seqEnderecoCidade = rs.getLong("seq_cidade");
                String nomeCidade = rs.getString("nome_cidade");
                String siglaEstado = rs.getString("sigla_estado");
                long seqPais = rs.getLong("seq_pais");
                String nomePais = rs.getString("nome_pais");
                 
                   
                listaConsulta.add(new BeanEnderecoPessoa(seqPessoa, seqEndereco, seqTipoLogradouro, nomeTipoLogradouro, enderecoLogradouro, enderecoNumero, enderecoComplemento, enderecoBairro, enderecoCep, seqEnderecoCidade, nomeCidade, siglaEstado, seqPais, nomePais));

             }

         } finally {
             try {
                 con.close();
             } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());
                 e.printStackTrace();
             }
         }
     } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());
         e.printStackTrace();
     }

     return listaConsulta;

 }
    
    public boolean excluirEnderecoPessoa(BeanEnderecoPessoa beanEnderecoPessoa){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.enderecos where public.enderecos.seq_endereco = ? ");

                        stmt.setLong(1, beanEnderecoPessoa.getSeqEndereco());
			stmt.execute();
			stmt.close();

			con.close();
                        executou = true;

		} catch (Exception e) {
                    executou = false;
                    JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} finally{

			try{
				con.close();

			}catch (SQLException e){JOptionPane.showMessageDialog(null, e.getMessage());
			}
                }
    return executou;    
    }
    
}
