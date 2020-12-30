/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroSexos;
import br.com.folha.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André
 */
public class DaoCadastroSexos {

    Connection con = null;
    public boolean inserirSexo(BeanCadastroSexos sexo){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.sexos (nome_sexo, descricao_sexo) values ( ?,? )");

                        
            stmt.setString(1, sexo.getNomeSexo());
            stmt.setString(2, sexo.getDescricaoSexo());
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

    public boolean excluirSexo(BeanCadastroSexos sexo){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.sexos where public.sexos.seq_sexo = ? ");

                        stmt.setLong(1, sexo.getSeqSexo());
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

    public boolean alterarSexo(BeanCadastroSexos sexo) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.sexos set nome_sexo = ?, descricao_sexo = ?  where public.sexo.seq_sexos = ? ");

                        
                        stmt.setString(1, sexo.getNomeSexo());
                        stmt.setString(2, sexo.getDescricaoSexo());
                        stmt.setLong(3, sexo.getSeqSexo());
                        
                        
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
         

     public List<BeanCadastroSexos> selecionarSexo() {
         
        List<BeanCadastroSexos> listaSexo = new ArrayList<BeanCadastroSexos>();

     try {

       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_sexo, nome_sexo, descricao_sexo from public.sexos order by nome_sexo");
              
             ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                   long seqSexo = rs.getLong("seq_sexo");
                   String nomesSexo = rs.getString("nome_sexo");
                   String descricaoSexo = rs.getString("descricao_sexo");

                 listaSexo.add(new BeanCadastroSexos(seqSexo, nomesSexo, descricaoSexo));
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

     return listaSexo;

 }
}
