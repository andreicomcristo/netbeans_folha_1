/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCargaHorariaSemanal;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroVinculos;
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
 * @author andrei
 */
public class DaoCadastroVinculos {

     Connection con = null;
    public boolean inserirVinculo(BeanCadastroVinculos vinculo){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.vinculos (nome_vinculo, descricao_vinculo) values ( ?,? )");

                        
            stmt.setString(1, vinculo.getNomeVinculo());
            stmt.setString(2, vinculo.getDescricaoVinculo());

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

    public boolean excluirVinculo(BeanCadastroVinculos vinculo){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.vinculos where public.vinculos.seq_vinculo = ? ");

                        stmt.setLong(1, vinculo.getSeqVinculo());
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

    public boolean alterarVinculo(BeanCadastroVinculos vinculo) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.vinculos set nome_vinculo = ?, descricao_vinculo = ?  where public.vinculos.seq_vinculo = ? ");

                        
                        stmt.setString(1, vinculo.getNomeVinculo());
                        stmt.setString(2, vinculo.getDescricaoVinculo());
                        stmt.setLong(3, vinculo.getSeqVinculo());
                        
                        System.out.println(vinculo.getNomeVinculo());
                        System.out.println(vinculo.getDescricaoVinculo());
                        System.out.println(vinculo.getSeqVinculo());
                        
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
         

     public List<BeanCadastroVinculos> selecionarVinculo() {
        List<BeanCadastroVinculos> listaConsulta = new ArrayList<BeanCadastroVinculos>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_vinculo, nome_vinculo, descricao_vinculo from public.vinculos order by nome_vinculo");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqVinculo = rs.getLong("seq_vinculo");
                   String nomeVinculo = rs.getString("nome_vinculo");
                   String descricaoVinculo = rs.getString("descricao_vinculo");

                 listaConsulta.add(new BeanCadastroVinculos(seqVinculo, nomeVinculo, descricaoVinculo));

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
