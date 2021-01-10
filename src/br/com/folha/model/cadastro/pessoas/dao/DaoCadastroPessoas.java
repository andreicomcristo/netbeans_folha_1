    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.pessoas.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanSequenciaTexto;
import br.com.folha.model.cadastro.pessoas.bean.BeanCadastroPessoas;
import br.com.folha.util.ConnectionFactory;
import java.awt.Image;
import java.io.InputStream;
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

}
