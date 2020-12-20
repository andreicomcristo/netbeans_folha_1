/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package folha.dao.br.com.parametros.cadastros.ch_semanal;

import folha.model.br.com.parametros.cadastros.ch_semanal.CargaHorariaSemanal;
import folha.aconexao.br.com.banco.postgres.ConnectionFactory;
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
			PreparedStatement stmt = con.prepareStatement("insert into public.CH_SEMANAL (CH, DESCRICAO_CH ) values ( ?,? )");

            stmt.setInt(1, cargaHorariaSemanal.getCH());
            stmt.setString(2, cargaHorariaSemanal.getDESCRICAO_CH());

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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM public.CH_SEMANAL where public.CH_SEMANAL.CH = ? ");

                        stmt.setInt(1, cargaHorariaSemanal.getSEQ_CH_SEMANAL());

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
			PreparedStatement stmt = con.prepareStatement("UPDATE public.CH_SEMANAL set CH = ?, DESCRICAO_CH = ?  where public.CH_SEMANAL.SEQ_CH_SEMANAL = ? ");

                        stmt.setInt(1, cargaHorariaSemanal.getCH());
                        stmt.setString(2, cargaHorariaSemanal.getDESCRICAO_CH());
                        stmt.setInt(3, cargaHorariaSemanal.getSEQ_CH_SEMANAL());

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

             PreparedStatement stmt = con.prepareStatement("select SEQ_CH_SEMANAL, CH, DESCRICAO_CH from public.CH_SEMANAL order by CH");

              

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

                   int SEQ_CH_SEMANAL = rs.getInt("SEQ_CH_SEMANAL");
                   int CH = rs.getInt("CH");
                   String DESCRICAO_CH = rs.getString("DESCRICAO_CH");

                 listaConsulta.add(new CargaHorariaSemanal(SEQ_CH_SEMANAL, CH, DESCRICAO_CH));

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
