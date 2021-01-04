/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCarreiras;
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
public class DaoCadastroCarreiras {

    Connection con = null;
    public boolean inserirCarreira(BeanCadastroCarreiras carreira){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.carreiras (sigla_carreira, nome_carreira, descricao_carreira) values ( ?,?,? )");
                        
            stmt.setString(1, carreira.getSiglaCarreira());
            stmt.setString(2, carreira.getNomeCarreira());
            stmt.setString(3, carreira.getDescricaoCarreira());
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

    public boolean excluirCarreira(BeanCadastroCarreiras carreira){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.carreiras where public.carreiras.seq_carreira = ? ");

                        stmt.setLong(1, carreira.getSeqCarreira());
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

    public boolean alterarCarreira(BeanCadastroCarreiras carreira) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.carreiras set sigla_carreira = ?, nome_carreira = ?, descricao_carreira = ? where public.carreiras.seq_carreira = ? ");

                        stmt.setString(1, carreira.getSiglaCarreira());
                        stmt.setString(2, carreira.getNomeCarreira());
                        stmt.setString(3, carreira.getDescricaoCarreira());
                        stmt.setLong(4, carreira.getSeqCarreira());
                        
                        
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
         

     public List<BeanCadastroCarreiras> selecionarCarreira() {
        List<BeanCadastroCarreiras> listaCarreiras = new ArrayList<BeanCadastroCarreiras>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_carreira, sigla_carreira, nome_carreira, descricao_carreira from public.carreiras order by nome_carreira");

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqCarreira = rs.getLong("seq_carreira");
                   String siglaCarreira = rs.getString("sigla_carreira");
                   String nomeCarreira = rs.getString("nome_carreira");
                   String descicaoCarrreira = rs.getString("descricao_carreira");

                 listaCarreiras.add(new BeanCadastroCarreiras(seqCarreira, siglaCarreira, nomeCarreira, descicaoCarrreira));
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

     return listaCarreiras;

 }
}
