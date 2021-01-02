/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroBancos;
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
public class DaoCadastroBancos {

    Connection con = null;
    public boolean inserirBanco(BeanCadastroBancos banco){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.bancos (codigo_banco, nome_banco, sigla_banco) values ( ?,?,? )");

                        
            stmt.setString(1, banco.getCodigoBanco());
            stmt.setString(2, banco.getNomeBanco());
            stmt.setString(3, banco.getSiglaBanco());
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

    public boolean excluirBanco(BeanCadastroBancos banco){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.bancos where public.bancos.seq_banco = ? ");

                        stmt.setLong(1, banco.getSeqBanco());
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

    public boolean alterarBanco(BeanCadastroBancos banco) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.bancos set codigo_banco = ?, nome_banco = ?, sigla_banco = ?  where public.bancos.seq_banco = ? ");

                        
                        stmt.setString(1, banco.getCodigoBanco());
                        stmt.setString(2, banco.getNomeBanco());
                        stmt.setString(3, banco.getSiglaBanco());
                        stmt.setLong(4, banco.getSeqBanco());
                        
                        
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
         

     public List<BeanCadastroBancos> selecionarBanco() {
        List<BeanCadastroBancos> listaEscolaridade = new ArrayList<BeanCadastroBancos>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_banco, codigo_banco, nome_banco, sigla_banco from public.bancos order by nome_banco");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seq_banco = rs.getLong("seq_banco");
                   String codigo_banco = rs.getString("codigo_banco");
                   String nome_banco = rs.getString("nome_banco");
                   String sigla_banco = rs.getString("sigla_banco");

                 listaEscolaridade.add(new BeanCadastroBancos(seq_banco, codigo_banco, nome_banco, sigla_banco));
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
