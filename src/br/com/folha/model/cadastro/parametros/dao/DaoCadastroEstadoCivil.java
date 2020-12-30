/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.model.cadastro.parametros.dao;

import br.com.folha.model.cadastro.parametros.bean.BeanCadastroCidades;
import br.com.folha.model.cadastro.parametros.bean.BeanCadastroEstadoCivel;
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
public class DaoCadastroEstadoCivil { 

    Connection con = null;
    public boolean inserirEstadoCivil(BeanCadastroEstadoCivel estadoCivil){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.estados_civis (nome_estado_civil, descricao_estado_civil) values ( ?,? )");

                        
            stmt.setString(1, estadoCivil.getNomeEstadoCivil());
            stmt.setString(2, estadoCivil.getDescricaoEstadoCivil());

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

    public boolean excluirEstadoCivil(BeanCadastroEstadoCivel estadoCivil){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.estados_civis where public.estados_civis.seq_estado_civil = ? ");

                        stmt.setLong(1, estadoCivil.getSeqEstadoCivil());
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

    public boolean alterarEstadoCivil(BeanCadastroEstadoCivel EstadoCivil) {
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.estados_civis set nome_estado_civil = ?, descricao_estado_civil = ?  where public.estados_civis.seq_estado_civil = ? ");

                        
                        stmt.setString(1, EstadoCivil.getNomeEstadoCivil());
                        stmt.setString(2, EstadoCivil.getDescricaoEstadoCivil());
                        stmt.setLong(3, EstadoCivil.getSeqEstadoCivil());
                        
                        
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
         

     public List<BeanCadastroEstadoCivel> selecionarEstadoCivil() {
        List<BeanCadastroEstadoCivel> listaConsulta = new ArrayList<BeanCadastroEstadoCivel>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_estado_civil, nome_estado_civil, descricao_estado_civil from public.estados_civis order by nome_estado_civil");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   long seqEstadoCivil = rs.getLong("seq_estado_civil");
                   String nomeEstadoivil = rs.getString("nome_estado_civil");
                   String descricaoEstadoCivil = rs.getString("descricao_estado_civil");

                 listaConsulta.add(new BeanCadastroEstadoCivel(seqEstadoCivil, nomeEstadoivil, descricaoEstadoCivil));
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
