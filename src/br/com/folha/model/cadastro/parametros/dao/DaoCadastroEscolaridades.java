/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroEscolaridades;
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
public class DaoCadastroEscolaridades {

    Connection con = null;
    public boolean inserirEscolaridade(BeanCadastroEscolaridades escolaridade){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.escolaridades (nome_escolaridade, descricao_escolaridade) values ( ?,? )");

                        
            stmt.setString(1, escolaridade.getNomeEscolaridade());
            stmt.setString(2, escolaridade.getDescricaoEscolaridade());
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

    public boolean excluirEscolaridade(BeanCadastroEscolaridades escolaridade){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.escolaridades where public.escolaridades.seq_escolaridade = ? ");

                        stmt.setLong(1, escolaridade.getSeqEscolaridade());
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

    public boolean alterarEscolaridade(BeanCadastroEscolaridades escolaridade) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.escolaridades set nome_escolaridade = ?, descricao_escolaridade = ?  where public.escolaridades.seq_escolaridade = ? ");

                        
                        stmt.setString(1, escolaridade.getNomeEscolaridade());
                        stmt.setString(2, escolaridade.getDescricaoEscolaridade());
                        stmt.setLong(3, escolaridade.getSeqEscolaridade());
                        
                        
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
         

     public List<BeanCadastroEscolaridades> selecionarEscolaridade() {
        List<BeanCadastroEscolaridades> listaEscolaridade = new ArrayList<BeanCadastroEscolaridades>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_escolaridade, nome_escolaridade, descricao_escolaridade from public.escolaridades order by nome_escolaridade");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqEscolaridade = rs.getLong("seq_escolaridade");
                   String nomeEscolaridade = rs.getString("nome_escolaridade");
                   String descricaoEscolaridade = rs.getString("descricao_escolaridade");

                 listaEscolaridade.add(new BeanCadastroEscolaridades(seqEscolaridade, nomeEscolaridade, descricaoEscolaridade));
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

     return listaEscolaridade;

 }
}
