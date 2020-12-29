/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
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
public class DaoCadastroCidades {

    Connection con = null;
    public boolean inserirCidade(BeanCadastroCidades cidade){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.cidades (nome_cidade, sigla_estado) values ( ?,? )");

                        
            stmt.setString(1, cidade.getNomeCidade());
            stmt.setString(2, cidade.getSiglaEstado());

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

    public boolean excluirCidade(BeanCadastroCidades cidade){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.cidades where public.cidades.seq_cidade = ? ");

                        stmt.setLong(1, cidade.getSeqCidade());
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

    public boolean alterarCidade(BeanCadastroCidades cidade) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.cidades set nome_cidade = ?, sigla_estado = ?  where public.cidades.seq_cidade = ? ");

                        
                        stmt.setString(1, cidade.getNomeCidade());
                        stmt.setString(2, cidade.getSiglaEstado());
                        stmt.setLong(3, cidade.getSeqCidade());
                        
                        
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
         

     public List<BeanCadastroCidades> selecionarCidade() {
        List<BeanCadastroCidades> listaConsulta = new ArrayList<BeanCadastroCidades>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_cidade, nome_cidade, sigla_cidade from public.cidades order by nome_cidade");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqCidade = rs.getLong("seq_cidade");
                   String nomeCidada = rs.getString("nome_cidade");
                   String siglaCidade = rs.getString("Sigla_cidade");

                 listaConsulta.add(new BeanCadastroCidades(seqCidade, nomeCidada, siglaCidade));

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


}
