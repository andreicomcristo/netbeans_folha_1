/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.folha.dao.parametros.cadastros.cargaHorariaSemanal;

import br.com.folha.model.parametros.cadastros.cargaHorariaSemanal.CargaHorariaSemanal;
import br.com.folha.aconexao.banco.postgres.ConnectionFactory;
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
public class DaoCargaHorariaSemanal {

     Connection con = null;

    public boolean inserirCargaHorariaSemanal(CargaHorariaSemanal cargaHorariaSemanal){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("insert into public.carga_horaria_semanal (carga_horaria, descricao_carga_horaria ) values ( ?,? )");

            stmt.setInt(1, cargaHorariaSemanal.getCarga_horaria());
            stmt.setString(2, cargaHorariaSemanal.getDescricao_carga_horaria());

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
    
    public boolean excluirCargaHorariaSemanal(CargaHorariaSemanal cargaHorariaSemanal){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.carga_horaria_semanal where public.carga_horaria_semanal.seq_carga_horaria_sem = ? ");

                        stmt.setInt(1, cargaHorariaSemanal.getSeq_carga_horaria_sem());

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

    public boolean alterarCargaHorariaSemanal(CargaHorariaSemanal cargaHorariaSemanal){
                boolean executou = false;
		try {
			con = ConnectionFactory.getConnection();
                                                                            // nome da tebela
			PreparedStatement stmt = con.prepareStatement("UPDATE public.carga_horaria_semanal set carga_horaria = ?, descricao_carga_horaria = ?  where public.carga_horaria_semanal.seq_carga_horaria_sem = ? ");

                        stmt.setInt(1, cargaHorariaSemanal.getCarga_horaria());
                        stmt.setString(2, cargaHorariaSemanal.getDescricao_carga_horaria());
                        stmt.setInt(3, cargaHorariaSemanal.getSeq_carga_horaria_sem());

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
         
    public List<CargaHorariaSemanal> selecionarCargaHorariaSemanal() {

        List<CargaHorariaSemanal> listaConsulta = new ArrayList<CargaHorariaSemanal>();

     try {


       con = ConnectionFactory.getConnection();

         try {

             PreparedStatement stmt = con.prepareStatement("select seq_carga_horaria_sem, carga_horaria, descricao_carga_horaria from public.carga_horaria_semanal order by carga_horaria");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   int seq_carga_horaria_sem = rs.getInt("seq_carga_horaria_sem");
                   int carga_horaria = rs.getInt("carga_horaria");
                   String descricao_carga_horaria = rs.getString("descricao_carga_horaria");

                 listaConsulta.add(new CargaHorariaSemanal(seq_carga_horaria_sem, carga_horaria, descricao_carga_horaria));

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
